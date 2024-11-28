import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVRead {

    private final String filePath;

    Scanner input; //scanner object for reading file

    public CSVRead(String filePath) {
        this.filePath = filePath;
    }

    public String[] getValues(){
        String[] tokens; //new array
        String line = input.nextLine(); //skips header line
        tokens = line.split(","); //tokens = array of values in current line
        return tokens;
    }

    public ArrayList<String> readHistoricPayslips(){
        ArrayList<String> allData = new ArrayList<String>(); //new arraylist of strings
        while(input.hasNext()){ //while there is more data in file
            allData.add(input.nextLine()); //add line to list
        }
        return allData; //returns all data in file as an arraylist
    }

    //assumes file is of form tokens[0] = title, tokens[1] = scale number(years), tokens[2] = salary rate
   public String readSalary(String title, int scalePoint) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Skip the header row
            if (scanner.hasNextLine()) {
                scanner.nextLine();  // This skips the first row (header)
            }

            //iterate through the rest of the rows
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); // Assumes CSV is comma-separated
                if (parts.length == 3) {
                    String payscaleDescription = parts[0].trim();
                    int fileScalePoint = Integer.parseInt(parts[1].trim());
                    String annualRate = parts[2].trim();

                    //match the title and scale point
                    if (payscaleDescription.equals(title) && fileScalePoint == scalePoint) {
                        return annualRate; // Return the matching salary
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("CSV file not found at " + filePath);
        } catch (Exception e) {
            System.err.println("Error reading salary: " + e.getMessage());
        }

        throw new FileNotFoundException("No matching salary found for title: " + title + " and scale point: " + scalePoint);
    }

    public String[] readEmployeeDetails(Employee employee){
        String header = input.nextLine();
        while(input.hasNext()){
            String[] tokens = getValues();
            int id = employee.getId();
            if(tokens[0].equals(id)){
                return tokens;
            }
        }
        return new String[0];
    }

    public String[] getMostRecentPayslip(Employee employee) {
        String header = input.nextLine();

        String[] currentTokens = null;
        if (!input.hasNext()) {
            currentTokens = getValues();
        }
        return currentTokens;
    }

    public void close(){
        input.close();
    }

}
