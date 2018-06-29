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
        Faktura instance = new Faktura(42, 4242, frm.getFirmy().get(0), frm.getFirmy().get(1), polozky, "qwert", "qasdfg", 1); 
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
        FirmaRepositoryMock frm = new FirmaRepositoryMock();
        HashMap<Integer, Integer> polozky = new HashMap();
        for (int i = 0; i < 10; i++) {
            polozky.put(i, i);
        }
        Faktura instance = new Faktura(42, 4242, frm.getFirmy().get(0), frm.getFirmy().get(1), polozky, "qwert", "qasdfg", 1);
        int expResult = 50;
        int result = instance.getBLOK_DODAVATEL_X();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Faktura.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        FirmaRepositoryMock frm = new FirmaRepositoryMock();
        HashMap<Integer, Integer> polozky = new HashMap();
        for (int i = 0; i < 10; i++) {
            polozky.put(i, i);
        }
        Faktura instance = new Faktura(42, 4242, frm.getFirmy().get(0), frm.getFirmy().get(1), polozky, "qwert", "qasdfg", 1);
        int expResult = 42;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Faktura.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        FirmaRepositoryMock frm = new FirmaRepositoryMock();
        HashMap<Integer, Integer> polozky = new HashMap();
        for (int i = 0; i < 10; i++) {
            polozky.put(i, i);
        }
        Faktura instance = new Faktura(42, 4242, frm.getFirmy().get(0), frm.getFirmy().get(1), polozky, "qwert", "qasdfg", 1);
        int id = 0;
        instance.setId(id);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
    
}
