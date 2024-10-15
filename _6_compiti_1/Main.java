package _6_compiti_1;

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

    public static void numberOfLetters (String phrase) {
        Scanner input = new Scanner(System.in);

        char letter;
        int count = 0;
        System.out.print("Chose  a letter: ");
        letter = input.next().charAt(0);

        for (int i = 0; i < phrase.length(); i++) {
            if (letter == phrase.charAt(i)) {
                count++;
            }
        }

        System.out.println(count + " times " + letter);
    }

    public static boolean isInQueue (String phrase, String tail) {
        if(phrase.endsWith(tail)){
            return true;
        }
        return false;
    }

    public static char heatChar (String phrase) {
        String watched = "";
        int count, times = 0;
        char heated = ' ';

        for (int i = 0; i < phrase.length(); i++) {
            count = 0;
            if (watched.indexOf(phrase.charAt(i)) == -1) {
                for (int j = 0; j < phrase.length(); j++){
                    if (phrase.charAt(j) == phrase.charAt(i)) {
                        count++;
                    }
                    if (count > times){
                        times = count;
                        heated = phrase.charAt(i);
                    }
                }
                watched += phrase.charAt(i);
            }
        }
        return heated;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String phrase = "", tail = "";

        int pick;

        do {
            System.out.println("1. remove first word\n2. separate vowels and cons\n3. comp 1\n4. input string\n5. number of letters\n6. Is in tail\n7. Most freq char\n0. Exit");
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
                case 5:
                    numberOfLetters(phrase);
                    break;
                case 6:
                    System.out.println("Write the tail: ");
                    tail = input.nextLine();
                    System.out.println(isInQueue(phrase, tail));
                    break;
                case 7:
                    System.out.println("The most frequent char is: " + heatChar(phrase));
                    break;
            }
        } while (pick != 0);
    }
}