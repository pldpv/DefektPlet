/*
 * An Object which contains list of information about drawable and painted
 * image of this drawable.
 */
package ua.gov.pv.defektplet.util;

import java.awt.image.BufferedImage;
import java.util.List;
import ua.gov.pv.defektplet.helper.DrawableInfo;

/**
 *
 * @author Tkachuk Evgen
 * @see DrawableInfo
 *
 */
public class GraphicsContent {
    
    private List<? extends DrawableInfo> drawableInfo;
    private BufferedImage bImage;
    
    /**
     * @return List of information about drawable object(s)
     * @see DrawableInfo
     */
    public List<? extends DrawableInfo> getList() {
        return drawableInfo;
    }
    /**
     * @return painted image of drawable object(s)
     */
    public BufferedImage getbImage() {
        return bImage;
    }
    /**
     * Constructs a new GraphicsContent with the specified BufferedImage 
     * and DrawableInfo
     * @param bImage  BufferedImage
     * @param drawableInfo drawable information
     */
    public GraphicsContent(BufferedImage bImage, List<? extends DrawableInfo> drawableInfo) {
        this.drawableInfo = drawableInfo;
        this.bImage = bImage;
    }
}
