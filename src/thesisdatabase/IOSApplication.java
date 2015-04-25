package thesisdatabase;


import java.util.ArrayList;

public class IOSApplication extends Application
{
  ArrayList<String> frameworks;
  
  public IOSApplication(String fName, String pName, String min, String target, String vName, String vCode)
  {
    super(fName, pName, min, target, vName, vCode);
    frameworks = new ArrayList<String>();
  }
  
    public ArrayList<String> appData()
  {
      ArrayList<String> data =super.appData();
      data.add("iOS");
      return data;
  }
  
      public ArrayList<?> getInfo()
  {
      return frameworks;
  }
  
    
  public void addFramework(String framework)
  {
    frameworks.add(framework);
  }
  
  public void print()
  {
    super.print();
    for(int i = 0; i <frameworks.size(); i++)
    {
      System.out.println(frameworks.get(i));
    }
  }
}

