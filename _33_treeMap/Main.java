package _33_treeMap;

import java.util.Scanner;

public class Main {
    public static CarDealer CarDealer = new CarDealer();
    public static Scanner sc = new Scanner(System.in);

    public static void addAuto() {
        System.out.println("Enter model, color, plate, brand, year");
        Car car = new Car(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt());
        CarDealer.addCar(car);
    }

    public static void main(String[] args) {
        int pick;
        do {
            System.out.println("1 add\n2 show");
            pick = sc.nextInt();
            switch (pick) {
                case 1:
                    addAuto();
                    break;
                case 2:
                    CarDealer.showCars();
                    break;
            }
        } while (pick != 0);
    }
}