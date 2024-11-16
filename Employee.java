//Emma
import java.time.LocalDate;

public class Employee {

    protected int id;
    protected String name;
    protected String title;

    public Employee(){
    }

    public Employee(int id, String name, String title){
        this.name = name;
        this.title = title;
        LocalDate dateCreated = new LocalDate();
        //call CSVWrite
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

    public String toString(){
        return "Employee: " + id + "\n" +
                "Name: " + name + "\n" +
                "Title: " + title + "\n" +
                "Hours worked: " + "\n";
    }

    //get hourly employee salary should read from one data file, get full-time employee salary reads from another
    //make excel file with salary info, use scanner to read and find salaries
}
