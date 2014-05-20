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
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawRailsString implements Drawable {

    private final IntervalInformation ii;
    private final RailsStrings rs;
    private final Graphics2D g2;
    private final Integer linePos;
    private final GraphicsCharacteristics gc;

    public DrawRailsString(RailsStrings rs, GraphicsCharacteristics gh,
            Graphics g, IntervalInformation ii) {
        this.ii = ii;
        this.rs = rs;
        g2 = (Graphics2D) g;
        this.gc = gh;
        linePos = gh.HEIGHT / 2;

    }

    public void draw() {
        g2.setColor(Color.BLACK);
        BasicStroke pen = new BasicStroke(2);
        g2.setStroke(pen);
        g2.drawLine(getStartX(), linePos, getEndX(), linePos);
    }

    private int getStartX() {
        if (rs.getKmS() * 1000 + rs.getmS() > ii.kmS * 1000 + ii.mS) {
            return (int) (gc.LEGEND_WIDTH
                    + ((rs.getKmS() - ii.kmS) * 1000 + rs.getmS() - ii.mS)
                    * gc.IMG_WIDTH / gc.SCALE);
        } else {
            return gc.LEGEND_WIDTH;
        }
    }

    private int getEndX() {
        if (rs.getKmE() * 1000 + rs.getmE() < ii.kmE * 1000 + ii.mE) {
            return (int) (gc.LEGEND_WIDTH
                    + ((rs.getKmE() - ii.kmS) * 1000 + rs.getmE() - ii.mS)
                    * gc.IMG_WIDTH / gc.SCALE);
        } else {
            return gc.IMG_WIDTH + gc.LEGEND_WIDTH;
        }
    }
}
