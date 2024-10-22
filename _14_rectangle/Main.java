package _14_rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 5);
        Rectangle rect = new Rectangle(p1, p2);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Get Top Left Point");
            System.out.println("2. Get Bottom Right Point");
            System.out.println("3. Set Top Left Point");
            System.out.println("4. Set Bottom Right Point");
            System.out.println("5. Get Height");
            System.out.println("6. Get Width");
            System.out.println("7. Get Perimeter");
            System.out.println("8. Get Area");
            System.out.println("9. Get Diagonal");
            System.out.println("10. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Top Left Point: (" + rect.getTopLeft().getX() + ", " + rect.getTopLeft().getY() + ")");
                    break;
                case 2:
                    System.out.println("Bottom Right Point: (" + rect.getBottomRight().getX() + ", " + rect.getBottomRight().getY() + ")");
                    break;
                case 3:
                    System.out.println("Enter new Top Left Point (x y): ");
                    int x1 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    rect.setTopLeft(new Point(x1, y1));
                    break;
                case 4:
                    System.out.println("Enter new Bottom Right Point (x y): ");
                    int x2 = scanner.nextInt();
                    int y2 = scanner.nextInt();
                    rect.setBottomRight(new Point(x2, y2));
                    break;
                case 5:
                    System.out.println("Height: " + rect.getHeight());
                    break;
                case 6:
                    System.out.println("Width: " + rect.getWidth());
                    break;
                case 7:
                    System.out.println("Perimeter: " + rect.getPerimeter());
                    break;
                case 8:
                    System.out.println("Area: " + rect.getArea());
                    break;
                case 9:
                    System.out.println("Diagonal: " + rect.getDiagonal());
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}