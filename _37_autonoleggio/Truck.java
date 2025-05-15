package _37_autonoleggio;

import java.time.LocalDate;

public class Truck extends Vehicle {
    private int maxLoad;

    public Truck(String targa, int identifier, String model, int hp, LocalDate acquisitionDate, int maxLoad) {
        super(targa, identifier, model, hp, acquisitionDate);
        this.maxLoad = maxLoad;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public int loanPrice() {
        LocalDate now = LocalDate.now();
        int days = now.getDayOfYear() - getAcquisitionDate().getDayOfYear();

        int totalLoan = 70 * days;
        if (getDistanceTravelled() > 100) {
            totalLoan += (getDistanceTravelled() - 100) / 30;
        }
        return totalLoan;
    }
}
