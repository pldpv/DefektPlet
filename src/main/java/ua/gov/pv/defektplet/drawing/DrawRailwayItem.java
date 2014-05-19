/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.drawing;

import java.util.ArrayList;
import java.util.List;
import ua.gov.pv.defektplet.helper.IntervalInformation;
import ua.gov.pv.defektplet.helper.RailwayItem;



/**
 *
 * @author ?????
 */
public class DrawRailwayItem {
    private List<RailwayItem> railItem=new ArrayList<RailwayItem>();
    IntervalInformation ii;
    private final Integer scale,length;
    
    public DrawRailwayItem(Integer scale,IntervalInformation ii) {
        this.ii=ii;
        this.scale=scale;
        length=(ii.kmE-ii.kmS)*1000+(ii.mE-ii.mS);
        
    }
    
    private void getRailwayItems(){
        for (int i=0;i<length;i+=scale){
            int kmS=(ii.kmS*1000+ii.mS+i)/1000;
            int mS=(ii.mS+i>=1000)?(ii.mS+i)%1000:ii.mS+i;
            int kmE=(kmS*1000+mS+scale)/1000;
            int mE=(i+scale>length)?ii.mE:(mS+scale)%1000;
            railItem.add(new RailwayItem(scale, 
                    new IntervalInformation(ii.direction, kmS, mS, kmE, mE, ii.line,ii.railThread)));
        }
    }
    public List<RailwayItem> getList(){
        getRailwayItems();
        return railItem;
    }
    public static void main(String ... args){
        IntervalInformation ii =new IntervalInformation("Дарниця - Полтава", 137,0 , 141, 1000, 1,"Ліва");
        DrawRailwayItem dd=new DrawRailwayItem(500, ii);
        for (RailwayItem item:dd.getList()){
            item.saveImg();
        }
        System.exit(0);
    }
}
