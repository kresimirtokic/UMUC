/*
 * Kresimir TOkic
 * March 25 2020
 * Circle.java
 * subclass of TwoDimensionalShape
 */

public class Circle extends TwoDimensionalShape {
	
	//variables
	double radius;
	static final double PI = 3.14;

	// constructor 
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// getters
	public double getRadius() {
		return radius;
	}
	
	// setters 
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// returns area of circle
	@Override
	public double getArea() {
		double area = 2 * PI * radius;
		return area;
	}
	
	// method returns circumference
	public double getCircumference() {
		double circumference = 2 * PI * radius;
		return circumference;
	}

}
