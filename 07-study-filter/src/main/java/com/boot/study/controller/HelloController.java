package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	private static final Logger log=LoggerFactory.getLogger(HelloController.class);
	@GetMapping
	public String hello(String name) {
		log.debug("debug");
		log.info("info");
		log.error("error");
		return "hello world";
	}

	
}
