package com.nev.nevbackendmigration.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String password;
    private String role;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Listing> listings;


//    public User(){}
//    public User(String username,String userEmail,String password){
//        this.username=username;
//        this.userEmail=userEmail;
//        this.password=password;
//    }
}
//    public Long getId(){
//        return id;
//    }
//    public void setUsername(String username){
//        this.username =username;
//    }
//    public String getUsername(){
//        return username;
//    }
//    public void setUserEmail(String userEmail){
//        this.userEmail=userEmail;
//    }
//    public String getUserEmail(){
//        return userEmail;
//    }
//    public void setPassword(String password){
//        this.password=password;
//    }
//    public String getPassword(){
//        return password;
//    }
//
//    public List<Listing> getListings() {
//        return listings ;
//    }
//    public void setListings(List<Listing> listings) {
//        this.listings = listings;
//    }
//}
//
