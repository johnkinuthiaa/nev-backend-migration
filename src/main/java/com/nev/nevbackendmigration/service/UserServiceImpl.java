package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.UserDto;
import com.nev.nevbackendmigration.model.Listing;
import com.nev.nevbackendmigration.model.User;
import com.nev.nevbackendmigration.repository.ListingRepository;
import com.nev.nevbackendmigration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final ListingRepository listingRepository;

    public UserServiceImpl(UserRepository repository,ListingRepository listingRepository){
        this.repository=repository;
        this.listingRepository=listingRepository;
    }

    @Override
    public UserDto registerUser(UserDto registrationDetails) {
        var user1 =repository.findUserByUserEmail(registrationDetails.getUserEmail());
        UserDto response =new UserDto();
        if(user1 ==null){
            User user =new User();
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
