/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class Databaze implements DBInterface {

    private String driver = "com.mysql.jdbc.Driver";
    private Connection pripojeni;

    /**
     * Constructor - pripojeni k DB
     *
     * @param url adresa databaze
     * @param uzivatel jmeno administratora
     * @param heslo heslo k DB
     * @throws Exception
     */
    public Databaze(String url, String uzivatel, String heslo) throws Exception {
        try {
            Class.forName(driver);
            pripojeni = (Connection) DriverManager.getConnection(url, uzivatel, heslo);
        } catch (SQLException ex) {
            throw new Exception("Nastala chyba při připojování k databázi.");
        }
    }

    /**
     * Odeslani SQL prikazu
     *
     * @param dotaz prikaz v SQL
     * @return pocet zmenenych radek
     * @throws Exception
     */
    private int poslatPrikaz(String dotaz) throws Exception {
        try (Statement st = pripojeni.createStatement()) {
            return st.executeUpdate(dotaz);
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    /**
     * Pridani do databaze INSERT
     *
     * @param tabulka nazev tabulky
     * @param nazevHodnota HashMap s nazvem atributu a jeho hodnotou
     * @throws Exception
     */
    private void zapsatDB(String tabulka, HashMap<String, String> nazevHodnota) throws Exception {
        String nazvy = "";
        String hodnoty = "";
        for (String nazev : nazevHodnota.keySet()) {
            nazvy = nazvy + nazev + ", ";
            hodnoty = hodnoty + nazevHodnota.get(nazev) + ", ";
        }
        try {
            String dotaz = "INSERT INTO " + tabulka + " (" + nazvy.substring(0, nazvy.length() - 2) + ") VALUES(" + hodnoty.substring(0, hodnoty.length() - 2) + ");";
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nepodařilo se zapsat do databáze." + ex.getMessage());
        }
    }

    /**
     * Mazani prvku z databaze podle Nazvu a Id
     *
     * @param tabulka Nazev Tabulky
     * @param nazevId nazev Id prvku
     * @param id hodnota Id Prvku
     * @throws Exception
     */
    private void smazatDB(String tabulka, String nazevId, String id) throws Exception {
        try {
            String dotaz = "DELETE FROM " + tabulka + " WHERE " + nazevId + " = " + id;
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nastala chyba při mazání v databázi." + ex.getMessage());
        }
    }

    /**
     * prepsani atributu v DB
     *
     * @param tabulka nazev tabulky
     * @param sloupecZmena co se ma prepsat
     * @param hodnotaZmena na co se ma prepsat
     * @param nazevId nazev id prvku
     * @param id id prvku
     * @throws Exception
     */
    private void upravitDB(String tabulka, String sloupecZmena, String hodnotaZmena, String nazevId, String id) throws Exception {
        try {
            String dotaz = "UPDATE " + tabulka + " SET " + sloupecZmena + " = '" + hodnotaZmena + "' WHERE " + nazevId + " = " + id;
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nastala chyba při pŕepisování dat v databázi." + ex.getMessage());
        }
    }

    private ArrayList<String> ziskatUdajeDB(String dotaz, String sloupec) throws Exception {
        ArrayList<String> vysledek = new ArrayList();
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            while (rs.next()) {//ziskani dat kazdeho slouce
                vysledek.add(rs.getString(sloupec));
            }
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vysledek;
    }

    @Override
    public Faktura getFakruta(int id) throws Exception {
        String dotaz = "SELECT * FROM nkRecept r INNER JOIN nkUzivatel u ON r.fkIdUzivatel = u.idUzivatel WHERE idRecept = '" + id + "';";
        String dotazTyp = "SELECT * FROM nkRecept WHERE idRecept = '" + id + "';";
        String typFaktury = ziskatUdajeDB(dotazTyp, "typ").get(0);
        int idDodavatel;
        int idOdberatel;
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            Faktura vystup;
            switch (rs.getString("typ")) {
                case "FakturaA":
                    vystup = new Faktura(rs.getInt("id"), rs.getInt("cislo"), this.getUzivatel(idDodavatel), this.getUzivatel(idOdberatel), this.getListPolozekF(id), rs.getString("datumSplatnosti"), rs.getString("zpusobPlatby"));
                    break;
                default:
                    throw new AssertionError();
            }
            return vystup;
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
    }

    @Override
    public void smazFaktura(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Faktura> getListFaktur() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zmenFakturu(Faktura faktura) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Ziskani Uzivatele z DB
 * @param id
 * @return
 * @throws Exception 
 */
    @Override
    public Uzivatel getUzivatel(int id) throws Exception {
        String dotaz = "SELECT * FROM Uzivatel WHERE idRecept = '" + id + "';";
        Uzivatel vystup;

        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            vystup = new Uzivatel(rs.getInt("id"), rs.getString("nazev"), rs.getString("login"), rs.getInt("heslo"), rs.getString("ulice"), rs.getInt("psc"), rs.getString("mesto"), rs.getString("stat"), rs.getInt("ic"), rs.getInt("dic"), Integer.getInteger(rs.getString("telefon")), rs.getString("email"), rs.getString("cisloUctu"));
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    /**
     * Ziskani Uzivatele z DB
     * @param login
     * @param heslo
     * @return
     * @throws Exception 
     */
    @Override
    public Uzivatel getUzivatel(String login, int heslo) throws Exception {
        String dotaz = "SELECT * FROM Uzivatel WHERE login = '" + login + "' AND heslo = '" + heslo + "';";
        Uzivatel vystup;

        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            vystup = new Uzivatel(rs.getInt("id"), rs.getString("nazev"), rs.getString("login"), rs.getInt("heslo"), rs.getString("ulice"), rs.getInt("psc"), rs.getString("mesto"), rs.getString("stat"), rs.getInt("ic"), rs.getInt("dic"), Integer.getInteger(rs.getString("telefon")), rs.getString("email"), rs.getString("cisloUctu"));
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    @Override
    public void smazUzivatele(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zmenUzivatele(Uzivatel uzivatel) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Uzivatel> getListUzivatel() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Polozka> getListPolozek() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private HashMap<Integer,Integer> getListPolozekF(int idFaktury){
        HashMap<Integer,Integer> vystup = new HashMap();
        
        return vystup;
    }
    @Override
    public void zmenPolozku(Polozka polozka) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smazPolozku(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Polozka getPolozka(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
