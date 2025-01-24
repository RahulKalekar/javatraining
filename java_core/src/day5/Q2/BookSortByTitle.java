package day5.Q2;


import java.util.Comparator;
import java.util.List;

public class BookSortByTitle implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
