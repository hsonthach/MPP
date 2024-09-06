package lab4.c;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Commissioned cm = new Commissioned("123", 0.8, 500);
		cm.addOrder(new Order("100", LocalDate.of(2023, 2, 1),200));
		cm.addOrder(new Order("100", LocalDate.of(2023, 2, 10),100));
		Employee[] emp = { new Salaried("121", 4000), new Hourly("122", 15.67, 20), cm};
		for(Employee e :emp){
			e.print(3, 2023);
			System.out.println();
		}
	}
}
