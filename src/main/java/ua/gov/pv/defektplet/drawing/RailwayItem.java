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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import javax.imageio.ImageIO;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;
import ua.gov.pv.defektplet.helper.DefektPletHelper;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author
 */
public class RailwayItem {

    DrawableList<Drawable> railsString;
    DrawableList<Drawable> railsDefect;
    DrawableList<Drawable> temporaryRecovery;
    DrawableList<Drawable> governedVelocity;
    DrawableList<Drawable> [] deviation;

    private final IntervalInformation ii;
    private final GraphicsCharacteristics gc;
    private BufferedImage bImage;
    private final DefektPletHelper helper;

    public RailwayItem(GraphicsCharacteristics gc, 
            IntervalInformation ii) {
        this.ii = ii;
        helper=new DefektPletHelper(ii);
        this.gc=gc;
    }

    public void draw() {
        BufferedImage b1 = drawRank();
        BufferedImage b2 = draw(fillDef());
        BufferedImage b3 = draw(fillRailsString());
        draw(fillTempRec());
        bImage = new BufferedImage(gc.IMG_WIDTH+gc.LEGEND_WIDTH, b1.getHeight() + b2.getHeight()
                + b3.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = bImage.getGraphics();
        g.drawImage(b1, 0, 0, null);
        g.drawImage(b2, 0, b1.getHeight(), null);
        g.drawImage(b3, 0, b1.getHeight() + b2.getHeight(), null);
        g.dispose();
    }

    public void saveImg() {
        draw();
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\" + ii.kmS + "," + ii.mS + ".PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


//    private void drawGrid(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        float[] dash = {5, 3, 1, 3};
//        BasicStroke pen = new BasicStroke(1, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_BEVEL, 10, dash, 0);
//
//        //Drawing working space grid
//        g2.setColor(Color.white);
//        g2.drawRect(0, 0, 999, g2. * LINE_HEIGHT - 1);
//        for (int i = 100; i < 1000; i += 100) {
//            g2.drawLine(i, 0, i, LINE_HEIGHT * lineCount);
//        }
//        for (int i = LINE_HEIGHT; i < lineCount * LINE_HEIGHT; i += LINE_HEIGHT) {
//            g2.setStroke(pen);
//            g2.setColor(Color.white);
//            g2.drawLine(0, i, 1000, i);
//        }
//    }

    private BufferedImage drawRank() {
        BufferedImage result = new BufferedImage(gc.IMG_WIDTH+gc.LEGEND_WIDTH,
                gc.HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = result.createGraphics();
        DrawRank dr=new DrawRank(ii, gc, g2);
        dr.draw();
        return result;
    }


    public BufferedImage draw(DrawableList dl) {
        if (dl.isDrawable()) {
            dl.draw();
            return dl.getbImage();
        }
        return null;
    }


    public DrawableList<Drawable> fillDef() {
        BufferedImage bi = new BufferedImage(gc.IMG_WIDTH+gc.LEGEND_WIDTH,
                gc.HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawGrid(bi.createGraphics(),"Дефекты");
        railsDefect = new DrawableList<Drawable>(bi);
        for (RailsDefect rd : helper.getRailsDefectList()) {
            railsDefect.add(new DrawDefekt(rd, gc, bi.createGraphics(), ii));
        }
        return railsDefect;
    }
    public DrawableList<Drawable> fillRailsString() {
        BufferedImage bi = new BufferedImage(gc.IMG_WIDTH+gc.LEGEND_WIDTH, 
                gc.HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawGrid(bi.createGraphics(),"Плеть/ВВ");
        railsString = new DrawableList<Drawable>(bi);
        for (RailsStrings rs : helper.getRailsStrings()) {
            railsString.add(new DrawRailsString(rs, gc, bi.createGraphics(), ii));
        }
        return railsString;
    }
    public DrawableList<Drawable> fillTempRec() {
        temporaryRecovery = new DrawableList<Drawable>();
        temporaryRecovery.setbImage(railsString.getbImage());
        for (TemporaryRecovery tr : helper.getTemporaryRecovery()) {
            temporaryRecovery.add(new DrawTemporaryRecovery(tr, gc, 
                    temporaryRecovery.getbImage().createGraphics(), ii));
        }
        return temporaryRecovery;
    }
    private void drawGrid(Graphics g, String legend){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,gc.IMG_WIDTH+gc.LEGEND_WIDTH,gc.HEIGHT);
        g2.setColor(Color.BLACK);
     //   g2.drawRect(0, 0, gc.IMG_WIDTH+gc.LEGEND_WIDTH, gc.HEIGHT);
        g2.setFont(gc.font);
        FontMetrics fm = g2.getFontMetrics(gc.font);
        g2.drawString(legend, gc.LEGEND_WIDTH/2-fm.stringWidth(legend)/2, gc.HEIGHT-1);
    }
    public BufferedImage getImage(){
        return bImage;
    }
}
