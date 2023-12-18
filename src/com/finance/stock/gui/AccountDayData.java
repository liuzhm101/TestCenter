package com.finance.stock.gui;

import java.util.ArrayList;
import java.util.List;

public class AccountDayData {




	String date;		// 交易日期
	int posNum;			// 交易日期序号
	
	int cashValue;	  // 当天收盘时的现金价值
	int stockValue;	  // 当天收盘时的股票价值
	int totalValue;	  // 当天收盘时的总价值
	
	List buyTransList=new ArrayList();		  // 当天的买入交易
	List saleTransList=new ArrayList();		  // 当天的卖出交易
	List stockHoldList=new ArrayList();	      // 当天收盘时的持股情况	
	
	
	public void setCashValue(int cashValue) {
		this.cashValue = cashValue;
	}
	
	public int getCashValue()
	{
		return cashValue;
	}
	
	public void setStockValue(int stockValue) {
		this.stockValue = stockValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	// 计算当前持有的股票市值
	public int getStockValue()
	{
		
		int stockValue=0;
		
		for (int i=0; i<stockHoldList.size(); i++)
		{
			StockHoldShare shs=(StockHoldShare)stockHoldList.get(i);
			int stockHoldValue=(int)shs.getCurPrice()*shs.getAmount();
			stockValue=stockValue+stockHoldValue;
		}
		
		return stockValue;
		
	}
	
	// 计算当前账户的总值
	public int getTotalValue()
	{
		int totalValue=0;
		
		totalValue=getCashValue()+getStockValue();
		
		return totalValue;		
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPosNum() {
		return posNum;
	}

	public void setPosNum(int posNum) {
		this.posNum = posNum;
	}

	public List getBuyTransList() {
		return buyTransList;
	}

	public void setBuyTransList(List buyTransList) {
		this.buyTransList = buyTransList;
	}

	public List getSaleTransList() {
		return saleTransList;
	}

	public void setSaleTransList(List saleTransList) {
		this.saleTransList = saleTransList;
	}

	public List getStockHoldList() {
		return stockHoldList;
	}

	public void setStockHoldList(List stockHoldList) {
		this.stockHoldList = stockHoldList;
	}
	

}
