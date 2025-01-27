package _30_preparazione_verifica;

import java.util.ArrayList;

public class Campeggio {
    private final ArrayList<Prenotazione> prenotazioni;

    public Campeggio() {
        prenotazioni = new ArrayList<>();
    }

    public void aggiungiPrenotazione(Prenotazione p) {
        prenotazioni.add(p);
    }

    public void printPrenotazioni() {
        for (Prenotazione prenotazione : prenotazioni) {
            System.out.println(prenotazione);
        }
    }
}
