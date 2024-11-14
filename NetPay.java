// Shaun
public class NetPay extends PaySlip{
    private double salary;
    //salary called from CSV into one of employees then called to here, all deductions then done off of that
    private double prsiRate;
    //4.1%
    private double healthInsuranceRate;
    //
    private double uscRate;
    // if salary greater than 12,012 tax is 0.5%
    // < than 25760 is 2%
    // <70,044 is 4%
    //greater than 70,044 is 8%T
    private double unionFeesRate;
    // 0.8% of salary or 80c for every 100 euro earned
    private double incomeTaxRate;
    // 20% for everything below 42,000, 40% for everything above
    public NetPay(Salary salary){
        double usc = salary/
        double prsi = salary/
        double
    }
}
