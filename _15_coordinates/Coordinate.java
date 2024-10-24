package _15_coordinates;

import java.time.LocalDateTime;

public class Coordinate {
    private Point longitude;
    private Point latitude;
    private LocalDateTime time;

    public Coordinate(Point longitude, Point latitude) {
        setLongitude(longitude);
        setLatitude(latitude);
        this.time = coordinateTime();
    }

    public LocalDateTime coordinateTime() {
        int offset = 0;
        int deg = latitude.getG();
        if (deg < 0) {
            for (int i = deg; i < 0; i += 15) {
                offset -= 1;
            }
        } else {
            for (int i = deg; i > 0; i -= 15) {
                offset += 1;
            }
        }
        return LocalDateTime.now().plusHours(offset);
    }

    public Point getLongitude() {
        return longitude;
    }

    public void setLongitude(Point longitude) {
        if (longitude.getG() < -180 || longitude.getG() > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees.");
        }
        this.longitude = longitude;
    }

    public Point getLatitude() {
        return latitude;
    }

    public void setLatitude(Point latitude) {
        if (latitude.getG() < -90 || latitude.getG() > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees.");
        }
        this.latitude = latitude;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime() {
        this.time = LocalDateTime.now();
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