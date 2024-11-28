package _18_telecomunicazioni_RC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pick;

        // Parametri iniziali
        int ampiezzaIniziale = -1;
        double C = -1;
        double R = -1;

        // Costanti per il calcolo
        final double fMin = 1.0;         // Frequenza minima in Hz
        final double fMax = 30000.0;    // Frequenza massima in Hz
        final int nPassi = 30;          // Numero di passi per il calcolo
        final double dimensionePassi = (fMax - fMin) / (nPassi - 1);

        do {
            // Menu
            System.out.println("\n--- Menu ---");
            System.out.println("0. Esci");
            System.out.println("1. Inserisci ampiezza iniziale");
            System.out.println("2. Inserisci C (in F)");
            System.out.println("3. Inserisci R (in Ω)");
            System.out.println("4. Calcola la tabella");
            System.out.print("Seleziona un'opzione: ");

            // Verifica input del menu
            while (!scanner.hasNextInt()) {
                System.out.println("Errore: inserisci un numero intero valido.");
                scanner.next(); // Pulisce l'input non valido
            }
            pick = scanner.nextInt();

            // Gestione delle opzioni del menu
            switch (pick) {
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;

                case 1:
                    System.out.print("Inserisci l'ampiezza iniziale: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Errore: inserisci un valore intero valido.");
                        scanner.next();
                    }
                    ampiezzaIniziale = scanner.nextInt();
                    System.out.println("Ampiezza iniziale impostata a: " + ampiezzaIniziale);
                    break;

                case 2:
                    System.out.print("Inserisci C (capacità in farad): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Errore: inserisci un valore numerico valido.");
                        scanner.next();
                    }
                    C = scanner.nextDouble();
                    System.out.println("Capacità impostata a: " + C + " F");
                    break;

                case 3:
                    System.out.print("Inserisci R (resistenza in ohm): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Errore: inserisci un valore numerico valido.");
                        scanner.next();
                    }
                    R = scanner.nextDouble();
                    System.out.println("Resistenza impostata a: " + R + " Ω");
                    break;

                case 4:
                    // Controllo che tutti i parametri siano stati inseriti
                    if (ampiezzaIniziale == -1 || C == -1 || R == -1) {
                        System.out.println("Errore: devi prima inserire tutti i valori (ampiezza iniziale, C e R).");
                        break;
                    }

                    // Calcolo e stampa della tabella
                    System.out.println("\n--- Tabella Teorica ---");
                    System.out.printf("%-15s %-15s %-15s%n", "Frequenza (Hz)", "Modulo", "Fase (rad)");
                    for (int i = 0; i < nPassi; i++) {
                        double frequenza = fMin + i * dimensionePassi;
                        double modulo = ampiezzaIniziale / Math.sqrt(1 + Math.pow((2 * Math.PI * frequenza) * C * R, 2));
                        double fase = -Math.atan((2 * Math.PI * frequenza) * C * R);
                        System.out.printf("%-15.2f %-15.2f %-15.2f%n", frequenza, modulo, fase);
                    }
                    break;

                default:
                    System.out.println("Errore: opzione non valida. Scegli un numero tra 0 e 4.");
                    break;
            }
        } while (pick != 0);

        scanner.close(); // Chiude lo scanner
    }
}