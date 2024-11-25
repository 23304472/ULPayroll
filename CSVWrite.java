import java.io.*;
import java.time.LocalDate;

public class CSVWrite {

    public CSVWrite(){
        //constructor
    }

    public void addEmployee(int id, String name, String title, LocalDate dateAdded){
        String employeeInfo = id + ", " + name + ", " + title + ", " + dateAdded; //info to be added
        File file = new File("Employees.csv"); //reference to file

        try (PrintWriter writer = new PrintWriter (new FileWriter("Employees.csv", true))){ //'true' sets file to append mode
            if(file.length() == 0) { //if file is empty
                String header = "ID, Name, Title, Date Added"; //adds header
                header += "\n"; //goes to next line
                writer.write(header);
            }
            writer.println(employeeInfo); //adds employee info
        } catch (IOException e) {
            System.err.println("IO error encountered"); //returns runtime exception if new file cant be created
        }
    }

    public void addPayslip(Payslip payslip){
        String paySlipInfo = payslip.getGrossPay() + ", " + payslip.getPrsiRate() + ", " + payslip.getHealthInsuranceRate() + ", " + payslip.getUscRate() + ", " + payslip.getUnionFeesRate() + ", " + payslip.getIncomeTax() + ", " + payslip.getNetPay(); //info to be added

        File file = new File("Payslips.csv"); //creates new file

        try(PrintWriter writer = new PrintWriter (new FileWriter("Payslips.csv", true))){ //opens in append mode
            if(file.length() == 0) { //if file is empty
                String header = "Gross Pay, PRSI Rate, Health Insurance Rate, USC Rate, Union Fees Rate, Income Tax Rate, Net Pay"; //creates header
                header += "\n"; //goes to next line
                writer.write(header); //adds header
            }
            writer.println(paySlipInfo); //adds payslip info
        } catch (IOException e) {
            System.err.println("IO error encountered");
        }
    }

    public void addPayClaimForm(int id, String title, double hours, LocalDate dateAdded){
        String payClaimFormInfo = id + ", " + title + ", " + hours + ", " + dateAdded;
        File file = new File("PayClaimForms.csv");//creates new file

        try(PrintWriter writer = new PrintWriter(new FileWriter("PayClaimForms.csv", true))){
            if(file.length() == 0){
                String header = "ID, Title, Hours, Date Submitted"; //creates header
                header += "\n"; //goes to next line
                writer.write(header); //writes header
            }
            writer.println(payClaimFormInfo); //adds employee info
        } catch (IOException e){
            System.err.println("IO error encountered"); //handles error
        }
    }




}
