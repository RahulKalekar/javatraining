package lab_exams.lab1;

import java.util.ArrayList;
import java.util.Comparator;

public class MerchandiseSorter {

    public static void sortByItemCode(ArrayList<Merchandise> merchandiseList) {
        merchandiseList.sort(new Comparator<Merchandise>() {
            public int compare(Merchandise m1, Merchandise m2) {
                return m1.getItemCode().compareTo(m2.getItemCode());
            }
        });
    }

    public static void sortByPriceDescending(ArrayList<Merchandise> merchandiseList) {
        merchandiseList.sort(new Comparator<Merchandise>() {
            public int compare(Merchandise m1, Merchandise m2) {
                return Double.compare(m2.getUnitPrice(), m1.getUnitPrice());
            }
        });
    }
}
