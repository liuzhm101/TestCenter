package com.finance.stock.gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Stroke;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import com.finance.stock.data.MarketRDDayData;
import com.finance.stock.data.StockDayData;
import com.finance.stock.data.StockRecordDDR;
import com.finance.stock.data.StockRecordRUR;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockKLineAllChartPanel extends JPanel {

	
	public StockKLineFrame sklf;
	
	public Graphics2D my_g;
	
	public List stockDataRecordList=new ArrayList();
	public String c_date="";
	public int k_width=12;  // K��������
	public int kz_width=8; // K��������
	int kcount=0;  // K������
	int interval=1; // K��ѡ����
	public int y_distance=1;
	public int d_height=0;

	public int y_gap=0;  // ��ͼ��������0�������ƫ��ֵ�����ڲ���Ҫ��
	
	public int c_datePos=0;	
	public int startPos=0;
	public int endPos=0;
	public int mark_datePos=0;
	
	public boolean showCrossLine=false;
	public int crossLine_x=0;
	public int crossLine_y=0;
	
	public boolean leftMoveToPoint=false;
	public boolean rightMoveToPoint=false;
	public boolean keepMoveToPoint=false;
	
	public boolean leftReachEdge=false;
	public boolean rightReachEdge=false;
	
	public boolean initCrossLineLeftEdge=false;
	public boolean initCrossLineRightEdge=false;
	
	int fontsize=20;
	
	public boolean displayResult=false;
	public StockInfoPanel infoPanel;
	
//	public String indicatorType="";
	public String indicatorPercent="Compare5"; 
//	public String indicatorPercent="10"; 
	
	public Map marketDataRecordMap=new TreeMap();
	public Map ygProfitDataRecordMap=new TreeMap();
	
	StockRecordDDR srd=new StockRecordDDR();
	StockRecordRUR srr=new StockRecordRUR();
	
	JPopupMenu popupMenu = new JPopupMenu();
	
//	public String type_ind="MarketRD";  // Ĭ����amount�ɽ���Ϊ�ο�
	public String type_ind="macd";  // Ĭ����amount�ɽ���Ϊ�ο�
//	public String type_ind="wr100";  // Ĭ����amount�ɽ���Ϊ�ο�
//	public String type_ind="cci14";  // Ĭ����amount�ɽ���Ϊ�ο�
	public String stockcode="";
	
	public static double enlargeFactor=1;
	
	public List transactionDataList;
	
	/**
	 * @wbp.parser.constructor
	 */
	public StockKLineAllChartPanel(List stockDataRecordList, String c_date, int k_width, int y_distance, int d_height, StockInfoPanel infoPanel) {
		// TODO Auto-generated constructor stub
		
		this.stockDataRecordList=stockDataRecordList;
		this.c_date=c_date;
		this.k_width=k_width;
		this.y_distance=y_distance;
		this.d_height=d_height;
		this.c_datePos=CommonTool.getDatePosition(stockDataRecordList, c_date);
		this.mark_datePos=c_datePos;
		this.kz_width=k_width-6;
		
		this.infoPanel=infoPanel;
		
		this.setBackground(Color.black);
		
		// ׼����market all����
		marketDataRecordMap=CommonTool.loadMarketDataRecordMap("all");
		
//		addPopup(this, popupMenu);
		
		JMenu mnNewMenu = new JMenu("Load Indicator");
		popupMenu.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Market All");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap("all");
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmMarket = new JMenuItem("Market 600");
		mntmMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap("600");
				
			}
		});
		mnNewMenu.add(mntmMarket);
		
		JMenuItem mntmMarket_1 = new JMenuItem("Market 300");
		mntmMarket_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap("300");
				
			}
		});
		mnNewMenu.add(mntmMarket_1);
		
		JMenuItem mntmMarket_2 = new JMenuItem("Market 000");
		mntmMarket_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap("000");
				
			}
		});
		mnNewMenu.add(mntmMarket_2);
		
		JMenuItem mntmMarket_3 = new JMenuItem("Market 002");
		mntmMarket_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap("002");
				
			}
		});
		mnNewMenu.add(mntmMarket_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("YG Profit Circle");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("YG Profit Rect");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu1 = new JMenu("MarketType");
		popupMenu.add(mnNewMenu1);
		
		JMenuItem mntRise10 = new JMenuItem("Rise_10%");
		mntRise10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				indicatorPercent="Rise10";
				String marketType=CommonTool.getStockMarketType(stockcode);
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap(marketType);
				
			}
		});
		mnNewMenu1.add(mntRise10);
		
		JMenuItem mntDown10 = new JMenuItem("Down_10%");
		mntDown10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				indicatorPercent="Down10";
				String marketType=CommonTool.getStockMarketType(stockcode);
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap(marketType);
				
			}
		});
		mnNewMenu1.add(mntDown10);
		
		
		JMenuItem mntRise5 = new JMenuItem("Rise_5%");
		mntRise5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				indicatorPercent="Rise5";
				String marketType=CommonTool.getStockMarketType(stockcode);
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap(marketType);
				
			}
		});
		mnNewMenu1.add(mntRise5);
		
		JMenuItem mntDown5 = new JMenuItem("Down_5%");
		mntDown5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				indicatorPercent="Down5";
				String marketType=CommonTool.getStockMarketType(stockcode);
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap(marketType);
				
			}
		});
		mnNewMenu1.add(mntDown5);
		
		JMenuItem compare5 = new JMenuItem("Compare_5%");
		compare5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="MarketRD";
				indicatorPercent="Compare5";
				String marketType=CommonTool.getStockMarketType(stockcode);
				marketDataRecordMap=CommonTool.loadMarketDataRecordMap(marketType);
				
			}
		});
		mnNewMenu1.add(compare5);
		
		
		JMenu mnNewMenu2 = new JMenu("IndicatorType");
		popupMenu.add(mnNewMenu2);
		
		JMenuItem mntMACD = new JMenuItem("macd");
		mntMACD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="macd";
				repaint();
			}
		});
		mnNewMenu2.add(mntMACD);
		
		JMenuItem mntKDJ = new JMenuItem("kdj");
		mntKDJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="kdj";
				repaint();
			}
		});
		mnNewMenu2.add(mntKDJ);
		
		JMenu mnNewMenuWR = new JMenu("wr");
		mnNewMenu2.add(mnNewMenuWR);
		
		JMenuItem mntWR6 = new JMenuItem("wr6");
		mntWR6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="wr6";
				repaint();
				
			}
		});
		mnNewMenuWR.add(mntWR6);
		
		JMenuItem mntWR10 = new JMenuItem("wr10");
		mntWR10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="wr10";
				repaint();
				
			}
		});
		mnNewMenuWR.add(mntWR10);
		
		JMenuItem mntWR42 = new JMenuItem("wr42");
		mntWR42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="wr42";
				repaint();
			}
		});
		mnNewMenuWR.add(mntWR42);
		
		JMenuItem mntWR100 = new JMenuItem("wr100");
		mntWR100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="wr100";
				repaint();
			}
		});
		mnNewMenuWR.add(mntWR100);
		
		JMenuItem mntWR_all = new JMenuItem("wr_all");
		mntWR_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				type_ind="wr_all";
				repaint();
			}
		});
		mnNewMenuWR.add(mntWR_all);
		
		
		JMenu mnNewMenu3 = new JMenu("ChangeSize");
		popupMenu.add(mnNewMenu3);
		
		JMenuItem mntLarge = new JMenuItem("large");
		mntLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (enlargeFactor>1)
				{
					enlargeFactor=enlargeFactor-0.5;
				}
				else
				{
					enlargeFactor=1;
				}
				
				repaint();
			
			}
		});
		mnNewMenu3.add(mntLarge);
		
		JMenuItem mntSmall = new JMenuItem("small");
		mntSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				enlargeFactor=enlargeFactor+0.1;
				
				repaint();
			}
		});
		mnNewMenu3.add(mntSmall);
		
		
		JMenuItem mntmSetting = new JMenuItem("Setting");
		popupMenu.add(mntmSetting);
		
		
		int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
		if (screenWidth<1800)
		{
			fontsize=12;
		}
		
		if (screenWidth>=1800 && screenWidth<2200)
		{
			fontsize=16;
		}
		
		if (screenWidth>=2200)
		{
			fontsize=20;
		}

		
	}

	
	
	public void drawAllKLineChart(List stockDataRecordList, int c_datePos, int k_width, int y_distance, int d_height)
	{
		
		// ��ȡK�ߴ��ڳߴ�
		int width=this.getWidth();
		int height=this.getHeight();
		
		int indicatorHeight=height*1/7;
//		int indicatorHeight=0;			// ��������߶ȣ��ɸ��ݴ��ڸ߶����ţ�
		int amountHeight=height*1/7;    // �ɽ�������߶ȣ��ɸ��ݴ��ڸ߶����ţ�
		int KLineHeight=height-indicatorHeight-amountHeight; // ʵ��K������߶�
		
		// �����ܻ��Ƶ�K��������
//		if (k_width==2)
//		{
//			kcount=2*kcount;
//			interval=interval*2;
//		}
//		else
		{
			kcount=(int)width/k_width;  
			interval=1;
		}
		
		// ����������K����ǰ�����K��������
		float prePeriodRatio=0.3f;    // ��c_datePosΪ���ߣ�ǰ��K����������
		int prePeriod=Math.round(kcount*prePeriodRatio);
		int aftPeriod=kcount-prePeriod-1;
		
		// ����ͷβ���������ݵļ�ֵ���
		startPos=c_datePos-prePeriod;
		endPos=c_datePos+aftPeriod;
		
		if (startPos<0)   // c_datePosǰû��prePeriod��ô�����ݣ�����c_datePos���油����,�Գ�����������
		{
			startPos=0;
			endPos=kcount-1;
		}
		
		if (endPos>stockDataRecordList.size()-1)
		{
			endPos=stockDataRecordList.size()-1;
		}
		System.out.println("StartPos: "+startPos+" "+"EndPos: "+endPos+" C_datePos: "+c_datePos);
		
		// �ҳ�startPos��endPos��Χ�ڵ������С�۸�ֵ
		double max=0;
		double min=1000000;
		double max_amount=0;
		double max_kdj=-1000;
		double min_kdj=1000;
		double max_macd=1;
		double min_macd=-1;
		double max_wr=100;
		double min_wr=0;
		double max_cci=300;
		double min_cci=-300;
		
		List priceList=new ArrayList();  // ���㵱ǰK�߽׶ε����س���׼��priceList
		List sddList=new ArrayList();
		for (int i=startPos; i<=endPos; i=i+interval)
		{
			StockDayData sdd=(StockDayData)stockDataRecordList.get(i);
			stockcode=sdd.getCode();
			
			max=Math.max(max, sdd.getHigh());
			min=Math.min(min, sdd.getLow());
			max_amount=Math.max(max_amount, sdd.getAmount());
			max_kdj=Math.max(Math.max(Math.max(max_kdj, sdd.getKdj_k()),sdd.getKdj_d()),sdd.getKdj_j());
			min_kdj=Math.min(Math.min(Math.min(min_kdj, sdd.getKdj_k()),sdd.getKdj_d()),sdd.getKdj_j());
			max_macd=Math.max(Math.max(max_macd, sdd.getMa_dea()),sdd.getMa_dif());
			min_macd=Math.min(Math.min(min_macd, sdd.getMa_dea()),sdd.getMa_dif());
			
			priceList.add(sdd.getClose());
			sddList.add(sdd);
		}
//		double maxDDR=CommonTool.calculateMaxDrawDownByPrice(priceList); // �������ǰ�׶ε����س�ֵ�� maxDDR
		
		srd=CommonTool.calculateMaxDrawDownBySDD(sddList);
		srr=CommonTool.calculateMaxRiseUpBySDD(sddList);
		infoPanel.setMaxDDR(srd.getDDR());
		infoPanel.setMaxRUR(srr.getRUR());
		
		// ����K�߻�ͼ�Ķ����͵ײ�����ļ۸�ֵ
		double topPrice=(double)(max+(max-min)*0.05)*enlargeFactor; 
		double endPrice=(double)(min-(max-min)*0.05)/enlargeFactor; 
		double top_amount=(double)(max_amount*1.05);   // ������double���������ּ���Ĵ�������
		
		if (endPrice<0)
		{
			endPrice=0;
		}
		
		
		// ���Ʊ���ͼ�������ߣ�����ֵ���۸��ߣ�ʱ���ߣ��ɽ�����ߣ�
		int y_markCount=9;   // K��ͼ��������
		int x_perMarkGap=3;   // K��ͼ���ߵ�����
		int y_perMarkGap=KLineHeight/y_markCount;    // ������������  
		double y_perPriceGap=((double)topPrice-(double)endPrice)/y_markCount;  // ����������۸���
		int x_markCount=width/x_perMarkGap;     // ������������
		
		Font autoFont_EN=new Font("Arial", Font.PLAIN, fontsize);
		Font autoFont_CN=new Font("����", Font.PLAIN,  fontsize);
        
        my_g.setFont(autoFont_EN);
        
		int y_mark=0;
		double y_price=topPrice;
		my_g.setColor(Color.red);
		my_g.drawString(CommonTool.getDoubleNumberWithTwoBit(topPrice)+"", width-60, 10);	// ��Ƕ�����߼۸�top
		my_g.drawString(CommonTool.getDoubleNumberWithTwoBit(endPrice)+"", width-60, KLineHeight-5);  // ��ǵײ���ͼ۸�end
		
		
		// ����K��ͼ����ÿ�е�����
		for (int s=1; s<y_markCount; s++)
		{
			// ����ÿһ����������
			y_mark=y_mark+y_perMarkGap;
			y_price=y_price-y_perPriceGap;
			y_price=CommonTool.getDoubleNumberWithTwoBit(y_price);  
			my_g.drawString(y_price+"", width-60, y_mark-5);	// ���ÿ�м���ߵĶ�Ӧ�ļ۸�price
			
			int x_mark=0;
			for (int t=1; t<x_markCount; t++)
			{
				x_mark=x_mark+x_perMarkGap;
				my_g.setColor(Color.red);
				my_g.drawLine(x_mark, y_mark, x_mark, y_mark);   // ����ÿһ���������ߵĵ�dot 
			}
		}
		
		// ����K��ͼ�ײ���ʵ�ߣ��ɽ�����ʵ�ߣ�������ʵ��
		my_g.drawLine(0, KLineHeight, width, KLineHeight);
		my_g.drawLine(0, KLineHeight+amountHeight, width, KLineHeight+amountHeight);
		my_g.drawLine(0, KLineHeight+amountHeight+indicatorHeight-1, width, KLineHeight+amountHeight+indicatorHeight-1);
		
		
		// ���ƶ��յ�k��ͼ
		StockDayData crossStockDayData=new StockDayData();
		StockDayData previousStockDayData=new StockDayData();
		for (int j=startPos; j<=endPos; j=j+interval)
		{
			int x=k_width/2+(j-startPos)*k_width+5;  // +5��ͼƫ����
			StockDayData sdd=(StockDayData)stockDataRecordList.get(j);
			
//			if (sdd.getDate().equals(c_date))
//				sdd.isCenterDate=true;
			sdd.isCenterDate=false;
			sdd.isMaxHighDate=false;
			sdd.isMinLowDate=false;
			
//			sdd.isMarkDate=false;
			if (j==mark_datePos)    // ��עdate_c
				sdd.isMarkDate=true;
			
			if (sdd.getHigh()==max)
				sdd.isMaxHighDate=true;
			
			if (sdd.getLow()==min)
				sdd.isMinLowDate=true;
			
			
//			if (j==startPos)
//			{
//				previousStockDayData=sdd;
//			}
			
			double max_value=0;
			double min_value=0;
			
			if (type_ind.equals("macd"))
			{
				max_value=max_macd;
				min_value=min_macd;
			}
			else if (type_ind.equals("kdj"))
			{
				max_value=max_kdj;
				min_value=min_kdj;
			}
			else if (type_ind.startsWith("wr"))
			{
				max_value=max_wr;
				min_value=min_wr;
			}
			else if (type_ind.startsWith("cci"))
			{
				max_value=max_cci;
				min_value=min_cci;
			}
			
			drawOneKLine(sdd, previousStockDayData, x, KLineHeight, amountHeight, indicatorHeight, topPrice, endPrice, top_amount, type_ind, max_value, min_value);
			previousStockDayData=sdd;
	
			if (crossLine_x>x-k_width/2 && crossLine_x<=x+k_width/2)
			{
				// ���cross������������K�����ڵ�����
				crossStockDayData=sdd;
				System.out.println("SelectPos: "+sdd.getPosNum());
			}
			
			
			if (crossLine_x>x-kz_width/2 && crossLine_x<x+kz_width/2 
					&& crossLine_y>sdd.getY_low() && crossLine_y<sdd.getY_high())
			{
				// ���cross������������K���ڣ������Ժ���
						
			}
			
			// ����5�ա�10�ա�20�ա�60��ֵ����
			if (j==endPos && showCrossLine==false)
			{
				String content="";
				int strPos=5;
		        my_g.setFont(autoFont_CN);
		        my_g.setColor(Color.lightGray);
		        content=CommonTool.dealNullStr(sdd.getName())+" ("+sdd.getCode().trim()+") "+sdd.getDate();
		        my_g.drawString(content, strPos, autoFont_CN.getSize()+2); 
		        
		        my_g.setFont(autoFont_EN);
		        my_g.setColor(Color.white);
		        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+30;  // ������һ���ַ����Ŀ�ʼλ��
		        content="MA5: "+sdd.getMa_5();
		        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);
		        
		        my_g.setColor(Color.yellow);
		        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+20;  // ������һ���ַ����Ŀ�ʼλ��
		        content="MA10: "+sdd.getMa_10();
		        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);
		        
		        my_g.setColor(new Color(255, 0, 255));
		        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+20;  // ������һ���ַ����Ŀ�ʼλ��
		        content="MA20: "+sdd.getMa_20();
		        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);
		        
		        my_g.setColor(Color.green);
		        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+20;  // ������һ���ַ����Ŀ�ʼλ��
		        content="MA60: "+sdd.getMa_60();
		        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);		
				
				
			}
			
			infoPanel.setSdd(sdd);
			infoPanel.repaint();
			
		}
		
	
		// ������������Ҽ��ƶ��¼�����Ҫ���¶�λcrossLine���ڽ���K������
		if (leftMoveToPoint)
		{
			int newPosNum=crossStockDayData.getPosNum()-1;
			crossStockDayData=(StockDayData)stockDataRecordList.get(newPosNum);
			crossLine_x=crossStockDayData.getX_center();
			crossLine_y=crossStockDayData.getY_close();
			if (newPosNum==startPos)
			{
				leftReachEdge=true;
			}
		}
		
		if (rightMoveToPoint)
		{
			int newPosNum=crossStockDayData.getPosNum()+1;
			crossStockDayData=(StockDayData)stockDataRecordList.get(newPosNum);
			crossLine_x=crossStockDayData.getX_center();
			crossLine_y=crossStockDayData.getY_close();
			if (newPosNum==endPos)   // ���ﵱǰ��������һ��K��
			{
				rightReachEdge=true;
			}
		}
		
		
