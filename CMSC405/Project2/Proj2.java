
/*
 * Kresimir Tokic
 * 7/12/20
 * CMSC405 Comp Graphics 
 * Project 2
 * Proj2 class creates shapes and handles event listeners
 */

import java.awt.*;
import java.awt.event.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

public class Proj2 extends GLJPanel implements GLEventListener, KeyListener {

	// variables
	private static final long serialVersionUID = 1L;
	private double rotateX = 0;
	private double rotateY = 0;
	private double rotateZ = 0;
	private double translateX = 0;
	private double translateY = 0;
	private double translateZ = 0;
	private double zoom = 1;

	// default constructor
	public Proj2() {
		super(new GLCapabilities(null));
		setPreferredSize(new Dimension(720, 720));
		addGLEventListener(this);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	// keyPressed handler
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			rotateY -= 5;
		} else if (key == KeyEvent.VK_RIGHT) {
			rotateY += 5;
		} else if (key == KeyEvent.VK_DOWN) {
			rotateX -= 5;
		} else if (key == KeyEvent.VK_UP) {
			rotateX += 5;
		} else if (key == KeyEvent.VK_PLUS || key == KeyEvent.VK_EQUALS) { // must check both keys
			zoom += .125;
		} else if (key == KeyEvent.VK_MINUS || key == KeyEvent.VK_UNDERSCORE) { // must check both keys
			zoom -= .125;
		} else if (key == KeyEvent.VK_W) {
			translateY += .25;
		} else if (key == KeyEvent.VK_A) {
			translateX -= .25;
		} else if (key == KeyEvent.VK_S) {
			translateY -= .25;
		} else if (key == KeyEvent.VK_D) {
			translateX += .25;
		} else if (key == KeyEvent.VK_R) {
			rotateX = 0;
			rotateY = 0;
			rotateZ = 0;
			translateX = 0;
			translateY = 0;
			translateZ = 0;
			zoom = 1;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	// sets rotation, scale, translation and creates shapes to display
	@Override
	public void display(GLAutoDrawable toDraw) {
		GL2 gl2 = toDraw.getGL().getGL2(); // The object that contains all the OpenGL methods.

		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		gl2.glLoadIdentity();
		gl2.glRotated(rotateZ, 0, 0, 1); // rotate Z of scene
		gl2.glRotated(rotateY, 0, 1, 0); // rotate Y of scene
		gl2.glRotated(rotateX, 1, 0, 0); // rotate X of scene
		gl2.glScaled(zoom, zoom, zoom); // scales scene
		gl2.glTranslated(translateX, translateY, translateZ); // translates scene

		// Draw 3D Shapes with space between them
		Shape cube = new Cube(gl2, 0.125);
		gl2.glTranslated(.2, .2, .1);
		Shape pyramid = new Pyramid(gl2, 0.125);
		gl2.glTranslated(-.1, -.1, -.5);
		Shape fanBlades = new Fan(gl2, 0.125);
		gl2.glTranslated(.1, .1, .1);
		Shape diamonds = new Diamond(gl2, 0.125);
		gl2.glTranslated(.1, .1, .1);
		Shape stars = new Star(gl2, 0.125);
		gl2.glTranslated(-.5, -.5, -.2);
		Shape thing = new Hex(gl2, 0.125); // figure out why not working

	}

	// This is called before the GLJPanel is destroyed.
	// It can be used to release OpenGL resources.
	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// called when the panel is created
		GL2 gl2 = drawable.getGL().getGL2();
		gl2.glMatrixMode(GL2.GL_PROJECTION);
		gl2.glOrtho(-1, 1, -1, 1, -1, 1);
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glClearColor(0, 0, 0, 1);
		gl2.glEnable(GL2.GL_DEPTH_TEST);
		gl2.glLineWidth(2);

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

}
