/*
 * Caches railway objects
 */
package ua.gov.pv.defektplet.drawing;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import ua.gov.pv.defektplet.util.GraphicsContent;

/**
 * 
 * @author Евген
 */
public class CacheRailway extends HashMap<Integer, GraphicsContent> {
    /**
     * maximum size of cache
     */
    private final int MAX_SIZE;
    /**
     * min and max indexes of RailwayItem
     */
    private final int minIndex, maxIndex;
    /**
     * Constructs empty CacheRailway with specified max size, min, max index 
     * of RailwayItem
     * @param MAX_SIZE
     * @param minIndex
     * @param maxIndex 
     */
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
