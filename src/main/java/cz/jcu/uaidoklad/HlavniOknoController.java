/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad;

import cz.jcu.uaidoklad.Model.FakturaService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Tomáš
 */
public class HlavniOknoController implements Initializable {

    @FXML
    private Button OdhlasitBtn;
    
    @FXML
    private Button UlozitBtn;
    
    @FXML
    private Button UpravitBtn;
    
    @FXML
    private Button PDFBtn;
    
    @FXML
    private Tab InformaceTab;
    
    @FXML
    private Tab VytvorFakturuTab;
    
    @FXML
    private Tab SeznamFakturTab;
    
    @FXML
    private Tab KontaktyTab;
    
    @FXML
    private AnchorPane InformacePane;
    
    @FXML
    private AnchorPane VytvorFakturuPane;
        
    @FXML
    private Text NazevText;
    
    @FXML
    private Text UliceText;
    
    @FXML
    private Text MestoText;
    
    @FXML
    private Text PSCText;
    
    @FXML
    private Text StatText;
    
    @FXML
    private Text MobilText;
    
    @FXML
    private Text CisloUctuText;
    
    @FXML
    private Text EmailText;
    
    @FXML
    private Text ICOText;
    
    @FXML
    private Text DICText;
      
    @FXML
    private ChoiceBox<?> KontaktChoiceBox;
    
    @FXML
    private TextField DatumSplatnostiTField;
        
    @FXML
    private TextField PopisZboziTextField;
    
    @FXML
    private TextField PocetKsZboziTextField;
    
    @FXML
    private TextField CenaKusZboziTField;
    
    @FXML
    private Button DalsiPolozkaBtn;
    
    @FXML
    private ListView<?> SeznamFakturListView;
    
    @FXML
    private ListView<?> KontaktyListView;
    @FXML
    private ChoiceBox<?> ZpusobUhradyChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Odhlaseni a vraceni se na uvodni okno
     * @param event
     */
    @FXML
    private void OdhlasitClickedBtn(ActionEvent event) {
        
        Stage stage = (Stage) OdhlasitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void UlozitClickedBtn(ActionEvent event) {
    }

    @FXML
    private void UpravitClickedBtn(ActionEvent event) {
    }

    @FXML
    private void PDFClickedBtn(ActionEvent event) {
        
    }

    @FXML
    private void DalsiPolozkaClickedBtn(ActionEvent event) {
    }
    
}
