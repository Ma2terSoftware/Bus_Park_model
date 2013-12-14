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
	static final ArrayList<Drawable> graphObjects = new ArrayList<Drawable>();
	
	//CONSTRUCTORS

	//METHODS
	static void addDrawable(Drawable a){
		graphObjects.add(a);
	}
	
	public void drawObject(Drawable obj, Graphics g){
		g = (Graphics2D)g;
		Point loc = obj.getLoc();
		Dimension size = obj.getSize();
		
		g.setColor(obj.getColor());
		g.fillArc(loc.x - size.width/2, loc.y - size.height / 2, size.width, size.height, 0, 360);
		
		g.setColor(Color.black);
		g.drawString(obj.getName(), loc.x-(int)(obj.getName().length()*5.5/2), loc.y - size.height/2);
	}
	
	
	public void paint(Graphics g){
		for(Drawable a:graphObjects){
			drawObject(a, g);
		}
	}
	
}
