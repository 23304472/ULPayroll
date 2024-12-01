import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.text.DecimalFormat;

/**
 * The {@code Payslip} class represents an employee's payslip.
 */
public class Payslip {

    /** The employee associated with the payslip. */
    private Employee employee;

    /** The date of the payslip generation. */
    private LocalDate date;

    /** The gross pay of the employee. */
    private double grossPay;

    /** The PRSI rate for tax calculation. */
    private double prsiRate = 0.041;

    /** The monthly health insurance deduction rate. */
    private double healthInsuranceRate = 1600.0 / 12;

    /** The Universal Social Charge rate. */
    private double uscRate;

    /** The union fees rate for deductions. */
    private double unionFeesRate = 0.008;

    /** The income tax for the employee. */
    private double incomeTax;

    /** The net pay after all deductions. */
    private double netPay;

    /**
     * Constructs a new {@code Payslip} for the specified employee.
     *
     * @param employee the employee associated with this payslip
     * @param csvRead  the CSV reader used to fetch salary details
     * @throws FileNotFoundException if the salary file is not found
     * @throws IllegalArgumentException if the salary for the employee is not found
     */
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

    /**
     * Calculates the USC rate based on the gross pay.
     */
    private void calculateUscRate() {
        if (grossPay < 12012) {
            uscRate = 0.005;  // If gross pay < 12,012, USC is 0.5%
        } else if (grossPay < 25760) {
            uscRate = 0.02;   // If 12,012 <= gross pay < 25,760, USC is 2%
        } else if (grossPay < 70044) {
            uscRate = 0.04;   // If 25,760 <= gross pay < 70,044, USC is 4%
        } else {
            uscRate = 0.08;   // If gross pay >= 70,044, USC is 8%
        }
    }

    /**
     * Calculates the income tax based on the gross pay.
     */
    private void calculateIncomeTax() {
        double threshold = 42000;
        if (grossPay <= threshold) {
            incomeTax = grossPay * 0.20; // 20% tax for gross pay <= 42,000
        } else {
            double lowerTax = threshold * 0.20;
            double upperTax = (grossPay - threshold) * 0.40; // 40% tax for amount above 42,000
            incomeTax = lowerTax + upperTax;
        }
    }

    /**
     * Calculates the net pay after all deductions.
     */
    public void calculateNetPay() {
        netPay = grossPay
                - (grossPay * prsiRate)
                - (grossPay * uscRate)
                - (grossPay * unionFeesRate)
                - incomeTax
                - healthInsuranceRate;
    }

    //getters and setters

    /**
     * Gets the employee used with this payslip.
     *
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Gets the date of this payslip.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the gross pay.
     *
     * @return the gross pay
     */
    public double getGrossPay() {
        return grossPay;
    }

    /**
     * Gets the net pay.
     *
     * @return the net pay
     */
    public double getNetPay() {
        return netPay;
    }

    /**
     * Gets the PRSI rate.
     *
     * @return the PRSI rate
     */
    public double getPrsiRate() {
        return prsiRate;
    }

    /**
     * Gets the USC rate.
     *
     * @return the USC rate
     */
    public double getUscRate() {
        return uscRate;
    }

    /**
     * Gets the union fees rate.
     *
     * @return the union fees rate
     */
    public double getUnionFeesRate() {
        return unionFeesRate;
    }

    /**
     * Gets the income tax.
     *
     * @return the income tax
     */
    public double getIncomeTax() {
        return incomeTax;
    }

    /**
     * Gets the health insurance rate.
     *
     * @return the health insurance rate
     */
    public double getHealthInsuranceRate() {
        return healthInsuranceRate;
    }

    /**
     * Returns a string representation of this payslip.
     *
     * @return a formatted string representing the payslip details
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###.00");
        String formattedNetPay = df.format(netPay);
        return "PaySlip Details:\n" +
                "Employee ID: " + employee.getId() + "\n" +
                "Name: " + employee.getName() + "\n" +
                "Date: " + date + "\n" +
                "Gross Pay: €" + grossPay + "\n" +
                "PRSI Rate: " + (prsiRate * 100) + "%\n" +
                "Income Tax: €" + incomeTax + "\n" +
                "USC Rate: " + (uscRate * 100) + "%\n" +
                "Union Fees Rate: " + (unionFeesRate * 100) + "%\n" +
                "Net Pay: €" + formattedNetPay + "\n";
    }
}

    /*
    TEST CODE FOR PAYSLIP
    public static void main(String[] args) {
        // Create a test Employee
        Employee employee = new Employee(1, "Shaun Purcell");  // basic employee
        double grossPay = 75000.0;  // Example gross pay

        try {
            // Create a Payslip object
            Payslip payslip = new Payslip(employee, grossPay);
            // Print out the payslip details
            System.out.println(payslip);
        } catch (FileNotFoundException e) {
            System.err.println("Error reading salary information: " + e.getMessage());
        }
    }
}
*/
