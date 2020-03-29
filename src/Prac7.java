
public class Prac7 {

	// brute force method
	public static int bruteForceSearch(String text, String pattern) {

		int n = text.length();
		int m = pattern.length();

		for (int i = 0; i <= n - m; i++) 
		{
			int j;
			for (j = 0; j < m; j++) 
			{
				if (text.charAt(i + j) != pattern.charAt(j)) 
				{
					break;
				}
			}
			if (j == m) 
			{
				return i;	//return position where the match was found in text
			}
		}
		
		return n;		
	}

	
	//main driver/testing method
	public static void main(String[] args) {
		String txtString = "AHMEDJJABDUL";
		String patString = "JJ";
		System.out.print(bruteForceSearch(txtString, patString));
	}
}
