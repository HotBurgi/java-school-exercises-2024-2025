package _15_coordinates;

public class Point {
    private int g, p, s;

    public Point(int g, int p, int s) {
        this.g = g;
        this.p = p;
        this.s = s;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "Angles{" +
                "g=" + g +
                ", p=" + p +
                ", s=" + s +
                '}';
    }

    public void fixAngle() {
        while (s >= 60) {
            s -= 60;
            p += 1;
        }

        while (s < 0) {
            s += 60;
            p -= 1;
        }

        while (p >= 60) {
            p -= 60;
            g += 1;
        }

        while (p < 0) {
            p += 60;
            g -= 1;
        }

        while (g >= 360) {
            g -= 360;
        }

        while (g < 0) {
            g += 360;
        }
    }
}