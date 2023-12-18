package com.finance.stock.data;

public class StockHoldData implements Cloneable{

	String stockcode;
	String stockname;
	String date;
	int number;
	String holdername;
	int amount;
	double percent;
	String type;
	
	String industry;
	String concept;
	String location; 
	
	int transNo;
	double buyPrice;
	double curPrice;
	
	public int getTransNo() {
		return transNo;
	}
	public void setTransNo(int transNo) {
		this.transNo = transNo;
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
	
	
	public String getStockcode() {
		return stockcode;
	}
	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHoldername() {
		return holdername;
	}
	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public Object clone() {  
		StockHoldData shd = null;  
		try{
			
			shd = (StockHoldData)super.clone();  
			
		}catch(CloneNotSupportedException e) {  
		    e.printStackTrace();  
		}  
		      return shd;  
	}  
	
}
