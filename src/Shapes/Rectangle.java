package Shapes;

public class Rectangle {
	private int width;
	private int height;
	private String color;
	private int x;
	private int y;

	public Rectangle(int width, int height) 
	{
		this.width = width;
		this.height = height;
		this.color = "Red";
		this.x = 0;
		this.y = 0;
	}
	
	public int getWidth() 
	{
		return this.width;
	}
	
	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	public int getHeight() 
	{
		return this.height;
	}
	
	public void setHeight(int height) 
	{
		this.height = height;
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
