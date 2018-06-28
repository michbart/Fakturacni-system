/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.ArrayList;

/**
 *
 * @author NikolaKraus
 */
public interface FakturaRepository {

    public Faktura getFaktura(int id) throws Exception;

    public void smazFaktura(int id) throws Exception;

    public ArrayList<Faktura> getListFaktur() throws Exception;

    public void zmenFakturu(Faktura faktura) throws Exception;

    public Firma getUzivatel(int id) throws Exception;

    public Firma getUzivatel(String login, int heslo) throws Exception;

    public void smazUzivatele(int id)throws Exception;

    public void zmenUzivatele(Firma uzivatel) throws Exception;

    public ArrayList<Firma> getListUzivatel() throws Exception;

    public ArrayList<Polozka> getListPolozek() throws Exception;

    public void zmenPolozku(Polozka polozka) throws Exception;

    public void smazPolozku(int id) throws Exception;

    public Polozka getPolozka(int id) throws Exception;

}
