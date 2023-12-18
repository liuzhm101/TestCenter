package com.finance.stock.gui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StockKLineMouseMotionListener implements MouseMotionListener, MouseListener {

	
	StockKLineAllChartPanel skac;
	static Point startPoint;
	
	public StockKLineMouseMotionListener(StockKLineAllChartPanel skac)
	{
		this.skac=skac;
		
	}	
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getClickCount()==2)
		{
			skac.showCrossLine=!skac.showCrossLine;
			skac.repaint();
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		startPoint=e.getPoint();
		
		if (e.isPopupTrigger()) {
			showMenu(e);
		}
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		skac.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		if (e.isPopupTrigger()) {
			showMenu(e);
		}
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		skac.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		Point currentPoint=e.getPoint();
		int x=(int)(currentPoint.getX()-startPoint.getX());
		
		skac.c_datePos=skac.c_datePos-x;   // 这个不准确，不能用pos减去距离x 
		if (skac.c_datePos<0)
			skac.c_datePos=0;
		
		if (skac.c_datePos>skac.endPos)
			skac.c_datePos=skac.endPos;
		
		skac.repaint();
		
		startPoint=currentPoint;
		
	}

	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		skac.crossLine_x=e.getX();
		skac.crossLine_y=e.getY();
		skac.repaint();
		
	}
	
	private void showMenu(MouseEvent e) {
		skac.popupMenu.show(e.getComponent(), e.getX(), e.getY());
	}
	

}
