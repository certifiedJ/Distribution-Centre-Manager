package com.cpan228.distribution.controller;

import com.cpan228.distribution.data.DistributionCentreItemRepository;
import com.cpan228.distribution.data.ItemRepository;
import com.cpan228.distribution.dto.ItemAvailabilityDTO;
import com.cpan228.distribution.model.DistributionCentreItems;
import com.cpan228.distribution.model.Items;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final DistributionCentreItemRepository dciRepository;
    private final ItemRepository itemRepository;

    public ItemController(DistributionCentreItemRepository dciRepository, ItemRepository itemRepository) {
        this.dciRepository = dciRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/search")
    public ResponseEntity<List<ItemAvailabilityDTO>> searchItemsByBrandAndName(
            @RequestParam String brand,
            @RequestParam String name) {
        // Fetch matching items from the repository
        List<DistributionCentreItems> results = dciRepository.findByItemBrandAndNameContaining(brand, name);

        // If no results, return 204 No Content
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Map results to DTOs
        List<ItemAvailabilityDTO> dtos = results.stream()
                .map(dci -> new ItemAvailabilityDTO(
                        dci.getItem().getBrand(),
                        dci.getItem().getName(),
                        dci.getDistributionCentre().getName(),
                        dci.getQuantity()
                ))
                .collect(Collectors.toList());

        // Return 200 OK with the list
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> results = itemRepository.findAll();
        return ResponseEntity.ok(results);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Items item) {
        itemRepository.save(item);
        return ResponseEntity.noContent().build();
    }
}