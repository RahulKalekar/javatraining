package com.productapp.config;//package com.productapp.config;
//
//import com.productapp.repo.ProductRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@SpringBootApplication
//@ComponentScan(basePackages = "com.productapp")
//@EntityScan(basePackages = "com.productapp.entites")
//@EnableJpaRepositories(basePackages = "com.productapp.repo")
//public class Productapp01Application implements CommandLineRunner {
//
//	@Autowired
//	private ProductRepo productRepo;
//
//	public static void main(String[] args) {
//		SpringApplication.run(Productapp01Application.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
////		productRepo.save(new Product("laptop",  BigDecimal.valueOf(10000.00)));
////		productRepo.save(new Product("table",  BigDecimal.valueOf(4000.00)));
////		System.out.println("----------product is added------");
//	}
//}
///*
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public static void main(String[] args) {
//		SpringApplication.run(Productapp01Application.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		if(dataSource!=null) {
//			System.out.println("ds is configre :)");
//		}
//		if(jdbcTemplate!=null) {
//			System.out.println("jdbcTemplate is configre :)");
//		}
//	}
// */