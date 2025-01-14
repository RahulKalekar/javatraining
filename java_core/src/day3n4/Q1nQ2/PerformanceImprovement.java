package day3n4.Q1nQ2;

import java.io.*;

public class PerformanceImprovement {
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        FavoritePlayerWithBufferedInput();
        double end = System.currentTimeMillis();
        System.out.println("Time taken for BufferedInput: "+(end - start));

        start = System.currentTimeMillis();
        FavoritePlayerWithoutBufferedInput();
        end = System.currentTimeMillis();
        System.out.println("Time taken without BufferedInput: "+(end - start));
    }

    public static void FavoritePlayerWithBufferedInput() {
        try (BufferedInputStream br = new BufferedInputStream(new FileInputStream("src\\day3n4\\Q1nQ2\\sachin.jpg"));
             BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("src\\day3n4\\Q1nQ2\\copiedBufferedInputStream.jpg"))){

            int bytesRead;
            while ((bytesRead = br.read()) != -1) {
                bw.write(bytesRead);
            }

        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void FavoritePlayerWithoutBufferedInput(){
        try (FileInputStream br = new FileInputStream("src\\day3n4\\Q1nQ2\\sachin.jpg");
             FileOutputStream bw = new FileOutputStream("src\\day3n4\\Q1nQ2\\copiedBufferedInputStream.jpg")){

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
