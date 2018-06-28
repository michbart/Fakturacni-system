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

    private int id;
    private String nazev;
    private double cena;
    private String mernaJednotka;
    public final int DPH = 21;

    public Polozka(int id, String nazev, double cena, String mernaJednotka) {
        this.id = id;
        this.nazev = nazev;
        this.cena = cena;
        this.mernaJednotka = mernaJednotka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
