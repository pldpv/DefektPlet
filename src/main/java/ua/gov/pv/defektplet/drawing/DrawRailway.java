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
import javax.swing.JCheckBox;
import ua.gov.pv.defektplet.entity.Direction;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;
import ua.gov.pv.defektplet.util.DrawDefectList;
import ua.gov.pv.defektplet.util.DrawDeviationList;
import ua.gov.pv.defektplet.util.DrawGovernedVelocityList;
import ua.gov.pv.defektplet.util.DrawRailsStringList;
import ua.gov.pv.defektplet.util.DrawRankList;
import ua.gov.pv.defektplet.util.DrawTemporaryRecoveryList;
import ua.gov.pv.defektplet.util.DrawableList;

/**
 *
 * @author ?????
 */
public class DrawRailway {

    private BufferedImage bImage;
    private Integer numberOfItems = 10;
    private Integer scale;
    private Integer cacheSize = 3 * numberOfItems;
    private Integer leftCache,rightCache;
    private Integer imageWidth = 1000;
    private int minIndex, maxIndex, currentIndex;

    private IntervalInformation ii;
    private static GraphicsCharacteristics gc;

    public LinkedList<RailwayItem> rItemLeftList = new LinkedList<RailwayItem>();
    private LinkedList<RailwayItem> rItemRightList = new LinkedList<RailwayItem>();
    JCheckBox[] cb;
    int listIndex;

    private final Direction direction;

    public DrawRailway(IntervalInformation ii, Integer scale,
            JCheckBox[] cb) {
        this.cb = cb;
        this.ii = ii;
        this.scale = scale / numberOfItems;
        this.direction = new DefectStringsDataSource().
                getDirectionByNameLine(ii.direction, ii.line);
        minIndex = -(ii.kmS * 1000 + ii.mS - getDirectionStart(direction)+1)
                / this.scale;
        maxIndex = (getDirectionEnd(direction) - (ii.kmS * 1000 - ii.mS)+1)
                / this.scale;
        currentIndex = 0;
        gc = new GraphicsCharacteristics(imageWidth / numberOfItems, 0,
                10, this.scale);

        cacheRItem();

    }

    private void cacheRItem() {
        leftCache = (-cacheSize > minIndex) ? -cacheSize : Math.abs(minIndex);
        listIndex = Math.abs(leftCache);
        rightCache = (cacheSize + numberOfItems < maxIndex) ? cacheSize : maxIndex;
        for (int i = -leftCache; i < rightCache + numberOfItems; i++) {
            rItemLeftList.add(createRItemByIndex(i, "Ліва"));
            rItemRightList.add(createRItemByIndex(i, "Права"));
        }
        System.out.println(minIndex);
    }

