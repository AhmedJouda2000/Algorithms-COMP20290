/**
 * The {@code Prac1} class implements the Russian Peasant's algorithm.
 *
 * @author Ahmed Jouda
 */

public class Prac1 {

	// russian peasant method takes two ints and returns an integer result of their
	// multiplication
	public static int russianPeasant(int x, int y) {

		int res = 0; // initialize result to 0
		// while the second number is greater than 0
		while (y > 0) {
			// if the number is even then add nothing
			// if the number is odd then add the first number to the running total
			if (y % 2 != 0) {
				res = res + x;

			}
			// update the two numbers for the next iteration
			x = 2 * x;
			y = y / 2;
		}
		return res;

	}

	public static void main(String[] args) {
		// hard coded ints to test the algorithm
		int a = 68;
		int b = 139;
		int c = 72;
		int d = 12;

		System.out.print("**Example 1**\n68 x 139\nExpected: 9452\nGot: ");
		final long startTime = System.currentTimeMillis();
		int ans = russianPeasant(a, b);
		final long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(ans);
		System.out.println("The time taken: " + elapsedTime);

		System.out.print("\n\n**Example 2**\n72 x 12\nExpected: 864\nGot: ");
		final long startTime2 = System.currentTimeMillis();
		int ans2 = russianPeasant(c, d);
		final long elapsedTime2 = System.currentTimeMillis() - startTime2;
		System.out.println(ans2);
		System.out.println("The time taken: " + elapsedTime2);

		System.out.print("\n\n**Example 3**\n68 x 12\nExpected: 816\nGot: ");
		final long startTime3 = System.currentTimeMillis();
		int ans3 = russianPeasant(a, d);
		final long elapsedTime3 = System.currentTimeMillis() - startTime3;
		System.out.println(ans3);
		System.out.println("The time taken: " + elapsedTime3);

	}

}
