import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Employee {

    private int id;
    private String name;
    private String title;
    private LocalDate dateAdded;
    private String password;
    private double hoursWorked;
    private HashMap<Integer, String> passwords;
    CSVWrite csv = new CSVWrite(); //

    public Employee(int id, String name, String title) throws FileNotFoundException {
        this.id = id;
        this.name = name;
        this.title = title;
        this.dateAdded = LocalDate.now(); //stores date employees is added
        this.passwords = new HashMap<>();
        csv.addEmployee(id, name, title, dateAdded);//adds new employee to csv file
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        //find id in csv file, update row
        //needs to update csv file
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public String getPassword() {
        return passwords.get(id); //returns matching password for given id
    }

    public void setPassword(String password){
        if(isValid(password)){
            this.password = password; //sets to current password
            passwords.put(id, password); //adds to hashmap linked with employee id
        } else throw new IllegalArgumentException("Invalid password, must be at least 8 characters and contain a symbol and number");
    }
    
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean isValid(String password){
        boolean isValid = true;
        if (password.length() < 8){ //must be at least 8 characters
            isValid = false; //return false if > 8 characters
        } else if(!password.matches(".*[0-9].*")){ // must contain number
            isValid = false; //return false if no number
        } else if(password.matches(".*[!$&].*")){ //must contain symbol
            isValid = false; //return false if no symbol
        }
        return isValid;
    }

    public boolean passwordExists(int id){
        return passwords.containsKey(id);
         
    }

    public String toString(){
        return "Employee: " + id + "\n" +
                "Name: " + name + "\n" +
                "Title: " + title + "\n" +
                "Hours worked: " + hoursWorked + "\n";
    }

}
/*
TEST FOR EMPLOYEE -Shaun
public class Main {
    public static void main(String[] args) {
        try {
            //create an Employee instance
            Employee employee = new Employee(1, "John Smith", "Full Professor");

            //set hours worked for the employee
            employee.setHoursWorked(40.0);  // Example: 40 hours worked

            //set the password for the employee
            employee.setPassword("Password1@);

            //print out the employee details
            System.out.println(employee);

            //check if the password exists for the given employee ID
            System.out.println("Password exists: " + employee.passwordExists(1));

        } catch (FileNotFoundException e) {
            System.err.println("Error: CSV file not found.");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
*/
