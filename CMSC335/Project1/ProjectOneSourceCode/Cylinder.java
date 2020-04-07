/*
 * Kresimir TOkic
 * March 25 2020
 * Cylinder.java
 * subclass of ThreeDeminsionalShape
 */

public class Cylinder extends ThreeDimensionalShape {

	// variables
	double height, baseRadius;
	static final double PI = 3.14;
	
	// constructor
	public Cylinder(double height, double baseRadius) {
		this.height = height;
		this.baseRadius = baseRadius;
	}
	
	// getters
	public double getHeight() {
		return height;
	}
	
	public double getBaseRadius() {
		return baseRadius;
	}
	
	// setters
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setBaseRadius(double baseRadius) {
		this.baseRadius = baseRadius;
	}
	

	// returns volume
	@Override
	public double getVolume() {
		double volume = PI * (baseRadius * baseRadius) * height;
		return volume;
	}

}
