package lab_exams.lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lab1 {

    public static void main(String[] args) {
        ArrayList<Merchandise> merchandiseList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\rahul.kalekar\\OneDrive - Körber Supply Chain Software\\Desktop\\lab_assignments\\java_core\\src\\lab_exams\\lab1\\details.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                String itemCode = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double unitPrice = Double.parseDouble(parts[2]);

                merchandiseList.add(new Merchandise(itemCode, quantity, unitPrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        MerchandiseSorter.sortByItemCode(merchandiseList);

        System.out.println("Merchandise in ascending order by item codex");
        for (Merchandise merchandise : merchandiseList) {
            System.out.println(merchandise.toString());
        }

        MerchandiseSorter.sortByPriceDescending(merchandiseList);
        System.out.println("Merchandise in descending order by price");
        for (Merchandise merchandise : merchandiseList) {
            System.out.println(merchandise.toString());
        }
    }
}
