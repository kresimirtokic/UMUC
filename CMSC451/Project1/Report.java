/*
 * Kresimir Tokic
 * 9/8/20
 * Report.java
 * CMSC451 Project 1 (Second Program)
 * Launches GUI, opens, reads file, parses, calculates data to display
 * Some code borrowed and modified from https://www.javatpoint.com/java-jfilechooser
 * & https://www.geeksforgeeks.org/program-coefficient-variation/
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;


public class Report {

	//class vars
	private JFrame frmBenchmarkReport;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	String data[][] = new String[10][5];
	String column[] = { "Size", "Avg Count", "Coef Count %", "Avg Time", "Coef Time %" };
	int set = 0;

	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report window = new Report();
					window.frmBenchmarkReport.setVisible(true);
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		});
	}

	// constructor calls init
	public Report() {
		initialize();
	}

	// creates GUI
	private void initialize() {
		frmBenchmarkReport = new JFrame();
		frmBenchmarkReport.setTitle("Benchmark Report");
		frmBenchmarkReport.setBounds(100, 100, 450, 300);
		frmBenchmarkReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBenchmarkReport.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		

		menuBar = new JMenuBar();
		frmBenchmarkReport.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmOpen = new JMenuItem("Open");
		
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mntmOpen) {
					JFileChooser fc = new JFileChooser();
					int i = fc.showOpenDialog(fc);
					if (i == JFileChooser.APPROVE_OPTION) {
						File f = fc.getSelectedFile();
						String filepath = f.getPath();
						try {
							BufferedReader br = new BufferedReader(new FileReader(filepath));
							String line = null;
							while ((line = br.readLine()) != null) {
								if (!line.contentEquals("")) {
									parseLine(line);
								}
							}
							
							br.close();
							set = 0; //reset set count for next file-open event
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}

			// splits line by spaces, then loops through to find loopCount & timeLapse
			private void parseLine(String line) {
				String[] temp = line.split("\\s+");
				String size = temp[0];
				double sumTotalLoopCounts = 0;
				double sumTotalTimeLapses = 0;
				double averageLoopCounts = 0;
				double averageTimeLapses = 0;
				double standardDeviation = 0;
				for (int i = 1; i < temp.length - 1; i += 2) {
					sumTotalLoopCounts += Double.parseDouble(temp[i]);								
				}
				
				for (int j = 2; j < temp.length; j += 2) {
					sumTotalTimeLapses += Double.parseDouble(temp[j]);					
				}
				averageLoopCounts = sumTotalLoopCounts / ((temp.length -1) / 2);
				averageTimeLapses = sumTotalTimeLapses / ((temp.length - 1) / 2);
				double loopCountDev = standardDeviation(averageLoopCounts, temp, 1);
				double timeLapseDev = standardDeviation(averageLoopCounts, temp, 2);
				double coefLoopCount = loopCountDev / averageLoopCounts;
				double coefTimeLapse = timeLapseDev / averageTimeLapses;
				//calculateCoef(); //get standard deviation first then coef
				placeIntoData(size, averageLoopCounts, averageTimeLapses, coefLoopCount, coefTimeLapse); //add coef params
				
			}

			// calculates standard deviation
			private double standardDeviation(double average, String[] temp, int offset) {
				double dev = 0;
				for(int i = offset; i < temp.length; i += 2 ) {
					dev = dev + (Double.parseDouble(temp[i])/2 - average) * (Double.parseDouble(temp[i])/2 - average);
				}
				double result = Math.sqrt(dev / ((temp.length - 1)/2 - 1));
				return result;
			}

			// method puts data into data[][] based on the current read line
			private void placeIntoData(String size, double averageLoopCounts, double averageTimeLapses, double coefCount, double coefTime) {
				String pattern = "##.###";
				DecimalFormat df = new DecimalFormat(pattern);
				String formattedCoefCount = df.format(coefCount * 100);
				String formattedCoefTime = df.format(coefTime * 100);
				data[set][0] = size;
				data[set][1] = String.valueOf(averageLoopCounts);
				data[set][2] = formattedCoefCount;
				data[set][3] = String.valueOf(averageTimeLapses);
				data[set][4] = formattedCoefTime;
				set++;
			}
		});
		mnFile.add(mntmOpen);
		// frmBenchmarkReport.getContentPane().add(table);
		
		// move this to 
		table = new JTable(data, column);
		table.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(table);
		frmBenchmarkReport.getContentPane().add(sp);
	}

}
