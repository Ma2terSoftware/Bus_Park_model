package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class BusParking extends Hub{
	final Point DEFAULT_LOCATION = new Point(50,50);
	final Dimension DEFAULT_SIZE = new Dimension(40,40);
	final int DEFAULT_CAPACITY = 25;
	final String DEFAULT_NAME = "Автобусный парк";
	final Color DEFAULT_COLOR = Color.black;
	
	private int capacity;
	//SETTERS
	public void testLoc(Point loc){
		location = loc;
	}
	//GETTERS
 	public int getCap(){
		return capacity;
	}
	
	//CONSTRUCTORS
	public BusParking(){
		location = DEFAULT_LOCATION;
		size = DEFAULT_SIZE;
		capacity = DEFAULT_CAPACITY;
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
