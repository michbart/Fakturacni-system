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
public class Faktura implements Serializable {

    private int id;
    private Uzivatel dodavatel;
    private Uzivatel odberatel;
    private HashMap<Integer, Integer> polozky;
    private int cislo;
    private String datumSplatnosti;
    private String zpusobPlatby;
    /* X a Y pozice zacatku bloku informaci o dodavateli */
    private int BLOK_DODAVATEL_X;
    private int BLOK_DODAVATEL_Y;
    /* X a Y pozice zacatku bloku informaci o odberateli */
    private int BLOK_ODBERATEL_X;
    private int BLOK_ODBERATEL_Y;
    /* X a Y pozice zacatku bloku info (data splatnosti)  */
    private int BLOK_INFO_X;
    private int BLOK_INFO_Y;
    /* X a Y pozice zacatku bloku polozek */
    private int BLOK_POLOZKY_X;
    private int BLOK_POLOZKY_Y;
    /* X a Y pozice zacatku bloku celkem (cena bez dph a s dph*/
    private int BLOK_CELKEM_X;
    private int BLOK_CELKEM_Y;
    /* X a Y pozice zacatku bloku QR kodu */
    private int BLOK_QR_X;
    private int BLOK_QR_Y;
    /* X a Y pozice cisla faktury (FAKTURA 2016-04 danovy doklad) */
    private int BLOK_CISLA_X;
    private int BLOK_CISLA_Y;
    /* X a Y pozice zacatku bloku info (ucet, var. symbol, zpusob platby)  */
    private int BLOK_INFO2_X;
    public int BLOK_INFO2_Y;
    /* X a Y pozice zacatku bloku celkem (cena vcetne dph - zvyraznena) */
    private int BLOK_CELKEM2_X;
    private int BLOK_CELKEM2_Y;

    /**
     * Konstruktor nove faktury
     *
     * @param id
     * @param cislo
     * @param dodavatel
     * @param odberatel
     * @param polozky
     * @param datumSplatnosti
     * @param zpusobPlatby
     */
    public Faktura(int id, int cislo, Uzivatel dodavatel, Uzivatel odberatel, HashMap<Integer, Integer> polozky, String datumSplatnosti, String zpusobPlatby, int typ) {
        this.id = id;
        this.dodavatel = dodavatel;
        this.odberatel = odberatel;
        this.polozky = polozky;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
        this.zpusobPlatby = zpusobPlatby;
        vyberTyp(typ);
    }

    public Faktura(int id, int cislo, String datumSplatnosti, String zpusobPlatby, int typ) {
        this.id = id;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
        this.zpusobPlatby = zpusobPlatby;
        vyberTyp(typ);
    }

    private void vyberTyp(int typ){
        switch (typ) {
            case 1: {
                BLOK_DODAVATEL_X = 50;
                BLOK_DODAVATEL_Y = 750;
                BLOK_ODBERATEL_X = 300;
                BLOK_ODBERATEL_Y = 630;
                BLOK_INFO_X = 50;
                BLOK_INFO_Y = 650;
                BLOK_POLOZKY_X = 50;
                BLOK_POLOZKY_Y = 390;
                BLOK_CELKEM_X = 300;
                BLOK_CELKEM_Y = 50;
                BLOK_QR_X = 70;
                BLOK_QR_Y = 420;
                break;
            }
            case 2: {
                BLOK_CISLA_X = 548;
                BLOK_CISLA_Y = 746;
                BLOK_DODAVATEL_X = 30;
                BLOK_DODAVATEL_Y = 315;
                BLOK_ODBERATEL_X = 390;
                BLOK_ODBERATEL_Y = 654;
                BLOK_QR_X = 515;
                BLOK_QR_Y = 300;
                BLOK_INFO_X = 373;
                BLOK_INFO_Y = 654;
                BLOK_INFO2_X = 30;
                BLOK_INFO2_Y = 755;
                BLOK_POLOZKY_X = 30;
                BLOK_POLOZKY_Y = 593;
                BLOK_CELKEM_X = 391;
                BLOK_CELKEM_Y = 462;
                BLOK_CELKEM2_X = 30;
                BLOK_CELKEM2_Y = 752;
                break;
            }
            default:
                break;
        }
    }
    
    public int getBLOK_DODAVATEL_X() {
        return BLOK_DODAVATEL_X;
    }

    public int getBLOK_DODAVATEL_Y() {
        return BLOK_DODAVATEL_Y;
    }

    public int getBLOK_ODBERATEL_X() {
        return BLOK_ODBERATEL_X;
    }

    public int getBLOK_ODBERATEL_Y() {
        return BLOK_ODBERATEL_Y;
    }

    public int getBLOK_INFO_X() {
        return BLOK_INFO_X;
    }

    public int getBLOK_INFO_Y() {
        return BLOK_INFO_Y;
    }

    public int getBLOK_POLOZKY_X() {
        return BLOK_POLOZKY_X;
    }

    public int getBLOK_POLOZKY_Y() {
        return BLOK_POLOZKY_Y;
    }

    public int getBLOK_CELKEM_X() {
        return BLOK_CELKEM_X;
    }

    public int getBLOK_CELKEM_Y() {
        return BLOK_CELKEM_Y;
    }

    public int getBLOK_QR_X() {
        return BLOK_QR_X;
    }

    public int getBLOK_QR_Y() {
        return BLOK_QR_Y;
    }

    public int getBLOK_CISLA_X() {
        return BLOK_CISLA_X;
    }

    public int getBLOK_CISLA_Y() {
        return BLOK_CISLA_Y;
    }

    public int getBLOK_INFO2_X() {
        return BLOK_INFO2_X;
    }

    public int getBLOK_INFO2_Y() {
        return BLOK_INFO2_Y;
    }

    public int getBLOK_CELKEM2_X() {
        return BLOK_CELKEM2_X;
    }

    public int getBLOK_CELKEM2_Y() {
        return BLOK_CELKEM2_Y;
    }

    

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

    public String getZpusobPlatby() {
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
