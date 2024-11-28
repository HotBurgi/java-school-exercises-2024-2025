package _20_lab_tools;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tools[] inventory = new Tools[100];
        int stack = 0, pick;

        do {
            System.out.println("menu");
            System.out.println("1. Add tool");
            System.out.println("2. Show tools");
            System.out.println("0. Exit");
            pick = sc.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Enter code: ");
                    int code = sc.nextInt();
                    System.out.println("Enter description: ");
                    String description = sc.next();
                    System.out.println("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.println("Enter aquisition date (year): ");
                    int year = sc.nextInt();
                    System.out.println("Enter aquisition date (month): ");
                    int month = sc.nextInt();
                    System.out.println("Enter aquisition date (day): ");
                    int day = sc.nextInt();
                    LocalDate aquisitionDate = LocalDate.of(year, month, day);
                    System.out.println("Enter warrenty (years): ");
                    int warrenty = sc.nextInt();
                    inventory[stack] = new Tools(code, description, price, aquisitionDate, warrenty);
                    stack++;
                    break;
                case 2:
                    for (int i = 0; i < stack; i++) {
                        System.out.println(inventory[i].toString());
                    }
                    break;
                case 3:
                    System.out.println("Enter tool code: ");
                    int toolCode = sc.nextInt();
                    for (int i = 0; i < stack; i++) {
                        if (inventory[i].getCode() == toolCode) {
                            for (int j = i; j < stack - 1; j++) {
                                inventory[j] = inventory[j + 1];
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the description of the tool you want to search: ");
                    String search = sc.next();
                    for (int i = 0; i < stack; i++) {
                        if (inventory[i].getDescription().contains(search)) {
                            System.out.println(inventory[i].toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter the first year: ");
                    int firstYear = sc.nextInt();
                    System.out.println("Enter the second year: ");
                    int secondYear = sc.nextInt();

                    while (firstYear > secondYear) {
                        System.out.println("The first year must be lower than the second year");
                        System.out.println("Enter the first year: ");
                        firstYear = sc.nextInt();
                        System.out.println("Enter the second year: ");
                        secondYear = sc.nextInt();
                    }
                    int totalPrice = 0;
                    for (int i = 0; i < stack; i++) {
                        if (inventory[i].getAquisitionDate().getYear() >= firstYear && inventory[i].getAquisitionDate().getYear() <= secondYear) {
                            totalPrice += (int) inventory[i].getPrice();
                        }
                    }
                    System.out.println("The total price of the tools bought between " + firstYear + " and " + secondYear + " is " + totalPrice + "€");
                    break;
                case 6:
                    System.out.println("Elements in warrenty: ");
                    for (int i = 0; i < stack; i++) {
                        if (inventory[i].getAquisitionDate().getYear() + inventory[i].getWarrenty() >= LocalDate.now().getYear()) {
                            System.out.println(inventory[i].toString());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }


        } while (pick != 0);
    }
}
