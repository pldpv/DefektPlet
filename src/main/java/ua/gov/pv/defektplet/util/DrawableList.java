/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import ua.gov.pv.defektplet.drawing.Drawable;

/**
 *
 * @author Евген
 * @param <T>
 */
public class DrawableList<T extends Drawable> extends ArrayList<Drawable> {

    
    private final BufferedImage bImage;
    
    public DrawableList(BufferedImage bImage) {
        this.bImage=bImage;
    }

    public void draw() {
        Graphics2D g2 = (Graphics2D) bImage.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, bImage.getWidth(),bImage.getHeight());
        for (Drawable d : this) {
            d.draw(g2);
        }
    }

    public BufferedImage getbImage(){
        return bImage;
    }
}
