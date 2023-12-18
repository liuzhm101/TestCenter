package com.finance.stock.gui;

import javax.swing.JInternalFrame;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.finance.stock.data.StockDayData;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockKLineFrame extends JInternalFrame {
	
	private JTextField textField;
	public StockKLineAllChartPanel stockKLinePanel;
	public StockInfoPanel infoPanel;
	public JPanel status;
	
	public StockKLineFrame(List stockDataRecordList, String c_date, int k_width, int y_distance, int d_height) {
		
		 
		setClosable(true);
		setTitle("Stock K\u7EBF\u56FE");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
//		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(93, 21, 141, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(251, 20, 141, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(21, 24, 108, 29);
		panel.add(lblNewLabel);
		
		JButton button_small = new JButton("---");
	
		button_small.setBounds(435, 20, 141, 37);
		panel.add(button_small);
		
		JButton button_large = new JButton("+++");
	
		button_large.setBounds(622, 20, 141, 37);
		panel.add(button_large);
		
		status = new JPanel();
		status.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		status.setPreferredSize(new Dimension(10, 20));
		getContentPane().add(status, BorderLayout.SOUTH);
		
		StockDayData sdd=(StockDayData)stockDataRecordList.get(stockDataRecordList.size()-1);
		infoPanel = new StockInfoPanel(sdd);
		infoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		infoPanel.setPreferredSize(new Dimension(250, 20));
		getContentPane().add(infoPanel, BorderLayout.EAST);
		
		stockKLinePanel=new StockKLineAllChartPanel(stockDataRecordList, c_date, k_width, y_distance, d_height, infoPanel);
		stockKLinePanel.sklf=this;
		getContentPane().add(stockKLinePanel, BorderLayout.CENTER);

		this.addKeyListener(new StockKLineKeyListener(stockKLinePanel));
		this.setFocusable(true);
		
		this.addMouseListener(new StockKLineMouseMotionListener(stockKLinePanel));
		this.addMouseMotionListener(new StockKLineMouseMotionListener(stockKLinePanel));
		this.addMouseWheelListener(new StockKLineMouseWheelListener(stockKLinePanel));
		
		this.addKeyListener(new StockKeyboardListener(this));
		
	}
	
	
	

}
