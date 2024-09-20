package lab9.prob7;

import java.util.List;
import java.util.stream.Collectors;

public final class LambdaLibrary {
	private LambdaLibrary() {}
	
	public static final QuaFunction<List<Employee>, Integer, Character, Character, String> employeesInSalaryRangeAndLastName = (es, salary, from, to) -> es
		.stream()
		.filter(e -> e.getSalary() > salary)
		.filter(e -> e.getLastName().charAt(0) >= from && e.getLastName().charAt(0) <= to)
		.map(e -> e.getFirstName() + " " + e.getLastName())
		.sorted()
		.collect(Collectors.joining(", "));
}
