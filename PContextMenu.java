import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PContextMenu extends JPopupMenu
{
private PData data;
	
	PCommand cmd = PCommand.getInstance();
	 static JMenuItem jitem;
	public static void contMenu()
	{
		jitem = new JMenuItem("Context menu");
		
	}
}