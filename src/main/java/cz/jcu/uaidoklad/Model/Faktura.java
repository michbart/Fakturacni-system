/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public abstract class Faktura implements Serializable {

    protected int id;
    protected Uzivatel dodavatel;
    protected Uzivatel odberatel;
    protected HashMap<Integer, Integer> polozky;
    protected int cislo;
    protected String datumSplatnosti;
    protected String zpusobPlatby;

    /**
     * Konstruktor nove faktury
     * @param id
     * @param cislo
     * @param dodavatel
     * @param odberatel
     * @param polozky
     * @param datumSplatnosti
     * @param zpusobPlatby 
     */
    public Faktura(int id, int cislo, Uzivatel dodavatel, Uzivatel odberatel, HashMap<Integer, Integer> polozky, String datumSplatnosti, String zpusobPlatby) {
        this.id = id;
        this.dodavatel = dodavatel;
        this.odberatel = odberatel;
        this.polozky = polozky;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
        this.zpusobPlatby = zpusobPlatby;
    }
    
    public Faktura(int id, int cislo, HashMap<Integer, Integer> polozky, String datumSplatnosti, String zpusobPlatby) {
        this.id = id;
        this.polozky = polozky;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
        this.zpusobPlatby = zpusobPlatby;
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
    
    public abstract int blokInfo2X();
    
    public abstract int blokInfo2Y();
    
    public abstract int blokCelkem2X();
    
    public abstract int blokCelkem2Y();
    
    public abstract int blokCislaX();
    
    public abstract int blokCislaY();

    /**
     * Getter pro ziskani ID faktury
     *
     * @return ID faktury
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pro ziskani data splatnosti
     *
     * @return datum splatnosti
     */
    public String getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(String datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }
    
    public String getZpusobPlatby(){
        return zpusobPlatby;
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

    public HashMap<Integer, Integer> getPolozky() {
        return polozky;
    }

    /**
     * Getter pro ziskani polozek faktury
     *
     * @return polozky faktury
     */
    public void setPolozky(HashMap<Integer, Integer> polozky) {
        this.polozky = polozky;
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

}
