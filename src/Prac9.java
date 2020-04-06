
public class Prac9 {
	public static void printRLE(String input) {
		
		//loop through the chars in the input string starting at first char
		for (int i = 0; i < input.length(); i++) {

			//Create a counter for the occurrences of current character
			int count = 1;
			while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
				count++; //keep incrementing as long as u see the same char in a row
				i++; 
			}

			// Print character and its count
			System.out.print(input.charAt(i));
			System.out.print(count);
		}
	}

	public static void main(String[] args) {
		String input = "wwwwaaadexxxxxxywww";
		printRLE(input);
	}
	
	
}
