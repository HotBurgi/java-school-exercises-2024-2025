package _10_calcoli_numeri_complessi;

import java.util.Scanner;

public class Main {
    public static void sum (int real1, int real2, int ima1, int ima2) {
        int sumR = real1 + real2;
        int sumI = ima1 + ima2;

        if (sumI >= 0) {
            System.out.println("Z= " + sumR + " + " + sumI + "j");
        } else {
            System.out.println("Z= " + sumR + " - " + (-sumI) + "j");
        }
    }

    public static void sub (int real1, int real2, int ima1, int ima2) {
        int subR = real1 - real2;
        int subI = ima1 - ima2;

        if (subI >= 0) {
            System.out.println("Z= " + subR + " + " + subI + "j");
        } else {
            System.out.println("Z= " + subR + " - " + (-subI) + "j");
        }
    }

    public static void mul (int real1, int real2, int ima1, int ima2) {
        int mulR = (real1 * real2) - (ima1 * ima2);
        int mulI = (real1 * ima2) + (ima1 * real2);

        if (mulI >= 0) {
            System.out.println("Z= " + mulR + " + " + mulI + "j");
        } else {
            System.out.println("Z= " + mulR + " - " + (-mulI) + "j");
        }
    }

    public static void div (int real1, int real2, int ima1, int ima2) {
        double den = Math.pow(real2, 2) + Math.pow(ima2, 2);

        int numR = (real1 * real2) + (ima1 * ima2);
        int numI = (ima1 * real2) - (real1 * ima2);

        if (numI >= 0) {
            System.out.println("Z= " + numR + " + " + numI + "j" + " / " + (int) den);
        } else {
            System.out.println("Z= " + numR + " - " + numI + "j" + " / " + den);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pick, real1, real2, ima1, ima2;

        System.out.println("Enter real part of num1: ");
        real1 = input.nextInt();
        System.out.println("Enter imaginary part of num1: ");
        ima1 = input.nextInt();

        System.out.println("Enter real part of num2: ");
        real2 = input.nextInt();
        System.out.println("Enter imaginary part of num2: ");
        ima2 = input.nextInt();

        do {
            System.out.println("1.Sum\n2.Sub\n3.Mul\n4.Div\n0.Exit");
            pick = input.nextInt();

            switch (pick) {
                case 1:
                    sum(real1, real2, ima1, ima2);
                    break;
                case 2:
                    sub(real1, real2, ima1, ima2);
                    break;
                case 3:
                    mul(real1, real2, ima1, ima2);
                    break;
                case 4:
                    div(real1, real2, ima1, ima2);
                    break;
            }
        } while (pick != 0);

        input.close();
    }
}