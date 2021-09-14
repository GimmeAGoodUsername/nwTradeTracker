package com.demise.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawer {

    public void drawDot( BufferedImage bufferedImage, Point p ) throws IOException {
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.RED);
        graphics.drawRect((int) p.getX(), (int) p.getY(), 20, 9);
        graphics.dispose();
        ImageIO.write(bufferedImage,"png",new File("C:\\Users\\Happy\\Desktop\\work\\workspace\\TradeReader\\src\\main\\resources\\img\\testres1.png"));
    }
}
