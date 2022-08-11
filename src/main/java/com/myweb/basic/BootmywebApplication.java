package com.myweb.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //entity listener를 활성화시키기 위한 선언
@SpringBootApplication
public class BootmywebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootmywebApplication.class, args);
	}

}
