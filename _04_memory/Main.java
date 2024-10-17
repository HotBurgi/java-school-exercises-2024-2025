package _04_memory;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int SIZE = 4;

    public static void setup(char[][] cards, char[] animals, boolean[][] parallel) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cards[i][j] = animals[(i * SIZE + j) % animals.length];
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

    public static void printScores(int[] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " has " + players[i] + " points.");
        }
        System.out.println();
    }

    public static void pickCard(char[][] cards, boolean[][] parallel, int[] players, int currentPlayer) {
        Scanner input = new Scanner(System.in);

        int pickedRow, pickedCol;
        int pickedRow2, pickedCol2;

        do {
            System.out.println("Player " + (currentPlayer + 1) + ", it's your turn.");
            System.out.println("Please enter the row number (0 - 3): ");
            pickedRow = input.nextInt();
            System.out.println("Please enter the column number (0 - 3): ");
            pickedCol = input.nextInt();
        } while (pickedRow >= SIZE || pickedRow < 0 || pickedCol >= SIZE || pickedCol < 0 || parallel[pickedRow][pickedCol]);

        parallel[pickedRow][pickedCol] = true;
        printCards(cards, parallel);

        do {
            System.out.println("Please enter the second row number (0 - 3): ");
            pickedRow2 = input.nextInt();
            System.out.println("Please enter the second column number (0 - 3): ");
            pickedCol2 = input.nextInt();
        } while (pickedRow2 >= SIZE || pickedRow2 < 0 || pickedCol2 >= SIZE || pickedCol2 < 0 || parallel[pickedRow2][pickedCol2]);

        parallel[pickedRow2][pickedCol2] = true;
        printCards(cards, parallel);

        if (cards[pickedRow][pickedCol] == cards[pickedRow2][pickedCol2]) {
            System.out.println("Cards match!");
            players[currentPlayer]++;
        } else {
            System.out.println("Cards do not match!");
            parallel[pickedRow][pickedCol] = false;
            parallel[pickedRow2][pickedCol2] = false;
        }
    }

    public static boolean checkGameEnd(boolean[][] parallel) {
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

        System.out.println("Enter the number of players (1-4): ");
        int numPlayers;
        do {
            numPlayers = input.nextInt();
        } while (numPlayers < 1 || numPlayers > 4);

        int[] players = new int[numPlayers];
        setup(cards, animals, parallel);

        int currentPlayer = 0;

        do {
            if (checkGameEnd(parallel)) {
                System.out.println("Game Over!");
                if (numPlayers == 1) {
                    System.out.println("You found " + players[0] + " pairs!");
                } else {
                    int maxScore = players[0];
                    int winner = 0;
                    boolean tie = false;

                    for (int i = 1; i < numPlayers; i++) {
                        if (players[i] > maxScore) {
                            maxScore = players[i];
                            winner = i;
                            tie = false;
                        } else if (players[i] == maxScore) {
                            tie = true;
                        }
                    }

                    if (tie) {
                        System.out.println("It's a tie!");
                    } else {
                        System.out.println("Player " + (winner + 1) + " wins with " + maxScore + " points!");
                    }
                }
                break;
            }

            System.out.println("1. Pick cards\n2. Print board\n3. Print scores\n0. Exit");
            int pick = input.nextInt();

            switch (pick) {
                case 1:
                    pickCard(cards, parallel, players, currentPlayer);
                    if (numPlayers > 1) {
                        currentPlayer = (currentPlayer + 1) % numPlayers;
                    }
                    break;
                case 2:
                    printCards(cards, parallel);
                    break;
                case 3:
                    printScores(players);
                    break;
            }
        } while (true);
    }
}