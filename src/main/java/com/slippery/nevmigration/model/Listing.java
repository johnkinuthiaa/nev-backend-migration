package com.slippery.nevmigration.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.processing.Generated;
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
    @ElementCollection
    private List<String> appliancesIncluded;
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

    private boolean swimmingPool;
    private boolean gym;
    private LocalDateTime createdAt;
    private LocalDateTime updatedDate;
    @ElementCollection
    private List<String> nearBySchools;
    private String electricityType;
    @Lob
    private String petPolicy;
    @ManyToOne
    @JsonBackReference
    private User user;
    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Reviews> reviewsList =new ArrayList<>();

}
