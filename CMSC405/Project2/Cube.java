
/*
 * Kresimir Tokic
 * 7/12/20
 * CMSC405 Comp Graphics 
 * Project 2
 * Cube class extends abstract Shape
 */

import com.jogamp.opengl.GL2;

public class Cube extends Shape  {

	// makes squares
    private void square(GL2 gl2, double r, double g, double b) {
        gl2.glColor3d(r,g,b);
        gl2.glBegin(GL2.GL_TRIANGLE_FAN);
        gl2.glVertex3d(-0.5, -0.5, 0.5);
        gl2.glVertex3d(0.5, -0.5, 0.5);
        gl2.glVertex3d(0.5, 0.5, 0.5);
        gl2.glVertex3d(-0.5, 0.5, 0.5);
        gl2.glEnd();
    }
    
    // constructs cube
    public Cube(GL2 gl2, double size) {
        gl2.glPushMatrix();
        gl2.glScaled(size,size,size); // scale unit cube to desired size
        
        square(gl2,1, 0, 0); // red front face
        
        gl2.glPushMatrix();
        gl2.glRotated(90, 0, 1, 0);
        square(gl2,0, 1, 0); // green right face
        gl2.glPopMatrix();
        
        gl2.glPushMatrix();
        gl2.glRotated(-90, 1, 0, 0);
        square(gl2,0, 0, 1); // blue top face
        gl2.glPopMatrix();
        
        gl2.glPushMatrix();
        gl2.glRotated(180, 0, 1, 0);
        square(gl2,0, 1, 1); // cyan back face
        gl2.glPopMatrix();
        
        gl2.glPushMatrix();
        gl2.glRotated(-90, 0, 1, 0);
        square(gl2,1, 0, 1); // magenta left face
        gl2.glPopMatrix();
        
        gl2.glPushMatrix();
        gl2.glRotated(90, 1, 0, 0);
        square(gl2,1, 1, 0); // yellow bottom face
        gl2.glPopMatrix();
        
        gl2.glPopMatrix(); // Restore matrix to its state before cube() was called.
    }
}
