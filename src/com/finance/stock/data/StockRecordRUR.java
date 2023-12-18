package com.finance.stock.data;


public class StockRecordRUR {
	
	double RUR=0;
	StockDayData maxSDD;
	StockDayData curSDD;
	
	public double getRUR() {
		return RUR;
	}
	public void setRUR(double RUR) {
		this.RUR = RUR;
	}
	public StockDayData getMaxSDD() {
		return maxSDD;
	}
	public void setMaxSDD(StockDayData maxSDD) {
		this.maxSDD = maxSDD;
	}
	public StockDayData getCurSDD() {
		return curSDD;
	}
	public void setCurSDD(StockDayData curSDD) {
		this.curSDD = curSDD;
	}
	

}
