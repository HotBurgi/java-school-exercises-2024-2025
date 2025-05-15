package _39_fake_verifica;

import java.time.LocalDate;

public abstract class TechGuy {
    private static int prog = 0;
    private final int code;
    private final LocalDate hireDate;
    private final String name;
    private final String surname;
    private final int yearsOfExperience;
    private final boolean intern;

    public TechGuy(String name, String surname, LocalDate hireDate, Boolean intern) {
        this.name = name;
        this.surname = surname;
        this.hireDate = hireDate;
        this.code = prog++;
        this.yearsOfExperience = LocalDate.now().getYear() - hireDate.getYear();
        this.intern = intern;
    }

    public abstract int calculatePay(int hours);

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public boolean isIntern() {
        return intern;
    }
}
