/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

/**
 *
 * @author Michal
 */
public class CompanyInvoiceImpl implements FakturaService {
    @Override
    public void vygenerujPDF(Faktura f, Databaze db) {
        new PDF(f, db).vygeneruj();
        //treba vyhodit okno ze bylo provedeno uspesne
    } 
}
