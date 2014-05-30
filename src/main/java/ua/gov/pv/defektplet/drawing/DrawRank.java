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
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class DrawRank implements Drawable {

    public DrawRank(IntervalInformation ii, GraphicsCharacteristics gc) {
        this.ii = ii;
        this.gc = gc;
     
    }

    private final IntervalInformation ii;
    private final GraphicsCharacteristics gc;
    

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(gc.font);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, gc.IMG_WIDTH + gc.LEGEND_WIDTH, gc.HEIGHT);
        g2.setColor(Color.BLACK);
        g2.drawLine(gc.LEGEND_WIDTH, gc.HEIGHT - 1, gc.LEGEND_WIDTH + gc.IMG_WIDTH,
                gc.HEIGHT - 1);
        FontMetrics fm = g2.getFontMetrics(gc.font);
        int startC = (ii.getmS() % 100 != 0) ? 100 - ii.getmS() % 100 : 0;
        for (int i = 0; i <= gc.SCALE; i += 100) {
            int x = gc.LEGEND_WIDTH + (startC + i) * gc.IMG_WIDTH / gc.SCALE;
            g2.drawLine(x, gc.HEIGHT, x, gc.HEIGHT - 2);
            if (i == gc.SCALE) {
                g2.drawString(getPk(ii.getmS() + i),
                        x - fm.stringWidth(getPk(ii.getmS() + i)), gc.HEIGHT - 3);
            } else {
                g2.drawString(getPk(ii.getmS() + i),
                        x - fm.stringWidth(getPk(ii.getmS() + i)) / 2, gc.HEIGHT - 3);
            }
        }
    }

    private String getPk(int m) {
        String str;
        str = (meterToPK(m) == 9) ? String.valueOf(1+(ii.getKmS() * 1000 + m) / 1000)+"км"
                : meterToPK(m) + "/" + (meterToPK(m) + 1);
        return str;
    }

    private int meterToPK(int m) {
        return m / 100 % 10;
    }
}
