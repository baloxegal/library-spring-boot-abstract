package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
//@ComponentScan({"controllers", "services"})
//@EntityScan("domain")
//@EnableJpaRepositories("db")
public class LibrarySpringBootAplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringBootAplication.class, args);
	}

}
