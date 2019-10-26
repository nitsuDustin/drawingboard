package Shapes;

public class Rectangle extends Shape {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		super();
		super.setColor("Red");
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Rectangle, Color: " + super.getColor() 
				+ ", Origin (" + super.getX() + "," + super.getY()
				+ "), Width: " + getWidth() + ", Height: " + getHeight();
	}
}
