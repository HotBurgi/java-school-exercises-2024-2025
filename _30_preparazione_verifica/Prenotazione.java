package _30_preparazione_verifica;

import java.time.LocalDate;

public class Prenotazione {
    String nomeCampeggiatore;
    LocalDate dataInizio;
    LocalDate dataFine;
    int numeroPiazzola;
    TipoPiazzola tipoPiazzola;

    public Prenotazione(String nomeCampeggiatore, LocalDate dataInizio, LocalDate dataFine, int numeroPiazzola, TipoPiazzola tipoPiazzola) {
        this.nomeCampeggiatore = nomeCampeggiatore;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.numeroPiazzola = numeroPiazzola;
        this.tipoPiazzola = tipoPiazzola;
    }

    @Override
    public String toString() {
        return nomeCampeggiatore + ";" + dataInizio + ";" + dataFine + ";" + numeroPiazzola + ";" + tipoPiazzola;
    }
}