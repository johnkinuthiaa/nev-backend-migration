package com.nev.nevbackendmigration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nev.nevbackendmigration.model.Listing;
import lombok.Data;

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
    private Boolean isFurnished;
    private Boolean hasParking;
    private String type;
    private Boolean hasOffer;
    private String imgUrl;
    private List<Listing> listings;
    private Listing listing;
}