/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.View;

import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.FakturaService;
import cz.jcu.uaidoklad.Model.Polozka;
import java.util.List;

/**
 *
 * @author Michal
 */
public class ViewClass implements View {

    FakturaService fs;

    public ViewClass() {
    }
    
    
    @Override
    public Faktura getFakturaById(int id) {
        return fs.getFakturaById(id);
    }

    @Override
    public List<Faktura> getFaktury() {
        return fs.getFaktury();
    }

    @Override
    public Polozka getPolozkaById(int id) {
        return fs.getPolozkaById(id);
    }

    @Override
    public List<Polozka> getPolozky() {
        return fs.getPolozky();
    }
    
}
