package _12_fraction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();
        int pick, power, newNumerator, newDenominator, choose;

        do {
            System.out.println("1. Opposite\n2. Reciprocal\n3. Sum\n4. Subtract\n5. Multiply\n6. Divide\n7. Pow\n8. Change NUM/DEN\n0. Exit");
            System.out.print("Pick an option: ");
            pick = scanner.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Opposite");
                    fraction1.opposite();
                    System.out.println(fraction1);
                    break;
                case 2:
                    System.out.println("Reciprocal");
                    try {
                        fraction1.reciprocal();
                        System.out.println(fraction1);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Sum");
                    fraction1.sum(fraction2);
                    System.out.println(fraction1);
                    break;
                case 4:
                    System.out.println("Subtract");
                    fraction1.sub(fraction2);
                    System.out.println(fraction1);
                    break;
                case 5:
                    System.out.println("Multiply");
                    fraction1.mul(fraction2);
                    System.out.println(fraction1);
                    break;
                case 6:
                    System.out.println("Division");
                    try {
                        fraction1.div(fraction2);
                        System.out.println(fraction1);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("What power: ");
                    power = scanner.nextInt();
                    fraction1.pow(power);
                    System.out.println(fraction1);
                    break;
                case 8:
                    System.out.print("Numerator: ");
                    newNumerator = scanner.nextInt();
                    System.out.print("Denominator: ");
                    newDenominator = scanner.nextInt();

                    System.out.print("Which fraction you want to change? 1 / 2: ");
                    choose = scanner.nextInt();
                    if (choose == 1) {
                        fraction1.setNumerator(newNumerator);
                        fraction1.setDenominator(newDenominator);
                    } else {
                        fraction2.setNumerator(newNumerator);
                        fraction2.setDenominator(newDenominator);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (pick != 0);
    }
}