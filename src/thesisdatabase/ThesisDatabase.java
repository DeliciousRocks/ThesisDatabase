/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author waltersquires
 */
public class ThesisDatabase 
{
    public static ThesisFrame window;
    public static JFrame popUp;
    private static Connection conn;
    public static String userName;
    public static int role;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
        //SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                window =new ThesisFrame();
                window.setVisible(true);
                window.selectPanel(1);

            }
            
        });
        conn = connectToDatabaseOrDie();
        
    }
    private static Connection connectToDatabaseOrDie() 
    {
     Connection con = null;
  
     try
     {
     Class.forName("org.postgresql.Driver");
   
     } 
     catch (ClassNotFoundException e1)
     {
     e1.printStackTrace();
     }
  
     String url = "jdbc:postgresql://localhost:5432/Static_Analysis";
     String user = "postgres";
     String password = "A1B2C3";

     try 
     {
     con = DriverManager.getConnection(url, user, password);
     }

     catch (SQLException e) 
     {
     e.printStackTrace();
  //     System.exit(2);
     }
     return con;
   }
    
    public static boolean login(String user, String pass)
        throws SQLException {

       PreparedStatement login = null;
       String loginString =
           "select login(?,?)";
       boolean loggedIn = false;

       try {
              login = conn.prepareStatement(loginString);
              login.setString(1, user);
              login.setString(2, pass);
              ResultSet rs = login.executeQuery();
              if(rs.next())
                loggedIn =rs.getBoolean(1);
              
              if(loggedIn)
              {
                PreparedStatement getRole = null;
                String getRoleString = "select role " +
                                       "from users " +
                                       "where userName = ?";
                getRole = conn.prepareStatement(getRoleString);
                getRole.setString(1, user);
                //System.out.println(getRole.toString());

                rs = getRole.executeQuery();
                if(rs.next())
                {
                    role =rs.getInt(1);
                    userName = user;
                    //System.out.println(role + userName);
                }
              }
              
              return loggedIn;
    
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
       return loggedIn;
   }

//Adds app not permission. Yet
public static int addNewApp(ArrayList<String> data)
        throws SQLException {

       int appId = -1;
       PreparedStatement addNewApp = null;
       String newAppString =
           "select addnewapp(?,?,?,?,?,?,?,?,?,?)";
       try {
              addNewApp = conn.prepareStatement(newAppString);
              
              for (int i = 0; i<10;i++)
              {
                  int j = i+1;
                  if (i == 2 || i ==3)
                    addNewApp.setFloat(j, Float.valueOf(data.get(i)));
                  else
                     addNewApp.setString(j, data.get(i));
              }
              ResultSet rs = addNewApp.executeQuery();
              if(rs.next())
                appId =rs.getInt(1);
              
              return appId;
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
       return -1;
   }

public static void addpermission(int id, Permission x)
        throws SQLException {

       PreparedStatement addPermission = null;
       String newPermissionString =
           "select addpermission(?,?,?,?)";
       try {
              addPermission = conn.prepareStatement(newPermissionString);
              addPermission.setInt(1, id);
              addPermission.setString(2, x.getName());
              addPermission.setBoolean(3, x.getRequested());
              addPermission.setBoolean(4, x.getRequired());
 
              addPermission.executeQuery();
            
              
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
   }

public static void addPackage(int id, String x)
        throws SQLException {

       PreparedStatement addPackage = null;
       String newPackageString =
           "select addpackage(?,?)";
       try {
              addPackage = conn.prepareStatement(newPackageString);
              addPackage.setInt(1, id);
              addPackage.setString(2, x);
   
              addPackage.executeQuery();
              
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
   }

public static Application readJSON(String json) throws org.json.JSONException
  {
    JSONObject obj = new JSONObject(json);
    IOSApplication ios = null;
    AndroidApplication android = null;

    String appType = obj.getJSONObject("properties").getString("platform");

    if(appType.equals("iOS"))
         {
           ios= new IOSApplication(obj.getString("file"),
                                 obj.getJSONObject("properties").getString("packageName"),
                                 obj.getJSONObject("properties").getString("minimumPlatformVersion"),
                                 obj.getJSONObject("properties").getString("targetPlatformVersion"),
                                 obj.getJSONObject("properties").getString("versionName"),
                                 obj.getJSONObject("properties").getString("versionCode"));
           
           JSONArray arr = obj.getJSONArray("frameworks");
           for (int i = 0; i < arr.length(); i++)
           {
             JSONObject temp =new JSONObject(arr.get(i).toString());
             //System.out.println(temp);
             //System.out.println(i);
             //System.out.println(temp.getString("framework"));
             //System.out.println(arr.get(i).getJSONObject("framework"));
             ios.addFramework(temp.getString("framework"));  
           }
               return ios;
         }
    else if (appType.equals("Android"))
      {
           android= new AndroidApplication(obj.getString("file"),
                                 obj.getJSONObject("properties").getString("packageName"),
                                 obj.getJSONObject("properties").getString("minimumPlatformVersion"),
                                 obj.getJSONObject("properties").getString("targetPlatformVersion"),
                                 obj.getJSONObject("properties").getString("versionName"),
                                 obj.getJSONObject("properties").getString("versionCode"));
           JSONArray arr = obj.getJSONArray("permissions");
           for (int k = 0; k < arr.length(); k++)
           {
             JSONObject temp =new JSONObject(arr.get(k).toString());
             Permission buffer = new Permission(temp.getString("permission"),temp.getBoolean("required"),temp.getBoolean("requested"));

             //System.out.println(i);
             //System.out.println(temp.getString("framework"));
             //System.out.println(arr.get(i).getJSONObject("framework"));
             android.addPermission(buffer);  
           }
               return android;
         }
    
    return null;
  }
}

