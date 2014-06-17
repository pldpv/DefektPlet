/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.pv.defektplet.util;

/**
 *
 * @author Евген

 */
public class GraphicsContent<I,L> {
        private L list;
        private I bImage;

    public L getList() {
        return list;
    }

    public I getbImage() {
        return bImage;
    }

    public GraphicsContent(I bImage,L list) {
        this.list = list;
        this.bImage = bImage;
    }
}
