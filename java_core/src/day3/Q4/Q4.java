package day3.Q4;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.lang.Integer;

public class Q4 {
    public static void main(String[] args) {
        ArrayList<Book> books=new ArrayList<>();
        String line;
        try(BufferedReader br=new BufferedReader(new FileReader(new File("details.txt")))){
            while ((line=br.readLine())!=null){
                String tokens[]=line.split(":");
                books.add(new Book(Integer.parseInt(tokens[0]),
                        tokens[1],
                        tokens[2],
                        tokens[3],
                        Integer.parseInt(tokens[4])));

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for(Book book: books){
            System.out.println(book);
        }

    }

}
