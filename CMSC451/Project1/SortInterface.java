/*
 * Kresimir Tokic
 * 9/7/20
 * SortInteface.java
 * CMSC451 Project 1
 * Interface for sorting methods & time and counters
 */
public interface SortInterface {

	long getLoopCount();
	
	long getTimeLapse();
	
	void recursiveSort(int[] myArray);

	void iterativeSort(int[] arr);
}
