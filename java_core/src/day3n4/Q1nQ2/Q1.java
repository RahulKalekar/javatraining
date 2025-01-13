package day3n4.Q1nQ2;
import java.io.*;

public class Q1 {

    public static void main(String[] args) {
        try (FileInputStream br = new FileInputStream("src\\day3\\Q1\\sachin.jpg");
             FileOutputStream bw = new FileOutputStream("src\\day3\\Q1\\copiedFileInputStream.jpg")) {

            int bytesRead;
            while ((bytesRead = br.read()) != -1) {
                bw.write(bytesRead);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
