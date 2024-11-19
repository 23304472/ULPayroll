import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVRead {
    Scanner input; //scanner object for reading file

    public CSVRead(String filename) throws FileNotFoundException{
        input = new Scanner(new File(filename));
    } // opens file for reading

    public String[] getValues(){
        String[] tokens; //new array
        String line = input.nextLine(); //skips header line
        tokens = line.split(","); //tokens = array of values in current line
        return tokens;
    }

    public ArrayList<String> readToList(){
        ArrayList<String> allData = new ArrayList<String>(); //new arraylist of strings
        while(input.hasNext()){ //while there is more data in file
            allData.add(input.nextLine()); //add line to list
        }
        return allData; //returns all data in file as an arraylist
    }

    //assumes file is of form tokens[0] = title, tokens[1] = scale number(years), tokens[2] = salary rate
    public String readSalary(Employee employee){
        String line  = input.nextLine(); //skips header line
        while(input.hasNext()){ //while there is more data in file
            String[] tokens = getValues();
            if((tokens[0].equals(employee.getTitle())) && (Integer.parseInt(tokens[1]) == (ChronoUnit.YEARS.between(employee.getDateAdded(), LocalDate.now())))){
                //check if tokens[0] (title name) = employees title
                // check if service year value matches the difference in years between when employee was created and the time now
                return tokens[2]; //return tokens[2] (salary value)
            }
        }
        input.close();
        return null;
    }
    
    public String[] readEmployeeDetails(Employee employee){
            String header = input.nextLine();
            while(input.hasNext()){
                String[] tokens = getValues();
                String id = String.valueOf(employee.getId());
                if(tokens[0].equals(id)){
                    return tokens;
                }
            }
            return new String[0];
        }
   

}
