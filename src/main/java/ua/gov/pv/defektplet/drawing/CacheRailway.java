/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import ua.gov.pv.defektplet.helper.CharacteristicsInfo;
import ua.gov.pv.defektplet.util.GraphicsContent;

/**
 *
 * @author Евген
 */
public class CacheRailway extends HashMap<Integer, GraphicsContent<BufferedImage,List<? extends CharacteristicsInfo>>> {

    private final int MAX_SIZE;
    private final int minIndex, maxIndex;

    public CacheRailway(int MAX_SIZE, int minIndex, int maxIndex) {
        this.MAX_SIZE = MAX_SIZE;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    public boolean isCacheble(Integer index) {
        return size() < MAX_SIZE && index >= minIndex && index <= maxIndex;
    }
    public int maxKey(){
        return (int) Collections.max((Collection) keySet());
    }
    public int minKey(){
        return (int) Collections.min((Collection) keySet());
    }
}
