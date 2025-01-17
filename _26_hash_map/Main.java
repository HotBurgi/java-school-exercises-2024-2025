package _26_hash_map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Integer> map = new HashMap<>();

        // Add key-value pairs to the HashMap
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        // Retrieve a value from the HashMap
        int appleCount = map.get("apple");
        System.out.println("Apple count: " + appleCount);

        // Check if a key exists in the HashMap
        if (map.containsKey("banana")) {
            System.out.println("Banana is available.");
        }

        // Iterate over the HashMap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}