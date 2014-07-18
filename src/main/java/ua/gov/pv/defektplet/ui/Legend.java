/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 1
 */
public class Legend extends JPanel {

    public Legend(List<String> legendList, int height) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        for (String s : legendList) {
            JLabel l = new JLabel(s);
            c.anchor=GridBagConstraints.CENTER;
            c.gridwidth = 1;
            c.ipady=height/2+2;
            //c.insets = new Insets(+1, 0, 0, 0);
            l.setFont(l.getFont().deriveFont(Font.BOLD));
            c.weighty = 0.0;
            //c.fill = GridBagConstraints.HORIZONTAL & GridBagConstraints.VERTICAL;
            add(l, c);
            c.gridy++;
        }
    }
    
}
