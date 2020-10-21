
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cmsc405;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Kresimir Tokic 6/28/20 Modified template file provided by instructor Runs
 * program, displays images, rotates, scales, translates image.
 * 
 * @author jim
 */
public class CMSC405P1Template extends JPanel {

	// A counter that increases by one in each frame.
	private int frameNumber = 1;
	// The time, in milliseconds, since the animation started.
	private long elapsedTimeMillis;
	// This is the measure of a pixel in the coordinate system
	// set up by calling the applyLimits method. It can be used
	// for setting line widths, for example.
	private float pixelSize;
	// static JLabel frameLabel;
	static int translateX = 0;
	static int translateY = 0;
	static double rotation = 0.0;
	static double scaleX = 1.0;
	static double scaleY = 1.0;
	ImageTemplate myImages = new ImageTemplate();
	BufferedImage bImage = myImages.getImage(ImageTemplate.letterB);
	BufferedImage lImage = myImages.getImage(ImageTemplate.letterL);
	BufferedImage mImage = myImages.getImage(ImageTemplate.letterM);

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		JFrame window;
		window = new JFrame("Java Animation"); // The parameter shows in the window title bar.
		final CMSC405P1Template panel = new CMSC405P1Template(); // The drawing area.
		window.setContentPane(panel); // Show the panel in the window.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End program when window closes.
		window.pack(); // Set window size based on the preferred sizes of its contents.
		window.setResizable(false); // Don't let user resize window.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( // Center window on screen.
				(screen.width - window.getWidth()) / 2, (screen.height - window.getHeight()) / 2);
		// frameLabel = new JLabel();
		// window.add(frameLabel);
		Timer animationTimer; // A Timer that will emit events to drive the animation.
		final long startTime = System.currentTimeMillis();
		// Taken from AnimationStarter
		// Modified to change timing and allow for recycling
		animationTimer = new Timer(1600, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panel.frameNumber > 4) {
					panel.frameNumber = 1;
				} else {
					panel.frameNumber++;
				}
				panel.elapsedTimeMillis = System.currentTimeMillis() - startTime;
				panel.repaint();
			}
		});
		window.setVisible(true); // Open the window, making it visible on the screen.
		animationTimer.start(); // Start the animation running.
	}

	public CMSC405P1Template() {
		// Size of Frame
		setPreferredSize(new Dimension(800, 600));
	}

	// This is where all of the action takes place
	// Code taken from AnimationStarter.java but modified to add the specific Images
	// Also added looping structure for Different transformations
	protected void paintComponent(Graphics g) {

		/*
		 * First, create a Graphics2D drawing context for drawing on the panel.
		 * (g.create() makes a copy of g, which will draw to the same place as g, but
		 * changes to the returned copy will not affect the original.)
		 */
		Graphics2D g2 = (Graphics2D) g.create();

		/*
		 * Turn on antialiasing in this graphics context, for better drawing.
		 */
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		/*
		 * Fill in the entire drawing area with white.
		 */
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight()); // From the old graphics API!

		/*
		 * Here, I set up a new coordinate system on the drawing area, by calling the
		 * applyLimits() method that is defined below. Without this call, I would be
		 * using regular pixel coordinates. This function sets the value of the global
		 * variable pixelSize, which I need for stroke widths in the transformed
		 * coordinate system.
		 */
		// Controls your zoom and area you are looking at
		applyWindowToViewportTransformation(g2, -75, 75, -75, 75, true);

		AffineTransform savedTransform = g2.getTransform();
		// System.out.println("Frame is " + frameNumber);
		switch (frameNumber) {
		case 1: // First frame is unmodified.
			// frameLabel.setText("Unmodified"); //updating text creates double calls
			translateX = 0;
			translateY = 0;
			scaleX = 1.0;
			scaleY = 1.0;
			rotation = 0;
			// System.out.println(rotation);
			break;
		case 2: // Second frame translates each image (-5, 7).
			// frameLabel.setText("Translate x -5 & y 7");
			translateX = -5;
			translateY = 7;
			// System.out.println(rotation);
			break;
		case 3: // Third frame rotates each image by 45 degrees Counter clockwise
			// frameLabel.setText("Rotate 45 Counter");
			rotation = 45 * Math.PI / 180.0;
			// System.out.println(rotation);
			break;
		// Can add more cases as needed
		case 4: // fourth frame rotates each image by 90 clockwise
			// frameLabel.setText("Rotate 90 Clockwise");
			rotation = rotation - 90 * Math.PI / 180;
			// System.out.println(rotation);
			break;
		case 5: // fifth frame scales x 2 and y 0.5
			// frameLabel.setText("Scale x twice & y half");
			scaleX = 2;
			scaleY = 0.5;
			// System.out.println(rotation);
			break;
		default:
			// frameLabel.setText("Begin");
			// rotation = 0;
			break;
		} // End switch
		g2.translate(translateX, translateY); // Move image.
		// To offset translate again
		g2.translate(20, 10);
		g2.rotate(rotation); // Rotate image.
		g2.scale(scaleX, scaleY); // Scale image.
		g2.drawImage(mImage, 0, 0, this); // draw image
		g2.setTransform(savedTransform);

		// Add another image
		g2.translate(translateX, translateY); // Move image.
		// To offset translate again
		// This allows you to place your images across your graphic
		g2.translate(-20, 10);
		g2.rotate(rotation); // Rotate image.
		g2.scale(scaleX, scaleY); // Scale image.
		g2.drawImage(lImage, 0, 0, this);
		g2.setTransform(savedTransform);

		// Add another image
		g2.translate(translateX, translateY); // Move image.
		// To offset translate again
		// This allows you to place your images across your graphic
		g2.translate(-60, 10);
		g2.rotate(rotation); // Rotate image.
		g2.scale(scaleX, scaleY); // Scale image.
		g2.drawImage(bImage, 0, 0, this);
		g2.setTransform(savedTransform);

		// You can add more shapes/images as needed
	}

	// Method taken directly from AnimationStarter.java Code
	private void applyWindowToViewportTransformation(Graphics2D g2, double left, double right, double bottom,
			double top, boolean preserveAspect) {
		int width = getWidth(); // The width of this drawing area, in pixels.
		int height = getHeight(); // The height of this drawing area, in pixels.
		if (preserveAspect) {
			// Adjust the limits to match the aspect ratio of the drawing area.
			double displayAspect = Math.abs((double) height / width);
			double requestedAspect = Math.abs((bottom - top) / (right - left));
			if (displayAspect > requestedAspect) {
				// Expand the viewport vertically.
				double excess = (bottom - top) * (displayAspect / requestedAspect - 1);
				bottom += excess / 2;
				top -= excess / 2;
			} else if (displayAspect < requestedAspect) {
				// Expand the viewport vertically.
				double excess = (right - left) * (requestedAspect / displayAspect - 1);
				right += excess / 2;
				left -= excess / 2;
			}
		}
		g2.scale(width / (right - left), height / (bottom - top));
		g2.translate(-left, -top);
		double pixelWidth = Math.abs((right - left) / width);
		double pixelHeight = Math.abs((bottom - top) / height);
		pixelSize = (float) Math.max(pixelWidth, pixelHeight);
	}

}
