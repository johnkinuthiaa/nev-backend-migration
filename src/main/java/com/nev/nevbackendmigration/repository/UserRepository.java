package com.nev.nevbackendmigration.repository;

import com.nev.nevbackendmigration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserEmail(String email);
}
