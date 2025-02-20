package persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

//@Repository //needed for di using annotations which helps in scanning
public class BookDaoImp implements BookDao {

    private static final Logger logger = LogManager.getLogger(BookDaoImp.class);

    private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
    private static int counter = 0;
    static {
        booksMap.put(++counter, new Book(counter, "ABC123", "Head first Java" , "Katthy", 600));
        booksMap.put(++counter,  new Book(counter, "ABC723", "Servlet jsp Java" , "Katthy", 700));
    }

    @Override
    public List<Book> getAllBooks() {
        logger.warn("Fetching all books");
        return new ArrayList<Book>(booksMap.values());
    }

    @Override
    public Book addBook(Book book) {
        book.setId(++counter);
        booksMap.put(counter, book);
        return booksMap.get(counter);
    }

    @Override
    public void deleteBook(int id) {
        logger.warn("Deleting book with ID: {}", id);
        booksMap.remove(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        booksMap.put(id, book);
    }

    @Override
    public Book getBookById(int id) {
        logger.debug("Fetching book with ID: {}", id);
        return booksMap.get(id);
    }

}
