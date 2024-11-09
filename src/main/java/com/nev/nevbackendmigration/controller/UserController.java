package com.nev.nevbackendmigration.controller;

import com.nev.nevbackendmigration.dto.UserDto;
import com.nev.nevbackendmigration.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }
    @PostMapping("/register/Users")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto registrationDetails){
        return ResponseEntity.ok(service.registerUser(registrationDetails));
    }
    @PutMapping("/update/users")
    public UserDto updateUser(@RequestBody UserDto registrationDetails,@RequestParam Long id){
        return service.updateUser(registrationDetails,id);
    }
    @DeleteMapping("/delete/id")
    public ResponseEntity<UserDto> deleteUserById(@RequestParam Long id){
        return ResponseEntity.ok(service.deleteUserById(id));
    }
    @DeleteMapping("/admin/delete/all")
    public ResponseEntity<UserDto> deleteAllUsers(){
        return ResponseEntity.ok(service.deleteAllUsers());
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto loginDetails){
        return ResponseEntity.ok(service.login(loginDetails));
    }
}
