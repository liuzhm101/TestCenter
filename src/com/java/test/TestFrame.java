package com.java.test;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;

public class TestFrame extends JFrame {
	
	public TestFrame() {
		
		setSize(800, 500);
		setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,20));

		
		setTitle("Test");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(44, 91, 113, 27);
		getContentPane().add(btnNewButton);
		
		JTree tree = new JTree();
		tree.setBounds(65, 179, 255, 147);
		getContentPane().add(tree);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(368, 150, 42, 190);
		getContentPane().add(scrollBar);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		try {

			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//Nimbus风格，jdk6 update10版本以后的才会出现
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif风格，是蓝黑
//			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());//跨平台的Java风格
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//windows风格
			
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格
//			UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFeel");//windows风格
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");//java风格
//			UIManager.setLookAndFeel("com.apple.mrj.swing.MacLookAndFeel");//待考察，

			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		TestFrame tf=new TestFrame();
		tf.setVisible(true);
		
	}
	
	
	public static void setUIFont (javax.swing.plaf.FontUIResource f){

	    java.util.Enumeration keys = UIManager.getDefaults().keys();

	    while (keys.hasMoreElements()) {

	      Object key = keys.nextElement();

	      Object value = UIManager.get (key);

	      System.out.println(key+"("+value+")");
	      
	      if (value instanceof javax.swing.plaf.FontUIResource)

	        UIManager.put (key, f);

	      }

	    } 
}
