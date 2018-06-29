/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NikolaKraus
 */
public class FakturaRepositoryTest {
    
    public FakturaRepositoryTest() {
    }

    /**
     * Test of ulozFaktura method, of class FakturaRepository.
     */
    @Test
    public void testUlozFaktura() throws Exception {
        System.out.println("ulozFaktura");
        Faktura faktura = null;
        FakturaRepository instance = new FakturaRepositoryMock();
        
        instance.ulozFaktura(faktura);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaktura method, of class FakturaRepository.
     */
    @Test
    public void testGetFaktura() throws Exception {
        System.out.println("getFaktura");
        int id = 0;
        FakturaRepository instance = new FakturaRepositoryImpl();
        Faktura expResult = null;
        Faktura result = instance.getFaktura(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of smazFaktura method, of class FakturaRepository.
     */
    @Test
    public void testSmazFaktura() throws Exception {
        System.out.println("smazFaktura");
        int id = 0;
        FakturaRepository instance = new FakturaRepositoryImpl();
        instance.smazFaktura(id);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListFaktur method, of class FakturaRepository.
     */
    @Test
    public void testGetListFaktur() throws Exception {
        System.out.println("getListFaktur");
        FakturaRepository instance = new FakturaRepositoryImpl();
        ArrayList<Faktura> expResult = null;
        ArrayList<Faktura> result = instance.getListFaktur();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of zmenFakturu method, of class FakturaRepository.
     */
    @Test
    public void testZmenFakturu() throws Exception {
        System.out.println("zmenFakturu");
        Faktura faktura = null;
        FakturaRepository instance = new FakturaRepositoryImpl();
        instance.zmenFakturu(faktura);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPolozek method, of class FakturaRepository.
     */
    @Test
    public void testGetListPolozek() throws Exception {
        System.out.println("getListPolozek");
        FakturaRepository instance = new FakturaRepositoryImpl();
        ArrayList<Polozka> expResult = null;
        ArrayList<Polozka> result = instance.getListPolozek();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of ulozPolozka method, of class FakturaRepository.
     */
    @Test
    public void testUlozPolozka() throws Exception {
        System.out.println("ulozPolozka");
        Polozka polozka = null;
        FakturaRepository instance = new FakturaRepositoryImpl();
        instance.ulozPolozka(polozka);
        fail("The test case is a prototype.");
    }

    /**
     * Test of zmenPolozku method, of class FakturaRepository.
     */
    @Test
    public void testZmenPolozku() throws Exception {
        System.out.println("zmenPolozku");
        Polozka polozka = null;
        FakturaRepository instance = new FakturaRepositoryImpl();
        instance.zmenPolozku(polozka);
        fail("The test case is a prototype.");
    }

    /**
     * Test of smazPolozku method, of class FakturaRepository.
     */
    @Test
    public void testSmazPolozku() throws Exception {
        System.out.println("smazPolozku");
        int id = 0;
        FakturaRepository instance = new FakturaRepositoryImpl();
        instance.smazPolozku(id);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPolozka method, of class FakturaRepository.
     */
    @Test
    public void testGetPolozka() throws Exception {
        System.out.println("getPolozka");
        int id = 0;
        FakturaRepository instance = new FakturaRepositoryImpl();
        Polozka expResult = null;
        Polozka result = instance.getPolozka(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public class FakturaRepositoryImpl implements FakturaRepository {

        public void ulozFaktura(Faktura faktura) throws Exception {
        }

        public Faktura getFaktura(int id) throws Exception {
            return null;
        }

        public void smazFaktura(int id) throws Exception {
        }

        public ArrayList<Faktura> getListFaktur() throws Exception {
            return null;
        }

        public void zmenFakturu(Faktura faktura) throws Exception {
        }

        public ArrayList<Polozka> getListPolozek() throws Exception {
            return null;
        }

        public void ulozPolozka(Polozka polozka) throws Exception {
        }

        public void zmenPolozku(Polozka polozka) throws Exception {
        }

        public void smazPolozku(int id) throws Exception {
        }

        public Polozka getPolozka(int id) throws Exception {
            return null;
        }
    }
    
}
