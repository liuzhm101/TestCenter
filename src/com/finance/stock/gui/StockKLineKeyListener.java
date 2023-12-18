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
					
					// ���û�г���ʮ���ߣ���������ʾʮ���ߣ���Ҫ��ʼ��ʮ���ߵ�endPosλ��
					if (skac.showCrossLine==false)
					{
						skac.showCrossLine=true;
						skac.initCrossLineRightEdge=true;
					}
					else
					{
					
						// ���û��������ߣ���ֻ��������ƶ�ʮ����
						if (!skac.leftReachEdge)
						{
							skac.leftMoveToPoint=true;
						}
						
						// �����������ߣ��������ƶ�c_datePos
						if (skac.leftReachEdge)
						{
							skac.c_datePos=skac.c_datePos-1;
							if (skac.c_datePos<0)
								skac.c_datePos=0;
							
						}
					
					}
					
					skac.rightReachEdge=false;	 // �Ҳ�û��ͷ����֤���������ƶ�K��ͼ
					skac.repaint();
					
				}			
				
				
				if (e.getKeyCode()==KeyEvent.VK_RIGHT)
				{
					
					// ���û�г���ʮ���ߣ���������ʾʮ���ߣ���Ҫ��ʼ��ʮ���ߵ�startPosλ��
					if (skac.showCrossLine==false)
					{
						skac.showCrossLine=true;
						skac.initCrossLineLeftEdge=true;
					}
					else
					{
					
						// ���û�������ұߣ������Ҽ����ƶ�ʮ����
						if (!skac.rightReachEdge)
						{
							skac.rightMoveToPoint=true;
						}
					
						// ����������ұߣ��������ƶ�
						if (skac.rightReachEdge)
						{
							skac.c_datePos=skac.c_datePos+1;   // �����ĵ����ƣ���ʵ������������
							if (skac.c_datePos>skac.endPos)
								skac.c_datePos=skac.endPos;
													
						}
						
					}					
					
					skac.leftReachEdge=false;  // ���û��ͷ����֤���������ƶ�K��ͼ
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
