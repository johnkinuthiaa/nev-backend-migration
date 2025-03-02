package com.slippery.nevmigration.service.impl;


import com.slippery.nevmigration.dto.UserDto;

import com.slippery.nevmigration.model.Users;
import com.slippery.nevmigration.repository.UserRepository;
import com.slippery.nevmigration.service.JwtService;
import com.slippery.nevmigration.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);


    public UserServiceImpl(UserRepository repository, JwtService jwtService, AuthenticationManager authenticationManager){
        this.repository=repository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public UserDto registerUser(Users registrationDetails) {
        UserDto response =new UserDto();
        Users existingUserByUsername =repository.findByUsername(registrationDetails.getUsername().trim());

        if(existingUserByUsername !=null){
            response.setMessage("User with username "+registrationDetails.getUsername()+" already exists! ");
            response.setStatusCode(400);
            return response;
        }
        if(registrationDetails.getUserEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")){
            System.out.println("email matches regex");
        }

        Users user =new Users();
        user.setPassword(passwordEncoder.encode(registrationDetails.getPassword()));
        user.setUsername(registrationDetails.getUsername());
        user.setListings(new ArrayList<>());
        user.setUserEmail(registrationDetails.getUserEmail());
        user.setRole(registrationDetails.getRole());
        user.setReviewsList(null);
        repository.save(user);
        response.setMessage("User registration completed");
        response.setStatusCode(200);
        return response;
    }

    @Override
    public UserDto login(Users loginDetails) {
        UserDto response =new UserDto();
        var findUserUsingEmail =repository.findAll().stream()
                .filter(user -> user.getUserEmail().equals(loginDetails.getUserEmail()))
                .toList();
        if(findUserUsingEmail.isEmpty()){
            response.setMessage("User with the email was not found! ");
            response.setStatusCode(404);
            return response;
        }
        Users existingUserByUsername =repository.findByUsername(findUserUsingEmail.get(0).getUsername());

        if(existingUserByUsername ==null){
            response.setMessage("User with username "+loginDetails.getUsername()+" does not exist!");
            response.setStatusCode(400);
            return response;
        }
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(findUserUsingEmail.get(0).getUsername(),loginDetails.getPassword())
        );
        if(authentication.isAuthenticated()){
            var token =jwtService.generateJwtToken(findUserUsingEmail.get(0).getUsername());
            existingUserByUsername.setIsAuthenticated(true);
            repository.save(existingUserByUsername);
            response.setJwtToken(token);
            response.setUser(existingUserByUsername);
            response.setMessage("User logged in successfully");
            response.setStatusCode(200);
        }else{
            response.setMessage("User not authenticated");
            response.setStatusCode(401);
        }
        return response;
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserDto response =new UserDto();
        Optional<Users> existingUser =repository.findById(userId);
        if(existingUser.isEmpty()){
            response.setMessage("User doesnt exist");
            response.setStatusCode(200);
            return response;
        }
        response.setUser(existingUser.get());
        response.setStatusCode(200);
        return response;
    }

    @Override
    public UserDto updateUser(Users details,Long id) {
        UserDto response =new UserDto();
        Optional<Users> existingUser =repository.findById(id);
        if(existingUser.isEmpty()){
            response.setMessage("User does not exist");
            response.setStatusCode(404);
            return response;
        }
        existingUser.get().setRole(details.getRole() ==null||details.getRole().isBlank()?existingUser.get().getRole():details.getRole());
        existingUser.get().setUserEmail(details.getUserEmail() ==null||details.getUserEmail().isBlank()?existingUser.get().getUserEmail():details.getUserEmail());
        existingUser.get().setPassword(details.getPassword() ==null ||details.getPassword().isBlank()?existingUser.get().getPassword():details.getPassword());
        existingUser.get().setUsername(details.getUsername() ==null||details.getUsername().isBlank()?existingUser.get().getUsername():details.getUsername());
        existingUser.get().setListings(existingUser.get().getListings());
        repository.save(existingUser.get());
        response.setMessage("User updated successfully");
        response.setStatusCode(200);
        response.setUser(existingUser.get());

        return response;
    }

    @Override
    public UserDto deleteUserById(Long id) {
        UserDto response =new UserDto();
        Optional<Users> existingUser =repository.findById(id);
        if(existingUser.isEmpty()){
            response.setMessage("User was not found");
            response.setStatusCode(404);
            return response;
        }
        repository.deleteById(id);
        response.setStatusCode(200);
        response.setMessage("User deleted successfully");

        return response;
    }

    @Override
    public UserDto deleteAllUsers() {
        return null;
    }
}
