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
public class Firma {

    private int id;
    private String nazev;
    private String login;
    private int heslo;
    private String ulice;
    private int psc;
    private String mesto;
    private String stat;
    private int ic;
    private int dic;
    private String telefon;
    private String email;
    private String cisloUctu;

    /**
     * Construktor pro prihlaseneho uzivatele
     *
     * @param id
     * @param nazev
     * @param login
     * @param heslo
     * @param ulice
     * @param psc
     * @param mesto
     * @param stat
     * @param ic
     * @param dic
     * @param telefon
     * @param email
     * @param cisloUctu
     */
    public Firma(int id, String nazev, String login, int heslo, String ulice, int psc, String mesto, String stat, int ic, int dic, String telefon, String email, String cisloUctu) {
        this.id = id;
        this.nazev = nazev;
        this.login = login;
        this.heslo = heslo;
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

    /**
     * Construktor pro zakazniky
     *
     * @param id
     * @param nazev
     * @param ulice
     * @param psc
     * @param mesto
     * @param stat
     * @param ic
     * @param dic
     * @param telefon
     * @param email
     * @param cisloUctu
     */
    public Firma(int id, String nazev, String ulice, int psc, String mesto, String stat, int ic, int dic, String telefon, String email, String cisloUctu) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getHeslo() {
        return heslo;
    }

    public void setHeslo(int heslo) {
        this.heslo = heslo;
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

    public String getTelefon() {
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

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCisloUctu(String cisloUctu) {
        this.cisloUctu = cisloUctu;
    }

}
