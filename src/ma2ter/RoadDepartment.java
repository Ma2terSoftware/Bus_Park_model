package ma2ter;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class RoadDepartment {

	private ArrayList<Hub> hubList = new ArrayList<Hub>();
	
	//GETTERS
	
	//CONSTRUCTORS
	
	//METHODS
	public BusStop createBusStop(){
		final Random rand = new Random();
		BusStop newStop = new BusStop(""+hubList.size(),new Point(rand.nextInt(400), rand.nextInt(400)),hubList.size());
		hubList.add(newStop);
		return newStop;
	}
	public Hub createHub(){
		final Random rand = new Random();
		Hub newStop = new Hub(new Point(rand.nextInt(400), rand.nextInt(400)),hubList.size());
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
