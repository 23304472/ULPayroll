//Ava
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Promotions {
    //maps each role onto another map which maps a paygrade to its salary
    private Map<String, Map<Integer, Double>> payScaleMap = new HashMap<>();

    //may need another map here connected to promotion path csv?
    //would map a role onto another map that would map a current paygrade to the next paygrade?

    //sets up the promotion system from the paygrade csv
    public Promotions() throws FileNotFoundException {
       loadPayScaleFromCSV("FullTimeRates.csv");

       //
    }

    public void loadPayScaleFromCSV(String fileName) throws FileNotFoundException {
        CSVRead reader = new CSVRead(filename);
        ArrayList<String> data = reader.readToList(); //to get the data from payscale csv

        for(String line: data){
            String[] tokens = line.split(",");
            String title = tokens[0];
            int currentGrade = Integer.parseInt(tokens[1]);
            int nextGrade = Integer.parseInt(tokens[2]);
        }
    }



   // public void promote(Employee employee){
        //int currentGrade = employee.getPayGrade();
        //if(nextPayGrade.containsKey(currentGrade)){ //Checks if a higher paygrade exists or if employee is at the top of their paygrade
           // int newGrade = nextPayGrade.get(currentGrade)+1;
        //}
   // }
}
//implements promotions
//asks staff member to confirm promotion
//THINK WE NEED TO ADD A GETPAYGRADE METHOD TO EMPLOYEE??
//do i need a promotion path csv as well?
//to promote: needs to find the job, check if employee can be promoted and if yes promote the employee
