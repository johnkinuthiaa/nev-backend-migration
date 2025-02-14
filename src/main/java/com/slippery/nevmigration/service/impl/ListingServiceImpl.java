//package com.slippery.nevmigration.service.impl;
//
//import com.slippery.nevmigration.dto.ReqRes;
//import com.slippery.nevmigration.model.Listing;
//import com.slippery.nevmigration.model.Users;
//import com.slippery.nevmigration.repository.ListingRepository;
//import com.slippery.nevmigration.repository.UserRepository;
//import com.slippery.nevmigration.service.ListingService;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//public class ListingServiceImpl implements ListingService {
//    private final ListingRepository repository;
//    private final UserRepository userRepository;
//
//
//    public ListingServiceImpl(ListingRepository repository, UserRepository userRepository){
//        this.repository=repository;
//        this.userRepository=userRepository;
//
//    }
//
//    @Override
//    public ReqRes getAllListings(){
//        ReqRes response =new ReqRes();
//        if (!repository.findAll().isEmpty()){
//            response.setMessage("all listings");
//            response.setStatusCode(200);
//            response.setListings(repository.findAll());
//            response.setName("all listings");
//        }else {
//            response.setStatusCode(404);
//            response.setError("could not find any listing");
//        }
//        return response;
//
//    }
//    @Override
//    public ReqRes getListingByLocation(String location) {
//        ReqRes response = new ReqRes();
//        if(location == null || location.isBlank()){
//            response.setStatusCode(401);
//            response.setMessage("location cannot be empty");
//            return response;
//        }
//        try{
//            var listingsInLocation =repository.findAll().stream()
//                    .filter(listing -> listing.getLocation().toLowerCase().contains(location.toLowerCase()))
//                    .toList();
//            if (listingsInLocation.isEmpty()) {
//                response.setStatusCode(404);
//                response.setMessage("no listings were found in that location");
//            } else {
//                response.setMessage("all listings found in " + location);
//                response.setStatusCode(200);
//                response.setListings(listingsInLocation);
//                response.setName("all listings");
//            }
//        } catch (Exception e) {
//            response.setMessage(e.getMessage());
//            response.setStatusCode(404);
//        }
//
//
//
//        return response;
//    }
//    @Override
//    public ReqRes getListingById(Long id){
//        ReqRes response = new ReqRes();
//        if(repository.findById(id).isPresent()){
//
//            response.setStatusCode(200);
//            response.setMessage("listing wth id "+id+" found.");
//            response.setListing(repository.findById(id).orElse(null));
//        }else{
//            response.setStatusCode(404);
//            response.setMessage("no listings were found with an id of"+id);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes getListingByParking(Boolean hasParking) {
//        ReqRes response =new ReqRes();
//        var parking =repository.findAll().stream()
//                .filter(listing -> listing.getHasParking().equals(hasParking))
//                .toList();
//        if(parking.isEmpty()){
//            response.setStatusCode(404);
//            response.setMessage("no listings were found");
//        }else{
//            response.setStatusCode(200);
//            response.setMessage("listing wth parking "+hasParking+" found.");
//            response.setListings(parking);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes getListingByBedrooms(Long bedrooms) {
//        ReqRes response =new ReqRes();
//        var noOfBedrooms =repository.findAll().stream()
//                .filter(listing -> listing.getBedrooms().toString().toLowerCase().contains(bedrooms.toString().toLowerCase()))
//                .toList();
//        if(noOfBedrooms.isEmpty()){
//            response.setStatusCode(404);
//            response.setMessage("no listings were found");
//        }else{
//            response.setStatusCode(200);
//            response.setMessage("listings wth "+bedrooms+"bedrooms found.");
//            response.setListings(noOfBedrooms);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes getListingByBathrooms(Long bathrooms) {
//        ReqRes response =new ReqRes();
//        var noOfBathrooms =repository.findAll().stream()
//                .filter(listing -> listing.getBedrooms().toString().toLowerCase().contains(bathrooms.toString().toLowerCase()))
//                .toList();
//        if(noOfBathrooms.isEmpty()){
//            response.setStatusCode(404);
//            response.setMessage("no listings were found");
//        }else{
//            response.setStatusCode(200);
//            response.setMessage("listings wth "+bathrooms+"bathrooms found.");
//            response.setListings(noOfBathrooms);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes getListingByType(String type) {
//        ReqRes response =new ReqRes();
//
//        var houseType = repository.findAll().stream()
//                .filter(listing -> listing.getType().toLowerCase().contains(type.toLowerCase()))
//                .collect(Collectors.toList());
//        if(houseType.isEmpty()){
//
//            response.setStatusCode(404);
//            response.setMessage("no listings were found");
//        }else{
//            response.setStatusCode(200);
//            response.setMessage("listings of "+type+" found.");
//            response.setListings(houseType);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes getListingByFurnished(Boolean isFurnished) {
//        ReqRes response =new ReqRes();
//        var furnished =repository.findAll().stream()
//                .filter(listing -> listing.getIsFurnished().equals(isFurnished))
//                .toList();
//        if(furnished.isEmpty()){
//            response.setStatusCode(404);
//            response.setMessage("no listings were found");
//        }else{
//            response.setStatusCode(200);
//            response.setMessage("listings wth furnished "+isFurnished+" found");
//            response.setListings(furnished);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes getListingByPrice(Double price) {
//        ReqRes response =new ReqRes();
//        var housePrice =repository.findAll().stream()
//                .filter(listing -> listing.getRegularPrice().toString().toLowerCase().contains(price.toString().toLowerCase()))
//                .toList();
//        if(housePrice.isEmpty()){
//            response.setStatusCode(404);
//            response.setMessage("no listings were found");
//        }else{
//            response.setStatusCode(200);
//            response.setMessage("listings wth "+price+"bathrooms found.");
//            response.setListings(housePrice);
//        }
//        return response;
//    }
//
//    @Override
//    public ReqRes updateListing(Listing listingInfo, Long userId, Long listingId) {
//        ReqRes response =new ReqRes();
//        Optional<Users> userTemp = userRepository.findById(userId);
//        Optional<Listing> existingListing =repository.findById(listingId);
//
//        if(userTemp.isEmpty()){
//            response.setMessage("user not found");
//            response.setStatusCode(404);
//            return response;
//        }
//        if(existingListing.isEmpty()){
//            response.setMessage("Listing not found");
//            response.setStatusCode(404);
//            return response;
//        }
//        if(!existingListing.get().getUsers().getId().equals(userId)){
//            response.setMessage("User doesnt have a listing with id "+listingId);
//            response.setStatusCode(400);
//            return response;
//        }
//        existingListing.get()
//                .setAddress(listingInfo.getAddress() ==null||listingInfo.getAddress().isBlank()?existingListing.get().getAddress(): listingInfo.getAddress());
//        existingListing.get().setBathrooms(listingInfo.getBathrooms() ==null?existingListing.get().getBathrooms():listingInfo.getBathrooms());
//        existingListing.get().setBedrooms(listingInfo.getBedrooms() ==null?existingListing.get().getBedrooms():listingInfo.getBedrooms());
//        existingListing.get().setDescription(listingInfo.getDescription() ==null ||listingInfo.getDescription().isBlank()?
//                existingListing.get().getDescription(): listingInfo.getDescription());
//        existingListing.get().setDiscount(listingInfo.getDiscount() ==null?existingListing.get().getDiscount(): listingInfo.getDiscount());
//        existingListing.get().setHasOffer(listingInfo.getHasOffer() ==null?existingListing.get().getHasOffer():listingInfo.getHasOffer());
//        existingListing.get().setHasParking(listingInfo.getHasParking() ==null? existingListing.get().getHasParking() : listingInfo.getHasParking());
//        existingListing.get().setIsFurnished(listingInfo.getIsFurnished() ==null?existingListing.get().getIsFurnished():listingInfo.getIsFurnished());
//        existingListing.get().setLocation(listingInfo.getLocation() ==null||listingInfo.getLocation().isBlank()?existingListing.get().getLocation(): listingInfo.getLocation());
//        existingListing.get().setName(listingInfo.getName()==null||listingInfo.getName().isBlank()?existingListing.get().getName(): listingInfo.getName());
//        existingListing.get().setRegularPrice(listingInfo.getRegularPrice() ==null ||listingInfo.getRegularPrice().toString().isBlank()?existingListing.get().getRegularPrice(): listingInfo.getRegularPrice());
//
////        new shii to update
//        existingListing.get().setRooms(listingInfo.getRooms() ==null?existingListing.get().getRooms(): listingInfo.getRooms());
//        existingListing.get().setSquareFootage(listingInfo.getSquareFootage() ==null?existingListing.get().getSquareFootage(): listingInfo.getSquareFootage());
//        existingListing.get().setKitchen(listingInfo.getKitchen() ==null?existingListing.get().getKitchen(): listingInfo.getKitchen());
//        existingListing.get().setStatus(listingInfo.getStatus() ==null||listingInfo.getStatus().isBlank()?existingListing.get().getStatus(): listingInfo.getStatus());
//
//        existingListing.get().setPetPolicy(listingInfo.getPetPolicy() ==null||listingInfo.getPetPolicy().isBlank()?existingListing.get().getPetPolicy(): listingInfo.getPetPolicy());
//        existingListing.get().setPostalCode(listingInfo.getPostalCode() ==null||listingInfo.getPostalCode().isBlank()?existingListing.get().getPostalCode(): listingInfo.getPostalCode());
//        existingListing.get().setType(listingInfo.getType() ==null||listingInfo.getType().isBlank()?existingListing.get().getType(): listingInfo.getType());
//        existingListing.get().setUpdatedDate(LocalDateTime.now());
//        existingListing.get().setYearBuilt(listingInfo.getYearBuilt()<=0?existingListing.get().getYearBuilt(): listingInfo.getYearBuilt());
//        existingListing.get().setSizeOfLand(listingInfo.getSizeOfLand() ==null||listingInfo.getSizeOfLand()<=0?existingListing.get().getSizeOfLand(): listingInfo.getSizeOfLand());
//        existingListing.get().setFlooringType(listingInfo.getFlooringType() ==null||listingInfo.getFlooringType().isBlank()?existingListing.get().getFlooringType(): listingInfo.getFlooringType());
//        existingListing.get().setElectricityType(listingInfo.getElectricityType() ==null||listingInfo.getElectricityType().isBlank()?existingListing.get().getElectricityType(): listingInfo.getElectricityType());
//        existingListing.get().setNeighbourHoodName(listingInfo.getNeighbourHoodName() ==null||listingInfo.getNeighbourHoodName().isBlank()?existingListing.get().getNeighbourHoodName(): listingInfo.getNeighbourHoodName());
//
//        repository.save(existingListing.get());
//        response.setMessage("Listing updated");
//        response.setStatusCode(200);
//        response.setListing(existingListing.get());
//
//        return response;
//    }
//
//    @Override
//    public ReqRes createListing(ReqRes listingInfo, Long id) {
//        ReqRes response =new ReqRes();
//        try {
//            Optional<Users> userTemp = userRepository.findById(id);
//            Optional<Listing> listing=repository.findByNameEqualsIgnoreCase(listingInfo.getName().trim());
//
//            if(userTemp.isEmpty()){
//                response.setMessage("User not found");
//                response.setStatusCode(404);
//                return response;
//            }
//            if(listing.isPresent()){
//                response.setMessage("listing already exists");
//                response.setStatusCode(400);
//                return response;
//            }
//            Listing newListing =new Listing();
//
//            newListing.setName(listingInfo.getName());
//            newListing.setDescription(listingInfo.getDescription());
//            newListing.setAddress(listingInfo.getAddress());
//            newListing.setRegularPrice(listingInfo.getRegularPrice());
//            newListing.setDiscount(listingInfo.getDiscount());
//            newListing.setBathrooms(listingInfo.getBathrooms());
//            newListing.setBedrooms(listingInfo.getBedrooms());
//            newListing.setIsFurnished(listingInfo.getIsFurnished());
//            newListing.setHasParking(listingInfo.getHasParking());
//            newListing.setType(listingInfo.getType());
//            newListing.setHasOffer(listingInfo.getHasOffer());
//            newListing.setImgUrl(listingInfo.getImgUrl());
//            newListing.setReviewsList(null);
//            newListing.setLocation(listingInfo.getLocation());
//            newListing.setSwimmingPool(listingInfo.getSwimmingPool());
//            newListing.setGym(listingInfo.getGym());
//            newListing.setUsers(userTemp.get());
//            newListing.setCreatedAt(LocalDateTime.now());
//
//            newListing.setElectricityType(listingInfo.getElectricityType());
//            newListing.setFlooringType(listingInfo.getFlooringType());
//            newListing.setKitchen(listingInfo.getKitchen());
//
//            newListing.setNeighbourHoodName(listingInfo.getNeighbourHoodName());
//            newListing.setPetPolicy(listingInfo.getPetPolicy());
//            newListing.setPostalCode(listingInfo.getPostalCode());
//            newListing.setRooms(listingInfo.getRooms());
//            newListing.setSizeOfLand(listingInfo.getSizeOfLand());
//            newListing.setStatus(listingInfo.getStatus());
//            newListing.setSquareFootage(listingInfo.getSquareFootage());
//            newListing.setYearBuilt(listingInfo.getYearBuilt());
//            newListing.setUpdatedDate(null);
//            repository.save(newListing);
////            user listing
//
//            List<Listing> userListings =userTemp.get().getListings();
//            userListings.add(newListing);
//            userTemp.get().setListings(userListings);
//            userRepository.save(userTemp.get());
//            response.setStatusCode(201);
//            response.setMessage("new listing created");
//            response.setListing(newListing);
//
//        } catch (Exception e) {
//            response.setStatusCode(500);
//            response.setMessage(e.getMessage());
//        }
//        return response;
//
//    }
//
//    @Override
//    public ReqRes advancedSearch(ReqRes searchParams) {
//        ReqRes response =new ReqRes();
//        try{
//            var advancedListing =repository.findAll().stream()
//                    .filter(listing ->
//                            listing.getIsFurnished().equals(searchParams.getIsFurnished())
//                            &&listing.getHasParking().equals(searchParams.getHasParking())
//                            && Objects.equals(listing.getBathrooms(), searchParams.getBathrooms())
//                            && Objects.equals(listing.getBedrooms(), searchParams.getBedrooms())
//                            &&(listing.getRegularPrice()-searchParams.getRegularPrice() >0
//                                    &&listing.getRegularPrice()-searchParams.getRegularPrice() < 9999)
//                    )
//                    .toList();
//            response.setListings(advancedListing);
//        } catch (Exception e) {
//            response.setMessage(e.getMessage());
//            response.setStatusCode(500);
//        }
//        return response;
//    }
//
//
//    @Override
//    public ReqRes deleteListing(Long id,Long userId) {
//        ReqRes response =new ReqRes();
//        Optional<Listing> listing =repository.findById(id);
//        Optional<Users> user =userRepository.findById(userId);
//        if(listing.isEmpty()){
//            response.setMessage("Listing is not available");
//            response.setStatusCode(404);
//            return response;
//        }
//        if(user.isEmpty()){
//            response.setMessage("Listing is not available");
//            response.setStatusCode(404);
//            return response;
//        }
//        if(!listing.get().getUsers().getId().equals(userId)){
//            response.setMessage("Listing does not belong to user");
//            response.setStatusCode(401);
//            return response;
//        }
//        repository.deleteById(id);
//        response.setMessage("Listing deleted");
//        response.setStatusCode(200);
//        return response;
//    }
//
//    @Override
//    public ReqRes deleteAllListings(Long id) {
//        ReqRes response =new ReqRes();
//        Users userTemp = userRepository.findById(id).orElse(null);
//        if(userTemp !=null){
//            repository.deleteAll();
//            response.setStatusCode(200);
//            response.setMessage("all listings deleted");
//
//        }else{
//            response.setMessage("user not found");
//        }
//
//        return response;
//    }
//}
