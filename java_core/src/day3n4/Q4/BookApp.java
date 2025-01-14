package day3n4.Q4;


import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class BookApp {


    public static void purchaseBook(Book book,int noOfCopies, LinkedList<Book> bookList) {
        while (noOfCopies > 0) {
            bookList.add(book);
            noOfCopies--;
        }
    }

    public static void sellBook(String ISBN, int noOfCopies, LinkedList<Book> bookList) throws InSufficientBooksException {
        Iterator<Book> itr = bookList.iterator();
        int i=0;
        while (itr.hasNext()) {
            Book book = itr.next();
            if (book.ISBN.equals(ISBN)) {
                itr.remove();
                i++;
                if (i == noOfCopies) {
                    break;
                }
            }
        }

        if (i < noOfCopies) {
            throw new InSufficientBooksException("Book not found");
        }
    }

    public Book searchBook(int id, LinkedList<Book> bookList) {
        for (Book book : bookList) {
            if (book.id == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) throws InSufficientBooksException {
        LinkedList<Book> bookList = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\day3n4\\Q4\\books.txt"));) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(":");
                Book book = new Book(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                bookList.add(book);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        sellBook("A234", 1, bookList);
        Book book2 = new Book(1,"Z234","spring","me",222);
        purchaseBook(book2,2,bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
