/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Controller;

import cz.jcu.uaidoklad.Model.Faktura;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Michal
 */
public class PDF {

    private Faktura fakt;
    private PDDocument document;
    private PDPage page;
    private PDFont fontNormal = PDType1Font.HELVETICA;
    private PDFont fontBold = PDType1Font.HELVETICA_BOLD;
    private PDPageContentStream cs;
    public int BLOK_DODAVATEL_X;
    public int BLOK_DODAVATEL_Y;
    public int BLOK_ODBERATEL_X;
    public int BLOK_ODBERATEL_Y;
    public int BLOK_INFO_X;
    public int BLOK_INFO_Y;
    public int BLOK_POLOZKY_X;
    public int BLOK_POLOZKY_Y;
    public int BLOK_CELKEM_X;
    public int BLOK_CELKEM_Y;

    public PDF(Faktura f) {
        this.fakt = f;
        document = new PDDocument();
        page = new PDPage();
        document.addPage(page);
        try {
            cs = new PDPageContentStream(document, page);
        } catch (IOException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            //TODO
        }
        nastavKonstanty();
    }

    /**
     * Nastavuje konstanty pro dany typ faktury
     */
    public void nastavKonstanty() {
        BLOK_DODAVATEL_X = fakt.blokDodavatelX();
        BLOK_DODAVATEL_Y = fakt.blokDodavatelY();
        BLOK_ODBERATEL_X = fakt.blokOdberatelX();
        BLOK_ODBERATEL_Y = fakt.blokOdberatelY();
        BLOK_INFO_X = fakt.blokInfoX();
        BLOK_INFO_Y = fakt.blokInfoY();
        BLOK_POLOZKY_X = fakt.blokPolozkyX();
        BLOK_POLOZKY_Y = fakt.blokPolozkyY();
        BLOK_CELKEM_X = fakt.blokCelkemX();
        BLOK_CELKEM_Y = fakt.blokCelkemY();
    }

    /**
     * Vygeneruje kompletni fakturu
     */
    public void vygeneruj() {
        try {
            vykresliOhraniceni();
            vypisDodavatele();
            vypisOdberatele();
            vypisInfoFaktura();
            vypisInfoPolozky();
            vypisPolozky();
            vykresliQRkod();
            vypisCelkem();
            ukonciZapis();
        } catch (IOException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            //TODO
        }
    }
    /**
     * Vykresli horizontalni cary
     * @throws IOException 
     */
    private void vykresliOhraniceni() throws IOException {

        cs.drawLine(50, 675, 560, 675);
        cs.drawLine(300, 625, 560, 625);
        cs.drawLine(50, 385, 560, 385);
        cs.drawLine(300, 45, 560, 45);
    }
    
