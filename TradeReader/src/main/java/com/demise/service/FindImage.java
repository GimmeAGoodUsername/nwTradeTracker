package com.demise.service;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Utility class for image matching. This code is useful for cases where you are
 * trying to find where a sub-image appears in a larger image. For example,
 * where a button appears on a screen shot of a web page.
 *
 * @author Jayson Falkner - jfalkner@gmail.com
 */
public class FindImage {



    public static Point match(BufferedImage subimage, BufferedImage image) {
        // brute force N^2 check all places in the image
        for (int i = 0; i <= image.getWidth() - subimage.getWidth(); i++) {
            check_subimage:
            for (int j = 0; j <= image.getHeight() - subimage.getHeight(); j++) {
                for (int ii = 0; ii < subimage.getWidth(); ii++) {
                    for (int jj = 0; jj < subimage.getHeight(); jj++) {
                        if (subimage.getRGB(ii, jj) != image.getRGB(i + ii, j + jj)) {
                            continue check_subimage;
                        }
                    }
                }
                // if here, all pixels matched
                return new Point(i, j);
            }
        }
        return null;
    }

    public static BufferedImage screenshot() throws AWTException {
        Robot r = new Robot();
        // take a full screenshot
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        return r.createScreenCapture(screenRect);
    }

}
