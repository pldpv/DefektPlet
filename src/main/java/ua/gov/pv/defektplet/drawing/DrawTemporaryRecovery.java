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
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawTemporaryRecovery implements Drawable {
     private IntervalInformation ii;
    private int scale;
    private final TemporaryRecovery tr;
    private final Integer lineHeight;
    private final Graphics2D g2;

    public DrawTemporaryRecovery(TemporaryRecovery tr, Graphics g, IntervalInformation ii, int scale, int lineHeight) {
        this.ii = ii;
        this.scale = scale;
        this.tr = tr;
        this.lineHeight = lineHeight;
        g2 = (Graphics2D) g;

    }

    public void draw() {
        Font f = new Font("Arial", Font.BOLD, lineHeight);
        FontMetrics fm = g2.getFontMetrics(f);
        g2.drawRect(getX(), 0, getWidth()+getX(), lineHeight);
        g2.setColor(Color.WHITE);
        g2.drawString(String.valueOf((int)tr.getTrLength()), getX()+(getWidth()
                -fm.stringWidth(String.valueOf((int)tr.getTrLength())))/2 , lineHeight-1);
    }

    
    private int getX() {
        return ((tr.getKm() - ii.kmS) * 1000 + tr.getM() - ii.mS) * 1000 / scale;
    }
    private int getWidth(){
        return (int) tr.getTrLength()*1000/scale;
    }

}
