package com.boot.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.service.JdbcService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private JdbcService jdbcService;

	@GetMapping
	public List<Map<String, Object>> hello() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_test t");
		return list;
	}

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "小威老师");
		map.put("age", 18);

		jdbcService.save();

		return map;
	}
}
