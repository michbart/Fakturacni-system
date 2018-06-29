/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Controller;

import cz.jcu.uaidoklad.Model.PDF;
import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.FakturaRepositoryImpl;
import cz.jcu.uaidoklad.Model.FakturaService;
import cz.jcu.uaidoklad.Model.FakturaServiceImpl;
import cz.jcu.uaidoklad.Model.Firma;

/**
 *
 * @author Michal
 */
public class ControllerClass implements Controller {

    FakturaService fs;

    public ControllerClass() throws Exception {
        fs = new FakturaServiceImpl();
    }
    
    
    @Override
    public void createFaktura(Faktura f) {
        fs.createFaktura(f);
    }

    @Override
    public void updateFaktura(Faktura f) {
        fs.updateFaktura(f);
    }

    @Override
    public void deleteFaktura(int id) {
        fs.deleteFaktura(id);
    }

    @Override
    public void exportAsPDF(Faktura f, FakturaService db) {
        fs.exportAsPDF(f, db);
    }

    

    
}
