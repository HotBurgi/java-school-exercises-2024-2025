package _17_array_di_oggetti;

public class Main {
    static Macchine[] autonoleggio = new Macchine[4];

    public static void main(String[] args) {
        for (int i = 0; i < autonoleggio.length; i++) {
            if (autonoleggio[i] == null)
                return;
        }
    }
}