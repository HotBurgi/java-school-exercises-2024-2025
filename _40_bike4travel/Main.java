package _40_bike4travel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bike4travel bike4travel = new Bike4travel();
        int pick;

        do {
            System.out.println("1. Add Traveler\n2. Calculate Total\n3. Print Travelers\n0. Exit");
            pick = scanner.nextInt();

            switch (pick) {
                case 1:
                    if (!bike4travel.available()) {
                        System.out.println("Sorry, no more bikes available.");
                    }
                    System.out.println("Enter the number of days:");
                    int days = scanner.nextInt();
                    System.out.println("Choose a bike model:");
                    System.out.println("1. Mountain Bike | 2. Race Bike");
                    int bikeChoice = scanner.nextInt();
                    System.out.println("Do you need luggage? (true/false)");
                    boolean luggage = scanner.nextBoolean();

                    if (bikeChoice == 1) {
                        bike4travel.addTraveler(days, new MountainBike(luggage));
                    } else if (bikeChoice == 2) {
                        bike4travel.addTraveler(days, new RaceBike(luggage));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    System.out.println("Total amount: " + bike4travel.calculateTotal());
                    break;

                case 3:
                    bike4travel.printTravelers();
                    break;
                default:
                    if (pick != 0) {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
            }
        } while (pick != 0);
    }
}
