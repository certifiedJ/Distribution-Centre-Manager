package com.cpan228.distribution.controller;

import com.cpan228.distribution.data.DistributionCentreItemRepository;
import com.cpan228.distribution.data.DistributionCentreRepository;
import com.cpan228.distribution.data.ItemRepository;
import com.cpan228.distribution.model.DistributionCentres;
import com.cpan228.distribution.model.DistributionCentreItems;
import com.cpan228.distribution.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/distribution-centres/{centreId}/items")
public class DistributionCentreItemController {

    private final DistributionCentreItemRepository dciRepository;
    private final DistributionCentreRepository dcRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public DistributionCentreItemController(DistributionCentreItemRepository dciRepository,
                                            DistributionCentreRepository dcRepository,
                                            ItemRepository itemRepository) {
        this.dciRepository = dciRepository;
        this.dcRepository = dcRepository;
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public ResponseEntity<String> addItemToCentre(@PathVariable Long centreId,
                                                  @RequestParam Long itemId,
                                                  @RequestParam int quantity) {
        // Validate the distribution centre exists
        Optional<DistributionCentres> centreOpt = dcRepository.findById(centreId);
        if (centreOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Distribution centre not found");
        }

        // Validate the item exists
        Optional<Items> itemOpt = itemRepository.findById(itemId);
        if (itemOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item not found");
        }

        DistributionCentres centre = centreOpt.get();
        Items item = itemOpt.get();

        // Check if the item is already associated with the centre
        Optional<DistributionCentreItems> existingAssociation = dciRepository.findByDistributionCentreAndItem(centre, item);
        if (existingAssociation.isPresent()) {
            // Update the existing quantity
            DistributionCentreItems dci = existingAssociation.get();
            dci.setQuantity(dci.getQuantity() + quantity);
            dciRepository.save(dci);
            return ResponseEntity.ok("Quantity updated for existing item in distribution centre");
        } else {
            // Create a new association
            DistributionCentreItems newDci = new DistributionCentreItems(centre, item, quantity);
            dciRepository.save(newDci);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Item added to distribution centre");
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItemFromCentre(@PathVariable Long centreId, @PathVariable Long itemId) {
        // Check if distribution centre exists
        Optional<DistributionCentres> centreOpt = dcRepository.findById(centreId);
        if (centreOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Distribution centre not found");
        }
        DistributionCentres centre = centreOpt.get();

        // Check if item exists
        Optional<Items> itemOpt = itemRepository.findById(itemId);
        if (itemOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
        Items item = itemOpt.get();

        // Check if association exists
        Optional<DistributionCentreItems> associationOpt = dciRepository.findByDistributionCentreAndItem(centre, item);
        if (associationOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found in this distribution centre");
        }

        // Delete the association
        dciRepository.delete(associationOpt.get());
        return ResponseEntity.ok("Item removed from distribution centre");
    }
}