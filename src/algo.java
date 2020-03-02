

public class algo {
	
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
		final long startTime = System.currentTimeMillis();
		int ans = alg(a,b);
		final long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(ans);
		System.out.println("the time taken" + elapsedTime);
		
	}
}