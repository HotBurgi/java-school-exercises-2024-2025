package _9_Scommesse_Ippodromo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();

    final static String[] horses = {"Ettore", "Pegaso", "Fulmine", "Olimpia", "Tornado", "Vento", "Stella", "Nerone", "Galileo", "Apollo"};

    public static int[] generatePodium () {
        int winner;
        int [] podium = {-1, -1 -1};

        System.out.println("PODIUM");
        for (int i = 0; i < 3; i++) {
            winner = rand.nextInt(10);
            winner = isInPodium(podium, winner);
            podium[i] = winner;
            int toPrint = winner + 1;
            System.out.println(i+1 + " | " + toPrint + ". " + horses[winner]);
        }

        return podium;
    }

    public static int isInPodium(int[] podium, int winner) {
        while (podium[0] == winner || podium[1] == winner || podium[2] == winner) {
            winner = rand.nextInt(10);
        }

        return winner;
    }

    public static int isWin (int bet, int betType) {
        int[] podium = generatePodium();

        if (betType == 1 && podium[0] == bet) {
            System.out.println("You won 50€!");
            System.out.print("");
            return 50;
        } else if (betType == 2 && (podium[0] == bet || podium[1] == bet || podium[2] == bet)) {
            System.out.println("You won 10€!");
            System.out.print("");
            return 10;
        }

        System.out.println("You lost!");
        System.out.print("");
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int balance = 100;

        int pick, bet;
        do{
            System.out.println("1.Bet on winner\n2.Bet on position\n3.Check balance\n0.Exit");
            pick = scanner.nextInt();
            System.out.print("");

            switch(pick){
                case 1:
                    System.out.print("WINNER | 50€ | Pick a horse (1-10): ");
                    bet = scanner.nextInt() - 1;
                    balance += isWin(bet, 1) - 5;
                    break;
                case 2:
                    System.out.print("POSITION | 10€ | Pick a horse (1-10): ");
                    bet = scanner.nextInt() - 1;
                    balance += isWin(bet, 2) - 5;
                    break;
                case 3:
                    System.out.println("Your balance is: " + balance + "€");
            }
        }while (pick != 0 && balance > 5);

        if (balance < 5){
            System.out.println("Your balance is: " + balance + "€");
            System.out.println("You can no longer bet, good bye!");
        }
    }
}