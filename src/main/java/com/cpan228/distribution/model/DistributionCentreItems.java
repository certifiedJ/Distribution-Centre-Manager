package com.cpan228.distribution.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@IdClass(DistributionCentreItemId.class) // Specify the composite key class
public class DistributionCentreItems {

    @Id // Part of the composite key
    @ManyToOne
    @JoinColumn(name = "distribution_centre_id") // Maps to centre_id in the database
    private DistributionCentres distributionCentre;

    @Id // Part of the composite key
    @ManyToOne
    @JoinColumn(name = "item_id") // Maps to item_id in the database
    private Items item;

    private int quantity;

    // Constructor without id
    public DistributionCentreItems(DistributionCentres distributionCentre, Items item, int quantity) {
        this.distributionCentre = distributionCentre;
        this.item = item;
        this.quantity = quantity;
    }
}