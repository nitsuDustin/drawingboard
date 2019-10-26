package Commands;
import Shapes.*;
public interface CreateCommand {
    Shape createShape(int...param);
}