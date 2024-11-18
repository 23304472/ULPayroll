//Shaun
public class PaySlip {
    //calls net pay
    //toString
    //stores all payslips to csv file

    //employee receives payslip given employee and date
@Override
    public String toString() {
        return "PaySlip Details:\n"
                + "Employee ID: " + employee.getId() + "\n"
                + "Name: " + employee.getName() + "\n"
                + "Title: " + employee.getTitle() + "\n"
                + "Date: " + date + "\n"
                + "Gross Pay: €" + netPayDetails.getGrossPay() + "\n"
                + "Income Tax: €" + netPayDetails.getIncomeTax() + "\n"
                + "USC Rate: " + (netPayDetails.getUscRate() * 100) + "%\n"
                + "Net Pay: €" + netPayDetails.getNetPay() + "\n";
    }
}
