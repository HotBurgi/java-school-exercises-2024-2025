package _33_treeMap;

import java.util.TreeMap;

public class CarDealer {
    TreeMap<String, Car> cars = new TreeMap<>();

    public void addCar(Car car) {
        if (cars.containsKey(car.getPlate())) {
            System.out.println("Car with plate " + car.getPlate() + " already exists");
            return;
        }
        cars.put(car.getPlate(), car);
    }

    public void showCars() {
        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}