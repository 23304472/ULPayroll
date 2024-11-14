//Emma
public class Employee {

    private String name;
    private String title;

    public Employee(String name, String title){
        this.name = name;
        this.title = title;
        //record date
        //store in csv file
    }

    public String getName(){
        return name;
    } public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return title;
    }public void setRole(String role){
        this.title = role;
    }

    public String toString(){
        return "Employee name: " + name + "\n" +
                "Employee role: " + title + "\n";
    }

    //get hourly employee salary should read from one data file, get full-time employee salary reads from another
    //make excel file with salary info, use scanner to read and find salaries
}
