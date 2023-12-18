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
import java.awt.FlowLayout;
import java.awt.Rectangle;

public class StockExecuteSqlDialog extends JDialog {
	
	public String sqlStr;
	JTextArea sqlStrTextArea = new JTextArea();
	public JTextField tableNameTextFiled;

	public StockExecuteSqlDialog() {
		
		setTitle("Execute SQL");
		this.setSize(749, 479);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 50));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("  Execute  ");
		panel_1.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				sqlStr=sqlStrTextArea.getSelectedText();
				
				if (sqlStr==null)
				{
					String allText=sqlStrTextArea.getText();
					String[] s=allText.split("\n");
					sqlStr=s[0];
				}
				else
				{
					sqlStr=sqlStr.trim();
				}
					
				StockKey.sqlString=sqlStr;
				
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
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane);
		
		sqlStrTextArea = new JTextArea();
		String fontname=sqlStrTextArea.getFont().getName();
		sqlStrTextArea.setFont(new Font(fontname, Font.BOLD, 15));
		scrollPane.setViewportView(sqlStrTextArea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_4, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(30);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTableName = new JLabel("Table Name:");
		panel.add(lblTableName);
		
		tableNameTextFiled = new JTextField();
		tableNameTextFiled.setBounds(new Rectangle(0, 0, 100, 0));
		panel.add(tableNameTextFiled);
		tableNameTextFiled.setColumns(40);
		
		
		
	}
}
