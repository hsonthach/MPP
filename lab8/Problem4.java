package lab8;

import java.util.Arrays;
import java.util.List;

//Problem 4:
//String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
//a. Use Arrays.sort() to sort the names by ignore case using Method reference.
//b. Convert the sorted names array into List.
//c. Print the sorted list using method reference.
public class Problem4 {
    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen", "Kristy"};
        // a. Use Arrays.sort() to sort the names by ignore case using Method reference.
        Arrays.sort(names, String::compareToIgnoreCase);
        // b. Convert the sorted names array into List.
        List<String> sortedNames = Arrays.asList(names);
        // c. Print the sorted list using method reference.
        sortedNames.forEach(System.out::println);
    }
}
