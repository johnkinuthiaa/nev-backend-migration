package com.slippery.nevmigration.repository;

import com.slippery.nevmigration.model.AppliancesIncluded;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceRepository extends JpaRepository<AppliancesIncluded,Long> {
}
