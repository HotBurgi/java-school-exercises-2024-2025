package _41_correct_the_exercise;

// Interfaccia: classe che espone solo metodi non codificati
// Astratta: classe che espone metodi codificati o non codificati

//Modificatore d'accesso: parola chiave che specifica il livello di visibilità o accessibilità di classi o variabili

public abstract class Alfa {
    protected int i, j;

    public void setij(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void show() {
        System.out.println("i: " + i + ", j: " + j);
    }
}

class Beta extends Alfa {
    public int q;

    void div() {
        q = i / j;
    }

    public void show() {
        System.out.println("q" + q);
    }
}

class Test {
    public static void main(String[] args) {
        Beta b = new Beta();
        b.setij(10, 5);
        b.div();

        b.show();
    }
}