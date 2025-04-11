package com.cpan228.distribution.data;

import com.cpan228.distribution.model.DistributionCentres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCentreRepository extends JpaRepository<DistributionCentres, Long> {
}