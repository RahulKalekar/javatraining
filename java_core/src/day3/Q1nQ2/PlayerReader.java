package day3.Q1nQ2;

import java.io.FileReader;
import java.io.FileWriter;

public class PlayerReader {
    public static void main(String[] args) {
        try (FileReader br = new FileReader("src\\day3\\Q1\\sachin.jpg");
             FileWriter bw = new FileWriter("src\\day3\\Q1\\copiedFileReader.jpg")) {

            int character;
            while ((character = br.read()) != -1) {
                bw.write(character);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}