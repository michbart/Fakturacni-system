/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;


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
        db = new FakturaRepositoryImpl("sql7.freemysqlhosting.net", "sql7244879", "CBmxSwfY9y");
    }
    
    @Override
    public void exportAsPDF(Faktura f, FakturaRepositoryImpl db) {
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
        try {
            return db.getListFaktur();
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void createFaktura(Faktura f) {
        
    }

    @Override
    public void updateFaktura(Faktura f) {
        try {
            db.zmenFakturu(f);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteFaktura(int id) {
        try {
            db.smazFaktura(id);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
