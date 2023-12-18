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
		System.out.println("Total time: "+time+"��");
		
	}
	
	public void monitorMarket(String curDate)
	{
		
		try
		{
//			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\MarketMonitorOut.log")));
			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\MarketMonitorErr.log")));
		
		
			// ��ȡȫ����Ʊ����
			String stockCodeListFile="stockcodelist";
			ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
			List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
	//		stockCodeList=CommonTool.getAllStock_Random(stockCodeList, 20);
//			stockCodeList=CommonTool.getAllStock_600(stockCodeList);
//			stockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 0, 20);
			
			// ������ʷȫ�����ڵ��г��������
	//		processStockMarketSumData(stockCodeList);
			
			// ����ָ��ʱ���ڵ��г��������
//			int days=5;
//			String startDate=CommonTool.getStockTransDate(curDate, -days);
//			System.out.println(startDate+" - "+curDate);
			
			processAddStockMarketSumData(stockCodeList, curDate, curDate);
//			processAddStockMarketSumData(stockCodeList, "2018/07/06", "2018/12/31");
			
			
//			processStockRiseRank(stockCodeList, startDate, curDate, 0);  // ��ȥn���Ƿ�����
//			processStockRiseRank(stockCodeList, "2005/01/01", "2014/01/01", 0); // ĳ��ʱ�����Ƿ�����
//			processStockRiseRank(stockCodeList, "2005/01/01", "2015/01/01", 0); // ĳ��ʱ�����Ƿ�����
			
			
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
		
		
			// ��ȡȫ����Ʊ����
			String stockCodeListFile="stockcodelist";
			ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
			List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
	//		stockCodeList=CommonTool.getAllStock_Random(stockCodeList, 20);
//			stockCodeList=CommonTool.getAllStock_600(stockCodeList);
//			stockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 0, 20);
			
			// ������ʷȫ�����ڵ��г��������
	//		processStockMarketSumData(stockCodeList);
			
			// ����ָ��ʱ���ڵ��г��������
//			int days=5;
//			String startDate=CommonTool.getStockTransDate(curDate, -days);
//			System.out.println(startDate+" - "+curDate);
			
			processAddStockMarketSumData(stockCodeList, startDate, endDate);
//			processAddStockMarketSumData(stockCodeList, "2018/07/06", "2018/12/31");
			
			
//			processStockRiseRank(stockCodeList, startDate, curDate, 0);  // ��ȥn���Ƿ�����
//			processStockRiseRank(stockCodeList, "2005/01/01", "2014/01/01", 0); // ĳ��ʱ�����Ƿ�����
//			processStockRiseRank(stockCodeList, "2005/01/01", "2015/01/01", 0); // ĳ��ʱ�����Ƿ�����
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void processStockMarketSumData(List stockCodeList)
	{
		
		// �Թ�Ʊ���밴������г���ѡȡ
		List researchStockCodeList=new ArrayList();
		Map stockMarketSumDataMap;
		
		
		// ��������
//		researchStockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 1, 50); 
//		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "all");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		
		// ȫ����Ʊͳ��
		researchStockCodeList=stockCodeList; 
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "all");
		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		// �ְ���Ʊͳ��
		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // ��600���ѡ��
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "600");
		outputMarketSumDataToTable(stockMarketSumDataMap, "600");
		
		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // ��300���ѡ��
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "300");
		outputMarketSumDataToTable(stockMarketSumDataMap, "300");
		
		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // ��000���ѡ��
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "000");
		outputMarketSumDataToTable(stockMarketSumDataMap, "000");
		
		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // ��002���ѡ��
		stockMarketSumDataMap=generateStockMarketSumData(researchStockCodeList,  "002");
		outputMarketSumDataToTable(stockMarketSumDataMap, "002");
		
		
	}
	
	public void processAddStockMarketSumData(List stockCodeList, String startDate, String endDate)
	{
		
		// �Թ�Ʊ���밴������г���ѡȡ
		List researchStockCodeList=new ArrayList();
		Map stockMarketSumDataMap;
		
		
		// ��������
//		researchStockCodeList=CommonTool.getAllStock_ByOrderNo(stockCodeList, 1, 50); 
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "all");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		
		// ȫ����Ʊͳ��
		researchStockCodeList=stockCodeList; 
		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList,  startDate, endDate, "all");
		outputMarketSumDataToTable(stockMarketSumDataMap, "all");
		
		// �ְ���Ʊͳ��
