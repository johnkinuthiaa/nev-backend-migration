package com.nev.nevbackendmigration.controller;

import com.nev.nevbackendmigration.dto.ReqRes;
import com.nev.nevbackendmigration.model.Listing;
import com.nev.nevbackendmigration.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ReqRes> getListingById(@RequestParam Long id){
        return ResponseEntity.ok(service.getListingById(id));
    }
    @GetMapping("/get/parking")
    public ResponseEntity<ReqRes> getListingByParking(@RequestParam Boolean hasParking){
        return ResponseEntity.ok(service.getListingByParking(hasParking));
    }
    @GetMapping("get/bedrooms")
    public ResponseEntity<ReqRes> getListingByBedrooms(@RequestParam Long bedrooms){
        return ResponseEntity.ok(service.getListingByBedrooms(bedrooms));
    }
    @GetMapping("/get/bathrooms")
    public ResponseEntity<ReqRes> getListingByBathrooms(@RequestParam Long bathrooms){
        return ResponseEntity.ok(service.getListingByBathrooms(bathrooms));
    }
    @GetMapping("/get/type")
    public ResponseEntity<ReqRes> getListingByType(@RequestParam String type){
        return ResponseEntity.ok(service.getListingByType(type));
    }
    @GetMapping("get/furnished")
    public ResponseEntity<ReqRes> getListingByFurnished(@RequestParam Boolean isFurnished){
        return ResponseEntity.ok(service.getListingByFurnished(isFurnished));
    }
    @GetMapping("get/price")
    public ResponseEntity<ReqRes> getListingByPrice(@RequestParam Double price){
        return ResponseEntity.ok(service.getListingByPrice(price));
    }
    @PutMapping("update/listing")
    public ResponseEntity<ReqRes> updateListing(@RequestBody ReqRes listingInfo,Long id){
        return ResponseEntity.ok(service.updateListing(listingInfo,id));
    }
    @PostMapping("create/new-listing")
    public ResponseEntity<ReqRes> createListing(@RequestBody ReqRes listingInfo,Long id){
        return new ResponseEntity<>(service.createListing(listingInfo,id), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/id")
    public ResponseEntity<ReqRes> deleteListing(@RequestParam Long id){
        return new ResponseEntity<>(service.deleteListing(id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<ReqRes> deleteAllListings(@RequestParam Long id){
        return new ResponseEntity<>(service.deleteAllListings(id),HttpStatus.ACCEPTED);
    }

}
