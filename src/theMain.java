import Commands.*;
import Shapes.*;
import java.util.*;

public class theMain {
    public static void main(String args[]) {
        //String command = "CREATE RECTANGLE 5 7";
        Shape tempShape = null;
        //String [] tempArray;
        ArrayList<Shape> shapes = new ArrayList<>();
        Stack<String> commands = new Stack<>();
        Command theCommands = new Command(shapes, commands);
        
        System.out.println("Input a Rectangle and a Circle: two shapes will appear");
        theCommands.createRectangle(10, 7);
        theCommands.createCircle(10);
        theCommands.drawscene();
        System.out.println();

        System.out.println("Select, color, move, and draw both shapes");
        tempShape = (Shape) theCommands.select(1);
        theCommands.color("Blue", tempShape);
        theCommands.move(10, 10, tempShape);
        theCommands.draw(tempShape);
        System.out.println();
        
        System.out.println("Select, color, move, and draw Rectangle");
        tempShape = (Shape) theCommands.select(0);
        theCommands.move(11, 1, tempShape);
        theCommands.color("Yellow", tempShape);
        theCommands.draw(tempShape);
        System.out.println();

        System.out.println("Delete Rectangle: One Shape will appear");
        theCommands.delete(tempShape);
        theCommands.drawscene();
        System.out.println();

        System.out.println("Select outside of Shapes ArrayList: Should error");        
        tempShape = (Shape) theCommands.select(2);
        tempShape = (Shape) theCommands.select(-1);
        System.out.println();
        
        System.out.println("Add two more elements: three shapes should appear");
        theCommands.createRectangle(20, 10);
        theCommands.createCircle(20);
        theCommands.drawscene();
        System.out.println();
        
        System.out.println("Change shape at index 1 & 2");
        tempShape = (Shape) theCommands.select(2);
        theCommands.color("Yellow", tempShape);
        theCommands.move(2, 20, tempShape);

        tempShape = (Shape) theCommands.select(1);
        theCommands.color("Purple", tempShape);
        theCommands.move(3, 21, tempShape);
        theCommands.drawscene();
        System.out.println();   
        
        System.out.println("Delete shape at index 1");
        theCommands.delete(tempShape);
        theCommands.drawscene();
        System.out.println();

    }
}