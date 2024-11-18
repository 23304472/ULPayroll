import java.io.FileNotFoundException;
import java.time.LocalDate;

public class HourlyEmployee extends Employee{

    private double hours;

    public HourlyEmployee(int id, String name, String title, double hours) throws FileNotFoundException {
        super(id, name, title);
        this.hours = hours;
        LocalDate dateAdded = LocalDate.now();
        csv.addEmployee(id, name, title, dateAdded);
    }

    public double getHours(){
        return hours;
    } public void setHours(int hours){
        this.hours = hours;
    }

    public double getHourlyRate(){
        //calls readSalary method on hourly rate file
        //casts to double for payslip calculations
    }

    //gets hourly salary from hourly csv file
    @Override
    public String toString(){
        return super.toString() +
                "Salary type: Hourly" + "\n";
    }
}
