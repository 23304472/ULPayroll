import java.io.FileNotFoundException;
import java.time.LocalDate;

public class FullTimeEmployee extends Employee{

    private double hours;

    public FullTimeEmployee(int id, String name, String title, double hours) throws FileNotFoundException {
        super(id, name, title);
        this.hours = hours;
        LocalDate dateAdded = LocalDate.now(); //stores date new employee is added
        csv.addEmployee(id, name, title, dateAdded); //adds new employee to csv file
    }

    public double getHours(){
        return hours;
    } public void setHours(double hours){
        this.hours = hours;
    }

    public double getHourlyRate(){

        //call readSalary method on fulltime salary file
        //casts to double so payslip can be calculated
    }


    @Override
    public String toString(){
        return super.toString() +
                "Salary type: Full-time" + "\n";
    }

}

