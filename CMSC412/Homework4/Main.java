
/*
 * Kresimir Tokic
 * 09/11/20
 * CMSC412 Homework 4
 * Reads from local text file, runs bankers algorithm
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		// vars
		Scanner sc = new Scanner(System.in);
		String fileName = "";
		

		// prompt user for file then open it
		System.out.println("Enter file name:");
		fileName = sc.next();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			readFileContents(br);
		} catch (IOException e) {
			System.out.println("Error Reading File: " + fileName);
		}
	}

	
	
	
	// read file launch relevant methods
	private static void readFileContents(BufferedReader br) {
		try {
			int counter = 0;
			int n = Integer.parseInt(br.readLine()); // number of processes
			int m = Integer.parseInt(br.readLine()); // number of resources

			boolean[] completedProcess = new boolean[n];
			int[][] maxClaim = new int[n][m];
			int[][] allocatedResources = new int[n][m];
			int[][] neededResources = new int[n][m];
			int[] safeOrder = new int[n];
			int[] resources = new int[m];
			String line = "";
			int totalResources[] = { 5, 5, 5, 5, 5 }; // hard coded 5 of each resource
			int[] availableResources = new int[m];

			// reads file by line, parses each line into appropriate arrays
			while ((line = br.readLine()) != null) {
				String[] tempLine = line.split("\\s+");
				for (int i = 0; i < m; i++) {
					resources[i] = Integer.parseInt(tempLine[i]);
					if (counter < 7) {
						maxClaim[counter][i] = resources[i];
					} else {
						allocatedResources[counter - 7][i] = resources[i];
					}
				}
				counter++;
			}
			calculateAvailableResources(allocatedResources, availableResources, totalResources);
			calculateNeededResources(maxClaim, allocatedResources, neededResources);
			printInputToScreen(maxClaim, allocatedResources, neededResources);
			figureItOut(availableResources, neededResources, allocatedResources, maxClaim, completedProcess);// iterate through m???
			//isExecutable(availableResources, neededResources, m); 
		} catch (NumberFormatException | IOException e) {
			System.out.println("Number Format or IO Error");
			// e.printStackTrace();
		}
	}

	// determines the available resources
	private static void calculateAvailableResources(int[][] allocatedResources, int[] availableResources,
			int[] totalResources) {
		for (int i = 0; i < totalResources.length; i++) {
			int totalAllocatedResources = 0;
			for (int j = 0; j < allocatedResources.length; j++) {
				totalAllocatedResources += allocatedResources[j][i];
				availableResources[i] = totalResources[i] - totalAllocatedResources;
			}
			//System.out.println("available: " + Arrays.toString(availableResources));
		}
	}

	// determines the needed resources
	private static void calculateNeededResources(int[][] maxClaim, int[][] allocatedResources,
			int[][] neededResources) {
		for (int i = 0; i < maxClaim.length; i++) {
			for (int j = 0; j < maxClaim[i].length; j++) {
				neededResources[i][j] = maxClaim[i][j] - allocatedResources[i][j];
			}
		}
	}

	// outputs a table of claimed, allocated, needed resources per process
	private static void printInputToScreen(int[][] maxClaim, int[][] allocatedResources, int[][] neededResources) {
		System.out.print("Max Claim:\t");
		for (int i = 0; i < maxClaim.length; i++) {
			for (int j = 0; j < maxClaim[i].length; j++) {
				System.out.print(maxClaim[i][j]);
			}
			System.out.print("\t");
		}
		System.out.print("\n");

		System.out.print("Allocated:\t");
		for (int i = 0; i < allocatedResources.length; i++) {
			for (int j = 0; j < allocatedResources[i].length; j++) {
				System.out.print(allocatedResources[i][j]);
			}
			System.out.print("\t");
		}
		System.out.print("\n");

		System.out.print("Needed:\t\t");
		for (int i = 0; i < neededResources.length; i++) {
			for (int j = 0; j < neededResources[i].length; j++) {
				System.out.print(neededResources[i][j]);
			}
			System.out.print("\t");
		}
		System.out.print("\n");
	}

	// determine if a given process can execute
	private static boolean isExecutable(int[] availableResources, int[][] neededResources, int processIndex) {
		for (int i = 0; i < availableResources.length; i++) {
			if (neededResources[processIndex][i] > availableResources[i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * determine safe sequence by storing each process into an array in its safe
	 * sequence deallocate the process and increase the available resources find the
	 * next safe process
	 */
	private static void figureItOut(int[] availableResources, int[][] neededResources, int[][] allocatedResources, int[][] maxClaim, boolean[] completedProcess) {
		int count = 0;
		while(count < neededResources.length) {
		for (int i = 0; i < neededResources.length; i++) {
			if(completedProcess[i] == false && isExecutable(availableResources, neededResources, i)) {
				System.out.println("executable process: " + "P" + (i+1));
				completedProcess[i] = true;
				count++;
				for (int j = 0; j < 5; j++) {
					neededResources[i][j] -= neededResources[i][j];
					availableResources[j] += allocatedResources[i][j];
				}
			}
		}
	}
	}
}
