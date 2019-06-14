import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Line implements IPShape, Serializable
{

	int x, y, x2, y2, clr, width;
	String shapeType;
	
	public Line() {}
	
	public Line (int x, int y, int x2, int y2, int clr, int width)
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.clr = clr;
		this.width = width;
		shapeType = "line";
		
	}
	
	@Override
	public void draw(Graphics2D gg)
	{
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawLine(x, y, x2, y2);		
	}

}
