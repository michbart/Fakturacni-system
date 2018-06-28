/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michal
 */
public class FakturaServiceImpl implements FakturaService {
    
    private FakturaRepository db;
    
    public FakturaServiceImpl() throws Exception{
        db = new Databaze("sql7.freemysqlhosting.net", "sql7244879", "CBmxSwfY9y");
    }
    
    @Override
    public void exportAsPDF(Faktura f, Databaze db) {
        new PDF(f, db).vygeneruj();
    }

    @Override
    public Faktura getFakturaById(int id) {
        try {
            return db.getFaktura(id);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
