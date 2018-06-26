/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Controller;

import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.Uzivatel;

/**
 *
 * @author Michal
 */
public class ControllerClass implements Controller {

    @Override
    public void vygenerujPDF(Faktura f) {
        new PDF(f).vygeneruj();
        //treba vyhodit okno ze bylo provedeno uspesne
    }

    

    
}
