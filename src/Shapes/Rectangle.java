package Shapes;

public class Rectangle extends Shape {
	
	private final int width;
	private final int height;

	private Rectangle(Builder builder) {
		this.width = builder.width;
		this.height = builder.height;
		super.setColor("Red");
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Rectangle, Color: " + super.getColor() 
				+ ", Origin (" + super.getX() + "," + super.getY()
				+ "), Width: " + getWidth() + ", Height: " + getHeight();
	}

	public static class Builder {
		private final int width;
		private final int height;

		public Builder(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public Rectangle build() {
			Rectangle rectangle = new Rectangle(this);
			return rectangle;
		}
	}
}