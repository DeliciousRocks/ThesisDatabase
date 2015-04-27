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
        panels.add(appPrivilegesPanel2);
        panels.add(addUserPanel1);
        panels.add(viewPermissionsPanel1);
        panels.add(classifyUnknownPermissionsPanel1);
        panels.add(editUserPanel1);
        panels.add(userActivityPanel1);
        panels.add(potentiallyInsecurePanel1);
        panels.add(classifyUnknownFrameworksPanel1);
        panels.add(viewFrameworksPanel1);
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
    
    public void setName(String name)
    {
        queriesPanel1.setName(name);
        editUserPanel1.setName(name);
    }
    
    public AppData getAndroidPanel()
    {
        return androidResults1;
    }
    
    public AppPrivilegesPanel getPrivilegesPanel()
    {
        return appPrivilegesPanel2;
    }

    public PotentiallyInsecurePanel getPotentiallyInsecurePanel()
    {
        return potentiallyInsecurePanel1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queriesPanel1 = new thesisdatabase.QueriesPanel();
        androidResults1 = new thesisdatabase.AppData();
        loginPanel2 = new thesisdatabase.LoginPanel();
        addAppPanel1 = new thesisdatabase.AddAppPanel();
        appPrivilegesPanel2 = new thesisdatabase.AppPrivilegesPanel();
        addUserPanel1 = new thesisdatabase.AddUserPanel();
        viewPermissionsPanel1 = new thesisdatabase.ViewPermissionsPanel();
        classifyUnknownPermissionsPanel1 = new thesisdatabase.classifyUnknownPermissionsPanel();
        editUserPanel1 = new thesisdatabase.EditUserPanel();
        userActivityPanel1 = new thesisdatabase.UserActivityPanel();
        classifyUnknownFrameworksPanel1 = new thesisdatabase.classifyUnknownFrameworksPanel();
        viewFrameworksPanel1 = new thesisdatabase.ViewFrameworksPanel();
        potentiallyInsecurePanel1 = new thesisdatabase.PotentiallyInsecurePanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new java.awt.CardLayout());
        add(queriesPanel1, "card2");
        add(androidResults1, "card3");
        add(loginPanel2, "card4");
        add(addAppPanel1, "card5");
        add(appPrivilegesPanel2, "card6");
        add(addUserPanel1, "card7");
        add(viewPermissionsPanel1, "card8");
        add(classifyUnknownPermissionsPanel1, "card9");
        add(editUserPanel1, "card10");
        add(userActivityPanel1, "card11");
        add(classifyUnknownFrameworksPanel1, "card12");
        add(viewFrameworksPanel1, "card13");
        add(potentiallyInsecurePanel1, "card14");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public void guestMode()
    {
        queriesPanel1.guestMode();
    }
    
    public void userMode()
    {
        queriesPanel1.userMode();
    }
   
    public ViewPermissionsPanel getViewPermissionsPanel()
    {
        return viewPermissionsPanel1;
    }


    public ViewFrameworksPanel getViewFrameworksPanel()
    {
        return viewFrameworksPanel1;
    }
    
    
     public classifyUnknownPermissionsPanel getViewUNKNOWNPermissionsPanel()
    {
        return classifyUnknownPermissionsPanel1;
    }
     
      public classifyUnknownFrameworksPanel getViewUNKNOWNFrameworksPanel()
    {
        return classifyUnknownFrameworksPanel1;
    }
    
    public void loadUserForEditing(String username, String password, int role, String quota) {
        editUserPanel1.setUser(username, password, role, quota);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private thesisdatabase.AddAppPanel addAppPanel1;
    private thesisdatabase.AddUserPanel addUserPanel1;
    private thesisdatabase.AppData androidResults1;
    private thesisdatabase.AppPrivilegesPanel appPrivilegesPanel2;
    private thesisdatabase.classifyUnknownFrameworksPanel classifyUnknownFrameworksPanel1;
    private thesisdatabase.classifyUnknownPermissionsPanel classifyUnknownPermissionsPanel1;
    private thesisdatabase.EditUserPanel editUserPanel1;
    private thesisdatabase.LoginPanel loginPanel2;
    private thesisdatabase.PotentiallyInsecurePanel potentiallyInsecurePanel1;
    private thesisdatabase.QueriesPanel queriesPanel1;
    private thesisdatabase.UserActivityPanel userActivityPanel1;
    private thesisdatabase.ViewFrameworksPanel viewFrameworksPanel1;
    private thesisdatabase.ViewPermissionsPanel viewPermissionsPanel1;
    // End of variables declaration//GEN-END:variables
}
