package _15_coordinates;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point longitude = new Point(1, 2, 3);
        Point latitude = new Point(45, 2, 3);
        Coordinate coordinate = new Coordinate(longitude, latitude);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Get Longitude");
            System.out.println("2. Get Latitude");
            System.out.println("3. Get Time");
            System.out.println("4. Set Longitude");
            System.out.println("5. Set Latitude");
            System.out.println("6. Set Time");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Longitude: " + coordinate.getLongitude());
                    break;
                case 2:
                    System.out.println("Latitude: " + coordinate.getLatitude());
                    break;
                case 3:
                    System.out.println("Time: " + coordinate.getTime());
                    break;
                case 4:
                    System.out.println("Enter new Longitude (g p s): ");
                    int g1 = scanner.nextInt();
                    int p1 = scanner.nextInt();
                    int s1 = scanner.nextInt();
                    try {
                        coordinate.setLongitude(new Point(g1, p1, s1));
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter new Latitude (g p s): ");
                    int g2 = scanner.nextInt();
                    int p2 = scanner.nextInt();
                    int s2 = scanner.nextInt();
                    try {
                        coordinate.setLatitude(new Point(g2, p2, s2));
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    coordinate.setTime();
                    System.out.println("Time updated to: " + coordinate.getTime());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}