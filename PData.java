import java.awt.Color;

public class PData
{
	int width;
	int clr;
	String shape;
	
	private static PData instance = null;
	
	private PData() 
	{
		width = 5;
		clr = 0;
		shape = "curve";
	}
	
	public static PData getInstance()
	{
		if (instance == null)
		{
			instance = new PData();
		}		
		return instance;		
	}
}