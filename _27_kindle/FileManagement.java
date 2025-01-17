package _27_kindle;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileManagement {
    private static final String filePath = "kindle.txt";

    public static void saveToFile(Kindle kindle) {
        // Save the Kindle object to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : kindle.map.values()) {
                writer.write(book.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Book> readFromFile() {
        Map<Integer, Book> map = new HashMap<>();
        // Read the Kindle object from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] bookData;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                bookData = line.split(";");
                Book book = new Book(bookData[0], bookData[1], bookData[2], Integer.parseInt(bookData[3]), Integer.parseInt(bookData[4]));
                map.put(book.getISBN(), book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
