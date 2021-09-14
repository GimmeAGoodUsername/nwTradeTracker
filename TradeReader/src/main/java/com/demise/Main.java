package com.demise;

import com.demise.service.Drawer;
import com.demise.service.FindImage;
import com.demise.service.ImageLocator;
import org.opencv.core.Core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class Main {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    /**
     * Useful entry point for matching images via command-line. Simply run the
     * code with the sub-image and image passed as arguments.
     * <p>
     * java FindImage sub_image.png image.png
     * <p>
     * Note, if matching many images, use the `match` method as an API.
     * Launching the JVM every time you need to do a match is relatively slow!
     * This entry point mostly exists to formally capture the simple demo code.
     *
     * @param args The file location of the sub-image and image, respectively.
     * @throws Exception If either of the image files can't be found.
     */
    public static void main( String[] args ) throws Exception {

        String imagePath = "C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\test1.png";
        String templatePath = "C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\materials/beanssmol.png";
        ImageLocator imageLocator = new ImageLocator();
        imageLocator.scan(imagePath, templatePath);
        /*
        // Load the sub-image you want to find that appears in the image, respectively.
        BufferedImage subimage = ImageIO.read(new File("C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\materials/beanssmol.png"));
        BufferedImage image = ImageIO.read(new File("C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\test1.png"));

        // Attempt to find the match.
        Point match = FindImage.match(subimage, image);

        // If null, no match. Otherwise, show where the match occurred.
        if ( match == null ) {
            System.out.println("no");
        } else {
            System.out.println("Found img in img:" + match.x + "," + match.y);
            Drawer drawer = new Drawer();
            drawer.drawDot(image, match);

         }
           */

    }

}