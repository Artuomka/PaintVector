import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public PFrame()
	{
		//setLayout(null);
		setTitle("Paint");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(250, 75, 600, 540);
		
		PPanel pan = new PPanel();
		PContextMenu context = new PContextMenu();
		PButtonPanel bpan = new PButtonPanel(null);
		PToolBar ptb = new PToolBar();
		PContextMenu jitem = new PContextMenu();
		add(pan);
		add(bpan, BorderLayout.EAST);
		add(ptb, BorderLayout.NORTH);
		//PContextMenu.contMenu();

		

		setVisible(true);
	}
}
