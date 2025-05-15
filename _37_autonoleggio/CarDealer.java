package _37_autonoleggio;

import java.util.ArrayList;

public class CarDealer {
    private final ArrayList<Vehicle> vehicles;

    public CarDealer() {
        vehicles = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
}
