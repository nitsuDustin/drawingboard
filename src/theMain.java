import Commands.*;
import Shapes.*;
import java.util.*;
import java.io.*;

public class theMain {
    public static void main(String args[]) {
        ArrayList<Shape> shapes = new ArrayList<>();
        Stack<String> commands = new Stack<>();
        Command theCommands = new Command(shapes, commands);
        
        BufferedReader reader;
        try {
            reader = new BufferedReader
                    (new FileReader("src/data/commands1.txt"));
            String command = reader.readLine();
            while (command != null) {
                theCommands.callCommands(command); 
                command = reader.readLine(); 
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        System.out.println("Input a Rectangle and a Circle: two shapes will appear");
        theCommands.callCommands("CREATE RECTANGLE 10 7");
        theCommands.callCommands("CREATE CIRCLE 10");
        theCommands.callCommands("DRAWSCENE");
        System.out.println();

        System.out.println("Select, color, move, and draw Circle");
        theCommands.callCommands("SELECT 2");
        theCommands.callCommands("COLOR Blue");
        theCommands.callCommands("MOVE 10 10");
        theCommands.callCommands("DRAW");
        System.out.println();
        
        System.out.println("Select, color, move, and draw Rectangle");
        theCommands.callCommands("SELECT 1");
        theCommands.callCommands("COLOR Yellow");
        theCommands.callCommands("MOVE 11 1");
        theCommands.callCommands("DRAW");
        System.out.println();

        System.out.println("Delete Rectangle: One Shape will appear");
        theCommands.callCommands("DELETE");
        theCommands.callCommands("DRAWSCENE");
        System.out.println();

        System.out.println("Select outside of Shapes ArrayList: Should error");        
        theCommands.callCommands("SELECT 2");
        theCommands.callCommands("SELECT -1");
        System.out.println();
        
        System.out.println("Add two more elements: three shapes should appear");
        theCommands.callCommands("CREATE RECTANGLE 10 7");
        theCommands.callCommands("CREATE CIRCLE 20");
        theCommands.callCommands("DRAWSCENE");
        System.out.println();
        
        System.out.println("Change new shapes");
        theCommands.callCommands("SELECT 3");
        theCommands.callCommands("COLOR Yellow");
        theCommands.callCommands("MOVE 2 20");

        theCommands.callCommands("SELECT 2");
        theCommands.callCommands("COLOR Green");
        theCommands.callCommands("MOVE 21 3");
        theCommands.callCommands("DRAWSCENE");
        System.out.println();   
        
        System.out.println("Color error");
        theCommands.callCommands("COLOR Purple");
        theCommands.callCommands("COLOR Pink");
        System.out.println();   

        System.out.println("Delete Rectangle");
        theCommands.callCommands("DELETE");
        theCommands.callCommands("DRAWSCENE");
        System.out.println();
    */
    }
}