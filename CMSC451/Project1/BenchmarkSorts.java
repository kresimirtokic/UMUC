/*
 * Kresimir Tokic
 * 9/8/20
 * BenchmarkSorts.java
 * CMSC451 Project 1 (Program 1)
 * Creates randomly generated arrays of long, sorts,
 * checks if they're sorted, time stamps, counts loops
 * both iteratively and recursively
 */
import java.io.*;
import java.util.*;

public class BenchmarkSorts {

	HeapSort sortObject = new HeapSort();
	Random randGen = new Random();
	FileWriter iterativeFile;
	FileWriter recursiveFile;
	FileWriter dataFile;
	FileWriter sortedDataFile;
	boolean firstLineIterative = true;
	boolean firstLineRecursive = true;


	// explicit constructor
	BenchmarkSorts() {
		try {
			this.iterativeFile = new FileWriter("iterative.txt");
			this.recursiveFile = new FileWriter("recursive.txt");
			this.dataFile = new FileWriter("unsortedData.txt");
			this.sortedDataFile = new FileWriter("sortedData.txt");
		} catch (IOException e) {
			System.out.println("Error Creating FileWriter Objects");
			// e.printStackTrace();
		}

	}

	void printToScreen(int[] myArray) {
		for (int i = 0; i < 10; i++) {
			System.out.print(myArray[i] + " ");
		}
		System.out.print("\n");
	}
	
	void generateRandomDataSets(int n) {
		int[] myArray = new int[n];
		for (int i = 0; i < n; i++) {
			myArray[i] = randGen.nextInt();
			//System.out.print(myArray[i] + " ");
		}
		System.out.println("\nUnsorted Arrays:");
		printToScreen(myArray);
		printUnsortedDataSets(myArray);
		sort(myArray);
	}

	void sort(int[] myArray) {
		sortObject.iterativeSort(myArray);
		printIterativeResults(myArray);
		sortObject.recursiveSort(myArray);
		printRecursiveResults(myArray);
		printSortedDataSets(myArray);
	}

	void printIterativeResults(int[] myArray) {
		System.out.println("Iterative Results:");
		printToScreen(myArray);
		try {
			if (firstLineIterative) {
				iterativeFile.append("\n");
				iterativeFile.append(myArray.length + ": ");
				firstLineIterative = false;
			}
			iterativeFile.append(sortObject.getLoopCount() + " ");
			iterativeFile.append(sortObject.getTimeLapse() + " ");
			// iterativeFile.close();
		} catch (IOException e) {
			System.out.println("An Error Occured Writing Result File");
			// e.printStackTrace();
		}
	}

	void printRecursiveResults(int[] myArray) {
		System.out.println("Recursive Results:");
		printToScreen(myArray);
		try {
			if (firstLineRecursive) {
				recursiveFile.append("\n");
				recursiveFile.append(myArray.length + ": ");
				firstLineRecursive = false;
			}
			recursiveFile.append(sortObject.getLoopCount() + " ");
			recursiveFile.append(sortObject.getTimeLapse() + " ");
			// iterativeFile.close();
		} catch (IOException e) {
			System.out.println("An Error Occured Writing Result File");
			// e.printStackTrace();
		}
	}

	void printUnsortedDataSets(int[] myArray) {
		try {

			for (int i = 0; i < myArray.length; i++) {
				dataFile.append(myArray[i] + " ");
			}
			dataFile.append("\n");
			// dataFile.close();
		} catch (IOException e) {
			System.out.println("An Error Occured Writing Unsorted Data Set File");
			// e.printStackTrace();
		}

	}

	void printSortedDataSets(int[] myArray) {
		try {
			for (int i = 0; i < myArray.length; i++) {
				sortedDataFile.append(myArray[i] + " ");
			}
			sortedDataFile.append("\n");
			// sortedDataFile.close();
		} catch (IOException e) {
			System.out.println("An Error Occured Writing Sorted Data Set File");
			// e.printStackTrace();
		}

	}
}
