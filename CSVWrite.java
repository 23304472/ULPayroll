import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class CSVWrite {
    PrintWriter writer;

    public CSVWrite(String filename) throws FileNotFoundException{
        writer = new PrintWriter(filename);
    }

    public void addEmployee(int id, String name, String title, LocalDate dateAdded){
        String employeeInfo = id + ", " + name + ", " + title + ", " + dateAdded; //info to be added
        java.io.File file = new java.io.File("Employees.csv");

        try (PrintWriter writer = new PrintWriter (new FileWriter("Employees.csv", true))){ //'true' sets file to append mode
            if(file.length() == 0) { //if file is empty
                String header = "ID, Name, Title, Date Added"; //adds header
                header += "\n"; //goes to next line
                writer.write(header);
            }
            writer.println(employeeInfo); //adds employee info
        } catch (IOException e) {
            throw new RuntimeException(e); //returns runtime exception if new file cant be created
        }
    }

    public static void addPayslip(double grossPay, double prsiRate, double healthInsuranceRate, double uscRate, double unionFeesRate, double incomeTax, double netPay){
        String paySlipInfo = grossPay + ", " + prsiRate + ", " + healthInsuranceRate + ", " + uscRate + ", " + unionFeesRate + ", " + incomeTax + ", " + netPay; //info to be added

        java.io.File file = new java.io.File("Payslips.csv"); //creates new file

        try(PrintWriter writer = new PrintWriter (new FileWriter("Payslips.csv", true))){ //opens in append mode
            if(file.length() == 0) { //if file is empty
                String header = "Gross Pay, PRSI Rate, Health Insurance Rate, USC Rate, Union Fees Rate, Income Tax Rate, Net Pay"; //creates header
                header += "\n"; //goes to next line
                writer.write(header); //adds header
            }
            writer.println(paySlipInfo); //adds payslip info
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //write to employee file
    //write to payslip file
    //set method should change value in csv file
}
