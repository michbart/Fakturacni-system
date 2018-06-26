/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.io.Serializable;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;

/**
 *
 * @author Michal
 */
public class Faktura implements Serializable {
    protected Uzivatel dodavatel;
    protected Uzivatel odberatel;
    
    public Faktura(Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky){
        this.dodavatel=dodavatel;
    }
    
    /**
     * Getter pro ziskani dodavatele
     * @return dodavatel
     */
    public Uzivatel getDodavatel(){
        return dodavatel;
    }
    
    /**
     * Getter pro ziskani odberatele
     * @return odberatel
     */
    public Uzivatel getOdberatel(){
        return odberatel;
    }
}
