package ma2ter;

import java.util.ArrayList;
import java.util.Random;

public class BusDepartment {
	
	static final int MAX_BUS = 25;
	
	private final BusParking bPark = new BusParking();
	private int busCount = 0;
	private ArrayList<Bus> busList = new ArrayList<Bus>();
	
	// GETTERS
	public int getBusCount(){
		return busCount;
	}
	public BusParking getBP(){
		return bPark;
	}
	//CONSTRUCTORS
	public BusDepartment(){
		
	}
	
	//METHODS
	public Bus createBus(){
		if(busCount < MAX_BUS)
		{
			busCount++;
			Bus newBus = new Bus(getFreeId(), bPark.getLocation());
			busList.add(newBus);
			return newBus;
		} else {
			System.out.println("Overcap!!");
		}
		return null;
	}
	
	public Bus getBusById(int id){
		for(Bus b:busList){
			if (b.getId() == id) return b;
		}
		return null;
	}
	public Bus getBusByIndex(int ind){
		if(ind >= 0 && ind < busCount){
			return busList.get(ind);
		}
		return null;
	}
	
	public void removeBus(Bus bus){
		if(bus != null){
			System.out.print("Deleting bus with id=" + bus.getId());
			busList.remove(bus);
			busCount--;
			System.out.println(". Deleted!");
		}
	}
	public void removeBus(){
		if(busCount != 0){
			removeBus(busList.get(0));
		}
	}
	public void removeBus(int id){
		Bus b = getBusById(id);
		removeBus(b);
	}
	
	
	public int getFreeId(){
		int result = 0;
		final Random rand = new Random();
		boolean isEnd = false;
		while(!isEnd){
			isEnd = true;
			result = rand.nextInt(8999) + 1000;
			for(Bus b: busList){
				if(b.getId() == result){
					isEnd = false;
					break;
				}
			}
		}
		
		return result;
	}
	
	public void move(){
		for(Bus b:busList){
			b.move();
		}
	}
}
