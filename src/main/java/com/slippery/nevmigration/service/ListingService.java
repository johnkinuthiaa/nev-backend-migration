package com.slippery.nevmigration.service;

import com.slippery.nevmigration.dto.ReqRes;
import com.slippery.nevmigration.model.Listing;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ListingService {
    ReqRes getAllListings();

    ReqRes getListingByLocation(String location);

    ReqRes getListingById(Long id);

    ReqRes getListingByParking(Boolean hasParking);

    ReqRes getListingByBedrooms(Long bedrooms);

    ReqRes getListingByBathrooms(Long bathrooms);

    ReqRes getListingByType(String type);

    ReqRes getListingByFurnished(Boolean isFurnished);

    ReqRes getListingByPrice(Double price);

    ReqRes updateListing(Listing listingInfo, Long userId, Long listingId);

    ReqRes createListing(ReqRes listingInfo, Long id);
    ReqRes advancedSearch(ReqRes searchParams);
//    Listing createListing(Listing listingInfo, Long id);

    ReqRes deleteListing(Long id,Long userId);

    ReqRes deleteAllListings(Long id);
}