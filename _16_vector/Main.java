package _16_vector;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector vector = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Vector");
            System.out.println("2. Display Vector Length");
            System.out.println("3. Check Vector Equality");
            System.out.println("4. Print Vector");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter x0: ");
                    double x0 = scanner.nextDouble();
                    System.out.print("Enter y0: ");
                    double y0 = scanner.nextDouble();
                    System.out.print("Enter x1: ");
                    double x1 = scanner.nextDouble();
                    System.out.print("Enter y1: ");
                    double y1 = scanner.nextDouble();
                    vector = new Vector(new Point(x0, y0), new Point(x1, y1));
                    System.out.println("Vector created.");
                    break;
                case 2:
                    if (vector != null) {
                        System.out.println("Vector length: " + vector.length());
                    } else {
                        System.out.println("No vector created yet.");
                    }
                    break;
                case 3:
                    if (vector != null) {
                        System.out.print("Enter x0 for comparison vector: ");
                        double cx0 = scanner.nextDouble();
                        System.out.print("Enter y0 for comparison vector: ");
                        double cy0 = scanner.nextDouble();
                        System.out.print("Enter x1 for comparison vector: ");
                        double cx1 = scanner.nextDouble();
                        System.out.print("Enter y1 for comparison vector: ");
                        double cy1 = scanner.nextDouble();
                        Vector comparisonVector = new Vector(new Point(cx0, cy0), new Point(cx1, cy1));
                        System.out.println("Vectors are equal: " + vector.isEqual(comparisonVector));
                    } else {
                        System.out.println("No vector created yet.");
                    }
                    break;
                case 4:
                    if (vector != null) {
                        System.out.println(vector);
                    } else {
                        System.out.println("No vector created yet.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}