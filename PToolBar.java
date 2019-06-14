import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class PToolBar extends JPanel


{
	
	PData data;
	PCommand cmd = PCommand.getInstance();
	
	public PToolBar () 
	{
		setBackground(Color.DARK_GRAY);
	
		setBounds (10, 10, 100, 100);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.LINE_START; // This is a trick
	    gbc.fill = GridBagConstraints.VERTICAL;
	    
	    JSlider btnSLIDER = new JSlider(1,10,3);
	    btnSLIDER.setBorder(BorderFactory.createTitledBorder("Choose how thick"));
	    btnSLIDER.setMinorTickSpacing(1);  
	    btnSLIDER.setMajorTickSpacing(1);  
	    btnSLIDER.setPaintTicks(true);  
	    btnSLIDER.setPaintLabels(true);  
	    
	    btnSLIDER.addChangeListener((ChangeListener) cmd.aWidth);
	    add(btnSLIDER);
}
}
