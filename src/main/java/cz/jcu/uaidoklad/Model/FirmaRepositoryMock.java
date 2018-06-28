/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.ArrayList;

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

    public FirmaRepositoryMock() {
        firmy = new ArrayList<>();
        vytvorFirmy();
        pridejFirmy();
    }

    @Override
    public ArrayList<Firma> getFirmy() {
        return firmy;
    }

    
    
    private void vytvorFirmy() {
        f1 = new Firma(1, "nazev", "ulice", 555, "mesto", "stat", 123, 456, 1111111, "email", "123/0900");
        f2 = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
        f3 = new Firma(1, "nazev", "ulice", 555, "mesto", "stat", 123, 456, 1111111, "email", "123/0900");
        f4 = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
        f5 = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
    }

    private void pridejFirmy() {
        firmy.add(f1);
        firmy.add(f2);
        firmy.add(f3);
        firmy.add(f4);
        firmy.add(f5);
    }

}
