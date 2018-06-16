package com.boot.study.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.service.AsyncService;

@RestController
@RequestMapping("/hello")
public class HelloController {

	private ExecutorService service = Executors.newFixedThreadPool(10);

	@Autowired
	private AsyncService asyncService;

	@GetMapping
	public String hello() {
//		service.execute(new Runnable() {
//
//			@Override
//			public void run() {
//				try {
//					TimeUnit.SECONDS.sleep(3);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//				System.out.println("我醒了");
//			}
//		});

		asyncService.hello();
		asyncService.hello1();

		return "hello world";
	}

	@Autowired
	private TaskExecutor taskExecutor;

	@GetMapping("/map")
	public Map<String, Object> map() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "小威老师");
		map.put("age", 18);

		taskExecutor.execute(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("我醒了22");
			}
		});

		return map;
	}
}
