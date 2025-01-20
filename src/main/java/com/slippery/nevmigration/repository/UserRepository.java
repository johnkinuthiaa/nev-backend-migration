package com.slippery.nevmigration.repository;

import com.slippery.nevmigration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserEmail(String email);
    User findByUsername(String username);

}