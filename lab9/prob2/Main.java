package lab9.prob2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Main {
	public static void main(String[] args) {
		printSquares(4);
	}
	
	public static void printSquares(int num) {
		var result = IntStream.iterate(1, n -> n + 1)
			.limit(num)
			.map(n -> n * n)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(", "));
		System.out.println(result);
	}
}
