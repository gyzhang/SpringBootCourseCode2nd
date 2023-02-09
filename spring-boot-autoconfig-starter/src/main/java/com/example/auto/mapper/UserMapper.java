package com.example.auto.mapper;

import org.springframework.stereotype.Repository;

import com.example.auto.entity.User;

@Repository
public interface UserMapper {

	User selectUser(int id);
}
