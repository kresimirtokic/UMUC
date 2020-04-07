
public class Cone extends Cylinder {

	// variables
	double height, baseRadius;
	static final double PI = 3.14;
	
	// constructor
	public Cone(double height, double baseRadius) {
		super(height, baseRadius);
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
		double volume = (PI * (baseRadius * baseRadius) * height) / 3;
		return volume;
	}

}
