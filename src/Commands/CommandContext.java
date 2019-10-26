package Commands;
import Shapes.*;

public class CommandContext {
    private Command commands;

    public CommandContext(Command commands) {
        this.commands = commands;
    }

    public Command getCommand() {
        return commands;
    }

    public void setCommand(Command commands) {
        this.commands = commands;
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
					//commands.createRectangle(x,y);
					//commands.createShape(x,y);
					commands.create(x,y);
				}
				if (newShape.equals("CIRCLE")) {
					int radius = Integer.parseInt(tempArray[2]);
					//commands.createCircle(radius);
					commands.create(radius);
				}
				break;
			case "SELECT":
                int numOfShape = Integer.parseInt(tempArray[1]);
                Shape selectedShape = (Shape) commands.select(numOfShape);
                commands.setSelectedShape(selectedShape);
				break;
			case "MOVE":
				int x = Integer.parseInt(tempArray[1]);
				int y = Integer.parseInt(tempArray[2]);
                commands.move(x, y, commands.getSelectedShape());
				break;
			case "DRAW":
				commands.draw(commands.getSelectedShape());
				break;
			case "COLOR":
                commands.color(tempArray[1], commands.getSelectedShape());
				break;
			case "DELETE":
                commands.delete(commands.getSelectedShape());
				break;
			case "DRAWSCENE":
                commands.drawscene();
				break;
			case "UNDO":
                commands.undo();
				break;
			default:
				System.out.println("ERROR: invalid command.");
				return;
		}
		if (!commandString.equals("UNDO"))
			commands.getCommandStack().add(commandString);
	}
}