package ua.gov.pv.defektplet.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
    
    private BufferedImage image;
    BufferedImage result;
    Dimension d;
    public ImagePanel(BufferedImage bImage){
        this.image=bImage;
        int imgWidth=Someclass.screenSize.width-100;
        int imgHeight=bImage.getHeight()*imgWidth/image.getWidth();
        result =new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        setSize(new Dimension(result.getWidth(), result.getHeight()));
        paintComponent(result.createGraphics());
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\result.PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void setBImage(BufferedImage image){
        this.image=image;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,result.getWidth(), result.getHeight(),null);
    }
    public void paint(){
        if (result!=null){
            paintComponent(result.createGraphics());
        }
    }

}