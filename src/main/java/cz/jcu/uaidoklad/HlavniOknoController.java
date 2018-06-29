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
import cz.jcu.uaidoklad.Model.FirmaRepositoryMock;
import cz.jcu.uaidoklad.View.View;
import cz.jcu.uaidoklad.View.ViewClass;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Tomáš
 */
public class HlavniOknoController implements Initializable {
    
    private View v;
    private Controller c;
    private FakturaRepositoryImpl db;
    private HashMap<Integer, Integer> polozky;
    private Faktura f;
    private FirmaRepositoryMock firmaMock;
    
    @FXML
    private Button ZavritBtn;
    
    @FXML
    private Button UlozitBtn;
    
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
    private TextField PopisZboziTextField;
    
    @FXML
    private TextField PocetKsZboziTextField;
    
    @FXML
    private TextField CenaKusZboziTField;
    
    @FXML
    private Button DalsiPolozkaBtn;
    
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
    
    @FXML
    private Text nazevLabel;
    
    @FXML
    private Text uliceLabel;
    
    @FXML
    private Text mestoLabel;
    
    @FXML
    private Text pscLabel;
    
    @FXML
    private Text statLabel;
    
    @FXML
    private Text icoLabel;
    
    @FXML
    private Text dicLabel;
    
    @FXML
    private Text ucetLabel;
    
    @FXML
    private Text emailLabel;
    
    @FXML
    private Text mobilLabel;
    @FXML
    private ComboBox<Firma> ZakaznikComboBox;
    @FXML
    private ComboBox<String> ZpusobUhradyComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            v = new ViewClass();
        } catch (Exception ex) {
            //Logger.getLogger(HlavniOknoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ZakaznikComboBox.getItems().clear();
        firmaMock = new FirmaRepositoryMock();
        naplnFirmy();
        nastavDodavatele();
        naplnPlatbu();
    }
    
    public HlavniOknoController() throws Exception {
        Thread nacteniDB = new Thread(new Runnable() {
            public void run() {
                try {
                    db = new FakturaRepositoryImpl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244879?characterEncoding=UTF-8", "sql7244879", "CBmxSwfY9y");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        nacteniDB.start();

        polozky = new HashMap<>();
        polozky.put(1, 2);
        c = new ControllerClass();
        
    }
    
    /**
     * Nastavi udaje o dodavateli
     */
    private void nastavDodavatele() {
        nazevLabel.setText(firmaMock.getFirmy().get(0).getNazev());
        uliceLabel.setText(firmaMock.getFirmy().get(0).getUlice());
        pscLabel.setText(String.valueOf(firmaMock.getFirmy().get(0).getPsc()));
        mestoLabel.setText(firmaMock.getFirmy().get(0).getMesto());
        statLabel.setText(firmaMock.getFirmy().get(0).getStat());
        icoLabel.setText(String.valueOf(firmaMock.getFirmy().get(0).getIc()));
        dicLabel.setText(String.valueOf(firmaMock.getFirmy().get(0).getDic()));
        ucetLabel.setText(firmaMock.getFirmy().get(0).getCisloUctu());
        emailLabel.setText(firmaMock.getFirmy().get(0).getEmail());
        mobilLabel.setText(firmaMock.getFirmy().get(0).getTelefon());
    }
    
    private void naplnFirmy() {
        ZakaznikComboBox.getItems().addAll(firmaMock.getFirmy());
        ZakaznikComboBox.setConverter(new StringConverter<Firma>() {
            @Override
            public String toString(Firma f) {
                return f.getNazev();
            }
            
            @Override
            // not used...
            public Firma fromString(String s) {
                return null;
            }
        });
    }
    
    private void naplnPlatbu() {
        ZpusobUhradyComboBox.getItems().addAll(v.getPlatba());
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
    private void PDFClickedBtn(ActionEvent event) {
        Faktura fa = new Faktura(101, 2001, firmaMock.getFirmy().get(0), ZakaznikComboBox.getSelectionModel().getSelectedItem(), polozky, datumSplatnostiDate.getValue().toString(), ZpusobUhradyComboBox.getValue(), 1);
        
        c.exportAsPDF(fa, db);
        c.createFaktura(fa);
    }
    
    @FXML
    private void DalsiPolozkaClickedBtn(ActionEvent event) {
    }
    
}
