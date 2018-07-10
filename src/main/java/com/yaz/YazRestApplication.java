package com.yaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yaz")
public class YazRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(YazRestApplication.class, args);
	}
}
