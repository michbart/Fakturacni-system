/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Michal
 */
public class QRkod {
    
    public QRkod(){
        
    }
    
    /**
     * Vygeneruje QR kod pro PDF
     * @param text info o fakture
     * @param width sirka QR kodu
     * @param height vyska QR kodu
     * @return data o QR kodu
     */
    public byte[] getQRCodeImage(String text, int width, int height)  {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();
            return pngData;
        } catch (WriterException | IOException ex) {
            //Logger.getLogger(qrkod.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}