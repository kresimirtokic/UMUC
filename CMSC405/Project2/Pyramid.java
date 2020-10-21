
/*
 * Kresimir Tokic
 * 7/12/20
 * CMSC405 Comp Graphics 
 * Project 2
 * Pyramid class extends abstract Shape
 */

import com.jogamp.opengl.*;

public class Pyramid extends Shape {

	// private GLU glu = new GLU();
	private float rtri = 0.0f;

	// constructor
	public Pyramid(GL2 gl2, double size) {

		gl2.glPushMatrix();
		gl2.glScaled(size, size, size); // scale to desired size
		gl2.glShadeModel(GL2.GL_SMOOTH);

		// gl2.glTranslatef(-0.5f, 0.0f, -6.0f); // Move the triangle
		gl2.glRotatef(rtri, 0.0f, 1.0f, 0.0f);
		gl2.glBegin(GL2.GL_TRIANGLES);

		// drawing triangle in all dimensions
		// front
		gl2.glPushMatrix();
		gl2.glColor3f(1.0f, 0.0f, 0.0f); // Red
		gl2.glVertex3f(1.0f, 2.0f, 0.0f); // Top

		gl2.glColor3f(0.0f, 1.0f, 0.0f); // Green
		gl2.glVertex3f(-1.0f, -1.0f, 1.0f); // Left

		gl2.glColor3f(0.0f, 0.0f, 1.0f); // Blue
		gl2.glVertex3f(1.0f, -1.0f, 1.0f); // Right)
		gl2.glPopMatrix();

		// right
		gl2.glPushMatrix();
		gl2.glColor3f(1.0f, 0.0f, 0.0f);
		gl2.glVertex3f(1.0f, 2.0f, 0.0f); // Top

		gl2.glColor3f(0.0f, 0.0f, 1.0f);
		gl2.glVertex3f(1.0f, -1.0f, 1.0f); // Left

		gl2.glColor3f(0.0f, 1.0f, 0.0f);
		gl2.glVertex3f(1.0f, -1.0f, -1.0f); // Right
		gl2.glPopMatrix();

		// left
		gl2.glPushMatrix();
		gl2.glColor3f(1.0f, 0.0f, 0.0f);
		gl2.glVertex3f(1.0f, 2.0f, 0.0f); // Top

		gl2.glColor3f(0.0f, 1.0f, 0.0f);
		gl2.glVertex3f(1.0f, -1.0f, -1.0f); // Left

		gl2.glColor3f(0.0f, 0.0f, 1.0f);
		gl2.glVertex3f(-1.0f, -1.0f, -1.0f); // Right
		gl2.glPopMatrix();

		// top
		gl2.glPushMatrix();
		gl2.glColor3f(1.0f, 0.0f, 0.0f);
		gl2.glVertex3f(1.0f, 2.0f, 0.0f); // Top

		gl2.glColor3f(0.0f, 0.0f, 1.0f);
		gl2.glVertex3f(-1.0f, -1.0f, -1.0f); // Left

		gl2.glColor3f(0.0f, 1.0f, 0.0f);
		gl2.glVertex3f(-1.0f, -1.0f, 1.0f); // Right
		gl2.glPopMatrix();

		gl2.glEnd(); // Done Drawing 3d triangle (Pyramid)

		gl2.glFlush();
		rtri += 0.2f;
		gl2.glPopMatrix(); // restore matrix to before call
	}

	/*
	 * @Override public void init(GLAutoDrawable drawable) {
	 * 
	 * final GL2 gl = drawable.getGL().getGL2();
	 * 
	 * gl.glShadeModel(GL2.GL_SMOOTH); gl.glClearColor(0f, 0f, 0f, 0f);
	 * gl.glClearDepth(1.0f); gl.glEnable(GL2.GL_DEPTH_TEST);
	 * gl.glDepthFunc(GL2.GL_LEQUAL); gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT,
	 * GL2.GL_NICEST); }
	 */
	/*
	 * @Override public void reshape(GLAutoDrawable drawable, int x, int y, int
	 * width, int height) {
	 * 
	 * // TODO Auto-generated method stub final GL2 gl = drawable.getGL().getGL2();
	 * if (height <= 0) height = 1;
	 * 
	 * final float h = (float) width / (float) height; gl.glViewport(0, 0, width,
	 * height); gl.glMatrixMode(GL2.GL_PROJECTION); gl.glLoadIdentity();
	 * 
	 * glu.gluPerspective(45.0f, h, 1.0, 20.0); gl.glMatrixMode(GL2.GL_MODELVIEW);
	 * gl.glLoadIdentity(); }
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * // TODO Auto-generated method stub final GLProfile profile =
	 * GLProfile.get(GLProfile.GL2); GLCapabilities capabilities = new
	 * GLCapabilities(profile);
	 * 
	 * // The canvas final GLCanvas glcanvas = new GLCanvas(capabilities);
	 * Triangledepthtest triangledepthtest = new Triangledepthtest();
	 * 
	 * glcanvas.addGLEventListener(triangledepthtest); glcanvas.setSize(400, 400);
	 * 
	 * final JFrame frame = new JFrame("3d Triangle (solid)");
	 * frame.getContentPane().add(glcanvas);
	 * frame.setSize(frame.getContentPane().getPreferredSize());
	 * frame.setVisible(true); final FPSAnimator animator = new
	 * FPSAnimator(glcanvas, 300, true);
	 * 
	 * animator.start(); }
	 */
}
