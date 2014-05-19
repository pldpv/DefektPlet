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

    private IntervalInformation ii;
    private int scale;
    private final RailsStrings rs;
    private final Integer lineHeight;
    private final Graphics2D g2;
    private final Integer linePos;

    public DrawRailsString(RailsStrings rs, Graphics g, IntervalInformation ii, int scale, int lineHeight) {
        this.ii = ii;
        this.scale = scale;
        this.rs = rs;
        this.lineHeight = lineHeight;
        g2 = (Graphics2D) g;
        linePos = lineHeight / 2;

    }

    public void draw() {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 1000, lineHeight);
        g2.setColor(Color.BLACK);
        BasicStroke pen = new BasicStroke(2);
        g2.setStroke(pen);
        g2.drawLine(getStartX(), linePos, getEndX(), linePos);
    }

    private int getStartX() {
        if (rs.getKmS() * 1000 + rs.getmS() > ii.kmS * 1000 + ii.mS) {
            return (int) ((rs.getKmS() - ii.kmS) * 1000 + rs.getmS() - ii.mS) * 1000 / scale;
        } else {
            return 0;
        }
    }

    private int getEndX() {
        if (rs.getKmE() * 1000 + rs.getmE() < ii.kmE * 1000 + ii.mE) {
            return (int) ((rs.getKmE() - ii.kmS) * 1000 + rs.getmE() - ii.mS) * 1000 / scale;
        } else {
            return 1000;
        }
    }
}
