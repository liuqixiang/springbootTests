package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.model.MyConfig;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private MyConfig myConfig;
	@GetMapping
	public MyConfig hello() {
		return myConfig;
	}

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "小威老师");
		map.put("age", 18);

		return map;
	}
}
