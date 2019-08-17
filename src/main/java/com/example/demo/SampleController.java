package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	private SampleDockerDao dockerDao;
	
	@Autowired
	private SampleDockerConstants dockerConstants;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello From Docker Container";
	}
	
	@GetMapping("/redis/get")
	public String fetchFromRedis() {
		return dockerDao.fetchValue(dockerConstants.getRedisKey());
	}
	
	@PostMapping("/redis/insert/value/{value}")
	public void insertValue(@PathVariable("value")String value) {
		dockerDao.insertValue(dockerConstants.getRedisKey(), value);
	}

}
