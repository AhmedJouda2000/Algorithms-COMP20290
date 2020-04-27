/**
 * The {@code Prac9} class implements an algorithm that takes a string as an
 * argument and returns a compressed version of it.
 *
 * @author Ahmed Jouda
 */
public class Prac9 {
	public static void printRLE(String input) {

		// loop through the chars in the input string starting at first char
		for (int i = 0; i < input.length(); i++) {

			// Create a counter for the occurrences of current character
			int count = 1;
			while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
				count++; // keep incrementing as long as u see the same char in a row
				i++;
			}

			// Print character and its count
			System.out.print(input.charAt(i));
			System.out.print(count);
		}
	}

	public static void main(String[] args) {
		
		//Shows that the encoding works
		String input = "wwwwaaadexxxxxxywww";
		System.out.println("Original String: " + input);
		System.out.print("Compressed String: ");
		printRLE(input);

		//Shows how great this compression can be
		String input2 = "mmmmmmmmmmmmjjjjjjoooooodddduuuuuuuuqqqq";
		System.out.println("\n\nOriginal String: " + input2);
		System.out.print("Compressed String: ");
		printRLE(input2);

		// here clearly RLE is not compressing, in fact its expanding
		// due to no same char followed by itself
		String input3 = "ahmedjouda";
		System.out.println("\n\nOriginal String: " + input3);
		System.out.print("Compressed String: ");
		printRLE(input3);
		
		//More analysis of results in documentation

	}

}
