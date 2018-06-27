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
public interface DBInterface {
    public Faktura getFakruta(int id)throws Exception;
    public ArrayList<Faktura> getListFaktur()throws Exception;
    public void zmenFakturu(Faktura faktura)throws Exception;
    public Uzivatel getUzivatel(int id)throws Exception;
    public Uzivatel getUzivatel(String login, int heslo)throws Exception;
    public void zmenUzivatele(Uzivatel uzivatel)throws Exception;
    public ArrayList<Uzivatel> getListUzivatel()throws Exception;
    public ArrayList <Polozka> getListPolozek()throws Exception;
    public void zmenPolozku()throws Exception;
    public Polozka getPolozka(int id)throws Exception;
    
    
}
