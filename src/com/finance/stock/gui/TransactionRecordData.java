package com.finance.stock.gui;

import java.util.List;

import com.finance.stock.data.*;

public class TransactionRecordData {

	String stockcode="";
	
	StockDayData buySDD;
	StockDayData saleSDD;
	StockSecondData buySSD;  // 买入日的集合竞价数据对象ssd
	StockSecondData saleSSD;  // 卖出日的集合竞价数据对象ssd
	
	List preStockDayDataList;  // 买入日前几天的股票数据对象list (顺序: b1,b2,b3...)
	List preIndexDayDataList;  // 买入日前几天的指数数据对象list (顺序: b1,b2,b3...)
	
	double maxDDR;
	double maxRUR;
	double profitPerYear;
	
	double transactionProfit;
	double transactionBuyPrice;
	double transactionSalePrice;

	String modelType;   // 模型类型
	String modelParam;  // 模型参数值
	double modelPrt;	// 模型优先级参数值
	double stockPrt;	// 个股优先级参数值
	double percentLimit;	// 模型资金百分比限制
	
	public String getModelType() {
		return modelType;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getModelParam() {
		return modelParam;
	}
	public void setModelParam(String modelParam) {
		this.modelParam = modelParam;
	}
	public double getModelPrt() {
		return modelPrt;
	}
	public void setModelPrt(double modelPrt) {
		this.modelPrt = modelPrt;
	}
	public double getStockPrt() {
		return stockPrt;
	}
	public void setStockPrt(double stockPrt) {
		this.stockPrt = stockPrt;
	}
	public double getPercentLimit() {
		return percentLimit;
	}
	public void setPercentLimit(double percentLimit) {
		this.percentLimit = percentLimit;
	}
	
	public double getTransactionProfit() {
		return transactionProfit;
	}
	public void setTransactionProfit(double transactionProfit) {
		this.transactionProfit = transactionProfit;
	}
	public double getTransactionBuyPrice() {
		return transactionBuyPrice;
	}
	public void setTransactionBuyPrice(double transactionBuyPrice) {
		this.transactionBuyPrice = transactionBuyPrice;
	}
	public double getTransactionSalePrice() {
		return transactionSalePrice;
	}
	public void setTransactionSalePrice(double transactionSalePrice) {
		this.transactionSalePrice = transactionSalePrice;
	}
	
	String transType="";  // 标记买、卖类型 buy, sale
	int transNo=0;  // 标记买、卖交易序号
	
	FundStatData fsd;	// 基金统计数据
	
	public StockSecondData getSaleSSD() {
		return saleSSD;
	}
	public void setSaleSSD(StockSecondData saleSSD) {
		this.saleSSD = saleSSD;
	}
	public List getPreStockDayDataList() {
		return preStockDayDataList;
	}
	public void setPreStockDayDataList(List preStockDayDataList) {
		this.preStockDayDataList = preStockDayDataList;
	}
	public List getPreIndexDayDataList() {
		return preIndexDayDataList;
	}
	public void setPreIndexDayDataList(List preIndexDayDataList) {
		this.preIndexDayDataList = preIndexDayDataList;
	}
	
	public StockSecondData getBuySSD() {
		return buySSD;
	}
	public void setBuySSD(StockSecondData buySSD) {
		this.buySSD = buySSD;
	}
	public double getMaxDDR() {
		return maxDDR;
	}
	public void setMaxDDR(double maxDDR) {
		this.maxDDR = maxDDR;
	}
	public double getMaxRUR() {
		return maxRUR;
	}
	public void setMaxRUR(double maxRUR) {
		this.maxRUR = maxRUR;
	}
	public double getProfitPerYear() {
		return profitPerYear;
	}
	public void setProfitPerYear(double profitPerYear) {
		this.profitPerYear = profitPerYear;
	}
	
	public FundStatData getFsd() {
		return fsd;
	}
	public void setFsd(FundStatData fsd) {
		this.fsd = fsd;
	}
	public int getTransNo() {
		return transNo;
	}
	public void setTransNo(int transNo) {
		this.transNo = transNo;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public StockSecondData getSsd() {
		return buySSD;
	}
	public void setSsd(StockSecondData ssd) {
		this.buySSD = buySSD;
	}
	
	public String getStockcode() {
		return stockcode;
	}
	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	public StockDayData getBuySDD() {
		return buySDD;
	}
	public void setBuySDD(StockDayData buySDD) {
		this.buySDD = buySDD;
	}
	public StockDayData getSaleSDD() {
		return saleSDD;
	}
	public void setSaleSDD(StockDayData saleSDD) {
		this.saleSDD = saleSDD;
	}
	
	
}
