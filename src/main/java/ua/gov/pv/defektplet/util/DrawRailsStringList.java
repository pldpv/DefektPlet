/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import ua.gov.pv.defektplet.drawing.DrawRailsString;
import ua.gov.pv.defektplet.drawing.Drawable;
import ua.gov.pv.defektplet.drawing.GraphicsCharacteristics;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 * @param <T>
 */
public class DrawRailsStringList<T extends Drawable> extends DrawableList<Drawable> {

    public DrawRailsStringList(IntervalInformation ii, GraphicsCharacteristics gc) {
        super(ii, gc);
        bImage = new BufferedImage(gc.IMG_WIDTH + gc.LEGEND_WIDTH,
                gc.HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    public DrawRailsStringList() {
    }

    @Override
    public void draw() {
        Graphics2D g2 = (Graphics2D) bImage.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, gc.IMG_WIDTH + gc.LEGEND_WIDTH, gc.HEIGHT);
        super.draw();
    }

    @Override
    void fillList() {
        for (RailsStrings rs : new DefectStringsDataSource().
                getRailsStrings(ii.direction, ii.line, ii.railThread,
                        ii.kmS, ii.mS, ii.kmE, ii.mE)) {
            this.add(new DrawRailsString(rs, gc, bImage.createGraphics(), ii));
        }
    }
}
