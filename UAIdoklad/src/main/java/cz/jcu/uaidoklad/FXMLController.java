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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void PrihlasitClickedBtn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/HlavniOkno.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("UAIdoklad");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Chyba");
        }
    }

    @FXML
    private void RegistrovatClickedBtn(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Registrace.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("UAIdoklad - Registrace");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Chyba");
        }

        //zavre se uvodni okno
        Stage stage = (Stage) RegistrovatBtn.getScene().getWindow();
        stage.close();
    }
}
