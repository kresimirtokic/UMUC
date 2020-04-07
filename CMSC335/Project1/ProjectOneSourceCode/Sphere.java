/*
 * Kresimir TOkic
 * March 25 2020
 * Sphere.java
 * subclass of ThreeDimensionalShape
 */

public class Sphere extends ThreeDimensionalShape {
	
	// variables
	double radius;
	static final double PI = 3.14;
	static final double FOUR_THIRDS = 1.33;
	
	// constructor
	public Sphere(double radius) {
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

	// returns volume
	@Override
	public double getVolume() {
		double volume = FOUR_THIRDS * PI * (radius * radius * radius);
		return volume;
	}

}
