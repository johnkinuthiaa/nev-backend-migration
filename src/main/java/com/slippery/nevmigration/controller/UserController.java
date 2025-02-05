package com.slippery.nevmigration.controller;


import com.slippery.nevmigration.dto.UserDto;
import com.slippery.nevmigration.model.User;
import com.slippery.nevmigration.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody User registrationDetails){
        return ResponseEntity.ok(service.registerUser(registrationDetails));
    }
    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody User registrationDetails, @RequestParam Long id){
        return ResponseEntity.ok(service.updateUser(registrationDetails, id));
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
    public ResponseEntity<UserDto> login(@RequestBody User loginDetails){
        return ResponseEntity.ok(service.login(loginDetails));
    }
    @GetMapping("/get/{userId}/user")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(service.getUserById(userId));
    }
}
