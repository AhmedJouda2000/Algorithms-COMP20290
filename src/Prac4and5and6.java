
/**
 * The {@code Prac4and5and6} class implements six different sort algorithms.
 * A menu is provided in main to allow easy access.
 * Array sizes can be changed.
 * Sorted arrays can be printed, currently they aren't because its time consuming
 *
 * @author Ahmed Jouda
 */
import java.util.Random;
import java.util.Scanner;

public class Prac4and5and6 {

	// LAB 6 - IMPROVED QUICK SORT
	public static void improvedQuickSort(int[] values) {
		// shuffle at start to avoid worst case scenario
		knuthShuffle(values);
		improvedSort(values, 0, values.length - 1);
	}

	public static void improvedSort(int[] values, int left, int right) {
		int size = right - left + 1;
		// cut off for insertion sort
		if (size <= 10)
			insertionSort(values);
		else {
			// set pivot as median of 3
			int pivot = medianOf3(values, left, right);
			// get partition
			int partition = partitionIt(values, left, right, pivot);
			// recursively sort elements before
			// and after partition
			improvedSort(values, left, partition - 1);
			improvedSort(values, partition + 1, right);
		}
	}

	public static int medianOf3(int[] values, int left, int right) {
		int center = (left + right) / 2;

		// order left and center (low and middle)
		if (values[left] > values[center])
			swap(values, left, center);

		// order left and right (low and high)
		if (values[left] > values[right])
			swap(values, left, right);

		// order center and right (middle and high)
		if (values[center] > values[right])
			swap(values, center, right);

		swap(values, center, right - 1); // place pivot on the right
		return values[right - 1]; // return median
	}

	public static int partitionIt(int[] values, int left, int right, double pivot) {
		int leftPtr = left; // pointer to the right of the first int
		int rightPtr = right - 1; // pointer to before the pivot

		while (true) {
			while (values[++leftPtr] < pivot) // find bigger
				;
			while (values[--rightPtr] > pivot) // find smaller
				;
			if (leftPtr >= rightPtr) // if the pointers meet then done
				break;
			else // else swap the elements
				swap(values, leftPtr, rightPtr);
		}
		swap(values, leftPtr, right - 1); // put back the pivot
		return leftPtr;
	}

