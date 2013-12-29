package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

public class BusStop extends Hub{

	static final Dimension DEFAULT_SIZE = new Dimension(20,20);
	static final Color DEFAULT_COLOR = Color.blue;
	
	private ArrayList<Passanger> passList = new ArrayList<Passanger>();
	
	//GETTERS

	
	//CONSTRUCTORS
	public BusStop(String n,Point p,int i){
		location = p;
		size = DEFAULT_SIZE;
		//name = n;
		//color = DEFAULT_COLOR;
		id = i;
	}

	//METHODS
	public Passanger getPassByDest(Point destination){
		for(Passanger p:passList){
			if (p.getDestination() == destination) return p;
		}
		return null;

	}
}

