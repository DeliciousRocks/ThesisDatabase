package thesisdatabase;


public class Permission
{
  private String permissionName;
  private boolean required;
  private boolean requested;
  
  public Permission(String pName, boolean require, boolean request)
  {
    permissionName = pName;
    required = require;
    requested = request;
  }
  
  public String getName()
  {
      return permissionName;
  }
  
  public boolean getRequired()
  {
      return required;
  }
  
  public boolean getRequested()
  {
      return requested;
  }
  
  public void print()
  {
    System.out.println(permissionName + "\nRequired: " +required+ "\nRequested: "+requested);
  }
 
}