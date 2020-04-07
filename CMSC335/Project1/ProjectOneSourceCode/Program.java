
/*
 * Kresimir TOkic
 * March 25 2020
 * Program.java
 * This is the command line program that creates
 * the objects and menus and outputs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Program {

	// variables
	static final Date TODAY = Calendar.getInstance().getTime();
	static final SimpleDateFormat SDF = new SimpleDateFormat("MMM dd 'at' h:mm a");
	static final String WELCOME = "*********Welcome to the Java OO Shapes Program ********** \n";
	static final String MENU = "\n1. Construct a Circle" + "\n2. Construct a Rectangle " + "\n3. Construct a Square "
			+ "\n4. Construct a Triangle " + "\n5. Construct a Sphere " + "\n6. Construct a Cube "
			+ "\n7. Construct a Cone " + "\n8. Construct a Cylinder " + "\n9. Construct a Torus "
			+ "\n10. Exit the program" + "\n\nSelect from the menu above:";
	static final String CONFIRMATION = "You have selected a ";
	static final String CONTINUE = "Would you like to continue? (Y or N)";
	static final String INVALID = "Invalid entry, try again:\n";
	static final String EXIT = "Thanks for using the program. Today is " + SDF.format(TODAY);
	static final String AREA = "The area of the shape is: ";
	static final String VOL = "The volume of the shape is: ";
	double dim1;
	double[] dims = new double[2];
	String input = null;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	// prints welcome and triggers showTopMenu
	public void run() {
		System.out.println(WELCOME);
		try {
			showTopMenu();
		} catch (IOException e) {
			System.out.println("IOException Occured.");
		}
	}

	// method shows top display and triggers getInput & verifyInput
	private void showTopMenu() throws IOException {
		System.out.println(MENU);
		getInput();
		verifyInput(input);
	}

	// method returns user input
	private String getInput() throws IOException {
		return input = reader.readLine();
	}

	// method verifies input for top menu choices
	private void verifyInput(String input) throws IOException {
		// check if string is number 1 -10
		if (input.matches("[1-9]")) {
			constructShape(input);
		} else if (input.matches("10")) {
			System.out.println(EXIT);
		} else {
			System.out.print(INVALID);
			showTopMenu();
		}
	}

	// method constructs shapes
	private void constructShape(String input) throws IOException {
		switch (input) {
		case "1":
			System.out.print(CONFIRMATION + "Circle\n");
			dim1 = radiusInput();
			Shape circ = new Circle(dim1);
			printData(circ);
			constructMore();
			break;
		case "2":
			System.out.print(CONFIRMATION + "Rectangle\n");
			dims = baseAndHeightInput();
			Shape rect = new Rectangle(dims[0], dims[1]);
			printData(rect);
			constructMore();
			break;
		case "3":
			System.out.print(CONFIRMATION + "Square\n");
			dim1 = sideInput();
			Shape sq = new Square(dim1);
			printData(sq);
			constructMore();
			break;
		case "4":
			System.out.print(CONFIRMATION + "Triangle\n");
			dims = baseAndHeightInput();
			Shape tri = new Triangle(dims[0], dims[1]);
			printData(tri);
			constructMore();
			break;
		case "5":
			System.out.print(CONFIRMATION + "Sphere\n");
			dim1 = radiusInput();
			Shape sphr = new Sphere(dim1);
			printData(sphr);
			constructMore();
			break;
		case "6":
			System.out.print(CONFIRMATION + "Cube\n");
			dim1 = sideInput();
			Shape cb = new Cube(dim1);
			printData(cb);
			constructMore();
			break;
		case "7":
			System.out.print(CONFIRMATION + "Cone\n");
			dims = radiusAndHeight();
			Shape cn = new Cone(dims[0], dims[1]);
			printData(cn);
			constructMore();
			break;
		case "8":
			System.out.print(CONFIRMATION + "Cylinder\n");
			dims = radiusAndHeight();
			Shape cyl = new Cylinder(dims[0], dims[1]);
			printData(cyl);
			constructMore();
			break;
		case "9":
			System.out.print(CONFIRMATION + "Torus\n");
			dims = minorAndMajorRadius();
			Shape tor = new Torus(dims[0], dims[1]);
			printData(tor);
			constructMore();
			break;
		}
	}

	// method gets user input dimension and verify it
	private double getDimension() throws IOException {
		try {
			dim1 = Double.parseDouble(reader.readLine());
		} catch (NumberFormatException e2) {
			System.out.print(INVALID);
			getDimension();
		}
		return dim1;
	}

	// method prompts to continue playing
	private void constructMore() throws IOException {
		System.out.print(CONTINUE);
		getInput();
		yOrN(input);
	}

	// method verify input Y or N shows relevant menus
	private void yOrN(String input) throws IOException {
		if (input.matches("Y|y")) {
			showTopMenu();
		} else if (input.matches("N|n")) {
			System.out.println(EXIT);
		} else {
			System.out.print(INVALID);
			constructMore();
		}
	}

	// method prints relevant area or volume
	private void printData(Shape aShape) {
		if (aShape instanceof TwoDimensionalShape) {
			System.out.println(AREA + ((TwoDimensionalShape) aShape).getArea());
		} else if (aShape instanceof ThreeDimensionalShape) {
			System.out.println(VOL + ((ThreeDimensionalShape) aShape).getVolume());
		}		
	}
	
	
	// method returns radius
	private double radiusInput() throws IOException {
		System.out.print("Enter radius: ");
		dim1 = getDimension();	
		return dim1;
	}

	// method returns base and height
	private double[] baseAndHeightInput() throws IOException {
		System.out.print("Enter length of base: ");
		dims[0] = getDimension();
		System.out.print("Enter height: ");
		dims[1] = getDimension();
		return dims;
	}
	
	// method returns length of a side
	private double sideInput() throws IOException{
		System.out.print("Enter length of a side: ");
		dim1 = getDimension();
		return dim1;
	}
	
	// method returns base radius and height
	private double[] radiusAndHeight() throws IOException {
		System.out.print("Enter base radius: ");
		dims[0] = getDimension();
		System.out.print("Enter height: ");
		dims[1] = getDimension();
		return dims;
	}
	
	// method returns minor and major radius
	private double[] minorAndMajorRadius() throws IOException {
		System.out.print("Enter minor radius: ");
		dims[0] = getDimension();
		System.out.print("Enter major radius: ");
		dims[1] = getDimension();
		return dims;
	}
	
}
