package Shapes;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String toString() {
		return "Circle, Color: " + super.getColor() 
				+ ", Origin (" + super.getX() + "," + super.getY()
				+ "), Radius: " + getRadius();
	}
}
