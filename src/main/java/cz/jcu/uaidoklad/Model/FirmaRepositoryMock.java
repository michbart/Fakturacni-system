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
 * @author Michal
 */
public class FirmaRepositoryMock implements FirmaRepository {

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

    private ArrayList<Firma> firmy;
    private ArrayList<Faktura> faktury;
    private ArrayList<Polozka> polozky;

    public FirmaRepositoryMock() {
        firmy = new ArrayList<>();
        faktury = new ArrayList();
        polozky = new ArrayList();
        vytvorFirmy();
        pridejFirmy();
        vytvorPolozky();
        pridejPolozky();
        vytvorFaktury();
        pridejFaktury();
    }

    @Override
    public ArrayList<Firma> getFirmy() {
        return firmy;
    }

    private void vytvorFirmy() {
        f1 = new Firma(2, "Ammeraal Beltech EuroFAB", "Hruskove dvory 80", 58601, "Jihlava", "Ceska republika", 12377684, 4563, "123456789", "mail@gmail.com", "123456789/0900");
        f2 = new Firma(1, "ENGEL strojirenska spol. s r.o.", "Ceskobudejovicka 314", 15319, "Kaplice", "Ceska republika", 62497219, 456, "1234567890", "email@email.cz", "1234567/0300"); 
        f3 = new Firma(3, "nazev2", "ulice2", 456, "mesto2", "stat2", 123, 456, "1111111", "email2", "123456789/0900");
        f4 = new Firma(4, "nazev3", "ulice3", 789, "mesto3", "stat3", 123, 456, "1111111", "email3", "123456789/0900");
        f5 = new Firma(5, "nazev4", "ulice4", 135, "mesto4", "stat4", 123, 456, "1111111", "email4", "123456789/0900");
    }

    public String getNazev(Firma f) {
        return f.getNazev();
    }

    private void pridejFirmy() {
        firmy.add(f1);
        firmy.add(f2);
        firmy.add(f3);
        firmy.add(f4);
        firmy.add(f5);
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
        System.out.println("tu" + fa1.getId());
        faktury.add(fa1);
        faktury.add(fa2);
    }

    private void vytvorPolozky() {

        p1 = new Polozka(1, "banan", 120.234, "t");
        p2 = new Polozka(2, "qwert", 12.24, "qwer");
        p3 = new Polozka(3, "pomerač", 10.34, "l");
    }

    private void pridejPolozky() {
        polozky.add(p1);
        polozky.add(p2);
        polozky.add(p3);
    }

}
