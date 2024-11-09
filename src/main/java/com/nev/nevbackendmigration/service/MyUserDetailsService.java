package com.nev.nevbackendmigration.service;


import com.nev.nevbackendmigration.model.User;
import com.nev.nevbackendmigration.model.UserPrincipal;
import com.nev.nevbackendmigration.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository repository;
    public MyUserDetailsService(UserRepository repository){
        this.repository=repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repository.findByUsername(username);
        if(user ==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}
