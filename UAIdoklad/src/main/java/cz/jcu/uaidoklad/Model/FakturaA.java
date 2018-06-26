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
public class FakturaA extends Faktura {

    /* X a Y pozice zacatku bloku informaci o dodavateli */
    public final int BLOK_DODAVATEL_X=0;
    public final int BLOK_DODAVATEL_Y=0;

    /* X a Y pozice zacatku bloku informaci o odberateli */
    public final int BLOK_ODBERATEL_X = 0;
    public final int BLOK_ODBERATEL_Y = 0;

    
    
    public FakturaA(int cislo, Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky) {
        super(cislo, dodavatel, odberatel, polozky);
    }

    @Override
    public int blokDodavatelX() {
        return BLOK_DODAVATEL_X;
    }

    @Override
    public int blokDodavatelY() {
        return BLOK_DODAVATEL_Y;
    }

    @Override
    public int blokOdberatelX() {
        return BLOK_ODBERATEL_X;
    }

    @Override
    public int blokOdberatelY() {
        return BLOK_ODBERATEL_Y;
    }
}
