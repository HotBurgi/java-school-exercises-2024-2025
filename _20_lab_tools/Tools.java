package _20_lab_tools;

import java.time.LocalDate;

public class Tools {
    private final int code;
    private final String description;
    private final double price;
    private final LocalDate aquisitionDate;
    private final int warrenty;

    public Tools(int code, String description, double price, LocalDate aquisitionDate, int warrenty) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.aquisitionDate = aquisitionDate;
        this.warrenty = warrenty;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getAquisitionDate() {
        return aquisitionDate;
    }

    public int getWarrenty() {
        return warrenty;
    }

    @Override
    public String toString() {
        return "Tools{" +
                "code: " + code +
                ", description: '" + description + '\'' +
                ", price: " + price + "€" +
                ", aquisitionDate: " + aquisitionDate +
                ", warrenty: " + warrenty + " years" +
                '}';
    }
}