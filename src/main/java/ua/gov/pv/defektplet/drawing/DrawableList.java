/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Евген
 */
public class DrawableList<T extends Drawable> extends ArrayList<Drawable> {

    private boolean drawable;
    private static BufferedImage bImage;
    public DrawableList(BufferedImage bImage) {
        this.drawable = true;
        this.bImage=bImage;
    }
    
    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public boolean getDrawable() {
        return drawable;
    }

    public void draw() {
        for (Drawable d : this) {
            d.draw();
        }
    }
    public BufferedImage getBufferedImage(){
        return bImage;
    }
}
