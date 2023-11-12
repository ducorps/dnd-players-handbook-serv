package com.handbook.handbookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@SpringBootApplication
public class HandbookapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(HandbookapiApplication.class, args);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());

		return template;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
		redisConfig.setHostName("rediss://red-cl8iffqvokcc73b03r6g:Lb7P4yZDIrqB24ZzMqdMtX9COgNA9l8O@oregon-redis.render.com:6379");
		redisConfig.setPort(6379);
		redisConfig.setPassword("Lb7P4yZDIrqB24ZzMqdMtX9COgNA9l8O");
		redisConfig.setUsername("red-cl8iffqvokcc73b03r6g");
		JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfig = JedisClientConfiguration.builder();
		jedisClientConfig.connectTimeout(Duration.ofSeconds(60));
		jedisClientConfig.useSsl();

		return new JedisConnectionFactory(redisConfig, jedisClientConfig.build());
	}
}
