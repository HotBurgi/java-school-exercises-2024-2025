package _11_scommesse_ippodromo_2;

public class Giocatore {
    private int cassa;
    private int pv; // piazzato (0) / vincente (1)
    private int indiceCavallo;

    public Giocatore() {
        this.cassa = 100;
    }
    public int getCassa() {
        return cassa;
    }

    public int getPv() {
        return pv;
    }

    public int getIndiceCavallo() {
        return indiceCavallo;
    }

    public void setCassa(int cassa) {
        this.cassa = cassa;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setIndiceCavallo(int indiceCavallo) {
        this.indiceCavallo = indiceCavallo;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "cassa=" + cassa +
                ", pv=" + pv +
                ", indiceCavallo=" + indiceCavallo +
                '}';
    }
}