//		if (keepMoveToPoint)
//		{
//			int newPosNum=crossStockDayData.getPosNum();
//			crossStockDayData=(StockDayData)stockDataRecordList.get(newPosNum);
//			crossLine_x=crossStockDayData.getX_center();
//			crossLine_y=crossStockDayData.getY_close();
//			
//		}
		
		
		// ��λ����ߵ�ʮ���߽�����ƶ�������ֵ��
		if (leftReachEdge)
		{
			crossLine_x=crossStockDayData.getX_center();
			crossLine_y=crossStockDayData.getY_close();
		}
		
		// ��λ���ұߵ�ʮ���߽�����ƶ�������ֵ��
		if (rightReachEdge)
		{
			crossLine_x=crossStockDayData.getX_center();
			crossLine_y=crossStockDayData.getY_close();
		}
		
		// ��ʮ���߳���������ߵ�K������
		if (initCrossLineLeftEdge)
		{
			crossStockDayData=(StockDayData)stockDataRecordList.get(startPos);
			crossLine_x=crossStockDayData.getX_center();
			crossLine_y=crossStockDayData.getY_close();
			leftReachEdge=true;
		}
		
		// ��ʮ���߳��������ұߵ�K������
		if (initCrossLineRightEdge)
		{
			crossStockDayData=(StockDayData)stockDataRecordList.get(endPos);
			crossLine_x=crossStockDayData.getX_center();
			crossLine_y=crossStockDayData.getY_close();
			rightReachEdge=true;
		}
		
		initCrossLineLeftEdge=false;
		initCrossLineRightEdge=false;
		
		leftMoveToPoint=false;
		rightMoveToPoint=false;
		

		
		
		// ����CrossLineʮ�ֶ�λ�߼�InfoDialog��Ʊ��Ϣ��
		if (showCrossLine==true)
		{
			// ����ʮ�ֶ�λ��
			my_g.setColor(Color.white);
			my_g.drawLine(0, crossLine_y, width, crossLine_y);
			my_g.drawLine(crossLine_x, 0, crossLine_x, height);

			// �������ڻ�����
			my_g.setColor(Color.blue);
			my_g.fillRect(crossLine_x+1, KLineHeight-24, 100, 24);
			my_g.setColor(Color.white);
			my_g.drawString(crossStockDayData.getDate()+"", crossLine_x+8, KLineHeight-8);
			
			int infoDialog_x=width-300;
			int infoDialog_y=10;
			
			// ���ƹ�Ʊ��Ϣ��
//			my_g.setColor(Color.black);
//			my_g.fillRect(infoDialog_x+45, infoDialog_y, 220, 320);
//			my_g.setColor(Color.red);
//			my_g.drawRect(infoDialog_x+45, infoDialog_y, 220, 320);
//			
//			// ���ƹ�Ʊ��Ϣ
//			my_g.setColor(Color.red);
//			my_g.setFont(autoFont_CN);
//			my_g.drawString("��������   "+crossStockDayData.getDate(), infoDialog_x+55, infoDialog_y+30);
//			my_g.drawString("��Ʊ����   "+crossStockDayData.getCode(), infoDialog_x+55, infoDialog_y+60);
//			my_g.drawString("��Ʊ����   "+crossStockDayData.getName(), infoDialog_x+55, infoDialog_y+90);
//			my_g.drawString(" ���̼�    "+crossStockDayData.getOpen()+"("+crossStockDayData.getOpen_rise()+"%)", infoDialog_x+55, infoDialog_y+120);
//			my_g.drawString(" ��߼�    "+crossStockDayData.getHigh()+"("+crossStockDayData.getHigh_rise()+"%)", infoDialog_x+55, infoDialog_y+150);
//			my_g.drawString(" ��ͼ�    "+crossStockDayData.getLow()+"("+crossStockDayData.getLow_rise()+"%)", infoDialog_x+55, infoDialog_y+180);
//			my_g.drawString(" ���̼�    "+crossStockDayData.getClose()+"("+crossStockDayData.getClose_rise()+"%)", infoDialog_x+55, infoDialog_y+210);
//			my_g.drawString(" �ɽ���    "+crossStockDayData.getAmount(), infoDialog_x+55, infoDialog_y+240);
//			my_g.drawString(" �ɽ���    "+crossStockDayData.getMoney(), infoDialog_x+55, infoDialog_y+270);
//			my_g.drawString(" ������    "+crossStockDayData.getChange_ratio(), infoDialog_x+55, infoDialog_y+300);
			
			infoPanel.setSdd(crossStockDayData);
			infoPanel.repaint();
			
			// ��̬�仯���� MA5, MA10, MA20, M60 ��Ϣ
			String content="";
			int strPos=5;
	        my_g.setFont(autoFont_CN);
	        my_g.setColor(Color.lightGray);
	        content=CommonTool.dealNullStr(crossStockDayData.getName())+" ("+crossStockDayData.getCode()+") "+crossStockDayData.getDate();
	        my_g.drawString(content, strPos, autoFont_CN.getSize()+2); 
	        
	        my_g.setFont(autoFont_EN);
	        my_g.setColor(Color.white);
	        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+30;  // ������һ���ַ����Ŀ�ʼλ��
	        content="MA5: "+crossStockDayData.getMa_5();
	        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);
	        
	        my_g.setColor(Color.yellow);
	        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+20;  // ������һ���ַ����Ŀ�ʼλ��
	        content="MA10: "+crossStockDayData.getMa_10();
	        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);
	        
	        my_g.setColor(new Color(255, 0, 255));
	        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+20;  // ������һ���ַ����Ŀ�ʼλ��
	        content="MA20: "+crossStockDayData.getMa_20();
	        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);
	        
	        my_g.setColor(Color.green);
	        strPos=strPos+CommonTool.calcStrLength(content, autoFont_EN.getSize2D()/2)+20;  // ������һ���ַ����Ŀ�ʼλ��
	        content="MA60: "+crossStockDayData.getMa_60();
	        my_g.drawString(content, strPos, autoFont_CN.getSize()+2);		
			
	        
	        // ��̬���Ƶ����market�г��۲�����
	        MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(crossStockDayData.getDate());
	        
	        if (mdd!=null)
	        {
		        my_g.setColor(Color.red);
		        content="Rise/Down10: "+mdd.getRise10()+" / "+mdd.getDown10();
		        my_g.drawString(content, strPos+120, autoFont_CN.getSize()+5);
		        		        
		        content="Rise/Down5: "+(mdd.getRise5()+mdd.getRise7()+mdd.getRise10())+" / "+(mdd.getDown5()+mdd.getDown7()+mdd.getDown10());
		        my_g.drawString(content, strPos+320, autoFont_CN.getSize()+5);
		        
		        my_g.setColor(Color.white);
		        content="Rise/Down10 Open: "+mdd.getRise10_open()+" / "+mdd.getDown10_open();
		        my_g.drawString(content, strPos+120, autoFont_CN.getSize()+25);
		        		        
		        content="Rise/Down5 Open: "+(mdd.getRise5_open()+mdd.getRise7_open()+mdd.getRise10_open())+" / "+(mdd.getDown5_open()+mdd.getDown7_open()+mdd.getDown10_open());
		        my_g.drawString(content, strPos+320, autoFont_CN.getSize()+25);
	        }
	        
		}

		
	}
	
	
	public void drawOneKLine(StockDayData stockData, StockDayData previousStockData, int x, int KLineHeight, int amountHeight, int indicatorHeight, double top, double end, double top_amount, String type_ind, double top_ind, double end_ind)
	{
		
		double ratio=(double)KLineHeight/(top-end);  /* ���ű�����������double����ȡ��λС���������õ�0ֵ */
		
		int y_high=KLineHeight-(int)((stockData.getHigh()-end)*ratio);
		int y_low=KLineHeight-(int)((stockData.getLow()-end)*ratio);
		int y_open=KLineHeight-(int)((stockData.getOpen()-end)*ratio);
		int y_close=KLineHeight-(int)((stockData.getClose()-end)*ratio);
		
		int y_ma5=KLineHeight-(int)((stockData.getMa_5()-end)*ratio);
		int y_ma10=KLineHeight-(int)((stockData.getMa_10()-end)*ratio);
		int y_ma20=KLineHeight-(int)((stockData.getMa_20()-end)*ratio);
		int y_ma60=KLineHeight-(int)((stockData.getMa_60()-end)*ratio);
		
		int y_pastHighAvg=KLineHeight-(int)((stockData.getPastHighAvg()-end)*ratio);
		int y_pastLowAvg=KLineHeight-(int)((stockData.getPastLowAvg()-end)*ratio);
		int y_pastPEAvg=KLineHeight-(int)((stockData.getPastPeAvg()*stockData.getEarnPerShare()-end)*ratio);
		
		int y_amount_high=0;
		if (top_amount!=0)
		{
			double amountRatio=CommonTool.getDoubleNumberWithTwoBit((double)stockData.getAmount()/top_amount);
			y_amount_high=amountHeight-(int)(amountRatio*amountHeight);
		}
		
		stockData.setY_high(y_high);
		stockData.setY_low(y_low);
		stockData.setY_open(y_open);
		stockData.setY_close(y_close);
		
		stockData.setX_center(x);
		stockData.setX_left(x-kz_width/2);
		stockData.setX_right(x+kz_width/2);
		
		
		// ������K����
		if (stockData.getOpen()<stockData.getClose())
		{
			
			my_g.setColor(Color.red);   
			my_g.drawLine(x, y_low, x, y_high);
			my_g.drawRect(x-kz_width/2, y_close, kz_width, y_open-y_close);  // close�ߣ��Ӹ����ͻ�������
			my_g.setColor(Color.black); 
			my_g.drawLine(x, y_open-1, x, y_close+1);
			
			// �����ǳɽ�����
			my_g.setColor(Color.red);
			my_g.drawRect(x-kz_width/2, KLineHeight+y_amount_high, kz_width, amountHeight-y_amount_high);
			
		}
		
		// ���µ�K����
		if (stockData.getOpen()>stockData.getClose())
		{
			
			my_g.setColor(new Color(84, 255, 255));   
			my_g.drawLine(x, y_low, x, y_high);
			my_g.fillRect(x-kz_width/2, y_open, kz_width, y_close-y_open);	// open�ߣ��Ӹ����ͻ�������	 
			
			// ���µ��ɽ�����
			my_g.fillRect(x-kz_width/2, KLineHeight+y_amount_high, kz_width, amountHeight-y_amount_high);
			
		}
		
		// ��ƽ��K����
		if (stockData.getOpen()==stockData.getClose())
		{
			
			my_g.setColor(Color.white);   
			my_g.drawLine(x, y_low, x, y_high);
			my_g.fillRect(x-kz_width/2, y_close, kz_width, 1);   // open=close������ɫ����
			
			// ��ƽ�̳ɽ�����
			if (stockData.getHigh_rise()>0)
			{
				my_g.setColor(Color.red);
				my_g.drawRect(x-kz_width/2, KLineHeight+y_amount_high, kz_width, amountHeight-y_amount_high);
			}
			else
			{
				my_g.setColor(new Color(84, 255, 255));
				my_g.fillRect(x-kz_width/2, KLineHeight+y_amount_high, kz_width, amountHeight-y_amount_high);
			}
			
		}
		

		int x_pre=previousStockData.getX_center();
		
		// ����ma5, ma10, ma20, ma60����
		if (previousStockData.getMa_5()!=0)   // startPos��һ��K��֮ǰpreviousSDD�����ݣ��޷���MA�ߣ�����ӵڶ���K����ʼ������ǰ��MA��
		{			
			int y_ma5_pre=KLineHeight-(int)((previousStockData.getMa_5()-end)*ratio);
			my_g.setColor(Color.white);   
			my_g.drawLine(x, y_ma5, x_pre, y_ma5_pre);
		}			
		
		if (previousStockData.getMa_10()!=0)
		{
			int y_ma10_pre=KLineHeight-(int)((previousStockData.getMa_10()-end)*ratio);
			my_g.setColor(Color.yellow);   
			my_g.drawLine(x, y_ma10, x_pre, y_ma10_pre);	
		}
		
		if (previousStockData.getMa_20()!=0)
		{
			int y_ma20_pre=KLineHeight-(int)((previousStockData.getMa_20()-end)*ratio);
			my_g.setColor(new Color(255, 0, 255));   
			my_g.drawLine(x, y_ma20, x_pre, y_ma20_pre);	
		}
		
		if (previousStockData.getMa_60()!=0)
		{
			int y_ma60_pre=KLineHeight-(int)((previousStockData.getMa_60()-end)*ratio);
			my_g.setColor(Color.green);   
			my_g.drawLine(x, y_ma60, x_pre, y_ma60_pre);		
		}
		
/*		
		if (previousStockData.getPastHighAvg()!=0)  // ��ȥ��߹ɼ�ƽ��ֵ
		{
			int y_pastHighAvg_pre=KLineHeight-(int)((previousStockData.getPastHighAvg()-end)*ratio);
			my_g.setColor(Color.pink);   
			my_g.drawLine(x, y_pastHighAvg, x_pre, y_pastHighAvg_pre);		
		}
		
		if (previousStockData.getPastLowAvg()!=0)  // ��ȥ��͹ɼ�ƽ��ֵ
		{
			int y_pastLowAvg_pre=KLineHeight-(int)((previousStockData.getPastLowAvg()-end)*ratio);
			my_g.setColor(Color.pink);   
			my_g.drawLine(x, y_pastLowAvg, x_pre, y_pastLowAvg_pre);		
		}
		
		if (previousStockData.getPastPeAvg()!=0)  // ��ȥPEƽ��ֵ
		{
			int y_pastPEAvg_pre=KLineHeight-(int)((previousStockData.getPastPeAvg()*previousStockData.getEarnPerShare()-end)*ratio);
			my_g.setColor(Color.blue);   
			my_g.drawLine(x, y_pastPEAvg, x_pre, y_pastPEAvg_pre);		
		}
	
*/
		
		if ( type_ind.toLowerCase().equals("kdj") && top_ind-end_ind!=0 )
		{
			
			double kdj_ratio=CommonTool.getDoubleNumberWithTwoBit((double)indicatorHeight/(top_ind-end_ind));  /* ���ű�����������double����ȡ��λС���������õ�0ֵ */
			
			int indTotalHeight=KLineHeight+amountHeight+indicatorHeight;
			
			int y_kdj_k=indTotalHeight-(int)((stockData.getKdj_k()-end_ind)*kdj_ratio);
			int y_kdj_d=indTotalHeight-(int)((stockData.getKdj_d()-end_ind)*kdj_ratio);
			int y_kdj_j=indTotalHeight-(int)((stockData.getKdj_j()-end_ind)*kdj_ratio);
			
			if (previousStockData!=null)
			{
				
				int y_kdj_k_pre=indTotalHeight-(int)((previousStockData.getKdj_k()-end_ind)*kdj_ratio);
				int y_kdj_d_pre=indTotalHeight-(int)((previousStockData.getKdj_d()-end_ind)*kdj_ratio);
				int y_kdj_j_pre=indTotalHeight-(int)((previousStockData.getKdj_j()-end_ind)*kdj_ratio);
				
				my_g.setColor(Color.white);   
				my_g.drawLine(x, y_kdj_k, x_pre, y_kdj_k_pre);
				my_g.setColor(Color.yellow);   
				my_g.drawLine(x, y_kdj_d, x_pre, y_kdj_d_pre);	
				my_g.setColor(new Color(255, 0, 255));  
				my_g.drawLine(x, y_kdj_j, x_pre, y_kdj_j_pre);

			}
			
		}
		
		if ( type_ind.toLowerCase().startsWith("wr") && top_ind-end_ind!=0 )
		{
			
			double wr_ratio=CommonTool.getDoubleNumberWithTwoBit((double)indicatorHeight/(top_ind-end_ind));  /* ���ű�����������double����ȡ��λС���������õ�0ֵ */
			
			int indTotalHeight=KLineHeight+amountHeight+indicatorHeight;
			
			int y_wr_6=indTotalHeight-(int)((stockData.getWR6()-end_ind)*wr_ratio);
			int y_wr_10=indTotalHeight-(int)((stockData.getWR10()-end_ind)*wr_ratio);
			int y_wr_42=indTotalHeight-(int)((stockData.getWR42()-end_ind)*wr_ratio);
			int y_wr_100=indTotalHeight-(int)((stockData.getWR100()-end_ind)*wr_ratio);
			
			if (previousStockData!=null)
			{
				
				int y_wr_6_pre=indTotalHeight-(int)((previousStockData.getWR6()-end_ind)*wr_ratio);
				int y_wr_10_pre=indTotalHeight-(int)((previousStockData.getWR10()-end_ind)*wr_ratio);
				int y_wr_42_pre=indTotalHeight-(int)((previousStockData.getWR42()-end_ind)*wr_ratio);
				int y_wr_100_pre=indTotalHeight-(int)((previousStockData.getWR100()-end_ind)*wr_ratio);
				
				if (type_ind.equals("wr6") || type_ind.equals("wr_all"))
				{
					my_g.setColor(Color.yellow);   
					my_g.drawLine(x, y_wr_6, x_pre, y_wr_6_pre);
				}
				
				if (type_ind.equals("wr10") || type_ind.equals("wr_all"))
				{
					my_g.setColor(Color.gray);   
					my_g.drawLine(x, y_wr_10, x_pre, y_wr_10_pre);	
				}
				
				if (type_ind.equals("wr42") || type_ind.equals("wr_all"))
				{
					my_g.setColor(new Color(255, 0, 255));  
					my_g.drawLine(x, y_wr_42, x_pre, y_wr_42_pre);	
					
				}
				
				if (type_ind.equals("wr100") || type_ind.equals("wr_all"))
				{
					
					my_g.setColor(Color.yellow);  
					my_g.drawLine(x, y_wr_100, x_pre, y_wr_100_pre);	
					
					my_g.setColor(new Color(255, 0, 255));  
					my_g.drawLine(x, y_wr_42, x_pre, y_wr_42_pre);
					
				}
			}
			
		}
		
		
		if ( type_ind.toLowerCase().startsWith("cci") && top_ind-end_ind!=0 )
		{
			
			double cci_ratio=CommonTool.getDoubleNumberWithTwoBit((double)indicatorHeight/(top_ind-end_ind));  /* ���ű�����������double����ȡ��λС���������õ�0ֵ */
			
			int indTotalHeight=KLineHeight+amountHeight+indicatorHeight;
			
			int y_cci_14=indTotalHeight-(int)((stockData.getCCI14()-end_ind)*cci_ratio);
			
			
			if (previousStockData!=null)
			{
				
				int y_cci_14_pre=indTotalHeight-(int)((previousStockData.getCCI14()-end_ind)*cci_ratio);
				
				if (type_ind.equals("cci14") )
				{
					my_g.setColor(Color.white);   
					my_g.drawLine(x, y_cci_14, x_pre, y_cci_14_pre);
				}
				
				
			}
			
		}
		
		
		// ��ʱK�߻���ÿ��ļ����
//		if (stockData.getDate().contains("-004"))     // 60����
//		if (stockData.getDate().contains("-008"))		// 30����
//		if (stockData.getDate().contains("-240"))	// 1����
//		{
//			
//			Stroke origed=my_g.getStroke();
//			Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0);
//		    my_g.setStroke(dashed);
//		        
//			my_g.setColor(Color.red);   
//			my_g.drawLine(x, 0, x, KLineHeight);
//			my_g.setStroke(origed);
//			
//		}
		
		if (previousStockData!=null && stockData!=null)
		{
			String previousDateStr=previousStockData.getDate();
			String currentDateStr=stockData.getDate();
			if (previousDateStr!=null && currentDateStr!=null && (!previousDateStr.substring(0,4).equals(currentDateStr.substring(0,4))) )
			{
				
				Stroke origed=my_g.getStroke();
				Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0);
			    my_g.setStroke(dashed);
			        
				my_g.setColor(Color.lightGray);   
				my_g.drawLine(x, 0, x, KLineHeight);
				my_g.drawString(stockData.getDate().substring(0,4), x+5, 50);
				my_g.setStroke(origed);
				
				
			}
		
		}		
		
		if ( type_ind.toLowerCase().equals("macd") && top_ind-end_ind!=0 )
		{
			
			// �ö�Ӧ�İ��ָ��macd���ݻ�ͼ����������stock��������ݻ�ͼ
//			stockData=CommonTool.getIndexDataForStock(stockData);  // ���stockDataͬһ���ͬ���ָ����Ϣ
//			previousStockData=CommonTool.getIndexDataForStock(stockData);	// ���previousStockDataͬһ���ͬ���ָ����Ϣ
			
			double macd_ratio=CommonTool.getDoubleNumberWithTwoBit((double)indicatorHeight/(top_ind-end_ind));  /* ���ű�����������double����ȡ��λС���������õ�0ֵ */
			
			int indTotalHeight=KLineHeight+amountHeight+indicatorHeight;
			
			int y_ma_dea=indTotalHeight-(int)((stockData.getMa_dea()-end_ind)*macd_ratio);
			int y_ma_dif=indTotalHeight-(int)((stockData.getMa_dif()-end_ind)*macd_ratio);
			
			if (previousStockData!=null)
			{
				
				int y_ma_dea_pre=indTotalHeight-(int)((previousStockData.getMa_dea()-end_ind)*macd_ratio);
				int y_ma_dif_pre=indTotalHeight-(int)((previousStockData.getMa_dif()-end_ind)*macd_ratio);

				my_g.setColor(Color.yellow);   
				my_g.drawLine(x, y_ma_dea, x_pre, y_ma_dea_pre);
				my_g.setColor(Color.white);   
				my_g.drawLine(x, y_ma_dif, x_pre, y_ma_dif_pre);	
				
				int y_ma_ddz=indTotalHeight-indicatorHeight/2+1;   // ddz������ʼ�����λ��
				int ddz_length=(int)((stockData.getMa_ddz())*macd_ratio*1.8);  // ddz���ĳ���,Ҫ����1.8���Ŵ�㿴�����
				my_g.setColor(Color.lightGray);   
				my_g.drawLine(x, y_ma_ddz, x, y_ma_ddz);
				
				int y_ma_ddz_end=y_ma_ddz-ddz_length;  // ddz�����յ�λ��

				if (stockData.getMa_ddz()>0)
				{
					my_g.setColor(Color.red);  
				}
				
				if (stockData.getMa_ddz()<0)
				{
					my_g.setColor(new Color(84, 255, 255)); 
				}
				my_g.drawLine(x, y_ma_ddz, x, y_ma_ddz_end);
				
			}
			
		}
		
		
		// ����DDR, RUR�����ʶ��
		if (srd.getCurSDD()!=null && stockData.getDate().equals(srd.getCurSDD().getDate()) )
		{
			my_g.setColor(Color.green);
			
			int r=15;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_high-r, r*2, r*2);
		}
		
		if (srd.getMinSDD()!=null && stockData.getDate().equals(srd.getMinSDD().getDate()) )
		{
			my_g.setColor(Color.green);
			
			int r=15;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_low-r, r*2, r*2);
		}
		
		if (srr.getCurSDD()!=null && stockData.getDate().equals(srr.getCurSDD().getDate()) )
		{
			my_g.setColor(Color.pink);
			
			int r=15;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_low-r, r*2, r*2);
		}
		
		if (srr.getMaxSDD()!=null && stockData.getDate().equals(srr.getMaxSDD().getDate()) )
		{
			my_g.setColor(Color.pink);
			
			int r=15;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_high-r, r*2, r*2);
		}
		
		
		// ��עK�߹ؼ���λֵ
		if (stockData.isMarkDate())       // ���mark_date�Ĳο�ֵ
		{
			my_g.setColor(Color.white);
			my_g.drawLine(x, y_high-3, x+50, y_high-20);
			my_g.drawString(CommonTool.getDoubleNumberWithTwoBit(stockData.getClose())+"  "+CommonTool.getDoubleNumberWithTwoBit(stockData.getClose_rise())+"%  "+stockData.getDate(), x+58, y_high-30);
			
			int r=15;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_high-r, r*2, r*2);
		}
		
		if (stockData.isMaxHighDate())       // ���max_date�Ĳο�ֵ
		{
			my_g.setColor(Color.white);
			my_g.drawLine(x, y_high-3, x+30, y_high-10);
			my_g.drawString(stockData.getClose()+"", x+38, y_high-10);
		}
		
		if (stockData.isMinLowDate())       // ���min_date�Ĳο�ֵ
		{
			my_g.setColor(Color.white);
			my_g.drawLine(x, y_low+3, x+30, y_low+10);
			my_g.drawString(stockData.getClose()+"", x+38, y_low+10);
		}
		
		// ��עK�������λֵ
		if (stockData.isBuyDate())      
		{
			my_g.setColor(Color.yellow);
//			my_g.drawLine(x, y_high-3, x+50, y_high-20);
//			my_g.drawString(CommonTool.getDoubleNumberWithTwoBit(stockData.getClose())+"  "+CommonTool.getDoubleNumberWithTwoBit(stockData.getClose_rise())+"%  "+stockData.getDate(), x+58, y_high-30);
			
			int r=10;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_high-r-5, r*2, r*2);
		}
		
		// ��עK��������λֵ
		if (stockData.isSaleDate())      
		{
			my_g.setColor(Color.red);
//			my_g.drawLine(x, y_high-3, x+50, y_high-20);
//			my_g.drawString(CommonTool.getDoubleNumberWithTwoBit(stockData.getClose())+"  "+CommonTool.getDoubleNumberWithTwoBit(stockData.getClose_rise())+"%  "+stockData.getDate(), x+58, y_high-30);
			
			int r=10;
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_high-r, r*2, r*2);
		}
		
		// ����K������Բ
		if (stockData.isTransDate())
		{
			int r=(int)(Math.abs(stockData.getProfit()));
			
			if (stockData.getProfit()>0)
			{
				my_g.setColor(Color.pink);
			}
			else
			{
				my_g.setColor(Color.green);
			}
		
			my_g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.8f));
			my_g.fillOval(x-r, y_high-r, r*2, r*2);
			
		}
		

		
		if (type_ind.equals("MarketRD"))
		{
			
			
			MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(stockData.getDate());
			
			if (mdd!=null && indicatorPercent.equals("0"))
			{
			
				double riseRatio=CommonTool.getDoubleNumberWithTwoBit((double)mdd.getRise()/(double)mdd.getCount());
				double downRatio=CommonTool.getDoubleNumberWithTwoBit((double)mdd.getDown()/(double)mdd.getCount());
				double riseRatio5=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10()+(double)mdd.getRise7()+(double)mdd.getRise5())/(double)mdd.getCount());
				double downRatio5=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getDown10()+(double)mdd.getDown7()+(double)mdd.getDown5())/(double)mdd.getCount());			
				double flatRatio=1-riseRatio-downRatio;
				
				int rise_height=(int)(indicatorHeight*riseRatio);
				int down_height=(int)(indicatorHeight*downRatio);
				int rise5_height=(int)(indicatorHeight*riseRatio5);
				int down5_height=(int)(indicatorHeight*downRatio5);
				int flat_height=(int)(indicatorHeight*flatRatio);
				
				my_g.setColor(Color.green);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight, kz_width, down_height);
	
				my_g.setColor(Color.blue);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight, kz_width, down5_height);
				
				my_g.setColor(Color.white);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down_height, kz_width, flat_height);
				
				my_g.setColor(Color.red);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down_height+flat_height, kz_width, rise_height);
				
				my_g.setColor(Color.pink);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down_height+flat_height+rise_height-rise5_height, kz_width, rise5_height);
				
			}
			
		
			// ֻͳ���ǵ�5%���ϵļ�����
			if (mdd!=null  && indicatorPercent.equals("Compare5"))
			{
			
				double total_count=mdd.getRise10()+(double)mdd.getRise7()+(double)mdd.getRise5()+
								   mdd.getDown10()+(double)mdd.getDown7()+(double)mdd.getDown5();
						
				
				double riseRatio5=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10()+(double)mdd.getRise7()+(double)mdd.getRise5())/total_count);
				double downRatio5=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getDown10()+(double)mdd.getDown7()+(double)mdd.getDown5())/total_count);					
				
				int rise5_height=(int)(indicatorHeight*riseRatio5);
				int down5_height=(int)(indicatorHeight*downRatio5);
				
				my_g.setColor(Color.blue);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight, kz_width, down5_height);
								
				my_g.setColor(Color.red);
