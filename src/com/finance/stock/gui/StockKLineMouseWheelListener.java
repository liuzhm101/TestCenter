package com.finance.stock.gui;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class StockKLineMouseWheelListener implements MouseWheelListener {

	StockKLineAllChartPanel skac;
	
	public StockKLineMouseWheelListener(StockKLineAllChartPanel skac)
	{
		this.skac=skac;
		
	}	
	
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

		// 滚轮向前
		if (e.getWheelRotation()==-1) 
		{
			if (skac.k_width==2)
			{
				skac.k_width=6;
				skac.kz_width=1;
			}
			else
			{
				skac.k_width=skac.k_width+2;
				skac.kz_width=skac.kz_width+2;
			}
			
			skac.repaint();
		}

		//滚轮向后
		if (e.getWheelRotation()==1) 
		{
			skac.k_width=skac.k_width-2;
			if (skac.k_width<2)
				skac.k_width=2;
			
			skac.kz_width=skac.kz_width-2;
			if (skac.kz_width<1)
				skac.kz_width=1;
			
			skac.repaint();
		}
		
		
	}

}
