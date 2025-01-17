package _25_emails_arrayList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Mailbox mailbox = new Mailbox();

    public static Email leggiDatiEmail() {
        Scanner sc1 = new Scanner(System.in);
        String mittente, oggetto, testo;
        LocalDate dataOra;
        mittente = sc1.next();
        oggetto = sc1.next();
        dataOra = LocalDate.now();
        testo = sc1.next();
        return new Email(mittente, oggetto, dataOra, testo);
    }

    public static void main(String[] args) {
        int scelta;
        Scanner sc = new Scanner(System.in);
        Email email;

        do {
            System.out.println(
                    """
                            1.aggiungi
                            2.scrivi file
                            3.visualizza tutti
                            9.leggi file
                            4.ricerca per mittente
                            9.leggi file
                            """);
            scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    try {
                        email = leggiDatiEmail();
                        mailbox.aggiungiEmail(email);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    mailbox.scriviFile();
                    break;
                case 3:
                    mailbox.tutti();
                    break;
                case 9:
                    mailbox.leggiFile();
                    break;
                case 4:
                    System.out.println("Inserisci il mittente:");
                    String mittente = sc.next();
                    ArrayList<Email> emails = mailbox.getEmailsByMittente(mittente);
                    for (Email e : emails) {
                        System.out.println(e);
                    }
                    break;
            }
        } while (scelta != 0);
    }
}