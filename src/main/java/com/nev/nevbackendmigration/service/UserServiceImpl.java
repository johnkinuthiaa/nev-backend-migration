package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.UserDto;
import com.nev.nevbackendmigration.model.User;
import com.nev.nevbackendmigration.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
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


}
