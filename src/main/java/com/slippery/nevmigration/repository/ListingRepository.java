package com.slippery.nevmigration.repository;

import com.slippery.nevmigration.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing,Long> {
    Optional<Listing> findByNameEqualsIgnoreCase(String name);

    List<Listing> findAllByLocationContainingIgnoreCase(String location);

}
