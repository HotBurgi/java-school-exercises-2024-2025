package _7_dates;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static LocalDate getData(int day, int month, int year) {
        return LocalDate.of(year, month, day);
    }

    public static String compareDates(LocalDate date) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(date)) {
            return "The date is after today's date";
        } else if (today.isBefore(date)) {
            return "The date is before today's date";
        }
        return "The date is today's date";
    }

    public static LocalDate tomorrowDate() {
        LocalDate today = LocalDate.now();
        return today.plusDays(1);
    }

    public static boolean isInThisMonth(LocalDate date) {
        LocalDate today = LocalDate.now();
        return today.getMonthValue() == date.getMonthValue();
    }

    public static LocalDate generateDate(String strDate) {
        strDate = strDate.trim();
        String[] numbers = strDate.split("/");

        if (numbers.length != 3) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }

        int day, month, year;
        try {
            day = Integer.parseInt(numbers[0]);
            month = Integer.parseInt(numbers[1]);
            year = Integer.parseInt(numbers[2]);
            return getData(day, month, year);
        } catch (NumberFormatException e) {
            System.out.println("Invalid date components: " + e.getMessage());
            return null;
        }
    }

    public static void areDatesConsecutive(String strDate, String strDate1) {
        LocalDate date = generateDate(strDate);
        LocalDate date1 = generateDate(strDate1);

        if (date == null || date1 == null) {
            System.out.println("Invalid date(s) entered.");
            return;
        }

        if (date.plusDays(1).equals(date1)) {
            System.out.println("The two dates are consecutive.");
        } else {
            System.out.println("The dates are not consecutive.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        String strDate, strDate1;
        int pick, day, month, year;

        do {
            System.out.println("1. Input two dates\n2. Compare with today's date\n3. Tomorrow's date\n4. Check if a date is in this month\n0. Exit");
            pick = input.nextInt();
            input.nextLine();  // Consume the newline character

            switch (pick) {
                case 1:
                    System.out.println("Enter the first date (dd/MM/yyyy):");
                    strDate = input.nextLine();
                    System.out.println("Enter the second date (dd/MM/yyyy):");
                    strDate1 = input.nextLine();
                    areDatesConsecutive(strDate, strDate1);
                    break;

                case 2:
                    System.out.println("Enter a date to compare with today (dd/MM/yyyy):");
                    strDate = input.nextLine();
                    LocalDate date = generateDate(strDate);
                    if (date != null) {
                        System.out.println(compareDates(date));
                    }
                    break;

                case 3:
                    System.out.println("Tomorrow's date is: " + tomorrowDate());
                    break;

                case 4:
                    System.out.println("Enter a date (dd/MM/yyyy):");
                    strDate = input.nextLine();
                    LocalDate checkDate = generateDate(strDate);
                    if (checkDate != null) {
                        if (isInThisMonth(checkDate)) {
                            System.out.println("The date is in this month.");
                        } else {
                            System.out.println("The date is not in this month.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (pick != 0);

        input.close();
    }
}