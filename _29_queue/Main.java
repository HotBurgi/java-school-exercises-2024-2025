package _29_queue;

import java.util.HashMap;
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
            System.out.println("Supermarket Queue System");
            System.out.println("1. Add Person to Queue");
            System.out.println("2. Peek the Queue");
            System.out.println("3. Remove Person from Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number of items in shopping list: ");
                    int itemCount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    HashMap<Integer, String> shoppingList = new HashMap<>();
                    for (int i = 0; i < itemCount; i++) {
                        System.out.print("Enter item name: ");
                        String item = scanner.nextLine();
                        System.out.print("Enter item price: ");
                        int price = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        shoppingList.put(price, item);
                    }
                    Person person = new Person(name, shoppingList);
                    supermarket.addToQueue(person);
                    System.out.println("Person added to queue.");
                    break;
                case 2:
                    Person peekedPerson = supermarket.peekTheQueue();
                    if (peekedPerson != null) {
                        System.out.println("Person at the front of the queue: " + peekedPerson.getName());
                    } else {
                        System.out.println("The queue is empty.");
                    }
                    break;
                case 3:
                    Person removedPerson = supermarket.removeFromQueue();
                    if (removedPerson != null) {
                        System.out.println("Removed person from queue: " + removedPerson.getName());
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