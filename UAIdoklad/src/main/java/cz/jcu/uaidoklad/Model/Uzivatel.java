/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

/**
 *
 * @author Michal
 */
public class Uzivatel {

    private String nazev;
    private String ulice;
    private int psc;
    private String mesto;
    private String stat;
    private int ic;
    private int dic;
    private int telefon;
    private String email;
    private String cisloUctu;

    public Uzivatel(String nazev, String ulice, int psc, String mesto, String stat, int ic, int dic, int telefon, String email, String cisloUctu) {
        this.nazev = nazev;
        this.ulice = ulice;
        this.psc = psc;
        this.mesto = mesto;
        this.stat = stat;
        this.ic = ic;
        this.dic = dic;
        this.telefon = telefon;
        this.email = email;
        this.cisloUctu = cisloUctu;
    }

    public String getNazev() {
        return nazev;
    }

    public String getUlice() {
        return ulice;
    }

    public int getPsc() {
        return psc;
    }

    public String getMesto() {
        return mesto;
    }

    public String getStat() {
        return stat;
    }

    public int getIc() {
        return ic;
    }

    public int getDic() {
        return dic;
    }

    public int getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getCisloUctu() {
        return cisloUctu;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void setIc(int ic) {
        this.ic = ic;
    }

    public void setDic(int dic) {
        this.dic = dic;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCisloUctu(String cisloUctu) {
        this.cisloUctu = cisloUctu;
    }

}
