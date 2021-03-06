/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sean
 */
public class PotentiallyInsecurePanel extends javax.swing.JPanel {

    /**
     * Creates new form PotentiallyInsecurePanel
     */
    public PotentiallyInsecurePanel() {
        initComponents();
    }
    
    public void populateTable() {
        ResultSet rs = ThesisDatabase.getPotentiallyInsecureApps();
        potentiallyInsecureTable.setModel(DbUtils.resultSetToTableModel(rs));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        potentiallyInsecureTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        add(backButton, gridBagConstraints);

        potentiallyInsecureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "App ID", "App Name", "Genre", "OS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        potentiallyInsecureTable.setMaximumSize(new java.awt.Dimension(1000, 64));
        potentiallyInsecureTable.setPreferredSize(new java.awt.Dimension(200, 64));
        jScrollPane1.setViewportView(potentiallyInsecureTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(22, 22, 22, 22);
        add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Apps using potentially insecure permissions or packages:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ThesisDatabase.window.selectPanel(2);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable potentiallyInsecureTable;
    // End of variables declaration//GEN-END:variables
}
