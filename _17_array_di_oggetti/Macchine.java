package _17_array_di_oggetti;

public class Macchine {
    private final String name;
    private String targa;

    public Macchine(String name, String targa) {
        this.name = name;
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
}
