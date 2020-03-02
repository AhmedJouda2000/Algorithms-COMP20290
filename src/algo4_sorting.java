import java.sql.Time;

public class algo4_sorting {
	
	//IMPROVED MERGESORT
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
	
	//MERGESORT
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

	// SELECTION SORT
	public void selectionSort(int arr[]) {
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

	// INSERTION SORT
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

	// SILLY SORT - BOGO
	void bogoSort(int[] a) 
    { 
        // if array is not sorted then shuffle the 
        // array again 
        while (isSorted(a) == false) 
            shuffle(a); 
    } 
  
    // To generate permuatation of the array 
    void shuffle(int[] a) 
    { 
         // Math.random() returns a double positive 
         // value, greater than or equal to 0.0 and 
         // less than 1.0. 
         for (int i=1; i <= a.length; i++) 
             swap(a, i, (int)(Math.random()*i)); 
    } 
  
    // Swapping 2 elements 
    void swap(int[] a, int i, int j) 
    { 
        int temp = a[i]; 
        a[i] = a[j]; 
        a[j] = temp; 
    } 
  
    // To check if array is sorted or not 
    boolean isSorted(int[] a) 
    { 
        for (int i=1; i<a.length; i++) 
            if (a[i] < a[i-1]) 
                return false; 
        return true; 
    } 
    
    
	// Prints the array
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		algo4_sorting ob = new algo4_sorting();
		int[] arr = { 10, 12, 9, 10, 2, 15, 14 };
		algo4_sorting.mergeSort(arr);
		ob.printArray(arr);
	}

}
