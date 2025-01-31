package com.balu.jwtAuthentication.Security;

import com.balu.jwtAuthentication.model.UserPrincipal;
import com.balu.jwtAuthentication.repository.UserRepo;
import com.balu.jwtAuthentication.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceDetails implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if (user == null){
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
