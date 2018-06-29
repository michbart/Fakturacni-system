/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.uaidoklad.Model;

import org.junit.Test;
import static org.junit.Assert.*;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NikolaKraus
 */
public class QRkodTest {
    
    public QRkodTest() {
    }

    /**
     * Test of getQRCodeImage method, of class QRkod.
     */
    @Test
    public void testGetQRCodeImage() {
        System.out.println("getQRCodeImage");
        String text = "qwert";
        int width = 9;
        int height = 9;
        QRkod instance = new QRkod();
        String expResult = text;
        byte[] resultB = instance.getQRCodeImage(text, width, height);
        String result = null;
        try {
            result = decodeQRCode(resultB);
        } catch (IOException ex) {
            Logger.getLogger(QRkodTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(expResult, result);
        
    }
    
    private static String decodeQRCode(byte[] bitecode) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bitecode);
        BufferedImage bufferedImage = ImageIO.read(bais);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }
}
