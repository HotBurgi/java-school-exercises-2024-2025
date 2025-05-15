package _39_fake_verifica;

import java.util.ArrayList;

public class Project {
    ArrayList<Worker> team;

    public Project() {
        this.team = new ArrayList<>();
    }

    public void addWorker(Worker w) {
        team.add(w);
    }

    public void removeWorker(int i) {
        team.remove(i);
    }

    public int getProjectPrice() {
        int totalPrice = 0;
        for (Worker w : team) {
            totalPrice += w.getT().calculatePay(w.getTotalHours());
        }
        return totalPrice;
    }
}