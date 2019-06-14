import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PPanel extends JPanel
{
	PCommand cmd = PCommand.getInstance();
	
	public PPanel() 
	{
		setBackground(Color.WHITE);
		setBounds (250, 75, 600, 540);
		addMouseListener(cmd.aPressed);
		addMouseMotionListener(cmd.aDragged);
		//addMouseListener (cmd.aContext);
	}
		
	
	
	public void paint (Graphics g) 
	{
		super.paint(g);
		Graphics2D  gg = (Graphics2D) g;
		for (IPShape p: cmd.shapes)
		{
			p.draw(gg);
		}
	}
}

