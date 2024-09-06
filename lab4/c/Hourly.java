package lab4.c;

public class Hourly extends Employee {
	private double hourlyWage;
    private int hoursPerWeek;
    
	public Hourly(String empId, double hourlyWage, int hoursPerWeek) {
		super(empId);
		this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
	}

	@Override
	public double calcGrossPay(int month, int year) {
		// assuming 4 weeks per month
		return hourlyWage * hoursPerWeek * 4;
	}
}
