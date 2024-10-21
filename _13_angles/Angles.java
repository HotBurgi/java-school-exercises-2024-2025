package _13_angles;

public class Angles {
    private int g, p, s;

    public Angles(int g, int p, int s) {
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

        while (p >= 60) {
            p -= 60;
            g += 1;
        }

        while (g >= 360) {
            g -= 360;
        }
    }

    public double toDecimal(){
        fixAngle();
        return g + (p / 60.0) + (s / 3600.0);
    }

    public Angles sum(Angles toSum){
        Angles sum = new Angles(g + toSum.g, p + toSum.p, s + toSum.s);
        sum.fixAngle();
        return sum;
    }

    public Angles sub(Angles toSub){
        Angles sub = new Angles(g - toSub.getG(), p - toSub.getP(), s - toSub.getS());

        if (sub.s < 0) {
            sub.p -= 1;
            sub.s += 60;
        }

        if (sub.p < 0) {
            sub.g -= 1;
            sub.p += 60;
        }

        sub.fixAngle();
        return sub;
    }
}