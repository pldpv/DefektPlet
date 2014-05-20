/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.drawing;

import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Tkachuk Evgen
 */
public class GraphicsCharacteristics {

    public GraphicsCharacteristics(Integer IMG_WIDTH, Integer LEGEND_WIDTH, Integer HEIGHT, Integer SCALE) {
        this.IMG_WIDTH = IMG_WIDTH;
        this.LEGEND_WIDTH = LEGEND_WIDTH;
        this.HEIGHT = HEIGHT;
        this.SCALE = SCALE;
        this.font = new Font("Arial", Font.PLAIN, HEIGHT - 1);
    }
    final Integer IMG_WIDTH;
    final Integer LEGEND_WIDTH;
    final Integer HEIGHT;
    final Integer SCALE;
    Font font;
}
