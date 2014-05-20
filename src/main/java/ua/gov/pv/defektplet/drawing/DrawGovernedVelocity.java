/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ���
 */
public class DrawGovernedVelocity implements Drawable {

    private final IntervalInformation ii;
    private final GovernedVelocity gv;
    private final Graphics2D g2;
    private final GraphicsCharacteristics gc;

    public DrawGovernedVelocity(GovernedVelocity gv, GraphicsCharacteristics gh,
            Graphics g, IntervalInformation ii) {
        this.gv = gv;
        g2 = (Graphics2D) g;
        this.ii = ii;
        this.gc = gh;
    }

    public void draw() {
        FontMetrics fm = g2.getFontMetrics(gc.font);
        g2.setColor(Color.BLACK);
        g2.drawLine(getEndX(), 0, getEndX(), gc.HEIGHT);
        g2.setColor(getColor());
        g2.setFont(gc.font);
        g2.drawString(getVelocity(), getStartX() + (getEndX() + getStartX()
                - fm.stringWidth(getVelocity())) / 2, gc.HEIGHT - 1);
    }

    private int getStartX() {
        if (gv.getKmS() * 1000 + gv.getmS() < ii.kmS * 1000 + ii.mS) {
            return gc.LEGEND_WIDTH;
        } else {
            return gc.LEGEND_WIDTH + ((gv.getKmS() - ii.kmS) * 1000 + gv.getmS() - ii.kmS)
                    * gc.IMG_WIDTH / gc.SCALE;
        }
    }

    private int getEndX() {
        if (gv.getKmE() * 1000 + gv.getmE() < ii.kmE * 1000 + ii.mE) {
            return ((gv.getKmE() - ii.kmS) * 1000 + gv.getmE() - ii.mS)
                    * gc.IMG_WIDTH / gc.SCALE;
        } else {
            return ((ii.kmE - ii.kmS) * 1000 - ii.mS + ii.mE) 
                    * gc.IMG_WIDTH / gc.SCALE;
        }
    }

    private String getVelocity() {
        String str;
        str = gv.getPassengerVelocity() + "/" + gv.getFreightVelocity();
        return str;
    }

    private Color getColor() {
        if (gv.getPassengerVelocity() > 140) {
            return Color.white;
        } else if ((gv.getPassengerVelocity() <= 140)
                && (gv.getPassengerVelocity() > 110)) {
            return Color.yellow;
        } else if ((gv.getPassengerVelocity() <= 110)
                && (gv.getPassengerVelocity() > 90)) {
            return Color.orange;
        } else if ((gv.getPassengerVelocity() <= 90)
                && (gv.getPassengerVelocity() > 80)) {
            return Color.red;
        } else if ((gv.getPassengerVelocity() <= 80)
                && (gv.getPassengerVelocity() > 60)) {
            return Color.pink;
        } else if ((gv.getPassengerVelocity() <= 60)
                && (gv.getPassengerVelocity() > 40)) {
            return Color.cyan;
        } else {
            return Color.black;
        }
    }
}
