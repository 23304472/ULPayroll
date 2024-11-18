import java.io.FileNotFoundException;
import java.time.LocalDate;

public class PartTimeEmployee extends Employee {

    private double hours;

    public PartTimeEmployee(int id, String name, String title, double hours) throws FileNotFoundException {
        super(id, name, title);
        this.hours = hours;
        LocalDate dateAdded = LocalDate.now();
        csv.addEmployee(id, name, title, dateAdded);
    }

    public double getHours(){
        return hours;
    } public void setHours(double hours){
        this.hours = hours;
    }

    public double getPartTimeRate(String title){
        //calls readSalary method on part-time file
        //casts to double for payslip calculations
    }

    @Override
    public String toString(){
        return super.toString() + "Salary type: Part-time" + "\n";
    }

}
