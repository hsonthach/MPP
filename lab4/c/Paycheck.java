package lab4.c;

public class Paycheck {
	private final double grossPay;
    private final double fica = 0.23;
    private final double state = 0.05;
    private final double local = 0.01;
    private final double medicare = 0.03;
    private final double socialSecurity = 0.075;
    
    public Paycheck(double grossPay) {
        this.grossPay = grossPay;
    }
    
    public double getNetPay() {
        double deductions = fica + state + local + medicare + socialSecurity;
        return grossPay - (grossPay * deductions);
    }
    
    public void print() {
        System.out.println("Paystub:");
        System.out.println("  Gross Pay: " + grossPay);
        System.out.println("  Fica: " + fica);
        System.out.println("  State: " + state);
        System.out.println("  Local: " + local);
        System.out.println("  Medicare: " + medicare);
        System.out.println("  Social Security: " + socialSecurity);
        System.out.println("  NET PAY: " + getNetPay());
    }
}
