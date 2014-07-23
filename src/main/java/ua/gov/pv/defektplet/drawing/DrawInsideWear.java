/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.*;
import java.awt.geom.AffineTransform;
import ua.gov.pv.defektplet.entity.SideWear;
import ua.gov.pv.defektplet.helper.DrawableInfo;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author 1
 */
public class DrawInsideWear implements Drawable {

    private SideWear sideWear;
    private final IntervalInformation ii;
    private final int penWidth;
    private final GraphicsCharacteristics gc;
    private DrawableInfo info;

    public DrawInsideWear(SideWear sideWear, GraphicsCharacteristics gc, IntervalInformation ii) {
        this.sideWear = sideWear;
        this.ii = ii;
        this.gc = gc;
        this.penWidth = gc.HEIGHT / 5;
        info = new DrawableInfo(getX(), gc.HEIGHT, getLength(), gc.HEIGHT, info());
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
   
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(penWidth));
        float inside = sideWear.getInsideSideWear();
        int position = gc.HEIGHT - penWidth;
        while (inside / 5 >= 1) {
            g2.drawLine(getX(), position, getX() + getLength(), position);
            position = position - penWidth;
            inside = inside - 5;
        }
        if (inside % 5 == 0 && inside != 0) {
            g2.drawLine(getX(), position, getX() + getLength(), position);
        }
        if (inside % 5 != 0 && inside != 0) {
            g2.setColor(Color.GRAY);
            g2.drawLine(getX(), position, getX() + getLength(), position);
        }

    }

    @Override
    public DrawableInfo getInfo() {
        return info;
    }

    private int getX() {
        return gc.LEGEND_WIDTH + ((sideWear.getKmS() - ii.getKmS()) * 1000
                + sideWear.getpK() * 100 - 100 + (sideWear.getLimb() * 25 - 25) - ii.getmS())
                * gc.IMG_WIDTH / gc.SCALE;
    }

    private int getLength() {
        return 25 * gc.IMG_WIDTH / gc.SCALE;
    }

    private String info() {
        String eol = System.getProperty("line.separator");
        String result = new String(
                "Боковой износ: " + sideWear.getInsideSideWear() + " мм");
        return result;
    }
}
