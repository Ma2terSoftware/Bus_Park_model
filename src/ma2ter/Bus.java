package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;


public class Bus extends GraphicObject{
	
	static final Dimension DEFAULT_SIZE = new Dimension(20,20);
	static final int MAX_P = 25;
	static final int MAX_V = 80;
	static final Color DEFAULT_COLOR = Color.green;
	
	private int v = 3;
	private int p = 0;
	private int numRoute = 0;
	private int id = 0;
	private boolean isOnRoute = false;
	private ArrayList<Point> route = new ArrayList<Point>();
	private int crntDestNum = -1;
	private Point destination = null;
	// GETTERS
	public String getName(){
		return ""+id;
	}
	
	public int getV(){
		return v;
	}
	public int getP(){
		return p;
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
		destination = getNextDest();
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
		Graph.addGraphicObject(this);
	}
	// METHODS
	private Point getNextDest(){
		
		if(crntDestNum == route.size()-1) crntDestNum = 0;
		else crntDestNum++;
		return route.get(crntDestNum);
	}
	
	public void move(){
		if(destination != null){
			if(location.x != destination.x){
				if(Math.abs(location.x - destination.x) <= v){
					location.x = destination.x;
				} else {
					location.x += (location.x < destination.x) ? v : -v;
				}
			}
			if(location.y != destination.y){
				if(Math.abs(location.y - destination.y) <= v)
				{
					location.y = destination.y;
				} else {
					location.y += (location.y < destination.y) ? v : -v;
				}
				
			}
			if(destination.x == location.x && destination.y == location.y){
				destination = getNextDest();
			}
		}
	}

}
