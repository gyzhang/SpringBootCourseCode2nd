package com.example.auto.service;

import com.example.auto.entity.User;
import com.example.auto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User selectUser(int id){
        return userMapper.selectUser(id);
    }

}
