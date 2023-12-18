package com.finance.stock.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import java.util.*;

public class StockTableCellRender extends DefaultTableCellRenderer {

	Map columnColorMap=new TreeMap();
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
		
		
		DefaultTableCellRenderer defaultRenderer=new DefaultTableCellRenderer();  			
		Component renderer = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				 
		
		Iterator it=columnColorMap.keySet().iterator();
		
		while(it.hasNext())
		{
			
			int columnNo=CommonTool.getIntValue(it.next().toString());
			Color columnColor=(Color)columnColorMap.get(columnNo);

			Font curFont=this.getFont();
			if (column==columnNo)
			{
				Font f=new Font(curFont.getName(), Font.BOLD, curFont.getSize());
				renderer.setFont(f);
				renderer.setForeground(columnColor);
			}

			
		}
		
		return renderer;
		
	}
		
}
