import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Oval implements IPShape, Serializable
{

	int x, y, x2, y2, clr, width;
	String shapeType;
	public Oval() {}
	public Oval(int x, int y, int x2, int y2, int clr, int width) 
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.clr = clr;
		this.width = width;	
		shapeType = "oval";
	}

	@Override
	public void draw(Graphics2D gg) 
	{
		int ovalW = Math.abs(x2-x);
		int ovalH = Math.abs(y2-y);
		int minX = Math.min(x, x2);
		int minY = Math.min(y, y2);
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawOval(minX, minY, ovalW, ovalH);			
	}

}
