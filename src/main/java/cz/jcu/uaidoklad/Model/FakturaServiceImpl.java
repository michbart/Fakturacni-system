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
    private Faktura fakt;
    
    public FakturaServiceImpl() throws Exception{
        db = new FakturaRepositoryImpl("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244879?characterEncoding=UTF-8", "sql7244879", "CBmxSwfY9y");
        fakt = new Faktura();
    }
    
    @Override
    public void exportAsPDF(Faktura f, FakturaRepositoryImpl db) {
        try {
            new PDF(f, db).vygeneruj();
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            db.ulozFaktura(f);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public Polozka getPolozkaById(int id) {
        try {
            return db.getPolozka(id);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Polozka> getPolozky() {
        try {
            return db.getListPolozek();
        } catch (Exception ex) {
            Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void createPolozka(Polozka p) {
        try {
            db.ulozPolozka(p);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePolozka(Polozka p) {
        try {
            db.zmenPolozku(p);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePolozka(int id) {
        try {
            db.smazPolozku(id);
        } catch (Exception ex) {
            //Logger.getLogger(FakturaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<String> getPlatba() {
        return fakt.getPlatba();
    }
    
}
