package _40_bike4travel;

public class RaceBike extends Bike {
    public RaceBike(boolean luggage) {
        super(30, luggage, "Race Bike");
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