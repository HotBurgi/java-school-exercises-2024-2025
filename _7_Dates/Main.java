package _7_Dates;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    final static Scanner input = new Scanner(System.in);

    public static LocalDate getData (int day, int month, int year) {
        return LocalDate.of(year, month, day);
    }

    public static String compareDates (LocalDate date) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(date)) {
            return "The date is after today's date";
        } else if (today.isBefore(date)) {
            return "The date is before today's date";
        }

        return "The date is today's date";
    }

    public static LocalDate tomorrowDate () {
        LocalDate today = LocalDate.now();
        return today.plusDays(1);
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int pick, day, month, year;

        do {
            System.out.println("1. Input a date\n2. Before or after\n3. Tomorrow's date\n0. Exit");
            pick = input.nextInt();

            switch (pick) {
                case 1:
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();
                    System.out.println(getData(day, month, year));
                    break;
                case 2:
                    System.out.println(compareDates(date));
                    break;
                case 3:
                    System.out.println(tomorrowDate());
                    break;
            }
        } while (pick != 0);
    }
}
