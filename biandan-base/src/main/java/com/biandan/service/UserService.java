package com.biandan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biandan.dao.UserMapper;
import com.biandan.entity.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User selectById(){
		return userMapper.selectByPrimaryKey("02");
	}
	public List<User> selectAll(){
		return userMapper.selectAll();
	}
	
}
