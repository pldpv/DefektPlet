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
import ua.gov.pv.defektplet.util.DrawDefectList;
import ua.gov.pv.defektplet.util.DrawableList;

/**
 *
 * @author ?????
 */
public class DrawRailway {

    ;
    private final Integer length;
    
    private List<BufferedImage> bImage = new ArrayList<BufferedImage>();
    
    private Integer numberOfItems=10;
    private Integer scale;
    private Integer screenWidth;
    private IntervalInformation [] ii= new IntervalInformation[1];
    private List<DrawableList> list= new ArrayList<DrawableList>();
    private static GraphicsCharacteristics gc;
    private List<RailwayItem> rItemList= new ArrayList<RailwayItem>();
    
    public DrawRailway(IntervalInformation [] ii,List<DrawableList> list) {
        this.ii = ii;
        this.list=list;
        length = (ii[0].kmE - ii[0].kmS) * 1000 + (ii[0].mE - ii[0].mS);
        gc=new GraphicsCharacteristics(screenWidth/numberOfItems, 0, 10, scale/numberOfItems);
    }

    private void createRailwayItems() {
        for (int i = 0; i < length; i += gc.SCALE) {
            int kmS = (ii[0].kmS * 1000 + ii[0].mS + i) / 1000;
            int mS = (ii[0].mS + i >= 1000) ? (ii[0].mS + i) % 1000 : ii[0].mS + i;
            int kmE = (kmS * 1000 + mS + gc.SCALE) / 1000;
            int mE = (i + gc.SCALE > length) ? ii[0].mE : (mS + gc.SCALE) % 1000;
            railItemList.add(new RailwayItem(gc, new IntervalInformation());
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
