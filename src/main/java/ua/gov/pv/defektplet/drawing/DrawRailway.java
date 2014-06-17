/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JCheckBox;
import ua.gov.pv.defektplet.entity.Direction;
import ua.gov.pv.defektplet.helper.CharacteristicsInfo;
import ua.gov.pv.defektplet.helper.DefectStringsDataSource;
import ua.gov.pv.defektplet.helper.IntervalInformation;
import ua.gov.pv.defektplet.util.GraphicsContent;

/**
 *
 * @author ?????
 */
public class DrawRailway {

    private BufferedImage bImage;
    private final Integer numberOfItems = 10;
    private final Integer scale;
    private final Integer CACHE_SIZE = 50;
    private final Integer imageWidth = 1000;
    private int minIndex, maxIndex, currentIndex;
    private final CacheRailway cacheRailway;
    private final IntervalInformation ii;
    private static GraphicsCharacteristics gc;

    JCheckBox[] cb;

    private final Direction direction;

    public DrawRailway(IntervalInformation ii, Integer scale,
            JCheckBox[] cb) {
        this.cb = cb;
        this.ii = ii;
        this.scale = scale / numberOfItems;
        this.direction = new DefectStringsDataSource(ii).
                getDirectionByNameLine();

        minIndex = -(ii.getKmS() * 1000 + ii.getmS() - getDirectionStart(direction) + 1)
                / this.scale;
        maxIndex = (getDirectionEnd(direction) - (ii.getKmS() * 1000 - ii.getmS()) + 1)
                / this.scale;
        currentIndex = 0;
        gc = new GraphicsCharacteristics(imageWidth / numberOfItems, 0,
                20, this.scale);
        cacheRailway = new CacheRailway(CACHE_SIZE, minIndex, maxIndex);
    }

    public void cacheRItem() {

        for (int i = -CACHE_SIZE / 2; i < CACHE_SIZE / 2; i++) {
            if (cacheRailway.isCacheble(i)) {
                DrawRailwayItem drawItem = createRItemByIndex(i);
                drawItem.draw();
                cacheRailway.put(i, new GraphicsContent(drawItem.getImage(),drawItem.getRItemInfoList()));
            }
        }
    }

    public ListIterator iterator() {
        return new ListIterator() {

            @Override
            public boolean hasNext() {
                return currentIndex < maxIndex;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    ++currentIndex;
                    int cacheIndex = cacheRailway.maxKey() + 1;
                    cacheRailway.remove(cacheRailway.minKey());
                    if (cacheRailway.isCacheble(cacheIndex)) {
                        DrawRailwayItem drawItem = createRItemByIndex(cacheIndex);
                        drawItem.draw();
                        cacheRailway.put(cacheIndex,
                                new GraphicsContent(drawItem.getImage(),drawItem.getRItemInfoList()));
                    }
                }
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > minIndex;
            }

            @Override
            public Object previous() {
                if (hasPrevious()) {
                    --currentIndex;
                    cacheRailway.remove(cacheRailway.maxKey());
                    int cacheIndex = cacheRailway.minKey() - 1;
                    if (cacheRailway.isCacheble(cacheIndex)) {
                        DrawRailwayItem drawItem = createRItemByIndex(cacheIndex);
                        drawItem.draw();
                        cacheRailway.put(cacheIndex, 
                                new GraphicsContent(drawItem.getImage(),drawItem.getRItemInfoList()));
                    }
                }
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
        int imgHeight = cacheRailway.get(currentIndex).getbImage().getHeight() + gc.HEIGHT;
        bImage = new BufferedImage(imageWidth, imgHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bImage.getGraphics();

        g.drawImage(drawRank(), 0, 0, null);
        for (int i = currentIndex, count = 0; i < currentIndex + numberOfItems; i++, count++) {
            if (cacheRailway.containsKey(i)) {
                g.drawImage(cacheRailway.get(i).getbImage(),
                        imageWidth / numberOfItems * count, gc.HEIGHT, null);
            }
        }

        g.dispose();
    }
    
    private List<CharacteristicsInfo> getInfo() {
        List<CharacteristicsInfo> infoList = new ArrayList<CharacteristicsInfo>();
        for (int i = currentIndex, count = 0; i < currentIndex + numberOfItems; i++, count++) {
            if (cacheRailway.containsKey(i)) {
                 for(CharacteristicsInfo info:cacheRailway.get(i).getList()){
                     infoList.add(info.setX(info.getX()+count*gc.IMG_WIDTH));
                 }
            }
        }
        return infoList;
    }
    public GraphicsContent<BufferedImage,List<CharacteristicsInfo>> getGraphicsContent(){
        draw();
        return new GraphicsContent(bImage,getInfo());
    }
    private BufferedImage drawRank() {
        int kmS = (ii.getKmS() * 1000 + ii.getmS() + currentIndex * scale) / 1000;
        int mS = Math.abs(ii.getKmS() * 1000 + ii.getmS() + currentIndex * scale) % 1000;
        int kmE = (kmS * 1000 + mS + scale * numberOfItems) / 1000;
        int mE = (mS + scale * numberOfItems) % 1000;
        IntervalInformation iInf = new IntervalInformation(ii.getDirection(), kmS, mS, kmE, mE, ii.getLine(), null);
        GraphicsCharacteristics gcR = new GraphicsCharacteristics(imageWidth, 0, gc.HEIGHT, gc.SCALE * numberOfItems);
        DrawRank dr = new DrawRank(iInf, gcR);
        BufferedImage bImageRank = new BufferedImage(imageWidth, gc.HEIGHT, BufferedImage.TYPE_INT_RGB);
        dr.draw(bImageRank.createGraphics());
        return bImageRank;
    }

    public BufferedImage getImage() {
        return bImage;
    }

    private DrawRailwayItem createRItemByIndex(int index) {
        return new DrawRailwayItem(new RailwayItem(cb, createIntervalByIndex(index), gc));
    }

    private IntervalInformation createIntervalByIndex(int index) {
        int kmS = (ii.getKmS() * 1000 + ii.getmS() + index * scale + 1) / 1000;
        int mS = Math.abs(ii.getKmS() * 1000 + ii.getmS() + index * scale) % 1000;
        int kmE = (kmS * 1000 + mS + scale) / 1000;
        int mE = (mS + scale) % 1000;
        return new IntervalInformation(ii.getDirection(), kmS, mS, kmE, mE, ii.getLine(), null);
    }

    private int getDirectionStart(Direction d) {
        return 1001;
        //return d.getKmS() * 1000 + d.getmS();
    }

    private int getDirectionEnd(Direction d) {
        return 338100;
//return d.getKmE() * 1000 + d.getmE();
    }

}
