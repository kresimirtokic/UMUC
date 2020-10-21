
/*
 * Kresimir Tokic
 * 7/12/20
 * CMSC405 Comp Graphics 
 * Project 2
 * Star class extends abstract Shape
 */

import com.jogamp.opengl.GL2;

public class Star extends Shape {

	private void traingles(GL2 gl2, double r, double g, double b) {
		gl2.glColor3d(r, g, b);
		gl2.glBegin(GL2.GL_TRIANGLE_FAN);
		gl2.glVertex3d(0, 0, 1);
		gl2.glVertex3d(0.25, 0, 0);
		gl2.glVertex3d(0, 0.25, 0);
		gl2.glVertex3d(-0.25, 0, 0);
		gl2.glVertex3d(0, -0.25, 0);
		gl2.glEnd();
	}

	public Star(GL2 gl2, double size) {
		gl2.glPushMatrix();
		gl2.glScaled(size, size, size);

		traingles(gl2, 1, 1, .2);

		gl2.glPushMatrix();
		gl2.glRotated(180, 0, 1, 0);
		traingles(gl2, 1, 1, .2);
		gl2.glPopMatrix();

		gl2.glPushMatrix();
		gl2.glRotated(90, 0, 1, 0);
		traingles(gl2, 1, 1, .2);
		gl2.glPopMatrix();

		gl2.glPushMatrix();
		gl2.glRotated(-90, 0, 1, 0);
		traingles(gl2, 1, 1, .2);
		gl2.glPopMatrix();

		gl2.glPopMatrix();
	}
}