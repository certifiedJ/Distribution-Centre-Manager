package com.cpan228.distribution.controller;

import com.cpan228.distribution.data.DistributionCentreItemRepository;
import com.cpan228.distribution.dto.ItemAvailabilityDTO;
import com.cpan228.distribution.model.DistributionCentreItems;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final DistributionCentreItemRepository dciRepository;

    public ItemController(DistributionCentreItemRepository dciRepository) {
        this.dciRepository = dciRepository;
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
}