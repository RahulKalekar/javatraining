package day5.Q3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src\\day5\\Q3\\data.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                doubles.add(Double.parseDouble(line));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        Collections.sort(doubles);
        System.out.println(doubles.get(doubles.size() - 1));
    }
}