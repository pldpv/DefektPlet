/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class DrawRank implements Drawable {

    public DrawRank(IntervalInformation ii, GraphicsCharacteristics gc, Graphics2D g2) {
        this.ii = ii;
        this.gc = gc;
        this.g2 = g2;
    }

    private final IntervalInformation ii;
    private final GraphicsCharacteristics gc;
    private final Graphics2D g2;

    @Override
    public void draw() {
        g2.setFont(gc.font);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, gc.IMG_WIDTH + gc.LEGEND_WIDTH, gc.HEIGHT);
        g2.setColor(Color.BLACK);
        g2.drawLine(gc.LEGEND_WIDTH, gc.HEIGHT - 1, gc.LEGEND_WIDTH + gc.IMG_WIDTH,
                gc.HEIGHT - 1);
        FontMetrics fm = g2.getFontMetrics(gc.font);
        int startC = (ii.mS % 100 != 0) ? 100 - ii.mS % 100 : 0;
        for (int i = 0; i <= gc.SCALE; i += 100) {
            int x = gc.LEGEND_WIDTH + (startC + i) * gc.IMG_WIDTH / gc.SCALE;
            g2.drawLine(x, gc.HEIGHT, x, gc.HEIGHT - 2);
            if (i == gc.SCALE) {
                g2.drawString(getPk(ii.mS + i),
                        x - fm.stringWidth(getPk(ii.mS + i)), gc.HEIGHT - 3);
            } else {
                g2.drawString(getPk(ii.mS + i),
                        x - fm.stringWidth(getPk(ii.mS + i)) / 2, gc.HEIGHT - 3);
            }
        }
    }

    private String getPk(int m) {
        String str;
        str = (meterToPK(m) == 9) ? String.valueOf(1+(ii.kmS * 1000 + m) / 1000)+"км"
                : meterToPK(m) + "/" + (meterToPK(m) + 1);
        return str;
    }

    private int meterToPK(int m) {
        return m / 100 % 10;
    }
}
