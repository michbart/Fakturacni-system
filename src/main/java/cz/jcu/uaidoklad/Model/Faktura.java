/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michal
 */
public class Faktura implements Serializable {

    private int id;
    private Firma dodavatel;
    private Firma odberatel;
    private HashMap<Integer, Integer> polozky;
    private int cislo;
    private String datumSplatnosti;
    private String zpusobPlatby;
    private int typ;
    private ArrayList<String> platba;
    /* X a Y pozice zacatku bloku informaci o dodavateli */
    private int BLOK_DODAVATEL_X;
    private int BLOK_DODAVATEL_Y;
    /* X a Y pozice zacatku bloku informaci o odberateli */
    private int BLOK_ODBERATEL_X;
    private int BLOK_ODBERATEL_Y;
    /* X a Y pozice zacatku bloku info (data splatnosti)  */
    private int BLOK_INFO_X;
    private int BLOK_INFO_Y;
    /* X a Y pozice zacatku bloku polozek */
    private int BLOK_POLOZKY_X;
    private int BLOK_POLOZKY_Y;
    /* X a Y pozice zacatku bloku celkem (cena bez dph a s dph*/
    private int BLOK_CELKEM_X;
    private int BLOK_CELKEM_Y;
    /* X a Y pozice zacatku bloku QR kodu */
    private int BLOK_QR_X;
    private int BLOK_QR_Y;
    /* X a Y pozice cisla faktury (FAKTURA 2016-04 danovy doklad) */
    private int BLOK_CISLA_X;
    private int BLOK_CISLA_Y;
    /* X a Y pozice zacatku bloku info (ucet, var. symbol, zpusob platby)  */
    private int BLOK_INFO2_X;
    public int BLOK_INFO2_Y;
    /* X a Y pozice zacatku bloku celkem (cena vcetne dph - zvyraznena) */
    private int BLOK_CELKEM2_X;
    private int BLOK_CELKEM2_Y;

    public Faktura(){
        naplnPlatbu();
    }
    /**
     * Konstruktor nove faktury
     *
     * @param id
     * @param cislo
     * @param dodavatel
     * @param odberatel
     * @param polozky
     * @param datumSplatnosti
     * @param zpusobPlatby
     */
    public Faktura(int id, int cislo, Firma dodavatel, Firma odberatel, HashMap<Integer, Integer> polozky, String datumSplatnosti, String zpusobPlatby, int typ) {
        this.id = id;
        this.dodavatel = dodavatel;
        this.odberatel = odberatel;
        this.polozky = polozky;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
        this.zpusobPlatby = zpusobPlatby;
        this.typ = typ;
        vyberTyp(typ);
        
    }

    public Faktura(int id, int cislo, String datumSplatnosti, String zpusobPlatby, int typ) {
        this.id = id;
        this.cislo = cislo;
        this.datumSplatnosti = datumSplatnosti;
        this.zpusobPlatby = zpusobPlatby;
        this.typ = typ;
        vyberTyp(typ);
    }

    private void naplnPlatbu(){
        platba = new ArrayList<>();
        platba.add("Prevodem");
        platba.add("Hotove");
        platba.add("Kartou");
    }
    
