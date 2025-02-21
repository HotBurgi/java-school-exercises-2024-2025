package _34_priority_queue;

import java.util.PriorityQueue;

public class Cpu {
    PriorityQueue<Task> tasks = new PriorityQueue<>();

    public void addTask(Task task) {
        if (task == null) {
            return;
        }

        tasks.add(task);
    }

    public void visualizeTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void removeTask() {
        Task t = tasks.poll();

        assert t != null;
        if (t.getTime() == 0) {
            return;
        }
        t.setTime(t.getTime() - 1);
        tasks.add(t);
    }
}