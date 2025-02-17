package com.slippery.nevmigration.repository;

import com.slippery.nevmigration.model.ImagesForListings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImagesForListings,Long> {
}
