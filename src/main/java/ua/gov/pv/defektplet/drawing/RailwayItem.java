/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import ua.gov.pv.defektplet.util.DrawableList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author
 */
public class RailwayItem {

    List<DrawableList<? extends Drawable>> drawableList;

    private BufferedImage bImage;
    public static final Logger LOG=Logger.getLogger(RailwayItem.class);
    public RailwayItem(List<DrawableList<? extends Drawable>> drawableList) {
        this.drawableList = drawableList;
        draw();
    }

    private void draw() {
        bImage = new BufferedImage(getImageWidth(), getImageHeight(), 
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bImage.getGraphics();
        for (DrawableList dl:drawableList){
            int height=0;
            g.drawImage(dl.getbImage(), 0, height, null);
            height+=dl.getbImage().getHeight();
        }
        g.dispose();
    }
    private int getImageHeight(){
        int result=0;
        for (DrawableList dl:drawableList){
            result+=dl.getbImage().getHeight();
        }
        return result;
    }
    private int getImageWidth(){
        return drawableList.get(0).getbImage().getWidth();
    }
    public void saveImg(String fileName) {
        draw();
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\"+fileName+".PNG"));
        } catch (IOException ex) {
            LOG.log(Level.ERROR, ex);
        }
    }
    public BufferedImage getImage() {
        return bImage;
    }
}
