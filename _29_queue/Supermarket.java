package _29_queue;

import java.util.Queue;

public class Supermarket {
    Queue<Person> queue;

    public Supermarket(Queue<Person> queue) {
        this.queue = queue;
    }

    public void addToQueue(Person guy) {
        queue.add(guy);
    }

    public Person peekTheQueue() {
        return queue.peek();
    }

    public Person removeFromQueue() {
        return queue.remove();
    }
}
