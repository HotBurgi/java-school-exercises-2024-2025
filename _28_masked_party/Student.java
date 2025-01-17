package _28_masked_party;

import java.time.LocalDate;

public class Student {
    private static int nextMatriculationNumber = 1000;
    private String name;
    private LocalDate birthDate;
    private final int age;
    private String mask;
    private char sex;
    private int matriculationNumber;

    public Student(String name, LocalDate birthDate, String mask, char sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = LocalDate.now().getYear() - birthDate.getYear();
        this.mask = mask;
        this.sex = sex;
        this.matriculationNumber = nextMatriculationNumber++;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return name + ";" + birthDate + ";" + mask + ";" + sex + ";" + matriculationNumber;
    }
}
