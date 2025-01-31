package com.bank;

import com.bank.dao.AccountDao;
import com.bank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.math.BigDecimal;
import java.math.BigDecimal;
@EnableAspectJAutoProxy
@SpringBootApplication

public class BankApplication implements CommandLineRunner {
	@Autowired
	private AccountDao accountDao;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//accountDao.save(new Account("Rahul", 1000.00));
		System.out.println("----------------------Added--------------------------");
		//accountDao.save(new Account("Rohan", 2000.00));
		System.out.println("----------------------Added--------------------------");
	}
}
