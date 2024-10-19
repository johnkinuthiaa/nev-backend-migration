package com.nev.nevbackendmigration.controller;

import com.nev.nevbackendmigration.dto.ReqRes;
import com.nev.nevbackendmigration.service.ListingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/listings")
public class ListingController {
    private final ListingService service;
    public ListingController(ListingService service){
        this.service=service;
    }
    @GetMapping("/all")
    public ResponseEntity<ReqRes> getAllListings(){
        return ResponseEntity.ok(service.getAllListings());
    }
    @GetMapping("/get/location")
    public ResponseEntity<ReqRes> getListingByLocation(@RequestParam String location){
        return ResponseEntity.ok(service.getListingByLocation(location));
    }
    @GetMapping("/get/id")
    public  ResponseEntity<ReqRes> getListingById(@RequestParam Long id){
        return ResponseEntity.ok(service.getListingById(id));
    }
//    ReqRes getListingByParking(Boolean hasParking);
//    ReqRes getListingByBedrooms(Long bedrooms);
//    ReqRes getListingByBathrooms(Long bathrooms);
//    ReqRes getListingByType(String type);
//    ReqRes getListingByFurnished(Boolean isFurnished);
//    ReqRes getListingByPrice(Double price);
//    ReqRes updateListing(ReqRes listingInfo);
//    ReqRes createListing(ReqRes listingInfo);
//    ReqRes deleteListing(Long id);
//    ReqRes deleteAllListings();



}
