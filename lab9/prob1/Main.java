package lab9.prob1;

import java.util.List;

public final class Main {
	public static void main(String[] args) {
		List<String> words = List.of("apple", "banana", "cherry", "durian", "orange", "grape");
        char c = 'a';
        char d = 'r';
        int len = 5;

        int result = countWords(words, c, d, len);
        System.out.println(result);
	}
	
	public static int countWords(List<String> words, char c, char d, int len) {
		return (int) words.stream()
			.filter(word -> word.length() == len)
			.filter(word -> word.indexOf(c) >= 0)
			.filter(word -> word.indexOf(d) < 0)
			.count();
	}
}
