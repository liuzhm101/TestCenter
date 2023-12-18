 package com.finance.stock.gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.finance.stock.data.StockDayData;
import com.finance.stock.data.StockDayMarketSumData;
import com.finance.stock.data.StockRecordRUR;

public class MarketMonitor {

	String stockAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull";
	String stockFileFolder=stockAllDataFull+"\\all";
	
	public static void main(String args[])
	{
		
		MarketMonitor mm=new MarketMonitor();
		
		long starttime=System.currentTimeMillis();
		
//		String curDate=CommonTool.getCurrentDate().substring(0, 10).replace("-", "/");
		mm.monitorMarket("2019/06/01", "2019/07/20");
		
		long endtime=System.currentTimeMillis();
		
		int time=(int)(endtime-starttime)/1000;
		System.out.println("Total time: "+time+"秒");
		
	}
	
	public void monitorMarket(String curDate)
	{
		
		try
		{
//			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\MarketMonitorOut.log")));
			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\MarketMonitorErr.log")));
		
		
			// 读取全部股票代码
			String stockCodeListFile="stockcodelist";
			ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
			List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
	//		stockCodeList=CommonTool.getAllStock_Random(stockCodeList, 20);
//			stockCodeList=CommonTool.getAllStock_600(stockCodeList);
//			stockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 0, 20);
			
			// 处理历史全部日期的市场交易情况
	//		processStockMarketSumData(stockCodeList);
			
			// 处理指定时间内的市场交易情况
//			int days=5;
//			String startDate=CommonTool.getStockTransDate(curDate, -days);
//			System.out.println(startDate+" - "+curDate);
			
			processAddStockMarketSumData(stockCodeList, curDate, curDate);
//			processAddStockMarketSumData(stockCodeList, "2018/07/06", "2018/12/31");
			
			
//			processStockRiseRank(stockCodeList, startDate, curDate, 0);  // 过去n天涨幅排名
//			processStockRiseRank(stockCodeList, "2005/01/01", "2014/01/01", 0); // 某段时间内涨幅排名
//			processStockRiseRank(stockCodeList, "2005/01/01", "2015/01/01", 0); // 某段时间内涨幅排名
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void monitorMarket(String startDate, String endDate)
	{
		
		try
		{
//			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\MarketMonitorOut.log")));
			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\MarketMonitorErr.log")));
		
		
			// 读取全部股票代码
			String stockCodeListFile="stockcodelist";
			ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
			List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
	//		stockCodeList=CommonTool.getAllStock_Random(stockCodeList, 20);
//			stockCodeList=CommonTool.getAllStock_600(stockCodeList);
//			stockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 0, 20);
			
			// 处理历史全部日期的市场交易情况
	//		processStockMarketSumData(stockCodeList);
			
			// 处理指定时间内的市场交易情况
//			int days=5;
//			String startDate=CommonTool.getStockTransDate(curDate, -days);
//			System.out.println(startDate+" - "+curDate);
			
			processAddStockMarketSumData(stockCodeList, startDate, endDate);
//			processAddStockMarketSumData(stockCodeList, "2018/07/06", "2018/12/31");
			
			
//			processStockRiseRank(stockCodeList, startDate, curDate, 0);  // 过去n天涨幅排名
//			processStockRiseRank(stockCodeList, "2005/01/01", "2014/01/01", 0); // 某段时间内涨幅排名
//			processStockRiseRank(stockCodeList, "2005/01/01", "2015/01/01", 0); // 某段时间内涨幅排名
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void processStockMarketSumData(List stockCodeList)
	{
		
		// 对股票代码按规则进行抽样选取
		List researchStockCodeList=new ArrayList();
		Map stockMarketSumDataMap;
		
		
		// 测试数据
//		researchStockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 1, 50); 
//		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "all");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		
		// 全部股票统计
		researchStockCodeList=stockCodeList; 
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "all");
		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		// 分版块股票统计
		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // 按600板块选股
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "600");
		outputMarketSumDataToTable(stockMarketSumDataMap, "600");
		
		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // 按300板块选股
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "300");
		outputMarketSumDataToTable(stockMarketSumDataMap, "300");
		
		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // 按000板块选股
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "000");
		outputMarketSumDataToTable(stockMarketSumDataMap, "000");
		
		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // 按002板块选股
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "002");
		outputMarketSumDataToTable(stockMarketSumDataMap, "002");
		
		
	}
	
	public void processAddStockMarketSumData(List stockCodeList, String startDate, String endDate)
	{
		
		// 对股票代码按规则进行抽样选取
		List researchStockCodeList=new ArrayList();
		Map stockMarketSumDataMap;
		
		
		// 测试数据
//		researchStockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 1, 50); 
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "all");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		
		// 全部股票统计
		researchStockCodeList=stockCodeList; 
		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList,  startDate, endDate, "all");
		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		// 分版块股票统计
