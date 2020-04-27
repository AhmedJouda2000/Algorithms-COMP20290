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
			System.out.println("Enter 1 for Russian's Peasant    [Practical 1]");
			System.out.println("Enter 2 for Fibonnaci Numbers    [Practical 3]");
			System.out.println("Enter 3 for Towers of Hanoi      [Practical 3]");
			System.out.println("Enter 4 for Insertion Sort       [Practical 4]");
			System.out.println("Enter 5 for Selection Sort       [Practical 4]");
			System.out.println("Enter 6 for Bogo Sort            [Practical 4]");
			System.out.println("Enter 7 for Merge Sort           [Practical 5]");
			System.out.println("Enter 8 for Improved Merge Sort  [Practical 5]");
			System.out.println("Enter 9 for Quick Sort           [Practical 6]");
			System.out.println("Enter 10 for Improved Quick Sor  [Practical 6]");
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
				System.out.println("*Note: For timed perfomance test check Prac3a_fib.java");
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
				
			case 4:
				// Insertion sort - Prac4
				System.out.println("You selected Insertion Sort");
				System.out.println("Let us test a sample array:");
				int arr[] = { 12, 11, 13, 5, 6 };
				Prac4and5and6.printArray(arr);
				System.out.println("Expected outcome:");
				System.out.println("5 6 11 12 13");
				System.out.println("Actual outcome: ");
				Prac4and5and6.insertionSort(arr);
				Prac4and5and6.printArray(arr);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;
				
			case 5:
				// Selection sort - Prac4
				System.out.println("You selected Selection Sort");
				System.out.println("Let us test a sample array:");
				int arr2[] = { 25, 11, 15, 2, 3 };
				Prac4and5and6.printArray(arr2);
				System.out.println("Expected outcome:");
				System.out.println("2 3 11 15 25");
				System.out.println("Actual outcome: ");
				Prac4and5and6.selectionSort(arr2);
				Prac4and5and6.printArray(arr2);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;
				
			case 6:
				// Bogo sort - Prac4
				System.out.println("You selected Bogo Sort");
				System.out.println("Let us test a sample array:");
				int arr3[] = { 4, 12, 15, 7, 3 };
				Prac4and5and6.printArray(arr3);
				System.out.println("Expected outcome:");
				System.out.println("3 4 7 12 15");
				System.out.println("Actual outcome: ");
				Prac4and5and6.bogoSort(arr3);
				Prac4and5and6.printArray(arr3);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;
				
			case 7:
				// Merge sort - Prac5
				System.out.println("You selected Merge Sort");
				System.out.println("Let us test a sample array:");
				int arr4[] = { 13, 19, 60, 4, 12, 15, 7, 3 };
				Prac4and5and6.printArray(arr4);
				System.out.println("Expected outcome:");
				System.out.println("3 4 7 12 13 15 19 60");
				System.out.println("Actual outcome: ");
				Prac4and5and6.mergeSort(arr4);
				Prac4and5and6.printArray(arr4);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;
				
			case 8:
				// Merge sort - Prac5
				System.out.println("You selected Improved Merge Sort");
				System.out.println("Let us test a sample array:");
				int arr5[] = { 3, 5, 2, 1, 1, 10, 25, 40, 9, 20 };
				Prac4and5and6.printArray(arr5);
				System.out.println("Expected outcome:");
				System.out.println("1 1 2 3 5 9 10 20 25 40");
				System.out.println("Actual outcome: ");
				Prac4and5and6.improvedMergeSort(arr5);
				Prac4and5and6.printArray(arr5);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;
				
			case 9:
				// Quick sort - Prac6
				System.out.println("You selected Quick Sort");
				System.out.println("Let us test a sample array:");
				int arr6[] = { 3, 29, 67, 14, 23, 20, 57, 1, 3, 44 };
				Prac4and5and6.printArray(arr6);
				System.out.println("Expected outcome:");
				System.out.println("1 3 3 14 20 23 29 44 57 67");
				System.out.println("Actual outcome: ");
				Prac4and5and6.quickSort(arr6);
				Prac4and5and6.printArray(arr6);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;
				
			case 10:
				// Merge sort - Prac5
				System.out.println("You selected Improved Quick Sort");
				System.out.println("Let us test a sample array:");
				int arr7[] = { 29, 60, 4, 72, 17, 12, 15, 6, 7, 23, 18, 19, 68};
				Prac4and5and6.printArray(arr7);
				System.out.println("Expected outcome:");
				System.out.println("4 6 7 12 15 17 18 19 23 29 60 68 72");
				System.out.println("Actual outcome: ");
				Prac4and5and6.improvedQuickSort(arr7);
				Prac4and5and6.printArray(arr7);
				System.out.println("*Note: For extensive timed tests check Prac4and5and6.java");
				break;

			default:
				System.out.println("Invalid Option, try again");
				break;
			}
			
		}
		sc.close();
	}

}
