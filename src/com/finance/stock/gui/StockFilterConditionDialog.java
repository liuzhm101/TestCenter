package com.finance.stock.gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

public class StockFilterConditionDialog extends JDialog {
	public String conditionStr;
	JTextArea conditionTextArea = new JTextArea();
	
	public StockFilterConditionDialog() {
		setTitle("Filter Condition");
		this.setSize(714, 439);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 20));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 50));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton(" Filter ");
		panel_1.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				conditionStr=conditionTextArea.getSelectedText();
				
				if (conditionStr==null)
				{
					String allText=conditionTextArea.getText();
					String[] s=allText.split("\n");
					conditionStr=s[0];
				}
				else
				{
					conditionStr=conditionStr.trim();
				}
					
				StockKey.conditionString=conditionStr;
				
				dispose();
				
			}
		});
		
		
		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				conditionStr=conditionTextArea.getSelectedText();
//				
//				if (conditionStr==null)
//				{
//					String allText=conditionTextArea.getText();
//					String[] s=allText.split("\n");
//					conditionStr=s[0];
//				}
//				else
//				{
//					conditionStr=conditionStr.trim();
//				}
//					
//				StockKey.conditionString=conditionStr;
				
				dispose();
				
			}
		});
		
		
		JPanel panel_2 = new JPanel();
		panel.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane);
		
		conditionTextArea = new JTextArea();
		String fontname=conditionTextArea.getFont().getName();
		conditionTextArea.setFont(new Font(fontname, Font.BOLD, 15));
		scrollPane.setViewportView(conditionTextArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_4, BorderLayout.EAST);
		
		
		
	}
}
