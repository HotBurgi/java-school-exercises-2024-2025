package _2_Es_2;

import java.util.Random;

public class Main {
    final static int SIZE = 10;

    public static void setup (int[] vector, int[][] matrix){
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            vector[i] = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(100);
            }
        }
    }

    public static void max (int[] vector, int[][] matrix){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (vector[j] < matrix[i][j]) {
                    vector[j] = matrix[i][j];
                }
            }
        }
    }

    public static void printData (int[] vector, int[][] matrix){
        System.out.println("Matrix:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Max:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] vector = new int[SIZE];
        int[][] matrix = new int[SIZE][SIZE];

        setup(vector, matrix);
        max(vector, matrix);
        printData(vector, matrix);

    }
}
