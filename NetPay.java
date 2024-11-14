// Shaun
public class NetPay extends PaySlip{
    private double grossPay;
    //salary called from CSV into one of employees then called to here, all deductions then done off of that
    private double prsiRate = 4.1%
    //4.1%
    private double healthInsuranceRate = 1600/12
    // 1600 euro /12 for monthly (based on average health insurance rate in Ireland)
    private double uscRate;
    if (grossPay < 12012) {
    uscRate = 0.005 }
    else if (grossPay < 25760) {
    uscRate = 0.02 }
    else if (grossPay < 70044) {
    uscRate = 0.04 }
    else {
    uscRate = 0.08 }
    // if salary less than 12,012 tax is 0.5%
    // <12012 > 25760 is 2%
    // >25760 <70,044 is 4%
    //greater than 70,044 is 8%
    private double unionFeesRate = grossPay * 0.992
    // 0.8% of salary or 80c for every 100 euro earned
    private static double calculateIncomeTax {
        double incomeTaxRate = 0.0;
        double threshold = 42000

        if (grossPay < threshold) {
            incomeTaxRate = 0.20; }
        else {
            double lowerTax = threshold * 0.20;
            double upperTax = (grossPay - threshold) * 0.40;
            incomeTaxRate = lowerTax + upperTax ; 
        }
    // 20% for everything below 42,000, 40% for everything above
    private NetPay(Salary salary){
        double usc = salary/
        double prsi = salary/
        double
    }
}
