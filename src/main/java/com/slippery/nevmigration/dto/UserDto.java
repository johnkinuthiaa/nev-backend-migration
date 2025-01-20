package com.slippery.nevmigration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.slippery.nevmigration.model.Listing;
import com.slippery.nevmigration.model.User;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long userId;
    private int statusCode;
    private String error;
    private String message;
    private String username;
    private String userEmail;
    private String password;
    private String jwtToken;
    private List<User> users;
    private User user;
    private List<Listing> listings;
}
