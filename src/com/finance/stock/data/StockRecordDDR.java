package com.finance.stock.data;


public class StockRecordDDR {
	
	double DDR=0;
	StockDayData minSDD;    // ��ͼ۸���Ǹ�sdd��¼
	StockDayData curSDD;	// ��ǰ�۸���Ǹ�sdd��¼
	
	public double getDDR() {
		return DDR;
	}
	public void setDDR(double dDR) {
		DDR = dDR;
	}
	
	public StockDayData getMinSDD() {
		return minSDD;
	}
	public void setMinSDD(StockDayData minSDD) {
		this.minSDD = minSDD;
	}
	public StockDayData getCurSDD() {
		return curSDD;
	}
	public void setCurSDD(StockDayData curSDD) {
		this.curSDD = curSDD;
	}
	

}
