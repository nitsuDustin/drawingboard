package Commands;
import Shapes.*;
import java.util.*;
public class Command implements CommandPrototype
{
	private Rectangle rectangle;
	private Circle circle;
	private ArrayList<Object> shapes = new ArrayList<>();
	
	@Override
	public void createRectangle(int width, int height) 
	{
		rectangle = new Rectangle(width, height);
		shapes.add(rectangle);
	}

	@Override
	public void createCircle(int radius) 
	{
		circle = new Circle(radius);
		shapes.add(circle);
		
	}

	@Override
	public Object select(int numOfShape) 
	{
		if(shapes.get(numOfShape-1) == null) 
		{
			System.out.println("ERROR: Invalid shape for SELECT");
			return null;
		}
		else
			return shapes.get(numOfShape-1);
	}

	@Override
	public void move(int x, int y, Object shape) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Object shape) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void color(String color, Object shape) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object shape) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawscene() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() 
	{
		// TODO Auto-generated method stub
		
	}
}
