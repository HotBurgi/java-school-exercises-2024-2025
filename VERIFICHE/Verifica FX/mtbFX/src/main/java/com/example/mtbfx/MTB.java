package com.example.mtbfx;

import java.util.Arrays;

public class MTB {
    private String marca;
    private String modello;
    private String tipoAmmortizzazione;
    private String colore;
    private String[] aggiunte;
    private int prezzo;

    public MTB(String marca, String modello, String tipoAmmortizzazione, String colore, String[] aggiunte) {
        this.marca = marca;
        this.modello = modello;
        this.tipoAmmortizzazione = tipoAmmortizzazione;
        this.colore = colore;
        this.aggiunte = aggiunte;
        this.prezzo = setPrezzo();
    }

    private int setPrezzo(){
        int counter = 0;
        for (int i = 0; i < aggiunte.length; i++) {
            if(aggiunte[i] != null){ counter++; }
        }
        return 2000 + (counter * 200);
    }

    @Override
    public String toString() {
        return "MTB{ " + "\n" +
                "marca:'" + marca + "\n" +
                ", modello: '" + modello + "\n" +
                ", tipoAmmortizzazione: '" + tipoAmmortizzazione + "\n" +
                ", colore: '" + colore + "\n" +
                ", aggiunte: " + Arrays.toString(aggiunte) + "\n" +
                ", prezzo: " + prezzo +
                '}';
    }
}
