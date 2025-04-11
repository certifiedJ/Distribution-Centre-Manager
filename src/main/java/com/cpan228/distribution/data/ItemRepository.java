package com.cpan228.distribution.data;

import com.cpan228.distribution.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
    Optional<Items> findByName(String name);
    Boolean existsByNameAndBrand(String brand, String name);
}