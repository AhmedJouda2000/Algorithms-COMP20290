import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.print(
				"ALGORITHMS REPOSITORY\nAuthor: Ahmed Jouda\nThis includes some but not all the functionality of the repository\n");
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while (done == false) {
			System.out.print("------------------------------------------------------------------\n");
			System.out.println("\t\tPROGRAMS LIST");
			System.out.println("Enter 1 for Russian's Peasant [Practical 1]");
			System.out.println("Enter 2 for Fibonnaci Numbers [Practical 3]");
			System.out.println("Enter 3 for Towers of Hanoi   [Practical 3]");
			System.out.println("Enter 0 to exit");
			System.out.print("Select which program you want to run/test: ");
			
			int i = sc.nextInt();
			System.out.println("\t\t***Running***");
			switch (i) {
			case 0:
				done = true;
				System.out.println("\t**Thanks for using my program!**");
				break;
			case 1:
				// Russian Peasant - Prac1
				System.out.println("You selected Russian Peasant's Algorithm");
				System.out.println("The integers 2 and 3 will be passed into it");
				System.out.println("Expected outcome: 6");
				System.out.println("Actual outcome: " + Prac1.russianPeasant(2, 3));
				break;
				
			case 2:
				// Fibonacci Numbers - Prac3a_fib
				System.out.println("You selected Fibonacci Algorithm");
				System.out.println("Lets find the tenth fibonacci number");
				System.out.println("Expected outcome: 55");
				System.out.println("Actual outcome via recursion: " + Prac3a_fib.fibRecursion(10));
				System.out.println("Actual outcome via iteration: " + Prac3a_fib.fibonacciIterative(10));
				break;
				
			case 3:
				// Towers of Hanoi - Prac3b_hanoi
				System.out.println("You selected Towers of Hanoi Algorithm");
				System.out.println("Let us test it using two disks");
				System.out.println("Expected outcome:");
				System.out.println("Move disk 1 from rod A to rod B");
				System.out.println("Move disk 2 from rod A to rod C");
				System.out.println("Move disk 1 from rod B to rod C");
				System.out.println("Actual outcome: ");
				Prac3b_hanoi.towerOfHanoi(2, 'A', 'B', 'C');
				break;

			default:
				System.out.println("Invalid Option, try again");
				break;
			}
			
		}
		sc.close();
	}

}
