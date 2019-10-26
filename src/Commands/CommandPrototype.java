package Commands;

public interface CommandPrototype {
	//void createRectangle(int width, int height);
	/*
	� [w] is the required width of the rectangle
	� [h] is the required height of the rectangle
	� The origin of a created rectangle is the upper left hand corner at (0,0)
	� The color of a created rectangle is Red
	 */
	
	//void createCircle(int radius);
	/*
	� [r] is the required radius of the circle
	� The origin of a created circle is the center at (0,0)
	� The color of a created circle is Blue
	 */
	//Shape createShape(int...size);
	
	Object select(int numOfShape);
	/*
	� Selects a shape to use with future commands MOVE, DRAW, COLOR, DELETE
	� n is the total number of shapes
	� Currently selected shape defaults to a �no shape� value
	� Calling SELECT on a shape that does not exist in the list will produce the following
	error message �ERROR: invalid shape for SELECT�
	 */
	void move(int x, int y, Object shape);
	/*
	 � Moves the currently selected shape�s origin to the specified (x,y)
	 */
	
	void draw(Object shape);
	/*
	� Outputs the currently selected shape information to the console. 
	E.g.,
	Rectangle, Color: Red, Origin: (5,5), Width: 10, Height: 7
	Circle, Color: Blue, Origin: (10,9), Radius: 12 
	 */
	
	void color(String color, Object shape);
	/*
	� Sets the color of the currently selected shape.
	� [c] is one of the following valid colors:
	� Red, Blue, Yellow, Orange, Green 
	 */
	
	
	void delete(Object shape);
	/*
	� Removes the selected from the scene
	� Sets the currently selected shape to a �no shape� value
	 */
	
	
	void drawscene();
	/*
	� Draws all shapes in the scene using their current origins and colors
	� Output for each shape is the same as using the DRAW command
	 */
	
	
	void undo();
	/*
	� �Undoes� the most recent command in the drawing list
	� UNDO can be called after UNDO, which undoes the next most recent command in the
	drawing list
	� Undoing a SELECT command sets the currently selected shape to the previously
	selected shape (which could be �no shape�)
	� Undoing a MOVE command restores the selected shape to its previous position
	� Undoing a COLOR command restores the previous
	� Undoing a CREATE command deletes the shape
	� Undoing a DELETE restores the previously deleted shape to the scene. It should also
	restore the currently selected shape to the restored shape
	� Undoing DRAW or DRAWSCENE has no effect
	� The UNDO command is not stored on the drawing list (i.e., you cannot UNDO an
	UNDO) 
	 */
}
