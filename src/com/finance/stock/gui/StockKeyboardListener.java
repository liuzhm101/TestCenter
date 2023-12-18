package com.finance.stock.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JInternalFrame;

public class StockKeyboardListener implements KeyListener {

	JInternalFrame parentFrame;
	
	public StockKeyboardListener(JInternalFrame parentFrame) {
		// TODO Auto-generated constructor stub
		this.parentFrame=parentFrame;
	}
	
	public void keyPressed(KeyEvent e) {

		try
		{
			int keyCode=e.getKeyCode();
			if (keyCode==KeyEvent.VK_0
			||	keyCode==KeyEvent.VK_1	
			||	keyCode==KeyEvent.VK_2
			||	keyCode==KeyEvent.VK_3
			||	keyCode==KeyEvent.VK_4
			||	keyCode==KeyEvent.VK_5
			||	keyCode==KeyEvent.VK_6
			||	keyCode==KeyEvent.VK_7
			||	keyCode==KeyEvent.VK_8
			||	keyCode==KeyEvent.VK_9
			)
			{
				
				if (StockComponent.skf==null)
				{
					StockKeyboardFrame skf=new StockKeyboardFrame();
					skf.setInitKeyText(keyCode);
					skf.setSize(300, 400);
	        		StockComponent.desktopPane.add(skf);
	        		int parent_x=parentFrame.getX();
	        		int parent_y=parentFrame.getY();
	        		int parent_width=parentFrame.getWidth();
	        		int parent_height=parentFrame.getHeight();
	        		skf.setLocation(parent_x+parent_width-skf.getWidth()-2, parent_y+parent_height-skf.getHeight()-2);
	        		skf.setVisible(true);
	    			skf.setSelected(true);
	    			skf.moveToFront();
	    			
	    			StockComponent.skf=skf;
				}
				else
				{
					StockComponent.skf.setInitKeyText(keyCode);
					StockComponent.skf.setVisible(true);
					StockComponent.skf.setSelected(true);
					StockComponent.skf.moveToFront();
					
				}
				
				
			}
		}
		catch(Exception ec)
		{
			ec.printStackTrace();
		}
		
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {


		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
