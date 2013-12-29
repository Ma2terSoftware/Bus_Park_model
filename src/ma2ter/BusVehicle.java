package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;


public class BusVehicle extends Vehicle{
	
	static final Dimension DEFAULT_SIZE = new Dimension(20,20);
	static final int DEFAULT_CAPACITY = 40;
	static final int MAX_V = 80;
	static final Color DEFAULT_COLOR = Color.green;
	
	private int speed = 2;
	private int numRoute = 0;
	private int id = 0;
	private boolean isOnRoute = false;
	private ArrayList<Point> route = new ArrayList<Point>();
	private int crntDestNum = 0;
	private Point destination = null;
	// GETTERS
	public String getName(){
		return ""+id;
	}
	
	public int getSpeed(){
		return speed;
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
	public void setDest(Point dest){
		destination = dest;
	}
	public void setRoute(ArrayList<Point> rt){
		route = rt;
		destination = rt.get(0);
	}
	// CONSTRUCTORS
	public BusVehicle(int id, Point loc){
		location = new Point(loc);
		capacity = DEFAULT_CAPACITY;
		size = DEFAULT_SIZE;
		this.id = id;
		super.makeGraphic(DEFAULT_COLOR);
	}
	// METHODS
	private Point getNextDest(){
		
		if(crntDestNum == route.size()-1) crntDestNum = 0;
		else crntDestNum++;
		return route.get(crntDestNum);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void unload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void move() {
		// TODO Auto-generated method stub
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
			if(destination.x == location.x && destination.y == location.y){
				destination = getNextDest();
			}
		}
	}

}
