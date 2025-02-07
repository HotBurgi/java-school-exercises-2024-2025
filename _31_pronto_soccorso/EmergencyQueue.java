package _31_pronto_soccorso;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {
    private final Queue<Patient>[] queues;

    public EmergencyQueue() {
        queues = new LinkedList[3]; // Create the array
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>(); // Initialize each queue
        }
    }

    public void addPatient(Patient p) {
        switch (p.getPriority()) {
            case RED:
                queues[0].add(p);
                break;
            case YELLOW:
                queues[1].add(p);
                break;
            case WHITE:
                queues[2].add(p);
                break;
        }
    }

    public Patient maxPriority() {
        for (Queue<Patient> queue : queues) {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
        }
        return null;
    }

    public Patient searchByName(String name) {
        for (Queue<Patient> queue : queues) {
            for (Patient p : queue) {
                if (p.getName().equals(name)) {
                    queue.remove(p);
                    return p;
                }
            }
        }
        return null;
    }

    public void count() {
        for (Queue<Patient> queue : queues) {
            if (!queue.isEmpty()) { // Check for empty queue to avoid null pointer
                System.out.println(queue.peek().getPriority() + " queue" + ": " + queue.size());
            } else {
                System.out.println("CustomQueue is empty");
            }
        }
    }
}