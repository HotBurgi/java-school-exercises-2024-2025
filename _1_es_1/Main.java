package _1_es_1;
import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int SIZE = 100;

    public static boolean symmetric (int[][] matrix){
        for (int i = 0; i < SIZE/2; i++) {
            for (int j = 0; j < SIZE/2; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void fill (int[][] matrix){
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(100);
            }
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static void fillRandomLetters (char[][] matrix){
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (char) (r.nextInt(26) + 'a');
            }
        }
    }

    public static void printMatrixs (int[][] matrix, char[][] letters){
        System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Letters: ");
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                System.out.print(letters[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[SIZE][SIZE];
        char[][] letters = new char[SIZE][SIZE];
        int pick;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("1. fill\n2. symmetric\n3. transpose\n4. fill letters\n5. print both\n0. exit");
            pick = input.nextInt();

            switch (pick) {
                case 1:
                    fill(matrix);
                    break;
                case 2:
                    if (symmetric(matrix)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                case 3:
                    matrix = transpose(matrix);
                    break;
                case 4:
                    fillRandomLetters(letters);
                    break;
                case 5:
                    printMatrixs(matrix, letters);
            }
        }while (pick != 0);


    }
}