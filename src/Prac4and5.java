import java.util.Random;

public class Prac4and5 {
	
	//LAB 5 - IMPROVED MERGESORT
	public static void improvedMergeSort(int a[]) {
		int n = a.length;
	    if (n < 2) {
	        return;
	    }
	    if (n<10) {
			insertionSort(a);
		}
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l);
	    mergeSort(r);
	    
	    if (!(a[mid+1]<a[mid])) {
			return;
		}
	    
	    merge(a, l, r, mid, n - mid);
	    
	}
	
	//LAB - 5 MERGESORT
	public static void mergeSort(int[] a) {
		int n = a.length;
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l);
	    mergeSort(r);
	 
	    merge(a, l, r, mid, n - mid);
	}
	
	public static void merge(
			int[] a, int[] l, int[] r, int left, int right) {
			
			int i = 0, j = 0, k = 0;
			while (i < left && j < right) {
				if (l[i] <= r[j]) {
					a[k++] = l[i++];
				}
				else{
				a[k++] = r[j++];
				}
			}
			while (i < left) {
					a[k++] = l[i++];
			}
			while (j<right) {
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

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	// LAB 4 - SILLY SORT - BOGO
	public static void bogoSort(int[] a) 
    { 
        // if array is not sorted then shuffle the 
        // array again 
        while (isSorted(a) == false) 
            shuffle(a); 
    } 
  
    // To generate permutation of the array 
    public static void shuffle(int[] a) 
    { 
         // Math.random() returns a double positive 
         // value, greater than or equal to 0.0 and 
         // less than 1.0. 
         for (int i=1; i < a.length; i++) 
             swap(a, i, (int)(Math.random()*i)); 
    } 
  
    // Swapping 2 elements 
    public static void swap(int[] a, int i, int j) 
    { 
        int temp = a[i]; 
        a[i] = a[j]; 
        a[j] = temp; 
    } 
  
    // To check if array is sorted or not 
    public static boolean isSorted(int[] a) 
    { 
        for (int i=1; i<a.length; i++) 
            if (a[i] < a[i-1]) 
                return false; 
        return true; 
    } 
    
    
	// Prints the array
	private static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	
	//generate a random number
	private static Random r = new Random(System.currentTimeMillis());
	public static void main(String args[]) { 

		System.out.println("*****Testing in Main*****");
		//use an integer variable to decide which sorting algorithm to use below
		int type = 0; 

					
		///adjust input size to vary size of arrays
		for (int inputSize = 10; inputSize < 1001; inputSize*=10) {
		//vary total Runs to give you many empirical tests
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
								
								default:
									System.err.printf("Invalid Sort number");
									System.exit(-2);
							}


							totalruntime += System.nanoTime() - time;

						}
			
						long timeToPrint = System.nanoTime();
						//print sorted array
						System.out.print("Sorted Array: ");
						printArray(nums);
						totalruntime += System.nanoTime() - timeToPrint;
						
						//printout runtime.
						System.out.println("Total run time " + totalruntime);
						
						
					}

				}

}