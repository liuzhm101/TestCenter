package com.finance.stock.gui;

import java.util.*;

import com.finance.stock.data.StockDayAccount;
import com.finance.stock.data.StockDayData;
import com.finance.stock.data.StockHoldData;


public class AIQuantBot {

	
	public Map AIgenerateStockDayAccountMap(List transactionRecordDataList)
	{
		
		Map stockDayTransMap=new TreeMap(); // �ṹ�� date, stockDayTrans����(�ں�buyTransList, saleTransList����)
		
		// ��TransactionRecordDataList �Խ��׽��а��շ���
		for (int i=0; i<transactionRecordDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionRecordDataList.get(i);
			String buyDate=trd.getBuySDD().getDate();	// ȡ����������
			String saleDate=trd.getSaleSDD().getDate();		// ȡ����������
			trd.setTransNo(i);		// ��¼���׺�
			System.out.println("Handle Transaction: "+i+" "+buyDate);
			
			trd.setTransType(StockKey.buyType);  // ��Ϊ�����¼���뵽������StockDayTrans��buyTransList��
			if (stockDayTransMap.get(buyDate)==null)
			{
				// ���û�У������µ�stockDayTrans�������trd��buyTransList��
				StockDayTrans sdt=new StockDayTrans();
				sdt.getBuyTransList().add(trd);
				stockDayTransMap.put(buyDate, sdt);
			}
			else
			{
				// ����Ѵ��ڣ���ȡ��stockDayTrans�������trd��buyTransList��
				StockDayTrans sdt=(StockDayTrans)stockDayTransMap.get(buyDate);
				sdt.getBuyTransList().add(trd);
				stockDayTransMap.put(buyDate, sdt);
			}
			
			trd.setTransType(StockKey.saleType);  // ͬʱ��Ϊ������¼���뵽������StockDayTrans��saleTransList��
			if (stockDayTransMap.get(saleDate)==null)
			{
				// ���û�У������µ�stockDayTrans�������trd��saleTransList��
				StockDayTrans sdt=new StockDayTrans();
				sdt.getSaleTransList().add(trd);
				stockDayTransMap.put(saleDate, sdt);
			}
			else
			{
				// ����Ѵ��ڣ���ȡ��stockDayTrans�������trd��saleTransList��
				StockDayTrans sdt=(StockDayTrans)stockDayTransMap.get(saleDate);
				sdt.getSaleTransList().add(trd);
				stockDayTransMap.put(saleDate, sdt);
			}			
			
		}
		
		// ����ÿ���������ף������˻���Ϣ
		StockDayAccount sda=new StockDayAccount(100000);  // ��ʼ10��Ԫ
		Map stockDayAccountMap=new TreeMap();
		Iterator it=stockDayTransMap.keySet().iterator();
		
		while(it.hasNext())
		{
			
			String transDate=(String)it.next();
			sda.setDate(transDate);		
			System.out.println("process date: "+transDate);
			
			StockDayTrans sdt=(StockDayTrans)stockDayTransMap.get(transDate);
			
			// ȡ������Ҫ����Ĺ�Ʊ�б�����������
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
						// �����һ�ֶ����ˣ��������㣬ֱ�Ӽ�������һ����Ʊ
						continue;
					}
					
					// ��ӳֹɼ�¼���������������ֽ�
					StockHoldData shd=new StockHoldData();
					shd.setStockcode(trd.getStockcode());
					shd.setStockname(trd.getBuySDD().getName());
					shd.setAmount(buyShou*100);
					shd.setTransNo(trd.getTransNo());	// ��¼�˹�����ʱ��transNo
					shd.setBuyPrice(buyPrice);
					
					sda.currentCash=sda.currentCash-buyMoney*(1+0.0003); // Ӷ��0.03%
					sda.currentStockValue=sda.currentStockValue+buyMoney; 
					sda.currentStockHoldList.add(shd);
					sda.buyTransList.add(trd);
	
				}
				
			}
			
			// ȡ������Ҫ�����Ĺ�Ʊ�б������������
			List saleTransList=sdt.getSaleTransList();  
			
			int saleTransCount=saleTransList.size();
			if (saleTransCount>0)
			{
			
				// ����������Ʊ�Ľ���
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
							
							saleMoney=salePrice*shd.getAmount()*(1-0.0013);  // ����ʱӡ��˰0.1%, Ӷ��0.03%
							sda.currentCash=sda.currentCash+saleMoney;		// �������ֽ�����					
							sda.saleTransList.add(saleTrd);							
							sda.currentStockHoldList.remove(shd);	 // ������ֹ�������
							
						}
					}
					
				}	
				
			}
			
			// ���̺�����ǰ��Ȼ���еĹ�Ʊ��Ϣ�����¼��㵱ǰ�ֹ���ֵ������ǰ���ʽ�
			double currentStockValue=0;
			List newStockHoldList=new ArrayList();
			for (int k=0; k<sda.currentStockHoldList.size(); k++)
			{
				StockHoldData shd=(StockHoldData)sda.currentStockHoldList.get(k);
				String stockcode=shd.getStockcode();
				StockDayData sdd=CommonTool.getStockDayData(stockcode, transDate);
				shd.setCurPrice(sdd.getClose());
				newStockHoldList.add(shd.clone());   // ����ѳֹɼ�¼���Ƴ����������µ��б��У�֮���ٷ����¸��Ƶ�sda�����У������������������ݣ��������һ�ľ�ȫ����

				if (sdd==null)  // ��Ʊͣ�ƣ������������һֻ��Ʊ������ط�Ҫ�ٴ���Ӧ�ð�ͣ��ǰ���һ������ݴ�������
				{
					continue;
				}
				currentStockValue=currentStockValue+shd.getCurPrice()*shd.getAmount();  // ��ʱ����ÿһ���stock valueֵ�仯����Ϊstock valueÿ�춼�����Źɼ۱仯���仯
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
