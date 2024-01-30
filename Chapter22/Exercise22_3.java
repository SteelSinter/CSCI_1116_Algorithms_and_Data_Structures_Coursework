
public class Exercise22_3 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		String s1, s2;
		
		System.out.println("Enter s1: ");
		s1 = input.nextLine();
		System.out.println("Enter s2: ");
		s2 = input.nextLine();
		long startTime = System.currentTimeMillis();
		System.out.println(substringOf(s1, s2));
		long endTime = System.currentTimeMillis();
		System.out.println("Executed in " + (endTime - startTime) + " milliseconds.");

	}
	
	public static boolean substringOf(String s1, String s2) {
		String result = s1.replaceFirst(s2, s2);
		if (result.equals(s1)) {
			return true;
		}
		return false;
	}

}
