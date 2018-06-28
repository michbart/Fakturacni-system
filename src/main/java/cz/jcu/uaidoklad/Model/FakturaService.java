/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.List;

/**
 *
 * @author Michal
 */
public interface FakturaService {
    
    Faktura getFakturaById(int id);
    
    List<Faktura> getFaktury();
    
    List<String> getPlatba();
    
    void createFaktura(Faktura f);
    
    void updateFaktura(Faktura f);
    
    void deleteFaktura(int id);
    
    void exportAsPDF(Faktura f, FakturaRepositoryImpl db);
    
    Polozka getPolozkaById(int id);
    
    List<Polozka> getPolozky();
    
    void createPolozka(Polozka p);
    
    void updatePolozka(Polozka p);
    
    void deletePolozka(int id);
}
