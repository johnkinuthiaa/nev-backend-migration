package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto registrationDetails);
    UserDto login(UserDto loginDetails);
    UserDto updateUser(UserDto registrationDetails,Long id);
    UserDto deleteUserById(Long id);
    UserDto deleteAllUsers();
}
