package com.nev.nevbackendmigration.repository;

import com.nev.nevbackendmigration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserEmail(String email);
    User findUserByUsername(String username);

}
