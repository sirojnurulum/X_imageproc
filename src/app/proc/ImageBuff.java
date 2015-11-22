/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.proc;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

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

    public static Raster convertToGray(Raster raster) {
        int[] data = raster.getPixels(0, 0, raster.getWidth(), raster.getHeight(), (int[]) null);
        for (int i = 0; i < data.length; i += 3) {
            int r = (int) (data[i] * 0.299);
            int g = (int) (data[i + 1] * 0.587);
            int b = (int) (data[i + 2] * 0.114);
        }
        return null;
    }
}
