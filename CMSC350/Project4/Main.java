/*
 * Author: Kresimir Tokic
 * Date: 5/1/19
 * Filename: Main.java
 * About: UMUC CMSC350 Project 4
 * Creates GUI, reads file
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Stack;
//import java.util.Vector;
//import java.util.regex.*;
import javax.swing.*;

public class Main {


	private JFrame mainWindow;
	private JTextField inputFileName;
	private JTextField inputClassToRecompile;
	private JTextField outputField;
	private ArrayList<String> lines = new ArrayList<String>();
	private DirectedGraph dg;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	// build the gui
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setTitle("Class Dependency Graph");
		mainWindow.setBounds(100, 100, 700, 275);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);

		inputFileName = new JTextField();
		inputFileName.setBounds(195, 11, 212, 20);
		mainWindow.getContentPane().add(inputFileName);

		JLabel inputFileNameLabel = new JLabel("Input File Name:");
		inputFileNameLabel.setBounds(10, 14, 150, 14);
		mainWindow.getContentPane().add(inputFileNameLabel);

		JLabel classToRecompile = new JLabel("Class To Recompile:");
		classToRecompile.setBounds(10, 50, 150, 14);
		mainWindow.getContentPane().add(classToRecompile);

		inputClassToRecompile = new JTextField();
		inputClassToRecompile.setBounds(195, 50, 212, 20);
		mainWindow.getContentPane().add(inputClassToRecompile);
		
		JLabel recompilationOrderLabel = new JLabel("Recompilation Order:");
		recompilationOrderLabel.setBounds(10, 100, 150, 14);
		mainWindow.getContentPane().add(recompilationOrderLabel);
		
		outputField = new JTextField();
		outputField.setBounds(10, 120, 666, 105);
		outputField.setEditable(false);
		mainWindow.getContentPane().add(outputField);

		JButton buildDirectedGraphButton = new JButton("Build Directed Graph");
		buildDirectedGraphButton.setBounds(500, 10, 175, 23);
		mainWindow.getContentPane().add(buildDirectedGraphButton);
		buildDirectedGraphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						String fileName = inputFileName.getText();
						String filePath = System.getProperty("user.dir") + File.separator;
						BufferedReader bufFileRead = new BufferedReader( new FileReader(filePath + fileName));
						dg = DirectedGraph.createDirectedGraph(tokenizeFileData(bufFileRead));
						JOptionPane.showMessageDialog(mainWindow,  "Graph Built Sucessfully");
					} catch (IOException ioE) {
						//ioE.printStackTrace();
						JOptionPane.showMessageDialog(mainWindow,"File Did Not Open");
					} 
			}
		});
		
		JButton topologicalOrderButton = new JButton("Topological Order");
		topologicalOrderButton.setBounds(500, 50, 175, 23);
		mainWindow.getContentPane().add(topologicalOrderButton);
		topologicalOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					outputField.setText("");
					validateClassName(inputClassToRecompile.getText());
					outputField.setText(dg.topology(inputClassToRecompile.getText()));
				} catch (ClassException ce1 ) {
					JOptionPane.showMessageDialog(mainWindow, inputClassToRecompile.getText() + " Not Found");
				} catch (CycleException ce2) {
					JOptionPane.showMessageDialog(mainWindow, inputClassToRecompile.getText() + "Cycle Detected");
				}
				
			}
		});

	}

	// method reads file by line and returns array where each index is a line
	public String[] tokenizeFileData(BufferedReader theGraphFile) throws IOException {
		String tokenizedFileData = null;
		while ((tokenizedFileData = theGraphFile.readLine()) != null) {
			lines.add(tokenizedFileData);
		}
		return  lines.toArray(new String[lines.size()]);
	}

	
	//method validates class name exists
	public void validateClassName(String userClassName) throws ClassException {
		int found = 0;;
		for(int i = 0; i <lines.size(); i++) {
			if(lines.get(i).contains(userClassName)) {
				found++;
			}
		}
		if (found == 0) {
			throw new ClassException("Class Not Found");			
		}
		}



}// end public class Main
