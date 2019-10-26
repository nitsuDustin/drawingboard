package Commands;
import Shapes.*;
import java.util.*;
public class Command implements CommandPrototype {
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Stack<String> commands = new Stack<>();
	private Stack<Shape> deletedShapes = new Stack<>();
	private Stack<Object> previousSelectedShapes = new Stack<>();
	private Shape selectedShape;

	public Command(ArrayList<Shape> shapes, Stack<String> commands) {
		this.shapes = shapes;
		this.commands = commands;
		this.selectedShape = null;
	}

	@Override
	public void createShape(int...param) {
		if(param.length == 2) {
			Rectangle rectangle = new Rectangle.Builder(param[0], param[1]).build();
			shapes.add(rectangle);
		}
		if(param.length == 1) {
			Circle circle = new Circle.Builder(param[0]).build();
			shapes.add(circle);
		}
	}

	@Override
	public Object select(int numOfShape) {
		if(shapes.size() < numOfShape || numOfShape < 1) {
			System.out.println("ERROR: Invalid shape for SELECT");
			return selectedShape;
		}
		else
			if (selectedShape != null)
				previousSelectedShapes.add(selectedShape);
			return shapes.get(numOfShape - 1);
	}

	@Override
	public void move(int x, int y, Object shape) {
		if (shape == null) {
			System.out.println("Error: Shape not selected.");
			return;
		}
		Shape newShape = (Shape) shape;

		Shape prevShape = new Shape();
		prevShape.setNewShape(newShape);
		newShape.getPreviousShapeStack().add(prevShape);

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

			Shape prevShape = new Shape();
			prevShape.setNewShape(newShape);
			newShape.getPreviousShapeStack().add(prevShape);

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
		deletedShapes.add(newShape);
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
		String command = commands.pop();
		String [] tempArray = command.split(" ");
		String undoCommand = tempArray[0];
		Shape tempShape;
		switch (undoCommand) {
			case "CREATE":
				delete(shapes.get(shapes.size() - 1));
				break;
			case "SELECT":
				selectedShape = (Shape) previousSelectedShapes.pop();
				break;
			case "MOVE":
				tempShape = selectedShape.getPreviousShapeStack().pop();
				selectedShape.setX(tempShape.getX());
				selectedShape.setY(tempShape.getY());
				break;
			case "COLOR":
				tempShape = selectedShape.getPreviousShapeStack().pop();
				selectedShape.setColor(tempShape.getColor());
				break;
			case "DELETE":
				tempShape = deletedShapes.pop();
				shapes.add(tempShape);
				break;
			default:
		}
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
	public Stack<Shape> getDelectedShapeStack() {
		return deletedShapes;
	}
	public void setDeletedShapeStack(Stack<Shape> deletedShapes) {
		this.deletedShapes = deletedShapes;
	}
	public Stack<Object> getPreviousSelectedShapes() {
		return previousSelectedShapes;
	}
	public void setPreviousSelectedShapes(Stack<Object> prev) {
		previousSelectedShapes = prev;
	}

}
