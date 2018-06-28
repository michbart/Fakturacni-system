package cz.jcu.uaidoklad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLController implements Initializable {
    

    @FXML
    private Button PrihlasitBtn;
    @FXML
    private Button RegistrovatBtn;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField HesloPassField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * 
     * @param event, udalost pri kliknuti na tlacitko prihlasit
     */
    @FXML
    private void PrihlasitClickedBtn(ActionEvent event) {

        String login = loginTextField.getText();
        String heslo = HesloPassField.getText();

        Boolean kontrola = login.isEmpty() || heslo.isEmpty();
        if (kontrola) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Nezadali jste heslo nebo login.");
            alert.showAndWait();
            return;
        }

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
        //zavre se uvodni okno
        Stage stage = (Stage) PrihlasitBtn.getScene().getWindow();
        stage.close();

    }
    /**
     * 
     * @param event, udalost pri kliknuti na registraci
     */

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
