/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.helper.DrawableInfo;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author �����
 */
public class DrawDeviation implements Drawable {

    private IntervalInformation ii;
    private final Deviation deviation;
    private final int penWidth;
    private final GraphicsCharacteristics gc;

    public DrawDeviation(Deviation dev, GraphicsCharacteristics gh, IntervalInformation ii) {
        this.ii = ii;
        this.deviation = dev;
        this.gc=gh;
        penWidth =  gh.IMG_WIDTH/gh.SCALE;

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 1000, gc.HEIGHT);
        g2.setColor(getColor());
        g2.fillRect(getX(), 0, penWidth, gc.HEIGHT);
    }

    private Color getColor() {
        switch (deviation.getLevel()) {
            case 5:
                return Color.RED;
            case 4:
                return Color.YELLOW;
            case 3:
                return Color.GREEN;
        }
        return Color.BLACK;
    }

    private int getX() {
        return ((deviation.getKm() - ii.getKmS()) * 1000 + deviation.getM() - ii.getmS()) * gc.IMG_WIDTH / gc.SCALE;
    }

    @Override
    public DrawableInfo getInfo() {
        return null;
    }

}
