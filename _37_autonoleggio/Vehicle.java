package _37_autonoleggio;

import java.time.LocalDate;

public abstract class Vehicle {
    private String targa;
    private int identifier;
    private String model;
    private int hp;
    private LocalDate acquisitionDate;
    private int distanceTravelled;

    public Vehicle(String targa, int identifier, String model, int hp, LocalDate acquisitionDate) {
        this.targa = targa;
        this.identifier = identifier;
        this.model = model;
        this.hp = hp;
        this.acquisitionDate = acquisitionDate;
        this.distanceTravelled = 0;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public abstract int loanPrice();
}
