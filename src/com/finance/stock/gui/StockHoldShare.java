package com.finance.stock.gui;

import com.finance.stock.data.StockDayData;

public class StockHoldShare {


	String code;
	String name;
	String buyDate;   // ��������
	String curDate;   // ��ǰ����
	double buyPrice;  // ����ÿ�ɼ۸�
	double curPrice;  // ��ǰÿ�ɼ۸�
	int amount;   // ���ж��ٹ�

	StockDayData buySDD;  // �����յ�sdd

	public StockDayData getBuySDD() {
		return buySDD;
	}
	public void setBuySDD(StockDayData buySDD) {
		this.buySDD = buySDD;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getCurPrice() {
		return curPrice;
	}
	public void setCurPrice(double curPrice) {
		this.curPrice = curPrice;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getCurDate() {
		return curDate;
	}
	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
