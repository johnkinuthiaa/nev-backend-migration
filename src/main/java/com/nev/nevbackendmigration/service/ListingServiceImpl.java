package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.ReqRes;
import com.nev.nevbackendmigration.model.Listing;
import com.nev.nevbackendmigration.model.User;
import com.nev.nevbackendmigration.repository.ListingRepository;
import com.nev.nevbackendmigration.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService{
    private final ListingRepository repository;
    private final UserRepository userRepository;
    public ListingServiceImpl(ListingRepository repository,UserRepository userRepository){
        this.repository=repository;
        this.userRepository=userRepository;
    }

    @Override
    public ReqRes getAllListings(){
        ReqRes response =new ReqRes();
        if (!repository.findAll().isEmpty()){
            response.setMessage("all listings");
            response.setStatusCode(200);
            response.setListings(repository.findAll());
            response.setName("all listings");
        }else {
            response.setStatusCode(404);
            response.setError("could not find any listing");
        }
        return response;

    }
    @Override
    public ReqRes getListingByLocation(String location) {
        ReqRes response = new ReqRes();
        var listingsInLocation = repository.findAll().stream()
                .filter(listing -> listing.getAddress().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
        if (listingsInLocation.isEmpty()) {
            response.setStatusCode(404);
            response.setMessage("no listings were found in that location");
        } else {
            response.setMessage("all listings found in " + location);
            response.setStatusCode(200);
            response.setListings(listingsInLocation);
            response.setName("all listings");
        }
        return response;
    }
    @Override
    public ReqRes getListingById(Long id){
        ReqRes response = new ReqRes();
        if(repository.findById(id).isPresent()){

            response.setStatusCode(200);
            response.setMessage("listing wth id "+id+" found.");
            response.setListing(repository.findById(id).orElse(null));
        }else{
            response.setStatusCode(500);
            response.setMessage("no listings were found with an id of"+id);
        }
        return response;
    }

    @Override
    public ReqRes getListingByParking(Boolean hasParking) {
        ReqRes response =new ReqRes();
        var parking =repository.findAll().stream()
                .filter(listing -> listing.getHasParking().equals(hasParking))
                .toList();
        if(parking.isEmpty()){
            response.setStatusCode(404);
            response.setMessage("no listings were found");
        }else{
            response.setStatusCode(200);
            response.setMessage("listing wth parking "+hasParking+" found.");
            response.setListings(parking);
        }
        return response;
    }

    @Override
    public ReqRes getListingByBedrooms(Long bedrooms) {
        ReqRes response =new ReqRes();
        var noOfBedrooms =repository.findAll().stream()
                .filter(listing -> listing.getBedrooms().toString().toLowerCase().contains(bedrooms.toString().toLowerCase()))
                .toList();
        if(noOfBedrooms.isEmpty()){
            response.setStatusCode(404);
            response.setMessage("no listings were found");
        }else{
            response.setStatusCode(200);
            response.setMessage("listings wth "+bedrooms+"bedrooms found.");
            response.setListings(noOfBedrooms);
        }
        return response;
    }

    @Override
    public ReqRes getListingByBathrooms(Long bathrooms) {
        ReqRes response =new ReqRes();
        var noOfBathrooms =repository.findAll().stream()
                .filter(listing -> listing.getBedrooms().toString().toLowerCase().contains(bathrooms.toString().toLowerCase()))
                .toList();
        if(noOfBathrooms.isEmpty()){
            response.setStatusCode(404);
            response.setMessage("no listings were found");
        }else{
            response.setStatusCode(200);
            response.setMessage("listings wth "+bathrooms+"bathrooms found.");
            response.setListings(noOfBathrooms);
        }
        return response;
    }

    @Override
    public ReqRes getListingByType(String type) {
        ReqRes response =new ReqRes();

        var houseType = repository.findAll().stream()
                .filter(listing -> listing.getType().toLowerCase().contains(type.toLowerCase()))
                .collect(Collectors.toList());
        if(houseType.isEmpty()){

            response.setStatusCode(404);
            response.setMessage("no listings were found");
        }else{
            response.setStatusCode(200);
            response.setMessage("listings of "+type+" found.");
            response.setListings(houseType);
        }
        return response;
    }

    @Override
    public ReqRes getListingByFurnished(Boolean isFurnished) {
        ReqRes response =new ReqRes();
        var furnished =repository.findAll().stream()
                .filter(listing -> listing.getIsFurnished().equals(isFurnished))
                .toList();
        if(furnished.isEmpty()){
            response.setStatusCode(404);
            response.setMessage("no listings were found");
        }else{
            response.setStatusCode(200);
            response.setMessage("listings wth furnished "+isFurnished+" found");
            response.setListings(furnished);
        }
        return response;
    }

    @Override
    public ReqRes getListingByPrice(Double price) {
        ReqRes response =new ReqRes();
        var housePrice =repository.findAll().stream()
                .filter(listing -> listing.getRegularPrice().toString().toLowerCase().contains(price.toString().toLowerCase()))
                .toList();
        if(housePrice.isEmpty()){
            response.setStatusCode(404);
            response.setMessage("no listings were found");
        }else{
            response.setStatusCode(200);
            response.setMessage("listings wth "+price+"bathrooms found.");
            response.setListings(housePrice);
        }
        return response;
    }

    @Override
    public ReqRes updateListing(ReqRes listingInfo,Long id) {
        ReqRes response =new ReqRes();

        try {
            User userTemp = userRepository.findById(id).orElse(null);
            Listing newListing =new Listing();
            if (repository.findById(listingInfo.getId()).isPresent() && userTemp !=null){
                newListing.setName(listingInfo.getName());
                newListing.setDescription(listingInfo.getDescription());
                newListing.setAddress(listingInfo.getAddress());
                newListing.setRegularPrice(listingInfo.getRegularPrice());
                newListing.setDiscount(listingInfo.getDiscount());
                newListing.setBathrooms(listingInfo.getBathrooms());
                newListing.setBedrooms(listingInfo.getBedrooms());
                newListing.setIsFurnished(listingInfo.getIsFurnished());
                newListing.setHasParking(listingInfo.getHasParking());
                newListing.setType(listingInfo.getType());
                newListing.setHasOffer(listingInfo.getHasOffer());
                newListing.setImgUrl(listingInfo.getImgUrl());
                newListing.setCreatedAt(LocalDateTime.now());
                newListing.setUser(userTemp);
                repository.save(newListing);
                userRepository.save(userTemp);
                response.setStatusCode(201);
                response.setMessage("listing updated");
                response.setListing(newListing);
            }

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public ReqRes createListing(ReqRes listingInfo,Long id) {
        ReqRes response =new ReqRes();
        try {
            User userTemp = userRepository.findById(id).orElse(null);
            if (repository.getListingByName(listingInfo.getName()).isEmpty() && userTemp !=null){
                Listing newListing =new Listing();
                newListing.setName(listingInfo.getName());
                newListing.setDescription(listingInfo.getDescription());
                newListing.setAddress(listingInfo.getAddress());
                newListing.setRegularPrice(listingInfo.getRegularPrice());
                newListing.setDiscount(listingInfo.getDiscount());
                newListing.setBathrooms(listingInfo.getBathrooms());
                newListing.setBedrooms(listingInfo.getBedrooms());
                newListing.setIsFurnished(listingInfo.getIsFurnished());
                newListing.setHasParking(listingInfo.getHasParking());
                newListing.setType(listingInfo.getType());
                newListing.setHasOffer(listingInfo.getHasOffer());
                newListing.setImgUrl(listingInfo.getImgUrl());
                newListing.setUser(userTemp);
                newListing.setCreatedAt(LocalDateTime.now());
                repository.save(newListing);
                userRepository.save(userTemp);

                response.setStatusCode(201);
                response.setMessage("new listing created");
                response.setListing(newListing);
            }

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage(e.getMessage());
        }
        return response;

    }
    @Override
    public ReqRes deleteListing(Long id) {
        ReqRes response =new ReqRes();
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            response.setMessage("listing  with id "+id+" successfully deleted");
            response.setStatusCode(200);

        }
        return response;
    }

    @Override
    public ReqRes deleteAllListings(Long id) {
        ReqRes response =new ReqRes();
        User userTemp = userRepository.findById(id).orElse(null);
        if(userTemp !=null){
            repository.deleteAll();
            response.setStatusCode(200);
            response.setMessage("all listings deleted");

        }else{
            response.setMessage("user not found");
        }

        return response;
    }
}
