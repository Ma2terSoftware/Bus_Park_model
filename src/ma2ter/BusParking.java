package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class BusParking implements Drawable{
	static final Point DEFAULT_LOCATION = new Point(50,50);
	static final Dimension DEFAULT_SIZE = new Dimension(40,40);
	static final int DEFAULT_CAPACITY = 25;
	static final String DEFAULT_NAME = "Автобусный парк";
	static final Color DEFAULT_COLOR = Color.black;
	
	private Point location;
	private int capacity;
	private Dimension size;
	private String name;
	private Color color;
	//SETTERS
	public void testLoc(Point loc){
		location = loc;
	}
	//GETTERS
 	public int getCap(){
		return capacity;
	}
	
 	public Color getColor(){
 		return color;
 	}
 	public Point getLoc(){
		return location;
	}
	public Dimension getSize(){
		return size;
	}
	public String getName(){
		return name;
	}
	//CONSTRUCTORS
	public BusParking(){
		location = DEFAULT_LOCATION;
		size = DEFAULT_SIZE;
		capacity = DEFAULT_CAPACITY;
		name = DEFAULT_NAME;
		color = DEFAULT_COLOR;
		Graph.addDrawable(this);
	}
 	public BusParking(int x, int y, int cap){
		location = new Point(x,y);
		size = DEFAULT_SIZE;
		capacity = cap;
	}
 	public BusParking(Point p, int cap){
		location = p;
		size = DEFAULT_SIZE;
		capacity = cap;
	}
}
