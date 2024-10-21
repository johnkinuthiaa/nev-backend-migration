package com.nev.nevbackendmigration.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
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
    private LocalDateTime createdAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    @JsonBackReference
    private User user;

//    public Listing(){}
//    public Listing(String name,
//                   String description,
//                   String address,
//                   Double regularPrice,
//                   Double discount,
//                   Long bathrooms,
//                   Long bedrooms,
//                   Boolean isFurnished,
//                   Boolean hasParking,
//                   String type,
//                   Boolean hasOffer,
//                   String imgUrl
//                   ){
//        this.name=name;
//        this.description=description;
//        this.address=address;
//        this.regularPrice=regularPrice;
//        this.discount=discount;
//        this.bathrooms=bathrooms;
//        this.bedrooms=bedrooms;
//        this.isFurnished=isFurnished;
//        this.hasParking =hasParking;
//        this.type=type;
//        this.hasOffer=hasOffer;
//        this.imgUrl=imgUrl;
//    }
//    public void setId(Long id){
//        this.id=id;
//    }
//
//    public Long getId(){
//        return id;
//    }
//    public void setName(String name){
//        this.name=name;
//    }
//    public String getName(){
//        return name;
//    }
//
//    public void setDescription(String description){
//        this.description=description;
//    }
//    public String getDescription(){
//        return description;
//    }
//    public void setAddress(String address){
//        this.address=address;
//    }
//    public String getAddress(){
//        return address;
//    }
//    public void setRegularPrice(Double regularPrice){
//        this.regularPrice=regularPrice;
//    }
//    public Double getRegularPrice(){
//        return regularPrice;
//    }
//    public void setDiscount(Double discount){
//        this.discount=discount;
//    }
//    public Double getDiscount(){
//        return discount;
//    }
//    public void setBathrooms(Long bathrooms){
//        this.bathrooms=bathrooms;
//    }
//    public Long getBathrooms(){
//        return bathrooms;
//    }
//    public void setBedrooms(Long bedrooms){
//        this.bedrooms=bedrooms;
//    }
//    public Long getBedrooms(){
//        return bedrooms;
//    }
//    public void setIsFurnished(Boolean isFurnished){
//        this.isFurnished =isFurnished;
//    }
//    public Boolean getIsFurnished(){
//        return isFurnished;
//    }
//    public void setHasParking(Boolean hasParking){
//        this.hasParking=hasParking;
//    }
//    public Boolean getHasParking(){
//        return hasParking;
//    }
//    public void setType(String type){
//        this.type =type;
//    }
//    public String getType(){
//        return type;
//    }
//    public void setHasOffer(Boolean hasOffer) {
//        this.hasOffer = hasOffer;
//    }
//    public Boolean getHasOffer(){
//        return hasOffer;
//    }
//    public void setImgUrl(String imgUrl){
//        this.imgUrl=imgUrl;
//    }
//    public String getImgUrl(){
//        return imgUrl;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt){
//        this.createdAt =createdAt;
//    }
//    public LocalDateTime getCreatedAt(){
//        return createdAt;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
