package com.finance.stock.data;

import java.util.*;

public class StockDayAccount implements Cloneable {

	public String date;
	
	public double currentCash;  // 每日现金 
	public double currentStockValue;	// 每日股票市值 
	public double currentTotalValue;  // 每日总账户值 
	
	public List currentStockHoldList=new ArrayList();  // 每日收盘持股列表 
	public List buyTransList=new ArrayList();  // 每日实际股票买入交易记录 
	public List saleTransList=new ArrayList(); //  每日实际股票卖出交易记录 

	public StockDayAccount(double initMoney)
	{
		// 初始化stock account, 指定初始资金
		currentCash=initMoney;
		currentTotalValue=currentCash+currentStockValue;
		
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public double getCurrentCash() {
		return currentCash;
	}
	public void setCurrentCash(double currentCash) {
		this.currentCash = currentCash;
	}
	public double getCurrentStockValue() {
		return currentStockValue;
	}
	public void setCurrentStockValue(double currentStockValue) {
		this.currentStockValue = currentStockValue;
	}
	public double getCurrentTotalValue() {
		return currentTotalValue;
	}
	public void setCurrentTotalValue(double currentTotalValue) {
		this.currentTotalValue = currentTotalValue;
	}
	public List getCurrentStockHoldList() {
		return currentStockHoldList;
	}
	public void setCurrentStockHoldList(List currentStockList) {
		this.currentStockHoldList = currentStockList;
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

	public Object clone() {  
		StockDayAccount sda = null;  
		try{
			
			sda = (StockDayAccount)super.clone();  
			
		}catch(CloneNotSupportedException e) {  
		    e.printStackTrace();  
		}  
		
		
		
		return sda;  
	}  
	
}
