/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Евген
 */
public class PopUpInfo extends JLabel {

    private Font font1;
    private Font font2;
    private final FontRenderContext fontRenderContext1;
    private final FontRenderContext fontRenderContext2;

    public PopUpInfo(final String letter) {
        super(letter);
        final JPanel panel = new JPanel();
        setFocusable(true);
        setBackground(Color.RED);
        font1 = getFont();
        font2 = font1.deriveFont(48f);
        fontRenderContext1 = getFontMetrics(font1).getFontRenderContext();
        fontRenderContext2 = getFontMetrics(font2).getFontRenderContext();
        setVisible(false);

        MouseInputAdapter mouseHandler = new MouseInputAdapter() {

            @Override
            public void mouseEntered(final MouseEvent e) {
                setVisible(true);
                PopUpInfo.this.setOpaque(false);
                setFont(font2);
                Rectangle bounds = getBounds();
                Rectangle2D stringBounds = font2.getStringBounds(getText(), fontRenderContext2);
                bounds.width = (int) stringBounds.getWidth();
                bounds.height = (int) stringBounds.getHeight();
                setBounds(bounds);
                panel.repaint();
                panel.revalidate();
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                setVisible(false);
                PopUpInfo.this.setOpaque(false);
                setFont(font1);
                Rectangle bounds = getBounds();
                Rectangle2D stringBounds = font1.getStringBounds(getText(), fontRenderContext1);
                bounds.width = (int) stringBounds.getWidth();
                bounds.height = (int) stringBounds.getHeight();
                setBounds(bounds);
                panel.repaint();
                panel.revalidate();
            }
        };
        addMouseListener(mouseHandler);
    }
}

class Panel extends JPanel {

    private Font font1;
    private Font font2;
    private final FontRenderContext fontRenderContext1;
    private final FontRenderContext fontRenderContext2;

    public Panel(final String info) {
        final JLabel label = new JLabel(info);
        label.setFocusable(true);
        label.setBackground(Color.RED);
        font1 = getFont();
        font2 = font1.deriveFont(48f);
        fontRenderContext1 = getFontMetrics(font1).getFontRenderContext();
        fontRenderContext2 = getFontMetrics(font2).getFontRenderContext();
        add(label);
        label.setVisible(false);
        setOpaque(true);
        setVisible(true);
        MouseInputAdapter mouseHandler = new MouseInputAdapter() {

            @Override
            public void mouseEntered(final MouseEvent e) {
                label.setVisible(true);
                label.setOpaque(true);
                label.setFont(font2);
                Rectangle bounds = getBounds();
                Rectangle2D stringBounds = font2.getStringBounds(label.getText(), fontRenderContext2);
                bounds.width = (int) stringBounds.getWidth();
                bounds.height = (int) stringBounds.getHeight();
                setBounds(bounds);
                repaint();
                revalidate();
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                label.setVisible(false);
                label.setOpaque(false);
                label.setFont(font1);
                Rectangle bounds = getBounds();
                Rectangle2D stringBounds = font1.getStringBounds(label.getText(), fontRenderContext1);
                bounds.width = (int) stringBounds.getWidth();
                bounds.height = (int) stringBounds.getHeight();
                setBounds(bounds);
                repaint();
                revalidate();
            }
        };
        addMouseListener(mouseHandler);
    }
}
