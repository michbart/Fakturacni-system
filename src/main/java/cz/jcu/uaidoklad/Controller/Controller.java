/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Controller;

import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.FakturaRepositoryImpl;
import cz.jcu.uaidoklad.Model.FakturaService;
import cz.jcu.uaidoklad.Model.Firma;

/**
 *
 * @author Michal
 */
public interface Controller {
    void createFaktura(Faktura f);
    void updateFaktura(Faktura f);
    void deleteFaktura(int id);
    void exportAsPDF(Faktura f, FakturaService db);
}
