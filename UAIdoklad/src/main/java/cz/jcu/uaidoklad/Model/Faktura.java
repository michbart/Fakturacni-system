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
public abstract class Faktura implements Serializable {

    protected Uzivatel dodavatel;
    protected Uzivatel odberatel;
    protected ArrayList<Polozka> polozky;
    protected int cislo;
    //public int BLOK_DODAVATEL_Y=0;
    

    public Faktura(int cislo, Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky) {
        this.dodavatel = dodavatel;
        this.odberatel = odberatel;
        this.polozky = polozky;
        this.cislo = cislo;
    }

    public abstract int blokDodavatelX();
    public abstract int blokDodavatelY();
    public abstract int blokOdberatelX();
    public abstract int blokOdberatelY();
    
    public int getCislo() {
        return cislo;
    }
    
    /**
     * Getter pro ziskani dodavatele faktury
     *
     * @return dodavatel faktury
     */
    public Uzivatel getDodavatel() {
        return dodavatel;
    }

    /**
     * Getter pro ziskani odberatele faktury
     *
     * @return odberatel faktury
     */
    public Uzivatel getOdberatel() {
        return odberatel;
    }

    /**
     * Getter pro ziskani polozek faktury
     * @return polozky faktury
     */
    public ArrayList<Polozka> getPolozky() {
        return polozky;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    public void setDodavatel(Uzivatel dodavatel) {
        this.dodavatel = dodavatel;
    }

    public void setOdberatel(Uzivatel odberatel) {
        this.odberatel = odberatel;
    }

    public void setPolozky(ArrayList<Polozka> polozky) {
        this.polozky = polozky;
    }
    
}
