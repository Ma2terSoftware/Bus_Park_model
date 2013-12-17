package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public abstract class GraphicObject {
	
	
	protected Color color;
	protected Dimension size;
	protected Point location;
	protected String name;
	
	//GETTERS
	
	protected Color getColor(){
		return color;
	}
	
	protected Dimension getSize(){
		return size;
	}
	
	protected Point getLocation(){
		return location;
	}
	
	protected String getName(){
		return name;
	}
	
}
