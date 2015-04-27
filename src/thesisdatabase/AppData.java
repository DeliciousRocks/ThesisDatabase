/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author waltersquires
 */
public class AppData extends javax.swing.JPanel {

    /**
     * Creates new form androidResults
     */
    public AppData() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        permissionScrollPane = new javax.swing.JScrollPane();
        permissionTable = new javax.swing.JTable();
        appScrollPane = new javax.swing.JScrollPane();
        appTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        frameworkScrollPane = new javax.swing.JScrollPane();
        frameworkTable = new javax.swing.JTable();
        usedRadioButton = new javax.swing.JRadioButton();
        unusedRadioButton = new javax.swing.JRadioButton();
        updateButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        permissionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Permission Name", "Required", "Requested", "Dynamically Used"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn col = permissionTable.getColumnModel().getColumn(0);
        col.setPreferredWidth(200);
        col = permissionTable.getColumnModel().getColumn(1);
        col.setPreferredWidth(25);
        col = permissionTable.getColumnModel().getColumn(2);
        col.setPreferredWidth(25);
        permissionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                permissionTableMouseClicked(evt);
            }
        });
        permissionScrollPane.setViewportView(permissionTable);

        add(permissionScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 470, 160));

        appTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "App Name", "App Developer", "Uploaded By", "Date Uploaded", "Genre", "OS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appScrollPane.setViewportView(appTable);

        add(appScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 580, 60));

        jLabel1.setText("Application Data");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        frameworkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Framework Name", "Used Dynamically"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        frameworkTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frameworkTableMouseClicked(evt);
            }
        });
        frameworkScrollPane.setViewportView(frameworkTable);

        add(frameworkScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 470, 160));

        buttonGroup1.add(usedRadioButton);
        usedRadioButton.setText("Used Dynamically");
        usedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedRadioButtonActionPerformed(evt);
            }
        });
        add(usedRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        buttonGroup1.add(unusedRadioButton);
        unusedRadioButton.setText("Not Used Dynamically");
        add(unusedRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    public void loadApp(int id, ResultSet appRs) throws SQLException {
        appId = id;
        appTable.setModel(DbUtils.resultSetToTableModel(appRs));
        appName = (String)appTable.getValueAt(0, 0);
        os = (String)appTable.getValueAt(0, 5);
        loadPermissionsOrFrameworks();
    }

    private void loadPermissionsOrFrameworks() throws SQLException {
        boolean isAndroidApp = os.equals("Android");
        if (isAndroidApp) {
            ResultSet permissions = ThesisDatabase.getPermissions(appId);
            permissionTable.setModel(DbUtils.resultSetToTableModel(permissions));
        } else {
            ResultSet frameworks = ThesisDatabase.getFrameworks(appId);
            frameworkTable.setModel(DbUtils.resultSetToTableModel(frameworks));
        }

        permissionScrollPane.setVisible(isAndroidApp);
        frameworkScrollPane.setVisible(!isAndroidApp);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ThesisDatabase.window.selectPanel(2);
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void usedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usedRadioButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        boolean isUsedDynamically = usedRadioButton.isSelected();
        ThesisDatabase.updateDynamicallyUsed(isUsedDynamically, selectedItem, appName, os);
        try {
            loadPermissionsOrFrameworks();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void permissionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permissionTableMouseClicked
        int row = permissionTable.getSelectedRow();
        selectedItem = (String)permissionTable.getValueAt(row, 0);
    }//GEN-LAST:event_permissionTableMouseClicked

    private void frameworkTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameworkTableMouseClicked
        int row = frameworkTable.getSelectedRow();
        selectedItem = (String)frameworkTable.getValueAt(row, 0);
    }//GEN-LAST:event_frameworkTableMouseClicked

    private String selectedItem;
    private String appName;
    private String os;
    private int appId;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane appScrollPane;
    public javax.swing.JTable appTable;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane frameworkScrollPane;
    public javax.swing.JTable frameworkTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane permissionScrollPane;
    public javax.swing.JTable permissionTable;
    private javax.swing.JRadioButton unusedRadioButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JRadioButton usedRadioButton;
    // End of variables declaration//GEN-END:variables
}
