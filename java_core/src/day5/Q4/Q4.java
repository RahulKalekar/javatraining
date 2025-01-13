package day5.Q4;

import java.util.PriorityQueue;

public class Q4 {
    public static void main(String[] args) {
        PriorityQueue<Product> pq = new PriorityQueue<>();
        pq.add(new Product(101, "Soap", 800));
        pq.add(new Product(102, "Shampoo", 200));
        pq.add(new Product(103, "Brush", 300));
        pq.add(new Product(104, "Paste", 700));
        pq.add(new Product(105, "Mug", 900));
        while (!pq.isEmpty()) {
            Product product = pq.poll();
            System.out.println(product.getProductName() + " : " + product.getProductPrice());
        }
    }
}