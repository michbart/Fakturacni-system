/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import cz.jcu.uaidoklad.Model.Faktura;
import cz.jcu.uaidoklad.Model.QRkod;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

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
    private FakturaRepositoryImpl db;
    private FakturaRepositoryMock fakturaMock;
    private float celkovaCena = 0;
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
    public int BLOK_QR_X;
    public int BLOK_QR_Y;

    public PDF(Faktura f, FakturaRepositoryImpl db) {
        this.fakt = f;
        this.db = db;
        document = new PDDocument();
        page = new PDPage();
        document.addPage(page);
        fakturaMock = new FakturaRepositoryMock();
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
    private void nastavKonstanty() {
        BLOK_DODAVATEL_X = fakt.getBLOK_DODAVATEL_X();
        BLOK_DODAVATEL_Y = fakt.getBLOK_DODAVATEL_Y();
        BLOK_ODBERATEL_X = fakt.getBLOK_ODBERATEL_X();
        BLOK_ODBERATEL_Y = fakt.getBLOK_ODBERATEL_Y();
        BLOK_INFO_X = fakt.getBLOK_INFO_X();
        BLOK_INFO_Y = fakt.getBLOK_INFO_Y();
        BLOK_POLOZKY_X = fakt.getBLOK_POLOZKY_X();
        BLOK_POLOZKY_Y = fakt.getBLOK_POLOZKY_Y();
        BLOK_CELKEM_X = fakt.getBLOK_CELKEM_X();
        BLOK_CELKEM_Y = fakt.getBLOK_CELKEM_Y();
        BLOK_QR_X = fakt.getBLOK_QR_X();
        BLOK_QR_Y = fakt.getBLOK_QR_Y();
    }

    /**
     * Vygeneruje kompletni fakturu
     */
    public void vygeneruj() throws Exception {
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
            throw new Exception("faggit");
            //TODO
        }
    }

    /**
     * Vykresli horizontalni cary
     *
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
     *
     * @throws IOException
     */
    private void vypisCelkem() throws IOException {
        cs.beginText();
        cs.newLineAtOffset(BLOK_CELKEM_X, BLOK_CELKEM_Y);
        cs.setFont(fontBold, 12);
        cs.showText("Celkem k uhrade: ");
        cs.newLineAtOffset(160, 0);
        cs.showText(String.valueOf(String.valueOf(celkovaCena).format("%.02f", celkovaCena) + " Kc"));
        cs.endText();
    }

    /**
     * Vypise info o splatnosti, zpusobu uhrady a bankovnim spojeni
     *
     * @throws IOException
     */
    private void vypisInfoFaktura() throws IOException {
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
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        
        cs.showText(dateFormat.format(new Date())); //TODO
        cs.newLineAtOffset(0, -15);
        cs.showText(fakt.getDatumSplatnosti()); 
        cs.newLineAtOffset(0, -15);
        cs.showText(fakt.getZpusobPlatby()); 
        cs.newLineAtOffset(0, -20);
        cs.setFont(fontBold, 10);
        cs.showText(fakt.getDodavatel().getCisloUctu());
        cs.endText();
    }

    /**
     * Vypise info nad horizontalni carou u polozek
     *
     * @throws IOException
     */
    private void vypisInfoPolozky() throws IOException {
        cs.beginText();
        cs.newLineAtOffset(BLOK_POLOZKY_X, BLOK_POLOZKY_Y);
        cs.setFont(fontBold, 10);
        cs.showText("Popis");
        cs.newLineAtOffset(270, 0);
        cs.showText("Ks");
        cs.newLineAtOffset(40, 0);
        cs.showText("Cena ks");
        cs.newLineAtOffset(70, 0);
        cs.showText("DPH %");
        cs.newLineAtOffset(50, 0);
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
        cs.showText("IC: " + fakt.getDodavatel().getIc());
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
        cs.showText("IC: " + fakt.getOdberatel().getIc());
        cs.newLineAtOffset(0, -15);
        cs.showText("DIC: " + fakt.getOdberatel().getDic());
        cs.newLineAtOffset(100, 15);
        cs.showText("tel: " + fakt.getOdberatel().getTelefon());
        cs.newLineAtOffset(0, -15);
        cs.showText("email: " + fakt.getOdberatel().getEmail());
        cs.endText();
    }

    /**
     * Vypise polozky faktury pro vzor A
     */
    private void vypisPolozky() throws IOException {
        Polozka po;
        int pocet;
        double cena;
        cs.beginText();
        cs.setFont(fontNormal, 10);
        cs.newLineAtOffset(BLOK_POLOZKY_X, BLOK_POLOZKY_Y - 20);
        for (int id : fakt.getPolozky().keySet()) {
            try {
                //po = db.getPolozka(id);//polozka
                po = fakturaMock.getPolozka(id);
                pocet = fakt.getPolozky().get(id);
                cs.showText(po.getNazev());
                cs.newLineAtOffset(275, 0);
                cs.showText(String.valueOf(pocet));
                cs.newLineAtOffset(40, 0);
                cs.showText(String.valueOf(po.getCena()).format("%.02f", po.getCena()));
                cs.newLineAtOffset(75, 0);
                cs.showText("21");
                cs.newLineAtOffset(50, 0);
                cena = pocet * po.getCena() * 1.21;
                celkovaCena += cena;
                cs.showText(String.valueOf(cena).format("%.02f", cena));
                cs.newLineAtOffset(-440, -20);
            } catch (Exception ex) {
                //Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cs.endText();
    }

    /**
     * Vykresli QR kod s informacemi o platbe
     */
    private void vykresliQRkod() throws IOException {
//        cs.drawLine(70, 570, 220, 570);
//        cs.drawLine(70, 570, 70, 420);
//        cs.drawLine(220, 570, 220, 420);
//        cs.drawLine(70, 420, 220, 420);
        QRkod kod = new QRkod();
        ByteArrayInputStream bais = new ByteArrayInputStream(kod.getQRCodeImage(
                "Cislo faktury: " + fakt.getCislo() + "\n"
                + "Bankovni spojeni: " + fakt.getDodavatel().getCisloUctu() + "\n"
                + "Datum splatnosti: " + fakt.getDatumSplatnosti(),
                 150, 150));
        BufferedImage bim = ImageIO.read(bais);
        PDImageXObject pdImage = LosslessFactory.createFromImage(document, bim);
        cs.drawImage(pdImage, BLOK_QR_X, BLOK_QR_Y);
    }

    /**
     * Zavira zapis do PDF souboru
     *
     * @throws IOException
     */
    private void ukonciZapis() throws IOException {
        cs.close();
        document.save(fakt.getCislo() + ".pdf");
        document.close();
    }
}
