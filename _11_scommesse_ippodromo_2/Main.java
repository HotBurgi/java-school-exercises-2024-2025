package _11_scommesse_ippodromo_2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static String [] cavalli = null;
    private static final int CASSAGIOCATORE = 100;
    private static final int COSTOPUNTATA = 5;
    private static final int COEFFICIENTEPIAZZATO = 2;
    private static final int COEFFICIENTEVINCENTE = 10;

    public static void setup(){
        cavalli = new String[] {"ettore", "agamennone", "Lucrezio", "Seneca", "ettore2",
                "agamennone2", "Lucrezio2", "Seneca2", "Martinelli", "Eugen"};
    }
    public static int  scommessaPiaz(){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i < cavalli.length; i++){
            System.out.println((i + 1 ) + ") " + cavalli[i]);
        }
        System.out.println("Scegli cavallo:");
        return sc.nextInt();
    }

    private static boolean giaPreso(int[] podio, int cavallo){
        for (int i = 0; i < podio.length; i++){
            if (cavallo == podio[i]){
                return true;
            }
        }
        return false;
    }

    public static int[] classifica(){
        Random r = new Random();
        int [] indici = new int[3];
        for (int i=0;i<3;i++){
            int cavallo;
            do {
                cavallo = r.nextInt(10);
            } while (giaPreso(indici, cavallo));
            indici[i] = cavallo;
        }
        return indici;
    }

    public static boolean primo(int cavallo, int[] podio){
        if( podio[0] == cavallo){
            return true;
        }
        return false;
    }
    public static boolean inPodio(int cavallo, int[] podio){
        for (int i = 0; i < podio.length; i++){
            if (cavallo == podio[i]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int contoGiocatore = CASSAGIOCATORE;

        int scelta ;

        int[] podio = null;
        Scanner sc = new Scanner(System.in);
        Giocatore mattia = new Giocatore();
        setup();
        do {
            System.out.println("Bilancio giocatore:\t" + mattia.getCassa());
            System.out.println("0.esci\n" +
                    "1.Scommetti \n" +
                    "2.gara \n" +
                    "3.Visualizza risultati");

            scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    mattia.setIndiceCavallo(scommessaPiaz() - 1);
                    System.out.println(mattia.getIndiceCavallo());
                    System.out.println("1. vincente\n2. piazzato");
                    mattia.setPv(sc.nextInt());

                    break;
                case 2:
                    podio = classifica();
                    for (int i=0;i<3;i++){
                        System.out.println(podio[i]);
                    }
                    break;
                case 3:
                    if (mattia.getIndiceCavallo() != -1
                            && podio != null){
                        contoGiocatore -= COSTOPUNTATA;
                        if (primo(mattia.getIndiceCavallo(), podio)) {
                            mattia.setCassa( mattia.getCassa() +
                                            COSTOPUNTATA * COEFFICIENTEVINCENTE );
                        } else if (inPodio(mattia.getIndiceCavallo(), podio)) {
                            mattia.setCassa( mattia.getCassa() +
                                    COSTOPUNTATA * COEFFICIENTEPIAZZATO );
                        }
                    } else {
                        System.out.println(mattia.getIndiceCavallo() + "\t" + podio.length);
                        System.out.println("Eseguire prima passaggi 1 e 2.");
                    }


                    break;
            }

        } while ( scelta != 0 );
    }
}
