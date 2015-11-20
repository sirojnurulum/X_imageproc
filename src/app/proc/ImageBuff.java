/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.proc;

import java.awt.image.BufferedImage;

/**
 *
 * @author Siroj Nur Ulum
 */
public class ImageBuff {

    public static BufferedImage convertToRGB(BufferedImage image) {
        BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        tmp.getGraphics().drawImage(image, 0, 0, null);
        return tmp;
    }
}
