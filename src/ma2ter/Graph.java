package ma2ter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Graph extends JPanel {

	private static final long serialVersionUID = 7572860204162547404L;
	private BusDepartment mainBD;
	static final ArrayList<Drawable> graphObjects = new ArrayList<Drawable>();
	//private Image img = new ImageIcon("res/background.png").getImage();
	
	//CONSTRUCTORS
	public Graph(BusDepartment mainBD){
		this.mainBD = mainBD;
		
	}
	//METHODS
	static void addDrawable(Drawable a){
		graphObjects.add(a);
	}
	
	public void drawObject(Drawable obj, Graphics g){
		g = (Graphics2D)g;
		Point loc = obj.getLoc();
		Dimension size = obj.getSize();
		String name = obj.getName();
		
		g.setColor(Color.black);
		g.fillArc(loc.x - size.width/2, loc.y - size.height / 2, size.width, size.height, 0, 360);
		
		g.drawString(name, loc.x-(int)(name.length()*5.5/2), loc.y - size.height/2);
	}
	
	
	public void paint(Graphics g){
		for(Drawable a:graphObjects){
			drawObject(a, g);
		}
	}
	
}
