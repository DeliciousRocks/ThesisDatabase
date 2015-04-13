/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author waltersquires
 */
public class AddAppPanel extends javax.swing.JPanel {

    /**
     * Creates new form addApp
     */
    public AddAppPanel() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        JSON = new javax.swing.JTextArea();
        addApp = new javax.swing.JButton();
        appName = new javax.swing.JTextField();
        appNameLabel = new javax.swing.JLabel();
        developerLabel = new javax.swing.JLabel();
        developerName = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setLayout(new java.awt.GridBagLayout());

        JSON.setColumns(20);
        JSON.setRows(5);
        jScrollPane1.setViewportView(JSON);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.ipady = 132;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 29, 29, 29);
        add(jScrollPane1, gridBagConstraints);

        addApp.setText("Submit");
        addApp.setPreferredSize(new java.awt.Dimension(100, 30));
        addApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        add(addApp, gridBagConstraints);

        appName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        add(appName, gridBagConstraints);

        appNameLabel.setText("App Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 28, 0, 18);
        add(appNameLabel, gridBagConstraints);

        developerLabel.setText("Developer:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 28, 0, 18);
        add(developerLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(developerName, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 28);
        add(cancelButton, gridBagConstraints);

        jLabel1.setText("JSON:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(21, 27, 0, 0);
        add(jLabel1, gridBagConstraints);
        add(filler1, new java.awt.GridBagConstraints());
        add(filler2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void addAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppActionPerformed
    try {
        Application newApp = ThesisDatabase.readJSON(JSON.getText());
        ArrayList<String> data = newApp.appData();
        data.add(ThesisDatabase.userName);
        data.add(appName.getText());
        data.add(developerName.getText());
        boolean exists = ThesisDatabase.isRepeat(data.get(0),data.get(4),data.get(6));
         if (exists)
        {
            Object[] options1 = {"No",
                                "Yes"};
             int n = JOptionPane.showOptionDialog(ThesisDatabase.popUp,
             "App you would like to submit may already exist in the database"
            + "\nWould you like to add it anyway?",
      "Success",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,     
      options1,  
      options1[0]);
      if (n==1)
      {
            finishAdding(newApp, data);
      }
        }
        else
            finishAdding(newApp,data);
    }
     catch (SQLException ex)
    {
        Logger.getLogger(AddAppPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    catch (org.json.JSONException e)
    {
      JOptionPane.showMessageDialog(ThesisDatabase.popUp,
          "Something appears to be wrong with the JSON file you have submitted. Please try again",
          "Whoops!",
          JOptionPane.ERROR_MESSAGE);
    }
    }
    

    private void finishAdding(Application newApp, ArrayList<String> data)
    {
        try
        {
        int appId = ThesisDatabase.addNewApp(data);
        
        ArrayList<?> permissions = newApp.getInfo();
        if(newApp instanceof AndroidApplication)
        {
            for(int i = 0; i< permissions.size(); i++)
            {
                ThesisDatabase.addpermission(appId, (Permission)permissions.get(i));
            }
            
        }
        else if (newApp instanceof IOSApplication)
        {
            for(int i = 0; i< permissions.size(); i++)
            {
                ThesisDatabase.addPackage(appId, (String)permissions.get(i));

            }

            
        }
               
       
      Object[] options1 = {"No, I'd like to go back",
                          "Yes, I'd like to continue"};
      int n = JOptionPane.showOptionDialog(ThesisDatabase.popUp,
      "The data you submitted has been added to the database. "
      + "\nWould you like to continue?",
      "Success",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,     
      options1,  
      options1[0]);
      if (n==0)
      {
            ThesisDatabase.window.selectPanel(2);
      }
      
              clearFields();

     }
     catch (SQLException ex)
    {
        Logger.getLogger(AddAppPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }//GEN-LAST:event_addAppActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clearFields();
        ThesisDatabase.window.selectPanel(2);        
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void appNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appNameActionPerformed
private void clearFields()
{
    appName.setText("");
    developerName.setText("");
    JSON.setText("");
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JSON;
    private javax.swing.JButton addApp;
    private javax.swing.JTextField appName;
    private javax.swing.JLabel appNameLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel developerLabel;
    private javax.swing.JTextField developerName;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
