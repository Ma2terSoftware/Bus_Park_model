package ma2ter;

import java.awt.Point;
import java.util.Random;

public class CrossroadTestDrive {

	
	static public void main(String[] args){
		final Random rand = new Random();
		
		final int NUM_OF_TESTS = 500;
		
		int tests = 0;
		int passed = 0;
		
		System.out.println("START!");
		
		for(int i = 0; i < NUM_OF_TESTS; i++){
			
			tests++;
			int x = rand.nextInt(400);
			int y = rand.nextInt(400);
			
			Hub cr = new Hub(new Point(x,y), i);
			
			if(cr.getId() == i) {
				passed++;
			} else {
				System.out.println("Error. id = " + cr.getId() + ". i = " + i);
			}
			
			
		}
		
		System.out.println("End. Passed - " + passed + "/" + tests);
		
		
	}
}
