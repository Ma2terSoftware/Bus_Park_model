package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class Bus implements Drawable{
	
	static final Dimension DEFAULT_SIZE = new Dimension(20,20);
	static final int MAX_NUMBEROFPASSENGERS = 25;
	static final int MAX_SPEED = 80;
	static final Color DEFAULT_COLOR = Color.green;
	
	private int speed = 3;
	private int numberOfPassengers = 0;
	private int numRoute = 0;
	private int id = 0;
	private boolean isOnRoute = false;
	private Point destination = null;
	private Color color; 
	
	private Dimension size;
	private Point location;
	// GETTERS
	public Point getLoc(){
		return location;
	}
	public Dimension getSize(){
		return size;
	}
	public String getName(){
		return ""+id;
	}
	public Color getColor(){
		return color;
	}
	
	public int getSpeed(){
		return speed;
	}
	public int getNumberOfPassengers(){
		return numberOfPassengers;
	}
	public boolean OnRoute(){
		return isOnRoute;
	}
	public int getId(){
		return id;
	}
	public int getRoute(){
		return numRoute;
	}
	// SETTERS
	public void setRoute(int route){
		numRoute = route;
	}
	public void setDest(Point dest){
		destination = dest;
	}
	// CONSTRUCTORS
	public Bus(int id, Point loc){
		location = new Point(loc);
		size = DEFAULT_SIZE;
		color = DEFAULT_COLOR;
		if(id > 1000 && id < 9999){
			this.id = id;
			System.out.println("Bus created. id = " + this.id);
		} else {
			this.id = 0;
			System.out.println("Wrong id number of Bus in Bus.java (Method: Bus(int id)). id = " + id);
		}
		Graph.addDrawable(this);
	}
	// METHODS
	public void move(){
		if(destination != null){
			if(location.x != destination.x){
				if(Math.abs(location.x - destination.x) <= speed){
					location.x = destination.x;
				} else {
					location.x += (location.x < destination.x) ? speed : -speed;
				}
			}
			if(location.y != destination.y){
				if(Math.abs(location.y - destination.y) <= speed)
				{
					location.y = destination.y;
				} else {
					location.y += (location.y < destination.y) ? speed : -speed;
				}
				
			}
			if(destination.getLocation() == location.getLocation()){
				destination = null;
			}
		}
	}

}
