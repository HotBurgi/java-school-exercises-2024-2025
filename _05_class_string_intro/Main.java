package _05_class_string_intro;

import java.util.Scanner;

public class Main {

    public static boolean findAt(String phrase) {
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '@') {
                count++;
            }
        }

        int a = phrase.indexOf('a');

        return count == 1;
    }

    public static int numberize(String phrase) {
        int number = 0;
        for (int i = 0; i < phrase.length(); i++) {
            number = number * 10 + phrase.charAt(i) - '0';
        }

        return number;
    }

    public static void reversePhrase(String phrase) {
        String reversed = "";
        for (int i = phrase.length() - 1; i >= 0; i--) {
            reversed += phrase.charAt(i);
        }
        phrase = reversed;
    }

    public static int countWords(String phrase) {
        int count = 0;

        phrase = phrase.trim();

        if (phrase.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ' && phrase.charAt(i + 1) != ' ') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pick;
        String phrase = "";

        do {
            System.out.println("1. Enter a phrase\n2. Binary to number\n3. Reverse\n4. Count words\n0. Exit");
            pick = input.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Enter a phrase:");
                    phrase = input.nextLine();

                     if (findAt(phrase)) {
                         System.out.println("Yes");
                     } else {
                         System.out.println("No");
                     }
                    break;

                case 2:
                    System.out.println(numberize(phrase));
                    break;

                case 3:
                    reversePhrase(phrase);
                    System.out.println(phrase);
                    break;

                case 4:
                    System.out.println(countWords(phrase));
                    break;
            }
        } while (pick != 0);
    }
}