
/*
 * Kresimir Tokic
 * 7/12/20
 * CMSC405 Comp Graphics 
 * Project 2
 * Fan class extends abstract Shape
 */

import com.jogamp.opengl.GL2;

public class Fan extends Shape {

	private float rotation = 0.0f;

	// constructor
	public Fan(GL2 gl2, double size) {
		gl2.glPushMatrix();
		gl2.glScaled(size, size, size); // scale unit to desired size
		gl2.glRotatef(rotation, 1f, 0f, 0f);
		gl2.glColor3d(0.35, 0.91, 0.95);
		gl2.glBegin(GL2.GL_POLYGON);
		gl2.glVertex3d(-0.5, 0.3, 0.8);
		gl2.glVertex3d(0.5, 0.3, 0.8);
		gl2.glVertex3d(0.8, 0.7, 0.8);
		gl2.glVertex3d(-0.8, 0.7, 0.8);
		gl2.glEnd();

		int blades = 20;
		for (int i = 0; i <= blades; i++) {
			gl2.glRotated(360.0 / blades, 1, 0, 0);

			gl2.glBegin(GL2.GL_POLYGON);
			gl2.glColor3d(0.35, 0.91, 0.95);
			gl2.glVertex3d(-0.5, 0.3, 0.8);
			gl2.glVertex3d(0.5, 0.3, 0.8);
			gl2.glVertex3d(0.8, 0.7, 0.8);
			gl2.glVertex3d(-0.8, 0.7, 0.8);
			gl2.glEnd();
		}
		rotation -= 0.2f;
		gl2.glPopMatrix();
	}
}
