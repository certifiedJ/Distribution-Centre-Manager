package com.cpan228.distribution.controller;

import com.cpan228.distribution.data.DistributionCentreRepository;
import com.cpan228.distribution.model.DistributionCentres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distribution-centres")
public class DistributionCentreController {

    private final DistributionCentreRepository repository;

    @Autowired
    public DistributionCentreController(DistributionCentreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<DistributionCentres>> listAll() {
        List<DistributionCentres> centres = repository.findAll();
        return ResponseEntity.ok(centres);
    }
}