package ma2ter;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class HubManipulator {

	private ArrayList<Hub> hubList = new ArrayList<Hub>();
	
	//GETTERS
	public ArrayList<Hub> getHubList(){
		return hubList;
	}
	//CONSTRUCTORS
	
	//METHODS
	public BusStop createBusStop(Point loc, String name){
		BusStop newStop = new BusStop(name,loc,hubList.size());
		hubList.add(newStop);
		return newStop;
	}
	public Hub createHub(Point loc){
		Hub newStop = new Hub(loc,hubList.size());
		hubList.add(newStop);
		return newStop;
	}
	
	public Hub getHubById(int id){
		for(Hub c:hubList){
			if (c.getId() == id) return c;
		}
		return null;
	}
	
	public void removeHub(int id){
		
	}
}
