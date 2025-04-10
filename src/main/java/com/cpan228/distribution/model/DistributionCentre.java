package com.cpan228.distribution.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DistributionCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double latitude;
    private double longitude;
}