//		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // ��600���ѡ��
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "600");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "600");
//		
//		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // ��300���ѡ��
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "300");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "300");
//		
//		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // ��000���ѡ��
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "000");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "000");
//		
//		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // ��002���ѡ��
//		stockMarketSumDataMap=generateAddStockMarketSumData(researchStockCodeList, startDate, endDate, "002");
//		outputMarketSumDataToTable(stockMarketSumDataMap, "002");
//		
		
	}
	
	public void processStockRiseRank(List stockCodeList, String startDate, String endDate, int minRiseDays)
	{
	
		// �Թ�Ʊ���밴������г���ѡȡ
		List researchStockCodeList=new ArrayList();
		List transactionDataList;
		
		// ��������
//		stockCodeList=CommonTool.getAllStock_ByOrderNo(CommonTool.getAllStock_600(stockCodeList), 1, 100);
		
		List allTransactionDataList=new ArrayList();
		
		// ���̴߳����Ʊ
		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // ��600���ѡ��
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "600", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // ��300���ѡ��
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "300", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // ��000���ѡ��
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "000", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // ��002���ѡ��
		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
		outputRiseRankDataToTable(transactionDataList, "002", startDate, endDate);	
		allTransactionDataList.addAll(transactionDataList);
		
//		researchStockCodeList=stockCodeList; 
//		transactionDataList=generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
//		outputTransactionRecordReport(transactionDataList, "all", startDate, endDate);	
		outputRiseRankDataToTable(allTransactionDataList, "all", startDate, endDate);	
		
		
		// ���̴߳����Ʊ
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
		for (int i=0; i<stockCodeList.size(); i++)   // ���ÿֻ��Ʊ������ sddList
		{
				
			// ȡһֻ��Ʊ����ʷ��������
			String stockcode=((String)stockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition); // ȡ�������յ�sdd����
			System.out.println("Check stock: "+stockcode);
			
			for (int j=stockDataList.size()-1; j>=0; j--)  // ���ÿֻ��Ʊÿ������� sdd
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ȡ���˹�Ʊĳ�յ�sdd��¼
				
				StockDayMarketSumData sdmsd;
				if (stockMarketSumDataMap.get(sdd.getDate())==null)
				{
					sdmsd=new StockDayMarketSumData();  // ���������date�յ�sdmsd���򴴽�һ��sdmsd
					sdmsd.setDate(sdd.date);
					sdmsd.setType(marketType);
					stockMarketSumDataMap.put(sdmsd.getDate(), sdmsd);
				}
				else
				{
					sdmsd=(StockDayMarketSumData)stockMarketSumDataMap.get(sdd.getDate()); // ����Ѵ���sdmsd��ȡ����
				}
				
				// ����stock�����sdd����ͳ������sdmsd��
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
				
				
				// ����stock����open����ʱ��sdd����ͳ������sdmsd��
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
				
				
				sdmsd.count++;	// �ۼ��ܹ�Ʊ��
				sdmsd.total_money=sdmsd.total_money+sdd.getMoney();	// �ۼ��ܳɽ���
				sdmsd.total_liquid_value=sdmsd.total_liquid_value+sdd.getLiquid_value();  // �ۼ�����ͨ��ֵ
				
				if (sdd.getClose_rise()>0) // ���������ܷ���
				{
					sdmsd.total_rise_percent=sdmsd.total_rise_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()>0)  // ���̺����ܷ���
				{
					sdmsd.actual_rise_percent=sdmsd.actual_rise_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				if (sdd.getClose_rise()<0) // �����µ��ܷ���
				{
					sdmsd.total_down_percent=sdmsd.total_down_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()<0)  // ���������ܷ���
				{
					sdmsd.actual_down_percent=sdmsd.actual_down_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				
				// ��Ȩ�ع�ָ�ǵ���
				if (sdd.getClose_rise()>-20 && sdd.getClose_rise()<20)  // ȥ���¹����ռ��������Ĵ��
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
		for (int i=0; i<stockCodeList.size(); i++)   // ���ÿֻ��Ʊ������ sddList
		{
				
			// ȡһֻ��Ʊ����ʷ��������
			String stockcode=((String)stockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename); // ȡ�������յ�sdd����
			System.out.println("Check stock: "+stockcode);
			
			for (int j=stockDataList.size()-1; j>=0; j--)  // ���ÿֻ��Ʊÿ������� sdd
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ȡ���˹�Ʊĳ�յ�sdd��¼
				
				StockDayMarketSumData sdmsd;
				if (stockMarketSumDataMap.get(sdd.getDate())==null)
				{
					sdmsd=new StockDayMarketSumData();  // ���������date�յ�sdmsd���򴴽�һ��sdmsd
					sdmsd.setDate(sdd.date);
					sdmsd.setType(marketType);
					stockMarketSumDataMap.put(sdmsd.getDate(), sdmsd);
				}
				else
				{
					sdmsd=(StockDayMarketSumData)stockMarketSumDataMap.get(sdd.getDate()); // ����Ѵ���sdmsd��ȡ����
				}
				
				
				// ����stock�����sdd����ͳ������sdmsd��
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
				
				
				// ����stock����open����ʱ��sdd����ͳ������sdmsd��
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
				
				
				
				sdmsd.count++;	// �ۼ��ܹ�Ʊ��
				sdmsd.total_money=sdmsd.total_money+sdd.getMoney();	// �ۼ��ܳɽ���
				sdmsd.total_liquid_value=sdmsd.total_liquid_value+sdd.getLiquid_value();  // �ۼ�����ͨ��ֵ

				
				if (sdd.getClose_rise()>0) // ���������ܷ���
				{
					sdmsd.total_rise_percent=sdmsd.total_rise_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()>0)  // ���̺����ܷ���
				{
					sdmsd.actual_rise_percent=sdmsd.actual_rise_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				if (sdd.getClose_rise()<0) // �����µ��ܷ���
				{
					sdmsd.total_down_percent=sdmsd.total_down_percent+sdd.getClose_rise();
				}
				
				if (sdd.getClose_rise()-sdd.getOpen_rise()<0)  // ���������ܷ���
				{
					sdmsd.actual_down_percent=sdmsd.actual_down_percent+sdd.getClose_rise()-sdd.getOpen_rise();
				}
				
				// ��Ȩ�ع�ָ�ǵ���
				if (sdd.getClose_rise()>-20 && sdd.getClose_rise()<20)  // ȥ���¹����ռ��������Ĵ��
				{
					sdmsd.equalWeightTotalRise=sdmsd.equalWeightTotalRise+sdd.getClose_rise();
					sdmsd.equalWeightCount++;
					sdmsd.equalWeightRise=sdmsd.equalWeightTotalRise/sdmsd.equalWeightCount;
				}
				
			}

		}
	
		
		return stockMarketSumDataMap;
		
	}
	
	//	�Ƿ�����
	public List generateStockRankData(List stockCodeList, String startDate, String endDate, int minRiseDays)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<stockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)stockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\""; 
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock Rank: "+stockcode);
			
//			List researchStockDayDataList=new ArrayList();
//			for (int j=0; j<stockDataList.size(); j++)
//			{	
//				
//				// ÿ�������
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
				
				for (int n=m; n<researchStockDayDataList.size(); n++)  // �ӵ�ǰ�۸�ֵ����������۸�ֵ
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
					double RUR=CommonTool.getDoubleNumberWithTwoBit((maxSdd.getClose()-sddm.getClose())*100/sddm.getClose()); // ���㵱ǰ�۸�ֵΪ����������Ƿ�				
					maxSdd.setProfit(RUR);
					
					StockRecordRUR srr=new StockRecordRUR();
					srr.setCurSDD(sddm);
					srr.setMaxSDD(maxSdd);
					srr.setRUR(RUR);
				
					// ��¼ÿ��Ϊ���֮���������ǲ��μ�¼
					RURList.add(srr);
					
				}
				

			}
			
			// ���ҳ�����������ǲ��μ�¼���������Ǹ�
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
		// ���� column ������

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
		
		// ��������Ŀ¼���������ͳ�ƽ��
//		String datestr=CommonTool.getCurrentDate().replace(":", "-").replace(" ", "_");
//		String resultFileFolder=stockAllDataFull+"\\market\\"+datestr;  // ������all�Ǹ�Ŀ¼���ᱨ�ַ������ݶ�ʧ����ִ���
//		FileTool.createFolder(resultFileFolder);
		
		// ��marketĿ¼�±������ͳ�ƽ��
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
			
			// ���� data ������
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
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			Map sortMap=new TreeMap();
			
			// ȡ��һ��stock����������list
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				String stockCode=it.next().toString();
				List stockRecordList=(List)stockDataMap.get(stockCode); 
				
				// ȡ�����stock�ڴ˽������ڵ�sdd����������Map��
				StockDayData sdd=CommonTool.getStockDayDataExisted(stockRecordList, transDate);
				sortMap.put(sdd.getReal_rise(), sdd);
			}
			
			// ����õ�Map��ȡ��ÿ��sdd�������ڽ������ڵ�����(�Ƿ�)�������ֵ
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
