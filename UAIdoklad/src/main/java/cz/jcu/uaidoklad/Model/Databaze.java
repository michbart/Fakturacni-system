/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Michal
 */
public class Databaze {
    private String driver = "com.mysql.jdbc.Driver";
    private Connection pripojeni;
    
    public Databaze(String url, String uzivatel, String heslo, String[] mozneHodnoceni) throws Exception {
        pripojeni(url, uzivatel, heslo);
    }
    
    private void pripojeni(String url, String uzivatel, String heslo) throws Exception {
        try {
            Class.forName(driver);
            pripojeni = (Connection) DriverManager.getConnection(url, uzivatel, heslo);
        } catch (SQLException ex) {
            throw new Exception("Nastala chyba při připojování k databázi.");
        }
    }
}
