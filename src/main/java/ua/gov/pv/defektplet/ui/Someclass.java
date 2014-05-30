/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.pv.defektplet.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author ПГМ
 */
public class Someclass {

    private JMenuBar jMenuBar;
    private TabPaneClosable tabPane;
    static ResourceBundle labels = ResourceBundle.getBundle("DefectStrings", new Locale("ua"));
    static Dimension screenSize = 
                    Toolkit.getDefaultToolkit().getScreenSize();
    public Someclass() {
        initComponents();
        BasicConfigurator.configure();
    }

    private void initComponents() {
        final JFrame f = new JFrame();
        f.setSize(screenSize.width, screenSize.height);
        f.setJMenuBar(new DefectMenuBar(f));
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        tabPane = new TabPaneClosable();
        tabPane.add(new MainPanel(tabPane), labels.getString("mainForm"));
        f.setContentPane(tabPane);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DefectStrings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefectStrings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefectStrings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefectStrings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Someclass s = new Someclass();
            }
        });
    }

}
