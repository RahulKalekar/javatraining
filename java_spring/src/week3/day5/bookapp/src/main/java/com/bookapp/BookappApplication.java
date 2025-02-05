package com.bookapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class BookappApplication implements CommandLineRunner {
	//to make war file we need to 1. add dependecy
	//2. extend SpringBootServletInitializer
	//3. create war file by "mvn clean package"
	//4.save war file (present in target folder) to webapps in tomcat
	//5. run tomcat
	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-----------------Started----------------");
	}
}
