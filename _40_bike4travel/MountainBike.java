package _40_bike4travel;

public class MountainBike extends Bike {
    public MountainBike(boolean luggage) {
        super(20, luggage, "Mountain Bike");
    }

    @Override
    public int getTotal(int days) {
        int total = 0;
        total += price * days;
        if (luggage) {
            total += 5 * days;
        }
        return total;
    }
}