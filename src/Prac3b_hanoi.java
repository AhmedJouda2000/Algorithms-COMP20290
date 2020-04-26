/**
 * The {@code Prac3b_Hanoi} class implements an algorithm that returns the
 * needed steps to move a specified number of disks between three rods (A to C).
 *
 * @author Ahmed Jouda
 */
public class Prac3b_hanoi {
	// Recursive function to solve tower of Hanoi puzzle and help junior monks end
	// the world
	static void towerOfHanoi(int n, char first_rod, char middle_rod, char final_rod) {
		// Base case: No disks
		if (n == 0) {
			System.out.println("No disks to move");
			return;
		}
		// Base case: if there is only one disk, move it normally from first to final
		// rod
		if (n == 1) {
			System.out.println("Move disk 1 from rod " + first_rod + " to rod " + final_rod);
			return;
		}
		// else move everything above it to the middle rod
		towerOfHanoi(n - 1, first_rod, final_rod, middle_rod);
		// move the bottom disk from first to final rod
		System.out.println("Move disk " + n + " from rod " + first_rod + " to rod " + final_rod);
		// move everything from the the middle rod to the final rod
		towerOfHanoi(n - 1, middle_rod, first_rod, final_rod);
	}

	// Main method
	public static void main(String args[]) {

		// Testing different disk numbers
		System.out.println("   Test using two disks");
		int n = 2; // Number of disks
		towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
		System.out.println("_____________________________________");
		System.out.println("   Test using three disks");
		n = 3; // Number of disks
		towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
		System.out.println("_____________________________________");
		System.out.println("   Test using five disks");
		n = 5; // Number of disks
		towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
		System.out.println("_____________________________________");
		System.out.println("   Test using five disks");
		n = 0; // Number of disks
		towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods
	}
}
