/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import ua.gov.pv.defektplet.drawing.Drawable;
import ua.gov.pv.defektplet.drawing.GraphicsCharacteristics;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 * @param <T>
 */
public abstract class DrawableList<T extends Drawable> extends ArrayList<Drawable> {

    BufferedImage bImage;
    IntervalInformation ii;
    GraphicsCharacteristics gc;

    public DrawableList(IntervalInformation ii, GraphicsCharacteristics gc) {
        this.ii = ii;
        this.gc = gc;
    }
    public DrawableList(){
        
    }
    public void draw() {
        for (Drawable d : this) {
            d.draw();
        }
    }

    public BufferedImage getbImage() {
        return bImage;
    }

    abstract void fillList();
}
