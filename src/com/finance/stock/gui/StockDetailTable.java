package com.finance.stock.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints.Key;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

import com.finance.stock.data.StockDayAccount;
import com.finance.stock.data.StockDayData;
import com.finance.stock.data.StockFinanceIndicator;
import com.finance.stock.data.StockHoldData;
import com.finance.stock.data.StockSecondData;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StockDetailTable extends JPanel {

	
	Graphics2D my_g;
	boolean drawDot=false;
	
	int last_icon_x=0;
	int last_icon_y=0;
	int distance_x=200;
	int distance_y=70;
	
	int k_width=12;  // k������Ŀ�ȣ�һ��Ҫ��10���ϲ���
	int y_distance=1;
	int d_height=0;
	
	public String datasetFolder="";
	public String datasetFileName="";
	
	public StockTable stockTable;
	
  	public StockDetailTable(String datasetFolder, String datasetFileName) {
		
		this.datasetFolder=datasetFolder;
		this.datasetFileName=datasetFileName;
		
		setBackground(Color.white);
		
		setSize(1000, 800);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, BorderLayout.CENTER);
	
		stockTable = new StockTable();
		stockTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2 && (e.getModifiers() & e.BUTTON3_MASK) == 0)  // left click node 
				{
					
					int row=stockTable.getSelectedRow();
					String stockname=((String)stockTable.getValueAt(row, 1)).trim();
						
						openKChart_Stock();

				}
				
				
			}
		});
		
		
		stockTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				try
				{
					int keyCode=e.getKeyCode();
					
					if(keyCode==KeyEvent.VK_ENTER)
					{
						openKChart_Stock();
					}
				
					if (keyCode==KeyEvent.VK_0
					||	keyCode==KeyEvent.VK_1	
					||	keyCode==KeyEvent.VK_2
					||	keyCode==KeyEvent.VK_3
					||	keyCode==KeyEvent.VK_4
					||	keyCode==KeyEvent.VK_5
					||	keyCode==KeyEvent.VK_6
					||	keyCode==KeyEvent.VK_7
					||	keyCode==KeyEvent.VK_8
					||	keyCode==KeyEvent.VK_9
					)
					{
						
						if (StockComponent.skf==null)
						{
							StockKeyboardFrame skf=new StockKeyboardFrame();
							skf.setInitKeyText(keyCode);
							skf.setSize(300, 400);
			        		StockComponent.desktopPane.add(skf);
			        		int parent_x=StockComponent.sjif.getX();
			        		int parent_y=StockComponent.sjif.getY();
			        		int parent_width=StockComponent.sjif.getWidth();
			        		int parent_height=StockComponent.sjif.getHeight();
			        		skf.setLocation(parent_x+parent_width-skf.getWidth()-2, parent_y+parent_height-skf.getHeight()-2);
			        		skf.setVisible(true);
			    			skf.setSelected(true);
			    			skf.moveToFront();
			    			
			    			StockComponent.skf=skf;
						}
						else
						{
							StockComponent.skf.setInitKeyText(keyCode);
							StockComponent.skf.setVisible(true);
							StockComponent.skf.setSelected(true);
							StockComponent.skf.moveToFront();
							
						}
						
						
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
				
			}
			
			public void keyTyped(KeyEvent e) {
			
					
			}
			
			public void keyReleased(KeyEvent e) {
			
					
			}
			
			
		});
		scrollPane.setViewportView(stockTable);
	
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(stockTable, popupMenu);
		
		JMenu mnOpenKChartMenu = new JMenu("Open K Chart");
		popupMenu.add(mnOpenKChartMenu);
		
		JMenu mntmStock = new JMenu("Stock");
		mntmStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Stock();
				
			}
		});
		mnOpenKChartMenu.add(mntmStock);
		
		JMenuItem mntmDay = new JMenuItem("Day");
		mntmDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Stock();
				
			}
		});
		mntmStock.add(mntmDay);
		
		JMenuItem mntmMinute1 = new JMenuItem("Minute1");
		mntmMinute1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Minute(1);
				
			}
		});
		mntmStock.add(mntmMinute1);
		
		JMenuItem mntmMinute5 = new JMenuItem("Minute5");
		mntmMinute5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Minute(5);
				
			}
		});
		mntmStock.add(mntmMinute5);
		
		JMenuItem mntmMinute15 = new JMenuItem("Minute15");
		mntmMinute15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Minute(15);
				
			}
		});
		mntmStock.add(mntmMinute15);
		
		JMenuItem mntmMinute30 = new JMenuItem("Minute30");
		mntmMinute30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Minute(30);
				
			}
		});
		mntmStock.add(mntmMinute30);
		
		JMenuItem mntmMinute60 = new JMenuItem("Minute60");
		mntmMinute60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Minute(60);
				
			}
		});
		mntmStock.add(mntmMinute60);
		
		
		JMenuItem mntmIndex = new JMenuItem("Index");
		mntmIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Index();
				
			}
		});
		mnOpenKChartMenu.add(mntmIndex);
		
		JMenuItem mntmProfit = new JMenuItem("Profit");
		mntmProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Profit();
				
			}
		});
		mnOpenKChartMenu.add(mntmProfit);
		
		JMenuItem mntmValue = new JMenuItem("Value");
		mntmValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_Value();
				
			}
		});
		mnOpenKChartMenu.add(mntmValue);
		
		JMenuItem mntmRate = new JMenuItem("Rate(FL)");	  // ����
		mntmRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_RateFL(1);
				
			}
		});
		mnOpenKChartMenu.add(mntmRate);

		JMenuItem mntmRate1 = new JMenuItem("Rate(DBJ)");  // �ȱ���
		mntmRate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_RateDBJ();
				
			}
		});
		mnOpenKChartMenu.add(mntmRate1);
		
		JMenuItem mntmAIBot = new JMenuItem("AIQuantBot");	  // AIQuantBot ģ����ʵ���룬��׼����ÿ���ʲ���ֵ
		mntmAIBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				openKChart_AIQuantBot();
				
			}
		});
		mnOpenKChartMenu.add(mntmAIBot);

		
		JMenu mntmSort = new JMenu("Sort By");
		
		JMenuItem mntmAsc = new JMenuItem("Ascending");
		mntmAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectColumnNo=stockTable.getSelectedColumn();
				String columnName=stockTable.getColumnName(selectColumnNo);
				String conditionStr=" 1>0 order by "+columnName+" asc";
				
				initDatasetTableWithCondition(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, conditionStr);
			
			}
		});
		mntmSort.add(mntmAsc);
		
		JMenuItem mntmDesc = new JMenuItem("Descending");
		mntmDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectColumnNo=stockTable.getSelectedColumn();
				String columnName=stockTable.getColumnName(selectColumnNo);
				String conditionStr=" 1>0 order by "+columnName+" desc";
				
				initDatasetTableWithCondition(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, conditionStr);
			
				
			}
		});
		mntmSort.add(mntmDesc);
		popupMenu.add(mntmSort);
		
		
		JMenu mntmColor = new JMenu("Color");
		
		JMenuItem mntmRed = new JMenuItem("Red");
		mntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectColumnNo=stockTable.getSelectedColumn();
				String columnName=stockTable.getColumnName(selectColumnNo);
				
				StockTableCellRender stcr=(StockTableCellRender)stockTable.getDefaultRenderer(Object.class);
				stcr.columnColorMap.put(selectColumnNo, Color.red);
				stockTable.setDefaultRenderer(Object.class, stcr);
				
				String condition=StockKey.conditionString;
				initDatasetTableWithCondition(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, condition);
			
			}
		});
		mntmColor.add(mntmRed);
		
		JMenuItem mntmBlue = new JMenuItem("Blue");
		mntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectColumnNo=stockTable.getSelectedColumn();
				String columnName=stockTable.getColumnName(selectColumnNo);
				
				StockTableCellRender stcr=(StockTableCellRender)stockTable.getDefaultRenderer(Object.class);
				stcr.columnColorMap.put(selectColumnNo, Color.blue);
				stockTable.setDefaultRenderer(Object.class, stcr);
				
				String condition=StockKey.conditionString;
				initDatasetTableWithCondition(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, condition);
			
			}
		});
		mntmColor.add(mntmBlue);
		
		JMenuItem mntmOrange = new JMenuItem("Orange");
		mntmOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectColumnNo=stockTable.getSelectedColumn();
				String columnName=stockTable.getColumnName(selectColumnNo);
				
				StockTableCellRender stcr=(StockTableCellRender)stockTable.getDefaultRenderer(Object.class);
				stcr.columnColorMap.put(selectColumnNo, Color.orange);
				stockTable.setDefaultRenderer(Object.class, stcr);
				
				String condition=StockKey.conditionString;
				initDatasetTableWithCondition(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, condition);
			
			}
		});
		mntmColor.add(mntmOrange);
		
		popupMenu.add(mntmColor);
		
		
		JMenu mntmFund = new JMenu("Fund");
		
		JMenuItem mntmMoneyOrder = new JMenuItem("Money Order");
		mntmMoneyOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sqlString="select stockname, count(stockname) as count, sum(fund_2020q4.stockmoney)/10000 as money from stocklib.fund_2020q4 group by stockname order by money desc";
					
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);

			}
		});
		mntmFund.add(mntmMoneyOrder);
		
		JMenuItem mntmCountOrder = new JMenuItem("Count Order");
		mntmCountOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sqlString="select  stockname, count(stockname) as count, sum(fund_2020q4.stockmoney)/10000 as money from stocklib.fund_2020q4 group by stockname order by count desc, money desc";
				
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
			
			}
		});
		mntmFund.add(mntmCountOrder);
		
		JMenuItem mntmCompanyOrder = new JMenuItem("Company Order");
		mntmCompanyOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sqlString="select fundcompany, stockname, count(stockname) as count, sum(fund_2020q4.stockmoney)/10000 as money from stocklib.fund_2020q4 group by fundcompany, stockname order by fundcompany, money desc";
				
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
			
			}
		});
		mntmFund.add(mntmCompanyOrder);
		
		JMenuItem mntmStockHold = new JMenuItem("Stock Hold");
		mntmStockHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectRowNo=stockTable.getSelectedRow();
				int selectColumnNo=stockTable.getSelectedColumn();
				String stockname=stockTable.getValueAt(selectRowNo, selectColumnNo).toString();
						
				String sqlString="select * from stocklib.fund_2020q4 where stockname=\'"+stockname+"\'";
				
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
			
			}
		});
		mntmFund.add(mntmStockHold);
		
		JMenuItem mntmFundHold = new JMenuItem("Fund Hold");
		mntmFundHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectRowNo=stockTable.getSelectedRow();
				int selectColumnNo=stockTable.getSelectedColumn();
				String fundname=stockTable.getValueAt(selectRowNo, selectColumnNo).toString();
						
				String sqlString="select * from stocklib.fund_2020q4 where fundname=\'"+fundname+"\'";
				
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
			
			}
		});
		mntmFund.add(mntmFundHold);
		
		popupMenu.add(mntmFund);
		
		
		JMenuItem mntmViewFI = new JMenuItem("Check PE");
		mntmViewFI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int row=stockTable.getSelectedRow();
				int col1=((DefaultTableModel)stockTable.getModel()).findColumn("stockcode");
				int col2=((DefaultTableModel)stockTable.getModel()).findColumn("date_c");
				String stockcode=stockTable.getValueAt(row, col1).toString();
				String startDate=stockTable.getValueAt(row, col2).toString();
				String stockfilename="stock"+stockcode;
				String stockFileFolder=StockKey.stockAllFolderPath;
