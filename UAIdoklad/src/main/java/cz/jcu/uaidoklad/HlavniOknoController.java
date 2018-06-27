/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane SeznamFakturPane;
    @FXML
    private Tab PridatKontaktTab;
    @FXML
    private AnchorPane PridatKontaktPane;
    @FXML
    private TextField NazevOdberateleTField;
    @FXML
    private TextField UliceOdberateleTField;
    @FXML
    private TextField MestoOdberateleTField;
    @FXML
    private TextField PSCOdberateleTField;
    @FXML
    private TextField StatOdberateleTField;
    @FXML
    private TextField MobilOdberateleTField;
    @FXML
    private TextField EmailOdberateleTField;
    @FXML
    private TextField ICOOdberateleTField;
    @FXML
    private TextField DICOdberateleTField;
    @FXML
    private AnchorPane KontaktyPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OdhlasitClickedBtn(ActionEvent event) {
        //otevre se uvodni okno
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("UAIdoklad");
            stage.setScene(scene);
            stage.show();
            
        } catch (Exception e) {
            System.out.println("Chyba");
        }
        
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
    
}
