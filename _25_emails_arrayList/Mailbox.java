package _25_emails_arrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mailbox {
    final static int EMAIL_PIENO = -1;
    ArrayList<Email> emails;

    public Mailbox() {
        emails = new ArrayList<>();
    }

    public void aggiungiEmail(Email email) {
        emails.add(email);
    }

    public ArrayList<Email> ricercaMittente(String trovaMittente) {
        ArrayList<Email> contenitore = new ArrayList<>();
        for (Email email : emails) {
            if (email != null && trovaMittente.equals(email.getMittente())) {
                contenitore.add(email);
            }
        }
        return contenitore;
    }

    public void scriviFile() {
        try {
            File file = new File("emails.txt");
            FileWriter fw = new FileWriter(file);
            for (Email email : emails) {
                fw.write(email.data());
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Email fromStringtoObject(String data) {
        StringTokenizer st = new StringTokenizer(data, ";");
        String mittente = st.nextToken();
        String oggetto = st.nextToken();
        LocalDate dataOra = LocalDate.parse(st.nextToken());
        String testo = st.nextToken();
        return new Email(mittente, oggetto, dataOra, testo);
    }

    public void leggiFile() {
        try {
            File myObj = new File("emails.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Email email = fromStringtoObject(data);
                this.aggiungiEmail(email);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Pieno");
        }
    }

    public ArrayList<Email> getEmailsByMittente(String mittente) {
        ArrayList<Email> result = new ArrayList<>();
        for (Email email : emails) {
            if (email.getMittente().equals(mittente)) {
                result.add(email);
            }
        }
        return result;
    }

    public void tutti() {
        for (Email email : emails) {
            if (email != null) {
                System.out.println(email);
            }
        }
    }
}