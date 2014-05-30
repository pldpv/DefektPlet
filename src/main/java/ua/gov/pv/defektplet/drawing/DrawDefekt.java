/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawDefekt implements Drawable {

    private final IntervalInformation ii;
    private final RailsDefect rd;
    private final int penWidth;
    private final GraphicsCharacteristics gc;

    public DrawDefekt(RailsDefect rd, GraphicsCharacteristics gh, IntervalInformation ii) {
        this.ii = ii;
        this.rd = rd;
        this.gc = gh;
        penWidth = gh.IMG_WIDTH / gh.SCALE;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(getX(), 0, penWidth, gc.HEIGHT);
    }

    private int getX() {
        return gc.LEGEND_WIDTH + ((rd.getKm() - ii.getKmS()) * 1000 + rd.getM() - ii.getmS())
                * gc.IMG_WIDTH / gc.SCALE;
    }

}
