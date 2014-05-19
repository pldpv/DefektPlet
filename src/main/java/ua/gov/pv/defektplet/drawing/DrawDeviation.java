/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author �����
 */
public class DrawDeviation implements Drawable {

    private IntervalInformation ii;
    private int scale;
    private final Deviation deviation;
    private final Integer lineHeight;
    private final int penWidth;
    private final Graphics2D g2;

    public DrawDeviation(Deviation dev, Graphics g, IntervalInformation ii, int scale, int lineHeight) {
        this.ii = ii;
        this.scale = scale;
        this.deviation = dev;
        this.lineHeight = lineHeight;
        g2 = (Graphics2D) g;
        penWidth = 1000 / scale;

    }

    public void draw() {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 1000, lineHeight);
        g2.setColor(getColor());
        g2.fillRect(getX(), 0, penWidth, lineHeight);
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
        return ((deviation.getKm() - ii.kmS) * 1000 + deviation.getM() - ii.mS) * 1000 / scale;
    }

}
