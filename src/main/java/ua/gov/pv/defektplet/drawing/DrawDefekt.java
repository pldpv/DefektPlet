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
import ua.gov.pv.defektplet.helper.DrawableInfo;
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
    private DrawableInfo info;

    public DrawableInfo getInfo() {
        return info;
    }

    public DrawDefekt(RailsDefect rd, GraphicsCharacteristics gh, IntervalInformation ii) {
        this.ii = ii;
        this.rd = rd;
        this.gc = gh;
        penWidth = 2;//gh.IMG_WIDTH / gh.SCALE;
        info = new DrawableInfo(getX(),gc.HEIGHT , penWidth, gc.HEIGHT, info());
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
         g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        //g2.fillRect(getX(), 0, penWidth, gc.HEIGHT);
        g2.drawOval(getX(), gc.HEIGHT/2 -3, 6, 6);
    }

    private int getX() {
        return gc.LEGEND_WIDTH + ((rd.getKm() - ii.getKmS()) * 1000 + rd.getM() - ii.getmS())
                * gc.IMG_WIDTH / gc.SCALE;
    }

    private String info() {
        String eol = System.getProperty("line.separator");
        String result = new String(
                "Код: " + rd.getDefectCode() + eol
                + "Длина: " + rd.getDefectLength() + eol
                + "Глубина: " + rd.getDefectHeight() + eol
                + "Ширина: " + rd.getDefectWidth() + eol
                + "Дата: " + rd.getDateOfFounding());
        return result;
    }
}
