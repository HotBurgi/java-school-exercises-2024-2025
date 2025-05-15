package _37_autonoleggio;

import java.time.LocalDate;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String targa, int identifier, String model, int hp, LocalDate acquisitionDate, int numberOfSeats) {
        super(targa, identifier, model, hp, acquisitionDate);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public int loanPrice() {
        LocalDate now = LocalDate.now();
        int days = now.getDayOfYear() - getAcquisitionDate().getDayOfYear();
        return 50 * days + getDistanceTravelled() / 25;
    }
}
