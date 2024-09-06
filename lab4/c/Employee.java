package lab4.c;

public abstract class Employee {
	private String empId;
    
    public Employee(String empId) {
        this.empId = empId;
    }
    
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void print(int month, int year) {
    	Paycheck paycheck = calcCompensation(month, year);
    	System.out.println("Employee Id: " + empId);
    	paycheck.print();
    }
    
    public Paycheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);
        return new Paycheck(grossPay);
    }
    
    public abstract double calcGrossPay(int month, int year);
}
