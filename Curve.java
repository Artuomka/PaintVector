import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Curve implements IPShape, Serializable
{
	
	int x, y, x2, y2, clr, width;
	String shapeType;
	public Curve() {}
	public Curve (int x, int y, int x2, int y2, int clr, int width)
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.clr = clr;
		this.width = width;
		shapeType = "curve";
	}
	

	@Override
	public void draw(Graphics2D gg) {
		
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawLine(x, y, x2, y2);
		
		
	}

}
