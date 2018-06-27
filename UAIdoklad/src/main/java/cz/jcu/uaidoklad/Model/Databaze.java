/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class Databaze {

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
            hodnoty = hodnoty + hodnoty + ", ";
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
     * @param tabulka nazev tabulky
     * @param sloupecZmena co se ma prepsat
     * @param hodnotaZmena na co se ma prepsat
     * @param nazevId nazev id prvku
     * @param id id prvku
     * @throws Exception 
     */
    public void upravitDB(String tabulka, String sloupecZmena, String hodnotaZmena, String nazevId, String id) throws Exception {
        try {
            String dotaz = "UPDATE " + tabulka + " SET " + sloupecZmena + " = '" + hodnotaZmena + "' WHERE " + nazevId + " = " + id;
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nastala chyba při pŕepisování dat v databázi." + ex.getMessage());
        }
    }

}
