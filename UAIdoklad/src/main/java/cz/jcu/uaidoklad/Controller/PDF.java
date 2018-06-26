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

    public PDF(Faktura f) {
        this.fakt = f;
        document = new PDDocument();
        page = new PDPage();
        try {
            cs = new PDPageContentStream(document, page);
        } catch (IOException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            //TODO
        }
        nastavKonstanty();
    }

    public void nastavKonstanty() {
        BLOK_DODAVATEL_X = fakt.blokDodavatelX();
        BLOK_DODAVATEL_Y = fakt.blokDodavatelY();
        BLOK_ODBERATEL_X = fakt.blokOdberatelX();
        BLOK_ODBERATEL_Y = fakt.blokOdberatelY();
    }

    public void vygeneruj() {
        try {
            vykresliOhraniceni();
            vypisDodavatele();
            vypisOdberatele();
            vypisPolozky();
            ukonciZapis();
        } catch (IOException ex) {
            //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            //TODO
        }
    }

    /**
     * Vykresli ohraniceni
     */
    private void vykresliOhraniceni() throws IOException {

        cs.drawLine(0, 0, 0, 0);

    }

    /**
     * Vypise info o dodavateli
     */
    private void vypisDodavatele() throws IOException {
        cs.beginText();
        cs.setFont(fontNormal, 13);
        cs.moveTextPositionByAmount(BLOK_DODAVATEL_X, BLOK_DODAVATEL_Y);
        cs.drawString(fakt.getDodavatel().getNazev());
        //TODO zbytek
        cs.endText();
    }

    /**
     * Vypise info o odberateli
     */
    private void vypisOdberatele() throws IOException {
        cs.beginText();
        cs.setFont(fontBold, 13);
        cs.moveTextPositionByAmount(BLOK_ODBERATEL_X, BLOK_ODBERATEL_Y);
        cs.drawString(fakt.getOdberatel().getNazev());
        //TODO zbytek
        cs.endText();
        cs.endText();
    }

    /**
     * Vypise polozky
     */
    private void vypisPolozky() throws IOException {
        //foreach z listu
        cs.endText();
    }

    /**
     * Vykresli QR kod
     */
    private void vykresliQRkod() {

    }

    private void ukonciZapis() throws IOException {
        cs.close();
        document.save(fakt.getCislo() + ".pdf");
        document.close();
    }
}
