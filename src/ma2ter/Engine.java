package ma2ter;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Engine {
	JFrame f;
	
	Vehicles vehicles = new Vehicles();
	HubManipulator roaddept = new HubManipulator();
	
	//ACTION LISTENERS
	private class timerTick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			vehicles.move();
			f.repaint();
		}
	}
	private class buttonChangeLocClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Random rand = new Random();
			vehicles.getBP().testLoc(new Point(rand.nextInt(400), rand.nextInt(400)));
			Point testDest = new Point(vehicles.getBP().getLocation());
			
			//busdept.getBusByIndex(0).setDest(testDest);
		}
	}
	private class buttonAddBusClicked implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			vehicles.createVehicle(VehicleType.BUS);
		}
		
	}
	private class buttonAddHubClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Random rand = new Random();
			Hub testHub = roaddept.createHub((new Point(rand.nextInt(400), rand.nextInt(400))));
		}
		
	}
	private class buttonSetRouteClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<Point> route = new ArrayList<Point>();
			for(Hub h:roaddept.getHubList()){
				route.add(h.getLocation());
			}
			vehicles.getVehicleByIndex(0).setRoute(route);
		}
		
	}
	//METHODS
	void go(){

		// TODO Auto-generated method stub
		
		//JFrame f
		f = new JFrame("BusParkModel");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(704, 512);
		f.add(new Graph());
		f.setVisible(true);
		//JPanel panel
		JPanel panel = new JPanel();
		panel.setSize(200, 200);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		f.getContentPane().add(BorderLayout.EAST, panel);
				
		//Button bChangeLoc
		JButton bChangeLoc = new JButton("Change BP location!");
		panel.add(bChangeLoc);
		bChangeLoc.setVisible(true);
		bChangeLoc.addActionListener(new buttonChangeLocClicked());
		
		//Button bAddBus
		JButton bAddBus = new JButton("Add Bus");
		panel.add(bAddBus);
		bAddBus.setVisible(true);
		bAddBus.addActionListener(new buttonAddBusClicked());
		
		//Button bAddHub
		JButton bAddHub = new JButton("Add Hub");
		panel.add(bAddHub);
		bAddHub.setVisible(true);
		bAddHub.addActionListener(new buttonAddHubClicked());
		
		//Button bSetRoute
		JButton bSetRoute = new JButton("Set Route");
		panel.add(bSetRoute);
		bSetRoute.setVisible(true);
		bSetRoute.addActionListener(new buttonSetRouteClicked());
		
		//Timer mainTimer
		Timer mainTimer = new Timer(20, new timerTick());
		mainTimer.start();
		
		
	}
}
