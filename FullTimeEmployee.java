import java.io.FileNotFoundException;
import java.time.LocalDate;

public class FullTimeEmployee extends Employee {

    private double hours;  //stores the number of hours

    // Constructor
    public FullTimeEmployee(int id, String name, String title, LocalDate dateAdded) throws FileNotFoundException {
        super(id, name, title, dateAdded);  // Pass relevant fields to the superclass
        this.hours = 40;  //initialize hours to 40 for full-time employees by default

        //use CSVWrite class to add employees to a file
        CSVWrite csv = new CSVWrite("C:\\Users\\shaun\\OneDrive\\Documents\\CS4013Assignment\\csvs\\Employees.csv"); //update the file path
        csv.addEmployee(id, name, title, dateAdded);  // Add the new employee to the CSV file
    }

    //getter and setter for hours (specific to full-time employees)
    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    //method to get full-time salary rate
    public double getFullTimeRate(int scalePoint) throws FileNotFoundException {
        CSVRead csv = new CSVRead("C:\\Users\\shaun\\OneDrive\\Documents\\CS4013Assignment\\csvs\\FullTimeRates.csv");  //provide the correct file path again
        return Double.parseDouble(csv.readSalary(getTitle(), scalePoint)); // Pass title and scale point
    }

    @Override
    public String toString() {
        //use all relevant details from both FullTimeEmployee and Employee class
        try {
            double salary = getFullTimeRate(3);  // Example: fetch the salary for 3rd promotion of employee
            return super.toString() +
                    "Salary Type: Full-time\n" +
                    "Hours Worked: " + getHours() + "\n" +
                    "Salary: " + salary + "\n";
        } catch (FileNotFoundException e) {
            return super.toString() +
                    "Salary Type: Full-time\n" +
                    "Error: " + e.getMessage() + "\n";
        }
    }
}

/*
TEST CLASS USED TO RUN FullTimeEmployee (runs with employee, CSVRead and CSVWrite)
(needs Payslip added in future to print out monthly wage)
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //create a new FullTimeEmployee object
        FullTimeEmployee employee = new FullTimeEmployee(10005, "Shaun Purcell", "Full Professor", LocalDate.now());

        //print all the details of the employee
        System.out.println(employee); // This will call the overridden toString method
    }
}
*/
