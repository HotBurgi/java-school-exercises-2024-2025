package _23_array_lists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterate over the elements and print them
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // Get an element by index
        String firstFruit = list.getFirst();
        System.out.println("First fruit: " + firstFruit);

        // Remove an element by index
        list.remove(1); // Removes "Banana"

        // Print the ArrayList after removal
        System.out.println("ArrayList after removal: " + list);
    }
}