/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import cz.jcu.uaidoklad.Model.Faktura;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Petr
 */
public class Soubory {
    
    private String cestaKSouborum;
    
    
    
    /**
     * 
     * @param cestaKSouborum
     * @throws Exception 
     */
    
    public Soubory(String cestaKSouborum) throws Exception {
        File soubor = new File(cestaKSouborum);
        if (!soubor.isDirectory()){
            if (soubor.mkdirs()){
                throw new Exception("Nastala chyba pri tvorbe adresare");
            }
        }
    }
    
    
    
  
 /**
  * 
  * @param cesta
  * @throws Exception 
  */
    
    private void overeniCesty(String cesta) throws Exception {
        File soubor = new File(cesta);
        if (!soubor.isDirectory()) {
            if (!soubor.mkdirs()) {
                throw new Exception("Nastala chyba pri tvorbe adresare");
            }
        }
    }
    
    

    /**
     * 
     * @param faktura
     * @throws Exception 
     */
    
    
    void ulozeniFaktury(Faktura faktura) throws Exception {
        
   // TO DO: zatim neznam parametr faktury pri ukladani -> faktura.ziskatNazev();
   
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(cestaKSouborum + faktur + ".dat")));) {
            oos.writeObject(faktura);
        } catch (Exception e) {
            throw new Exception("Nastala chyba pri ukladani faktury do souboru.");
        }
    }




/**
 *  TO DO: opet parametr nazevFaktury
 */

    Faktura nacistFakturu(String nazevFaktury) throws Exception {
        Faktura faktura;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(cestaKSouborum + nazevFaktury + ".dat")));) {
            faktura = (Faktura) ois.readObject();
        } catch (Exception ex) {
            throw new Exception("Nastala chyba nacitani faktury ze souboru.");
        }
        return faktura;
    }

    
    
}