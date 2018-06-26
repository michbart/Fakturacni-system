package cz.jcu.uaidoklad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    private Label label;
    @FXML
    private Button PrihlasitBtn;
    @FXML
    private Button RegistrovatBtn;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField HesloTextField;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PrihlasitClickedBtn(ActionEvent event) {
    }

    @FXML
    private void RegistrovatClickedBtn(ActionEvent event) {
    }
}
