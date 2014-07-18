package ua.gov.pv.defektplet.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;
import ua.gov.pv.defektplet.helper.DrawableInfo;
import ua.gov.pv.defektplet.util.GraphicsContent;

public class ImagePanel extends JPanel {

    private BufferedImage result;
    private float offset;
    private GraphicsContent content;

    public ImagePanel(GraphicsContent content) {
        setLayout(null);
        requestFocusInWindow();
        this.content = content;
        int imgWidth = Someclass.screenSize.width - 100;
        offset = (float) imgWidth / content.getbImage().getWidth();
        float imgHeight = offset * content.getbImage().getHeight();
        result = new BufferedImage(imgWidth, (int) imgHeight, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(result.getWidth(), result.getHeight()));
    }
    public BufferedImage getImage(){
        return result;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(content.getbImage(), 0, 0, result.getWidth(), result.getHeight(), null);
        
    }

    public void paint() {

        if (result != null) {
            paintComponent(result.createGraphics());
        }
        drawPopUp();
    }

    public void reDraw() {
        for (Component comp : getComponents()) {
            remove(comp);
        }
        paint();
    }

    private void drawPopUp() {
        for (DrawableInfo info : content.getList()) {
            float x_pos, y_pos;
            x_pos = y_pos = offset;
            x_pos *= info.getX();
            y_pos *= info.getY();
            PopUpInfo panel = new PopUpInfo(info.getInfo().toString(), (int) x_pos, (int) y_pos);
            //PopUpInfo pop=new PopUpInfo(info.getInfo().toString());
            //pop.setLocation((int)x_pos, (int) y_pos);
            //pop.setVisible(true);
            add(panel);
        }
    }

    public void setGraphicsContent(GraphicsContent graphicsContent) {
        content = graphicsContent;
    }

}
