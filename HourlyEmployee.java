import java.io.FileNotFoundException;
import java.time.LocalDate;

public class HourlyEmployee extends Employee{

    private double hours;

    public HourlyEmployee(int id, String name, String title, double hours) throws FileNotFoundException {
        super(id, name, title);
        this.hours = hours;
        LocalDate dateAdded = LocalDate.now(); //stores date employee is added
        csv.addEmployee(id, name, title, dateAdded); //adds to csv file
    }

    public double getHours(){
        return hours;
    } public void setHours(int hours){
        this.hours = hours;
    }

    public double getHourlyRate(HourlyEmployee employee) throws FileNotFoundException {
        CSVRead csv = new CSVRead("HourlyRates.csv"); //start read of hourly rates file
        return Double.parseDouble(csv.readSalary(employee)); //returns rate as double
    }

    //gets hourly salary from hourly csv file
    @Override
    public String toString(){
        return super.toString() +
                "Salary type: Hourly" + "\n";
    }
}
