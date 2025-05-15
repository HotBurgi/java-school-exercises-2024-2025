package _40_bike4travel;

public class Bike4travel {
    int[] loanDays = new int[5];
    Bike[] bikes = new Bike[5];

    int totalBikers = 0;

    public boolean addTraveler(int days, Bike bike) {
        if (totalBikers == 5) {
            return false;
        }

        loanDays[totalBikers] = days;
        bikes[totalBikers] = bike;
        return true;
    }

    public int calculateTotal() {
        int total = 0;
        for (int i = 0; i < totalBikers; i++) {
            total += bikes[i].getTotal(loanDays[i]);
        }
        return total;
    }

    public void printTravelers() {
        for (int i = 0; i < totalBikers; i++) {
            System.out.println("Traveler " + (i + 1) + ": " + bikes[i].getModel() + ", Days: " + loanDays[i]);
        }
    }

    public boolean available() {
        return totalBikers < 5;
    }
}
