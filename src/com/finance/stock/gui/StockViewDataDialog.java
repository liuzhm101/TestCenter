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

public class StockViewDataDialog extends JDialog {
	
	JTextArea contentTextArea = new JTextArea();
	
	public StockViewDataDialog(String text) {
		
		setTitle("View Data");
		this.setSize(714, 439);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 20));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 50));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnRearrange = new JButton(" Rearrange ");
		panel_1.add(btnRearrange);
		btnRearrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String content=contentTextArea.getText().trim();
				
				content=content.replaceAll(" ", "\n");
				
				contentTextArea.setText(content);
				
			}
		});
		
		
		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
		
		contentTextArea = new JTextArea();
		String fontname=contentTextArea.getFont().getName();
		contentTextArea.setFont(new Font(fontname, Font.BOLD, 15));
		scrollPane.setViewportView(contentTextArea);
		contentTextArea.setText(text);
		contentTextArea.setCaretPosition(0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(20, 20));
		getContentPane().add(panel_4, BorderLayout.EAST);
		
		
		
	}
}
