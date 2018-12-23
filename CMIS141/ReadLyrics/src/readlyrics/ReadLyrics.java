/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readlyrics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*
* File: ReadLyrics.java
* Author: Kresimir Tokic
* Date: October 1, 2018
* Purpose: This program demonstrates
* reading data from files
 */
public class ReadLyrics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scannerIn = null;
        FileInputStream in = null;
        BufferedReader inputStream = null;
        int linesCount = 0;

        //int fileChar;
        String fileLine;
        try {
            //file should be located in Netbeans folder project location
            //netbeans projects/fileread/
            //use of FileInputStream
            in = new FileInputStream("InMyLife.txt"); //replace file name with any 
            inputStream = new BufferedReader(new FileReader("InMyLife.txt"));//replace file name with appropriate name

            System.out.println("The Bealtes - In My Life \n");
            //Read one line using BufferedReader
            while ((fileLine = inputStream.readLine()) != null) {
                System.out.println(fileLine);
                linesCount++;
                if (fileLine.equals("")){
                    linesCount--;
                }
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
            System.out.println("\n" + "Total number of lines in the song: " + linesCount);
        }//end finally
    }

}