    private void vyberTyp(int typ) {
        switch (typ) {
            case 1: {
                BLOK_DODAVATEL_X = 50;
                BLOK_DODAVATEL_Y = 750;
                BLOK_ODBERATEL_X = 300;
                BLOK_ODBERATEL_Y = 630;
                BLOK_INFO_X = 50;
                BLOK_INFO_Y = 650;
                BLOK_POLOZKY_X = 50;
                BLOK_POLOZKY_Y = 390;
                BLOK_CELKEM_X = 300;
                BLOK_CELKEM_Y = 50;
                BLOK_QR_X = 70;
                BLOK_QR_Y = 420;
                break;
            }
            case 2: {
                BLOK_CISLA_X = 548;
                BLOK_CISLA_Y = 746;
                BLOK_DODAVATEL_X = 30;
                BLOK_DODAVATEL_Y = 315;
                BLOK_ODBERATEL_X = 390;
                BLOK_ODBERATEL_Y = 654;
                BLOK_QR_X = 515;
                BLOK_QR_Y = 300;
                BLOK_INFO_X = 373;
                BLOK_INFO_Y = 654;
                BLOK_INFO2_X = 30;
                BLOK_INFO2_Y = 755;
                BLOK_POLOZKY_X = 30;
                BLOK_POLOZKY_Y = 593;
                BLOK_CELKEM_X = 391;
                BLOK_CELKEM_Y = 462;
                BLOK_CELKEM2_X = 30;
                BLOK_CELKEM2_Y = 752;
                break;
            }
            default:
                break;
        }
    }

    public ArrayList<String> getPlatba() {
        return platba;
    }

    public int getTyp() {
        return typ;
    }

    public int getBLOK_DODAVATEL_X() {
        return BLOK_DODAVATEL_X;
    }

    public int getBLOK_DODAVATEL_Y() {
        return BLOK_DODAVATEL_Y;
    }

    public int getBLOK_ODBERATEL_X() {
        return BLOK_ODBERATEL_X;
    }

    public int getBLOK_ODBERATEL_Y() {
        return BLOK_ODBERATEL_Y;
    }

    public int getBLOK_INFO_X() {
        return BLOK_INFO_X;
    }

    public int getBLOK_INFO_Y() {
        return BLOK_INFO_Y;
    }

    public int getBLOK_POLOZKY_X() {
        return BLOK_POLOZKY_X;
    }

    public int getBLOK_POLOZKY_Y() {
        return BLOK_POLOZKY_Y;
    }

    public int getBLOK_CELKEM_X() {
        return BLOK_CELKEM_X;
    }

    public int getBLOK_CELKEM_Y() {
        return BLOK_CELKEM_Y;
    }

    public int getBLOK_QR_X() {
        return BLOK_QR_X;
    }

    public int getBLOK_QR_Y() {
        return BLOK_QR_Y;
    }

    public int getBLOK_CISLA_X() {
        return BLOK_CISLA_X;
    }

    public int getBLOK_CISLA_Y() {
        return BLOK_CISLA_Y;
    }

    public int getBLOK_INFO2_X() {
        return BLOK_INFO2_X;
    }

    public int getBLOK_INFO2_Y() {
        return BLOK_INFO2_Y;
    }

    public int getBLOK_CELKEM2_X() {
        return BLOK_CELKEM2_X;
    }

    public int getBLOK_CELKEM2_Y() {
        return BLOK_CELKEM2_Y;
    }

    /**
     * Getter pro ziskani ID faktury
     *
     * @return ID faktury
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter pro ziskani data splatnosti
     *
     * @return datum splatnosti
     */
    public String getDatumSplatnosti() {
        return datumSplatnosti;
    }

    public void setDatumSplatnosti(String datumSplatnosti) {
        this.datumSplatnosti = datumSplatnosti;
    }

    public String getZpusobPlatby() {
        return zpusobPlatby;
    }

    /**
     * Getter pro ziskani cisla faktury
     *
     * @return cislo faktury
     */
    public int getCislo() {
        return cislo;
    }

    /**
     * Getter pro ziskani dodavatele faktury
     *
     * @return dodavatel faktury
     */
    public Firma getDodavatel() {
        return dodavatel;
    }

    /**
     * Getter pro ziskani odberatele faktury
     *
     * @return odberatel faktury
     */
    public Firma getOdberatel() {
        return odberatel;
    }

    public HashMap<Integer, Integer> getPolozky() {
        return polozky;
    }

    /**
     * Getter pro ziskani polozek faktury
     *
     * @return polozky faktury
     */
    public void setPolozky(HashMap<Integer, Integer> polozky) {
        this.polozky = polozky;
    }

