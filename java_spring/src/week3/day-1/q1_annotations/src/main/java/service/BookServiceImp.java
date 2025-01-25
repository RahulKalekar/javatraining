package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.*;

import java.util.*;
@Service    //needed for di using annotations which helps in scanning
public  class BookServiceImp implements BookService {

    //BAD CODE HARD CODING....

    //private BookDao dao=new BookDaoImp();
    //No need to create dao object by self just declare it
    //after declaring create a setter which we have to specify in the bean file.

    // for annotations di we must use @Autowired
    @Autowired
    private BookDao dao;
    public void setDao(BookDao dao){
        this.dao=dao;
    }
    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

}
