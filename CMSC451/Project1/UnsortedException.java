/*
 * Kresimir Tokic
 * 9/7/20
 * UnsortedException.java
 * CMSC451 Project 1
 * Exception for when data fails sorting algorithm
 */
public class UnsortedException extends Exception {

	// default serialVersionUID
	private static final long serialVersionUID = 1L;
	String message = "Unsorted Exception";

	// constructor
	UnsortedException() {
		this.message = "Array Is Unsorted";
	}

}
