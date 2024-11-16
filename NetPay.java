// Shaun
public class NetPay extends Payslip {
    private double grossPay;
    //salary called from CSV into one of employees then called to here, all deductions then done off of that
    private double prsiRate = 0.041;                 //4.1%
    private double healthInsuranceRate = 1600.0 / 12;  // 1600 euro a year (based on average health insurance rate in Ireland)
    private double uscRate;
    private double unionFeesRate = 0.008;            // 0.8% of salary or 80c for every 100 euro earned
    private double incomeTax;

    public void calculateUscRate() {
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

    public void calculateIncomeTax() {
        double threshold = 42000;
        if (grossPay <= threshold) {
            incomeTax = grossPay * 0.20; // Apply 20% for the entire grossPay
        } else {
            double lowerTax = threshold * 0.20; // Apply 20% for the first 42,000
            double upperTax = (grossPay - threshold) * 0.40; // Apply 40% for the rest
            incomeTax = lowerTax + upperTax;
        }
    }
    private double netPay;
    public void calculateNetPay() {
        // 20% for everything below 42,000, 40% for everything above
        netPay = grossPay
                - (grossPay * prsiRate)
                - (grossPay * uscRate)
                - (grossPay * unionFeesRate)
                - incomeTax
                - healthInsuranceRate;
    }
    // getters and setters
    public double getGrossPay() {
        return grossPay;
    }
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }
    public double getNetPay() {
        return netPay;
    }
    public double getIncomeTax(){
        return incomeTax;
    }
    public double getUscRate(){
        return uscRate;
    }
}
