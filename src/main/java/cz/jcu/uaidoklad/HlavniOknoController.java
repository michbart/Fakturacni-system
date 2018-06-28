/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad;

import cz.jcu.uaidoklad.Controller.Controller;
import cz.jcu.uaidoklad.Controller.ControllerClass;
import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.FakturaRepository;
import cz.jcu.uaidoklad.Model.FakturaRepositoryImpl;
import cz.jcu.uaidoklad.Model.Firma;
import cz.jcu.uaidoklad.View.View;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tomáš
 */
public class HlavniOknoController implements Initializable {

    View v;
    Controller c;
    FakturaRepositoryImpl db;
    Firma f1;
    HashMap<Integer, Integer> polozky;
    Faktura f;

    @FXML
    private Button ZavritBtn;

    @FXML
    private Button UlozitBtn;

    @FXML
    private Button UpravitBtn;

    @FXML
    private Button PDFBtn;

    @FXML
    private Tab InformaceTab;

    @FXML
    private AnchorPane InformacePane;

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
    private Tab VytvorFakturuTab;

    @FXML
    private AnchorPane VytvorFakturuPane;

    @FXML
    private ChoiceBox<?> KontaktChoiceBox;

    @FXML
    private TextField PopisZboziTextField;

    @FXML
    private TextField PocetKsZboziTextField;

    @FXML
    private TextField CenaKusZboziTField;

    @FXML
    private Button DalsiPolozkaBtn;

    @FXML
    private ChoiceBox<?> ZpusobUhradyChoiceBox;

    @FXML
    private DatePicker datumSplatnostiDate;

    @FXML
    private Tab SeznamFakturTab;

    @FXML
    private ListView<?> SeznamFakturListView;

    @FXML
    private Tab KontaktyTab;

    @FXML
    private ListView<?> KontaktyListView;

    @FXML
    private ListView<?> PolozkZboziListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public HlavniOknoController() throws Exception {
        Thread nacteniDB = new Thread(new Runnable(){
            public void run(){
                try {
                    db = new FakturaRepositoryImpl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244879?characterEncoding=UTF-8", "sql7244879", "CBmxSwfY9y");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        nacteniDB.start();
        f1 = new Firma(1, "nazev", "ulice", 555, "mesto", "stat", 123, 456, "1111111", "email", "123/0900");
        f = new Faktura(1, 201800001, f1, f1, polozky, "30.2.2019", "prevodem", 1);
        polozky = new HashMap<>();
        polozky.put(1, 2);
        c = new ControllerClass();
    }

    @FXML
    private void ZavritClickedBtn(ActionEvent event) {
        Stage stage = (Stage) ZavritBtn.getScene().getWindow();
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
        c.exportAsPDF(f, db);
    }

    @FXML
    private void DalsiPolozkaClickedBtn(ActionEvent event) {
    }

}
