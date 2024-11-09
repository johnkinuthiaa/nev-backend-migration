package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.UserDto;
import com.nev.nevbackendmigration.model.Listing;
import com.nev.nevbackendmigration.model.User;
import com.nev.nevbackendmigration.repository.ListingRepository;
import com.nev.nevbackendmigration.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);


    public UserServiceImpl(UserRepository repository, JwtService jwtService, AuthenticationManager authenticationManager){
        this.repository=repository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDto registerUser(UserDto registrationDetails) {
        var user1 =repository.findUserByUserEmail(registrationDetails.getUserEmail());
        UserDto response =new UserDto();
        if(user1 ==null){
            User user =new User();
            user.setUsername(registrationDetails.getUsername());
            user.setUserEmail(registrationDetails.getUserEmail());
            user.setPassword(passwordEncoder.encode(registrationDetails.getPassword()));
            repository.save(user);
            response.setMessage("user created successfully");
            response.setStatusCode(200);
            response.setUser(user);

        }
        return response;

    }

    @Override
    public UserDto login(UserDto loginDetails) {
        UserDto response =new UserDto();
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDetails.getUsername(),
                loginDetails.getPassword()
        ));
        if(authentication.isAuthenticated()){
            var token = jwtService.generateJwtToken(loginDetails.getUsername());
            response.setMessage("user logged in successfully");
            response.setStatusCode(200);
            response.setJwtToken(token);
        }else{
            response.setStatusCode(500);
            response.setMessage("user not authenticated");
        }

        return response;
    }

    @Override
    public UserDto updateUser(UserDto registrationDetails,Long id) {;
        UserDto response =new UserDto();
        if(repository.findById(id).isPresent()){
            User user =new User();
            user.setId(id);
            user.setUsername(registrationDetails.getUsername());
            user.setUserEmail(registrationDetails.getUserEmail());
            user.setPassword(registrationDetails.getPassword());
            user.setListings(registrationDetails.getListings());
            repository.save(user);
            response.setMessage("user created successfully");
            response.setStatusCode(200);
            response.setUser(user);

        }
        return response;
    }
    @Override
    public UserDto deleteUserById(Long id){
        UserDto response =new UserDto();
        User user =repository.findById(id).orElse(null);
        assert user !=null;
        if(repository.findById(id).isPresent()){
            repository.delete(user);
            response.setMessage("user with id "+id+" was deleted");
            response.setStatusCode(200);
        }
        return response;
    }

    @Override
    public UserDto deleteAllUsers() {
        UserDto response =new UserDto();
        repository.deleteAll();
        response.setStatusCode(200);
        response.setMessage("all users deleted");
        return response;
    }


}
