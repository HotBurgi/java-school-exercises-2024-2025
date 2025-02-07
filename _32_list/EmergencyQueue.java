package _32_list;

public class EmergencyQueue {
    private final CustomQueue redQueue;
    private final CustomQueue yellowQueue;
    private final CustomQueue whiteQueue;

    public EmergencyQueue() {
        redQueue = new CustomQueue();
        yellowQueue = new CustomQueue();
        whiteQueue = new CustomQueue();
    }

    public boolean addPatient(Patient p) {
        switch (p.getPriority()) {
            case RED:
                redQueue.enqueue(p);
                return true;
            case YELLOW:
                yellowQueue.enqueue(p);
                return true;
            case WHITE:
                whiteQueue.enqueue(p);
                return true;
        }
        return false;
    }

    public Patient maxPriority() {
        if (redQueue.getElements() != 0) {
            redQueue.dequeue();
        }
        if (yellowQueue.getElements() != 0) {
            yellowQueue.dequeue();
        }
        if (whiteQueue.getElements() != 0) {
            whiteQueue.dequeue();
        }
        return null;
    }

    public Patient searchByName(String name) {
        Node current = redQueue.getHead();
        for (int i = 0; i < redQueue.getElements(); i++) {
            if (current.getData().getName().equals(name)) {
                return current.getData();
            }
            current = current.getLink();
        }
        current = yellowQueue.getHead();
        for (int i = 0; i < yellowQueue.getElements(); i++) {
            if (current.getData().getName().equals(name)) {
                return current.getData();
            }
            current = current.getLink();
        }
        current = whiteQueue.getHead();
        for (int i = 0; i < whiteQueue.getElements(); i++) {
            if (current.getData().getName().equals(name)) {
                return current.getData();
            }
            current = current.getLink();
        }
        return null;
    }

    public void count() {
        if (redQueue.getElements() == 0) {
            System.out.println("Red Queue is empty");
        } else {
            System.out.println("Red Queue has " + redQueue.getElements() + " patients");
        }

        if (yellowQueue.getElements() == 0) {
            System.out.println("Yellow Queue is empty");
        } else {
            System.out.println("Yellow Queue has " + yellowQueue.getElements() + " patients");
        }

        if (whiteQueue.getElements() == 0) {
            System.out.println("White Queue is empty");
        } else {
            System.out.println("White Queue has " + whiteQueue.getElements() + " patients");
        }
    }

    public Patient peekQueue(Priority p) {
        return switch (p) {
            case RED -> redQueue.peek();
            case YELLOW -> yellowQueue.peek();
            case WHITE -> whiteQueue.peek();
        };
    }

    public void topPatient(Patient p) {
        p.setPriority(Priority.RED);
        redQueue.maxPriority(p);
    }

    public boolean turnYellow(Patient p) {
        if (whiteQueue.isEmpty()) {
            return false;
        }

        if (whiteQueue.peek().equals(p)) {
            Patient removedPatient = whiteQueue.dequeue();
            removedPatient.setPriority(Priority.YELLOW);
            yellowQueue.enqueue(removedPatient);
            return true;
        }

        Node before = findNodeBeforePatient(p);
        if (before == null || before.getLink() == null) {
            return false;
        }

        Node patientNode = before.getLink();
        before.setLink(patientNode.getLink());

        patientNode.getData().setPriority(Priority.YELLOW);
        yellowQueue.enqueue(patientNode.getData());
        return true;
    }

    public Node findNodeBeforePatient(Patient p) {
        Node current = whiteQueue.getHead();
        Node last = whiteQueue.getHead();
        while (current.getData() != p) {
            last = current;
            if (current.getLink() == null) {
                return null;
            }
            current = current.getLink();
        }
        return last;
    }

    public boolean move3Whites() {
        Patient p;
        if (whiteQueue.getElements() < 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            p = whiteQueue.peek();
            turnYellow(p);
        }
        return true;
    }

    public boolean moveBack(Priority prio) {
        Patient p;
        switch (prio) {
            case RED:
                p = redQueue.dequeue();
                redQueue.enqueue(p);
                return true;
            case YELLOW:
                p = yellowQueue.dequeue();
                yellowQueue.enqueue(p);
                return true;
            case WHITE:
                p = whiteQueue.dequeue();
                whiteQueue.enqueue(p);
                return true;
        }
        return false;
    }
}