package _34_priority_queue;

import java.util.Random;

public class Task implements Comparable<Task> {
    private static final int progressive = 0;
    private final Random random = new Random();
    private int priority;
    private int time;
    private int pid;

    public Task() {
        this.priority = random.nextInt(10) + 1;
        this.time = random.nextInt(10) + 1;
        this.pid = progressive + 1;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public int compareTo(Task o) {
        if (this.priority < o.priority) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Task{" +
                "pid=" + pid +
                ", time=" + time +
                ", priority=" + priority +
                '}';
    }
}
