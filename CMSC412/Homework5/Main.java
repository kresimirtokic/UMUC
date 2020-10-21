/*
 * Kresimir Tokic
 * CMSC412 Homework 5
 * 9/19/20
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	// main method
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			String directory = null;
			File directoryPath = null;

			int menuItem = menu(sc, true);
			while (menuItem != -1) {
				switch (menuItem) {
				case 0:
					exitProgram();
					break;
				case 1:
					directoryPath = selectDirectory(sc, directory);
					if (!directoryPath.exists()) {
						System.out.println("D'oh! Does not exist.");
						exitProgram();
					}
					menuItem = menu(sc, false);
					break;
				case 2:
					listDirectoryFirstLevel(directoryPath);
					menuItem = menu(sc, false);
					break;
				case 3:
					listDirectoryAllLevels(directoryPath);
					menuItem = menu(sc, false);
					break;
				case 4:
					deleteFile(sc, directoryPath);
					menuItem = menu(sc, false);
					break;
				case 5:
					displayHex(sc, directoryPath);
					menuItem = menu(sc, false);
					break;
				case 6:
					encryptFile(sc, directoryPath);
					menuItem = menu(sc, false);
					break;
				case 7:
					// decrypt file with same encrypt method
					encryptFile(sc, directoryPath);
					menuItem = menu(sc, false);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Ay, carumba!");
			exitProgram();
		}

	}

	// prompts user for password then file name to encrypt file
	private static void encryptFile(Scanner sc, File directoryPath) throws IOException {
		// password Qwertyuiop[123$4$567]
		System.out.println("Enter password:");
		String password = sc.next();
		byte[] key = password.getBytes();
		if (key.length > 256) {
			System.out.println("Bad Password. Try again.");
			encryptFile(sc, directoryPath);
		}
		System.out.println("Enter file name:");
		String fileName = sc.next();
		String path = directoryPath.getAbsolutePath();
		String fullPathName = path + "\\" + fileName;
		FileInputStream fis = new FileInputStream(fullPathName);
		System.out.println("Enter NEW file name:");
		String newFileName = sc.next();
		fullPathName = path + "\\" + newFileName;
		FileOutputStream fos = new FileOutputStream(fullPathName);
		int b = -1;
		long i = 0;
		while ((b = fis.read()) != -1) {
			b = (b ^ key[(int) (i % key.length)] ^ (int) (i & 0xFF));
			fos.write(b);
			i++;
		}
		fis.close();
		fos.close();
	}

	// outputs hex representation of file on screen
	private static void displayHex(Scanner sc, File directoryPath) throws IOException {
		//figure out data offset for output
		System.out.println("Enter file name:");
		String fileName = sc.next();
		String path = directoryPath.getAbsolutePath();
		String fullPathName = path + "\\" + fileName;
		FileInputStream fis = new FileInputStream(fullPathName);
		int i = 0;
		while ((i = fis.read()) != -1) {
			if (i != -1) {
				System.out.printf("%02X ", i);
			}

		}
		System.out.println("");
		fis.close();
	}

	// prompts user for file name to delete
	private static void deleteFile(Scanner sc, File directoryPath) {
		System.out.println("Enter file name:");
		String fileName = sc.next();
		String path = directoryPath.getAbsolutePath();
		String fullPathName = path + "\\" + fileName;
		File deleteFile = new File(fullPathName);
		if (!deleteFile.exists()) {
			System.out.println("D'oh! Does not exist. Try again.");
			deleteFile(sc, directoryPath);
		}
		deleteFile.delete();
	}

	// lists all files and sub-directories and files in sub-directories
	private static void listDirectoryAllLevels(File directoryPath) {
		File filesList[] = directoryPath.listFiles();
		for (File file : filesList) {
			if (file.isDirectory()) {
				System.out.println("Directory path: " + file.getAbsolutePath());
				listDirectoryAllLevels(file);
			}
			if (file.isFile()) {
				System.out.println("File name: " + file.getName());
				System.out.println("File path: " + file.getAbsolutePath());
			}
			System.out.println(" ");
		}

	}

	// exits program
	private static void exitProgram() {
		System.out.println("Thank you, come again.");
		System.exit(0);
	}

	// lists files and subs-directories
	private static void listDirectoryFirstLevel(File directoryPath) {
		File filesList[] = directoryPath.listFiles();
		for (File file : filesList) {
			if (file.isDirectory()) {
				System.out.println("Directory path: " + file.getAbsolutePath());
			}
			if (file.isFile()) {
				System.out.println("File name: " + file.getName());
				System.out.println("File path: " + file.getAbsolutePath());
			}
			System.out.println(" ");
		}
	}

	// prompts user for directory
	private static File selectDirectory(Scanner sc, String directory) {
		System.out.println("Select Directory. (Enter absolute path):");
		directory = sc.next();
		return new File(directory);
	}

	// prints appropriate menu relevant to execution and returns menu choice
	public static int menu(Scanner sc, boolean start) {
		if (start) {
			System.out.println("0 - Exit \n" + "1 - Select directory \n");
			start = false;
			return sc.nextInt();
		} else {
			System.out.println("0 - Exit \n" + "1 - Select directory \n" + "2 - List directory content (first level) \n"
					+ "3 - List directory content (all levels) \n" + "4 - Delete file \n" + "5 - Display file \n"
					+ "6 - Encrypt file \n" + "7 - Decrypt file \n" + "Select Option:");
			return sc.nextInt();
		}
	}
}
