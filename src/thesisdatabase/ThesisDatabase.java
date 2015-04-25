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
import java.util.Set;
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
  
     String url = "jdbc:postgresql://localhost:5432/Thesis";
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
              //viewApp(0);
              return loggedIn;
    
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
       return loggedIn;
   }

    public static int checkRole()
        throws SQLException {

       int role = -1;
       PreparedStatement checkRole = null;
       String check =
           "select getuserrole(?)";
       try {
              checkRole = conn.prepareStatement(check);
              checkRole.setString(1,ThesisDatabase.userName);
              ResultSet rs = checkRole.executeQuery();
              if(rs.next())
                role =rs.getInt(1);
           
              return role;
    
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
       return role;
   }

    
    public static ResultSet viewApp(int id)
      throws SQLException {
  
              
      try {
          PreparedStatement stmt = null;
              String query = "select os,appName,developer,addedby,dateadded"
                      + " from application"
                      + " where appId = ?";
          
          stmt = conn.prepareStatement(query);
          stmt.setInt(1,id);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return null;
 }
 
  public static ResultSet getPermissions(int id)
      throws SQLException {
  
              
      try {
          PreparedStatement stmt = null;
              String query = "select permissionname,requested,required"
                      + " from apphaspermission"
                      + " where appId = ?";
          
          stmt = conn.prepareStatement(query);
          stmt.setInt(1,id);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return null;
 }   
//Adds app not permission. Yet
public static int addNewApp(ArrayList<String> data)
        throws SQLException {
       int appId = -1;
       PreparedStatement addNewApp = null;
       String newAppString = "select addnewapp(?,?,?,?,?,?,?,?,?,?,?)";
       try {
              addNewApp = conn.prepareStatement(newAppString);
              
              for (int i = 0; i<11;i++)
              {
                  int j = i+1;
                  if (i == 2 || i ==3)
                  {
                    try
                    {
                    addNewApp.setFloat(j, Float.valueOf(data.get(i)));
                    }
                    catch (NumberFormatException e)
                    {
                      addNewApp.setFloat(j, -1);
                    }
                  }
                  else
                  {
                      addNewApp.setString(j, data.get(i));
                  }
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

public static boolean isRepeat(String x, String y)
        throws SQLException {

       PreparedStatement isRepeat = null;
       String repeat =
           "select isRepeat(?,?)";
       try {
            
              isRepeat = conn.prepareStatement(repeat);
              isRepeat.setString(1, x);
              isRepeat.setString(2, y);

              ResultSet rs = isRepeat.executeQuery();
              if(rs.next())
              {
                boolean temp = rs.getBoolean(1);
                return temp;
              }
              
              //return false;
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
       return false;
   }


public static void addpermission(int id, Permission x)
        throws SQLException {

       PreparedStatement addPermission = null;
       String newPermissionString =
           //"select addpermission(?,?,?,?)";
           "insert into apphaspermission values(?, ?, ?, ?)";
       try {
              addPermission = conn.prepareStatement(newPermissionString);
              addPermission.setInt(1, id);
              addPermission.setString(2, x.getName());
              addPermission.setBoolean(3, x.getRequested());
              addPermission.setBoolean(4, x.getRequired());
 
              //addPermission.executeQuery();
              addPermission.executeUpdate();
            
              
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
   }

public static void addPackage(int id, String x)
        throws SQLException {

       PreparedStatement addPackage = null;
       String newPackageString =
           "insert into apphasframework values(?, ?)";
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

public static ArrayList<ResultSet> getAppsbyStatus()
{
    ArrayList<ResultSet> results = new ArrayList();
        try {
            PreparedStatement stmt = null;
            String query = "select  * from getAppsWithPrivilegeStatus(?);";
            for (int i = 0; i<4; i++)
            {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1,i);
            ResultSet rs = stmt.executeQuery();
            results.add(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
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

    static String getUserName(int parseInt) throws SQLException
    {    
      String temp ="";
      try {
          PreparedStatement stmt = null;
              String query = "select getUserName(?)";
          stmt = conn.prepareStatement(query);
          stmt.setInt(1,parseInt);
          ResultSet rs = stmt.executeQuery();
          if(rs.next())
          {
            temp = rs.getString(1);
            return temp;
          }
          return temp;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return temp;
    }
    
    public static boolean addUser(String x, String y,int z)
        throws SQLException {

       PreparedStatement adduser = null;
       String add =
           "select createUser(?,?,?)";
       try {
            
              adduser = conn.prepareStatement(add);
              adduser.setString(1, x);
              adduser.setString(2, y);
              adduser.setInt(3, z);

              ResultSet rs = adduser.executeQuery();
              if(rs.next())
              {
                boolean temp = rs.getBoolean(1);
                return temp;
              }
              
              //return false;
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
       return false;
   }
    
    public static ResultSet getAllPermissions()
      throws SQLException {
  
              
      try {
          PreparedStatement stmt = null;
          String query = "Select * from permission where permissionname not in (select getunknownpermissions()) order by permissionname;";
          stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return null;
 }   
}

