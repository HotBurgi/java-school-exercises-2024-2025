package _39_fake_verifica;

public class Worker {
    private final TechGuy t;
    private final int totalHours;

    public Worker(TechGuy t, int totalHours) {
        this.t = t;
        this.totalHours = totalHours;
    }

    public TechGuy getT() {
        return t;
    }

    public int getTotalHours() {
        return totalHours;
    }
}