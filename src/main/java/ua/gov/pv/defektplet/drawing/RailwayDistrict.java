/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.JCheckBox;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class RailwayDistrict {

    private JCheckBox[] cb;
    private IntervalInformation ii;
    private List<RailwayItem> railwayDistrict = new LinkedList<RailwayItem>();
    private int minIndex, maxIndex, currentIndex;
    private int screenWidth;
    private int numberOfItems;
    private int scale;

    public RailwayDistrict(IntervalInformation ii, Integer screenWidth, JCheckBox[] cb) {
        numberOfItems = (screenWidth - screenWidth % 100 - 100) / 100;
        this.ii = ii;
        this.cb = cb;
        currentIndex = 0;

    }

}

