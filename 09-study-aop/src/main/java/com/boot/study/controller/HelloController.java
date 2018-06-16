package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello(String name) {
		return "hello world";
	}

	@GetMapping(value = "/map")
	public Map<String, Object> map(String aaa) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "小威老师");
		map.put("age", 18);

		return map;
	}
}
