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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import ua.gov.pv.defektplet.drawing.DrawDeviation;
import ua.gov.pv.defektplet.drawing.DrawGovernedVelocity;
import ua.gov.pv.defektplet.entity.Deviation;
import ua.gov.pv.defektplet.entity.GovernedVelocity;
import ua.gov.pv.defektplet.util.HibernateUtil;
import ua.gov.pv.defektplet.drawing.Drawable;
import ua.gov.pv.defektplet.drawing.DrawableList;

/**
 *
 * @author
 */
public class RailwayItem {

    //  private DrawableList<Deviation> realigning;
    private List<Deviation> deviation;

    private List<GovernedVelocity> gv;
    private HashMap<List<Object>, BufferedImage> hm;
    Session session = null;
    private IntervalInformation ii;
    private final int SCALE;
    private static final int WIDTH=1000;
    private static final int LINE_HEIGHT = 10;
    private final Font FONT = new Font("Arial", Font.PLAIN, LINE_HEIGHT - 1);
    private BufferedImage bImage;

    public RailwayItem(Integer scale, IntervalInformation ii) {
        this.SCALE = scale;
        this.ii = ii;
    }

    public void draw() {
        BufferedImage b1 = drawRank();
        BufferedImage b2 = drawGovernedVelocityList();
        BufferedImage b3 = drawDeviationList();
        bImage = new BufferedImage(1000, b1.getHeight() + b2.getHeight()
                + b3.getHeight() - 3, BufferedImage.TYPE_INT_RGB);
        Graphics g = bImage.getGraphics();
        g.drawImage(b1, 0, 0, null);
        g.drawImage(b2, 0, b1.getHeight() - 1, null);
        g.drawImage(b3, 0, b1.getHeight() + b2.getHeight() - 2, null);
        g.dispose();
    }

    public void saveImg() {
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\" + ii.kmS + "," + ii.mS + ".PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void drawRailwayItem(DrawableList d) {
        if (d.getDrawable() == true) {
            d.draw();
        }
    }

    private void drawGrid(Graphics g, int lineCount) {
        Graphics2D g2 = (Graphics2D) g;
        float[] dash = {5, 3, 1, 3};
        BasicStroke pen = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 10, dash, 0);

        //Drawing working space grid
        g2.setColor(Color.white);
        g2.drawRect(0, 0, 999, lineCount * LINE_HEIGHT - 1);
        for (int i = 100; i < 1000; i += 100) {
            g2.drawLine(i, 0, i, LINE_HEIGHT * lineCount);
        }
        for (int i = LINE_HEIGHT; i < lineCount * LINE_HEIGHT; i += LINE_HEIGHT) {
            g2.setStroke(pen);
            g2.setColor(Color.white);
            g2.drawLine(0, i, 1000, i);
        }
    }

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

    private BufferedImage drawDeviationList() {
        BufferedImage result = new BufferedImage(1000, 6 * LINE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = result.createGraphics();
        drawGrid(g2, 6);
        for (Deviation dev : getDeviationList()) {
            Drawable drawDev = new DrawDeviation(dev, g2, ii, SCALE, LINE_HEIGHT);
            drawDev.draw();
        }
        return result;
    }

    private BufferedImage drawGovernedVelocityList() {
        BufferedImage result = new BufferedImage(1000, LINE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = result.createGraphics();
        for (GovernedVelocity gv : getVelocityList()) {
            Drawable drawGV = new DrawGovernedVelocity(gv, g2, ii, SCALE, LINE_HEIGHT);
            drawGV.draw();
        }
        return result;
    }
    public BufferedImage drawRItem(){
        
    }
    public BufferedImage draw(DrawableList dl) {
        if (dl.getDrawable() == true) {
            dl.draw();
            return dl.getBufferedImage();
        }
        return null;
    }

    private List<GovernedVelocity> getGovernedVelocity() {
        gv = new ArrayList<GovernedVelocity>();
        session = HibernateUtil.getSessionFactory().openSession();
        Criterion cr1 = Restrictions.le("startCoordinate", ii.kmE * 1000 + ii.mE);
        Criterion cr2 = Restrictions.ge("endCoordinate", ii.kmS * 1000 + ii.mS);
        gv = session.createCriteria(GovernedVelocity.class)
                .setFetchMode("direction", FetchMode.JOIN)
                .add(Restrictions.eq("direction.idDirection", ii.idDirection))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.and(cr1, cr2))
                .list();
        session.close();
        return gv;
    }

    private List<Deviation> getDeviations() {
        deviation = new ArrayList<Deviation>();
        session = HibernateUtil.getSessionFactory().openSession();
        deviation = session.createCriteria(Deviation.class)
                .setFetchMode("direction", FetchMode.JOIN)
                .add(Restrictions.eq("direction.idDirection", ii.idDirection))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.between("coordinate", ii.kmS * 1000 + ii.mS, ii.kmE * 1000 + ii.mE))
                .list();
        session.close();
        return deviation;
    }

    public DrawableList<Drawable> fillDrawable() {
        BufferedImage bi = new BufferedImage(WIDTH, LINE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        DrawableList<Drawable> result = new DrawableList<Drawable>(bi);
        for (Deviation d : getDeviations()) {
            result.add(new DrawDeviation(d, bi.createGraphics(), ii, SCALE, SCALE));
        }
        return result;
    }
}
