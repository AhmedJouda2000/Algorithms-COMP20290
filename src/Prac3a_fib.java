
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

		// test for first 10 fibonacci numbers using both methods
		int maxNumber = 10;
		System.out.print("Recursive series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i) + " ");
		}

		System.out.print("\nIterative series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}

		// test for first 20 fibonacci numbers using both methods
		maxNumber = 20;
		System.out.print("\n\nRecursive series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i) + " ");
		}

		System.out.print("\nIterative series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}

		// test for first 30 fibonacci numbers using both methods
		maxNumber = 30;
		System.out.print("\n\nRecursive series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibRecursion(i) + " ");
		}

		System.out.print("\nIterative series of " + maxNumber + " numbers: ");
		for (int i = 1; i <= maxNumber; i++) {
			System.out.print(fibonacciIterative(i) + " ");
		}
	}
}
