import java.io.FileNotFoundException;
import java.time.LocalDate;

public class PartTimeEmployee extends Employee {

    private double hours;

    public PartTimeEmployee(int id, String name, String title, double hours) throws FileNotFoundException {
        super(id, name, title);
        this.hours = hours;
        LocalDate dateAdded = LocalDate.now(); //stores date employee is added
        csv.addEmployee(id, name, title, dateAdded); //adds to csv file
    }

    public double getHours(){
        return hours;
    } public void setHours(double hours){
        this.hours = hours;
    }

    public double getPartTimeRate(PartTimeEmployee employee) throws FileNotFoundException {
        CSVRead csv = new CSVRead("PartTimeRates.csv");
        return Double.parseDouble(csv.readSalary(employee));
    }

    @Override
    public String toString(){
        return super.toString() + "Salary type: Part-time" + "\n";
    }

}