//				String monitorStartDate="2000/01/01";	  // A����ʼ����
				String monitorStartDate=CommonTool.getStockTransDate(startDate, -1000);	
				String monitorEndDate=CommonTool.getStockTransDate(startDate, -1);	
				String condition3=" date>=\""+monitorStartDate+"\" and date<=\""+monitorEndDate+"\"";  // sql �����б�����˫���Ž�string����������
				List researchStockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition3);
				StockFinanceIndicator sfi=CommonTool.calculateStockFinanceIndicator(researchStockDataList);
				
				StockViewDataDialog svdd=new StockViewDataDialog(sfi.peChangeHistory+"\n"+sfi.earnChangeHistory);

				CommonTool.setLocationInScreenCenter(svdd);
				svdd.setModal(true);
				svdd.setVisible(true);
				
				
			}
		});
		popupMenu.add(mntmViewFI);
		
		
		JMenuItem mntmFilter = new JMenuItem("Filter Data");
		mntmFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StockFilterConditionDialog sfcd;
				if (StockComponent.sfcd==null)
				{
					sfcd=new StockFilterConditionDialog();
					StockComponent.sfcd=sfcd;
					CommonTool.setLocationInScreenCenter(sfcd);
				}
				else
				{
					sfcd=StockComponent.sfcd;
				}
				
				CommonTool.setLocationInScreenCenter(sfcd);
				sfcd.setModal(true);
				sfcd.setVisible(true);
				
				String conditionStr=StockKey.conditionString;
				initDatasetTableWithCondition(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, conditionStr);
				sfcd.setVisible(false);
				
			}
		});
		popupMenu.add(mntmFilter);
		
		
		
