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
    public final int BLOK_DODAVATEL_X = 50;
    public final int BLOK_DODAVATEL_Y = 750;

    /* X a Y pozice zacatku bloku informaci o odberateli */
    public final int BLOK_ODBERATEL_X = 300;
    public final int BLOK_ODBERATEL_Y = 630;

    public final int BLOK_INFO_X = 50;
    public final int BLOK_INFO_Y = 650;
    public final int BLOK_POLOZKY_X = 50;
    public final int BLOK_POLOZKY_Y = 390;
    public final int BLOK_CELKEM_X = 300;
    public final int BLOK_CELKEM_Y = 50;
<<<<<<< HEAD

    public FakturaA(int cislo, Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky) {
        super(cislo, dodavatel, odberatel, polozky);
=======
    
    public FakturaA(int id, int cislo, Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky) {
        super(id, cislo, dodavatel, odberatel, polozky);
>>>>>>> 7cd9e2f04a0fb220bbccfe7e4134ec39211d6923
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

    @Override
    public int blokInfoX() {
        return BLOK_INFO_X;
    }

    @Override
    public int blokInfoY() {
        return BLOK_INFO_Y;
    }

    @Override
    public int blokPolozkyX() {
        return BLOK_POLOZKY_X;
    }

    @Override
    public int blokPolozkyY() {
        return BLOK_POLOZKY_Y;
    }

    @Override
    public int blokCelkemX() {
        return BLOK_CELKEM_X;
    }

    @Override
    public int blokCelkemY() {
        return BLOK_CELKEM_Y;
    }
}
