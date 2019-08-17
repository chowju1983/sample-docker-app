package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDockerDao {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public void insertValue(String key,String value) {
		redisTemplate.opsForValue().set(key, value);
	}
	
	public String fetchValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
}
