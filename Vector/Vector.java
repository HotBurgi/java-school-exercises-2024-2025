package Vector;

public class Vector {
    Point p0;
    Point p1;

    public Vector(Point p0, Point p1) {
        this.p0 = p0;
        this.p1 = p1;

    }

    public Point getP0() {
        return p0;
    }

    public void setP0(Point p0) {
        this.p0 = p0;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public boolean isEqual(Vector v) {
        return p0.getX() == v.p0.getX() && p0.getY() == v.p0.getY() && p1.getX() == v.p1.getX() && p1.getY() == v.p1.getY();
    }

    public double length() {
        return Math.sqrt(Math.pow(p1.getX() - p0.getX(), 2) + Math.pow(p1.getY() - p0.getY(), 2));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "p0=(" + p0.getX() + ", " + p0.getY() + ")" +
                ", p1=(" + p1.getX() + ", " + p1.getY() + ")" +
                '}';
    }
}
