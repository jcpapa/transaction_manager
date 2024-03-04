package com.exam.tech.reevo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.exam.tech.revo.*"})
@ComponentScan(basePackages = {"com.exam.tech.revo"})
@EnableJpaRepositories(basePackages = {"com.exam.tech.revo"})
public class ReevoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReevoApplication.class, args);
	}

}
