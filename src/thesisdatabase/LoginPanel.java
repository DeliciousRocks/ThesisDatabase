/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author waltersquires
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTextField1 = new javax.swing.JTextField();
        UserNameLabel = new javax.swing.JLabel();
        userNameInput = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        userPasswordInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setMinimumSize(new java.awt.Dimension(400, 400));
        setLayout(new java.awt.GridBagLayout());

        UserNameLabel.setText("User Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(27, 20, 0, 0);
        add(UserNameLabel, gridBagConstraints);

        userNameInput.setFocusCycleRoot(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userPasswordInput, org.jdesktop.beansbinding.ObjectProperty.create(), userNameInput, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(14, 20, 0, 13);
        add(userNameInput, gridBagConstraints);

        PasswordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(7, 20, 2, 0);
        add(PasswordLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 2.1;
        gridBagConstraints.insets = new java.awt.Insets(13, 20, 0, 13);
        add(userPasswordInput, gridBagConstraints);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(36, 27, 0, 27);
        add(jButton1, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try 
        {
            boolean login = ThesisDatabase.login((userNameInput.getText()),userPasswordInput.getText());
            if(login)
            {
                if (ThesisDatabase.role>0)
                {
                    if (ThesisDatabase.role>1)
                        ThesisDatabase.window.guestMode();
                    else 
                        ThesisDatabase.window.userMode();
                    
                }
               
                ThesisDatabase.window.selectPanel(2);
                ThesisDatabase.userName = userNameInput.getText();
                ThesisDatabase.role = ThesisDatabase.checkRole();
                ThesisDatabase.window.setName(ThesisDatabase.userName);
                
            }
            else
            {
            }

        }
        catch (SQLException ex) 
        {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField userNameInput;
    private javax.swing.JTextField userPasswordInput;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
