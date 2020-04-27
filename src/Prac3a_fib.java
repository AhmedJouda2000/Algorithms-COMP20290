
/**
 * The {@code Prac3a_fib} class implements two algorithms that return the
 * fibonacci numbers, one is recursive the other is iterative.
 *
 * @author Ahmed Jouda
 */

public class Prac3a_fib {

	// Recursive fibonacci method, returns the ith fibonacci number
	public static int fibRecursion(int i) {
		// Base case 1
		if (i == 0) {
			return 0;
		}
		// Base case 2
		if (i == 1 || i == 2) {
			return 1;
		}
		// recursive call
		return fibRecursion(i - 2) + fibRecursion(i - 1);
	}

	// Iterative fibonacci method, returns the ith fibonacci number
	static int fibonacciIterative(int n) {
		// if its at position one or less return one
		if (n <= 1)
			return 1;
		//else declare the current the first two fibonacci numbers
		int fib = 1;
		int prevFib = 1;
		
		//loop until the required position
		//in each loop, the current fib number is the sum of the previous two.
		for (int i = 2; i < n; i++) {
			int temp = fib;
			fib = fib + prevFib;
			prevFib = temp;
		}
		return fib;
	}

	public static void main(String[] args) {

		// test for first 20 fibonacci numbers using both methods
		//recursive
		int maxNumber = 20;
		System.out.print("Recursive series of " + maxNumber + " numbers: ");
		final long startTime = System.currentTimeMillis();
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i) + " ");
		}
		final long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("\nThe time taken for 20 numbers [RECURSIVELY]: " + elapsedTime);

		//iterative
		System.out.print("\nIterative series of " + maxNumber + " numbers: ");
		final long startTime1 = System.currentTimeMillis();
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}
		final long elapsedTime1 = System.currentTimeMillis() - startTime1;
		System.out.println("\nThe time taken for 20 numbers [ITERATIVELY]: " + elapsedTime1);

		// test for first 30 fibonacci numbers using both methods
		// recursive
		maxNumber = 30;
		System.out.print("\n\nRecursive series of " + maxNumber + " numbers: ");
		final long startTime2 = System.currentTimeMillis();
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i) + " ");
		}
		final long elapsedTime2 = System.currentTimeMillis() - startTime2;
		System.out.println("\nThe time taken for 30 numbers [RECURSIVELY]: " + elapsedTime2);

		//iterative
		System.out.print("\nIterative series of " + maxNumber + " numbers: ");
		final long startTime3 = System.currentTimeMillis();
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}
		final long elapsedTime3 = System.currentTimeMillis() - startTime3;
		System.out.println("\nThe time taken for 30 numbers [ITERATIVELY]: " + elapsedTime3);

		// test for first 40 fibonacci numbers using both methods
		//recursive
		maxNumber = 40;
		System.out.print("\n\nRecursive series of " + maxNumber + " numbers: ");
		final long startTime4 = System.currentTimeMillis();
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i) + " ");
		}
		final long elapsedTime4 = System.currentTimeMillis() - startTime4;
		System.out.println("\nThe time taken for 40 numbers [RECURSIVELY]: " + elapsedTime4);

		//iterative
		System.out.print("\nIterative series of " + maxNumber + " numbers: ");
		final long startTime5 = System.currentTimeMillis();
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}
		final long elapsedTime5 = System.currentTimeMillis() - startTime5;
		System.out.println("\nThe time taken for 40 numbers [ITERATIVELY]: " + elapsedTime5);
	}
}
