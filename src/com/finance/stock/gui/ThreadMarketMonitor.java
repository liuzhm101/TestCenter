package com.finance.stock.gui;

import java.util.List;

public class ThreadMarketMonitor extends Thread {

	String stockType="";
	String functionName="";
	
	List researchStockCodeList;
	String startDate;
	String endDate;
	int minRiseDays;
	
	public void run()
	{
		long starttime=System.currentTimeMillis();
		
		if (functionName.equals(StockKey.StockRiseRank))
		{
			MarketMonitor mm=new MarketMonitor();
			List transactionDataList=mm.generateStockRankData(researchStockCodeList, startDate, endDate, minRiseDays);
			mm.outputRiseRankDataToTable(transactionDataList, stockType, startDate, endDate);	
		}
		
		if (functionName.equals(StockKey.StockMarketSumData))
		{
			
			
		}
		
		long endtime=System.currentTimeMillis();
		
		int time=(int)(endtime-starttime)/1000;
		System.out.println("Total time: "+time+"√Î");

		
	}
	

	
}
