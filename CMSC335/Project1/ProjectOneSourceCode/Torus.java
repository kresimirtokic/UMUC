/*
 * Kresimir TOkic
 * March 25 2020
 * Torus.java
 * subclass of ThreeDimensionalShape
 */

public class Torus extends ThreeDimensionalShape {

	// variables
	double minorRadius, majorRadius;
	static final double PI = 3.14;

	// constructor
	public Torus(double minorRadius, double majorRadius) {
		this.minorRadius = minorRadius;
		this.majorRadius = majorRadius;
	}

	// getters
	public double getMinorRadius() {
		return minorRadius;
	}

	public double getMajorRadius() {
		return majorRadius;
	}

	// setters
	public void setMinorRadius(double minorRadius) {
		this.minorRadius = minorRadius;
	}

	public void setMajorRadius(double majorRadius) {
		this.majorRadius = majorRadius;
	}

	// returns volume
	@Override
	public double getVolume() {
		double volume = (PI * (minorRadius * minorRadius)) * (2 * PI * majorRadius);
		return volume;
	}

}