//		JMenuItem mntmFenbi = new JMenuItem("Fenbi Data");
//		mntmFenbi.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//				
//				
//			}
//		});
//		popupMenu.add(mntmFenbi);
		
		
		JMenuItem mntmView = new JMenuItem("View Data");
		mntmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int row=stockTable.getSelectedRow();
				int col=stockTable.getSelectedColumn();
				String text=stockTable.getValueAt(row, col).toString();
				StockViewDataDialog svdd=new StockViewDataDialog(text);

				CommonTool.setLocationInScreenCenter(svdd);
				svdd.setModal(true);
				svdd.setVisible(true);
				
				
			}
		});
		popupMenu.add(mntmView);
		
		
		JMenuItem mntmRecover = new JMenuItem("Recover");
		mntmRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sqlString="select * from stocklib."+CommonTool.getFileName(StockDetailTable.this.datasetFileName);
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
				
				
			}
		});
		popupMenu.add(mntmRecover);
		
		JMenuItem mntmSummarizeStockYear = new JMenuItem("Summarize by Stock_Year");
		mntmSummarizeStockYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				String sqlString="select a.stockcode, a.stockname, a.year, a.year'/01/01' as date, count(*) as count, sum(a.profit) as profit " +
						"from stocklib."+CommonTool.getFileName(StockDetailTable.this.datasetFileName)+" a"+
						" group by a.stockcode, a.stockname, a.year order by a.stockcode";
				System.out.println(sqlString);
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
				
				
			}
		});
		popupMenu.add(mntmSummarizeStockYear);
		
		
		JMenuItem mntmSummarizeYearStock = new JMenuItem("Summarize by Year_Stock");
		mntmSummarizeYearStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				String sqlString="select a.stockcode, a.stockname, a.year, a.year'/01/01' as date, count(*) as count, sum(a.profit) as profit " +
						"from stocklib."+CommonTool.getFileName(StockDetailTable.this.datasetFileName)+" a"+
						" group by a.stockcode, a.stockname, a.year order by a.year";
				System.out.println(sqlString);
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
				
				
			}
		});
		popupMenu.add(mntmSummarizeYearStock);
		
		JMenuItem mntmSummarizeYear = new JMenuItem("Summarize by Year");
		mntmSummarizeYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
								
				String sqlString="select a.year, count(*) as count, sum(a.profit) as profit " +
						"from stocklib."+CommonTool.getFileName(StockDetailTable.this.datasetFileName)+" a"+
						" group by a.year";
				System.out.println(sqlString);
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
				
				
			}
		});
		popupMenu.add(mntmSummarizeYear);
		
		
		
		JSeparator js=new JSeparator();
		popupMenu.add(js);
		
		JMenuItem mntmExecuteSql = new JMenuItem("Execute SQL");
		mntmExecuteSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				StockExecuteSqlDialog sesd;
				if (StockComponent.sesd==null)
				{
					sesd=new StockExecuteSqlDialog();
					sesd.sqlStrTextArea.setText("select * from stocklib."+CommonTool.getFileName(StockDetailTable.this.datasetFileName)+" ");
					StockComponent.sesd=sesd;
					CommonTool.setLocationInScreenCenter(sesd);
				}
				else
				{
					sesd=StockComponent.sesd;
				}
				sesd.tableNameTextFiled.setText(CommonTool.getFileName(StockDetailTable.this.datasetFileName));
				
				CommonTool.setLocationInScreenCenter(sesd);
				sesd.setModal(true);
				sesd.setVisible(true);
				
				String sqlString=StockKey.sqlString;
				initDatasetTableWithSQLStr(StockDetailTable.this.datasetFolder, StockDetailTable.this.datasetFileName, sqlString);
				sesd.setVisible(false);
				
			}
		});
		popupMenu.add(mntmExecuteSql);
		
		
		StockTableCellRender stcr=new StockTableCellRender();
		stockTable.setDefaultRenderer(Object.class, stcr);
		
		initDatasetTable(datasetFolder, datasetFileName);
		
		
		
	}

	
	
	public void initDatasetTable(String datasetFolderPath, String datasetFileName)
	{
		
		ResultSet rs=null;
		
		try
		{
			datasetFileName=CommonTool.getFileName(datasetFileName);
			
			// read data from dataset
			rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, datasetFileName);
			
			 int columnCount = rs.getMetaData().getColumnCount();
		 		
			 DefaultTableModel dtm=new DefaultTableModel();
			 
			 for (int i = 1; i <= columnCount; i++) {
//				 System.out.println(rs.getMetaData().getColumnName(i));
				 String columnName=rs.getMetaData().getColumnName(i);
//				 System.out.println(columnName+": "+rs.getMetaData().getColumnType(i)+" "+rs.getMetaData().getColumnTypeName(i));
				 dtm.addColumn(columnName);
			 }
			 
			 stockTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			 stockTable.setRowHeight(27);
			 stockTable.setModel(dtm);
			 
			 
			 while (rs.next()) {
			 
				 Vector data=new Vector();
				 String stockcode="";
				  for (int i = 1; i <= columnCount; i++) {
					  
					  String datastr=rs.getString(i);
					  
					  if(datastr!=null)
					  {
						  datastr=CommonTool.formatNumberStrWithTwoBit(rs.getString(i).trim());
						  
						  if(i==1)
						  {
							  stockcode=datastr;  // ��¼��һ�е�stockcodeֵ
						  }
						  
						  if (i==2 && (datastr.contains("null")||datastr.trim().equals("")))  // �ڶ���stockname���Ϊ��,����ݵ�һ�е�stockcode����ת�����stockname
						  {
							  datastr=CommonTool.getStockNameByCode(stockcode);
						  }
					  }
					 
					  data.add(datastr);
					  
//					  System.out.print(rs.getString(i));
				  }		 
				  dtm.addRow(data);
//				  System.out.println("");
			 }
			 
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		CommonTool.autoFitTableColumns(stockTable);
		
		
	}

	
	public void initDatasetTableWithCondition(String datasetFolderPath, String datasetFileName, String condition)
	{
		
		ResultSet rs=null;
		try
		{
			datasetFileName=CommonTool.getFileName(datasetFileName);
			
			// read data from dataset
			rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, datasetFileName, condition);
			
			 int columnCount = rs.getMetaData().getColumnCount();
		 		
			 DefaultTableModel dtm=new DefaultTableModel();
			 
			 for (int i = 1; i <= columnCount; i++) {
//				 System.out.println(rs.getMetaData().getColumnName(i));
				 String columnName=rs.getMetaData().getColumnName(i);
//				 System.out.println(columnName+": "+rs.getMetaData().getColumnType(i)+" "+rs.getMetaData().getColumnTypeName(i));
				 dtm.addColumn(columnName);
			 }
			 
			 stockTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			 stockTable.setRowHeight(27);
			 stockTable.setModel(dtm);
			 
			 
			 while (rs.next()) {
			 
				 Vector data=new Vector();
				  for (int i = 1; i <= columnCount; i++) {
					  
					  String datastr=rs.getString(i);
					  if(datastr!=null)
					  {
						  datastr=CommonTool.formatNumberStrWithTwoBit(rs.getString(i).trim());
					  }
					  data.add(datastr);
					  
//					  System.out.print(rs.getString(i));
				  }		 
				  dtm.addRow(data);
//				  System.out.println("");
			 }
			 
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		CommonTool.autoFitTableColumns(stockTable);
		
		
	}
	
	
	public void initDatasetTableWithSQLStr(String datasetFolderPath, String datasetFileName, String sqlStr)
	{
		
		ResultSet rs=null;
		try
		{
			datasetFileName=CommonTool.getFileName(datasetFileName);
			
			// read data from dataset
			rs=CommonTool.executeSQLforSASDataSet(datasetFolderPath, datasetFileName, sqlStr);
			
			 int columnCount = rs.getMetaData().getColumnCount();
		 		
			 DefaultTableModel dtm=new DefaultTableModel();
			 
			 for (int i = 1; i <= columnCount; i++) {
//				 System.out.println(rs.getMetaData().getColumnName(i));
				 String columnName=rs.getMetaData().getColumnName(i);
//				 System.out.println(columnName+": "+rs.getMetaData().getColumnType(i)+" "+rs.getMetaData().getColumnTypeName(i));
				 dtm.addColumn(columnName);
			 }
			 
			 stockTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			 stockTable.setRowHeight(27);
			 stockTable.setModel(dtm);
			 
			 
			 while (rs.next()) {
			 
				 Vector data=new Vector();
				  for (int i = 1; i <= columnCount; i++) {
					  
					  String datastr=rs.getString(i);
					  
					  if(datastr!=null && datastr.contains("."))
					  {
						  datastr=CommonTool.formatNumberStrWithTwoBit(rs.getString(i).trim());
					  }
					  data.add(datastr);
					  
//					  System.out.print(rs.getString(i));
				  }		 
				  dtm.addRow(data);
//				  System.out.println("");
			 }
			 
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		CommonTool.autoFitTableColumns(stockTable);
		
		
	}
	
	
	
	public void openKChart_Stock()
	{
		
		int row=stockTable.getSelectedRow();
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		String filePreStr="stock";
		int codecol=CommonTool.findPossibleCodeColumn(dtm);
		int datecol=CommonTool.findPossibleDateColumn(dtm);
		int namecol=dtm.findColumn("stockname");
		
//		if (codecol==0)  // stock=-1  index=0  
//		{
//			filePreStr="index";
//		}
		
		try
		{
			String code=((String)stockTable.getValueAt(row, codecol)).trim();
			String name=((String)stockTable.getValueAt(row, namecol)).trim();
			String date=((String)stockTable.getValueAt(row, datecol)).trim();
			
			
			
			if (name.contains("����"))
			{
				openKChart_Day();
				return;
			}
			
			if (code.startsWith("5")||code.startsWith("1")||code.startsWith("8"))  // ��ETF���ָ�����л���index��ʽ��
			{
				openKChart_Index();
				return;
			}

			
			
			if (code.length()==8)  // ����� sh600007����8λ��ʽ����ȥ��ǰ׺
			{
				code=code.substring(2);   // stockcode
			}
			
			if (code.length()==11)
			{
				code=code.substring(5);   // indexcode
			}
			
			if (date.contains("-"))
			{
				date=date.replace("-", "/");
			}
			
			String datasetFolderPath=StockKey.stockAllFolderPath;
			String stockfilename=filePreStr+code;
			List stockDataRecordList=CommonTool.getStockDataRecordList(datasetFolderPath, stockfilename);
			
			
			// �����������ҳ����д�stockcode�Ľ��׼�¼���������롢������ע
			int stockcodecol=dtm.findColumn("stockcode");
			int buydatecol=dtm.findColumn("date_c");
			int saledatecol=dtm.findColumn("saledate");
			if (buydatecol!=-1 && saledatecol!=-1)    // ȷ���ǽ��׼�¼�������ǹ�Ʊ������н��׼�¼��ǲ���
			{
				for (int i=0; i<dtm.getRowCount(); i++)
				{
					String stockcode=dtm.getValueAt(i, stockcodecol).toString();
					if (stockcode.equals(code))
					{
	
						if (buydatecol!=0)  
						{
							Object buyDateValue=stockTable.getValueAt(i, buydatecol);
							if (buyDateValue!=null)
							{
								String buydate=((String)buyDateValue).trim();
								CommonTool.markSDD_Buy(stockDataRecordList, buydate);
							}
						}
						
						if (saledatecol!=0)  
						{
							Object saleDateValue=stockTable.getValueAt(i, saledatecol);
							if (saleDateValue!=null)
							{
								String saledate=((String)saleDateValue).trim();
								CommonTool.markSDD_Sale(stockDataRecordList, saledate);
							}
						}
						
					}
					
				}

			}
				
			// ����Stock K��ͼ���ڽ��л���
			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, date, k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
    		sklc.setSize(desktopWidth-80, desktopHeight-80);
    		
    		StockComponent.desktopPane.add(sklc);
//    		CommonTool.setLocationInScreenCenter(sklc);
    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
    		sklc.setTitle(filePreStr+": "+code+" "+sdd.getName());
    		sklc.setLocation(40, 40);
    		sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		
	}
	
	public void openKChart_Index()
	{
		
		int row=stockTable.getSelectedRow();
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		String filePreStr="index";
		int codecol=CommonTool.findPossibleCodeColumn(dtm);
		int datecol=CommonTool.findPossibleDateColumn(dtm);;

		try
		{
			String code=((String)stockTable.getValueAt(row, codecol)).trim();
			String date=((String)stockTable.getValueAt(row, datecol)).trim();
			
			String datasetFolderPath=StockKey.stockAllFolderPath;
			String stockfilename=filePreStr+code;
			List stockDataRecordList=CommonTool.getStockDataRecordList(datasetFolderPath, stockfilename);
			
			
			// �����������ҳ����д�stockcode�Ľ��׼�¼���������롢������ע
			int stockcodecol=dtm.findColumn("stockcode");
			int buydatecol=dtm.findColumn("date_c");
			int saledatecol=dtm.findColumn("saledate");
			if (buydatecol!=-1 && saledatecol!=-1)    // ȷ���ǽ��׼�¼�������ǹ�Ʊ������н��׼�¼��ǲ���
			{
				for (int i=0; i<dtm.getRowCount(); i++)
				{
					String stockcode=dtm.getValueAt(i, stockcodecol).toString();
					if (stockcode.equals(code))
					{
	
						if (buydatecol!=0)  
						{
							Object buyDateValue=stockTable.getValueAt(i, buydatecol);
							if (buyDateValue!=null)
							{
								String buydate=((String)buyDateValue).trim();
								CommonTool.markSDD_Buy(stockDataRecordList, buydate);
							}
						}
						
						if (saledatecol!=0)  
						{
							Object saleDateValue=stockTable.getValueAt(i, saledatecol);
							if (saleDateValue!=null)
							{
								String saledate=((String)saleDateValue).trim();
								CommonTool.markSDD_Sale(stockDataRecordList, saledate);
							}
						}
						
					}
					
				}
			}
			
			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, date, k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
    		sklc.setSize(desktopWidth-80, desktopHeight-80);
    		
    		StockComponent.desktopPane.add(sklc);
//    		CommonTool.setLocationInScreenCenter(sklc);
    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
    		sklc.setTitle(filePreStr+": "+code+" "+sdd.getName());
    		sklc.setLocation(40, 40);
    		sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public void openKChart_Minute(int minute)
	{
		
		int row=stockTable.getSelectedRow();
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		String filePreStr="minute";
		int codecol=CommonTool.findPossibleCodeColumn(dtm);
		int datecol=CommonTool.findPossibleDateColumn(dtm);;

		try
		{
			String code=((String)stockTable.getValueAt(row, codecol)).trim();
			String date=((String)stockTable.getValueAt(row, datecol)).trim();
			
			String datasetFolderPath=StockKey.stockFullFolderPath+"\\tdx\\minute"+minute;
			String stockfilename=filePreStr+code;
			List stockDataRecordList=CommonTool.getStockDataRecordList(datasetFolderPath, stockfilename);
			
			
			// �����������ҳ����д�stockcode�Ľ��׼�¼���������롢������ע
			int stockcodecol=dtm.findColumn("stockcode");
			int buydatecol=dtm.findColumn("date_c");
			int saledatecol=dtm.findColumn("saledate");
			if (buydatecol!=-1 && saledatecol!=-1)    // ȷ���ǽ��׼�¼�������ǹ�Ʊ������н��׼�¼��ǲ���
			{
				for (int i=0; i<dtm.getRowCount(); i++)
				{
					String stockcode=dtm.getValueAt(i, stockcodecol).toString();
					if (stockcode.equals(code))
					{
	
						if (buydatecol!=0)  
						{
							Object buyDateValue=stockTable.getValueAt(i, buydatecol);
							if (buyDateValue!=null)
							{
								String buydate=((String)buyDateValue).trim();
								CommonTool.markSDD_Buy(stockDataRecordList, buydate);
							}
						}
						
						if (saledatecol!=0)  
						{
							Object saleDateValue=stockTable.getValueAt(i, saledatecol);
							if (saleDateValue!=null)
							{
								String saledate=((String)saleDateValue).trim();
								CommonTool.markSDD_Sale(stockDataRecordList, saledate);
							}
						}
						
					}
					
				}
			}
			
			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, date, k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
    		sklc.setSize(desktopWidth-80, desktopHeight-80);
    		
    		StockComponent.desktopPane.add(sklc);
//    		CommonTool.setLocationInScreenCenter(sklc);
    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
    		sklc.setTitle(filePreStr+": "+code+" "+sdd.getName());
    		sklc.setLocation(40, 40);
    		sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public void openKChart_Day()
	{
		
		int row=stockTable.getSelectedRow();
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		String filePreStr="day";
		int codecol=CommonTool.findPossibleCodeColumn(dtm);
		int datecol=CommonTool.findPossibleDateColumn(dtm);;

		try
		{
			String code=((String)stockTable.getValueAt(row, codecol)).trim();
			String date=((String)stockTable.getValueAt(row, datecol)).trim();
			
			String datasetFolderPath=StockKey.stockFullFolderPath+"\\tdx\\day";
			String stockfilename=filePreStr+code;
			List stockDataRecordList=CommonTool.getStockDataRecordList(datasetFolderPath, stockfilename);
			
			
			// �����������ҳ����д�stockcode�Ľ��׼�¼���������롢������ע
			int stockcodecol=dtm.findColumn("stockcode");
			int buydatecol=dtm.findColumn("date_c");
			int saledatecol=dtm.findColumn("saledate");
			if (buydatecol!=-1 && saledatecol!=-1)    // ȷ���ǽ��׼�¼�������ǹ�Ʊ������н��׼�¼��ǲ���
			{
				for (int i=0; i<dtm.getRowCount(); i++)
				{
					String stockcode=dtm.getValueAt(i, stockcodecol).toString();
					if (stockcode.equals(code))
					{
	
						if (buydatecol!=0)  
						{
							Object buyDateValue=stockTable.getValueAt(i, buydatecol);
							if (buyDateValue!=null)
							{
								String buydate=((String)buyDateValue).trim();
								CommonTool.markSDD_Buy(stockDataRecordList, buydate);
							}
						}
						
						if (saledatecol!=0)  
						{
							Object saleDateValue=stockTable.getValueAt(i, saledatecol);
							if (saleDateValue!=null)
							{
								String saledate=((String)saleDateValue).trim();
								CommonTool.markSDD_Sale(stockDataRecordList, saledate);
							}
						}
						
					}
					
				}
			}
			
			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, date, k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
    		sklc.setSize(desktopWidth-80, desktopHeight-80);
    		
    		StockComponent.desktopPane.add(sklc);
//    		CommonTool.setLocationInScreenCenter(sklc);
    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
    		sklc.setTitle(filePreStr+": "+code+" "+sdd.getName());
    		sklc.setLocation(40, 40);
    		sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void openKChart_Profit()
	{
		
		int row=stockTable.getSelectedRow();
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		String filePreStr="index";
		int codecol=dtm.findColumn("code_i");
		int datecol=dtm.findColumn("date");

		
		try
		{
			String code=((String)stockTable.getValueAt(row, codecol)).trim();
			String date=((String)stockTable.getValueAt(row, datecol)).trim();
			
			String datasetFolderPath=StockKey.stockFullFolderPath+"\\totalresult\\total(3���Ǵ���15��ǰ������_9.29)\\detailday";
			String stockfilename="indexstockextotalprofitday";
			List stockDataRecordList=CommonTool.getStockDataRecordListWithProfit(datasetFolderPath, stockfilename, "average_fr_a1");
			

			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, date, k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
    		sklc.setSize(desktopWidth-80, desktopHeight-80);
    		
    		StockComponent.desktopPane.add(sklc);
//    		CommonTool.setLocationInScreenCenter(sklc);
    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
    		sklc.setTitle(filePreStr+": "+code+" "+sdd.getName());
    		sklc.setLocation(40, 40);
    		sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public void openKChart_Value()
	{
		
		int row=stockTable.getSelectedRow();
		int column=stockTable.getSelectedColumn();
		String columnName=stockTable.getColumnName(column);
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		try
		{
			
				Map valueMap=new TreeMap();
				int rowCount=dtm.getRowCount();
				String lastDate="2017/10/01";
				for (int i=0; i<rowCount; i++)
				{
								
					String value=((String)stockTable.getValueAt(i, column)).trim();
					int datecol=dtm.findColumn("date");
					if (datecol==-1)
					{
						datecol=dtm.findColumn("date_c");
					}
					String date=((String)stockTable.getValueAt(i, datecol)).trim();
				
					valueMap.put(date, value);
					lastDate=date;
					
				}
				
				List stockDataRecordList=generateStockDataRecordListFL(valueMap, columnName);
				
				StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, lastDate, k_width, y_distance, d_height);
				int desktopWidth=StockComponent.desktopPane.getWidth();
				int desktopHeight=StockComponent.desktopPane.getHeight();
	    		sklc.setSize(desktopWidth-80, desktopHeight-80);
	    		
	    		StockComponent.desktopPane.add(sklc);
	//    		CommonTool.setLocationInScreenCenter(sklc);
	    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
	    		sklc.setTitle(columnName);
	    		sklc.setLocation(40, 40);
	    		sklc.setVisible(true);
				sklc.setSelected(true);
				sklc.moveToFront();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	}
	
	// ��������
	public void openKChart_RateFL(double value)  // value ����ʼ��׼ֵ
	{

		int row=stockTable.getSelectedRow();
		int column=stockTable.getSelectedColumn();
		String columnName=stockTable.getColumnName(column);
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		int rows[]=stockTable.getSelectedRows();
		if (rows.length==1)
		{
			rows=new int[stockTable.getRowCount()];
			for (int s=0; s<stockTable.getRowCount(); s++)
			{
				rows[s]=s;
			}
		}
		
		try
		{
			
				Map valueMap=new TreeMap();
				int rowCount=dtm.getRowCount();
				String lastDate="";
				for (int i=0; i<rows.length; i++)
				{
								
					if (stockTable.getValueAt(rows[i], column)==null)  // ȥ����ֵ
						continue;
					
					double dayRate=CommonTool.converToDoubleNumber(((String)stockTable.getValueAt(rows[i], column)).trim());

					value=value*(1+dayRate/100); // �������׼������棬ÿ�ζ����ϴν������ȫ���ʽ�������

//					value=value+1*dayRate/100;  // �ȱ����׼������棬ÿ�ζ��ù̶��ĳ�ʼ����1������

					System.out.println(value);
					
					int datecol=CommonTool.findPossibleDateColumn(dtm);
					
					String date=((String)stockTable.getValueAt(rows[i], datecol)).trim();
				
					valueMap.put(date, value+"");   // Map(���ڣ����̼�)
					lastDate=date;
					
				}
				
				// ���ݹ�ָ���ڣ������޽��׵�����
//				List indexDataList=CommonTool.getIndexDataList("600");
//				valueMap=mendValueByIndexDate(valueMap, indexDataList);
				
				List stockDataRecordList=generateStockDataRecordListFL(valueMap, columnName);
				
				StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, lastDate, k_width, y_distance, d_height);
				int desktopWidth=StockComponent.desktopPane.getWidth();
				int desktopHeight=StockComponent.desktopPane.getHeight();
	    		sklc.setSize(desktopWidth-80, desktopHeight-80);
	    		
	    		StockComponent.desktopPane.add(sklc);
	//    		CommonTool.setLocationInScreenCenter(sklc);
	    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
	    		sklc.setTitle(columnName);
	    		sklc.setLocation(40, 40);
	    		sklc.setVisible(true);
				sklc.setSelected(true);
				sklc.moveToFront();
				
			}
			catch(Exception e)
			{
//				e.printStackTrace();
			}		
		
		

	}
	
	
	public Map mendValueByIndexDate(Map valueMap, List indexDataList)
	{
		
		Map newValueMap=new TreeMap();
		String lastValue="1";
		
		Iterator it=valueMap.keySet().iterator();
		String startDate=it.next().toString();
		
		for (int i=0; i<indexDataList.size(); i++)
		{
			
			StockDayData idd=(StockDayData)indexDataList.get(i);
			String date=idd.getDate();
			
			Object obj=valueMap.get(date);
			if (obj!=null)
			{
				lastValue=obj.toString();
				newValueMap.put(date, lastValue);
			}
			else
			{
				if (date.compareTo(startDate)>0)
					newValueMap.put(date, lastValue);
			}
			
		}
		
		return newValueMap;
		
	}
	
	
	// �ȱ������
	public void openKChart_RateDBJ()
	{

		int row=stockTable.getSelectedRow();
		int column=stockTable.getSelectedColumn();
		String columnName=stockTable.getColumnName(column);
		
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		int rows[]=stockTable.getSelectedRows();
		if (rows.length==1)
		{
			rows=new int[stockTable.getRowCount()];
			for (int s=0; s<stockTable.getRowCount(); s++)
			{
				rows[s]=s;
			}
		}
		
		try
		{
			
				Map valueMap=new TreeMap();
				int rowCount=dtm.getRowCount();
				String lastDate="";
				double benjin=1;
				double value=1;
				for (int i=0; i<rows.length; i++)
				{
								
					if (stockTable.getValueAt(rows[i], column)==null)  // ȥ����ֵ
						continue;
					
					double dayRate=CommonTool.converToDoubleNumber(((String)stockTable.getValueAt(rows[i], column)).trim());

//					value=value*(1+dayRate/100); // �������׼������棬ÿ�ζ����ϴν������ȫ���ʽ�������

					value=value+benjin*dayRate/100;  // �ȱ����׼������棬ÿ�ζ��ù̶��ĳ�ʼ����1������

					System.out.println(value);
					
					int datecol=dtm.findColumn("date");
					if (datecol==-1)
					{
						datecol=dtm.findColumn("date_c");
					}
					String date=((String)stockTable.getValueAt(rows[i], datecol)).trim();
				
					valueMap.put(date, value+"");   // Map(���ڣ����̼�)
					lastDate=date;
					
				}
				
				List stockDataRecordList=generateStockDataRecordListDBJ(valueMap, columnName, benjin);
				
				StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, lastDate, k_width, y_distance, d_height);
				int desktopWidth=StockComponent.desktopPane.getWidth();
				int desktopHeight=StockComponent.desktopPane.getHeight();
	    		sklc.setSize(desktopWidth-80, desktopHeight-80);
	    		
	    		StockComponent.desktopPane.add(sklc);
	//    		CommonTool.setLocationInScreenCenter(sklc);
	    		StockDayData sdd=(StockDayData)stockDataRecordList.get(0);
	    		sklc.setTitle(columnName);
	    		sklc.setLocation(40, 40);
	    		sklc.setVisible(true);
				sklc.setSelected(true);
				sklc.moveToFront();
				
			}
			catch(Exception e)
			{
//				e.printStackTrace();
			}		
		
		

	}
	
	// ����ģ����ʵ����
	public void openKChart_AIQuantBot()
	{
		
		// ȡ������Transaction Record Data����trd List���ں���Ӧ�յ�buySdd, saleSdd����	
		DefaultTableModel dtm=(DefaultTableModel)stockTable.getModel();
		
		int rows[]=stockTable.getSelectedRows();
		if (rows.length==1)
		{
			rows=new int[stockTable.getRowCount()];
			for (int s=0; s<stockTable.getRowCount(); s++)
			{
				rows[s]=s;
			}
		}
		
		List transactionList=new ArrayList();
		try
		{
			
				int col_stockcode=dtm.findColumn("stockcode");
				int col_buyDate=dtm.findColumn("date_c");
				int col_saleDate=dtm.findColumn("saledate");
				
				Map valueMap=new TreeMap();
				int rowCount=dtm.getRowCount();
				for (int i=0; i<rows.length; i++)
				{
					
					String stockcode=((String)stockTable.getValueAt(rows[i], col_stockcode)).trim();
					String buyDate=((String)stockTable.getValueAt(rows[i], col_buyDate)).trim();
					String saleDate=((String)stockTable.getValueAt(rows[i], col_saleDate)).trim();
					StockDayData buySDD=CommonTool.getStockDayData(stockcode, buyDate);
					StockDayData saleSDD=CommonTool.getStockDayData(stockcode, saleDate);
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(saleSDD);
					trd.setStockcode(stockcode);
					
					transactionList.add(trd);
					
				}
				

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		// ����AIQuantBot����stockDayAccountMap
		AIQuantBot aiqb=new AIQuantBot();
		Map stockDayAccountMap=aiqb.AIgenerateStockDayAccountMap(transactionList);
		
		// ����stockDayAccountMap�������ڻ�ͼ��stockDataRecordList
		Iterator it=stockDayAccountMap.keySet().iterator();
		while(it.hasNext())
		{
			
			String date=(String)it.next();
			
			StockDayAccount sda=(StockDayAccount)stockDayAccountMap.get(date);
			List stockHoldList=sda.getCurrentStockHoldList();
			String stockHoldStr="";
			for (int i=0; i<stockHoldList.size(); i++)
			{
				StockHoldData shd=(StockHoldData)stockHoldList.get(i);
				stockHoldStr=stockHoldStr+" "+shd.getStockcode()+" "+shd.getStockname()+" "
				+shd.getAmount()+"/"+shd.getBuyPrice()+"-"+shd.getCurPrice()+", ";
			}
			
			System.out.println(
					date+":" 
					+" cash "+CommonTool.getDoubleNumberWithTwoBit(sda.currentCash)
					+" stock "+CommonTool.getDoubleNumberWithTwoBit(sda.currentStockValue)
					+" total "+CommonTool.getDoubleNumberWithTwoBit(sda.currentTotalValue)
					+" ( "+stockHoldStr+" )");
			
		}
		
		
		// ����stockDataRecordList��K��ʾ��ͼ
		
		
		
	}
	
	public static List generateStockDataRecordListFL(Map valueMap, String columnName)
	{
	
			Map stockDataRecordMap=new TreeMap();
			List stockDataRecordList=new ArrayList();
		
			Iterator it=valueMap.keySet().iterator();
			double preDayValue=0;

			try
			{
				while (it.hasNext()) {
		
					String date=it.next().toString();
					double value=CommonTool.converToDoubleNumber((String)valueMap.get(date));
						
					if (preDayValue==0) 
						preDayValue=value;
					
					StockDayData sdd=new StockDayData();
					
					sdd.setCode(columnName.trim());
					sdd.setName(columnName.trim());
					sdd.setDate(date.trim());
					
					sdd.setOpen(preDayValue);
					sdd.setHigh(value);
					sdd.setLow(preDayValue);
					sdd.setClose(value);		
					sdd.setAmount(10000000);
					
					double rise=CommonTool.getDoubleNumberWithTwoBit((value/preDayValue-1)*100);   // �����Ƿ�
					sdd.setOpen_rise(0);
					sdd.setLow_rise(0);
					sdd.setHigh_rise(rise);
					sdd.setClose_rise(rise);
							
					stockDataRecordMap.put(date, sdd);
					preDayValue=value;
					
				}
				
				Iterator its=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(its.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(its.next());
					sdd.setPosNum(posNum);
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			
		
		
		return stockDataRecordList;
		
	}
	
	
	public static List generateStockDataRecordListDBJ(Map valueMap, String columnName, double benjin)
	{
	
			Map stockDataRecordMap=new TreeMap();
			List stockDataRecordList=new ArrayList();
		
			Iterator it=valueMap.keySet().iterator();
			double preDayValue=0;

			try
			{
				while (it.hasNext()) {
		
					String date=it.next().toString();
					double value=CommonTool.converToDoubleNumber((String)valueMap.get(date));
					if (preDayValue==0) preDayValue=value;
					
					StockDayData sdd=new StockDayData();
					
					sdd.setCode(columnName.trim());
					sdd.setName(columnName.trim());
					sdd.setDate(date.trim());
					
					sdd.setOpen(preDayValue);
					sdd.setClose(value);		
					
					if (value>=preDayValue)
					{
						sdd.setHigh(value);
						sdd.setLow(preDayValue);
					}
					else
					{
						sdd.setHigh(preDayValue);
						sdd.setLow(value);
					}
					sdd.setAmount(10000000);
					
					double rise=CommonTool.getDoubleNumberWithTwoBit((value-preDayValue)/benjin*100);   // �����Ƿ�
					sdd.setOpen_rise(0);
					sdd.setClose_rise(rise);
					if (value>=preDayValue)
					{
						sdd.setHigh_rise(rise);	
						sdd.setLow_rise(0);
					}
					else
					{
						sdd.setHigh_rise(0);
						sdd.setLow_rise(rise);
					}
					
					
					stockDataRecordMap.put(date, sdd);
					preDayValue=value;
					
				}
				
				Iterator its=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(its.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(its.next());
					sdd.setPosNum(posNum);
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			
		
		
		return stockDataRecordList;
		
	}
	
	
	public void drawDot()
	{
		my_g.setColor(Color.lightGray);   
		
		int wide=this.getWidth();
		int height=this.getHeight();
		int wdis=30;
		int hdis=30;
		for (int i=30; i<wide; i=i+wdis)
		{
			for (int j=30; j<height; j=j+hdis)
			{
				my_g.drawLine(i, j, i, j);
			}
		}
		
	}
	
	
    //����JPanel��paint����  
    //Graphics �ǻ�ͼ����Ҫ�ࡣ����԰�������һֻ����  
//    public void paint(Graphics g){  
//           
//    	   //1.���ø��ຯ����ɳ�ʼ������  
//           //��仰������  
//           super.paint(g);  
//           
//           my_g=(Graphics2D)g;
//           my_g.setStroke(new BasicStroke(2.0f));  
//           
//           drawDot();
//            
//    }  

	
    
 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		JFrame jf=new JFrame();				
//		VisualConfigureDesignPanel vcdp=new VisualConfigureDesignPanel();
//		jf.getContentPane().add(vcdp);
//		jf.setLocation(100, 100);
//		jf.setSize(600, 400);
//		jf.setVisible(true);

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
