package com.finance.stock.gui;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;

public class StockDayDataFloatFrame extends JInternalFrame{
	
	public JTextField textField1;
	public JTextField textField2;
	public JTextField textField3;
	public JTextField textField4;
	public JTextField textField5;
	public JTextField textField6;
	public JTextField textField7;
	public JTextField textField8;
	public JTextField textField9;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	public StockDayDataFloatFrame() {
		setTitle("\u65B9\u5927\u78B3\u7D20");
		setClosable(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("\u4EE3\u7801");
		lblNewLabel1.setForeground(Color.WHITE);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel1.setBounds(0, 3, 47, 22);
		panel.add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("\u65F6\u95F4");
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel2.setBounds(0, 31, 47, 22);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel3 = new JLabel("\u5F00\u76D8\u4EF7");
		lblNewLabel3.setForeground(Color.WHITE);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel3.setBounds(0, 59, 47, 22);
		panel.add(lblNewLabel3);
		
		JLabel lblNewLabel4 = new JLabel("\u6700\u9AD8\u4EF7");
		lblNewLabel4.setForeground(Color.WHITE);
		lblNewLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel4.setBounds(0, 87, 47, 22);
		panel.add(lblNewLabel4);
		
		JLabel lblNewLabel5 = new JLabel("\u6700\u4F4E\u4EF7");
		lblNewLabel5.setForeground(Color.WHITE);
		lblNewLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel5.setBounds(0, 115, 47, 22);
		panel.add(lblNewLabel5);
		
		JLabel lblNewLabel6 = new JLabel("\u6536\u76D8\u4EF7");
		lblNewLabel6.setForeground(Color.WHITE);
		lblNewLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel6.setBounds(0, 143, 47, 22);
		panel.add(lblNewLabel6);
		
		textField1 = new JTextField();
		textField1.setBorder(null);
		textField1.setForeground(Color.WHITE);
		textField1.setBackground(Color.BLACK);
		textField1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField1.setText("300029");
		textField1.setBounds(59, 0, 110, 28);
		panel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField2.setText("2017/03/29");
		textField2.setBorder(null);
		textField2.setForeground(Color.WHITE);
		textField2.setBackground(Color.BLACK);
		textField2.setBounds(59, 28, 110, 28);
		panel.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setText("13.11(-1.24%)");
		textField3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField3.setBorder(null);
		textField3.setForeground(Color.WHITE);
		textField3.setBackground(Color.BLACK);
		textField3.setBounds(59, 56, 110, 28);
		panel.add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setText("13.56");
		textField4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField4.setBorder(null);
		textField4.setForeground(Color.WHITE);
		textField4.setBackground(Color.BLACK);
		textField4.setBounds(59, 84, 110, 28);
		panel.add(textField4);
		textField4.setColumns(10);
		
		textField5 = new JTextField();
		textField5.setText("12.98");
		textField5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField5.setBorder(null);
		textField5.setForeground(Color.WHITE);
		textField5.setBackground(Color.BLACK);
		textField5.setBounds(59, 112, 110, 28);
		panel.add(textField5);
		textField5.setColumns(10);
		
		textField6 = new JTextField();
		textField6.setText("13.34");
		textField6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField6.setBorder(null);
		textField6.setForeground(Color.WHITE);
		textField6.setBackground(Color.BLACK);
		textField6.setBounds(59, 140, 110, 28);
		panel.add(textField6);
		textField6.setColumns(10);
		
		JLabel label = new JLabel("\u6DA8\u5E45");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		label.setBounds(0, 171, 47, 22);
		panel.add(label);
		
		textField = new JTextField();
		textField.setText("0.51(4.53%)");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBorder(null);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(59, 168, 110, 28);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("\u632F\u5E45");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		label_1.setBounds(0, 199, 47, 22);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("2.13(8.22%)");
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBorder(null);
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(59, 196, 110, 28);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("\u6210\u4EA4\u91CF");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		label_2.setBounds(0, 227, 47, 22);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setText("56000");
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBorder(null);
		textField_2.setForeground(Color.WHITE);
		textField_2.setBackground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(59, 224, 110, 28);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("\u6210\u4EA4\u989D");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		label_3.setBounds(0, 255, 47, 22);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setText("18.6\u4EBF");
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setBorder(null);
		textField_3.setForeground(Color.WHITE);
		textField_3.setBackground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(59, 252, 110, 28);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("\u6362\u624B\u7387");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		label_4.setBounds(0, 283, 47, 22);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setText("12.3%");
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setBorder(null);
		textField_4.setForeground(Color.WHITE);
		textField_4.setBackground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBounds(59, 280, 110, 28);
		panel.add(textField_4);
		
		JLabel label_5 = new JLabel("\u6D41\u901A\u503C");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		label_5.setBounds(0, 311, 47, 22);
		panel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setText("45.8\u4EBF");
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setBorder(null);
		textField_5.setForeground(Color.WHITE);
		textField_5.setBackground(Color.BLACK);
		textField_5.setColumns(10);
		textField_5.setBounds(59, 308, 110, 28);
		panel.add(textField_5);
		
		JLabel label_6 = new JLabel("\u5168\u5E02\u503C");
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(0, 339, 47, 22);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setText("67.9\u4EBF");
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setBorder(null);
		textField_6.setForeground(Color.WHITE);
		textField_6.setBackground(Color.BLACK);
		textField_6.setColumns(10);
		textField_6.setBounds(59, 336, 110, 28);
		panel.add(textField_6);
		
		JLabel label_7 = new JLabel("\u5E02\u76C8\u7387");
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(0, 367, 47, 22);
		panel.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setText("35");
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setBorder(null);
		textField_7.setForeground(Color.WHITE);
		textField_7.setBackground(Color.BLACK);
		textField_7.setColumns(10);
		textField_7.setBounds(59, 364, 110, 28);
		panel.add(textField_7);

		
		
		
	}
}
