/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.View;

import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.Polozka;
import java.util.List;

/**
 *
 * @author Michal
 */
public interface View {
    List<String> getPlatba();
    
    Faktura getFakturaById(int id);

    List<Faktura> getFaktury();

    Polozka getPolozkaById(int id);

    List<Polozka> getPolozky();
}
