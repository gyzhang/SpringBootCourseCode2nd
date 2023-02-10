package com.example.auto.mapper;

import org.springframework.stereotype.Repository;

import com.example.auto.entity.User;

import java.util.List;

@Repository
public interface UserMapper {

	User selectById(int id);
	List<User> selectAll();

}
