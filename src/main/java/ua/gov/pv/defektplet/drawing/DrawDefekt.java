/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawDefekt implements Drawable {

    private IntervalInformation ii;
    private int scale;
    private RailsDefect rd;
    private final Integer lineHeight;
    private int penWidth;
    private Graphics2D g2;
    private final Integer WIDTH;

    public DrawDefekt(RailsDefect rd, Graphics g, IntervalInformation ii,
            int scale, int lineHeight, Integer width) {
        this.ii = ii;
        this.scale = scale;
        this.rd = rd;
        this.lineHeight = lineHeight;
        g2 = (Graphics2D) g;
        penWidth = 1000 / scale;
        this.WIDTH = width;
    }

    public void draw() {
        g2.setColor(Color.BLACK);
        g2.fillRect(getX(), 0, penWidth, lineHeight);
    }

    private int getX() {
        return ((rd.getKm() - ii.kmS) * 1000 + rd.getM() - ii.mS) * 1000 / scale;
    }

}
