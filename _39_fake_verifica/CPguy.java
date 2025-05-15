package _39_fake_verifica;

import java.time.LocalDate;

public class CPguy extends TechGuy {
    public CPguy(String name, String surname, LocalDate hireDate, Boolean intern) {
        super(name, surname, hireDate, intern);
    }

    @Override
    public int calculatePay(int hours) {
        if (!this.isIntern()) {
            return 50 * hours;
        }
        return (50 * hours) + (hours * this.getYearsOfExperience());
    }
}