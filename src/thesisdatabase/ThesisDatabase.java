/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisdatabase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
                window = new ThesisFrame();
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
     //String url = "jdbc:postgresql://localhost:5432/Thesis";
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
    
       } catch (SQLException e ) {
           e.printStackTrace();
       }
       return role;
   }

    
    public static ResultSet viewApp(int id)
      throws SQLException {
  
              
      try {
          PreparedStatement stmt = null;
              String query =
                      "select os,appName,developer,addedby,dateadded,genre,os"
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
              String query =
                      "select permissionname as \"Permission Name\", "
                      + "requested as \"Requested\", "
                      + "required as \"Required\", "
                      + "useddynamically as \"Used Dynamically\" "
                      + "from apphaspermission "
                      + "where appId = ?";
          
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


  public static ResultSet getFrameworks(int id)
      throws SQLException {
  
              
      try {
          PreparedStatement stmt = null;
              String query = "select distinct frameworkname,potentiallyinsecure"
                      + " from apphasframework,framework"
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


public static void updatePermission(boolean x, String y)
        throws SQLException {
try{
        PreparedStatement updatePermission = null;
       String PermissionString =
           //"select addpermission(?,?,?,?)";
           "update permission set potentiallyinsecure= ? where permissionname =?";
       
              updatePermission = conn.prepareStatement(PermissionString);
              updatePermission.setBoolean(1, x);
              updatePermission.setString(2, y);
              updatePermission.executeUpdate();

 
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
   }


public static void updateFramework(boolean x, String y)
        throws SQLException {
try{
        PreparedStatement updatePermission = null;
       String PermissionString =
           //"select addpermission(?,?,?,?)";
           "update framework set potentiallyinsecure= ? where frameworkname =?";
       
              updatePermission = conn.prepareStatement(PermissionString);
              updatePermission.setBoolean(1, x);
              updatePermission.setString(2, y);
              updatePermission.executeUpdate();

 
       } 
       catch (SQLException e ) {
        e.printStackTrace();
       }
   }

public static boolean updateDynamicallyUsed(boolean isUsedDynamically, String permissionOrFramework, String appName, String os) {
    // Change query slightly based on if OS is Android or iOS.
    String query = os.equals("Android")
    ?
            "update apphaspermission " +
            "set useddynamically=? " +
            "where appid=(select appid from application where appname=?) " +
            "and permissionname=?"
    :
            "update apphasframework " +
            "set useddynamically=? " +
            "where appid=(select appid from application where appname=?) " +
            "and packagename=?";
    
    try {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setBoolean(1, isUsedDynamically);
        stmt.setString(2, appName);
        stmt.setString(3, permissionOrFramework);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
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
    
    public static boolean addUser(String x, String y, int z, int quota)
        throws SQLException {

       PreparedStatement adduser = null;
       String add =
           "select createUser(?,?,?,?)";
       try {
            
              adduser = conn.prepareStatement(add);
              adduser.setString(1, x);
              adduser.setString(2, y);
              adduser.setInt(3, z);
              adduser.setInt(4, quota);

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
    
    public static boolean updateUser(String username, String password, int role, int quota) {
        PreparedStatement updateUserStmt = null;
        String updateUserQuery =
                  "update users "
                + "set password=?, role=?, quota=? "
                + "where username=?";
                
        try {
            updateUserStmt = conn.prepareStatement(updateUserQuery);
            System.out.println(1);
            updateUserStmt.setString(1, password);
            System.out.println(2);
            updateUserStmt.setInt(2, role);
            System.out.println(3);
            updateUserStmt.setInt(3, quota);
            System.out.println(4);
            updateUserStmt.setString(4, username);
            
            System.out.println(5);
            updateUserStmt.executeUpdate();
            System.out.println(6);
            JOptionPane.showMessageDialog(window, "The user has successfully been updated",
                    "User Update Successfull", JOptionPane.DEFAULT_OPTION);            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(window, "Unable to update user:\n" + e,
                    "User Update Failed", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static boolean loadUserForEditing(String username)
    {
        String getUserQuery = "select * from users where username=?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(getUserQuery);
            stmt.setString(1, username);
            
            ResultSet rs = stmt.executeQuery();
            // If there is someone with that username, set up
            // the EditUserPanel. Otherwise, return false.
            if (rs.next()) {
                // Real convoluted way of doing this, because ThesisFrame
                // calls a method in EditUserPanel, but it don't matta.
                window.loadUserForEditing(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));                
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    public static ResultSet getTopUsersForMonth(int numberOfUsers, int year, int month) {
        Timestamp startTimestamp = new Timestamp(0);
        Timestamp endTimestamp = new Timestamp(0);
        getStartAndEndTimestampFromYearAndMonth(year, month, startTimestamp, endTimestamp);
        
        String topUsersQuery =
                "select userid as \"User ID\", username as \"User Name\", quota as \"Quota\", count(*) as \"Apps Submitted\"" +
                "from users, application " +
                "where userid=addedby " +
                "and dateadded > ? " +
                "and dateadded < ? " +
                "group by userid " +
                "order by count(*) " +
                "limit ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(topUsersQuery);
            stmt.setTimestamp(1, startTimestamp);
            stmt.setTimestamp(2, endTimestamp);
            stmt.setInt(3, numberOfUsers);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ResultSet getUsersUnderQuotaForMonth(int year, int month) {
        Timestamp startTimestamp = new Timestamp(0);
        Timestamp endTimestamp = new Timestamp(0);
        getStartAndEndTimestampFromYearAndMonth(year, month, startTimestamp, endTimestamp);
        
        String underQuotaQuery =
            "select userid as \"User ID\", " +
                "username as \"User Name\", " +
                "quota as \"Quota\", " +
                "count(*) as \"Apps Submitted\" " +
            "from users, application " +
            "where userid=addedby " +
            "and dateadded > ? " +
            "and dateadded < ? " +
            "group by userid " +
            "having count(*)<quota " +
            "union " +
            "select userid as \"User ID\", " +
                    "username as \"User Name\", " +
                    "quota as \"Quota\", " +
                    "0 as \"Apps Submitted\" " +
            "from users " +
            "where userid not in " +
                    "(select addedby " +
                    "from application " +
                    "where dateadded > ? " +
                          "and dateadded < ?) " +
            "order by \"User ID\"";
        try {
            PreparedStatement stmt = conn.prepareStatement(underQuotaQuery);
            stmt.setTimestamp(1, startTimestamp);
            stmt.setTimestamp(2, endTimestamp);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ResultSet getAllPermissions()
      throws SQLException {
  
              
      try {
          PreparedStatement stmt = null;
          String query = "Select * from permission "
                  + "where permissionname not in "
                  + "(select getunknownpermissions()) order by permissionname;";
          stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return null;
 }   
    
    
    public static ResultSet getAllFrameworks()
      throws SQLException {
              
      try {
          PreparedStatement stmt = null;
          String query = "Select * from framework "
                  + "where frameworkname not in "
                  + "(select getunknownframeworks()) order by frameworkname;";
          stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return null;
 }   
    
      public static ResultSet getUnknownPermissions()
      throws SQLException {
      
      try {
          PreparedStatement stmt = null;
          String query = "Select getunknownpermissions()";
          stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
            e.printStackTrace();
      }
      return null;
 }   
       
       public static ResultSet getUnknownFrameworks()
      throws SQLException {
              
      try {
          PreparedStatement stmt = null;
          String query = "Select getunknownFrameworks()";
          stmt = conn.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          return rs;
      } catch (SQLException e ) {
          //System.out.println(e.getMessage());
       e.printStackTrace();
      }
      return null;
 }   
    
        private static void getStartAndEndTimestampFromYearAndMonth(int year, int month, Timestamp start, Timestamp end) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 0);
        start.setTime(cal.getTimeInMillis());
        cal.add(Calendar.MONTH, 1);
        end.setTime(cal.getTimeInMillis());
    }
   
    public static ResultSet getPotentiallyInsecureApps() {
        String potentiallyInsecureQuery =
            "select application.appid as \"App ID\", " +
                    "appname as \"App Name\", " +
                    "genre as \"Genre\", " +
                    "os as \"OS\" " +
            "from application, framework, apphasframework " +
            "where potentiallyinsecure=true " +
                    "and application.appid=apphasframework.appid " +
                    "and framework.frameworkname=apphasframework.packagename " +
            "union " +
            "select application.appid as \"App ID\", " +
                    "appname as \"App Name\", " +
                    "genre as \"Genre\", " +
                    "os as \"OS\" " +
            "from application, permission, apphaspermission " +
            "where potentiallyinsecure=true " +
                    "and application.appid=apphaspermission.appid " +
                    "and permission.permissionname=apphaspermission.permissionname " +
            "order by \"App ID\"";
        
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(potentiallyInsecureQuery);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Integer> getStaticAnalysisStats() {
	// good 0, under 1, over 2, both 3
        List<String> queries = new ArrayList<String>();
        queries.add("select count(*) from getAppsWithPrivilegeStatus(0)"); // Good
        queries.add("select count(*) from getAppsWithPrivilegeStatus(1)"); // Under
        queries.add("select count(*) from getAppsWithPrivilegeStatus(2)"); // Over
        queries.add("select count(*) from getAppsWithPrivilegeStatus(3)"); // Both
        
        try {
            
            List<Integer> stats = new ArrayList<Integer>();
            
            List<PreparedStatement> stmts = new ArrayList<PreparedStatement>();
            for (String query : queries)
                stmts.add(conn.prepareStatement(query));
            for (PreparedStatement stmt : stmts) {
                ResultSet rs = stmt.executeQuery();
                rs.next();
                stats.add(rs.getInt(1));
            }
            
            return stats;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