//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise5_height, kz_width, rise5_height);
				
			}
			else if (mdd!=null  && indicatorPercent.equals("Rise10"))
			{
				double total_count=100;
//				double total_count=mdd.getRise10()+mdd.getDown10();
				
				double riseRatio10=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10())/total_count);
				double downRatio10=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getDown10())/total_count);	
				double riseRatio10_open=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10_open())/total_count);
				double downRatio10_open=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getDown10_open())/total_count);	
				
				
				int rise10_height=(int)(indicatorHeight*riseRatio10);
				int down10_height=(int)(indicatorHeight*downRatio10);
				int rise10_height_open=(int)(indicatorHeight*riseRatio10_open);
				int down10_height_open=(int)(indicatorHeight*downRatio10_open);
				
//				my_g.setColor(Color.blue);
//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight, kz_width, down10_height);
				
				if (rise10_height>rise10_height_open)
				{
					// ������ͣ���ȿ�����ͣ���࣬�Ȼ����̵���ͣ����
					my_g.setColor(Color.red);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise10_height, kz_width, rise10_height);

					my_g.setColor(Color.blue);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise10_height_open, kz_width, rise10_height_open);
				}
				else
				{
					// ������ͣ���ȿ�����ͣ���٣��Ȼ����̵���ͣ����
					my_g.setColor(Color.blue);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise10_height_open, kz_width, rise10_height_open);
		
					my_g.setColor(Color.red);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise10_height, kz_width, rise10_height);
			
				}
				
				
				
			}
			else if (mdd!=null  && indicatorPercent.equals("Down10"))
			{
				double total_count=200;
//				double total_count=mdd.getRise10()+mdd.getDown10();
				
				double riseRatio10=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10())/total_count);
				double downRatio10=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getDown10())/total_count);	
				
				int rise10_height=(int)(indicatorHeight*riseRatio10);
				int down10_height=(int)(indicatorHeight*downRatio10);
				
