package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.ReqRes;

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
    ReqRes updateListing(ReqRes listingInfo);
    ReqRes createListing(ReqRes listingInfo);
    ReqRes deleteListing(Long id);
    ReqRes deleteAllListings();
}
