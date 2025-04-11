package com.cpan228.distribution.data;

import com.cpan228.distribution.model.DistributionCentreItemId;
import com.cpan228.distribution.model.DistributionCentreItems;
import com.cpan228.distribution.model.DistributionCentres;
import com.cpan228.distribution.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistributionCentreItemRepository extends JpaRepository<DistributionCentreItems, DistributionCentreItemId> {
    // Find the association by distribution centre ID and item ID
    Optional<DistributionCentreItems> findByDistributionCentreAndItem(DistributionCentres centre, Items item);

    // Delete the association by distribution centre ID and item ID
    void deleteByDistributionCentre_IdAndItem_Id(Long centreId, Long itemId);
}