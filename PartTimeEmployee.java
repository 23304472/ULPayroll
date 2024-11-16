public class PartTimeEmployee extends Employee {

    private double hours;

    public PartTimeEmployee(int id, String name, String title, double hours){
        super(id, name, title);
        this.hours = hours;
        //add to csv file
    }

    public PartTimeEmployee(){
        super();
    }

    public int getId(){
        return id;
    } public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    } public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return title;
    } public void setTitle(String title){
        this.title = title;
    }

    public double getHours(){
        return hours;
    } public void setHours(double hours){
        this.hours = hours;
    }

    public String getPartTimeRate(String title){
        //calls csv read parttime file method
    }

    @Override
    public String toString(){
        return super.toString() + "Salary type: Part-time" + "\n";
    }

}
