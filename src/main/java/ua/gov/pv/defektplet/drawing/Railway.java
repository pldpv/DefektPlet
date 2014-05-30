/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.drawing;

import java.util.ArrayList;
import java.util.List;
import ua.gov.pv.defektplet.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class Railway {
    List<List<DrawRailwayItem>> railwayList= new ArrayList<List<DrawRailwayItem>>();
    private IntervalInformation ii;
    private int minIndex, maxIndex, currentIndex;
}
