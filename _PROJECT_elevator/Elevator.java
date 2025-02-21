package _PROJECT_elevator;

import java.util.ArrayList;
import java.util.Iterator;

public class Elevator {
    private final int UP = 1;
    private final int DOWN = -1;

    private final int floors;
    private int currentFloor;
    private int direction;
    private final int remainingCalls;
    private int passengersNumber = 0;


    private final ArrayList<Call> calls;
    private final ArrayList<Call> passengers = new ArrayList<>();

    // The starting floor of the elevator is the first call's starting floor, same for the direction
    public Elevator(int floors, ArrayList<Call> calls) {
        this.floors = floors;
        this.calls = calls;
        this.currentFloor = calls.getFirst().getStartingFloor();
        this.direction = calls.getFirst().getDirection();
        this.remainingCalls = calls.size();
        simulateElevator();
    }

    private void simulateElevator() {
        for (int i = 0; i < 10; i++) {
            int loading = loadPassengers();
            int unLoading = unloadPassengers();
            passengersNumber = passengers.size();
            System.out.println("Current floor: " + currentFloor);
            System.out.println("Load: " + loading);
            System.out.println("Unloading: " + unLoading);
            System.out.println("Current passengers: " + passengersNumber);
            changeFloor();
        }
    }

    private int loadPassengers() {
        int count = 0;
        Iterator<Call> iterator = calls.iterator();

        while (iterator.hasNext()) {
            Call call = iterator.next();
            if (call.getStartingFloor() == currentFloor) {
                passengers.add(call);
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    private int unloadPassengers() {
        int count = 0;
        Iterator<Call> iterator = calls.iterator();
        while (iterator.hasNext()) {
            Call call = iterator.next();
            if (call.getDestinationFloor() == currentFloor) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    private void changeFloor() {
        if (currentFloor == floors) {
            direction = DOWN;
        }
        if (currentFloor == 0) {
            direction = UP;
        }

        if (direction == UP) {
            currentFloor++;
        } else {
            currentFloor--;
        }
    }
}
