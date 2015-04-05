package thesisdatabase;


import java.util.ArrayList;

public class AndroidApplication extends Application
{
  ArrayList<Permission> permissions;
  
  public AndroidApplication(String fName, String pName, String min, String target, String vName, String vCode)
  {
    super(fName, pName, min, target, vName, vCode);
    permissions = new ArrayList<Permission>();
  }
  public ArrayList<String> appData()
  {
      ArrayList<String> data =super.appData();
      data.add("Android");
      return data;
  }

public void addPermission(Permission x)
{
  permissions.add(x);
}

public void print()
{
  super.print();
  for (int i =0; i < permissions.size(); i++)
  {
    permissions.get(i).print();
  }
}

}