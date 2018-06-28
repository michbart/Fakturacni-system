/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Michal
 */
public class FakturaServiceImpl implements FakturaService {
    Firma dod = new Firma(1, "nazev", "ulice", 555, "mesto", "stat", 123, 456, 1111111, "email","123/0900");
    Firma odb = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
    HashMap<Integer, Integer> polozky = new HashMap<>();
    private Faktura fa = new Faktura(1,12345, dod, odb, polozky, "dnes", "prevodem",1);
    
    @Override
    public void exportAsPDF(Faktura f, FakturaRepositoryImpl db) {
        new PDF(fa, db).vygeneruj();
    }

    @Override
    public Faktura getFakturaById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Faktura> getFaktury() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createFaktura(Faktura f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFaktura(Faktura f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFaktura(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
