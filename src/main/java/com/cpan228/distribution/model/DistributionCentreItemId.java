package com.cpan228.distribution.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class DistributionCentreItemId implements Serializable {
    // Getters and setters
    private Long distributionCentre; // Matches the entity field name
    private Long item;              // Matches the entity field name

    // Default constructor
    public DistributionCentreItemId() {}

    // Parameterized constructor
    public DistributionCentreItemId(Long distributionCentre, Long item) {
        this.distributionCentre = distributionCentre;
        this.item = item;
    }

    // Override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistributionCentreItemId that = (DistributionCentreItemId) o;
        return Objects.equals(distributionCentre, that.distributionCentre) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributionCentre, item);
    }
}