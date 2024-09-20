package lab9.prob7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
			new Employee("John", "Sims", 110000),
			new Employee("Joe", "Stevens", 200000),
			new Employee("Andrew", "Reardon", 80000),
			new Employee("Joe", "Cummings", 760000),
			new Employee("Steven", "Walters", 135000),
			new Employee("Thomas", "Blake", 111000),
			new Employee("Alice", "Richards", 101000),
			new Employee("Donald", "Trump", 100000));
		
		//your stream pipeline here
		String prob7a = list.stream()
			.filter(e -> e.getSalary() > 100000)
			.filter(e -> e.getLastName().charAt(0) >= 'N' && e.getLastName().charAt(0) <= 'Z')
			.map(e -> e.getFirstName() + " " + e.getLastName())
			.sorted()
			.collect(Collectors.joining(", "));
		System.out.println(prob7a);
		
		String prob7b = list.stream()
			.filter(LambdaLibrary.salaryHigherThan(100000))
			.filter(LambdaLibrary.lastNameBeginsFrom('N'))
			.filter(LambdaLibrary.lastNameBeginsTo('Z'))
			.map(LambdaLibrary.selectFullname)
			.sorted()
			.collect(Collectors.joining(", "));
		System.out.println(prob7b);
		
		String prob7b2 = LambdaLibrary.employeesInSalaryRangeAndLastName.apply(list);
		System.out.println(prob7b2);
	}

}
