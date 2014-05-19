/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Евген
 */
public class DrawableList<T extends Drawable> extends ArrayList<Drawable> {

    private boolean drawable;
    private BufferedImage bImage;

    public DrawableList(BufferedImage bImage) {
        this.drawable = true;
        this.bImage = bImage;
    }

    public DrawableList() {
        this.drawable = true;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    public boolean isDrawable() {
        return drawable;
    }

    public void draw() {
        for (Drawable d : this) {
            d.draw();
        }
    }

    public BufferedImage getbImage() {
        return bImage;
    }

    public void setbImage(BufferedImage bImage) {
        this.bImage = bImage;
    }
}
