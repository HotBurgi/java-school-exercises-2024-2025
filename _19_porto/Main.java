package _19_porto;

import java.util.Scanner;

public class Main {
    public static int getDockPosition(Boat boat) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pick = 0;
        Boat[] dock = new Boat[100];

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("0. Esci");
            System.out.println("1. Inserisci barca");

            switch (pick) {
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;

                case 1:
                    System.out.print("Inserisci il nome della barca: ");
                    String name = scanner.nextLine();
                    System.out.print("Inserisci la nazione della barca: ");
                    String nation = scanner.nextLine();
                    System.out.print("Inserisci la lunghezza della barca: ");
                    int length = scanner.nextInt();
                    System.out.print("Inserisci la larghezza della barca: ");
                    int beam = scanner.nextInt();
                    System.out.print("Inserisci il tipo di barca (1 = vela, 2 = motore): ");
                    int type = scanner.nextInt();
                    Boat boat = new Boat(name, nation, length, beam, type);
                    dock[getDockPosition(boat)] = new Boat(name, nation, length, beam, type);
                    break;
            }
        } while (pick != 0);
    }
}