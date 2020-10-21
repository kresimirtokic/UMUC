/*
 * Kresimir Tokic
 * 9/30/20
 * CMSC412 Final Project
 * Simulates various paging demand algorithms
 * 
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// vars
		Scanner sc = new Scanner(System.in);
		int physicalFrames = Integer.parseInt(args[0]); // accept as command line arg less than 8
		int virtualMemoryFrames = Integer.parseInt(args[1]); // accept as command line arg
		int referenceString[] = new int[virtualMemoryFrames];
		int menuItem = 0;

		try {
			menuItem = showMenu(sc, true);
			while (menuItem != -1) {
				switch (menuItem) {
				case 0:
					exitProgram();
					break;
				case 1:
					referenceString = readReferenceString(sc, virtualMemoryFrames);
					menuItem = showMenu(sc, false);
					break;
				case 2:
					referenceString = generateReferenceString(virtualMemoryFrames);
					menuItem = showMenu(sc, false);
					break;
				case 3:
					displayReferenceString(referenceString);
					menuItem = showMenu(sc, false);
					break;
				case 4:
					simulateFIFO(referenceString, virtualMemoryFrames, physicalFrames, sc);
					menuItem = showMenu(sc, false);
					break;
				case 5:
					simulateOPT(referenceString, virtualMemoryFrames, physicalFrames, sc);
					menuItem = showMenu(sc, false);
					break;
				case 6:
					simulateLRU(referenceString, virtualMemoryFrames, physicalFrames, sc);
					menuItem = showMenu(sc, false);
					break;
				case 7:
					simulateLFU(referenceString, virtualMemoryFrames, physicalFrames, sc);
					menuItem = showMenu(sc, false);
					break;
				default:
					menuItem = showMenu(sc, false);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			System.out.println("Input error.");
			exitProgram();

		}

	}

	// simulates LFU correctly per homework6 solutions
	private static void simulateLFU(int[] referenceString, int virtualMemoryFrames, int physicalFrames, Scanner sc) {
		HashSet<Integer> s = new HashSet<>(physicalFrames);
		HashMap<Integer, Integer> indexes = new HashMap<>(); // stores lfu indexes of pages
		int pageFaults = 0;
		int count = 0;
		int lfu = -1;
		// poplates unique ref string and 0 count to hashmap
		for (int i = 0; i < virtualMemoryFrames; i++) {
			if (!indexes.containsKey(referenceString[i])) {
				indexes.put(referenceString[i], 0);
			}
		}

		for (int i = 0; i < virtualMemoryFrames; i++) {
			if (s.size() < physicalFrames) { // check to see if space allows for more
				if (!s.contains(referenceString[i])) { // if its not in put it in
					s.add(referenceString[i]);
					count = indexes.get(referenceString[i]) + 1;
					indexes.replace(referenceString[i], count); // update the freq of use
					pageFaults++;
				} else { // if its already in there just increment the counter
					count = indexes.get(referenceString[i]) + 1;
					indexes.replace(referenceString[i], count);
				}
			} else { // else if space is full
				if (!s.contains(referenceString[i])) { // if its not in put it in
					int max = referenceString.length;
					Iterator<Integer> itr = s.iterator();
					while (itr.hasNext()) {
						int temp = itr.next();
						int current = indexes.get(temp);
						if (current < max) {
							max = current;
							lfu = temp;
						}
					}
					s.remove(lfu); // removes the lfu
					s.add(referenceString[i]); // inserts current page
					count = indexes.get(referenceString[i]) + 1;
					indexes.replace(referenceString[i], count);
					pageFaults++;
				} else {
					count = indexes.get(referenceString[i]) + 1;
					indexes.replace(referenceString[i], count);
				}
			}
			System.out.println("Ref String: " + referenceString[i]);
			System.out.println("Frame: " + s);
			System.out.println("Page Faults: " + pageFaults);
			// System.out.println("Victim Frame: " + lfu);
			System.out.println("Press a key to continue");
			String anyKey = sc.next();
		}
		System.out.println("Total Page Faults: " + pageFaults + "\n");
	}

	// simluates LRU correctly based on homework6 solutions
	private static void simulateLRU(int[] referenceString, int virtualMemoryFrames, int physicalFrames, Scanner sc) {
		HashSet<Integer> s = new HashSet<>(physicalFrames);
		HashMap<Integer, Integer> indexes = new HashMap<>(); // stores lru indexes of pages
		int pageFaults = 0;

		for (int i = 0; i < virtualMemoryFrames; i++) {
			if (s.size() < physicalFrames) { // check to see if space allows more pages
				if (!s.contains(referenceString[i])) { // insert if not already there
					s.add(referenceString[i]);
					pageFaults++;
				}
				indexes.put(referenceString[i], i); // store recently used index of page
			} else { // else if space is full
				if (!s.contains(referenceString[i])) { // insert if not already there
					int lru = Integer.MAX_VALUE;
					int val = Integer.MIN_VALUE;
					Iterator<Integer> itr = s.iterator();
					while (itr.hasNext()) {
						int temp = itr.next();
						if (indexes.get(temp) < lru) {
							lru = indexes.get(temp);
							val = temp;
						}
					}
					s.remove(val); // removes victim
					indexes.remove(val); // removes victim from hashmap
					s.add(referenceString[i]); // inserts current page
					pageFaults++;
				}
				indexes.put(referenceString[i], i); // puts current page and index
			}
			System.out.println("Ref String: " + referenceString[i]);
			System.out.println("Frame: " + s);
			System.out.println("Page Faults: " + pageFaults);
			// System.out.println("Victim Frame: " + val);
			System.out.println("Press a key to continue");
			String anyKey = sc.next();
		}
		System.out.println("Total Page Faults: " + pageFaults + "\n");
	}

	// simulates OPT correctly based on homework6 solutions
	private static void simulateOPT(int[] referenceString, int virtualMemoryFrames, int physicalFrames, Scanner sc) {
		List<Integer> fr = new ArrayList<Integer>(); // holds given num of frames
		int pageFaults = 0;
		for (int i = 0; i < virtualMemoryFrames; i++) {
			if (!fr.contains(referenceString[i])) {
				pageFaults++;
				if (fr.size() < physicalFrames) { // if empty slots fill them
					fr.add(referenceString[i]);
				} else { // else if full then predict and fill with prediction
					int j = predict(referenceString, fr, virtualMemoryFrames, i + 1);
					fr.set(j, referenceString[i]);
				}
			}
			System.out.println("Ref String: " + referenceString[i]);
			System.out.println("Frame: " + fr);
			System.out.println("Page Faults: " + pageFaults);
			// System.out.println("Victim Frame: " + val);
			System.out.println("Press a key to continue");
			String anyKey = sc.next();
		}
		System.out.println("Total Page Faults: " + pageFaults + "\n");
	}

	// method to predict frame that will not be used
	// this method inspired by Geeks4Geeks C++ explanation of OPT paging algorithm
	private static int predict(int[] referenceString, List<Integer> fr, int virtualMemoryFrames, int index) {
		int res = -1;
		int farthest = index; // stores index of frame farthest in the future
		for (int i = 0; i < fr.size(); i++) {
			int j;
			for (j = index; j < referenceString.length; j++) {
				if (fr.get(i) == referenceString[j]) {
					if (j > farthest) {
						res = i;
						farthest = j;
					}
					break;
				}
			}
			if (j == virtualMemoryFrames) {
				return i;
			}
		}
		return (res == -1) ? 0 : res; // if all frames not in future return 0 else return res
	}

	// simulates FIFO correctly per homework6 solutions
	private static void simulateFIFO(int[] referenceString, int virtualMemoryFrames, int physicalFrames, Scanner sc) {

		HashSet<Integer> s = new HashSet<>(physicalFrames);
		Queue<Integer> indexes = new LinkedList<>(); // to store pages in FIFO structure
		int pageFaults = 0;
		// int val = -1;

		for (int i = 0; i < virtualMemoryFrames; i++) {
			if (s.size() < physicalFrames) { // check to see if space allows more pages
				if (!s.contains(referenceString[i])) { // insert if not already there
					s.add(referenceString[i]);
					pageFaults++;
					indexes.add(referenceString[i]); // push current page to queue
				}
			} else { // else if set is full
				if (!s.contains(referenceString[i])) { // insert if not already there
					int val = indexes.peek(); // get victim frame
					indexes.poll();
					s.remove(val); // remove victim frame
					s.add(referenceString[i]); // insert current page
					indexes.add(referenceString[i]); // push current page to queue
					pageFaults++;
				}
			}
			System.out.println("Ref String: " + referenceString[i]);
			System.out.println("Frame: " + s);
			System.out.println("Page Faults: " + pageFaults);
			// System.out.println("Victim Frame: " + val);
			System.out.println("Press a key to continue");
			String anyKey = sc.next();
		}
		System.out.println("Total Page Faults: " + pageFaults + "\n");
	}

	// prints ref string to screen
	private static void displayReferenceString(int[] referenceString) {
		System.out.println("\nReference String:");
		for (int i = 0; i < referenceString.length; i++) {
			System.out.print(referenceString[i] + " ");
		}
		System.out.println("\n");
	}

	// generates random string of int from 0-9
	private static int[] generateReferenceString(int virtualMemoryFrames) {
		int tempRefString[] = new int[virtualMemoryFrames];
		Random rand = new Random();
		for (int i = 0; i < virtualMemoryFrames; i++) {
			tempRefString[i] = rand.nextInt(9);
		}
		System.out.println("\nRandom Reference String Generated \n");
		displayReferenceString(tempRefString);
		return tempRefString;
	}

	// prompts user for ref string and returns it as array
	private static int[] readReferenceString(Scanner sc, int virtualMemoryFrames) {
		int tempRefString[] = new int[virtualMemoryFrames];
		int temp = -1;
		try {
			for (int i = 0; i < virtualMemoryFrames; i++) {
				System.out.println("Enter reference string numbers 0-9:");
				temp = sc.nextInt();
				if (temp > 9 || temp < 0) {
					System.out.println("Must be integers between 0-9.");
				} else {
					tempRefString[i] = temp;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Input For Reference String.");
			exitProgram();
		}
		return tempRefString;
	}

	// shows menu and returns menu selection
	private static int showMenu(Scanner sc, boolean emptyRefString) {
		int selection = -1;
		try {
			if (emptyRefString) {
				System.out.println("0 - Exit");
				System.out.println("1 - Read Reference String");
				System.out.println("2 - Generate Reference String");
				selection = sc.nextInt();
				if (selection < 0 || selection > 2) {
					System.out.println("Invalid Menu Selection.");
					showMenu(sc, true);
				}
				return selection;
			} else {
				System.out.println("0 - Exit");
				System.out.println("1 - Read Reference String");
				System.out.println("2 - Generate Reference String");
				System.out.println("3 - Display Current Reference String");
				System.out.println("4 - Simulate FIFO");
				System.out.println("5 - Simulate OPT");
				System.out.println("6 - Simluate LRU");
				System.out.println("7 - Simluate LFU");
				selection = sc.nextInt();
				if (selection < 0 || selection > 7) {
					System.out.println("Invalid Menu Selection.");
					showMenu(sc, false);
				}
				return selection;
			}
		} catch (Exception e) {
			sc.nextLine();
			showMenu(sc, true);
		}
		return selection;
	}

	// exits program
	private static void exitProgram() {
		System.out.println("Good Bye.");
		System.exit(0);
	}
}
