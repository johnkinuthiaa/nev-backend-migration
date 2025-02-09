package com.slippery.nevmigration.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.nevmigration.model.AppliancesIncluded;
import com.slippery.nevmigration.model.Listing;
import com.slippery.nevmigration.model.NearBySchools;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {
    private int statusCode;
    private String error;
    private String message;
    private String name;
    private Long id;
    private String description;
    private String address;
    private Double regularPrice;
    private Double discount;
    private Long bathrooms;
    private Long bedrooms;
    private Long rooms;
    private Boolean isFurnished;
    private Boolean hasParking;
    private String type;
    private Boolean hasOffer;
    private String imgUrl;
    private Boolean swimmingPool;
    private Boolean gym;
    private String location;
    private String postalCode;
    private String neighbourHoodName;
    private Long squareFootage;
    private Long sizeOfLand;
    private int yearBuilt;
    private List<AppliancesIncluded> appliancesIncluded;
    private String flooringType;
    private String status;
    private long kitchen;
    private LocalDateTime updatedDate;
    private List<NearBySchools> nearBySchools;
    private String electricityType;
    private String petPolicy;
    private List<byte[]> imageBytes =new ArrayList<>();
    private String imageName;
    private String imageContent;
    private List<Listing> listings;
    private Listing listing;
}