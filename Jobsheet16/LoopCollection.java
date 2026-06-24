package Jobsheet16;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LoopCollection {
    public static void main(String[] args) {
        Stack<String> fruits = new Stack<>();

        fruits.push("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Leci");
        fruits.add("Salak");

        // mengganti elemen terakhir menjadi Strawberry
        fruits.set(fruits.size() - 1, "Strawberry");

        // menambahkan 3 buah baru
        fruits.add("Mango");
        fruits.add("Guava");
        fruits.add("Avocado");

        // sorting A-Z
        Collections.sort(fruits);

        System.out.println("Hasil Sorting:");
        System.out.println(fruits);


        for (String fruit : fruits) {
            System.out.printf("%s ", fruit);
        }

        System.out.println("\n" + fruits.toString());

        while (!fruits.empty()) {
            System.out.printf("%s ", fruits.pop());
        }

        System.out.println("");

        for (Iterator<String> it = fruits.iterator(); it.hasNext();) {
            String fruit = it.next();
            System.out.printf("%s ", fruit);
        }

        System.out.println("");

        fruits.stream().forEach((e) -> {
            System.out.printf("%s ", e);
        });

        System.out.println("");

        for (int i = 0; i < fruits.size(); i++) {
            System.out.printf("%s ", fruits.get(i));  
        }
    } 
}
