package com.finance.stock.gui;

import java.util.ArrayList;
import java.util.List;

public class AccountDayData {




	String date;		// ��������
	int posNum;			// �����������
	
	int cashValue;	  // ��������ʱ���ֽ��ֵ
	int stockValue;	  // ��������ʱ�Ĺ�Ʊ��ֵ
	int totalValue;	  // ��������ʱ���ܼ�ֵ
	
	List buyTransList=new ArrayList();		  // ��������뽻��
	List saleTransList=new ArrayList();		  // �������������
	List stockHoldList=new ArrayList();	      // ��������ʱ�ĳֹ����	
	
	
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
	
	// ���㵱ǰ���еĹ�Ʊ��ֵ
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
	
	// ���㵱ǰ�˻�����ֵ
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
