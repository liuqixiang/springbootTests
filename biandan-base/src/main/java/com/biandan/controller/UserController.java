package com.biandan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biandan.entity.User;
import com.biandan.service.UserService;
import com.biandan.util.DateAndTimeUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	@ApiOperation(value = "根据id查找user")
	public User getById(){
		return userService.selectById();
	}
	
	@GetMapping("getDate")
	@ApiOperation(value = "日期转换测试")
	public String getDate(Date date,@ApiParam(value = "用户id") String uid){
		System.out.println(DateAndTimeUtil.dateFormat(date)+"::::"+uid);
		return "1";
	}
	@GetMapping("selectAll")
	@ApiOperation(value = "获取所有user")
	public List<User> selectAll(){
		PageHelper.orderBy("uid desc");// 排序
		Page<User> page = PageHelper.startPage(1,2);
		List<User> list = userService.selectAll();
		return list;
	}
}
