/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import ua.gov.pv.defektplet.drawing.Drawable;
import ua.gov.pv.defektplet.helper.DrawableInfo;

/**
 *
 * @author Евген
 * @param <T>
 */
public class DrawableList<T extends Drawable> extends ArrayList<Drawable> {

    private final BufferedImage bImage;
    private List<DrawableInfo> info;

    public DrawableList(BufferedImage bImage) {
        this.info = new ArrayList<DrawableInfo>();
        this.bImage = bImage;
    }

    public void draw() {
        Graphics2D g2 = (Graphics2D) bImage.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, bImage.getWidth(), bImage.getHeight());
        for (Drawable d : this) {
            d.draw(g2);

        }
    }

    public BufferedImage getbImage() {
        return bImage;
    }

    private void createInfoList(int y_pos) {
        for (Drawable d : this) {
            if (d.getInfo() != null) {
                DrawableInfo characteristicInfo=d.getInfo();
                characteristicInfo.setY(y_pos+d.getInfo().getY());
                info.add(characteristicInfo);
            }
        }
    }

    public List<DrawableInfo> getInfoList(int y_pos) {
        createInfoList(y_pos);
        return info;
    }

}
