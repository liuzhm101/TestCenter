package com.finance.stock.gui;

import java.util.*;

import com.finance.stock.data.StockDayAccount;
import com.finance.stock.data.StockDayData;
import com.finance.stock.data.StockHoldData;


public class AIQuantBot {

	
	public Map AIgenerateStockDayAccountMap(List transactionRecordDataList)
	{
		
		Map stockDayTransMap=new TreeMap(); // 结构： date, stockDayTrans对象(内含buyTransList, saleTransList属性)
		
		// 对TransactionRecordDataList 对交易进行按日分类
		for (int i=0; i<transactionRecordDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionRecordDataList.get(i);
			String buyDate=trd.getBuySDD().getDate();	// 取出买入日期
			String saleDate=trd.getSaleSDD().getDate();		// 取出卖出日期
			trd.setTransNo(i);		// 记录交易号
			System.out.println("Handle Transaction: "+i+" "+buyDate);
			
			trd.setTransType(StockKey.buyType);  // 作为买入记录加入到买入日StockDayTrans的buyTransList中
			if (stockDayTransMap.get(buyDate)==null)
			{
				// 如果没有，创建新的stockDayTrans，并添加trd到buyTransList中
				StockDayTrans sdt=new StockDayTrans();
				sdt.getBuyTransList().add(trd);
				stockDayTransMap.put(buyDate, sdt);
			}
			else
			{
				// 如果已存在，则取出stockDayTrans，并添加trd到buyTransList中
				StockDayTrans sdt=(StockDayTrans)stockDayTransMap.get(buyDate);
				sdt.getBuyTransList().add(trd);
				stockDayTransMap.put(buyDate, sdt);
			}
			
			trd.setTransType(StockKey.saleType);  // 同时作为卖出记录加入到卖出日StockDayTrans的saleTransList中
			if (stockDayTransMap.get(saleDate)==null)
			{
				// 如果没有，创建新的stockDayTrans，并添加trd到saleTransList中
				StockDayTrans sdt=new StockDayTrans();
				sdt.getSaleTransList().add(trd);
				stockDayTransMap.put(saleDate, sdt);
			}
			else
			{
				// 如果已存在，则取出stockDayTrans，并添加trd到saleTransList中
				StockDayTrans sdt=(StockDayTrans)stockDayTransMap.get(saleDate);
				sdt.getSaleTransList().add(trd);
				stockDayTransMap.put(saleDate, sdt);
			}			
			
		}
		
		// 处理每日买、卖交易，更新账户信息
		StockDayAccount sda=new StockDayAccount(100000);  // 初始10万元
		Map stockDayAccountMap=new TreeMap();
		Iterator it=stockDayTransMap.keySet().iterator();
		
		while(it.hasNext())
		{
			
			String transDate=(String)it.next();
			sda.setDate(transDate);		
			System.out.println("process date: "+transDate);
			
			StockDayTrans sdt=(StockDayTrans)stockDayTransMap.get(transDate);
			
			// 取出开盘要买入的股票列表，计算买入金额
			List buyTransList=sdt.getBuyTransList();  
			
			int buyTransCount=buyTransList.size();
			if (buyTransCount>0)
			{
				double eachStockMoney=sda.getCurrentCash()/buyTransCount;
				
				for (int j=0; j<buyTransCount; j++)
				{
					TransactionRecordData trd=(TransactionRecordData)buyTransList.get(j);
					String buyStockCode=trd.getStockcode();
					double buyPrice=trd.getBuySDD().getOpen();
					int buyShou=(int)(eachStockMoney/(100*buyPrice));
					
					double buyMoney=0;
					if (buyShou>0)
					{
						buyMoney=buyPrice*buyShou*100;
					}
					else
					{
						// 如果连一手都买不了，则不做计算，直接继续看下一个股票
						continue;
					}
					
					// 添加持股记录，并计算买入后的现金
					StockHoldData shd=new StockHoldData();
					shd.setStockcode(trd.getStockcode());
					shd.setStockname(trd.getBuySDD().getName());
					shd.setAmount(buyShou*100);
					shd.setTransNo(trd.getTransNo());	// 记录此股买入时的transNo
					shd.setBuyPrice(buyPrice);
					
					sda.currentCash=sda.currentCash-buyMoney*(1+0.0003); // 佣金0.03%
					sda.currentStockValue=sda.currentStockValue+buyMoney; 
					sda.currentStockHoldList.add(shd);
					sda.buyTransList.add(trd);
	
				}
				
			}
			
			// 取出收盘要卖出的股票列表，计算卖出金额
			List saleTransList=sdt.getSaleTransList();  
			
			int saleTransCount=saleTransList.size();
			if (saleTransCount>0)
			{
			
				// 处理卖出股票的交易
				for (int j=0; j<saleTransCount; j++)
				{
					TransactionRecordData saleTrd=(TransactionRecordData)saleTransList.get(j);
					String saleStockCode=saleTrd.getStockcode();
					double salePrice=saleTrd.getSaleSDD().getClose();
					
					double saleMoney=0;
					List stockHoldList=sda.getCurrentStockHoldList();
					
					for (int k=0; k<stockHoldList.size(); k++)
					{
						StockHoldData shd=(StockHoldData)stockHoldList.get(k);
						if (shd.getStockcode().equals(saleStockCode) && shd.getTransNo()==saleTrd.getTransNo())
						{
							
							saleMoney=salePrice*shd.getAmount()*(1-0.0013);  // 卖出时印花税0.1%, 佣金0.03%
							sda.currentCash=sda.currentCash+saleMoney;		// 卖出后现金增加					
							sda.saleTransList.add(saleTrd);							
							sda.currentStockHoldList.remove(shd);	 // 卖出后持股数减少
							
						}
					}
					
				}	
				
			}
			
			// 收盘后，整理当前仍然持有的股票信息，重新计算当前持股市值，及当前总资金
			double currentStockValue=0;
			List newStockHoldList=new ArrayList();
			for (int k=0; k<sda.currentStockHoldList.size(); k++)
			{
				StockHoldData shd=(StockHoldData)sda.currentStockHoldList.get(k);
				String stockcode=shd.getStockcode();
				StockDayData sdd=CommonTool.getStockDayData(stockcode, transDate);
				shd.setCurPrice(sdd.getClose());
				newStockHoldList.add(shd.clone());   // 必须把持股记录复制出来，放入新的列表中，之后再放入新复制的sda对象中，才能真正保留下数据，否则后面一改就全改了

				if (sdd==null)  // 股票停牌，则继续处理下一只股票（这个地方要再处理，应该把停牌前最后一天的数据带过来）
				{
					continue;
				}
				currentStockValue=currentStockValue+shd.getCurPrice()*shd.getAmount();  // 即时计算每一天的stock value值变化，因为stock value每天都会随着股价变化而变化
			}
			sda.currentStockValue=currentStockValue;
			sda.currentTotalValue=sda.currentCash+sda.currentStockValue;
			
			StockDayAccount newSda=(StockDayAccount)sda.clone();
			newSda.currentStockHoldList=newStockHoldList;
			stockDayAccountMap.put(transDate, newSda);
			
		}
		
		
		return stockDayAccountMap;
		
		
	}
	
	
	
}
