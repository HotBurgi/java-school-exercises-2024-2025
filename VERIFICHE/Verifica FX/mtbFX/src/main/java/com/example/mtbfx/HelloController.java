package com.example.mtbfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label outputLbl;
    @FXML
    private TextField marcaTxt;
    @FXML
    private TextField modelloTxt;
    @FXML
    private RadioButton frontRadio;
    @FXML
    private RadioButton biRadio;
    @FXML
    private CheckBox monoChk;
    @FXML
    private CheckBox sellaChk;
    @FXML
    private CheckBox pompaChk;
    @FXML
    private ComboBox<String> coloreCbox;
    @FXML
    private Button scegliBtn;
    @FXML
    private Button annullaBtn;

    private MTB bicicletta = null;
    String[] marche = {"Marca 1", "Marca 2", "Marca 3", "Marca 4", "Marca 5"};
    String[] modelli = {"Modello 1", "Modello 2", "Modello 3", "Modello 4", "Modello 5"};

    @FXML
    public void initialize() {
        coloreCbox.getItems().addAll("blu", "rossa", "verde", "gialla");
    }

    @FXML
    protected void onScegliClick(){
        String marca;
        String modello;
        String colore;
        String tipoAmmortizzazione = frontRadio.isSelected() ? "front" : biRadio.isSelected() ? "bi-ammortizzata" : null;
        String[] accessoriSelezionati = getAccessori();

        if(marcaTxt.getText().isEmpty()){
            outputLbl.setStyle("-fx-text-fill: red;");
            outputLbl.setText("Selezionare una marca");
            return;
        } else if (checkEsistenza(marcaTxt.getText(), marche)){
            outputLbl.setStyle("-fx-text-fill: red;");
            outputLbl.setText("La marca non esiste");
            return;
        } else { marca = marcaTxt.getText(); }

        if(modelloTxt.getText().isEmpty()){
            outputLbl.setStyle("-fx-text-fill: red;");
            outputLbl.setText("Selezionare un modello");
            return;
        } else if (checkEsistenza(modelloTxt.getText(), modelli)){
            outputLbl.setStyle("-fx-text-fill: red;");
            outputLbl.setText("Il modello non esiste");
            return;
        } else { modello = modelloTxt.getText(); }

        if(coloreCbox.getSelectionModel().getSelectedItem() == null){
            outputLbl.setStyle("-fx-text-fill: red;");
            outputLbl.setText("Selezionare un colore");
            return;
        } else {
            colore = coloreCbox.getSelectionModel().getSelectedItem();
        }

        bicicletta = new MTB(marca, modello, tipoAmmortizzazione, colore, accessoriSelezionati);
        outputLbl.setStyle("-fx-text-fill: black;");
        outputLbl.setText(bicicletta.toString());
    }

    @FXML
    protected String[] getAccessori() {
        String[] accessoriSelezionati = new String[3];

        if (monoChk.isSelected()) {
            accessoriSelezionati[0] = "monocorona";
        }
        if (sellaChk.isSelected()) {
            accessoriSelezionati[1] = "alzasella";
        }
        if (pompaChk.isSelected()) {
            accessoriSelezionati[2] = "pompa ruote";
        }
        return accessoriSelezionati;
    }

    @FXML
    protected void onClickCleanScreen(){
        marcaTxt.clear();
        modelloTxt.clear();
        coloreCbox.getSelectionModel().clearSelection();
        frontRadio.selectedProperty().set(true);
        biRadio.selectedProperty().set(false);
        monoChk.selectedProperty().set(false);
        sellaChk.selectedProperty().set(false);
        pompaChk.selectedProperty().set(false);
    }

    private boolean checkEsistenza(String input, String[] collection){
        for (String s : collection) {
            if (s.equals(input)) {
                return false;
            }
        }
        return true;
    }
}