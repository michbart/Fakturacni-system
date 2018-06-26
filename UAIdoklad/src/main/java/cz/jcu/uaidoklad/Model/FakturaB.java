/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.ArrayList;

/**
 *
 * @author Michal
 */
public class FakturaB extends Faktura {
    
    public FakturaB(Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky) {
        super(dodavatel, odberatel, polozky);
    }
    
}
