package com.sh.guessgame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@MapperScan(basePackages="com.sh.guessgame.mybatis.mapper")
@EnableCaching
@EnableScheduling
public class GuessgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessgameApplication.class, args);
	}
}
