package _39_fake_verifica;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Project p = new Project();

        int pick;

        do {
            System.out.println("1.Add worker\n2.Remove worker\n3.Get project price");
            pick = sc.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Is it a CPguy or an ElectricGuy (1 / 2)");
                    int temp = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Name");
                    String name = sc.nextLine();
                    System.out.println("Surname");
                    String surname = sc.nextLine();

                    System.out.println("Year");
                    int year = sc.nextInt();
                    System.out.println("Month");
                    int month = sc.nextInt();
                    System.out.println("Day");
                    int day = sc.nextInt();
                    LocalDate hireDate = LocalDate.of(year, month, day);

                    System.out.println("Is intern");
                    boolean isIntern = sc.nextBoolean();
                    System.out.println("Worked hours");
                    int workedHours = sc.nextInt();

                    switch (temp) {
                        case 1:
                            CPguy cp = new CPguy(name, surname, hireDate, isIntern);
                            Worker cpW = new Worker(cp, workedHours);
                            p.addWorker(cpW);
                            break;
                        case 2:
                            ElectricGuy e = new ElectricGuy(name, surname, hireDate, isIntern);
                            Worker eW = new Worker(e, workedHours);
                            p.addWorker(eW);
                            break;
                        default:
                            System.out.println("IMPUT ERROR!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Index of worker to remove: ");
                    int i = sc.nextInt();
                    p.removeWorker(i);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Total project price: ");
                    System.out.println(p.getProjectPrice());
                    break;
                default:
                    System.out.println("IMPUT ERROR!");
                    break;
            }
        } while (pick != 0);
    }
}
