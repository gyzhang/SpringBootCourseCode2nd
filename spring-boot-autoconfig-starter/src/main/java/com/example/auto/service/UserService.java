package com.example.auto.service;

import com.example.auto.entity.User;
import com.example.auto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User selectById(int id){
        return userMapper.selectById(id);
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}
