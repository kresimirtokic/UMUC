/*
 * Kresimir Tokic
 * 6/15/20
 * Main.java
 * This file launches prompts user to input file name
 * launches GUIParser
 */

import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		// class variables
		Scanner sc = null;
		String fileName;


		// read file, launch gui
		System.out.println("Enter file name:");
		sc = new Scanner(System.in);
		try {
			fileName = sc.next();
			GUIParser gp = new GUIParser(fileName);
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found. Start over.");
		}
		
	}
}




	
