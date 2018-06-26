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
