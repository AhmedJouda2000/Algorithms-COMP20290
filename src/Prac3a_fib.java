
public class Prac3a_fib {
	public static int fibRecursion(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1 || i == 2) {
			return 1;
		}
		return fibRecursion(i-2) + fibRecursion(i-1);
	}
	
	static int fibonacciIterative(int n){
		  if (n<=1)
		      return 1; 

		  int fib = 1;
		  int prevFib =  1;

		  for (int i = 2; i < n; i++) {
		   int temp = fib;
		   fib = fib + prevFib;
		   prevFib = temp;
		  }
		  return fib;
		 }

	
	public static void main(String[] args) {
		int maxNumber = 10;
		System.out.print("Recursive series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i)+ " ");
		}
		System.out.println("\n\nIterative: "+fibonacciIterative(maxNumber)); 
	}
}

