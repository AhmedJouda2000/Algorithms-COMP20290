

public class Prac1 {
	
	public static int alg(int x, int y) {
		
		int res = 0;
		while(y>0) {
			if (y%2 != 0) {
				res = res + x;
				
			}
			x = 2*x;
			y = y/2;
		}
		return res;
		
	}
	public static void main(String[] args) {
		int a = 68;
		int b = 139;
		int c = 72;
		int d = 12;
		
		System.out.print("**Example 1**\n68 x 139\nExpected: 9452\nGot: ");
		final long startTime = System.currentTimeMillis();
		int ans = alg(a,b);
		final long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(ans);
		System.out.println("The time taken: " + elapsedTime);
		
		System.out.print("\n\n**Example 2**\n72 x 12\nExpected: 864\nGot: ");
		final long startTime2 = System.currentTimeMillis();
		int ans2 = alg(c,d);
		final long elapsedTime2 = System.currentTimeMillis() - startTime2;
		System.out.println(ans2);
		System.out.println("The time taken: " + elapsedTime2);
		
		System.out.print("\n\n**Example 3**\n68 x 12\nExpected: 816\nGot: ");
		final long startTime3 = System.currentTimeMillis();
		int ans3 = alg(a,d);
		final long elapsedTime3 = System.currentTimeMillis() - startTime3;
		System.out.println(ans3);
		System.out.println("The time taken: " + elapsedTime3);
		
	}
	
}
