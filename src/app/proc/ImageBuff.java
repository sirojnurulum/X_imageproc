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

    public static BufferedImage convertToGray(BufferedImage image) {
        BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        tmp.getGraphics().drawImage(image, 0, 0, null);
        int[] data = tmp.getRaster().getPixels(0, 0, tmp.getWidth(), tmp.getHeight(), (int[]) null);
        for (int i = 0; i < data.length; i += 3) {
            data[i] = data[i + 1] = data[i + 2] = (int) ((data[i] * 0.299) + (data[i + 1] * 0.587) + (data[i + 2] * 0.114));
        }
        tmp.getRaster().setPixels(0, 0, tmp.getWidth(), tmp.getHeight(), data);
        return tmp;
    }

    public static int checkColor(int color) {
        if (color >= 255) {
            return 255;
        } else {
            return color;
        }
    }

    public static BufferedImage buremin(BufferedImage image) {
        BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        tmp.getGraphics().drawImage(image, 0, 0, null);
        int[] sample = new int[3];
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (y == 0) {
                    if (x == 0) {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[0] * 4)) / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[1] * 4)) / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[2] * 4)) / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    } else if (x == tmp.getWidth() - 1) {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[0] * 4)) / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[1] * 4)) / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[2] * 4)) / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    } else {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[0] * 2))
                                / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[1] * 2))
                                / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[2] * 2))
                                / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    }
                } else if (y == tmp.getHeight() - 1) {
                    if (x == 0) {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[0] * 4)) / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[1] * 4)) / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[2] * 4)) / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    } else if (x == tmp.getWidth() - 1) {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[0] * 4)) / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[1] * 4)) / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[2] * 4)) / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    } else {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[0] * 2))
                                / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[1] * 2))
                                / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[2] * 2))
                                / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    }
                } else {
                    if (x == 0) {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[0] * 2))
                                / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[1] * 2))
                                / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[2] * 2))
                                / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    } else if (x == tmp.getWidth() - 1) {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[0] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[0] * 2))
                                / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[1] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[1] * 2))
                                / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[2] * 2)
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[2] * 2))
                                / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    } else {
                        int r = ((tmp.getRaster().getPixel(x, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[0])
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[0]))
                                / 9;
                        int g = ((tmp.getRaster().getPixel(x, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[1])
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[1]))
                                / 9;
                        int b = ((tmp.getRaster().getPixel(x, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x, y - 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x, y + 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y + 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x + 1, y - 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y - 1, (int[]) null)[2])
                                + (tmp.getRaster().getPixel(x - 1, y + 1, (int[]) null)[2]))
                                / 9;
                        sample[0] = checkColor(r);
                        sample[1] = checkColor(g);
                        sample[2] = checkColor(b);
                        tmp.getRaster().setPixel(x, y, sample);
                    }
                }
            }
            tmp.getRaster().setPixels(0, 0, tmp.getWidth(), tmp.getHeight(), tmp.getRaster().getPixels(0, 0, tmp.getWidth(), tmp.getHeight(), (int[]) null));
        }
        return tmp;
    }

}
