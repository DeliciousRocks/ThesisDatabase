/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.util.ArrayList;

/**
 *
 * @author waltersquires
 */
public class ThesisFrame extends java.awt.Frame {
    private ArrayList<javax.swing.JPanel> panels;
    /**
     * Creates new form ThesisFrame
     */
    public ThesisFrame() {
        initComponents();
        panels = new ArrayList();
        panels.add(addAppPanel1);
        panels.add(loginPanel2);
        panels.add(queriesPanel1);
        panels.add(androidResults1);



        
    }
    
    public void selectPanel(int s)
    {
        for (int i = 0; i< panels.size();i++)
        {
            if (s == i)
                panels.get(i).setVisible(true);
            else
                panels.get(i).setVisible(false);
        }
    }
    
    public AndroidResults getAndroidPanel()
    {
        return androidResults1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queriesPanel1 = new thesisdatabase.queriesPanel();
        androidResults1 = new thesisdatabase.AndroidResults();
        loginPanel2 = new thesisdatabase.LoginPanel();
        addAppPanel1 = new thesisdatabase.AddAppPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(queriesPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 620, 270));
        add(androidResults1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 610, -1));
        add(loginPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));
        add(addAppPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private thesisdatabase.AddAppPanel addAppPanel1;
    private thesisdatabase.AndroidResults androidResults1;
    private thesisdatabase.LoginPanel loginPanel2;
    private thesisdatabase.queriesPanel queriesPanel1;
    // End of variables declaration//GEN-END:variables
}
