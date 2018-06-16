package com.boot.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdbcService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void save() {
		jdbcTemplate.update("insert into t_test(name) values(?)", "test1");
		System.out.println(1 / 0);
		jdbcTemplate.update("insert into t_test(name) values(?)", "test2");
	}
}
