package ma2ter;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Engine {
	JFrame f;
	
	BusDepartment park = new BusDepartment();

	//ACTION LISTENERS
	private class timerTick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			park.move();
			f.repaint();
		}
	}
	private class buttonChangeLocClicked implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Random rand = new Random();
			park.getBP().testLoc(new Point(rand.nextInt(400), rand.nextInt(400)));
			Point testDest = new Point(park.getBP().getLoc());
			
			park.getBusByIndex(0).setDest(testDest);
		}
	}
	private class buttonAddBusClicked implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			park.createBus();
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
		
		//Timer mainTimer
		Timer mainTimer = new Timer(20, new timerTick());
		mainTimer.start();
		
		
	}
}
