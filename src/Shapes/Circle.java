package Shapes;

public class Circle {
	private int radius;
	private String color;
	private int x;
	private int y;
	
	public Circle(int radius) 
	{
		this.radius = radius;
		this.color = "Blue";
		this.x = 0;
		this.y = 0;
	}

	public int getRadius() 
	{
		return this.radius;
	}

	public void setRadius(int radius) 
	{
		this.radius = radius;
	}

	public String getColor() 
	{
		return this.color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}

	public int getX() 
	{
		return this.x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return this.y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}
}
