package ua.gov.pv.defektplet.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
   
    public ImagePanel(BufferedImage bImage) {
        this.image = bImage;
    }
    public void setBImage(BufferedImage bImage){
        image=bImage;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }

}
