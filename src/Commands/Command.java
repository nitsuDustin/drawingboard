package Commands;
import Shapes.*;
import java.util.*;
public class Command implements CommandPrototype {
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Stack<String> commands = new Stack<>();

	public Command(ArrayList<Shape> shapes, Stack<String> commands) {
		this.shapes = shapes;
		this.commands = commands;
	}

	public void callCommands(String commandString, Object shape) {
		String [] tempArray;
		tempArray = commandString.split(" ");
		String commandToExecute = tempArray[0];
		System.out.println(tempArray);
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
				int x = Integer.parseInt(tempArray[1]);
				int y = Integer.parseInt(tempArray[2]);
				move(x, y, shape);
				break;
			case "DRAW":
				draw(shape);
				break;
			case "COLOR":
				color(tempArray[1], shape);
				break;
			case "DELETE":
				delete(shape);
				break;
			case "DRAWSCENE":
				drawscene();
				break;
			case "UNDO":
				undo();
				break;
			default:
				System.out.println("ERROR: invalid command.");
				return;
		}
		commands.addElement(commandString);
	}


	@Override
	public void createRectangle(int width, int height) {
		Rectangle rectangle = new Rectangle(width, height);
		shapes.add(rectangle);
	}

	@Override
	public void createCircle(int radius) {
		Circle circle = new Circle(radius);
		shapes.add(circle);
		
	}

	@Override
	public Object select(int numOfShape) {
		if(shapes.size()-1 < numOfShape || numOfShape < 0) {
			System.out.println("ERROR: Invalid shape for SELECT");
			return null;
		}
		else
			return shapes.get(numOfShape);
	}

	@Override
	public void move(int x, int y, Object shape) {
		if (shape == null) {
			System.out.println("Error: Shape not selected.");
			return;
		}
		Shape newShape = (Shape) shape;
		newShape.setX(x);
		newShape.setY(y);
	}

	@Override
	public void draw(Object shape) {
		if (shape == null) {
			System.out.println("Error: Shape not selected.");
			return;
		}
		Shape newShape = (Shape) shape;
		System.out.print(newShape.toString());
		System.out.println();
	}

	@Override
	public void color(String color, Object shape) {
		if (shape == null) {
			System.out.println("Error: Shape not selected.");
			return;
		}
		Shape newShape = (Shape) shape;
		newShape.setColor(color);
	}

	@Override
	public void delete(Object shape) {
		if (shape == null) {
			System.out.println("Error: Shape not selected.");
			return;
		}
		Shape newShape = (Shape) shape;
		shapes.remove(newShape);
	}

	@Override
	public void drawscene() {
		for (int i = 0; i < shapes.size(); i++) {
			System.out.println(shapes.get(i).toString());
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
}
