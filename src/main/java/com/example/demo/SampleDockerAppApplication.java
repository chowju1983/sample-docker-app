package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class SampleDockerAppApplication {
	
	@Autowired
	private SampleDockerConstants constants;
	
	@Bean
	   public RedisConnectionFactory redisConnectionFactory() {
		LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
		connectionFactory.setHostName(constants.getHost());
		return connectionFactory;
	   }
	
	   @Bean
	   public StringRedisTemplate redisTemplate() {
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
	   }

	public static void main(String[] args) {
		SpringApplication.run(SampleDockerAppApplication.class, args);
	}


}
