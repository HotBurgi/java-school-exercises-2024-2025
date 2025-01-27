package _31_pronto_soccorso;

public class Patient {
    String name;
    Priority priority;

    public Patient(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }
}
