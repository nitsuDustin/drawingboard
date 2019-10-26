package Shapes;
import java.util.*;

public class Shape {
    private int x;
    private int y;
    private String color;
    private Stack<Shape> prevShape = new Stack<>();
    
    public Shape() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Stack<Shape> getPreviousShapeStack() {
        return prevShape;
    }

    public void setPreviousShapeStack(Stack<Shape> prevShape) {
        this.prevShape = prevShape;
    }

    public void setNewShape(Shape oldShape) {
        this.x = oldShape.getX();
        this.y = oldShape.getY();
        this.color = oldShape.getColor();
    }


    public String toString() {
        return x + ", " + y + ", " + color;
    }
}