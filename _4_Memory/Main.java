package _4_Memory;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int SIZE = 4;

    public static void setup(char[][] cards, char[] animals, boolean[][] parallel){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cards[i][j] = animals[i % SIZE];
                parallel[i][j] = false;
            }
        }
        shuffle(cards);
    }

    public static void shuffle(char[][] letters) {
        Random random = new Random();
        int x1, y1, x2, y2;
        char temp;
        for (int i = 0; i < 100; i++) {
            x1 = random.nextInt(SIZE);
            x2 = random.nextInt(SIZE);
            y1 = random.nextInt(SIZE);
            y2 = random.nextInt(SIZE);

            temp = letters[x1][y1];
            letters[x1][y1] = letters[x2][y2];
            letters[x2][y2] = temp;
        }
    }

    public static void printCards(char[][] cards, boolean[][] parallel) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (parallel[i][j]) {
                    System.out.print(cards[i][j] + "\t");
                } else {
                    System.out.print("*" + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void pickCard(char[][] cards, boolean[][] parallel) {
        int pickedRow, pickedCol;
        int pickedRow2, pickedCol2;

        Scanner input = new Scanner(System.in);

        do {
            printCards(cards, parallel);
            System.out.println("Please enter the row number (0 - 7): ");
            pickedRow = input.nextInt();
            System.out.println("Please enter the column number (0 - 7): ");
            pickedCol = input.nextInt();
        } while (pickedRow > SIZE || pickedRow < 0 || pickedCol > SIZE || pickedCol < 0);

        parallel[pickedRow][pickedCol] = true;
        printCards(cards, parallel);

        do {
            printCards(cards, parallel);
            System.out.println("Please enter the row2 number (0 - 7): ");
            pickedRow2 = input.nextInt();
            System.out.println("Please enter the column2 number (0 - 7): ");
            pickedCol2 = input.nextInt();
        } while (pickedRow2 > SIZE || pickedRow2 < 0 || pickedCol2 > SIZE || pickedCol2 < 0);

        parallel[pickedRow2][pickedCol2] = true;
        printCards(cards, parallel);

        if (cards[pickedRow][pickedCol] == cards[pickedRow2][pickedCol2]) {
            parallel[pickedRow][pickedCol] = true;
            parallel[pickedRow2][pickedCol2] = true;
            System.out.println("Cards match!");
        } else {
            parallel[pickedRow][pickedCol] = false;
            parallel[pickedRow2][pickedCol2] = false;
            System.out.println("Cards do not match!");
        }
    }

    public static boolean checkGameEnd (boolean[][] parallel) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!parallel[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] animals = {'H', 'D', 'C', 'M', 'L', 'S', 'E', 'F'};
        char[][] cards = new char[SIZE][SIZE];
        boolean[][] parallel = new boolean[SIZE][SIZE];
        int pick;
        setup(cards, animals, parallel);

        do{
            if (checkGameEnd (parallel)){
                System.out.println("Game Over!");
                break;
            }

            System.out.println("1. pick cards\n2. print\n0. exit");
            pick = input.nextInt();

            switch (pick){
                case 1:
                    pickCard(cards, parallel);
                    break;
                case 2:
                    printCards(cards, parallel);
                    break;
            }
        }while (pick != 0);

    }
}