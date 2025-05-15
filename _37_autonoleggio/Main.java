package _37_autonoleggio;

public class Main {
    public static void main(String[] args) {
        CarDealer carDealer = new CarDealer();

        Car car1 = new Car("AA123BB", 1, "Fiat 500", 100, null, 4);
        Car car2 = new Car("BB123CC", 2, "Fiat Panda", 80, null, 5);
        Truck truck1 = new Truck("CC123DD", 3, "Iveco Daily", 150, null, 1000);

        carDealer.addVehicle(car1);
        carDealer.addVehicle(car2);
        carDealer.addVehicle(truck1);

        carDealer.removeVehicle(car1);
    }
}
