package _15_coordinates;

import java.time.LocalDateTime;

public class Coordinate {
    private Point longitude;
    private Point latitude;
    private LocalDateTime time;

    public Coordinate(Point longitude, Point latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = LocalDateTime.now();
    }

    public Point getLongitude() {
        return longitude;
    }

    public void setLongitude(Point longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Point getLatitude() {
        return latitude;
    }

    public void setLatitude(Point latitude) {
        this.latitude = latitude;
    }

    public void setTime() {
        this.time = LocalDateTime.now();
    }

    public void fixCoordinates() {
        longitude.fixAngle();
        latitude.fixAngle();
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", time=" + time +
                '}';
    }
}
