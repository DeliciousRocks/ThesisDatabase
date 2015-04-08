package thesisdatabase;

import java.util.ArrayList;

public class Application
{
  private String fileName;
  private String packageName;
  private String minPlatformVersion;
  private String targetPlatformVersion;
  private String versionName;
  private String versionCode;
  
  public Application(String fName, String pName, String min, String target, String vName, String vCode)
  {
    fileName= fName;
    packageName = pName;
    minPlatformVersion = min;
    targetPlatformVersion = target;
    versionName = vName;
    versionCode = vCode;
  }
  
  public ArrayList<String> appData()
  {
     ArrayList<String> data = new ArrayList();
     data.add(fileName);
     data.add(packageName);
     data.add(minPlatformVersion);
     data.add(targetPlatformVersion);
     data.add(versionName);
     data.add(versionCode);
     return data;
  }
  
  public ArrayList<?> getInfo()
  {
      return null;
  }
  
   public  void print()
  {
    System.out.println("File Name: " + fileName);
    System.out.println("Package Name: " + packageName);
    System.out.println("Min Platform: " + minPlatformVersion);
    System.out.println("Target Platform: " + targetPlatformVersion);
    System.out.println("Version Name: " + versionName);
    System.out.println("Version Code: " + versionCode);
  }
}