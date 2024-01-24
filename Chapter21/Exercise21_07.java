import java.util.*;
import java.util.*;
public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		ArrayList<WordOccurrence> list = new ArrayList<WordOccurrence>();
		
		map.forEach((k, v) -> list.add(new WordOccurrence(k, v)));
		
		Collections.sort(list);

		// Display key and value for each entry
		System.out.println("Before:");
		map.forEach((k, v) -> System.out.println(k + "\t" + v));
		
		System.out.println("After:");
		for (WordOccurrence s: list) {
			System.out.println(s);
		}
	}
}

class WordOccurrence implements Comparable<WordOccurrence> {
	String word;
	int count;
	
	WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	@Override
	public int compareTo(WordOccurrence wo) {
		return Integer.compare(count, wo.count);
	}
	
	@Override
	public String toString() {
		return word + "\t" + count;
	}
}