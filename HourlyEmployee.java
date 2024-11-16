//Emma
public class HourlyEmployee extends Employee{

    private double hours;

    public HourlyEmployee(){
    }

    public HourlyEmployee(int id, String name, String title, double hours){
        super(id, name, title);
        this.hours = hours;
    }

    public int getId(){
        return super.getId();
    } public void setId(int id){
        super.setId(id);
    }

    public String getName(){
        return super.getName();
    } public void setName(String name){
        super.setName(name);
    }

    public String getTitle(){
        return super.getTitle();
    } public void setTitle(String title){
        super.setTitle(title);
    }

    public double getHours(){
        return hours;
    } public void setHours(int hours){
        this.hours = hours;
    }

    public String getHourlyRate(){
        //calls csv read hourly file method
    }

    //gets hourly salary from hourly csv file
    @Override
    public String toString(){
        return super.toString() +
                "Salary type: Hourly" + "\n";
    }
}