    public void setCislo(int cislo) {
        this.cislo = cislo;
    }

    public void setDodavatel(Firma dodavatel) {
        this.dodavatel = dodavatel;
    }

    public void setOdberatel(Firma odberatel) {
        this.odberatel = odberatel;
    }
    
     /* 
    //////////////////////////////////////////
    /////////////////////////////////////////
    // FAKTURA B ///////////////////////////
    ///////////////////////////////////////
    //////////////////////////////////////
    
    public int BLOK_DODAVATEL_B_X;
    public int BLOK_DODAVATEL_B_Y;
    public int BLOK_ODBERATEL_B_X;
    public int BLOK_ODBERATEL_B_Y;
    public int BLOK_ID_X;
    public int BLOK_ID_Y;
    public int BLOK_CASTKA_X;
    public int BLOK_CASTKA_Y;
    public int BLOK_CASTKA2_X;
    public int BLOK_CASTKA2_Y;
    public int BLOK_INFO_1_X;
    public int BLOK_INFO_1_Y;
    public int BLOK_INFO_2_X;
    public int BLOK_INFO_2_Y;
    public int BLOK_POLOZKY_B_X;
    public int BLOK_POLOZKY_B_Y;
    public int BLOK_QR_B_X;
    public int BLOK_QR_B_Y; 
    
    
    public final void nastavKonstantyB() {
    BLOK_DODAVATEL_B_X = 30;
    BLOK_DODAVATEL_B_Y = 200;
    BLOK_ODBERATEL_B_X = 400;
    BLOK_ODBERATEL_B_Y = 669;
    BLOK_ID_X = 400;
    BLOK_ID_Y = 769;
    BLOK_CASTKA_X = 30;
    BLOK_CASTKA_Y = 665;
    BLOK_INFO_1_X = 30;
    BLOK_INFO_1_Y = 563;
    BLOK_INFO_2_X = 400;
    BLOK_INFO_2_Y = 458;
    BLOK_POLOZKY_B_X = 30;
    BLOK_POLOZKY_B_Y = 377;
    BLOK_QR_B_X = 400;
    BLOK_QR_B_Y = 100;
    }
    
    public void vygenerujB() {
        try {
            vypisDodavateleB();
            vypisOdberateleB();
            vypisID();
            vypisInfoPolozkyB();
            vypisInfoFakturaB1();
            vypisInfoFakturaB2();
            vypisCenuCelkem();
            vykresliQRkodB();
            ukonciZapis();
        } catch (IOException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            //TODO
        }
    }
    
    private void vypisDodavateleB() throws IOException {
        cs.beginText();
        
        cs.newLineAtOffset(BLOK_DODAVATEL_B_X, BLOK_DODAVATEL_B_Y); 
        cs.setFont(fontNormal, 10);
        cs.showText("Dodavatel:");
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText("Ammeraal Beltech EuroFAB");
        cs.newLineAtOffset(0, -15);
        cs.setFont(fontNormal, 10);
        cs.showText("Hruskove dvory 80");
        cs.newLineAtOffset(0, -15);
        cs.showText("586 01 Jihlava");
        cs.newLineAtOffset(0, -15);
        cs.showText("Ceska republika");
        cs.newLineAtOffset(0, -15);
        cs.showText("IC:    21111111");
        cs.newLineAtOffset(0, -15);
        cs.showText("DIC: 22222222");
        cs.newLineAtOffset(0, -15);
        cs.showText("tel: 123 456 789");
        cs.newLineAtOffset(0, -15);
        cs.showText("email: fag@faggit.com");
        //TODO zbytek
        cs.endText();
    }
    
    private void vypisOdberateleB() throws IOException {
        cs.beginText();
        cs.setFont(fontBold, 10);
        cs.newLineAtOffset(BLOK_ODBERATEL_B_X, BLOK_ODBERATEL_B_Y); 
        cs.setFont(fontNormal, 10);
        cs.showText("Odberatel:");
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText("Ammeraal Beltech, s.r.o.");
        cs.newLineAtOffset(0, -15);
        cs.setFont(fontNormal, 10);
        cs.showText("Hruskove dvory 84");
        cs.newLineAtOffset(0, -15);
        cs.showText("586 01 Jihlava");
        cs.newLineAtOffset(0, -15);
        cs.showText("Ceska republika");
        cs.newLineAtOffset(0, -15);
        cs.showText("IC:    11111111");
        cs.newLineAtOffset(0, -15);
        cs.showText("DIC: 2222222");
        cs.newLineAtOffset(100, 15);
        cs.showText("tel: 123 456 789");
        cs.newLineAtOffset(0, -15);
        cs.showText("email: fag@faggit.com");
        //TODO zbytek
        cs.endText();
    }
    
    private void vypisID() throws IOException {
        cs.beginText();
        cs.setFont(fontBold, 10);
        cs.newLineAtOffset(BLOK_ID_X, BLOK_ID_Y); 
        cs.setFont(fontBold, 15);
        cs.showText("FAKTURA");
        cs.newLineAtOffset(0, -15);
        cs.showText("2016-004");
        cs.newLineAtOffset(0, -15);
        cs.showText("DANOVY DOKLAD");
         cs.endText();
         }
    
      private void vypisInfoPolozkyB() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_POLOZKY_B_X, BLOK_POLOZKY_B_Y);
        cs.setFont(fontBold, 10);
        cs.showText("Popis");
        cs.newLineAtOffset(270,0);
        cs.showText("Ks");
        cs.newLineAtOffset(40,0);
        cs.showText("Cena ks");
        cs.newLineAtOffset(70,0);
        cs.showText("DPH %");
        cs.newLineAtOffset(50,0);
        cs.showText("Cena s DPH");
        cs.endText();
    }
        
    private void vypisInfoFakturaB1() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_INFO_1_X, BLOK_INFO_1_Y);
        cs.setFont(fontNormal, 10);
        cs.newLineAtOffset(0, -20);
        cs.showText("Zpusob uhrady:");
        cs.setFont(fontBold, 10);
        cs.newLineAtOffset(0, -20);
        cs.showText("Bankovni ucet:");
        cs.newLineAtOffset(100, 20);
        cs.showText("Prevodem");
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText("1234567890/0800");
        cs.endText();
    }
    
    private void vypisInfoFakturaB2() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_INFO_2_X, BLOK_INFO_2_Y);
        cs.setFont(fontNormal, 10);
        cs.newLineAtOffset(0, -20);
        cs.showText("Datum vystaveni:");
        cs.newLineAtOffset(0, -15);
        cs.showText("Datum splatnosti:");
        cs.newLineAtOffset(0, -15);
        cs.showText("Dat. zdan. plneni:");
        cs.newLineAtOffset(0, -20);
        cs.newLineAtOffset(100, 50);
        cs.showText("26.6.2018");
        cs.newLineAtOffset(0, -15);
        cs.showText("30.6.2018");
        cs.newLineAtOffset(0, -15);
        cs.showText("26.6.2018");
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.endText();
        
        
    }
    
    private void vypisCenuCelkem() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_CASTKA_X, BLOK_CASTKA_Y);
        cs.setFont(fontBold, 20);
        cs.showText("Celkem k uhrade: ");
        cs.newLineAtOffset(0, -30);
        cs.showText("50000,00 Kc");
        cs.endText();
    }
    
    private void vykresliQRkodB() throws IOException {
       
        qrkod k = new qrkod();
        ByteArrayInputStream bais = new ByteArrayInputStream(k.getQRCodeImage("neco2", 150, 150));
        BufferedImage bim = ImageIO.read(bais);
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, bim);
        cs.drawImage(pdImage, 400, 65);
        
    }
    
*/

}
