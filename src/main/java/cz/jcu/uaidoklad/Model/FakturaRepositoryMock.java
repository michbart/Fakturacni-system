/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NikolaKraus
 */
public class FakturaRepositoryMock implements FakturaRepository {
    
    private Firma f1;
    private Firma f2;
    private Firma f3;
    private Firma f4;
    private Firma f5;
    private Polozka p1;
    private Polozka p2;
    private Polozka p3;
    private Faktura fa1;
    private Faktura fa2;

    private HashMap<Integer,Firma> firmy;
    private HashMap<Integer,Faktura> faktury;
    private HashMap<Integer,Polozka> polozky;

    public FakturaRepositoryMock() {
        firmy = new HashMap();
        faktury = new HashMap();
        polozky = new HashMap();
        vytvorFirmy();
        pridejFirmy();
        vytvorPolozky();
        pridejPolozky();
        vytvorFaktury();
        pridejFaktury();
    }

    private void vytvorFirmy() {
        f1 = new Firma(1, "ENGEL strojírenska spol. s r.o.", "Ceskobudejovicka", 15319, "Kaplice", "Ceska republika", 62497219, 456, "1234567890", "email@email.cz", "1234567/0300");
        f2 = new Firma(2, "nazev1", "ulice", 123, "mesto1", "stat1", 123, 456, "1111111", "email1", "123456789/0900");
        f3 = new Firma(3, "nazev2", "ulice2", 456, "mesto2", "stat2", 123, 456, "1111111", "email2", "123456789/0900");
        f4 = new Firma(4, "nazev3", "ulice3", 789, "mesto3", "stat3", 123, 456, "1111111", "email3", "123456789/0900");
        f5 = new Firma(5, "nazev4", "ulice4", 135, "mesto4", "stat4", 123, 456, "1111111", "email4", "123456789/0900");
    }

    public String getNazev(Firma f) {
        return f.getNazev();
    }

    private void pridejFirmy() {
        firmy.put(f1.getId(),f1);
        firmy.put(f2.getId(),f2);
        firmy.put(f3.getId(),f3);
        firmy.put(f4.getId(),f4);
        firmy.put(f5.getId(),f5);
    }

    private void vytvorFaktury() {
        HashMap<Integer, Integer> polozkyList = new HashMap();
        polozkyList.put(p1.getId(), 23);
        polozkyList.put(p2.getId(), 12);
        polozkyList.put(p3.getId(), 18);
        fa1 = new Faktura(1, 1234, f1, f2, polozkyList, "1.2.2111", "hotově Vatikanskou měnou", 1);
        fa2 = new Faktura(2, 5678, f1, f3, polozkyList, "32.13.0000", "qwert", 2);
    }

    private void pridejFaktury() {
        faktury.put(fa1.getId(),fa1);
        faktury.put(fa2.getId(),fa2);
    }

    private void vytvorPolozky() {

        p1 = new Polozka(1, "banan", 120.234, "t");
        p2 = new Polozka(2, "qwert", 12.24, "qwer");
        p3 = new Polozka(3, "pomerač", 10.34, "l");
    }

    private void pridejPolozky() {
        polozky.put(p1.getId(),p1);
        polozky.put(p2.getId(),p2);
        polozky.put(p3.getId(),p3);
    }

    @Override
    public void ulozFaktura(Faktura faktura) throws Exception {
        faktury.put(faktura.getId(), faktura);
    }

    @Override
    public Faktura getFaktura(int id) throws Exception {
        return faktury.get(id);
    }

    @Override
    public void smazFaktura(int id) throws Exception {
       faktury.remove(id);
    }

    @Override
    public ArrayList<Faktura> getListFaktur() throws Exception {
        ArrayList<Faktura> vystup = new ArrayList();
        for (int p:faktury.keySet()) {
            vystup.add(faktury.get(p));
        }
        return vystup;
    }

    @Override
    public void zmenFakturu(Faktura faktura) throws Exception {
        faktury.put(faktura.getId(), faktura);
    }

    @Override
    public ArrayList<Polozka> getListPolozek() throws Exception {
        ArrayList<Polozka> vystup = new ArrayList();
        for (int p:polozky.keySet()) {
            vystup.add(polozky.get(p));
        }
        return vystup;
    }

    @Override
    public void ulozPolozka(Polozka polozka) throws Exception {
        polozky.put(polozka.getId(),polozka);
    }

    @Override
    public void zmenPolozku(Polozka polozka) throws Exception {
        polozky.put(polozka.getId(),polozka);
    }

    @Override
    public void smazPolozku(int id) throws Exception {
        polozky.remove(id);
    }

    @Override
    public Polozka getPolozka(int id) throws Exception {
        return polozky.get(id);
    }

}
