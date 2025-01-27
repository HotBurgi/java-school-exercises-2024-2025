package _31_pronto_soccorso;

public class Main {
    public static void main(String[] args) {
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        emergencyQueue.addPatient(new Patient("Mario", Priority.RED));
        emergencyQueue.addPatient(new Patient("Luigi", Priority.YELLOW));
        emergencyQueue.addPatient(new Patient("Peach", Priority.WHITE));
        emergencyQueue.addPatient(new Patient("Toad", Priority.RED));
        emergencyQueue.addPatient(new Patient("Bowser", Priority.YELLOW));
        emergencyQueue.addPatient(new Patient("Yoshi", Priority.WHITE));
        emergencyQueue.count();
        System.out.println(emergencyQueue.maxPriority().getName());
        System.out.println(emergencyQueue.searchByName("Peach").getName());
        emergencyQueue.count();
    }
}
