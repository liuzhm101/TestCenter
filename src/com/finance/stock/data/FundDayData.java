package com.finance.stock.data;

public class FundDayData {

	String date;    // 季度日期
	
	String fundCode;
	String fundName;
	String fundCompany;
	String fundManager;
	double fundScale;
	String fundBirthDate;
	String fundType;

	double fundUnitPrice;  // 单位净值
	double fundGrandPrice;	// 累计净值
	double fundDailyRise;   // 当日涨跌幅
	
	int stockNo;			// 持股排名序号
	String stockCode;
	String stockName;
	double stockHoldPercent;  // 持股占比
	double stockHoldAmonut;  // 持股数：万股
	double stockHoldValue;  // 市值：万元 
	
	

	

	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockHoldPercent() {
		return stockHoldPercent;
	}
	public void setStockHoldPercent(double stockHoldPercent) {
		this.stockHoldPercent = stockHoldPercent;
	}
	public double getStockHoldAmount() {
		return stockHoldAmonut;
	}
	public void setStockHoldAmount(double stockHoldAmount) {
		this.stockHoldAmonut = stockHoldAmount;
	}
	public double getStockHoldValue() {
		return stockHoldValue;
	}
	public void setStockHoldValue(double stockHoldValue) {
		this.stockHoldValue = stockHoldValue;
	}

	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundCompany() {
		return fundCompany;
	}
	public void setFundCompany(String fundCompany) {
		this.fundCompany = fundCompany;
	}
	public String getFundManager() {
		return fundManager;
	}
	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}
	public double getFundScale() {
		return fundScale;
	}
	public void setFundScale(double fundScale) {
		this.fundScale = fundScale;
	}
	public String getFundBirthDate() {
		return fundBirthDate;
	}
	public void setFundBirthDate(String fundBirthDate) {
		this.fundBirthDate = fundBirthDate;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public double getFundUnitPrice() {
		return fundUnitPrice;
	}
	public void setFundUnitPrice(double fundUnitPrice) {
		this.fundUnitPrice = fundUnitPrice;
	}
	public double getFundGrandPrice() {
		return fundGrandPrice;
	}
	public void setFundGrandPrice(double fundGrandPrice) {
		this.fundGrandPrice = fundGrandPrice;
	}
	public double getFundDailyRise() {
		return fundDailyRise;
	}
	public void setFundDailyRise(double fundDailyRise) {
		this.fundDailyRise = fundDailyRise;
	}
	public int getStockNo() {
		return stockNo;
	}
	public void setStockNo(int stockNo) {
		this.stockNo = stockNo;
	}
	
}
