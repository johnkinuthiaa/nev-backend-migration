package com.nev.nevbackendmigration.controller;

import com.nev.nevbackendmigration.dto.UserDto;
import com.nev.nevbackendmigration.model.Listing;
import com.nev.nevbackendmigration.model.User;
import com.nev.nevbackendmigration.repository.UserRepository;
import com.nev.nevbackendmigration.service.ListingService;
import com.nev.nevbackendmigration.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }
    @PostMapping("/saveUsers")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto registrationDetails){
        return ResponseEntity.ok(service.registerUser(registrationDetails));
    }
}
