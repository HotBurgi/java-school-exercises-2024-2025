package _PROJECT_elevator;

public class Call {
    private final int UP = 1;
    private final int DOWN = -1;

    private final int startingFloor;
    private final int destinationFloor;
    private int direction;

    public Call(int startingFloor, int destinationFloor) {
        this.startingFloor = startingFloor;
        this.destinationFloor = destinationFloor;

        if (this.startingFloor < this.destinationFloor) {
            this.direction = UP;
        } else if (this.startingFloor > this.destinationFloor) {
            this.direction = DOWN;
        }
    }

    public int getStartingFloor() {
        return startingFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public int getDirection() {
        return direction;
    }
}
