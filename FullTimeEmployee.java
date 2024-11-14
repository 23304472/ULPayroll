//Emma
public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(String name, String role){
        super(name, role);
    }

//gets full-time salary from full-time csv file
    @Override
    public String toString(){
        return super.toString() + "Employee is paid a full-time salary";
    }

}