    public ListIterator iterator() {
        return new ListIterator() {

            @Override
            public boolean hasNext() {
                return currentIndex < maxIndex;
            }

            @Override
            public Object next() {
                ++currentIndex;
                rItemRightList.removeFirst();
                rItemLeftList.removeFirst();
                if (currentIndex + numberOfItems + rightCache <= maxIndex) {
                    rItemLeftList.addLast(createRItemByIndex(currentIndex + numberOfItems + cacheSize, "Ліва"));
                    rItemRightList.addLast(createRItemByIndex(currentIndex + numberOfItems + cacheSize, "Права"));
                } else {
                    ++listIndex;
                    --rightCache;
                }
                if (currentIndex-leftCache>minIndex&&leftCache<cacheSize){
                    leftCache++;
                    ++listIndex;
                }
                draw();
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > minIndex;
            }

            @Override
            public Object previous() {
                --currentIndex;
                int index = (Math.abs(minIndex - currentIndex) > (cacheSize - numberOfItems) / 2)
                        ? (cacheSize - numberOfItems) / 2 : Math.abs(minIndex - currentIndex);
                rItemRightList.removeLast();
                rItemLeftList.removeLast();
           
                if (currentIndex -  leftCache > minIndex) {
                    rItemLeftList.addFirst(createRItemByIndex(currentIndex  - cacheSize, "Ліва"));
                    rItemRightList.addFirst(createRItemByIndex(currentIndex  - cacheSize, "Права"));
                }else{
                  listIndex--;  
                  leftCache--;
                }
                if (currentIndex+numberOfItems+rightCache<=maxIndex&&rightCache<cacheSize){
                    rightCache++;
                }
                draw();
                System.out.println(listIndex);
                System.out.println(currentIndex);
                System.out.println(minIndex);
                System.out.println(leftCache);
                System.out.println();
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

    public void draw() {
        int imgHeight = rItemLeftList.get(listIndex).getImage().getHeight() + rItemRightList.get(listIndex).getImage().getHeight();
        bImage = new BufferedImage(imageWidth, imgHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bImage.getGraphics();
        for (int i = 0; i < numberOfItems; i++) {
            g.drawImage(rItemRightList.get(listIndex + i).getImage(),
                    imageWidth / numberOfItems * i, 0, null);
            g.drawImage(rItemLeftList.get(listIndex + i).getImage(),
                    imageWidth / numberOfItems * i, rItemRightList.get(listIndex).getImage().getHeight(), null);

        }
        g.dispose();
    }

    public BufferedImage getImage() {
        return bImage;
    }

    private RailwayItem createRItemByIndex(int index, String railThread) {
        return new RailwayItem(createDrawableList(
                createIntervalByIndex(index, railThread)));
    }

    private List<DrawableList> createDrawableList(IntervalInformation ii) {

        List<DrawableList> result = new ArrayList<DrawableList>();
        if (ii.railThread.equals("Права")) {
            result.add(new DrawRankList(ii, gc));
            result.add(new DrawGovernedVelocityList(ii, gc));
            if (cb[2].isSelected()) {
                result.add(new DrawDeviationList(ii, gc, "Р"));
            }
            if (cb[3].isSelected()) {
                result.add(new DrawDeviationList(ii, gc, "П"));
            }
            if (cb[4].isSelected()) {
                result.add(new DrawDeviationList(ii, gc, "Пр.л"));
                result.add(new DrawDeviationList(ii, gc, "Пр.п"));
            }
            if (cb[5].isSelected()) {
                result.add(new DrawDeviationList(ii, gc, "У"));
            }
            if (cb[6].isSelected()) {
                result.add(new DrawDeviationList(ii, gc, "Суж"));
            }
        }
        result.add(new DrawRailsStringList(ii, gc));
        if (cb[0].isSelected()) {
            result.add(new DrawDefectList(ii, gc));
        }
        if (cb[1].isSelected()) {
            result.add(new DrawTemporaryRecoveryList(ii, gc));
        }

        return result;
    }

    private IntervalInformation createIntervalByIndex(int index, String railThread) {

        int kmS = (ii.kmS * 1000 + ii.mS + index * scale + 1) / 1000;
        int mS = Math.abs(ii.kmS * 1000 + ii.mS + index * scale) % 1000;
        int kmE = (kmS * 1000 + mS + scale) / 1000;
        int mE = (mS + scale) % 1000;
        return new IntervalInformation(ii.direction, kmS, mS, kmE, mE, ii.line, railThread);
    }

    private int getDirectionStart(Direction d) {
        return d.getKmS() * 1000 + d.getmS();
    }

    private int getDirectionEnd(Direction d) {
        return d.getKmE() * 1000 + d.getmE();
    }

    public static void main(String... args) {
        IntervalInformation i;
        i = new IntervalInformation("Дарниця - Полтава", 100, 0, 101, 1000, 1, "Ліва");
        GraphicsCharacteristics gch = new GraphicsCharacteristics(1000, 0, 10, 1000);
        DrawRailway dd = new DrawRailway(i, 10000, new JCheckBox[10]);
        ListIterator it = dd.iterator();
        while (it.hasNext()) {
            it.next();
        }
        dd.cacheRItem();
        System.exit(0);
    }

}
