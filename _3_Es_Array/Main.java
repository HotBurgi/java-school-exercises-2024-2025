package _3_Es_Array;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int SIZE = 5;

    public static void fill(int[] sequence) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            sequence[i] = input.nextInt();
        }
    }

    public static void randomFill(int[] sequence) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            sequence[i] = random.nextInt(100);
        }
    }

    public static void isOrdered(int[] sequence) {
        int flag = 1;
        for (int i = 1; i < SIZE; i++) {
            if (sequence[i - 1] > sequence[i]) {
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Sequence is sorted in descending order.");
        } else {
            System.out.println("Sequence not is sorted in ascending order.");
        }
    }

    public static void shuffle(int[] sequence) {
        Random random = new Random();
        int x, y, temp;
        for (int i = 0; i < 10; i++) {
            x = random.nextInt(sequence.length);
            y = random.nextInt(sequence.length);

            temp =  sequence[x];
            sequence[x] = sequence[y];
            sequence[y] = temp;
        }
    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void findPrimes(int[] sequence, int [] primes) {
        int primesIndex = 0;
        for (int i = 0; i < SIZE; i++) {
            if (isPrime(sequence[i])) {
                primes[primesIndex++] = sequence[i]; // primesIndex viene usato come index poi incrementato
            }
        }

        for (int i = 0; i < primesIndex; i++) {
            System.out.print(primes[i] + " ");
        }
        System.out.println();
    }

    public static void removeNegatives(int[] sequence) {
        int stack = SIZE - 1;
        for (int i = 0; i < SIZE; i++) {
            if (sequence[i] < 0) {
                System.out.println("The " + (i + 1) + "th number is negative: " + sequence[i]);
                for (int j = i; j < SIZE - 1; j++) {
                    sequence[j] = sequence[j+1];
                }
                sequence[stack] = 0;
                stack--;
                i--;
            }
        }
        System.out.print("New sequence: ");
        printArray(sequence);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pick;
        int[] sequence = new int[SIZE];
        int[] primes = new int[SIZE];

        do {
            System.out.println("1. fill\n2. is sorted\n3. random fill\n4. shuffle\n5. find primes\n6. remove negatives\n7. print array\n8. print primes\n0. exit");
            pick = input.nextInt();

            switch (pick) {
                case 1:
                    fill (sequence);
                    break;

                case 2:
                    isOrdered(sequence);
                    break;

                case 3:
                    randomFill(sequence);
                    break;

                case 4:
                    shuffle(sequence);
                    break;

                case 5:
                    findPrimes(sequence, primes);
                    break;

                case 6:
                    removeNegatives(sequence);
                    break;

                case 7:
                    printArray(sequence);
                    break;

                case 8:
                    printArray(primes);
                    break;
            }
        } while (pick != 0);
    }
}
