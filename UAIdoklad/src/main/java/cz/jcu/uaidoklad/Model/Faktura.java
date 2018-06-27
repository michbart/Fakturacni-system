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

    protected int id;
    protected Uzivatel dodavatel;
    protected Uzivatel odberatel;
    protected ArrayList<Polozka> polozky;
    protected int cislo;
    protected String datumSplatnosti;

    public Faktura(int id, int cislo, Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky, String datumSplatnosti) {
        this.dodavatel = dodavatel;
        this.odberatel = odberatel;
        this.polozky = polozky;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
    }

    public abstract int blokDodavatelX();

    public abstract int blokDodavatelY();

    public abstract int blokOdberatelX();

    public abstract int blokOdberatelY();

    public abstract int blokInfoX();

    public abstract int blokInfoY();

    public abstract int blokPolozkyX();

    public abstract int blokPolozkyY();

    public abstract int blokCelkemX();

    public abstract int blokCelkemY();
    
    public abstract int blokQrX();
    
    public abstract int blokQrY();
    
    public String getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(String datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    
    /**
     * Getter pro ziskani cisla faktury
     *
     * @return cislo faktury
     */
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
     *
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
