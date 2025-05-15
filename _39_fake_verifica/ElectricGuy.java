package _39_fake_verifica;

import java.time.LocalDate;

public class ElectricGuy extends TechGuy {
    public ElectricGuy(String name, String surname, LocalDate hireDate, Boolean intern) {
        super(name, surname, hireDate, intern);
    }

    @Override
    public int calculatePay(int hours) {
        if (!this.isIntern()) {
            return 60 * hours;
        }
        return (60 * hours) + (hours * this.getYearsOfExperience());
    }
}