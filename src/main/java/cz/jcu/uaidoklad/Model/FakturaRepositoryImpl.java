/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michal
 */
public class FakturaRepositoryImpl implements FakturaRepository {

    private String driver = "com.mysql.jdbc.Driver";
    private Connection pripojeni;

    /**
     * Constructor - pripojeni k DB
     *
     * @param url adresa databaze
     * @param uzivatel jmeno administratora
     * @param heslo heslo k DB
     * @throws Exception
     */
    public FakturaRepositoryImpl(String url, String uzivatel, String heslo) throws Exception {
        try {
            Class.forName(driver);
            pripojeni = (Connection) DriverManager.getConnection(url, uzivatel, heslo);
        } catch (SQLException ex) {
            throw new Exception("Nastala chyba při připojování k databázi.");
        }
    }

    /**
     * Odeslani SQL prikazu
     *
     * @param dotaz prikaz v SQL
     * @return pocet zmenenych radek
     * @throws Exception
     */
    private int poslatPrikaz(String dotaz) throws Exception {
        try (Statement st = pripojeni.createStatement()) {
            return st.executeUpdate(dotaz);
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    /**
     * Pridani do databaze INSERT
     *
     * @param tabulka nazev tabulky
     * @param nazevHodnota HashMap s nazvem atributu a jeho hodnotou
     * @throws Exception
     */
    private void zapsatDB(String tabulka, HashMap<String, String> nazevHodnota) throws Exception {
        String nazvy = "";
        String hodnoty = "";
        for (String nazev : nazevHodnota.keySet()) {
            nazvy = nazvy + nazev + ", ";
            hodnoty = hodnoty + nazevHodnota.get(nazev) + ", ";
        }
        try {
            String dotaz = "INSERT INTO " + tabulka + " (" + nazvy.substring(0, nazvy.length() - 2) + ") VALUES(" + hodnoty.substring(0, hodnoty.length() - 2) + ");";
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nepodařilo se zapsat do databáze." + ex.getMessage());
        }
    }

    /**
     * Mazani prvku z databaze podle Nazvu a Id
     *
     * @param tabulka Nazev Tabulky
     * @param nazevId nazev Id prvku
     * @param id hodnota Id Prvku
     * @throws Exception
     */
    private void smazatDB(String tabulka, String nazevId, String id) throws Exception {
        try {
            String dotaz = "DELETE FROM " + tabulka + " WHERE " + nazevId + " = " + id;
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nastala chyba při mazání v databázi." + ex.getMessage());
        }
    }

    /**
     * prepsani atributu v DB
     *
     * @param tabulka nazev tabulky
     * @param sloupecZmena co se ma prepsat
     * @param hodnotaZmena na co se ma prepsat
     * @param nazevId nazev id prvku
     * @param id id prvku
     * @throws Exception
     */
    private void upravitDB(String tabulka, String sloupecZmena, String hodnotaZmena, String nazevId, String id) throws Exception {
        try {
            String dotaz = "UPDATE " + tabulka + " SET " + sloupecZmena + " = '" + hodnotaZmena + "' WHERE " + nazevId + " = " + id;
            poslatPrikaz(dotaz);
        } catch (Exception ex) {
            throw new Exception("Nastala chyba při pŕepisování dat v databázi." + ex.getMessage());
        }
    }

    /**
     * vytvoreni pro precteni jednoho atributu z tabulky POMOCNE
     *
     * @param dotaz
     * @param sloupec
     * @return
     * @throws Exception
     */
    private ArrayList<String> ziskatUdajeDB(String dotaz, String sloupec) throws Exception {
        ArrayList<String> vysledek = new ArrayList();
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            while (rs.next()) {//ziskani dat kazdeho slouce
                vysledek.add(rs.getString(sloupec));
            }
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vysledek;
    }

    /**
     * ziskani faktury z DB
     *
     * @param id id Faktury
     * @return Faktura
     * @throws Exception Chyba pri cteni z DB
     */
    @Override
    public Faktura getFaktura(int id) throws Exception {
        String dotaz = "SELECT * FROM Faktura WHERE idRecept = '" + id + "';";
        //String typFaktury = ziskatUdajeDB(dotaz, "typ").get(0);
        Firma Dodavatel = this.getUzivatel(Integer.valueOf(ziskatUdajeDB(dotaz, "dodavatel").get(0)));
        Firma Odberatel = this.getUzivatel(Integer.valueOf(ziskatUdajeDB(dotaz, "odberatel").get(0)));
        HashMap<Integer, Integer> seznamPolozek = this.getListPolozekF(id);
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            Faktura vystup;
//            switch (rs.getString("typ")) {
//                case "FakturaA":
            vystup = new Faktura(rs.getInt("id"), rs.getInt("cislo"), Dodavatel, Odberatel, seznamPolozek, rs.getString("datumSplatnosti"), rs.getString("zpusobPlatby"), rs.getInt("typ"));
//                    break;
//                default:
//                    throw new AssertionError();
//            }
            return vystup;
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
    }

    @Override
    public void smazFaktura(int id) throws Exception {
        smazatDB("Faktura", "id", String.valueOf(id));
    }

    /**
     * ziskani listu faktur z DB
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Faktura> getListFaktur() throws Exception {
        ArrayList<Faktura> vystup = new ArrayList();
        String dotaz = "SELECT * FROM Faktura ;";
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            while (rs.next()) {
                vystup.add(new Faktura(rs.getInt("id"), rs.getInt("cislo"), rs.getString("datumSplatnosti"), rs.getString("zpusobPlatby"), rs.getInt("typ")));
            }
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        for (Faktura f : vystup) {
            String dotaz2 = "SELECT * FROM Faktura WHERE idRecept = '" + f.getId() + "';";
            f.setDodavatel(this.getUzivatel(Integer.valueOf(ziskatUdajeDB(dotaz2, "dodavatel").get(0))));
            f.setOdberatel(this.getUzivatel(Integer.valueOf(ziskatUdajeDB(dotaz2, "odberatel").get(0))));
        }
        return vystup;
    }

    @Override
    public void zmenFakturu(Faktura faktura) throws Exception {
        upravitDB("Faktura", "cislo", String.valueOf(faktura.getCislo()), "id", String.valueOf(faktura.getId()));
        upravitDB("Faktura", "dodavatel", String.valueOf(faktura.getDodavatel()), "id", String.valueOf(faktura.getId()));
        upravitDB("Faktura", "odberatel", String.valueOf(faktura.getOdberatel()), "id", String.valueOf(faktura.getId()));
        upravitDB("Faktura", "polozky", String.valueOf(faktura.getPolozky()), "id", String.valueOf(faktura.getId()));
        upravitDB("Faktura", "datumSplatnosti", String.valueOf(faktura.getDatumSplatnosti()), "id", String.valueOf(faktura.getId()));
        upravitDB("Faktura", "zpusobPlatby", String.valueOf(faktura.getZpusobPlatby()), "id", String.valueOf(faktura.getId()));

    }

    /**
     * Ziskani Uzivatele z DB
     *
     * @param id
     * @return
     * @throws Exception
     */
//    @Override
    public Firma getUzivatel(int id) throws Exception {
        String dotaz = "SELECT * FROM Uzivatel WHERE id = '" + id + "';";
        Firma vystup;
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            vystup = new Firma(rs.getInt("id"), rs.getString("nazev"), rs.getString("login"), rs.getInt("heslo"), rs.getString("ulice"), rs.getInt("psc"), rs.getString("mesto"), rs.getString("stat"), rs.getInt("ic"), rs.getInt("dic"), rs.getString("telefon"), rs.getString("email"), rs.getString("cisloUctu"));
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    /**
     * Ziskani Uzivatele z DB
     *
     * @param login
     * @param heslo
     * @return
     * @throws Exception
     */
//    @Override
    public Firma getUzivatel(String login, int heslo) throws Exception {
        String dotaz = "SELECT * FROM Uzivatel WHERE login = '" + login + "' AND heslo = '" + heslo + "';";
        Firma vystup;

        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            vystup = new Firma(rs.getInt("id"), rs.getString("nazev"), rs.getString("login"), rs.getInt("heslo"), rs.getString("ulice"), rs.getInt("psc"), rs.getString("mesto"), rs.getString("stat"), rs.getInt("ic"), rs.getInt("dic"), rs.getString("telefon"), rs.getString("email"), rs.getString("cisloUctu"));
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

//    @Override
    public void smazUzivatele(int id) throws Exception {
        smazatDB("Uzivatel", "id", String.valueOf(id));
    }

//    @Override
    public void zmenUzivatele(Firma uzivatel) throws Exception {
        upravitDB("Uzivatel", "nazev", String.valueOf(uzivatel.getNazev()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "login", String.valueOf(uzivatel.getLogin()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "heslo", String.valueOf(uzivatel.getHeslo()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "ulice", String.valueOf(uzivatel.getUlice()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "pcs", String.valueOf(uzivatel.getPsc()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "mesto", String.valueOf(uzivatel.getMesto()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "stat", String.valueOf(uzivatel.getStat()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "ic", String.valueOf(uzivatel.getIc()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "dic", String.valueOf(uzivatel.getDic()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "telefon", String.valueOf(uzivatel.getTelefon()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "email", String.valueOf(uzivatel.getEmail()), "id", String.valueOf(uzivatel.getId()));
        upravitDB("Uzivatel", "cisloUctu", String.valueOf(uzivatel.getCisloUctu()), "id", String.valueOf(uzivatel.getId()));
    }

    /**
     * Ziskani listu Firem
     *
     * @return
     * @throws Exception
     */
//    @Override
    public ArrayList<Firma> getListUzivatel() throws Exception {
        String dotaz = "SELECT * FROM Uzivatel;";
        ArrayList<Firma> vystup = new ArrayList();
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            while (rs.next()) {
                vystup.add(new Firma(rs.getInt("id"), rs.getString("nazev"), rs.getString("login"), rs.getInt("heslo"), rs.getString("ulice"), rs.getInt("psc"), rs.getString("mesto"), rs.getString("stat"), rs.getInt("ic"), rs.getInt("dic"), rs.getString("telefon"), rs.getString("email"), rs.getString("cisloUctu")));
            }
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    /**
     * Ziskani listu existujicich polozek z DB
     *
     * @return list polozek
     * @throws Exception
     */
    @Override
    public ArrayList<Polozka> getListPolozek() throws Exception {
        ArrayList<Polozka> vystup = new ArrayList();
        String dotaz = "SELECT * FROM Polozka ;";
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            while (rs.next()) {
                vystup.add(new Polozka(rs.getInt("id"), rs.getString("nazev"), rs.getDouble("cena"), rs.getString("mernaJednotka")));//int id, String nazev, double cena, String mernaJednotka
            }
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    /**
     * ziskani listu polozek faktury
     *
     * @param idFaktury
     * @return
     * @throws Exception
     */
    private HashMap<Integer, Integer> getListPolozekF(int idFaktury) throws Exception {
        HashMap<Integer, Integer> vystup = new HashMap();
        String dotaz = "SELECT * FROM Polozka WHERE fkIdFaktura = '" + idFaktury + "';";
        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            while (rs.next()) {
                vystup.put(rs.getInt("fkIdPolozka"), rs.getInt("pocetKs"));
            }
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    @Override
    public void zmenPolozku(Polozka polozka) throws Exception {
        upravitDB("Polozka", "nazev", String.valueOf(polozka.getNazev()), "id", String.valueOf(polozka.getId()));
        upravitDB("Polozka", "cena", String.valueOf(polozka.getCena()), "id", String.valueOf(polozka.getId()));
        upravitDB("Polozka", "mernaJednotka", String.valueOf(polozka.getMernaJednotka()), "id", String.valueOf(polozka.getId()));

    }

    @Override
    public void smazPolozku(int id) throws Exception {
        smazatDB("Polozka", "id", String.valueOf(id));

    }

    @Override
    public Polozka getPolozka(int id) throws Exception {
        String dotaz = "SELECT * FROM Polozka WHERE id = '" + id + "';";
        Polozka vystup;

        try (Statement st = pripojeni.createStatement();
                ResultSet rs = st.executeQuery(dotaz);) {
            vystup = new Polozka(rs.getInt("id"), rs.getString("nazev"), rs.getDouble("cena"), rs.getString("mernaJednotka"));
        } catch (SQLException ex) {
            throw new Exception("Chyba při čtení z databáze: " + ex.getMessage());
        }
        return vystup;
    }

    @Override
    public void ulozFaktura(Faktura faktura) throws Exception {

        HashMap<String, String> nazevHodnota = new HashMap();
        nazevHodnota.put("cislo", String.valueOf(faktura.getCislo()));
        nazevHodnota.put("typ", String.valueOf(faktura.getTyp()));
        nazevHodnota.put("fkIdDodavatel", String.valueOf(faktura.getDodavatel().getId()));
        nazevHodnota.put("fkIdOdberatel", String.valueOf(faktura.getOdberatel().getId()));
        nazevHodnota.put("id", String.valueOf(faktura.getId()));
        nazevHodnota.put("datumSplatnosti", faktura.getDatumSplatnosti());
        nazevHodnota.put("zpusobPlatby", String.valueOf(faktura.getZpusobPlatby()));
        zapsatDB("Faktura", nazevHodnota);
        if (ziskatUdajeDB("SELECT * FROM Uzivatel WHERE id = '" + faktura.getDodavatel().getId() + "';", "id").isEmpty()) {
            ulozFirma(faktura.getDodavatel());
        }
        if (ziskatUdajeDB("SELECT * FROM Uzivatel WHERE id = '" + faktura.getOdberatel().getId() + "';", "id").isEmpty()) {
            ulozFirma(faktura.getOdberatel());
        }

        ulozPolozkyF(faktura.getPolozky(), Integer.valueOf(ziskatUdajeDB("SELECT * FROM Faktura WHERE cislo = '" + faktura.getCislo() + "';", "id").get(0)));

    }

    public void ulozFirma(Firma firma) throws Exception{
        HashMap< String, String> nazevHodnota = new HashMap();
        nazevHodnota.put("id", String.valueOf(firma.getId()));
        nazevHodnota.put("nazev", firma.getNazev());
        nazevHodnota.put("login", firma.getLogin());
        nazevHodnota.put("heslo", String.valueOf(firma.getHeslo()));
        nazevHodnota.put("ulice", firma.getUlice());
        nazevHodnota.put("psc", String.valueOf(firma.getPsc()));
        nazevHodnota.put("mesto", firma.getMesto());
        nazevHodnota.put("stat", firma.getMesto());
        nazevHodnota.put("ic", String.valueOf(firma.getIc()));
        nazevHodnota.put("dic", String.valueOf(firma.getDic()));
        nazevHodnota.put("telefon", firma.getTelefon());
        nazevHodnota.put("email", firma.getEmail());
        nazevHodnota.put("cisloUctu", firma.getCisloUctu());
        zapsatDB("Firma", nazevHodnota);
    }
//int id, String nazev, String login, int heslo, String ulice, int psc, String mesto, String stat, int ic, int dic, int telefon, String email, String cisloUctu) {
    @Override
    public void ulozPolozka(Polozka polozka) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HashMap< String, String> nazevHodnota = new HashMap();
        nazevHodnota.put("cena", String.valueOf(polozka.getCena()));
        nazevHodnota.put("nazev", polozka.getNazev());
        nazevHodnota.put("cena", polozka.getMernaJednotka());
        zapsatDB("Polozka", nazevHodnota);
    }

    private void ulozPolozkyF(HashMap<Integer, Integer> polozky, int idFaktury) throws Exception {
        HashMap<String, String> zapis = new HashMap();
        for (int idPolozky : polozky.keySet()) {
            zapis.clear();
            zapis.put("pocetKs", String.valueOf(polozky.get(idPolozky)));
            zapis.put("fkIdFaktura", String.valueOf(idFaktury));
            zapis.put("fkIdPolozka", String.valueOf(idPolozky));
            zapsatDB("FakturaPolozka", zapis);
        }        
    }

}
