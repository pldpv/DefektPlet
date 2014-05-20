/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ?????
 */
public class DrawRailway {

    private List<RailwayItem> railItem = new ArrayList<RailwayItem>();
    private final IntervalInformation ii;
    private final Integer length;
    private static GraphicsCharacteristics gc;
    private List<BufferedImage> bImage = new ArrayList<BufferedImage>();

    public DrawRailway(GraphicsCharacteristics gc, IntervalInformation ii) {
        this.ii = ii;
        this.gc = gc;
        length = (ii.kmE - ii.kmS) * 1000 + (ii.mE - ii.mS);
    }

    private void createRailwayItems() {
        for (int i = 0; i < length; i += gc.SCALE) {
            int kmS = (ii.kmS * 1000 + ii.mS + i) / 1000;
            int mS = (ii.mS + i >= 1000) ? (ii.mS + i) % 1000 : ii.mS + i;
            int kmE = (kmS * 1000 + mS + gc.SCALE) / 1000;
            int mE = (i + gc.SCALE > length) ? ii.mE : (mS + gc.SCALE) % 1000;
            railItem.add(new RailwayItem(gc, new IntervalInformation(ii.direction, kmS, mS, kmE, mE, ii.line, ii.railThread)));
        }
    }
    public void setDrawable(){
        for(RailwayItem ri:railItem){
            ri.temporaryRecovery.setDrawable(false);
        }
    }
    public List<RailwayItem> getList() {
        createRailwayItems();
        return railItem;
    }
    public void draw(){
        for (RailwayItem item : getList()) {
            item.draw();
            bImage.add(item.getImage());
        }
    }
    public static void main(String... args) {
        IntervalInformation ii = new IntervalInformation("Дарниця - Полтава", 137, 0, 141, 1000, 1, "Ліва");
        GraphicsCharacteristics gch = new GraphicsCharacteristics(1000, 50, 10, 2000);
        DrawRailway dd = new DrawRailway(gch, ii);
        for (RailwayItem item : dd.getList()) {
            item.saveImg();
        }
        System.exit(0);
    }

    public List<BufferedImage> getbImage() {
        return bImage;
    }
}
