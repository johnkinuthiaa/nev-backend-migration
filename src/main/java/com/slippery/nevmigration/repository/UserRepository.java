package com.slippery.nevmigration.repository;

import com.slippery.nevmigration.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findUserByUserEmail(String email);
    Users findByUsername(String username);

}