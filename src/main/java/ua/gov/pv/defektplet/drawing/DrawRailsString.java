/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.helper.DrawableInfo;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawRailsString implements Drawable {

    private final IntervalInformation ii;
    private final RailsStrings rs;
    private final Integer linePos;
    private final GraphicsCharacteristics gc;

    public DrawRailsString(RailsStrings rs, GraphicsCharacteristics gh,
            IntervalInformation ii) {
        this.ii = ii;
        this.rs = rs;
        this.gc = gh;
        linePos = gh.HEIGHT / 2;

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        BasicStroke pen = new BasicStroke(2);
        g2.setStroke(pen);
        g2.drawLine(getStartX(), linePos, getEndX(), linePos);
    }

    private int getStartX() {
        if (rs.getKmS() * 1000 + rs.getmS() > ii.getKmS() * 1000 + ii.getmS()) {
            return (int) (((rs.getKmS() - ii.getKmS()) * 1000 + rs.getmS() - ii.getmS())
                    * gc.IMG_WIDTH / gc.SCALE);
        } else {
            return 0;
        }
    }

    private int getEndX() {
        if (rs.getKmE() * 1000 + rs.getmE() < ii.getKmE() * 1000 + ii.getmE()) {
            return (int) (((rs.getKmE() - ii.getKmS()) * 1000 + rs.getmE() - ii.getmS())
                    * gc.IMG_WIDTH / gc.SCALE);
        } else {
            return gc.IMG_WIDTH;
        }
    }

    @Override
    public DrawableInfo getInfo() {
        return null;
    }
}
