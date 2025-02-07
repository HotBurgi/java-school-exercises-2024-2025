package _32_list;

public class CustomQueue {
    private Node head, tail;
    private int elements;

    public CustomQueue() {
        head = null;
        tail = null;
        elements = 0;
    }

    private void addOnHead(Patient p) {
        Node newNode = new Node(p);
        newNode.setLink(head);
        head = newNode;

        if (tail == null) {
            tail = head;
        }
        elements++;
    }

    private void addOnTail(Patient p) {
        Node newNode = new Node(p);

        if (head == null) {
            head = newNode;
        } else {
            tail.setLink(newNode);
        }
        tail = newNode;

        elements++;
    }

    public void enqueue(Patient p) {
        addOnTail(p);
    }

    public int getElements() {
        return elements;
    }

    public Patient dequeue() {
        if (head == null) {
            return null;
        } else {
            Patient p = head.getData();
            head = head.getLink();
            elements--;
            return p;
        }
    }

    public Patient peek() {
        if (head == null) {
            return null;
        } else {
            return head.getData();
        }
    }

    public Node getHead() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

    public void maxPriority(Patient p) {
        addOnHead(p);
    }

    public boolean isEmpty() {
        return elements == 0;
    }
}
