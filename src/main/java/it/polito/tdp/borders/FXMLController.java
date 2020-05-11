
package it.polito.tdp.borders;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Model;
import it.polito.tdp.borders.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	private ComboBox<Country> cmboxStati;

	@FXML
	private Button btnCerca;

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		int anno = Integer.parseInt(txtAnno.getText());
		this.model.creaGrafo(anno);
		// List<Supporto> list = new ArrayList<Supporto>(this.model.elencoStati()) ;
		// for(Supporto s : list) {
		// txtResult.appendText(s+"\n");
		// }
		cmboxStati.getItems().addAll(this.model.popoloTendina());
	}

	@FXML
	void cerca(ActionEvent event) {
		cmboxStati.getValue();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cmboxStati != null : "fx:id=\"cmboxStati\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
