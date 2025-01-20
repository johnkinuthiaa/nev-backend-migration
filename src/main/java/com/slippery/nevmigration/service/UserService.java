package com.slippery.nevmigration.service;

import com.slippery.nevmigration.dto.UserDto;
import com.slippery.nevmigration.model.User;

public interface UserService {
    UserDto registerUser(User registrationDetails);
    UserDto login(User loginDetails);
    UserDto updateUser(User registrationDetails,Long id);
    UserDto deleteUserById(Long id);
    UserDto deleteAllUsers();
}