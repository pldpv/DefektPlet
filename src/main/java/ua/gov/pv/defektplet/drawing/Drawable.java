package ua.gov.pv.defektplet.drawing;

import java.awt.Graphics;
import ua.gov.pv.defektplet.helper.DrawableInfo;


/**
 * Drawable is the public interface for drawing on a graphics context with 
 * information about drawable object.
 * 
 * @author Tkachuk Evgen
 * @see DrawableInfo
 * 
 */
public interface Drawable {
    
    /**
     * Draw on different graphics context.
     */
    public void draw(Graphics g);
    /**
     * 
     * @return information about drawable object.
     */
    public DrawableInfo getInfo();
}