	// Improvement 2 - Shuffle to avoid worst case
	public static void knuthShuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			// choose index uniformly in [0, i]
			int r = (int) (Math.random() * (i + 1));
			int swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}

	// LAB 6 - QUICK SORT
	public static void quickSort(int[] values) {
		// check for empty array
		if (values == null || values.length == 0) {
			return;
		}

		int number = values.length;
		sort(values, 0, number - 1);
	}

	private static void sort(int numbers[], int low, int high) {
		int i = low, j = high;
		// Get the pivot element
		int pivot = numbers[high - 1];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller than the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger than the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			if (i <= j) {
				exchange(numbers, i, j);
				i++;
				j--;
			}
		}

		// Call the function recursively
		if (low < j)
			sort(numbers, low, j);
		if (i < high)
			sort(numbers, i, high);
	}

	private static void exchange(int numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	// LAB 5 - IMPROVED MERGESORT
	public static void improvedMergeSort(int a[]) {
		int n = a.length;
		// if size is 1 or less just return
		if (n < 2) {
			return;
		}
		// cut off point for using insertion sort (Optimisation)
		if (n < 10) {
			insertionSort(a);
		}

		// split array into 2 arrays
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}

		// sort each of them
		mergeSort(l);
		mergeSort(r);

		// Check if the sorted arrays are also in sorted order (Optimisation)
		// This is the case if the last element of the left array is <= than the first
		// element of the right array
		// If so concatenate the arrays into original array
		if (l[l.length - 1] <= r[0]) {
			System.arraycopy(l, 0, a, 0, l.length);
			System.arraycopy(r, 0, a, l.length, r.length);
			return;
		}

		// Otherwise sort them together and merge into original array
		merge(a, l, r, mid, n - mid);

	}

	// LAB - 5 MERGESORT
	public static void mergeSort(int[] a) {
		int n = a.length;
		// if size is 1 or less just return
		if (n < 2) {
			return;
		}

		// split array into 2 arrays
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		// sort each of them
		mergeSort(l);
		mergeSort(r);

		// sort them together and merge into original array
		merge(a, l, r, mid, n - mid);
	}

	// The merge function takes in the input and both the sub-arrays and the
	// starting and end indices of both the sub arrays.
	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;

		// compares the elements of both sub-arrays one by one and
		// places the smaller element into the input array.
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}

		// when the end of one of the arrays is reached we add the rest of the other
		// array to the final result
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];

		}
	}

	// LAB 4 - SELECTION SORT
	public static void selectionSort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	// LAB 4 - INSERTION SORT
	public static void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			// Move elements of arr[0..i-1], that are greater than key, to one position
			// ahead of their current position

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	// LAB 4 - SILLY SORT - BOGO
	public static void bogoSort(int[] a) {
		// if array is not sorted then shuffle the
		// array again
		while (isSorted(a) == false)
			shuffle(a);
	}

	// To generate permutation of the array
	public static void shuffle(int[] a) {
		// Math.random() returns a double positive
		// value, greater than or equal to 0.0 and
		// less than 1.0.
		for (int i = 1; i < a.length; i++)
			swap(a, i, (int) (Math.random() * i));
	}

	// Swapping 2 elements
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// To check if array is sorted or not
	public static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				return false;
		return true;
	}

	// Prints the array
	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// generate a random number
	private static Random r = new Random(System.currentTimeMillis());

	public static void main(String args[]) {

		System.out.println("*****Testing in Main*****");
		// use an integer variable to decide which sorting algorithm to use below
		Scanner sc = new Scanner(System.in);
		System.out.print("------------------------------------------------------------------\n");
		System.out.println("\t\tSORTS LIST");
		System.out.println("Enter 0 for Selection Sort          [Practical 4]");
		System.out.println("Enter 1 for Insertion Sort          [Practical 4]");
		System.out.println("Enter 2 for Bogo Sort               [Practical 4]");
		System.out.println("Enter 3 for Merge Sort              [Practical 5]");
		System.out.println("Enter 4 for Improved Merge Sort     [Practical 5]");
		System.out.println("Enter 5 for Quick Sort              [Practical 6]");
		System.out.println("Enter 6 for Improved Quick Sort     [Practical 6]");
		System.out.print("Select which sort you want to run/test: ");

		int type = sc.nextInt();

		/// adjust input size to vary size of arrays
		for (int inputSize = 10; inputSize < 100001; inputSize *= 10) {
			// vary total Runs to give you many empirical tests
			System.out.println("\nInputSize: " + inputSize);

			int totalRuns = 1000;
			System.out.println("Total runs: " + totalRuns);

			long totalruntime = 0;
			int[] nums = null;

			for (int run = 0; run < totalRuns; run++) {

				nums = new int[inputSize];

				for (int i = 0; i < nums.length; i++) {
					nums[i] = r.nextInt(5 * inputSize);
				}

				long time = System.nanoTime();

				switch (type) {
				case 0:
					selectionSort(nums);
					break;

				case 1:
					insertionSort(nums);
					break;

				case 2:
					bogoSort(nums);
					break;

				case 3:
					mergeSort(nums);
					break;

				case 4:
					improvedMergeSort(nums);
					break;

				case 5:
					quickSort(nums);
					break;

				case 6:
					improvedQuickSort(nums);
					break;

				default:
					System.err.printf("Invalid Sort number");
					System.exit(-2);
				}

				totalruntime += System.nanoTime() - time;

			}

			// long timeToPrint = System.nanoTime();
			// print sorted array
			// System.out.print("Sorted Array: ");
			// printArray(nums);
			// totalruntime += System.nanoTime() - timeToPrint;

			// printout runtime.
			System.out.println("Total run time " + totalruntime);

		}
		sc.close();

	}

}
