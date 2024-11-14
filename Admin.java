//Ava 
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.ArrayList;

public class Admin {
  private String filePath;

  public Admin(String filePath){
    this.filePath = filePath;
  }
    
    public void addEmployee(Employee employee){
        //add to csv file
      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
      
}
