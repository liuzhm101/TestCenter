package com.finance.stock.gui;

import javax.swing.JTable;

public class StockTable extends JTable {

	public boolean isCellEditable(int row, int column) {
	     return false;
	}
	
	
}
