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
import cz.jcu.uaidoklad.Model.FakturaRepositoryMock;
import cz.jcu.uaidoklad.Model.FakturaService;
import cz.jcu.uaidoklad.Model.Firma;
import cz.jcu.uaidoklad.Model.*;
import cz.jcu.uaidoklad.View.View;
import cz.jcu.uaidoklad.View.ViewClass;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.omg.CORBA.portable.ValueFactory;

/**
 * FXML Controller class
 *
 * @author Tomáš
 */
public class HlavniOknoController implements Initializable {

    private View v;
    private Controller c;
    private HashMap<Integer, Integer> polozky;
    private Faktura f;
    private FakturaService fakturaService;
    private FakturaService db;
    private ObservableList<Firma> oListStavaka;
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
    private Tab KontaktyTab;
    
    @FXML
    private ListView<?> SeznamFakturListView;

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
    @FXML
    private TableView<Firma> tabulkaKontaky;
    @FXML
    private TableColumn<Firma, String> nazevKontak;
    @FXML
    private TableColumn<?, ?> uliceKontakty;
    @FXML
    private TableColumn<?, ?> psc;
    @FXML
    private TableColumn<?, ?> mesto;
    @FXML
    private TableColumn<?, ?> stat;
    @FXML
    private TableColumn<?, ?> ico;
    @FXML
    private TableColumn<?, ?> dic;
    @FXML
    private TableColumn<?, ?> telefon;
    @FXML
    private TableColumn<?, ?> email;
    @FXML
    private TableColumn<?, ?> cisloUctu;
    @FXML
    private TableView<?> tableFaktura;
    @FXML
    private TableColumn<?, ?> cisloFaktury;
    @FXML
    private TableColumn<?, ?> datumSplatnosti;
    @FXML
    private TableColumn<?, ?> nazevDodavatele;
    @FXML
    private TableColumn<?, ?> nazevOdberatele;
    @FXML
    private TableColumn<?, ?> zpusobPlatby;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            v = new ViewClass();
            c = new ControllerClass();
<<<<<<< HEAD
            fakturaService =  new FakturaServiceImpl();
=======
            fakturaService = new FakturaServiceImpl();
>>>>>>> bb848f8e416eeac3fda2d3b60de5b49f44c3249c
        } catch (Exception ex) {
            //Logger.getLogger(HlavniOknoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ZakaznikComboBox.getItems().clear();
        
        
        naplnFirmy();
        nastavDodavatele();
        naplnPlatbu();
        oListStavaka = FXCollections.observableArrayList(fakturaService.getFirmy());
        naplnListFirem();
        naplnListFaktur();
    }

    public HlavniOknoController() throws Exception {
        Thread nacteniDB = new Thread(new Runnable() {
            public void run() {
                try {
<<<<<<< HEAD
                    db = new FakturaServiceImpl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244879?characterEncoding=UTF-8", "sql7244879", "CBmxSwfY9y");
=======
                    db = new FakturaServiceImpl();//FakturaRepositoryImpl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244879?characterEncoding=UTF-8", "sql7244879", "CBmxSwfY9y");
>>>>>>> bb848f8e416eeac3fda2d3b60de5b49f44c3249c
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        nacteniDB.start();

        polozky = new HashMap<>();
        polozky.put(1, 2);

    }

    /**
     * Nastavi udaje o dodavateli
     */
    private void nastavDodavatele() {
        nazevLabel.setText(fakturaService.getFirmy().get(0).getNazev());
        uliceLabel.setText(fakturaService.getFirmy().get(0).getUlice());
        pscLabel.setText(String.valueOf(fakturaService.getFirmy().get(0).getPsc()));
        mestoLabel.setText(fakturaService.getFirmy().get(0).getMesto());
        statLabel.setText(fakturaService.getFirmy().get(0).getStat());
        icoLabel.setText(String.valueOf(fakturaService.getFirmy().get(0).getIc()));
        dicLabel.setText(String.valueOf(fakturaService.getFirmy().get(0).getDic()));
        ucetLabel.setText(fakturaService.getFirmy().get(0).getCisloUctu());
        emailLabel.setText(fakturaService.getFirmy().get(0).getEmail());
        mobilLabel.setText(fakturaService.getFirmy().get(0).getTelefon());
    }

    private void naplnFirmy() {
        ZakaznikComboBox.getItems().addAll(fakturaService.getFirmy());
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

    private void naplnListFaktur() {

    }

    
    private void naplnListFirem(){
        for(Firma f : fakturaService.getFirmy()){
            tabulkaKontaky.setItems(oListStavaka);
       //nazevKontak.setText(value);
        }
            
       

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
        Alert alert;
        try {
            Faktura fa = new Faktura(101, 2001, fakturaService.getFirmy().get(0), ZakaznikComboBox.getSelectionModel().getSelectedItem(), fakturaService.getFakturaById(1).getPolozky(), datumSplatnostiDate.getValue().toString(), ZpusobUhradyComboBox.getValue(), 1);

            c.exportAsPDF(fa, (FakturaRepositoryImpl) db);
            c.createFaktura(fa);
            alert = new Alert(AlertType.INFORMATION, "Faktura č." + fa.getCislo() + " byla vygenerována", ButtonType.OK);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        } catch (Exception e) {
            alert = new Alert(AlertType.ERROR, "Chyba při vytváření PDF.\n Zkontrolujte, zda jste vyplnili všechny pole", ButtonType.OK);
            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }
        }

    }

    @FXML
    private void DalsiPolozkaClickedBtn(ActionEvent event) {
    }

}
