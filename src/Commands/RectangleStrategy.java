package Commands;

import Shapes.*;

public class RectangleStrategy implements CreateCommand{
    public Rectangle createShape(int...param) {
        Rectangle rectangle = new Rectangle.Builder(param[0], param[1]).build();
        return rectangle;
    }
}