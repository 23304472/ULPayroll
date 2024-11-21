import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Employee {

    protected int id;
    protected String name;
    protected String title;
    protected LocalDate dateAdded;
    CSVWrite csv = new CSVWrite("Employees.csv"); //

    public Employee(int id, String name, String title) throws FileNotFoundException {
        this.name = name;
        this.title = title;
        LocalDate dateAdded = LocalDate.now(); //stores date employees is added
        csv.addEmployee(id, name, title, dateAdded); //adds new employee to csv file
    }

    public int getId(){
        return id;
    } public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    } public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return title;
    }public void setTitle(String role){
        this.title = role;
    }

    public LocalDate getDateAdded(){
        return dateAdded;
    }

    public String toString(){
        return "Employee: " + id + "\n" +
                "Name: " + name + "\n" +
                "Title: " + title + "\n" +
                "Hours worked: " + "\n";
    }

    //get hourly employee salary should read from one data file, get full-time employee salary reads from another
    //make excel file with salary info, use scanner to read and find salaries
}
