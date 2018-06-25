package com.biandan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.biandan.dao.UserMapper;
import com.biandan.entity.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	//@Cacheable(value = "names", key = "'names:' + #name")
	@Cacheable(value = "user", key = "'user:id:' + '04'")
	public User selectById(){
		System.out.println("我进来了");
		return userMapper.selectByPrimaryKey("02");
	}
	public List<User> selectAll(){
		return userMapper.selectAll();
	}
	
}
