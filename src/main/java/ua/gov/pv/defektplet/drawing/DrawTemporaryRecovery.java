/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.helper.CharacteristicsInfo;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawTemporaryRecovery implements Drawable {

    private IntervalInformation ii;
    private final TemporaryRecovery tr;
    private final GraphicsCharacteristics gc;

    public DrawTemporaryRecovery(TemporaryRecovery tr,
            GraphicsCharacteristics gh, IntervalInformation ii) {
        this.ii = ii;
        this.tr = tr;
        this.gc = gh;

    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        FontMetrics fm = g2.getFontMetrics(gc.font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(gc.font);
        g2.setColor(Color.WHITE);
        g2.fillRect(getX(), 0, getWidth(), gc.HEIGHT - 1);
        g2.setColor(Color.BLACK);
        g2.drawString(String.valueOf((int) tr.getTrLength()),
                getX() + (getWidth() - fm.stringWidth(String.valueOf((int) tr.getTrLength()))) / 2, gc.HEIGHT - 1);
        g2.drawRect(getX(), 0, getWidth(), gc.HEIGHT - 1);
    }

    private int getX() {
        return gc.LEGEND_WIDTH
                + ((tr.getKm() - ii.getKmS()) * 1000 + tr.getM() - ii.getmS())
                * gc.IMG_WIDTH / gc.SCALE;
    }

    private int getWidth() {
        return (int) tr.getTrLength()
                * gc.IMG_WIDTH / gc.SCALE;
    }

    @Override
    public CharacteristicsInfo getInfo() {
        return null;
    }

}
