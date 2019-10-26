package Shapes;

public class Circle extends Shape {
	
	private final int radius;

	private Circle(Builder builder) {
		this.radius = builder.radius;
		super.setColor("Blue");
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Circle, Color: " + super.getColor() 
				+ ", Origin (" + super.getX() + "," + super.getY()
				+ "), Radius: " + getRadius();
	}

	public static class Builder {
		private final int radius;

		public Builder(int radius) {
			this.radius = radius;
		}

		public Circle build() {
			Circle circle = new Circle(this);
			return circle;
		}
	}
}