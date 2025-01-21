package com.slippery.nevmigration.repository;

import com.slippery.nevmigration.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Reviews,Long> {
}
