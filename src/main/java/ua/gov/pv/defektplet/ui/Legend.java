/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ПГМ
 */
public class Legend extends JPanel {

    JCheckBox[] cb;

    public Legend(JCheckBox[] cb) {
        this.cb = cb;
    }

    private void init() {
        JLabel rank = new JLabel("км/пк");
        add(rank);
        JLabel velocity = new JLabel("уст. скорость");
        add(velocity);
        if (cb[2].isSelected()) {
            JLabel realing = new JLabel("Р");
            add(realing);
        }
        if (cb[2].isSelected()) {
            JLabel realing = new JLabel("Р");
            add(realing);
        }
    }
}
