import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Rect implements IPShape, Serializable
{

	int x, y, x2, y2, clr, width;
	String shapeType;
	
	public Rect(){
		
	}
	
	public Rect(int x, int y, int x2, int y2, int clr, int width)
	{
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.clr = clr;
		this.width = width;
		shapeType = "rect";
	}

	@Override
	public void draw(Graphics2D gg) 
	{
		int minX = Math.min(x, x2);
		int minY = Math.min(y, y2);
		int rectW = Math.abs(x2-x);
		int rectH = Math.abs(y2-y);
		gg.setColor(new Color(clr));
		gg.setStroke(new BasicStroke(width));
		gg.drawRect(minX, minY, rectW, rectH);
	}

}
