//Ava 
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.ArrayList;

public class Admin {
  private String filePath;

  public Admin(String filePath){
    this.filePath = filePath;
  }
    
  //adds a new employee to the csv file
    public void addEmployee(Employee employee){
       BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

      //Puts the employee details in a line in csv file
      String line = employee.getName() + ", " + employee.getTitle() + ", " + employee.getRole();

      //writes the line into the csv file and goes to next line then closes the writer
      writer.write(line);
      writer.newLine();
      writer.close();

      //Prints info about new employee
      System.out.println("New Employee added:" + line);
      
}
