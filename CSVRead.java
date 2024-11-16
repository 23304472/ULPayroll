import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class CSVRead {
    Scanner input; //scanner object for reading file

    public CSVRead(String filename) throws FileNotFoundException{
        input = new Scanner(new File(filename));
    } // opens file for reading

    public String[] getValues(){
        String[] tokens;
        String line = input.nextLine();
        tokens = line.split(",");
        return tokens;
    }

    public ArrayList<String> readToList(){
        ArrayList<String> allData = new ArrayList<String>(); //Arraylist holds all lines
        while(input.hasNext()){
            allData.add(input.nextLine()); //add line to list
        }
        return allData; //returns all lines
    }

    public ArrayList<Employee> readEmployeeList(){
        int lineNo = 0;
        ArrayList<Employee> employees = new ArrayList<Employee>();
        String header = input.nextLine();

        while(input.hasNext()){
            String[] tokens = getValues();
            employees.add(new Employee(tokens));
        }
        input.close();
        return employees;
    }

    public ArrayList<String> readFullTimeSalary(){
        int lineNo = 0;
        ArrayList<String> fullTimeSalaries = new ArrayList<String>();
        String header = input.nextLine();

        while(input.hasNext()){
            String[] tokens = getValues();
            fullTimeSalaries.add(new String(tokens));
        }
        input.close();
        return fullTimeSalaries;
    }

    public ArrayList<String> readPartTimeSalaries(){
        int lineNo = 0;
        ArrayList<String> partTimeSalaries = new ArrayList<String>();
        String header = input.nextLine();

        while(input.hasNext()){
            String[] tokens = getValues();
            partTimeSalaries.add(new String(tokens));
        }
        input.close();
        return partTimeSalaries;
    }

    public ArrayList<String> readPaySlips(){
        int lineNo = 0;
        ArrayList<String> paySlipDetails = new ArrayList<String>();
        String header = input.nextLine();

        while(input.hasNext()){
            String[] tokens = getValues();
            paySlipDetails.add(new String (tokens));
        }
        input.close();
        return paySlipDetails;
    }

    public ArrayList<String> readHourlyRates(){
        int lineNo = 0;
        ArrayList<String> hourlyRates = new ArrayList<String>();
        String header = input.nextLine();
        while(input.hasNext()){
            String[] tokens = getValues();
            hourlyRates.add(new String(tokens));
        }
        input.close();
        return hourlyRates;
    }
}
