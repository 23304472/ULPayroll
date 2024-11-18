import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVWrite {
    PrintWriter writer;

    public CSVWrite(String filename) throws FileNotFoundException{
        writer = new PrintWriter(filename);
    }

    public void addEmployee(int id, String name, String title, LocalDate dateAdded){
        String employeeInfo = id + ", " + name + ", " + title + ", " + dateAdded;
        java.io.File file = new java.io.File("Employees.csv");

        try (PrintWriter writer = new PrintWriter (new FileWriter("Employees.csv", true))){
            if(file.length() == 0) {
                String header = "ID, Name, Title, Date Added";
                header += "\n";
                writer.write(header);
            }
            writer.println(employeeInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addPayslip(double grossPay, double deductions, double netPay){
        String paySlipInfo = grossPay + ", " + deductions + ", " + netPay;

        java.io.File file = new java.io.File("Payslips.csv");

        try(PrintWriter writer = new PrintWriter (new FileWriter("Payslips.csv", true))){
            if(file.length() == 0) {
                String header = "Gross Pay, Deductions, Net Pay";
                header += "\n";
                writer.write(header);
            }
            writer.println(paySlipInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //write to employee file
    //write to payslip file
    //set method should change value in csv file
}
