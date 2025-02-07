package _32_list;

import java.util.Scanner;

public class Main {

    // NOT WORKING

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        boolean exit = false;

        while (!exit) {
            System.out.println("Emergency Queue Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Get Max Priority Patient");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Count Patients in Queues");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient priority (RED, YELLOW, WHITE): ");
                    String priority = scanner.nextLine().toUpperCase();
                    break;
                case 2:
                    Patient maxPriorityPatient = emergencyQueue.maxPriority();
                    if (maxPriorityPatient != null) {
                        System.out.println("Max priority patient: " + maxPriorityPatient.getName());
                    } else {
                        System.out.println("No patients in the queue.");
                    }
                    break;
                case 3:
                    System.out.print("Enter patient name to search: ");
                    String searchName = scanner.nextLine();
                    Patient foundPatient = emergencyQueue.searchByName(searchName);
                    if (foundPatient != null) {
                        System.out.println("Patient found: " + foundPatient.getName());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 4:
                    emergencyQueue.count();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
