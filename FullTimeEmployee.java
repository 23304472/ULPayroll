//Emma
public class FullTimeEmployee extends Employee{

    private double hours;

    public FullTimeEmployee(int id, String name, String title, double hours){
        super(id, name, title);
        this.hours = hours;
    }

    public String getName(){
        return super.getName();
    } public void setName(String name){
        super.setName();
    }

    public String getTitle(){
        return super.getTitle();
    } public void setTitle(String title){
        super.setTitle();
    }

    public double getHours(){
        return hours;
    } public void setHours(double hours){
        this.hours = hours;
    }

    public String getHourlyRate(){
        //calls csv read fulltime file method
    }


    @Override
    public String toString(){
        return super.toString() +
                "Salary type: Full-time" + "\n";
    }

}

