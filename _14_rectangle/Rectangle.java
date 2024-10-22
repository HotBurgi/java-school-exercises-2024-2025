package _14_rectangle;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getHeight() {
        return Math.abs(topLeft.getY() - bottomRight.getY());
    }

    public int getWidth() {
        return Math.abs(topLeft.getX() - bottomRight.getX());
    }

    public int getPerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    public int getArea() {
        return getHeight() * getWidth();
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(getHeight(), 2) + Math.pow(getWidth(), 2));
    }
}