package com.balu.jwtAuthentication.service;

//import com.balu.jwtAuthentication.Security.JwtService;
import com.balu.jwtAuthentication.model.Users;
import com.balu.jwtAuthentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user);
    }

//    public String verify(Users user) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//        if (authentication.isAuthenticated()){
//            return jwtService.generateToken(user.getUsername());
//        } else {
//            return "fail";
//        }
//    }
}
