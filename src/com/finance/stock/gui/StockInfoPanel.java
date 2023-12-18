package com.finance.stock.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.finance.stock.data.StockDayData;

public class StockInfoPanel extends JPanel {

	
	public Graphics2D my_g;
	public StockDayData sdd=new StockDayData();
	
	Font autoFont_EN=new Font("Arial", Font.PLAIN, 16);
	Font autoFont_CN=new Font("宋体", Font.PLAIN,  16);
	
	public double maxDDR;
	public double maxRUR;
	
	public double getMaxRUR() {
		return maxRUR;
	}

	public void setMaxRUR(double maxRUR) {
		this.maxRUR = maxRUR;
	}

	public double getMaxDDR() {
		return maxDDR;
	}

	public void setMaxDDR(double maxDDR) {
		this.maxDDR = maxDDR;
	}

	public StockDayData getSdd() {
		return sdd;
	}

	public void setSdd(StockDayData sdd) {
		this.sdd = sdd;
	}
	
	public StockInfoPanel(StockDayData sdd)
	{
		this.sdd=sdd;
		this.setBackground(Color.BLACK);
	
	}
	
	public void drawInfo(StockDayData sdd)
	{
		
		int infoDialog_x=0;
		int infoDialog_y=0;
		
		my_g.setColor(Color.red);
		my_g.setFont(autoFont_CN);
		my_g.drawLine(0, 0, 0, this.getHeight());
		
		my_g.setColor(Color.white);
		my_g.drawString("交易日期   "+CommonTool.dealNullStr(sdd.getDate()), infoDialog_x+10, infoDialog_y+30);
		my_g.drawString("股票代码   "+CommonTool.dealNullStr(sdd.getCode()), infoDialog_x+10, infoDialog_y+60);
		my_g.drawString("股票名称   "+CommonTool.dealNullStr(sdd.getName()), infoDialog_x+10, infoDialog_y+90);
		
		setColorByStockValue(sdd.getOpen_rise());
		my_g.drawString(" 开盘价    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getOpen())+"("+CommonTool.getDoubleNumberWithTwoBit(sdd.getOpen_rise())+"%)", infoDialog_x+10, infoDialog_y+120);
		setColorByStockValue(sdd.getHigh_rise());
		my_g.drawString(" 最高价    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getHigh())+"("+CommonTool.getDoubleNumberWithTwoBit(sdd.getHigh_rise())+"%)", infoDialog_x+10, infoDialog_y+150);
		setColorByStockValue(sdd.getLow_rise());
		my_g.drawString(" 最低价    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getLow())+"("+CommonTool.getDoubleNumberWithTwoBit(sdd.getLow_rise())+"%)", infoDialog_x+10, infoDialog_y+180);
		setColorByStockValue(sdd.getClose_rise());
		my_g.drawString(" 收盘价    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getClose())+"("+CommonTool.getDoubleNumberWithTwoBit(sdd.getClose_rise())+"%)", infoDialog_x+10, infoDialog_y+210);
		
		my_g.setColor(Color.yellow);
		my_g.drawString(" 成交量    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getAmount()/100)+"手", infoDialog_x+10, infoDialog_y+240);
		my_g.drawString(" 成交额    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getMoney()/100000000)+"亿", infoDialog_x+10, infoDialog_y+270);
		my_g.drawString(" 换手率    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getChange_ratio()*100)+"%", infoDialog_x+10, infoDialog_y+300);
		
		my_g.setColor(Color.white);
		my_g.drawString(" 流通值    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000)+"亿", infoDialog_x+10, infoDialog_y+330);
		my_g.drawString(" 总市值    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000)+"亿", infoDialog_x+10, infoDialog_y+360);
		
		my_g.setColor(Color.pink);
		my_g.drawString(" Min-Max: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getPastLowAvg())+"-"+CommonTool.getDoubleNumberWithTwoBit(sdd.getPastHighAvg()), infoDialog_x+10, infoDialog_y+390);

		my_g.setColor(Color.cyan);
		my_g.drawString("MACD: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getMa_macd()), infoDialog_x+10, infoDialog_y+420);
		
		if (sdd.isTransDate())
		{
			setColorByStockValue(sdd.getProfit());
			my_g.drawString(" 收益    "+CommonTool.getDoubleNumberWithTwoBit(sdd.getProfit())+"% (count="+sdd.getCount()+")", infoDialog_x+10, infoDialog_y+390);
		}
		
		my_g.setColor(Color.blue);
		my_g.drawString("当前最大回撤:  "+maxDDR+"%", infoDialog_x+10, infoDialog_y+450);
		
		my_g.setColor(Color.pink);
		my_g.drawString("当前最大涨幅:  "+maxRUR+"%", infoDialog_x+10, infoDialog_y+480);
		
		my_g.setColor(Color.white);
		my_g.drawString("KDJ_K:  "+CommonTool.getDoubleNumberWithTwoBit(sdd.getKdj_k()), infoDialog_x+10, infoDialog_y+520);
		my_g.drawString("KDJ_D:  "+CommonTool.getDoubleNumberWithTwoBit(sdd.getKdj_d()), infoDialog_x+10, infoDialog_y+550);
		my_g.drawString("KDJ_J:  "+CommonTool.getDoubleNumberWithTwoBit(sdd.getKdj_j()), infoDialog_x+10, infoDialog_y+580);
		
		my_g.setColor(Color.orange);
		my_g.drawString("量比:  "+CommonTool.getDoubleNumberWithTwoBit(sdd.getEq_ratio()), infoDialog_x+10, infoDialog_y+620);
		
		my_g.setColor(Color.cyan);
		my_g.drawString("市盈率 PE: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getPe_ratio()), infoDialog_x+10, infoDialog_y+660);
		my_g.drawString("市销率 PX: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getPx_ratio()), infoDialog_x+10, infoDialog_y+690);
		my_g.drawString("市净率 PJ: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getPj_ratio()), infoDialog_x+10, infoDialog_y+720);
		my_g.setColor(Color.pink);
		my_g.drawString("("+CommonTool.getDoubleNumberWithTwoBit(sdd.getPastPeAvg())+")", infoDialog_x+170, infoDialog_y+660);
		my_g.drawString("每股收益: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getEarnPerShare()), infoDialog_x+10, infoDialog_y+750);
		my_g.drawString("当前估价: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getEarnPerShare()*sdd.getPastPeAvg()), infoDialog_x+10, infoDialog_y+780);
	
		my_g.setColor(Color.white);
		my_g.drawString("WR6: "+CommonTool.getDoubleNumberWithTwoBit(sdd.wr6), infoDialog_x+10, infoDialog_y+810);
		my_g.setColor(Color.gray);
		my_g.drawString("WR10: "+CommonTool.getDoubleNumberWithTwoBit(sdd.wr10), infoDialog_x+10, infoDialog_y+830);
		my_g.setColor(new Color(255, 0, 255));
		my_g.drawString("WR42: "+CommonTool.getDoubleNumberWithTwoBit(sdd.wr42), infoDialog_x+120, infoDialog_y+810);
		my_g.setColor(Color.yellow);
		my_g.drawString("WR100: "+CommonTool.getDoubleNumberWithTwoBit(sdd.wr100), infoDialog_x+120, infoDialog_y+830);
		
		my_g.drawString("CCI14: "+CommonTool.getDoubleNumberWithTwoBit(sdd.getCCI14()), infoDialog_x+120, infoDialog_y+750);
		
	}
	
	
	public void setColorByStockValue(double value)
	{
		
		if (value>0)
		{
			my_g.setColor(Color.red);
		}
		
		if (value==0)
		{
			my_g.setColor(Color.gray);
		}
		
		if (value<0)
		{
			my_g.setColor(Color.green);
		}
		
	}
	
	//覆盖JPanel的paint方法  
    //Graphics 是绘图的重要类。你可以把他理解成一只画笔  
	public void paint(Graphics g){  
           
    	   //1.调用父类函数完成初始化任务  
           //这句话不能少  
           super.paint(g);  
           
           my_g=(Graphics2D)g;
           
           drawInfo(sdd);
            
    }  	

	
}
