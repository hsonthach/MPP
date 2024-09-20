package lab9.prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class Main {
	public static void main(String[] args) {
		List<Set<String>> sets = new ArrayList<Set<String>>();
		sets.add(new LinkedHashSet<String>(Arrays.asList("A", "B")));
		sets.add(new LinkedHashSet<String>(Arrays.asList("D")));
		sets.add(new LinkedHashSet<String>(Arrays.asList("1", "3", "5")));
		Set<String> result = union(sets);
		System.out.println(result);
	}
	
	private static Set<String> union(List<Set<String>> sets) {
		return sets.stream().reduce(new LinkedHashSet<String>(), (acc, s) -> { acc.addAll(s); return acc;});
	}
}
