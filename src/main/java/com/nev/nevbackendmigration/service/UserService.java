package com.nev.nevbackendmigration.service;

import com.nev.nevbackendmigration.dto.UserDto;

public interface UserService {
    UserDto registerUser(UserDto registrationDetails);
}
