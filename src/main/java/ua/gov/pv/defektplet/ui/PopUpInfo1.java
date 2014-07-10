/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Евген
 */

public  class PopUpInfo1 extends JPanel {


    public PopUpInfo1(final String info, int x_pos, int y_pos) {

        final JTextArea textArea = new JTextArea(info);
        add(textArea);
        setBackground(Color.WHITE);
        textArea.setVisible(false);
        setBounds(x_pos, y_pos, 20, 20);
        setOpaque(false);
        setVisible(true);
        final Rectangle bounds = getBounds();

        MouseInputAdapter mouseHandler = new MouseInputAdapter() {

            @Override
            public void mouseEntered(final MouseEvent e) {
                Rectangle bound = getBounds();
                bound.width = textArea.getPreferredSize().width;
                bound.height = textArea.getPreferredSize().height;
                setBounds(bound);
                textArea.setOpaque(true);
                textArea.setVisible(true);
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                textArea.setOpaque(false);
                textArea.setVisible(false);
                setOpaque(false);
                setBounds(bounds);
            }
        };
        addMouseListener(mouseHandler);
    }
}
