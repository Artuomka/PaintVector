import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.w3c.dom.css.RGBColor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PCommand 
{
	private PData data;
	private int x, y, x2, y2, x3, y3;
	private PPanel pan;

	ActionColor aColor;
	ActionWidth aWidth;
	ActionDragged aDragged;
	ActionPressed aPressed;
	ActionSave aSave;
	ActionLoad aLoad;
	ActionChoose aChoose;
	ColorChooser aColorChoose;
	ContextMenu aContext;
	public RenderedImage bi;

	ArrayList<IPShape> shapes = new ArrayList<IPShape>();



	public PPanel setPan (PPanel pan) {
		this.pan = pan;
		return pan;		
	}


	private PCommand()
	{
		data = PData.getInstance();
		aColor = new ActionColor ();
		aWidth = new ActionWidth();
		aDragged = new ActionDragged();
		aPressed = new ActionPressed();
		aSave = new ActionSave();
		aLoad = new ActionLoad();
		aChoose = new ActionChoose();
	aContext = new ContextMenu();
		aColorChoose = new ColorChooser();
	}
	public static PCommand instance;
	public static PCommand getInstance()
	{
		if (instance == null)
		{
			instance = new PCommand();
		}		
		return instance;
	}
	
	
	
	class ContextMenu extends MouseAdapter
	{		
	
		   public void mouseReleased(MouseEvent e)
		   {
		        if (e.isPopupTrigger())
		            doPop(e);
		    }

	    private void doPop(MouseEvent e)
	    {
		    	PContextMenu menu = new PContextMenu();
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	
	}

	public void setBI(BufferedImage bi)
	{
		this.bi= bi;
	}

	class ActionPressed implements MouseListener 
	{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			PPanel pan = (PPanel) e.getSource();
			int x3 = e.getX();
			int y3 = e.getY();
			IPShape shape = null;
			switch (data.shape)

			{

			case "rect": shape = new Rect ( x, y, x3, y3, data.clr, data.width);
			shapes.add(shape);
			shape.draw((Graphics2D) pan.getGraphics());			
			break;
			case "oval": shape = new Oval ( x, y, x3, y3, data.clr, data.width);
			shapes.add(shape);
			shape.draw((Graphics2D) pan.getGraphics());
			break;
			case "line":
				shape = new Line ( x, y, x3, y3, data.clr, data.width);
				shapes.add(shape);
				shape.draw((Graphics2D) pan.getGraphics());
				break;

			}		//

			//	if (shape==null) throw new RuntimeException();

		}
	}

	class	ActionDragged implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) 
		{
			PPanel pan = (PPanel) e.getSource();
			int x2 = e.getX();
			int y2 = e.getY();
			IPShape shape = null;
			switch (data.shape)			
			{
			case "curve": shape = new Curve ( x, y, x2, y2, data.clr, data.width);
			shapes.add(shape);
			shape.draw((Graphics2D) pan.getGraphics());
			break;		
			}

			if (shape==null)  throw new RuntimeException();

			x=x2;
			y=y2;
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class ActionColor implements ActionListener 

	{
		@Override 
		public void actionPerformed (ActionEvent e)
		{
			String cmd = e.getActionCommand();

			switch (cmd)
			{
			case "red": data.clr = 12648480;
			break;
			case "black": data.clr = 0;
			break;
			case "blue": data.clr = 21386;
			break;
			}
		}

	}

	class ActionWidth implements ActionListener, ChangeListener

	{
		@Override 
		public void actionPerformed (ActionEvent e)
		{
			String cmd = e.getActionCommand();

			switch (cmd)
			{
			case "1px": data.width = 1;
			break;
			case "5px": data.width = 5;
			break;
			case "10px": data.width = 10;
			break;
			}
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			data.width = (((JSlider) e.getSource()).getValue());

		}

	}

	public class ColorChooser implements ActionListener
	{

		PPanel pp;
		@Override
		public void actionPerformed(ActionEvent e) {
			Color color_chosen = Color.BLACK;
			Color color = JColorChooser.showDialog(pp, "SUPER COLOR", color_chosen);	
			data.clr = color.getRGB();					
		}
	}
	
class ActionSave implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser ch = new JFileChooser();
			ch.setCurrentDirectory(new File("D:\\"));
			//ch.showDialog(null, "Save FIle");
			FileNameExtensionFilter filter = new FileNameExtensionFilter ("json", new String [] {"json"});
			ch.setFileFilter(filter);
			ch.setAcceptAllFileFilterUsed(false);
			int flag = ch.showDialog(null, "Save FIle");

			if (flag==0)
			{
				File file = ch.getSelectedFile();
				FileWriter fileJS = null;
				try {
					fileJS = new FileWriter(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Gson jsonFile = new Gson();
				jsonFile.toJson(shapes, fileJS );

				try {
					fileJS.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}
	}

	class ActionLoad implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser ch = new JFileChooser();
			String str_readen = null;
			ch.setCurrentDirectory(new File("D:\\"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter ("json", new String [] {"json"});
			ch.setFileFilter(filter);
			ch.setAcceptAllFileFilterUsed(false);
			int flag = ch.showDialog(null, "Load FIle");
			
			if (flag==0)
			{
				File file = ch.getSelectedFile();
				FileReader fileReaden = null;
				try {
					fileReaden = new FileReader(file);
					BufferedReader reader = new BufferedReader(fileReaden);
					str_readen = reader.readLine();
					Gson jsonFile = new Gson();
					shapes =  jsonFile.fromJson(str_readen, new TypeToken<ArrayList<IPShape>>() {}.getType());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//	ArrayList<IPShape> shapes = Gson.fromJson(, ArrayList.class)
 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 
			}
			

		}
	}



	class ActionChoose implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{

			String cmd = e.getActionCommand();

			switch (cmd)
			{
			case "curve": data.shape = "curve";
			break;
			case "rect": data.shape = "rect";
			break;
			case "oval": data.shape = "oval";
			break;
			case "line": data.shape = "line";
			break;
			}
		}

	}

}

