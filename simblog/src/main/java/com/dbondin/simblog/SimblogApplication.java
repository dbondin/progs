package com.dbondin.simblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dbondin.simblog.jwt.JwtTokenUtil;

@SpringBootApplication
public class SimblogApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(SimblogApplication.class, args);
		
		//System.out.println(ctx.getBean(JwtTokenUtil.class).getUsernameFromToken(""));
	}

}
