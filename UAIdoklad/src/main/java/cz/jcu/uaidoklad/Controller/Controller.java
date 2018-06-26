/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Controller;

import cz.jcu.uaidoklad.Model.Faktura;

/**
 *
 * @author Michal
 */
public interface Controller {
    void vygenerujPDF(Faktura f);
}
