package com.balu.jwtAuthentication.controller;

import com.balu.jwtAuthentication.model.Users;
import com.balu.jwtAuthentication.repository.UserRepo;
import com.balu.jwtAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo repo;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
      return userService.verify(user);
    }


    @GetMapping("/get")
    public List<Users> getUsers(){
        return repo.findAll();
    }

    @GetMapping("/list")
    public String getString(){
        return "get Users....!";
    }
}
