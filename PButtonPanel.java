import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PButtonPanel extends JPanel

{	
	private PData data;
	
	PCommand cmd = PCommand.getInstance();
	
	public PButtonPanel (PData data) {
		setBackground(Color.DARK_GRAY);
		this.data = data;
		setBounds (10, 10, 600, 560);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER; 
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JButton btnBLACK = new JButton ("BLACK");
		JButton btnBLUE = new JButton ("BLUE");
		JButton btnRED = new JButton ("RED");
		JButton btnChoose = new JButton("Color Choose");
		JButton btnWidth1 = new JButton ("1px");
		JButton btnWidth5 = new JButton ("5px");
		JButton btnWidth10 = new JButton ("10px");
		JButton btnSave = new JButton ("Save");
		JButton btnLoad = new JButton ("Load");
		


		ButtonGroup group = new ButtonGroup();
		JRadioButton CurveButton = new JRadioButton("Curve", true);
		group.add(CurveButton);
		JRadioButton RectButton = new JRadioButton("Rectangle", false);
		group.add(RectButton);
		JRadioButton OvalButton = new JRadioButton("Oval", false);
		group.add(OvalButton);
		JRadioButton LineButton = new JRadioButton("Line", false);
		group.add(LineButton);
		
		add(CurveButton, gbc);
		add(RectButton, gbc);
		add(OvalButton, gbc);
		add(LineButton, gbc);
		
		CurveButton.setActionCommand("curve");
		RectButton.setActionCommand("rect");
		OvalButton.setActionCommand("oval");
		LineButton.setActionCommand("line");
		
		CurveButton.addActionListener(cmd.aChoose);
		RectButton.addActionListener(cmd.aChoose);
		OvalButton.addActionListener(cmd.aChoose);
		LineButton.addActionListener(cmd.aChoose);
		
		
		add(btnBLACK, gbc);
		add(btnBLUE, gbc);
		add(btnRED, gbc);
		add(btnChoose, gbc);
	
		add(btnWidth1, gbc);
		add(btnWidth5, gbc);
		add(btnWidth10, gbc);
		add(btnSave);
		add(btnLoad);
		
		
		btnBLACK.setActionCommand("black");
		btnBLUE.setActionCommand("blue");
		btnRED.setActionCommand("red");
		
		
		btnWidth1.setActionCommand("1px");
		btnWidth5.setActionCommand("5px");
		btnWidth10.setActionCommand("10px");
		
		btnBLACK.addActionListener(cmd.aColor);
		btnBLUE.addActionListener(cmd.aColor);
		btnRED.addActionListener(cmd.aColor);
		btnChoose.addActionListener(cmd.aColorChoose);
		
		btnWidth1.addActionListener(cmd.aWidth);
		btnWidth5.addActionListener(cmd.aWidth);
		btnWidth10.addActionListener(cmd.aWidth);
		btnLoad.addActionListener(cmd.aLoad);
		btnSave.addActionListener(cmd.aSave);
		
//		btnBLACK.setBounds(25, 20, 100, 30);	
//		btnBLACK.setBounds(25, 60, 100, 30);	
//		btnBLACK.setBounds(25, 100, 100, 30);	
//		btnBLACK.setBounds(25, 20, 100, 30);	
//		btnBLACK.setBounds(25, 20, 100, 30);	
//		btnBLACK.setBounds(25, 20, 100, 30);	
		
	}

}
