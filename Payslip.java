import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Payslip {
    private Employee employee;
    private LocalDate date;
    private double grossPay;
    private double prsiRate = 0.041;
    private double healthInsuranceRate = 1600.0 / 12;
    private double uscRate;
    private double unionFeesRate = 0.008;
    private double incomeTax;
    private double netPay;

    public Payslip(Employee employee, CSVRead csvRead) throws FileNotFoundException {
        this.employee = employee;
        this.date = LocalDate.now();

        // Use readSalary to get the gross pay
        String salaryString = csvRead.readSalary(employee);
        if (salaryString != null) {
            this.grossPay = Double.parseDouble(salaryString);
        } else {
            throw new IllegalArgumentException("Salary not found for employee: " + employee.getName());
        }
    }

    private void calculateUscRate() {
        if (grossPay < 12012) {
            uscRate = 0.005;             // if gross pay less than 12,012 tax is 0.5%
        } else if (grossPay < 25760) {
            uscRate = 0.02;              // <12012 > 25760 is 2%
        } else if (grossPay < 70044) {
            uscRate = 0.04;              // >25760 <70,044 is 4%
        } else {
            uscRate = 0.08;              //greater than 70,044 is 8%
        }
    }
    private void calculateIncomeTax() {
        double threshold = 42000;
        if (grossPay <= threshold) {
            incomeTax = grossPay * 0.20; // Apply 20% for the entire grossPay
        } else {
            double lowerTax = threshold * 0.20; // Apply 20% for the first 42,000
            double upperTax = (grossPay - threshold) * 0.40; // Apply 40% for the rest
            incomeTax = lowerTax + upperTax;
        }
    }
    public void calculateNetPay() {
        // 20% for everything below 42,000, 40% for everything above
        netPay = grossPay
                - (grossPay * prsiRate)
                - (grossPay * uscRate)
                - (grossPay * unionFeesRate)
                - (grossPay * incomeTax)
                - healthInsuranceRate;
    }

    public Employee getEmployee() {
        return employee;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getNetPay() {
        return netPay;
    }
    public double getGrossPay() {
        return grossPay;
    }
    public double getPrsiRate(){
        return prsiRate;
    }
    public double getUscRate(){
        return uscRate;
    }
    public double getUnionFeesRate(){
        return unionFeesRate;
    }
    public double getIncomeTax(){
        return incomeTax;
    }
    public double getHealthInsuranceRate(){
        return healthInsuranceRate;
    }
    

    @Override
    public String toString() {
        return "PaySlip Details:\n" +
                "Employee ID: " + employee.getId() + "\n" +
                "Name: " + employee.getName() + "\n" +
                "Date: " + date + "\n" +
                "Gross Pay: €" + grossPay + "\n" +
                "Income Tax: €" + incomeTax + "\n" +
                "USC Rate: " + (uscRate * 100) + "%\n" +
                "Net Pay: €" + netPay + "\n";
    }
}
