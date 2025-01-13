package day3.Q1nQ2;

import java.io.*;

public class PerformanceImprovement {
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        a2FavoritePlayerWithBufferedInput();
        double end = System.currentTimeMillis();
        System.out.println("Time taken for BufferedInput: "+(end - start));

        start = System.currentTimeMillis();
        a2FavoritePlayerWithoutBufferedInput();
        end = System.currentTimeMillis();
        System.out.println("Time taken without BufferedInput: "+(end - start));
    }

    public static void a2FavoritePlayerWithBufferedInput() {
        try (BufferedInputStream br = new BufferedInputStream(new FileInputStream("src\\day3\\favorite_player.jpg"));
             BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("src\\day3\\favoritePlayer_using_BufferedInputStream.jpg"))){

            int bytesRead;
            while ((bytesRead = br.read()) != -1) {
                bw.write(bytesRead);
            }

        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void a2FavoritePlayerWithoutBufferedInput(){
        try (FileInputStream br = new FileInputStream("src\\day3\\Q1\\sachin.jpg");
             FileOutputStream bw = new FileOutputStream("src\\day3\\Q1\\scopiedBufferedInputStream.jpg")){

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
