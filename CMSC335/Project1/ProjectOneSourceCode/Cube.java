/*
 * Kresimir TOkic
 * March 25 2020
 * Cube.java
 * sublcass of ThreeDimensionalShape
 */

public class Cube extends ThreeDimensionalShape {
	
	// variables
	double side;
	
	// constructor
	public Cube(double side) {
		this.side = side;
	}

	//getters
	public double getSide() {
		return side;
	}
		
	// setters 
	public void setSide(double side) {
		this.side = side;
	}
	
	// method returns volume
	@Override
	public double getVolume() {
		double volume = side * side * side;
		return volume;
	}

}
