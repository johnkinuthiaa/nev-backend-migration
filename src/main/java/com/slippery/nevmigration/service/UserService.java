package com.slippery.nevmigration.service;

import com.slippery.nevmigration.dto.UserDto;
import com.slippery.nevmigration.model.Users;

public interface UserService {
    UserDto registerUser(Users registrationDetails);
    UserDto login(Users loginDetails);
    UserDto getUserById(Long userId);
    UserDto updateUser(Users registrationDetails,Long id);
    UserDto deleteUserById(Long id);
    UserDto deleteAllUsers();
}