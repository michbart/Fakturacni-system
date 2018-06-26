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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Tomáš
 */
public class RegistraceController implements Initializable {

    @FXML
    private TextField NazevTextField;
    @FXML
    private TextField UliceTextField;
    @FXML
    private TextField MestoTextField;
    @FXML
    private TextField PSCTextField;
    @FXML
    private TextField StatTextField;
    @FXML
    private TextField MobilTextField;
    @FXML
    private TextField EmailTextField;
    @FXML
    private TextField CisloUctuTextField;
    @FXML
    private TextField icoTextField;
    @FXML
    private TextField dicTextField;
    @FXML
    private TextField LoginTextField;
    @FXML
    private Button StornoBtn;
    @FXML
    private Button RegistrovatBtn;
    @FXML
    private TextField HesloTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void StornoClickedBtn(ActionEvent event) {
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
        
        Stage stage = (Stage) StornoBtn.getScene().getWindow();
        stage.close();
   
    }

    @FXML
    private void RegistrovatClickedBtn(ActionEvent event) {
    }
    
}
