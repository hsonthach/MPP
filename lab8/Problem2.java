package lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2 {
	public static enum SortBy { BYPRICE, BYTITLE };
	
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>(Arrays.asList(
			new Product("Tesla", 45000d, 1), new Product("HRV", 38000d, 1), new Product("Camry", 29000d, 1),
			new Product("HRV", 37000d, 2)
		));
		
		System.out.println("a. By Price");
		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		System.out.println(products);
		System.out.println();
		
		System.out.println("b. By Title");
		Collections.sort(products, (p1, p2) -> p1.getTitle().compareTo(p2.getTitle()));
		System.out.println(products);
		System.out.println();

		System.out.println("c. By Price");
		sort(products, SortBy.BYPRICE);
		System.out.println(products);
		System.out.println();

		System.out.println("c. By Title");
		sort(products, SortBy.BYTITLE);
		System.out.println(products);
		System.out.println();
		
		System.out.println("d. By Title and Model");
		Collections.sort(products, (p1, p2) -> {
			int titleOrder = p1.getTitle().compareTo(p2.getTitle());
			if (titleOrder == 0) {
				return Integer.compare(p1.getModel(), p2.getModel());
			}
			return titleOrder;
		});
		System.out.println(products);
		System.out.println();
	}
	
	public static void sort(List<Product> products, SortBy s) {
		Collections.sort(products, (p1, p2) -> {
			int result = 0;
			if (s == SortBy.BYPRICE) {
				result = Double.compare(p1.getPrice(), p2.getPrice());
			}
			else if (s == SortBy.BYTITLE) {
				result = p1.getTitle().compareTo(p2.getTitle());
			}
			
			return result;
		});
	}
}
