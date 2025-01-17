package _28_masked_party;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManagement {
    private static final String filePath = "kindle.txt";

    public static void saveToFile(InviteList inviteList) {
        // Save the object to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : inviteList.getInvites()) {
                writer.write(student.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readFromFile() {
        ArrayList<Student> students = new ArrayList<>();
        // Read the Kindle object from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] studentData;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                studentData = line.split(";");
                Student student = new Student(studentData[0], LocalDate.parse(studentData[1]), studentData[2], studentData[3].charAt(0));
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
