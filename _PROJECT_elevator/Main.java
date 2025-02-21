package _PROJECT_elevator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Call> calls = new ArrayList<>();

        // Test cases
        calls.add(new Call(1, 5));  // A person at floor 1 wants to go to floor 5
        calls.add(new Call(2, 6));  // A person at floor 2 wants to go to floor 6
        calls.add(new Call(3, 7));  // A person at floor 3 wants to go to floor 7
        calls.add(new Call(5, 2));  // A person at floor 5 wants to go to floor 2
        calls.add(new Call(7, 4));  // A person at floor 7 wants to go to floor 4

        // Create an elevator with 10 floors and the test calls
        Elevator elevator = new Elevator(10, calls);
    }
}