    /**
     * Vypise informace na spodni care pdfka
     * @throws IOException 
     */
    private void vypisCelkem() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_CELKEM_X, BLOK_CELKEM_Y);
        cs.setFont(fontBold, 12);
        cs.showText("Celkem k uhrade: ");
        cs.newLineAtOffset(160, 0);
        cs.showText("50000,00 Kc"); //TODO
        cs.endText();
    }
    
    /**
     * Vypise info o splatnosti, zpusobu uhrady a bankovnim spojeni
     * @throws IOException 
     */
    private void vypisInfoFaktura() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_INFO_X, BLOK_INFO_Y);
        cs.setFont(fontBold, 15);
        cs.showText("Faktura - danovy doklad - " + fakt.getCislo());
        cs.setFont(fontNormal, 10);
        cs.newLineAtOffset(0, -20);
        cs.showText("Datum vystaveni:");
        cs.newLineAtOffset(0, -15);
        cs.showText("Datum splatnosti:");
        cs.newLineAtOffset(0, -15);
        cs.showText("Zpusob uhrady:");
        cs.setFont(fontBold, 10);
        cs.newLineAtOffset(0, -20);
        cs.showText("Bankovni ucet:");
        cs.setFont(fontNormal, 10);
        cs.newLineAtOffset(100, 50);
        cs.showText("26.6.2018"); //TODO
        cs.newLineAtOffset(0, -15);
        cs.showText("30.6.2018"); //TODO
        cs.newLineAtOffset(0, -15);
        cs.showText("Prevodem"); //TODO
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText("1234567890/0800"); //TODO
        cs.endText();
    }

    /**
     * Vypise info nad horizontalni carou u polozek
     * @throws IOException 
     */
    private void vypisInfoPolozky() throws IOException{
        cs.beginText();
        cs.newLineAtOffset(BLOK_POLOZKY_X, BLOK_POLOZKY_Y);
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
    
    /**
     * Vypise info o dodavateli
     */
    private void vypisDodavatele() throws IOException {
        cs.beginText();   
        cs.newLineAtOffset(BLOK_DODAVATEL_X, BLOK_DODAVATEL_Y); 
        cs.setFont(fontNormal, 10);
        cs.showText("Dodavatel:");
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText(fakt.getDodavatel().getNazev());
        cs.newLineAtOffset(0, -15);
        cs.setFont(fontNormal, 10);
        cs.showText(fakt.getDodavatel().getUlice());
        cs.newLineAtOffset(0, -15);
        cs.showText(fakt.getDodavatel().getPsc() + " " + fakt.getDodavatel().getMesto());
        cs.newLineAtOffset(0, -15);
        cs.showText(fakt.getDodavatel().getStat());
        cs.newLineAtOffset(200, 30);
        cs.showText("IC:    " + fakt.getDodavatel().getIc());
        cs.newLineAtOffset(0, -15);
        cs.showText("DIC: " + fakt.getDodavatel().getDic());
        cs.newLineAtOffset(100, 15);
        cs.showText("tel: " + fakt.getDodavatel().getTelefon());
        cs.newLineAtOffset(0, -15);
        cs.showText("email: " + fakt.getDodavatel().getEmail());
        cs.endText();
    }

    /**
     * Vypise info o odberateli
     */
    private void vypisOdberatele() throws IOException {
        cs.beginText();
        cs.setFont(fontBold, 10);
        cs.newLineAtOffset(BLOK_ODBERATEL_X, BLOK_ODBERATEL_Y); 
        cs.setFont(fontNormal, 10);
        cs.showText("Odberatel:");
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText(fakt.getOdberatel().getNazev());
        cs.newLineAtOffset(0, -15);
        cs.setFont(fontNormal, 10);
        cs.showText(fakt.getOdberatel().getUlice());
        cs.newLineAtOffset(0, -15);
        cs.showText(fakt.getOdberatel().getPsc() + " " + fakt.getOdberatel().getMesto());
        cs.newLineAtOffset(0, -15);
        cs.showText(fakt.getOdberatel().getStat());
        cs.newLineAtOffset(0, -30);
        cs.showText("IC:    " + fakt.getOdberatel().getIc());
        cs.newLineAtOffset(0, -15);
        cs.showText("DIC: " + fakt.getOdberatel().getDic());
        cs.newLineAtOffset(100, 15);
        cs.showText("tel: " + fakt.getOdberatel().getTelefon());
        cs.newLineAtOffset(0, -15);
        cs.showText("email: " + fakt.getOdberatel().getEmail());
        cs.endText();
    }

    /**
     * Vypise polozky
     */
    private void vypisPolozky() throws IOException {
        //foreach z listu
        //cs.endText();
    }

    /**
     * Vykresli QR kod
     * TODO
     */
    private void vykresliQRkod() throws IOException { 
        cs.drawLine(70, 570, 220, 570);
        cs.drawLine(70, 570, 70, 420);
        cs.drawLine(220, 570, 220, 420);
        cs.drawLine(70, 420, 220, 420);
        
    }

    /**
     * Zavira zapis do PDF souboru
     * @throws IOException 
     */
    private void ukonciZapis() throws IOException {
        cs.close();
        document.save("file.pdf");
        document.close();
    }
}
