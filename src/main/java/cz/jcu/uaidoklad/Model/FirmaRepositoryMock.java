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
    Firma f1 = new Firma(1, "nazev", "ulice", 555, "mesto", "stat", 123, 456, 1111111, "email","123/0900");
    Firma f2 = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
    Firma f3 = new Firma(1, "nazev", "ulice", 555, "mesto", "stat", 123, 456, 1111111, "email","123/0900");
    Firma f4 = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
    Firma f5 = new Firma(2, "nazev2", "ulice2", 555, "mesto2", "stat2", 123, 456, 1111111, "email2", "123/0900");
    
    ArrayList<Firma> firmy = new ArrayList<>();

    public FirmaRepositoryMock() {
        firmy.add(f1);
        firmy.add(f2);
        firmy.add(f3);
        firmy.add(f4);
        firmy.add(f5);
    }

    @Override
    public ArrayList<Firma> getFirmy() {
        return firmy;
    }

    
    
}
