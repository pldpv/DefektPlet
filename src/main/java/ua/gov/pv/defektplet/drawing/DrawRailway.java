/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import ua.gov.pv.defektplet.entity.Direction;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;
import ua.gov.pv.defektplet.util.DrawDefectList;
import ua.gov.pv.defektplet.util.DrawRailsStringList;
import ua.gov.pv.defektplet.util.DrawableList;

/**
 *
 * @author ?????
 */
public class DrawRailway {

    private BufferedImage bImage;
    private Integer numberOfItems = 10;
    private Integer scale=1000;
    private Integer cacheSize = 7 * numberOfItems;
    private Integer imageWidth=1000;
    private int minIndex, maxIndex, currentIndex;

    private IntervalInformation[] ii = new IntervalInformation[1];
    private List<DrawableList> list = new ArrayList<DrawableList>();
    private static GraphicsCharacteristics gc;

    private LinkedList<RailwayItem> rItemLeftList = new LinkedList<RailwayItem>();
    private LinkedList<RailwayItem> rItemRightList = new LinkedList<RailwayItem>();

    private final Direction direction;

    public DrawRailway(IntervalInformation[] ii, List<DrawableList> list) {
        this.ii = ii;
        direction = new DefectStringsDataSource().
                getDirectionByNameLine(ii[0].direction, ii[0].line);
        this.list = list;
//        minIndex = -((ii[0].kmS - direction.getKmS())
//                * 1000 + ii[0].mS - direction.getmS()) / scale / numberOfItems + 1;
//        maxIndex = ((direction.getKmE() - ii[0].kmE)
//                * 1000 + direction.getmE() - ii[0].mE) / scale / numberOfItems + 1;
        currentIndex = 0;
        gc = new GraphicsCharacteristics(imageWidth / numberOfItems, 0,
                10, scale / numberOfItems);

    }

//    private void createRailwayItems() {
//        for (int i = 0; i < length; i += gc.SCALE) {
//            int kmS = (ii[0].kmS * 1000 + ii[0].mS + i) / 1000;
//            int mS = (ii[0].mS + i >= 1000) ? (ii[0].mS + i) % 1000 : ii[0].mS + i;
//            int kmE = (kmS * 1000 + mS + gc.SCALE) / 1000;
//            int mE = (i + gc.SCALE > length) ? ii[0].mE : (mS + gc.SCALE) % 1000;
//        }
//    }

    public ListIterator iterator() {
        return new ListIterator() {

            @Override
            public boolean hasNext() {
                return currentIndex < maxIndex;
            }

            @Override
            public Object next() {
                ++currentIndex;
                int index = (Math.abs(minIndex - currentIndex) > (cacheSize - numberOfItems) / 2)
                        ? (cacheSize - numberOfItems) / 2 : Math.abs(minIndex - currentIndex);
                draw(index);
                rItemRightList.removeFirst();
                rItemLeftList.removeFirst();
                rItemRightList.addLast(null);
                rItemLeftList.addLast(null);
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > minIndex;
            }

            @Override
            public Object previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return currentIndex + 1;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(Object e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(Object e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    public void draw(int currentIndex) {
        bImage = new BufferedImage(imageWidth, 2 * rItemLeftList.get(currentIndex).getImage().getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bImage.getGraphics();
        for (int i = 0; i < 10; i++) {
            g.drawImage(rItemLeftList.get(currentIndex + i).getImage(),
                    imageWidth / numberOfItems * i, 0, null);
            g.drawImage(rItemRightList.get(currentIndex + i).getImage(),
                    imageWidth / numberOfItems * i, bImage.getHeight(), null);
        }
        g.dispose();
    }

    public BufferedImage getImage() {
        return bImage;
    }

    private int getDirectionStart(Direction d) {
        return d.getKmS() * 1000 + d.getmS();
    }

    private int getDirectionEnd(Direction d) {
        return d.getKmE() * 1000 + d.getmE();
    }

    public static void main(String... args) {
        IntervalInformation [] i =new IntervalInformation[2];
        i[0] = new IntervalInformation("Дарниця - Полтава", 137, 0, 141, 1000, 1, "Ліва");
        i[1] = new IntervalInformation("Дарниця - Полтава", 137, 0, 141, 1000, 1, "Ліва");
        GraphicsCharacteristics gch = new GraphicsCharacteristics(1000, 50, 10, 2000);
        List<DrawableList> list = new ArrayList<DrawableList>();
        list.add(new DrawDefectList());
        list.add(new DrawRailsStringList());
        DrawRailway dd = new DrawRailway(i,list);
        for (DrawableList drawList:list){
            System.out.println(drawList.getClass().);
        }
        System.exit(0);
    }
    private void createDrawableList(List<DrawableList> list){
        for (DrawableList drawList:list){
            
        }
    }
}
