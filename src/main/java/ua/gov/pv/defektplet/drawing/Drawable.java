package ua.gov.pv.defektplet.drawing;

import java.awt.Graphics;
import ua.gov.pv.defektplet.helper.CharacteristicsInfo;


/**
 *
 * @author ���
 */
public interface Drawable {
    public void draw(Graphics g);
    public CharacteristicsInfo getInfo();
}
