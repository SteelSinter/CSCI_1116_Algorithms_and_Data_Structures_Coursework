import java.util.LinkedList;
import java.util.List;

public class Exercise22_1 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String str = input.nextLine();
		
		System.out.println("Max consecutive substring: " + maxString(str));

	}
	
	public static String maxString(String str) {
		LinkedList<Character> result = new LinkedList<Character>();
		LinkedList<Character> current = new LinkedList<Character>();
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (current.size() > 1 && currentChar <= current.getLast() && current.contains(currentChar)) {
				current.clear();
			}
			current.add(currentChar);
			if (current.size() > result.size()) {
				result.clear();
				result.addAll(current);
			}
		}
		for (char c: result) {
			s = s + c;
		}
		return s;
	}

}
