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
   public final Integer idDirection, kmS, mS, kmE, mE, line;

    public IntervalInformation(Integer idDirection, Integer kmS, Integer mS, Integer kmE, Integer mE, Integer line) {
        this.idDirection = idDirection;
        this.kmS = kmS;
        this.mS = mS;
        this.kmE = kmE;
        this.mE = mE;
        this.line = line;
    }

    
}
