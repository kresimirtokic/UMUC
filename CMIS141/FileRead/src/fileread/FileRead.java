/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
* File: FileRead.java
* Author: Kresimir Tokic
* Date: October 1, 2018
* Purpose: This program demonstrates
* reading data from files
 */
public class FileRead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scannerIn = null;
        FileInputStream in = null;
        BufferedReader inputStream = null;

        //int equivalent of the char
        int fileChar;
        String fileLine;
        try {
            //file should be located in Netbeans folder project location
            //netbeans projects/fileread/
            //use of FileInputStream
            in = new FileInputStream("ReadIt.txt");

            System.out.println("ReadIt File Contents");
            //Read one char at a time
            while ((fileChar = in.read()) != -1) {
                //convert int to char
                System.out.print((char) fileChar);
            }
            //Separate the file output
            System.out.println("");

            System.out.println("Numbers.txt File COntents");

            //use of scanner and bufferedreader
            inputStream = new BufferedReader(new FileReader("Numbers.txt"));
            scannerIn = new Scanner(inputStream);
            while (scannerIn.hasNext()) {
                if (scannerIn.hasNextInt()) {
                    System.out.println(scannerIn.nextInt());
                }
                if (scannerIn.hasNextDouble()) {
                    System.out.println(scannerIn.nextDouble());
                } else {
                    scannerIn.next();
                }

            }

            //Separate the file output
            System.out.println("");
            //Use of
            inputStream = new BufferedReader(new FileReader("Strings.txt"));

            System.out.println("String.txt Contents");
            //Read one line using BufferedReader
            while ((fileLine = inputStream.readLine()) != null) {
                System.out.println(fileLine);
            }

        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        } finally {
            //need another catch for closing the streams
            try {
                //close the streams
                if (in != null) {
                    in.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException io) {
                System.out.println("Issue closing the Files " + io.getMessage());
            }
        }
    }
}
