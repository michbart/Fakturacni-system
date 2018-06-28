/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NikolaKraus
 */
public class FakturaTest {
    
    public FakturaTest() {
    }

    /**
     * Test of getTyp method, of class Faktura.
     */
    @org.junit.Test
    public void testGetTyp() {
        FirmaRepositoryMock frm = new FirmaRepositoryMock();
        System.out.println("getTyp");
        HashMap<Integer, Integer> polozky = new HashMap();
        for (int i = 0; i < 10; i++) {
            polozky.put(i, i);
        }
        Faktura instance = new Faktura(42, 4242, frm.getFirmy().get(0), frm.getFirmy().get(1), polozky, "qwert", "qasdfg", 1) {
        int expResult = 1;
        int result = instance.getTyp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBLOK_DODAVATEL_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_DODAVATEL_X() {
        System.out.println("getBLOK_DODAVATEL_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_DODAVATEL_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_DODAVATEL_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_DODAVATEL_Y() {
        System.out.println("getBLOK_DODAVATEL_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_DODAVATEL_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_ODBERATEL_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_ODBERATEL_X() {
        System.out.println("getBLOK_ODBERATEL_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_ODBERATEL_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_ODBERATEL_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_ODBERATEL_Y() {
        System.out.println("getBLOK_ODBERATEL_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_ODBERATEL_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_INFO_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_INFO_X() {
        System.out.println("getBLOK_INFO_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_INFO_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_INFO_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_INFO_Y() {
        System.out.println("getBLOK_INFO_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_INFO_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_POLOZKY_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_POLOZKY_X() {
        System.out.println("getBLOK_POLOZKY_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_POLOZKY_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_POLOZKY_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_POLOZKY_Y() {
        System.out.println("getBLOK_POLOZKY_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_POLOZKY_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_CELKEM_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_CELKEM_X() {
        System.out.println("getBLOK_CELKEM_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_CELKEM_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_CELKEM_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_CELKEM_Y() {
        System.out.println("getBLOK_CELKEM_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_CELKEM_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_QR_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_QR_X() {
        System.out.println("getBLOK_QR_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_QR_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_QR_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_QR_Y() {
        System.out.println("getBLOK_QR_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_QR_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_CISLA_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_CISLA_X() {
        System.out.println("getBLOK_CISLA_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_CISLA_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_CISLA_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_CISLA_Y() {
        System.out.println("getBLOK_CISLA_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_CISLA_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_INFO2_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_INFO2_X() {
        System.out.println("getBLOK_INFO2_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_INFO2_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_INFO2_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_INFO2_Y() {
        System.out.println("getBLOK_INFO2_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_INFO2_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_CELKEM2_X method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_CELKEM2_X() {
        System.out.println("getBLOK_CELKEM2_X");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_CELKEM2_X();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBLOK_CELKEM2_Y method, of class Faktura.
     */
    @org.junit.Test
    public void testGetBLOK_CELKEM2_Y() {
        System.out.println("getBLOK_CELKEM2_Y");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getBLOK_CELKEM2_Y();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Faktura.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Faktura.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Faktura instance = null;
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatumSplatnosti method, of class Faktura.
     */
    @org.junit.Test
    public void testGetDatumSplatnosti() {
        System.out.println("getDatumSplatnosti");
        Faktura instance = null;
        String expResult = "";
        String result = instance.getDatumSplatnosti();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatumSplatnosti method, of class Faktura.
     */
    @org.junit.Test
    public void testSetDatumSplatnosti() {
        System.out.println("setDatumSplatnosti");
        String datumSplatnosti = "";
        Faktura instance = null;
        instance.setDatumSplatnosti(datumSplatnosti);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZpusobPlatby method, of class Faktura.
     */
    @org.junit.Test
    public void testGetZpusobPlatby() {
        System.out.println("getZpusobPlatby");
        Faktura instance = null;
        String expResult = "";
        String result = instance.getZpusobPlatby();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCislo method, of class Faktura.
     */
    @org.junit.Test
    public void testGetCislo() {
        System.out.println("getCislo");
        Faktura instance = null;
        int expResult = 0;
        int result = instance.getCislo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDodavatel method, of class Faktura.
     */
    @org.junit.Test
    public void testGetDodavatel() {
        System.out.println("getDodavatel");
        Faktura instance = null;
        Firma expResult = null;
        Firma result = instance.getDodavatel();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOdberatel method, of class Faktura.
     */
    @org.junit.Test
    public void testGetOdberatel() {
        System.out.println("getOdberatel");
        Faktura instance = null;
        Firma expResult = null;
        Firma result = instance.getOdberatel();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPolozky method, of class Faktura.
     */
    @org.junit.Test
    public void testGetPolozky() {
        System.out.println("getPolozky");
        Faktura instance = null;
        HashMap<Integer, Integer> expResult = null;
        HashMap<Integer, Integer> result = instance.getPolozky();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPolozky method, of class Faktura.
     */
    @org.junit.Test
    public void testSetPolozky() {
        System.out.println("setPolozky");
        HashMap<Integer, Integer> polozky = null;
        Faktura instance = null;
        instance.setPolozky(polozky);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCislo method, of class Faktura.
     */
    @org.junit.Test
    public void testSetCislo() {
        System.out.println("setCislo");
        int cislo = 0;
        Faktura instance = null;
        instance.setCislo(cislo);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDodavatel method, of class Faktura.
     */
    @org.junit.Test
    public void testSetDodavatel() {
        System.out.println("setDodavatel");
        Firma dodavatel = null;
        Faktura instance = null;
        instance.setDodavatel(dodavatel);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOdberatel method, of class Faktura.
     */
    @org.junit.Test
    public void testSetOdberatel() {
        System.out.println("setOdberatel");
        Firma odberatel = null;
        Faktura instance = null;
        instance.setOdberatel(odberatel);
        fail("The test case is a prototype.");
    }
    
}
