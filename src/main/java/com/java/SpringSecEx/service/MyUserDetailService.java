package com.java.SpringSecEx.service;

import com.java.SpringSecEx.model.UserPrincipal;
import com.java.SpringSecEx.model.Users;
import com.java.SpringSecEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Users users= repo.findByUsername(username);

        if(users==null)
        {
            System.out.println("User not Found");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(users);
    }
}
