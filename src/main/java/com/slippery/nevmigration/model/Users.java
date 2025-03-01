package com.slippery.nevmigration.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
    private Boolean isAuthenticated =false;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "users")
    private List<Listing> listings =new ArrayList<>();
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true,mappedBy = "users")
    private List<Reviews> reviewsList =new ArrayList<>();

}


