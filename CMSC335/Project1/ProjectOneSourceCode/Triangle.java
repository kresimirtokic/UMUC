/*
 * Kresimir TOkic
 * March 25 2020
 * Traingle.java
 * subclass of TwoDimensionalShape
 */

public class Triangle extends TwoDimensionalShape {

	// variables
	double base, height;

	// constructor
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	// getters
	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	// setters
	public void setBase(double base) {
		this.base = base;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// returns area
	@Override
	public double getArea() {
		double area = (base * height) / 2;
		return area;
	}

}
