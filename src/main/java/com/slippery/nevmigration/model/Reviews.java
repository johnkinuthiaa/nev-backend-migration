package com.slippery.nevmigration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String review;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Users users;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Listing listing;
    private LocalDateTime createdOn =LocalDateTime.now();
}
