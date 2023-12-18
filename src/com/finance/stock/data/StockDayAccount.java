package com.finance.stock.data;

import java.util.*;

public class StockDayAccount implements Cloneable {

	public String date;
	
	public double currentCash;  // ÿ���ֽ� 
	public double currentStockValue;	// ÿ�չ�Ʊ��ֵ 
	public double currentTotalValue;  // ÿ�����˻�ֵ 
	
	public List currentStockHoldList=new ArrayList();  // ÿ�����ֹ̳��б� 
	public List buyTransList=new ArrayList();  // ÿ��ʵ�ʹ�Ʊ���뽻�׼�¼ 
	public List saleTransList=new ArrayList(); //  ÿ��ʵ�ʹ�Ʊ�������׼�¼ 

	public StockDayAccount(double initMoney)
	{
		// ��ʼ��stock account, ָ����ʼ�ʽ�
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
