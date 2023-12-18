package com.finance.stock.gui;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTable;

import com.finance.stock.data.StockMetaData;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.util.Iterator;

public class StockKeyboardFrame extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextArea jta;
	
	
	public StockKeyboardFrame() {
		
		setTitle("Stock \u952E\u76D8");
		setClosable(true);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					setVisible(false);
					String code=textField.getText().trim();
					CommonTool.openStockKChart(code);
					textField.setText("");
					
				}
				
				if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					dispose();
					StockComponent.skf=null;
					StockComponent.sjif.moveToFront();
					StockComponent.sjif.requestFocus();
					
				}
				
			}
			
			
			public void keyReleased(KeyEvent e) {
			
				jta.setText("");
				
				String curCode=textField.getText().trim();
				Iterator it=StockKey.stockMetaDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					String key=it.next().toString();
					if (key.startsWith(curCode))
					{
						StockMetaData smd=(StockMetaData)StockKey.stockMetaDataMap.get(key);
						jta.append(smd.getCode()+"   "+smd.getName()+"     "+smd.getIndustry()+"\n");
					}
					
				}
			
			
			}
			
		});
		textField.setPreferredSize(new Dimension(6, 35));
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		
//		table = new JTable();
//		getContentPane().add(table, BorderLayout.CENTER);
		
		jta = new JTextArea();
		jta.setEditable(false);
		jta.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
		getContentPane().add(jta, BorderLayout.CENTER);
		
		
	}

	public void setInitKeyText(int keyCode)
	{
		
		textField.setText(KeyEvent.getKeyText(keyCode));
		
	}
	
	
}
