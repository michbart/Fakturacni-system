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
public class Polozka {

    private String nazev;
    private double cena;
    private String mernaJednotka;
    public final int DPH=21;

    public Polozka(String nazev, double cena, String mernaJednotka) {
        this.nazev = nazev;
        this.cena = cena;
        this.mernaJednotka = mernaJednotka;
    }

    public String getMernaJednotka() {
        return mernaJednotka;
    }

    public void setMernaJednotka(String mernaJednotka) {
        this.mernaJednotka = mernaJednotka;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    

}
