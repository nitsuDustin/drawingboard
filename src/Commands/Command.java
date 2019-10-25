package Commands;
import Shapes.*;
import java.util.*;
public class Command implements CommandPrototype {
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Stack<String> commands = new Stack<>();
	private Object selectedShape;

	public Command(ArrayList<Shape> shapes, Stack<String> commands) {
		this.shapes = shapes;
		this.commands = commands;
		this.selectedShape = null;
	}

	public ArrayList<Shape> getShapeArrayList() {
		return shapes;
	}

	public void setShapeArrayList(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Stack<String> getCommandStack() {
		return commands;
	}

	public void setCommandStack(Stack<String> commands) {
		this.commands = commands;
	}

	public Object getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	public void callCommands(String commandString) {
		String [] tempArray = commandString.split(" ");
		String commandToExecute = tempArray[0];
		switch (commandToExecute) {
			case "CREATE":
				String newShape = tempArray[1];
				if (newShape.equals("RECTANGLE")) {
					int x = Integer.parseInt(tempArray[2]);
					int y = Integer.parseInt(tempArray[3]);
					createRectangle(x,y);
				}
				if (newShape.equals("CIRCLE")) {
					int radius = Integer.parseInt(tempArray[2]);
					createCircle(radius);
				}
				break;
			case "SELECT":
				int numOfShape = Integer.parseInt(tempArray[1]);
				selectedShape = select(numOfShape);
				break;
			case "MOVE":
				int x = Integer.parseInt(tempArray[1]);
				int y = Integer.parseInt(tempArray[2]);
				move(x, y, selectedShape);
				break;
			case "DRAW":
				draw(selectedShape);
				break;
			case "COLOR":
				color(tempArray[1], selectedShape);
				break;
			case "DELETE":
				delete(selectedShape);
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
		if (!commandString.equals("UNDO"))
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
		if(shapes.size() < numOfShape || numOfShape < 1) {
			System.out.println("ERROR: Invalid shape for SELECT");
			return selectedShape;
		}
		else
			return shapes.get(numOfShape - 1);
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
		List<String> validColors = Arrays.asList("Red", "Blue", "Yellow", "Orange", "Green");
		if (validColors.contains(color)) {
			Shape newShape = (Shape) shape;
			newShape.setColor(color);
		} else {
			System.out.println("ERROR: Invalid Color.");
		}
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
