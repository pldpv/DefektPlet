/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import ua.gov.pv.defektplet.drawing.DrawDefekt;
import ua.gov.pv.defektplet.drawing.DrawGovernedVelocity;
import ua.gov.pv.defektplet.drawing.Drawable;
import ua.gov.pv.defektplet.drawing.GraphicsCharacteristics;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public final class DrawGovernedVelocityList<T extends Drawable> extends DrawableList<Drawable> {
BufferedImage bImage;
    public DrawGovernedVelocityList(IntervalInformation ii,
            GraphicsCharacteristics gc) {
        super(ii, gc);
        bImage = new BufferedImage(gc.IMG_WIDTH + gc.LEGEND_WIDTH,
                gc.HEIGHT, BufferedImage.TYPE_INT_RGB);
        fillList();
        draw();
    }

    @Override
    void fillList() {
        for (GovernedVelocity gv : new DefectStringsDataSource().
                getGovernedVelocity(ii.direction, ii.line,
                        ii.kmS, ii.mS, ii.kmE, ii.mE)) {
            this.add(new DrawGovernedVelocity(gv, gc, bImage.createGraphics(), ii));
        }
    }

    @Override
    public void draw() {
        Graphics2D g2 = (Graphics2D) bImage.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, gc.IMG_WIDTH + gc.LEGEND_WIDTH, gc.HEIGHT);
        super.draw();
    }
    public BufferedImage getbImage() {
        return bImage;
    }
}
