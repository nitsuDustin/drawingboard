package Commands;

import Shapes.*;

public class CircleStrategy implements CreateCommand{
    public Circle createShape(int...radius) {
        Circle circle = new Circle.Builder(radius[0]).build();
        return circle;
    }
}