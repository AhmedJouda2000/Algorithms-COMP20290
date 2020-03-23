import java.util.Random;

public class Prac4and5and6 {
	
	//LAB 6 - IMPROVED QUICK SORT
	public static void improvedQuickSort(int[] values) {
			//shuffle at start to avoid worst case scenario
			knuthShuffle(values);
        	int number = values.length;
        	improvedSort(values, 0, number-1);
        }
	
		public static void improvedSort(int values[], int low, int high) {
			
	        // check for empty array
	        if (values ==null || values.length==0){
	            return;
	        }
	        
	        //Improvement 1 - insertion sort
	        if (values.length <= 10) {
				insertionSort(values);
			}
	        
	        if (high<=low) {
				return;
			}
	        else {
	        	// Sort low, middle, high
	            int middle = ( low + high ) / 2;
	            if( values[ middle ] < values[ low ] )
	                exchange( values, low, middle );
	            if( values[ high ] < values[ low ] )
	                exchange( values, low, high );
	            if( values[ high ] < values[ middle ]  )
	                exchange(values, middle, high );
	        	
	         // Place pivot at position high - 1
	            exchange( values, middle, high - 1 );
	            int pivot = values[ high - 1 ];
	            
	         // Begin partitioning
	            int i = low, j = high;	       

	            // Divide into two lists
	            while (i <= j) {
	                // If the current value from the left list is smaller than the pivot
	                // element then get the next element from the left list
	                while (values[i] < pivot) {
	                    i++;
	                }
	                // If the current value from the right list is larger than the pivot
	                // element then get the next element from the right list
	                while (values[j] > pivot) {
	                    j--;
	                }

	                // If we have found a value in the left list which is larger than
	                // the pivot element and if we have found a value in the right list
	                // which is smaller than the pivot element then we exchange the
	                // values.
	                // As we are done we can increase i and j
	                if (i <= j) {
	                    exchange(values, i, j);
	                    i++;
	                    j--;
	                }
	            }
	             
	            // Restore pivot
	            exchange( values, i, high - 1 );
	            
	        	improvedSort(values, low, i-1);
	        	improvedSort(values, i+1, high);
	    		
	    	}
	    		
	        }
		
		
	
	
	//Improvement 2 - Shuffle to avoid worst case
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
	
	
	//LAB 6 - QUICK SORT
	public static void quickSort(int[] values) {
        // check for empty array
        if (values ==null || values.length==0){
            return;
        }
    
        int number = values.length;
        sort(values, 0, number - 1);
    }

    private static void sort(int numbers[], int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[high-1];

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
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
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
		int type = 6; 

					
		///adjust input size to vary size of arrays
		for (int inputSize = 10; inputSize < 100001; inputSize*=10) {
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
			
						//long timeToPrint = System.nanoTime();
						//print sorted array
						//System.out.print("Sorted Array: ");
						//printArray(nums);
						//totalruntime += System.nanoTime() - timeToPrint;
						
						//printout runtime.
						System.out.println("Total run time " + totalruntime);
						
						
					}

				}

}
