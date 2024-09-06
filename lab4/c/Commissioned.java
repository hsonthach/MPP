package lab4.c;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
    private double commission;
	private double baseSalary;
    private List<Order> orders;
    
	public Commissioned(String empId, double commission, double baseSalary) {
		super(empId);
        this.commission = commission;
		this.baseSalary = baseSalary;
        this.orders = new ArrayList<Order>();
	}
	
	public void addOrder(Order order) {
        orders.add(order);
    }

	@Override
	public double calcGrossPay(int month, int year) {
		double orderTotal = 0;
		int length = orders.size();
		for (int i = 0; i < length; i++) {
			Order order = orders.get(i);
			LocalDate orderDate = order.getOrderDate();
			if (!(orderDate.getMonthValue() == month && orderDate.getYear() == year)) { continue; }
			orderTotal += order.getOrderAmount();
		}
		
		return baseSalary + commission * orderTotal;
	}
}
