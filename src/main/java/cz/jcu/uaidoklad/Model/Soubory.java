/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

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
    
    private String cestaKSouboru;
    
    public Soubory(String cestaKSouborum) throws Exception {
        this.cestaKSouboru = cestaKSouboru;
        overeniCesty(cestaKSouboru);
    }
    
   
    
  
 /**
  * Overi cestu k souboru
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
     * Ulozi obj faktura do souboru
     * @param faktura
     * @throws Exception 
     */
    
    
    void ulozeniFaktury(Faktura faktura) throws Exception {
        
    overeniCesty(cestaKSouboru);
   
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(cestaKSouboru + cisloFaktury + ".dat")));) {
            oos.writeObject(faktura);
        } catch (Exception e) {
            throw new Exception("Nastala chyba pri ukladani faktury do souboru.");
        }
    }




/**
 *  Nacte obj faktura ze souboru
 */

    Faktura nacistFakturu(String nazevFaktury) throws Exception {
        
        Faktura faktura;
        
        overeniCesty(cestaKSouboru);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(cestaKSouboru + cisloFaktury + ".dat")));) {
            faktura = (Faktura) ois.readObject();
        } catch (Exception ex) {
            throw new Exception("Nastala chyba nacitani faktury ze souboru.");
        }
        return faktura;
    }

    
    
}