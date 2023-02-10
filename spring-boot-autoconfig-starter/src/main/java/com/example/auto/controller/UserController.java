package com.example.auto.controller;

import com.example.auto.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auto.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @RequestMapping("get/{id}")
    public User getUserById(@PathVariable int id){
        return userService.selectById(id);
    }

    @RequestMapping("get/all")
    public List<User> getAllUsers(){
        return userService.selectAll();
    }
}
