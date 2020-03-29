
public class Prac7 {
	
	
	// brute force method
	public static void bruteForceSearch(String text, String pattern) {

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
				System.out.println("Pattern at index: " + i);	//print position where the match was found in text - stops at 1st occurrence of pattern
			}
		}
				
	}
	
	//part 2
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
		long startBFtime = 0;
		long endBFtime = 0;
		long BFtotal = 0;
		String patString = null;
		String txtString = null;
		//Pattern at start:
		startBFtime = System.nanoTime();
		txtString = "AHMEDJOUDASTUDIESCOMPUTERSCIENCE";
		patString = "AHMEDJOUDA";
		bruteForceSearch(txtString, patString);
		endBFtime = System.nanoTime();
		BFtotal = endBFtime - startBFtime;
		System.out.println("BF Time: " + BFtotal);
		
		//No pattern in text:
		startBFtime = System.nanoTime();
		txtString = "AHMEDJOUDASTUDIESCOMPUTERSCIENCE";
		patString = "AHMEDALI";
		bruteForceSearch(txtString, patString);
		endBFtime = System.nanoTime();
		BFtotal = endBFtime - startBFtime;
		System.out.println("BF Time: " + BFtotal);
		
		//Pattern in the middle:
		startBFtime = System.nanoTime();
		txtString = "STUDIESAHMEDJOUDACOMPUTERSCIENCE";
		patString = "AHMEDJOUDA";
		bruteForceSearch(txtString, patString);
		endBFtime = System.nanoTime();
		BFtotal = endBFtime - startBFtime;
		System.out.println("BF Time: " + BFtotal);
		
		//Pattern at the end(no similar patterns before):
		startBFtime = System.nanoTime();
		txtString = "STUDIESCOMPUTERSCIENCEAHMEDJOUDA";
		patString = "AHMEDJOUDA";
		bruteForceSearch(txtString, patString);
		endBFtime = System.nanoTime();
		BFtotal = endBFtime - startBFtime;
		System.out.println("BF Time: " + BFtotal);
		
		//Pattern at the end(Similar patterns before):
		startBFtime = System.nanoTime();
		txtString = "AHMEDJOUDCOMPUTERSCIENCEAHMEDJOUDA";
		patString = "AHMEDJOUDA";
		bruteForceSearch(txtString, patString);
		endBFtime = System.nanoTime();
		BFtotal = endBFtime - startBFtime;
		System.out.println("BF Time: " + BFtotal);
		
		
		System.out.println("\n\nKNUTH MORRIS PRATT METHOD");
			long startKPMStime = 0;
			long endKPMStime = 0;
			long KPMStotal = 0;
			String txt = null;
			String pat = null;
			//Pattern at start:
			startKPMStime = System.nanoTime();
	  		txt = "AHMEDJOUDASTUDIESCOMPUTERSCIENCE";
	  		pat = "AHMEDJOUDA";
	  		KMPSearch(pat, txt);
	  		endKPMStime = System.nanoTime();
	  		KPMStotal = endKPMStime - startKPMStime;
			System.out.println("KPMS Time: " + KPMStotal);
	  		
	  		//No pattern in text:
			startKPMStime = System.nanoTime();
	  		txt = "AHMEDJOUDASTUDIESCOMPUTERSCIENCE";
	  		pat = "AHMEDALI";
	  		KMPSearch(pat, txt);
	  		endKPMStime = System.nanoTime();
			KPMStotal = endKPMStime - startKPMStime;
			System.out.println("KPMS Time: " + KPMStotal);
	  		
	  		//Pattern in the middle:
	  		startKPMStime = System.nanoTime();
	  		txt = "STUDIESAHMEDJOUDACOMPUTERSCIENCE";
	  		pat = "AHMEDJOUDA";
	  		KMPSearch(pat, txt);
	  		endKPMStime = System.nanoTime();
			KPMStotal = endKPMStime - startKPMStime;
			System.out.println("KPMS Time: " + KPMStotal);
	  		
	  		//Pattern at the end(no similar patterns before):
	  		startKPMStime = System.nanoTime();
	  		txt = "STUDIESCOMPUTERSCIENCEAHMEDJOUDA";
	  		pat = "AHMEDJOUDA";
	  		KMPSearch(pat, txt);
	  		endKPMStime = System.nanoTime();
			KPMStotal = endKPMStime - startKPMStime;
			System.out.println("KPMS Time: " + KPMStotal);
	  		
	  		//Pattern at the end(Similar patterns before):
	  		startKPMStime = System.nanoTime();
	  		txt = "AHMEDJOUDCOMPUTERSCIENCEAHMEDJOUDA";
	  		pat = "AHMEDJOUDA";
	  		KMPSearch(pat, txt);
	  		endKPMStime = System.nanoTime();
			KPMStotal = endKPMStime - startKPMStime;
			System.out.println("KPMS Time: " + KPMStotal);
	}
}
