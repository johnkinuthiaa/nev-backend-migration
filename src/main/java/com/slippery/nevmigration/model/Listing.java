package com.slippery.nevmigration.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Cacheable
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String description;
    private String address;
    private String postalCode;
    private String neighbourHoodName;
    private Long squareFootage;
    private Long sizeOfLand;
    private int yearBuilt;
    private String flooringType;
    private String status;
    private String location;
    private Double regularPrice;
    private Double discount;
    private Long bathrooms;
    private Long bedrooms;
    private Long rooms;
    private Long kitchen;
    private Boolean isFurnished;
    private Boolean hasParking;
    private String type;
    private Boolean hasOffer;
    private String imgUrl;
    private Boolean swimmingPool;
    private Boolean gym;
    private LocalDateTime createdAt;
    private LocalDateTime updatedDate;
    private String electricityType;
    @Lob
    private String petPolicy;
//    @ManyToOne
//    @JsonBackReference
//    private Users users;
//    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
//    private List<Reviews> reviewsList =new ArrayList<>();

}
