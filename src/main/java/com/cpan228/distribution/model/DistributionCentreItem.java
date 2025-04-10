package com.cpan228.distribution.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DistributionCentreItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "distribution_centre_id")
    private DistributionCentre distributionCentre;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items item;

    private int quantity;
}