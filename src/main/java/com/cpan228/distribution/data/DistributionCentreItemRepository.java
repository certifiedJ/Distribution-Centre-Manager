package com.cpan228.distribution.data;

import com.cpan228.distribution.model.DistributionCentreItemId;
import com.cpan228.distribution.model.DistributionCentreItems;
import com.cpan228.distribution.model.DistributionCentres;
import com.cpan228.distribution.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistributionCentreItemRepository extends JpaRepository<DistributionCentreItems, DistributionCentreItemId> {
    // Find the association by distribution centre ID and item ID
    Optional<DistributionCentreItems> findByDistributionCentreAndItem(DistributionCentres centre, Items item);

    // Delete the association by distribution centre ID and item ID
//    void deleteByDistributionCentre_IdAndItem_Id(Long centreId, Long itemId);

    // search item by brand explicitly and name implicitly
    @Query("SELECT dci FROM DistributionCentreItems dci " +
            "JOIN dci.item i " +
            "JOIN dci.distributionCentre dc " +
            "WHERE i.brand = :brand AND LOWER(i.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<DistributionCentreItems> findByItemBrandAndNameContaining(
            @Param("brand") String brand,
            @Param("name") String name
    );
}