 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.IModel;
import model.Szemely;

/**
 *
 * @author Pepe
 */
public class SzemelyDialog extends javax.swing.JDialog {

    private IModel model;
    private Frame owner;

    public SzemelyDialog(java.awt.Frame owner, IModel model) {
        super(owner, true);
        this.model = model;
        this.owner = owner;
        initComponents();
        setLocationRelativeTo(owner);
        updateLstSzemelyek();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstSzemelyek = new javax.swing.JList();
        BtnUj = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        BtnSzerkeszt = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstSzemelyek.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSzemelyek.setFocusable(false);
        lstSzemelyek.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(lstSzemelyek);

        BtnUj.setText("Új");
        BtnUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUjActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Töröl");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Ok");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        BtnSzerkeszt.setText("Szerkeszt");
        BtnSzerkeszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSzerkesztActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSzerkeszt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnUj, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnSzerkeszt, BtnUj, jToggleButton2, jToggleButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BtnUj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSzerkeszt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSzerkesztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSzerkesztActionPerformed
        Szemely selected = (Szemely) lstSzemelyek.getSelectedValue();
        if (selected != null) {
            SzemelyadatokDialog szad = new SzemelyadatokDialog(owner, selected);
            szad.setVisible(true);
            if (szad.isMentes()) {
                try {
                    model.updateSzemely(selected);
                    updateLstSzemelyek();
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Válasssz ki valakit", "Nincs kiválasztva személy", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_BtnSzerkesztActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        Szemely selected = (Szemely) lstSzemelyek.getSelectedValue();
        if (selected != null) {
            
            int valasz = JOptionPane.showInternalConfirmDialog(rootPane, "Biztos, hogy törölni akaja?", "Törlés megerősítése", JOptionPane.YES_NO_OPTION);
            if (valasz==JOptionPane.YES_OPTION) {
                try {
                    model.removeSzemely(selected);
                    updateLstSzemelyek();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }else {
          JOptionPane.showMessageDialog(rootPane, "Válasssz ki valakit", "Nincs kiválasztva személy", JOptionPane.ERROR_MESSAGE);  
        }
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void BtnUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUjActionPerformed
        SzemelyadatokDialog szad = new SzemelyadatokDialog(owner, null);
        szad.setVisible(true);
        if (szad.isMentes()) {
            try {
                model.addSzemely(szad.getSzemely());
                updateLstSzemelyek();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex, "Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnUjActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnSzerkeszt;
    private javax.swing.JToggleButton BtnUj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JList lstSzemelyek;
    // End of variables declaration//GEN-END:variables

    private void updateLstSzemelyek() {
        try {
            List<Szemely> szemelyek = model.getSzemelyek();
            lstSzemelyek.setListData(szemelyek.toArray());

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(rootPane, ex, "Db hiba", JOptionPane.ERROR_MESSAGE);
        }
    }
}
