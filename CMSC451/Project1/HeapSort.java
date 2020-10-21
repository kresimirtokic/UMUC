/*
 * Kresimir Tokic
 * 9/7/20
 * HeapSort.java
 * CMSC451 Project 1
 * heapify & sort methods borrowed from https://www.geeksforgeeks.org/heap-sort/
 * buildMaxHeap, swap, iterative sort methods borrowed from https://www.geeksforgeeks.org/iterative-heap-sort/
 */

public class HeapSort implements SortInterface {

	private static final Exception UnsortedException = null;
	long loopCount = 0;
	long timeLapse = 0;

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	public void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	// recursive sorting method
	@Override
	public void recursiveSort(int arr[]) {
		long start = System.nanoTime();
		loopCount = 0;
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			loopCount++;
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
		timeLapse = System.nanoTime() - start;
		doubleCheckSort(arr);
	}

	// iterative sorting method
	@Override
	public void iterativeSort(int arr[]) {
		long start = System.nanoTime();
		loopCount = 0;
		int n = arr.length;

		buildMaxHeap(arr, n);

		for (int i = n - 1; i > 0; i--) {
			// swap value of first indexed
			// with last indexed
			swap(arr, 0, i);

			// maintaining heap property
			// after each swapping
			int j = 0, index;

			do {
				index = (2 * j + 1);

				// if left child is smaller than
				// right child point index variable
				// to right child
				if (index < (i - 1) && arr[index] < arr[index + 1])
					index++;

				// if parent is smaller than child
				// then swapping parent with child
				// having higher value
				if (index < i && arr[j] < arr[index])
					swap(arr, j, index);

				j = index;

			} while (index < i);
		}
		timeLapse = System.nanoTime() - start;
		doubleCheckSort(arr);
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		loopCount++; //this counts calls from buildMaxHeap & iterativeSort
	}

	public void buildMaxHeap(int arr[], int n) {
		for (int i = 1; i < n; i++) {
			// if child is bigger than parent
			if (arr[i] > arr[(i - 1) / 2]) {
				int j = i;

				// swap child and parent until
				// parent is smaller
				while (arr[j] > arr[(j - 1) / 2]) {
					swap(arr, j, (j - 1) / 2);
					j = (j - 1) / 2;
				}
			}
		}
	}

	@Override
	public long getLoopCount() {
		return loopCount;
	}

	@Override
	public long getTimeLapse() {
		return timeLapse;
	}

	//double checks the sorting throws exception if failed
	public void doubleCheckSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i+1]) {
				try {
					throw UnsortedException;
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		}
	}
}
