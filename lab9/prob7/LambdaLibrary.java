package lab9.prob7;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class LambdaLibrary {
	private LambdaLibrary() {}
	
	public static final Predicate<Employee> salaryHigherThan(int salary){
		return e -> e.getSalary() > salary;
	}
	
	public static final Predicate<Employee> lastNameBeginsFrom(char c){
		return e -> e.getLastName().charAt(0) >= c;
	}
	
	public static final Predicate<Employee> lastNameBeginsTo(char c){
		return e -> e.getLastName().charAt(0) <= c;
	}
	
	public static final Function<Employee, String> selectFullname = e -> e.getFirstName() + " " + e.getLastName();
	
	public static final Function<List<Employee>, String> employeesInSalaryRangeAndLastName = e -> e.stream()
		.filter(LambdaLibrary.salaryHigherThan(100000))
		.filter(LambdaLibrary.lastNameBeginsFrom('N'))
		.filter(LambdaLibrary.lastNameBeginsTo('Z'))
		.map(LambdaLibrary.selectFullname)
		.sorted()
		.collect(Collectors.joining(", "));
}
