package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Hub extends GraphicObject{
	
	static final Dimension DEFAULT_SIZE = new Dimension(10,10);
	static final Color DEFAULT_COLOR = Color.black;
	
	protected int id;
	
	//GETTERS
	public int getId(){
		return id;
	}
	
	//CONSTRUCTORS
	public Hub(Point p, int i){
		location = p;
		id = i;
		size = DEFAULT_SIZE;
		name = "" + p.x + " , " + p.y;
		color = DEFAULT_COLOR;
		
		Graph.addGraphicObject(this);
	}
	public Hub(){}
}
