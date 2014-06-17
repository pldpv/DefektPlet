package ua.gov.pv.defektplet.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JPanel;
import ua.gov.pv.defektplet.helper.CharacteristicsInfo;
import ua.gov.pv.defektplet.util.GraphicsContent;

public class ImagePanel extends JPanel {

    private BufferedImage result;
    private float offset;
    private GraphicsContent<BufferedImage, List<CharacteristicsInfo>> content;

    public ImagePanel(GraphicsContent<BufferedImage, List<CharacteristicsInfo>> content) {
        setLayout(null);
        requestFocusInWindow();
        this.content = content;
        int imgWidth = Someclass.screenSize.width - 100;
        offset = (float)imgWidth / content.getbImage().getWidth();
        float imgHeight = offset * content.getbImage().getHeight();
        result = new BufferedImage(imgWidth, (int) imgHeight, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(result.getWidth(), result.getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(content.getbImage(), 0, 0, result.getWidth(), result.getHeight(), null);
    }

    public void paint() {
        if (result != null) {
            paintComponent(result.createGraphics());
        }
        drawPopUp();
    }
    
    public void reDraw(){
        for (Component comp:getComponents()){
            remove(comp);
        }
        paint();
    }
    private void drawPopUp() {
        for (CharacteristicsInfo info : content.getList()) {
            float x_pos, y_pos;
            x_pos = y_pos = offset;
            x_pos *= info.getX();
            y_pos *= info.getY();
            Panel panel = new Panel(info.getInfo().toString(),(int) x_pos, (int) y_pos);
            add(panel);
        }
    }

    public void setGraphicsContent(GraphicsContent<BufferedImage, List<CharacteristicsInfo>> graphicsContent) {
        content = graphicsContent;
    }

}
