/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.helper;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import ua.gov.pv.defektplet.drawing.DrawDefekt;
import ua.gov.pv.defektplet.drawing.DrawRailsString;
import ua.gov.pv.defektplet.drawing.DrawTemporaryRecovery;
import ua.gov.pv.defektplet.drawing.Drawable;
import ua.gov.pv.defektplet.drawing.DrawableList;
import ua.gov.pv.defektplet.entity.RailsDefect;
import ua.gov.pv.defektplet.entity.RailsStrings;
import ua.gov.pv.defektplet.entity.TemporaryRecovery;

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

    private IntervalInformation ii;
    private final int SCALE;
    private static final int WIDTH=1000;
    private static final int LINE_HEIGHT = 10;
    private final Font FONT = new Font("Arial", Font.PLAIN, LINE_HEIGHT - 1);
    private BufferedImage bImage;
    private DefektPletHelper helper;

    public RailwayItem(Integer scale, IntervalInformation ii) {
        this.SCALE = scale;
        this.ii = ii;
        helper=new DefektPletHelper(ii);
    }

    public void draw() {
        BufferedImage b1 = drawRank();
        BufferedImage b2 = draw(fillDef());
        BufferedImage b3 = draw(fillRailsString());
        draw(fillTempRec());
       bImage = new BufferedImage(WIDTH, b1.getHeight() + b2.getHeight()
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
        BufferedImage result = new BufferedImage(1000, LINE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = result.createGraphics();
        g2.setFont(FONT);
        g2.drawRect(0, 0, 999, LINE_HEIGHT - 1);
        FontMetrics fMetrics = g2.getFontMetrics(FONT);
        for (int i = 0; i < 10; i++) {
            float rank = (ii.kmS * 1000 + ii.mS - 1 + i * SCALE / 10) / 1000f;
            g2.drawString(String.format("%.3f%n", rank), i * 100 - fMetrics.stringWidth(String.format("%.3f%n", rank)) / 2, LINE_HEIGHT - 1);
        }
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
        BufferedImage bi = new BufferedImage(WIDTH, LINE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawGrid(bi.createGraphics(),"Def");
        railsDefect = new DrawableList<Drawable>(bi);
        for (RailsDefect rd : helper.getRailsDefectList()) {
            railsDefect.add(new DrawDefekt(rd, bi.createGraphics(), ii, SCALE, LINE_HEIGHT,WIDTH));
        }
        return railsDefect;
    }
    public DrawableList<Drawable> fillRailsString() {
        BufferedImage bi = new BufferedImage(WIDTH, LINE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawGrid(bi.createGraphics(),"PLet");
        railsString = new DrawableList<Drawable>(bi);
        for (RailsStrings rs : helper.getRailsStrings()) {
            railsString.add(new DrawRailsString(rs, bi.createGraphics(), ii, SCALE, LINE_HEIGHT));
        }
        return railsString;
    }
    public DrawableList<Drawable> fillTempRec() {
        temporaryRecovery = new DrawableList<Drawable>();
        temporaryRecovery.setbImage(railsString.getbImage());
        for (TemporaryRecovery tr : helper.getTemporaryRecovery()) {
            temporaryRecovery.add(new DrawTemporaryRecovery(tr, temporaryRecovery.getbImage().createGraphics(), ii, SCALE, LINE_HEIGHT));
        }
        return temporaryRecovery;
    }
    private void drawGrid(Graphics g, String legend){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,WIDTH,LINE_HEIGHT);
        g2.setColor(Color.BLACK);
        g2.setFont(FONT);
        FontMetrics fm = g2.getFontMetrics(FONT);
        g2.drawString(legend, 10-fm.stringWidth(legend)/2, LINE_HEIGHT-1);
    }
}
