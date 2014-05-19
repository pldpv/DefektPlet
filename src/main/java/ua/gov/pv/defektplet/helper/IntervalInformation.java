/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.helper;

/**
 *
 * @author �����
 */
public class IntervalInformation {
   public final Integer kmS, mS, kmE, mE, line;
   public final String direction,railThread;

    public IntervalInformation(String direction, Integer kmS, Integer mS, Integer kmE, Integer mE, Integer line,String railThread) {
        this.direction = direction;
        this.kmS = kmS;
        this.mS = mS;
        this.kmE = kmE;
        this.mE = mE;
        this.line = line;
        this.railThread=railThread;
    }

    
}
