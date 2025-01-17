package _29_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Person> queue = new LinkedList<>();
        Supermarket supermarket = new Supermarket(queue);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Supermarket Queue Management");
            System.out.println("1. Add to Queue");
            System.out.println("2. Peek the Queue");
            System.out.println("3. Remove from Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter shopping list items (comma separated): ");
                    String[] items = scanner.nextLine().split(",");
                    ArrayList<String> shoppingList = new ArrayList<>();
                    for (String item : items) {
                        shoppingList.add(item.trim());
                    }
                    Person person = new Person(name, shoppingList);
                    supermarket.addToQueue(person);
                    System.out.println("Person added to the queue.");
                    break;
                case 2:
                    Person peekedPerson = supermarket.peekTheQueue();
                    if (peekedPerson != null) {
                        System.out.println("First person in the queue: " + peekedPerson.getName());
                    } else {
                        System.out.println("The queue is empty.");
                    }
                    break;
                case 3:
                    Person removedPerson = supermarket.removeFromQueue();
                    if (removedPerson != null) {
                        System.out.println("Removed person from the queue: " + removedPerson.getName());
                    } else {
                        System.out.println("The queue is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}