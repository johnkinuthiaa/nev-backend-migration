package com.slippery.nevmigration.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private String location;
    private Double regularPrice;
    private Double discount;
    private Long bathrooms;
    private Long bedrooms;
    private Boolean isFurnished;
    private Boolean hasParking;
    private String type;
    private Boolean hasOffer;
    private String imgUrl;
    private LocalDateTime createdAt;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonBackReference
    private User user;

}
