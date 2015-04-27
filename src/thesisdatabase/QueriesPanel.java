/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author waltersquires
 */
public class QueriesPanel extends javax.swing.JPanel {

    /**
     * Creates new form queriesPanel
     */
    public QueriesPanel() {
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

        welcomeLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        addAppButton = new javax.swing.JButton();
        viewAppDataButton = new javax.swing.JButton();
        appId = new javax.swing.JTextField();
        appPrivilegeButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        viewPermissionsButton = new javax.swing.JButton();
        unknownPermissionsButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        userActivityButton = new javax.swing.JButton();
        potentiallyInsecureButton = new javax.swing.JButton();

        welcomeLabel.setText("Welcome,");

        userNameLabel.setText("<userName>");

        addAppButton.setText("Add New App");
        addAppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppButtonActionPerformed(evt);
            }
        });

        viewAppDataButton.setText("View App Data");
        viewAppDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppDataButtonActionPerformed(evt);
            }
        });

        appId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appIdActionPerformed(evt);
            }
        });

        appPrivilegeButton.setText("View App Privilege Statuses");
        appPrivilegeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appPrivilegeButtonActionPerformed(evt);
            }
        });

        addUserButton.setText("Add New User");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        viewPermissionsButton.setText("View Permissions");
        viewPermissionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPermissionsButtonActionPerformed(evt);
            }
        });

        unknownPermissionsButton.setText("Review Unknown Permissions");
        unknownPermissionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unknownPermissionsButtonActionPerformed(evt);
            }
        });

        editUserButton.setText("Edit User");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        userActivityButton.setText("Review User Activity");
        userActivityButton.setToolTipText("");
        userActivityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActivityButtonActionPerformed(evt);
            }
        });

        potentiallyInsecureButton.setText("View Potentially Insecure Apps");
        potentiallyInsecureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potentiallyInsecureButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(welcomeLabel)
                        .addGap(6, 6, 6)
                        .addComponent(userNameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addUserButton)
                            .addComponent(addAppButton)
                            .addComponent(userActivityButton)
                            .addComponent(editUserButton))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewAppDataButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(appId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(appPrivilegeButton)
                            .addComponent(viewPermissionsButton)
                            .addComponent(unknownPermissionsButton)
                            .addComponent(potentiallyInsecureButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel)
                    .addComponent(userNameLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAppButton)
                    .addComponent(appPrivilegeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserButton)
                    .addComponent(viewAppDataButton)
                    .addComponent(appId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewPermissionsButton)
                    .addComponent(editUserButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userActivityButton)
                    .addComponent(potentiallyInsecureButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(unknownPermissionsButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addAppButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppButtonActionPerformed
    ThesisDatabase.window.selectPanel(0);
    }//GEN-LAST:event_addAppButtonActionPerformed

    private void viewAppDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppDataButtonActionPerformed
     try
     {
       ResultSet app = ThesisDatabase.viewApp(Integer.parseInt(appId.getText()));
        while (app.next()) {
              
                  String name = ThesisDatabase.getUserName(Integer.parseInt(app.getString("addedby")));
            
                  AppData temp = ThesisDatabase.window.getAndroidPanel();
                  temp.jTable2.setValueAt(app.getString("appName"), 0, 0);
                  temp.jTable2.setValueAt(app.getString("developer"), 0,1);
                  temp.jTable2.setValueAt(name, 0, 2);
                  temp.jTable2.setValueAt(app.getString("dateadded"), 0, 3); 
                  temp.jTable2.setValueAt(app.getString("genre"), 0, 4); 

                  DefaultTableModel model = (DefaultTableModel) temp.jTable1.getModel();

                  ResultSet permissions = ThesisDatabase.getPermissions(Integer.parseInt(appId.getText()));
                  temp.jTable1.setModel(DbUtils.resultSetToTableModel(permissions));

                  ThesisDatabase.window.selectPanel(3);
                  appId.setText("");
          }
     }
     catch(NumberFormatException e)
     {
          JOptionPane.showMessageDialog(ThesisDatabase.popUp,
          "Not an integer. Please try again",
          "Whoops!",
          JOptionPane.ERROR_MESSAGE);
     }  catch (SQLException ex) {
            Logger.getLogger(QueriesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewAppDataButtonActionPerformed

    public void setName(String name)
    {
        userNameLabel.setText(name);
    }
    
    
    private void appPrivilegeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appPrivilegeButtonActionPerformed
        ThesisDatabase.window.getPrivilegesPanel().initialize();
        ThesisDatabase.window.selectPanel(4);
    }//GEN-LAST:event_appPrivilegeButtonActionPerformed

    private void appIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appIdActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        ThesisDatabase.window.selectPanel(5);
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void viewPermissionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPermissionsButtonActionPerformed
try
     {
       ResultSet permissions = ThesisDatabase.getAllPermissions();
       
                  ViewPermissionsPanel temp = ThesisDatabase.window.getViewPermissionsPanel();
                  DefaultTableModel model = (DefaultTableModel) temp.jTable1.getModel();
                  int h= temp.jTable1.getRowCount();
                  int row = 0;
                  while(permissions.next())
                  {
                     temp.jTable1.setValueAt(permissions.getString("permissionname"), row, 0);
                     temp.jTable1.setValueAt(permissions.getBoolean("potentiallyinsecure"), row,1);
                     row++;
                        if(row>= h)
                        {
                          h++;
                          model.setRowCount(h);
                        }
                  }
                  
                  ThesisDatabase.window.selectPanel(6);
          }
     
     catch(NumberFormatException e)
     {
          JOptionPane.showMessageDialog(ThesisDatabase.popUp,
          "Not an integer. Please try again",
          "Whoops!",
          JOptionPane.ERROR_MESSAGE);
     }  catch (SQLException ex) {
            Logger.getLogger(QueriesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
               }//GEN-LAST:event_viewPermissionsButtonActionPerformed

    private void unknownPermissionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unknownPermissionsButtonActionPerformed
            try {
                  ResultSet permissions = ThesisDatabase.getAllPermissions();
       
                  ViewPermissionsPanel temp = ThesisDatabase.window.getViewPermissionsPanel();
                  DefaultTableModel model = (DefaultTableModel) temp.jTable1.getModel();
                  int h= temp.jTable1.getRowCount();
                  int row = 0;
                  while(permissions.next())
                  {
                     temp.jTable1.setValueAt(permissions.getString("permissionname"), row, 0);
                     temp.jTable1.setValueAt(permissions.getBoolean("potentiallyinsecure"), row,1);
                     row++;
                        if(row>= h)
                        {
                          h++;
                          model.setRowCount(h);
                        }
                  }
                  
             ThesisDatabase.window.selectPanel(7);
          }
     
      catch (SQLException ex) {
            Logger.getLogger(QueriesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                      ThesisDatabase.window.selectPanel(7);

    }//GEN-LAST:event_unknownPermissionsButtonActionPerformed

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        String username = JOptionPane.showInputDialog("What is the user name of the user you would like to edit?");
        ThesisDatabase.window.setName(username);
        ThesisDatabase.loadUserForEditing(username);
        ThesisDatabase.window.selectPanel(8);
    }//GEN-LAST:event_editUserButtonActionPerformed

    private void userActivityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActivityButtonActionPerformed
        ThesisDatabase.window.selectPanel(9);
    }//GEN-LAST:event_userActivityButtonActionPerformed

    private void potentiallyInsecureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potentiallyInsecureButtonActionPerformed
        ThesisDatabase.window.getPotentiallyInsecurePanel().populateTable();
        ThesisDatabase.window.selectPanel(10);
    }//GEN-LAST:event_potentiallyInsecureButtonActionPerformed

    public void guestMode()
    {
        userMode();
        addAppButton.setVisible(false);
        unknownPermissionsButton.setVisible(false);
        //addAppButton.setVisible(false);
        //addAppButton.setVisible(false);

    }
    
    public void userMode()
    {
        addUserButton.setVisible(false);
        //addAppButton.setVisible(false);
        //addAppButton.setVisible(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAppButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JTextField appId;
    private javax.swing.JButton appPrivilegeButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JButton potentiallyInsecureButton;
    private javax.swing.JButton unknownPermissionsButton;
    private javax.swing.JButton userActivityButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JButton viewAppDataButton;
    private javax.swing.JButton viewPermissionsButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
