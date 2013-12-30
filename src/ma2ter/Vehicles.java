package ma2ter;

import java.util.ArrayList;
import java.util.Random;

public class Vehicles {
	
	static final int MAX_BUS = 25;
	
	private final BusParking bPark = new BusParking();
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	// GETTERS
	public BusParking getBP(){
		return bPark;
	}
	//CONSTRUCTORS
	public Vehicles(){
		
	}
	
	//METHODS
	public Vehicle createVehicle(VehicleType type){
		switch(type){
			case BUS:
				BusVehicle newBus = new BusVehicle(getFreeId(), bPark.getLocation());
				vehicleList.add(newBus);
				return newBus;
			default:
				return null;
		}
			
	}
	
	public Vehicle getVehicleById(int id){
		for(Vehicle b:vehicleList){
			if (b.getId() == id) return b;
		}
		return null;
	}
	
	public Vehicle getVehicleByIndex(int ind){
		if(ind >= 0 && ind < vehicleList.size()){
			return vehicleList.get(ind);
		}
		return null;
	}
	
	public void removeVehicle(Vehicle vehicle){
		if(vehicle != null){
			vehicleList.remove(vehicle);
			System.out.println(". Deleted!");
		}
	}
	public void removeVehicle(){
		if(vehicleList.size() != 0){
			removeVehicle(vehicleList.get(0));
		}
	}
	public void removeVehicle(int id){
		Vehicle b = getVehicleById(id);
		removeVehicle(b);
	}
	
	
	public int getFreeId(){
		int result = 0;
		final Random rand = new Random();
		boolean isEnd = false;
		while(!isEnd){
			isEnd = true;
			result = rand.nextInt(8999) + 1000;
			for(Vehicle b: vehicleList){
				if(b.getId() == result){
					isEnd = false;
					break;
				}
			}
		}
		
		return result;
	}
	
	public void move(){
		for(Vehicle b:vehicleList){
			b.move();
		}
	}
}
