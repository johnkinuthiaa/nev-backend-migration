package com.nev.nevbackendmigration.repository;

import com.nev.nevbackendmigration.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing,Long> {
    Optional<Listing> getListingByName(String name);
}
