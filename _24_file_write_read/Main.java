package _24_file_write_read;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String contentToWrite = "Hello, world!";

        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(contentToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}