//				my_g.setColor(Color.blue);
//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight, kz_width, down10_height);
				
				my_g.setColor(Color.blue);
//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-down10_height, kz_width, down10_height);
				
			}
			else if (mdd!=null  && indicatorPercent.equals("Rise5"))
			{
				
				double total_count=400;
//				double total_count=mdd.getRise10()+mdd.getDown10();
				
				double riseRatio5=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10()+mdd.getRise7()+mdd.getRise5())/total_count);
				double riseRatio5_open=CommonTool.getDoubleNumberWithTwoBit((double)(mdd.getRise10_open()+mdd.getRise7_open()+mdd.getRise5_open())/total_count);		
				
				int rise5_height=(int)(indicatorHeight*riseRatio5);
				int rise5_height_open=(int)(indicatorHeight*riseRatio5_open);
				
//				my_g.setColor(Color.blue);
//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight, kz_width, down10_height);
				
				if (rise5_height>rise5_height_open)
				{
					// ������ͣ���ȿ�����ͣ���࣬�Ȼ����̵���ͣ����
					my_g.setColor(Color.red);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise5_height, kz_width, rise5_height);

					my_g.setColor(Color.blue);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise5_height_open, kz_width, rise5_height_open);
				}
				else
				{
					// ������ͣ���ȿ�����ͣ���٣��Ȼ����̵���ͣ����
					my_g.setColor(Color.blue);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise5_height_open, kz_width, rise5_height_open);
		
					my_g.setColor(Color.red);
	//				my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+down5_height, kz_width, rise5_height);
					my_g.fillRect(x-kz_width/2, KLineHeight+amountHeight+indicatorHeight-rise5_height, kz_width, rise5_height);
			
				}
				
				
				
			}
			
			
		}
		
		
	
		
		
	}
	

	
	
	
	//����JPanel��paint����  
	    //Graphics �ǻ�ͼ����Ҫ�ࡣ����԰�������һֻ����  
	public void paint(Graphics g){  
	           
	    	   //1.���ø��ຯ����ɳ�ʼ������  
	           //��仰������  
	           super.paint(g);  
	           
	           my_g=(Graphics2D)g;
	           
	           drawAllKLineChart(stockDataRecordList, c_datePos, k_width, y_distance, d_height);
	            
	    }  
	    
	
	
	public StockKLineAllChartPanel(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StockKLineAllChartPanel(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public StockKLineAllChartPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
