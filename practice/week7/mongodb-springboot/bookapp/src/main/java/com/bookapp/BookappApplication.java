package com.bookapp;

import com.bookapp.entities.Book;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.function.Supplier;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner {

//	@Autowired
//	private MongoTemplate mongoTemplate;
	@Autowired
	private BookRepository bookRepository;
	public static void main(String[] args)  {
		SpringApplication.run(BookappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(bookRepository!=null){
			System.out.println("bookRepository is not null");
		}
		//insertAllRecords();
		//printAll();
		//findById();
		//updateById();
		//deleteById();
		//findByNameAndAuthor();
		//findByNameOrAuthor();
	}
	private void findByNameOrAuthor() {
		bookRepository.findByNameOrAuthor("algebra", "gunika").forEach(System.out::println);
	}
	private void findByNameAndAuthor() {
		bookRepository.findByNameAndAuthor("algebra", "gunika").forEach(System.out::println);
	}
	private void deleteById() {
		bookRepository.deleteById("67b2caa3c109ec0b6bbfbd94");
	}

	private void updateById() {
		bookRepository.findById("67b2caa3c109ec0b6bbfbd94").ifPresent((book)->{
			book.setPages(500);
			book.setCost(900.0);
			bookRepository.save(book);
		});
	}
	private void findById() {
		Book book = bookRepository.findById("67b2caa3c109ec0b6bbfbd94").orElseThrow(()->new BookNotFoundException("book not found"));
		System.out.println(book);
	}

	private void printAll() {
		List<Book> books = bookRepository.findAll();
		books.forEach(System.out::println);
	}

	private void insertAllRecords() {
		bookRepository.save(new Book("algebra", 300, "gunika", 900.0));
		bookRepository.save(new Book("adv maths", 300, "ektga", 500.0));
		bookRepository.save(new Book("spring boot", 300, "raj", 700.0));
		bookRepository.save(new Book("python adv", 200, "raj", 600.0));
	}
}
