
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
				return i;	//return position where the match was found in text - stops at 1st occurrence of pattern
			}
		}
		
		return n;		
	}
	
	static void KMPSearch(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int j = 0; // index for pat[] 
  
        // Pre-process the pattern
        computeLPSArray(pat, M, lps); 
  
        int i = 0;
        while (i < N) { 
            if (pat.charAt(j) == txt.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
                System.out.println("Pattern at index: " + (i - j)); 
                j = lps[j - 1]; 
            } 
  
            // mismatch after j matches 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
                // Do not match lps[0..lps[j-1]] characters, 
                // they will match anyway 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            } 
        } 
        
    } 
  
    static void computeLPSArray(String pat, int M, int lps[]) 
    { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
  
        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar 
                // to search step. 
                if (len != 0) { 
                    len = lps[len - 1]; 
  
                    // Also, note that we do not increment 
                    // i here 
                } 
                else // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 
  
   
	//main driver/testing method
	public static void main(String[] args) {
		System.out.println("BRUTE FORCE METHOD");
		String txtString = "AHMEDJJABDUL";
		String patString = "JJ";
		System.out.println("Pattern at index: " + bruteForceSearch(txtString, patString));
		
		System.out.println("KNUTH MORRIS PRATT METHOD");
		String txt = "ABABDABACDABABCABAB"; 
	    String pat = "ABABCABAB"; 
	    KMPSearch(pat, txt);
	}
}
