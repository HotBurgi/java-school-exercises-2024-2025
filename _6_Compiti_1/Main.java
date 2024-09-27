package _6_Compiti_1;

import java.util.Scanner;

public class Main {
    public static String removeFirst (String phrase) {
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                return phrase.substring(i);
            }
        }
        return phrase;
    }

    public static void sepVowelsCons (String phrase) {
        String tempStr = "";
        for (int i = 0; i < phrase.length(); i++) {
            if ("aeiouAEIOU".indexOf(phrase.charAt(i)) != -1) {
                tempStr += phrase.charAt(i);
            }
        }
        System.out.println(tempStr);
        tempStr = "";

        for (int i = 0; i < phrase.length(); i++) {
            if ("aeiouAEIOU".indexOf(phrase.charAt(i)) == -1 && phrase.charAt(i) != ' ') {
                tempStr += phrase.charAt(i);
            }
        }
        System.out.println(tempStr);
    }

    public static void compOne (String phrase) {
        String tempStr = "";
        for (int i = 0; i < phrase.length(); i++) {
            if ("01".indexOf(phrase.charAt(i)) == -1) {
                System.out.println("There are letters in the sequence!");
                return;
            }
        }

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '1') {
                tempStr += 0;
            } else {
                tempStr += 1;
            }
        }

        phrase = tempStr;
        System.out.println(phrase);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String phrase = "";

        int pick;

        do {
            System.out.println("1. remove first word\n2. separate vowels and cons\n3. comp 1\n4. input string");
            pick = input.nextInt();
            input.nextLine();

            switch (pick) {
                case 1:
                    phrase = removeFirst(phrase);
                    System.out.println(phrase);
                    break;
                case 2:
                    sepVowelsCons(phrase);
                    break;
                case 3:
                    compOne(phrase);
                    break;
                case 4:
                    phrase = input.nextLine();
                    phrase = phrase.trim();
                    break;
            }
        } while (pick != 0);
    }
}
// commit test