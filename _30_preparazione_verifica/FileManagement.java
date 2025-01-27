package _30_preparazione_verifica;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManagement {
    private static final String filePath = "campeggio.txt";

    public static void saveOnFile(ArrayList<Prenotazione> prenotazioni) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Prenotazione prenotazione : prenotazioni) {
                writer.write(prenotazione.toString());
                writer.write("\n");
            }
        } catch (Exception e) {
            System.out.println("ERRORE");
        }
    }

    public static ArrayList<Prenotazione> prenotazioni() {
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] data;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); //opzionale (toglie gli spazi all'inizio e alla fine)
                data = line.split(";");
                Prenotazione prenotazione = new Prenotazione(data[0], LocalDate.parse(data[1]), LocalDate.parse(data[2]), Integer.parseInt(data[3]), TipoPiazzola.valueOf(data[4]));
                prenotazioni.add(prenotazione);
            }
        } catch (IOException e) {
            System.out.println("ERRORE");
        }
        return prenotazioni;
    }
}


