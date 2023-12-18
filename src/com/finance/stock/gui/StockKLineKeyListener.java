package com.finance.stock.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JInternalFrame;

public class StockKLineKeyListener implements KeyListener {

	StockKLineAllChartPanel skac;
	
	public StockKLineKeyListener() {
		// TODO Auto-generated constructor stub
	}

	public StockKLineKeyListener(StockKLineAllChartPanel skac)
	{
		this.skac=skac;
		
	}	
	
		public void keyPressed(KeyEvent e) {
	
	
				
				// TODO Auto-generated method stub
				if (e.getKeyCode()==KeyEvent.VK_UP)
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
					
					skac.keepMoveToPoint=true;
					skac.repaint();
				}
				
				
				if (e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					skac.k_width=skac.k_width-2;
					if (skac.k_width<2)
						skac.k_width=2;
					
					skac.kz_width=skac.kz_width-2;
					if (skac.kz_width<1)
						skac.kz_width=1;
					
					skac.keepMoveToPoint=true;
					skac.repaint();
					
				}
				
				
				
				if (e.getKeyCode()==KeyEvent.VK_LEFT)
				{
					
					// 如果没有出现十字线，则设置显示十字线，并要初始化十字线到endPos位置
					if (skac.showCrossLine==false)
					{
						skac.showCrossLine=true;
						skac.initCrossLineRightEdge=true;
					}
					else
					{
					
						// 如果没到达最左边，则只向左继续移动十字线
						if (!skac.leftReachEdge)
						{
							skac.leftMoveToPoint=true;
						}
						
						// 如果到达最左边，则向右移动c_datePos
						if (skac.leftReachEdge)
						{
							skac.c_datePos=skac.c_datePos-1;
							if (skac.c_datePos<0)
								skac.c_datePos=0;
							
						}
					
					}
					
					skac.rightReachEdge=false;	 // 右侧没到头，保证还能向左移动K线图
					skac.repaint();
					
				}			
				
				
				if (e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					
					// 如果没有出现十字线，则设置显示十字线，并要初始化十字线到startPos位置
					if (skac.showCrossLine==false)
					{
						skac.showCrossLine=true;
						skac.initCrossLineLeftEdge=true;
					}
					else
					{
					
						// 如果没到达最右边，则向右继续移动十字线
						if (!skac.rightReachEdge)
						{
							skac.rightMoveToPoint=true;
						}
					
						// 如果到达最右边，则向左移动
						if (skac.rightReachEdge)
						{
							skac.c_datePos=skac.c_datePos+1;   // 把中心点左移，就实现了整体左移
							if (skac.c_datePos>skac.endPos)
								skac.c_datePos=skac.endPos;
													
						}
						
					}					
					
					skac.leftReachEdge=false;  // 左侧没到头，保证还能向右移动K线图
					skac.repaint();
					
				}
				
	
					
				if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					
					if (skac.showCrossLine==false)
					{
						skac.sklf.dispose();
						
						
						try
						{
							StockComponent.sjif.moveToFront();
							StockComponent.sjif.requestFocus();
							StockComponent.sjif.setSelected(true);
						}
						catch(Exception ec)
						{
							ec.printStackTrace();
						}
					}
					else
					{				
						skac.showCrossLine=false;
						skac.repaint();
					}
					
				}
			
				if (e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					if (skac.showCrossLine==true)
					{
						
					}
					
				}	
				
				
				if (e.getKeyCode()==KeyEvent.VK_F)
				{
					
					if (skac.indicatorPercent.equals("5"))  // only show 5% percent
					{
						skac.indicatorPercent="10";  // show all percent
					}
					else if (skac.indicatorPercent.equals("10"))  // show all percent
					{
						skac.indicatorPercent="5";  // only show 5% percent
					}
					
					
					skac.repaint();
					
					
				}
			
		}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {


		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
