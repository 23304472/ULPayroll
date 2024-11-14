//Emma
public class HourlyEmployee extends Employee{

    public HourlyEmployee(String name, String role){
        super(name, role);
    }

    //gets hourly salary from hourly csv file
    @Override
    public String toString(){
        return super.toString() + "Employee is paid an hourly salary";
    }
}
