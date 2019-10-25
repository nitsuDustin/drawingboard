package Shapes;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		super();
		super.setColor("Blue");
		this.radius = radius;
		super.setColor("Blue");
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
