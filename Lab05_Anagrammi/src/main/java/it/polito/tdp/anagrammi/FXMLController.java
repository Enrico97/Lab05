package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtparola;

    @FXML
    private Button btncalcola;

    @FXML
    private TextArea txtcorretti;

    @FXML
    private TextArea txterrati;

    @FXML
    private Button btnreset;

    @FXML
    void calcola(ActionEvent event) {
    	txtcorretti.clear();
    	txterrati.clear();
    	String inserito = txtparola.getText().toLowerCase().replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	for (Parola p : model.anagrammi(inserito.trim())) {
    		if (p.isCorretta())
    			txtcorretti.appendText(p.getNome()+"\n");
    		else {
    			txterrati.appendText(p.getNome()+"\n");
    		}
    	}
    }

    @FXML
    void reset(ActionEvent event) {
    	txtparola.clear();
    	txtcorretti.clear();
    	txterrati.clear();
    }
    public void setModel (Model model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtparola != null : "fx:id=\"txtparola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btncalcola != null : "fx:id=\"btncalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtcorretti != null : "fx:id=\"txtcorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txterrati != null : "fx:id=\"txterrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnreset != null : "fx:id=\"btnreset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
