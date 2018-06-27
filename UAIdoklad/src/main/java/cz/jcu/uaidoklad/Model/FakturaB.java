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
public class FakturaB extends Faktura {
    
    /* X a Y pozice zacatku bloku informaci o dodavateli */
    public final int BLOK_DODAVATEL_X = 30;
    public final int BLOK_DODAVATEL_Y = 315;

    /* X a Y pozice zacatku bloku informaci o odberateli */
    public final int BLOK_ODBERATEL_X = 390;
    public final int BLOK_ODBERATEL_Y = 654;
    
    /* X a Y pozice zacatku bloku QR kodu */
    
    public final int BLOK_QR_X = 515;
    public final int BLOK_QR_Y = 300;
    
    /* X a Y pozice zacatku bloku info (data splatnosti)  */
    
    public final int BLOK_INFO_X = 373;
    public final int BLOK_INFO_Y = 654;
    
    /* X a Y pozice zacatku bloku info (ucet, var. symbol, zpusob platby)  */
    
    public final int BLOK_INFO2_X = 30;
    public final int BLOK_INFO2_Y = 755;
    
    /* X a Y pozice zacatku bloku polozek */
    
    public final int BLOK_POLOZKY_X = 30;
    public final int BLOK_POLOZKY_Y = 593;
    
    /* X a Y pozice zacatku bloku celkem (cena bez dph a s dph*/
    
    public final int BLOK_CELKEM_X = 391;
    public final int BLOK_CELKEM_Y = 462;
    
    /* X a Y pozice zacatku bloku celkem (cena vcetne dph - zvyraznena) */
    
    public final int BLOK_CELKEM2_X = 30;
    public final int BLOK_CELKEM2_Y = 752;
    
     
    
    public FakturaB(int cislo, Uzivatel dodavatel, Uzivatel odberatel, ArrayList<Polozka> polozky) {
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
    
    @Override
    public int blokQRX() {
        return BLOK_QR_X ;
    }
    
    @Override
    public int blokQRY() {
        return BLOK_QR_Y ;
    }
    
    @Override
    public int blokInfoX() {
        return BLOK_INFO_X
    }

    @Override
    public int blokInfoY() {
        return BLOK_INFO_Y
    }
    
    @Override
    public int blokInfo2X() {
        return BLOK_INFO2_X
    }

    @Override
    public int blokInfo2Y() {
        return BLOK_INFO2_Y
    }

    @Override
    public int blokPolozkyX() {
        return BLOK_POLOZKY_X
    }

    @Override
    public int blokPolozkyY() {
        return BLOK_POLOZKY_Y
    }

    @Override
    public int blokCelkemX() {
        return BLOK_CELKEM_X
    }

    @Override
    public int blokCelkemY() {
        return BLOK_CELKEM_Y
    }
    
    @Override
    public int blokCelkem2X() {
        return BLOK_CELKEM2_X
    }

    @Override
    public int blokCelkemY() {
        return BLOK_CELKEM2_Y
    }
    
}