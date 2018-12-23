/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reademails;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * this joint reads a text file of email addresses
 * @author kresimir.tokic
 */
public class ReadEmails {

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
            in = new FileInputStream("EmailAddresses.txt");

            System.out.println("EmailAddresses.txt File Contents");
            //Read one char at a time
            while ((fileChar = in.read()) != -1) {
                //convert int to char
                System.out.print((char) fileChar);
            }
        }catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        } finally {
            //need another catch for closing the streams
            try {
                //close the streams
                if (in != null) {
                    in.close();
                    System.out.println("-----------file closed");
                }
            } catch (IOException io) {
                System.out.println("Issue closing the Files " + io.getMessage());
            }
        }//end finally
    }//end main
    

