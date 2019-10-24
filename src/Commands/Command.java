package Commands;
import Shapes.*;
import java.util.*;
public class Command implements CommandPrototype {
	private Rectangle rectangle;
	private Circle circle;
	private ArrayList<Object> shapes = new ArrayList<>();
	private Stack<String> commands = new Stack<>();
	

	public void callCommands(String command) {
		String [] tempArray;
		String delimiter = " ";
		tempArray = command.split(delimiter);
		String commandToExecute = tempArray[0];
		switch (commandToExecute) {
			case "CREATE":
				String newShape = tempArray[1];
				if (newShape == "RECTANGLE") {
					int x = Integer.parseInt(tempArray[2]);
					int y = Integer.parseInt(tempArray[3]);
					createRectangle(x,y);
				}
				if (newShape == "CIRCLE") {
					int radius = Integer.parseInt(tempArray[2]);
					createCircle(radius);
				}
				break;
			case "SELECT":
				int numOfShape = Integer.parseInt(tempArray[1]);
				select(numOfShape);
				break;
			case "MOVE":
				break;
			case "DRAW":
				break;
			case "COLOR":
				break;
			case "DELETE":
				break;
			case "DRAWSCENE":
				drawscene();
				break;
			case "UNDO":
				undo();
				break;
			default:
				System.out.println("ERROR: invalid command.");
		}
	}
	@Override
	public void createRectangle(int width, int height) {
		rectangle = new Rectangle(width, height);
		shapes.add(rectangle);
	}

	@Override
	public void createCircle(int radius) {
		circle = new Circle(radius);
		shapes.add(circle);
		
	}

	@Override
	public Object select(int numOfShape) {
		if(shapes.get(numOfShape-1) == null) {
			System.out.println("ERROR: Invalid shape for SELECT");
			return null;
		}
		else
			return shapes.get(numOfShape-1);
	}

	@Override
	public void move(int x, int y, Object shape) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void draw(Object shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void color(String color, Object shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawscene() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
