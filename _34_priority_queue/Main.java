package _34_priority_queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cpu cpu = new Cpu();
        Task task = new Task();

        int pick;

        while (true) {
            System.out.println("1. Add task\n2. Visualize tasks\n3. Exit");
            pick = scanner.nextInt();
            switch (pick) {
                case 1:
                    cpu.addTask(task);
                    break;
                case 2:
                    cpu.visualizeTasks();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