//		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // 按600板块选股
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "600");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "600");
//		
//		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // 按300板块选股
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "300");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "300");
//		
//		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // 按000板块选股
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "000");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "000");
//		
//		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // 按002板块选股
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "002");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "002");
//		
		
	}
	
	public void processStockRiseRank(List stockCodeList, String startDate, String endDate, int minRiseDays)
	{
	
		// 对股票代码按规则进行抽样选取
		List researchStockCodeList=new ArrayList();
		List transactionDataList;
		
		// 测试数据
//		stockCodeList=CommonTool.getAllStock_ByOrderNo(CommonTool.getAllStock_600(stockCodeList), 1, 100);
		
		List allTransactionDataList=new ArrayList();
		
		// 单线程处理股票
		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // 按600板块选股
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "600", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // 按300板块选股
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "300", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // 按000板块选股
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "000", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // 按002板块选股
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "002", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
//		researchStockCodeList=stockCodeList; 
//		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
//		outputTransactionRecordReport(transactionDataList, "all", startDate, endDate);	
		outputRiseRankDataToTable(allTransactionDataList, "all", startDate, endDate);	
		
		
		// 多线程处理股票
//		ThreadMarketMonitor tmm=new ThreadMarketMonitor();
//		tmm.functionName=StockKey.StockRiseRank;
//		tmm.stockType="all";
//		tmm.researchStockCodeList=stockCodeList;
//		tmm.startDate=startDate;
//		tmm.endDate=endDate;
//		tmm.minRiseDays=minRiseDays;
//		tmm.start();
//		
//		ThreadMarketMonitor tmm_600=new ThreadMarketMonitor();
//		tmm_600.functionName=StockKey.StockRiseRank;
//		tmm_600.stockType="600";
//		tmm_600.researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);
//		tmm_600.startDate=startDate;
//		tmm_600.endDate=endDate;
//		tmm_600.minRiseDays=minRiseDays;
//		tmm_600.start();
//		
//		ThreadMarketMonitor tmm_300=new ThreadMarketMonitor();
//		tmm_300.functionName=StockKey.StockRiseRank;
//		tmm_300.stockType="300";
//		tmm_300.researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);
//		tmm_300.startDate=startDate;
//		tmm_300.endDate=endDate;
//		tmm_300.minRiseDays=minRiseDays;
//		tmm_300.start();
//		
//		ThreadMarketMonitor tmm_000=new ThreadMarketMonitor();
//		tmm_000.functionName=StockKey.StockRiseRank;
//		tmm_000.stockType="000";
//		tmm_000.researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);
//		tmm_000.startDate=startDate;
//		tmm_000.endDate=endDate;
//		tmm_000.minRiseDays=minRiseDays;
//		tmm_000.start();
//		
//		ThreadMarketMonitor tmm_002=new ThreadMarketMonitor();
//		tmm_002.functionName=StockKey.StockRiseRank;
//		tmm_002.stockType="002";
//		tmm_002.researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);
//		tmm_002.startDate=startDate;
//		tmm_002.endDate=endDate;
//		tmm_002.minRiseDays=minRiseDays;
//		tmm_002.start();
		
	}
	
	public Map generateAddStockMarketSumData(List stockCodeList, String startDate, String endDate, String marketType)
	{
		
		Map stockMarketSumDataMap=new TreeMap();
		
		String stockFileFolder=stockAllDataFull+"\\all";
		for (int i=0; i<stockCodeList.size(); i++)   // 获得每只股票的数据 sddList
		{
				
			// 取一只股票的历史所有数据
			String stockcode=((String)stockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition); // 取出所有日的sdd对象
			System.out.println("Check stock: "+stockcode);
			
			for (int j=stockDataList.size()-1; j>=0; j--)  // 获得每只股票每天的数据 sdd
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 取出此股票某日的sdd记录
				
				StockDayMarketSumData sdmsd;
				if (stockMarketSumDataMap.get(sdd.getDate())==null)
				{
					sdmsd=new StockDayMarketSumData();  // 如果不存在date日的sdmsd，则创建一个sdmsd
					sdmsd.setDate(sdd.date);
					sdmsd.setType(marketType);
					stockMarketSumDataMap.put(sdmsd.getDate(), sdmsd);
				}
				else
				{
					sdmsd=(StockDayMarketSumData)stockMarketSumDataMap.get(sdd.getDate()); // 如果已存在sdmsd，取出来
				}
				
				// 根据stock当天的sdd数据统计纳入sdmsd中
				if (sdd.getClose_rise()>9.9)
				{
					sdmsd.rise10_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>=7)
				{
					sdmsd.rise7_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>=5)
				{
					sdmsd.rise5_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>=3)
				{
					sdmsd.rise3_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>0)
				{
					sdmsd.rise0_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()==0)
				{
					sdmsd.flat_count++;
				}
				else if (sdd.getClose_rise()>=-3)
				{
					sdmsd.down0_count++;
					sdmsd.down_count++;
				}					
				else if (sdd.getClose_rise()>=-5)
				{
					sdmsd.down3_count++;
					sdmsd.down_count++;
				}						
				else if (sdd.getClose_rise()>=-7)
				{
					sdmsd.down5_count++;
					sdmsd.down_count++;
				}	
				else if (sdd.getClose_rise()>=-9.9)
				{
					sdmsd.down7_count++;
					sdmsd.down_count++;
				}				
				else if (sdd.getClose_rise()>-11)
				{
					sdmsd.down10_count++;
					sdmsd.down_count++;
				}	
				
				
				// 根据stock当天open开盘时的sdd数据统计纳入sdmsd中
				if (sdd.getOpen_rise()>9.9)
				{
					sdmsd.rise10_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>=7)
				{
					sdmsd.rise7_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>=5)
				{
					sdmsd.rise5_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>=3)
				{
					sdmsd.rise3_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>0)
				{
					sdmsd.rise0_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()==0)
				{
					sdmsd.flat_count_open++;
				}
				else if (sdd.getOpen_rise()>=-3)
				{
					sdmsd.down0_count_open++;
					sdmsd.down_count_open++;
				}					
				else if (sdd.getOpen_rise()>=-5)
				{
					sdmsd.down3_count_open++;
					sdmsd.down_count_open++;
				}						
				else if (sdd.getOpen_rise()>=-7)
				{
					sdmsd.down5_count_open++;
					sdmsd.down_count_open++;
				}	
				else if (sdd.getOpen_rise()>=-9.9)
				{
					sdmsd.down7_count_open++;
					sdmsd.down_count_open++;
				}				
				else if (sdd.getOpen_rise()>-11)
				{
					sdmsd.down10_count_open++;
					sdmsd.down_count_open++;
				}	
				
				
				sdmsd.count++;	// 累加总股票数
				sdmsd.total_money=sdmsd.total_money+sdd.getMoney();	// 累加总成交量
				sdmsd.total_liquid_value=sdmsd.total_liquid_value+sdd.getLiquid_value();  // 累加总流通市值
				
				if (sdd.getClose_rise()>0) // 收盘上涨总幅度
				{
					sdmsd.total_rise_percent=sdmsd.total_rise_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()>0)  // 收盘红柱总幅度
				{
					sdmsd.actual_rise_percent=sdmsd.actual_rise_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				if (sdd.getClose_rise()<0) // 收盘下跌总幅度
				{
					sdmsd.total_down_percent=sdmsd.total_down_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()<0)  // 收盘绿柱总幅度
				{
					sdmsd.actual_down_percent=sdmsd.actual_down_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				
				// 等权重股指涨跌幅
				if (sdd.getClose_rise()>-20 && sdd.getClose_rise()<20)  // 去除新股首日及非正常的大跌
				{
					sdmsd.equalWeightTotalRise=sdmsd.equalWeightTotalRise+sdd.getClose_rise();
					sdmsd.equalWeightCount++;
					sdmsd.equalWeightRise=sdmsd.equalWeightTotalRise/sdmsd.equalWeightCount;
				}
				
			}

		}
	
		
		return stockMarketSumDataMap;
		
	}
	
	public Map generateStockMarketSumData(List stockCodeList, String marketType)
	{
		
		Map stockMarketSumDataMap=new TreeMap();
		
		String stockFileFolder=stockAllDataFull+"\\all";
		for (int i=0; i<stockCodeList.size(); i++)   // 获得每只股票的数据 sddList
		{
				
			// 取一只股票的历史所有数据
			String stockcode=((String)stockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename); // 取出所有日的sdd对象
			System.out.println("Check stock: "+stockcode);
			
			for (int j=stockDataList.size()-1; j>=0; j--)  // 获得每只股票每天的数据 sdd
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 取出此股票某日的sdd记录
				
				StockDayMarketSumData sdmsd;
				if (stockMarketSumDataMap.get(sdd.getDate())==null)
				{
					sdmsd=new StockDayMarketSumData();  // 如果不存在date日的sdmsd，则创建一个sdmsd
					sdmsd.setDate(sdd.date);
					sdmsd.setType(marketType);
					stockMarketSumDataMap.put(sdmsd.getDate(), sdmsd);
				}
				else
				{
					sdmsd=(StockDayMarketSumData)stockMarketSumDataMap.get(sdd.getDate()); // 如果已存在sdmsd，取出来
				}
				
				
				// 根据stock当天的sdd数据统计纳入sdmsd中
				if (sdd.getClose_rise()>9.9)
				{
					sdmsd.rise10_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>=7)
				{
					sdmsd.rise7_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>=5)
				{
					sdmsd.rise5_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>=3)
				{
					sdmsd.rise3_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()>0)
				{
					sdmsd.rise0_count++;
					sdmsd.rise_count++;
				}
				else if (sdd.getClose_rise()==0)
				{
					sdmsd.flat_count++;
				}
				else if (sdd.getClose_rise()>=-3)
				{
					sdmsd.down0_count++;
					sdmsd.down_count++;
				}					
				else if (sdd.getClose_rise()>=-5)
				{
					sdmsd.down3_count++;
					sdmsd.down_count++;
				}						
				else if (sdd.getClose_rise()>=-7)
				{
					sdmsd.down5_count++;
					sdmsd.down_count++;
				}	
				else if (sdd.getClose_rise()>=-9.9)
				{
					sdmsd.down7_count++;
					sdmsd.down_count++;
				}				
				else if (sdd.getClose_rise()>-11)
				{
					sdmsd.down10_count++;
					sdmsd.down_count++;
				}	
				
				
				// 根据stock当天open开盘时的sdd数据统计纳入sdmsd中
				if (sdd.getOpen_rise()>9.9)
				{
					sdmsd.rise10_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>=7)
				{
					sdmsd.rise7_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>=5)
				{
					sdmsd.rise5_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>=3)
				{
					sdmsd.rise3_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()>0)
				{
					sdmsd.rise0_count_open++;
					sdmsd.rise_count_open++;
				}
				else if (sdd.getOpen_rise()==0)
				{
					sdmsd.flat_count_open++;
				}
				else if (sdd.getOpen_rise()>=-3)
				{
					sdmsd.down0_count_open++;
					sdmsd.down_count_open++;
				}					
				else if (sdd.getOpen_rise()>=-5)
				{
					sdmsd.down3_count_open++;
					sdmsd.down_count_open++;
				}						
				else if (sdd.getOpen_rise()>=-7)
				{
					sdmsd.down5_count_open++;
					sdmsd.down_count_open++;
				}	
				else if (sdd.getOpen_rise()>=-9.9)
				{
					sdmsd.down7_count_open++;
					sdmsd.down_count_open++;
				}				
				else if (sdd.getOpen_rise()>-11)
				{
					sdmsd.down10_count_open++;
					sdmsd.down_count_open++;
				}	
				
				
				
				sdmsd.count++;	// 累加总股票数
				sdmsd.total_money=sdmsd.total_money+sdd.getMoney();	// 累加总成交量
				sdmsd.total_liquid_value=sdmsd.total_liquid_value+sdd.getLiquid_value();  // 累加总流通市值

				
				if (sdd.getClose_rise()>0) // 收盘上涨总幅度
				{
					sdmsd.total_rise_percent=sdmsd.total_rise_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()>0)  // 收盘红柱总幅度
				{
					sdmsd.actual_rise_percent=sdmsd.actual_rise_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				if (sdd.getClose_rise()<0) // 收盘下跌总幅度
				{
					sdmsd.total_down_percent=sdmsd.total_down_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()<0)  // 收盘绿柱总幅度
				{
					sdmsd.actual_down_percent=sdmsd.actual_down_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				// 等权重股指涨跌幅
				if (sdd.getClose_rise()>-20 && sdd.getClose_rise()<20)  // 去除新股首日及非正常的大跌
				{
					sdmsd.equalWeightTotalRise=sdmsd.equalWeightTotalRise+sdd.getClose_rise();
					sdmsd.equalWeightCount++;
					sdmsd.equalWeightRise=sdmsd.equalWeightTotalRise/sdmsd.equalWeightCount;
				}
				
			}

		}
	
		
		return stockMarketSumDataMap;
		
	}
	
	//	涨幅排行
	public List generateStockRankData(List stockCodeList, String startDate, String endDate, int minRiseDays)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<stockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)stockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\""; 
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock Rank: "+stockcode);
			
//			List researchStockDayDataList=new ArrayList();
//			for (int j=0; j<stockDataList.size(); j++)
//			{	
//				
//				// 每天的数据
//				StockDayData sdd=(StockDayData)stockDataList.get(j); 
//				if (sdd.getDate().compareTo(startDate)>0 && sdd.getDate().compareTo(endDate)<0)
//				{
//					researchStockDayDataList.add(sdd);
//				}
//				
//			}
			List researchStockDayDataList=stockDataList;
			
			List RURList=new ArrayList();
			for (int m=0; m<researchStockDayDataList.size(); m++)
			{
				StockDayData sddm=(StockDayData)researchStockDayDataList.get(m);
				StockDayData maxSdd=sddm;
				
				for (int n=m; n<researchStockDayDataList.size(); n++)  // 从当前价格值往后查找最大价格值
				{		
					StockDayData sddn=(StockDayData)researchStockDayDataList.get(n);
					if (sddn.getClose()>maxSdd.getClose())
					{
						maxSdd=sddn;
					}
				}
				
				if (sddm.getClose()==0)
				{
					continue;
				}
				else
				{
					double RUR=CommonTool.getDoubleNumberWithTwoBit((maxSdd.getClose()-sddm.getClose())*100/sddm.getClose()); // 计算当前价格值为买入点的最大涨幅				
					maxSdd.setProfit(RUR);
					
					StockRecordRUR srr=new StockRecordRUR();
					srr.setCurSDD(sddm);
					srr.setMaxSDD(maxSdd);
					srr.setRUR(RUR);
				
					// 记录每日为起点之后的最大上涨波段记录
					RURList.add(srr);
					
				}
				

			}
			
			// 再找出所有最大上涨波段记录中最最大的那个
			StockRecordRUR maxSRR=null;
			for (int p=0; p<RURList.size(); p++)
			{

				StockRecordRUR srr=(StockRecordRUR)RURList.get(p);
				if (maxSRR==null || srr.getRUR()>maxSRR.getRUR())
				{
					maxSRR=srr;
				}
			}
			
			if (maxSRR!=null)
			{
				if (maxSRR.getMaxSDD().getPosNum()-maxSRR.getCurSDD().getPosNum()<minRiseDays) continue; 
				
				TransactionRecordData trd=new TransactionRecordData();
				trd.setBuySDD(maxSRR.getCurSDD());
				trd.setSaleSDD(maxSRR.getMaxSDD());
				trd.setStockcode(stockcode);
				
				transactionDataList.add(trd);
			}
			
		}
		
		return transactionDataList;
		
	}
	
	
	public void outputMarketSumDataToTable(Map stockMarketSumDataMap, String marketType)
	{
		// 创建 column 列名行

		String columnDef=
				CommonTool.getSqlStrColumnDef("date_sum", 20)+
				CommonTool.getSqlStrColumnDef("type", 10)+	 
				CommonTool.getSqlNumberColumnDef("count")+
				CommonTool.getSqlNumberColumnDef("equalWeightTotalRise") +
				CommonTool.getSqlNumberColumnDef("equalWeightRise") +
				CommonTool.getSqlNumberColumnDef("rise") +
				CommonTool.getSqlNumberColumnDef("down") +
				CommonTool.getSqlNumberColumnDef("flat") +
				CommonTool.getSqlNumberColumnDef("rise10") +
				CommonTool.getSqlNumberColumnDef("down10") +
				CommonTool.getSqlNumberColumnDef("rise7") +
				CommonTool.getSqlNumberColumnDef("down7") +
				CommonTool.getSqlNumberColumnDef("rise5") +
				CommonTool.getSqlNumberColumnDef("down5") +
				CommonTool.getSqlNumberColumnDef("rise3") +
				CommonTool.getSqlNumberColumnDef("down3") +
				CommonTool.getSqlNumberColumnDef("rise0") +
				CommonTool.getSqlNumberColumnDef("down0") +
				CommonTool.getSqlNumberColumnDef("rise_open") +
				CommonTool.getSqlNumberColumnDef("down_open") +
				CommonTool.getSqlNumberColumnDef("flat_open") +
				CommonTool.getSqlNumberColumnDef("rise10_open") +
				CommonTool.getSqlNumberColumnDef("down10_open") +
				CommonTool.getSqlNumberColumnDef("rise7_open") +
				CommonTool.getSqlNumberColumnDef("down7_open") +
				CommonTool.getSqlNumberColumnDef("rise5_open") +
				CommonTool.getSqlNumberColumnDef("down5_open") +
				CommonTool.getSqlNumberColumnDef("rise3_open") +
				CommonTool.getSqlNumberColumnDef("down3_open") +
				CommonTool.getSqlNumberColumnDef("rise0_open") +
				CommonTool.getSqlNumberColumnDef("down0_open") +				
				CommonTool.getSqlNumberColumnDef("total_rise_percent") +
				CommonTool.getSqlNumberColumnDef("total_down_percent")+
				CommonTool.getSqlNumberColumnDef("actual_rise_percent") +
				CommonTool.getSqlNumberColumnDef("actual_down_percent")+
				CommonTool.getSqlNumberColumnDef("total_money") +
				CommonTool.getSqlNumberColumnDef("total_liquid_value").replace(",", "") 
				;
		
		// 单独创建目录来保存大盘统计结果
//		String datestr=CommonTool.getCurrentDate().replace(":", "-").replace(" ", "_");
//		String resultFileFolder=stockAllDataFull+"\\market\\"+datestr;  // 不能用all那个目录，会报字符型数据丢失的奇怪错误。
//		FileTool.createFolder(resultFileFolder);
		
		// 在market目录下保存大盘统计结果
		String filename="MarketSumaryData_"+marketType;
		String resultFileFolder=stockAllDataFull+"\\market";
		File f=new File(resultFileFolder+"\\"+filename+".sas7bdat");
		if (!f.exists())
		{
			CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		}
		
		List marketDataList=new ArrayList();
		Iterator it=stockMarketSumDataMap.keySet().iterator();
		while (it.hasNext())
		{
	
			StockDayMarketSumData sdmsd=(StockDayMarketSumData)stockMarketSumDataMap.get(it.next());
			
			// 创建 data 数据行
			String dataDef=
					CommonTool.getSqlStrDataDef(sdmsd.getDate())+
					CommonTool.getSqlStrDataDef(sdmsd.getType())+
					CommonTool.getSqlNumberDataDef(sdmsd.getCount()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getEqualWeightTotalRise()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getEqualWeightRise()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getFlat_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise10_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown10_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise7_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown7_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise5_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown5_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise3_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown3_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise0_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown0_count()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getFlat_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise10_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown10_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise7_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown7_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise5_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown5_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise3_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown3_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getRise0_count_open()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getDown0_count_open()+"")+					
					CommonTool.getSqlNumberDataDef(sdmsd.getTotal_rise_percent()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getTotal_down_percent()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getActual_rise_percent()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getActual_down_percent()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getTotal_money()+"")+
					CommonTool.getSqlNumberDataDef(sdmsd.getTotal_liquid_value()+"").replace(",", "")
					;
			
//			marketDataList.add(dataDef);
			CommonTool.insertDataToSASDataSet(resultFileFolder, filename, dataDef);
			
			System.out.println(sdmsd.getDate()+"(count: "+sdmsd.getCount()+"): "+sdmsd.getRise_count()+" "+sdmsd.getDown_count());
			
		}
		
//		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, marketDataList);
		
		
	}
	
	public void outputRiseRankDataToTable(List transactionDataList, String marketType, String startDate, String endDate)
	{
		String period=startDate.replace("/", "")+"_"+endDate.replace("/", "");
		String columnDef="stockcode varchar(10), stockname varchar(10),  liquid_value double precision format 12.2, total_value double precision format 12.2, " +
				"date_c varchar(20), saledate varchar(20), days varchar(20), profit double precision format 12.2";
		String filename="RiseRank_"+marketType+"_"+period;
		String resultFileFolder=stockAllDataFull+"\\market";
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			double profit=trd.getSaleSDD().getProfit();
			if (profit==0)
			{
				if (trd.getBuySDD().getOpen()==0)
				{
					continue;
				}
				else
				{
					profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100;
				}
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(profit);
			transDataList.add(dataDef);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		
		
	}	
	
	public static Map rankStockRiseSpeed(Map stockDataMap, String startDate, String endDate, String timeType)
	{
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, timeType);
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			Map sortMap=new TreeMap();
			
			// 取出一个stock的所有数据list
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				String stockCode=it.next().toString();
				List stockRecordList=(List)stockDataMap.get(stockCode); 
				
				// 取出这个stock在此交易日期的sdd，放入排序Map中
				StockDayData sdd=CommonTool.getStockDayDataExisted(stockRecordList, transDate);
				sortMap.put(sdd.getReal_rise(), sdd);
			}
			
			// 排序好的Map中取出每个sdd，设置在交易日期的涨速(涨幅)相对排序值
			Iterator its=sortMap.keySet().iterator();
			List sortList=new ArrayList();
			int rank=sortMap.size();
			while(its.hasNext())
			{
				StockDayData sdd=(StockDayData)sortMap.get(its.next());
				sdd.setRise_speed_rank(rank);
				rank--;
			}
			
		}
		
		return stockDataMap;
		
	}
	
}
