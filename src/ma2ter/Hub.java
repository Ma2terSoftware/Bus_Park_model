package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Hub{
	
	static final Dimension DEFAULT_SIZE = new Dimension(10,10);
	static final Color DEFAULT_COLOR = Color.black;
	
	protected Dimension size;
	protected Point location;
	protected int id;
	
	//GETTERS
	public int getId(){
		return id;
	}
	public Point getLocation(){
		return location;
	}
	//CONSTRUCTORS
	public Hub(Point location, int id){
		this.location = location;
		this.id = id;
		size = DEFAULT_SIZE;
	}
	public Hub(){}
}
