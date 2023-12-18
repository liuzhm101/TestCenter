package com.finance.stock.data;

public class StockYGProfitDayData {

	public String code;
	public String name;
	public String industry;
	public String concept;
	public String date;
	public String location;
	
	public double open;
	public double high;
	public double low;
	public double close;
	public double open_rise;
	public double high_rise;
	public double low_rise;
	public double close_rise;
	
	public double real_rise; // 实际上涨的阳柱或阴柱 real_rise=close_rise-open_rise
	
	public double af_close;
	public double pf_close;
	
	public double amount;
	public double money;
	public double change_ratio;
	public double liquid_value;
	public double total_value;
	
	public double ma_5;
	public double ma_10;
	public double ma_20;
	public double ma_30;
	public double ma_60;
	
	public double swing;
	public double eq_ratio;
	
	public int y_high;
	public int y_open;
	public int y_close;
	public int y_low;
	
	public int x_center;
	public int x_left;
	public int x_right;
	
	boolean isCenterDate=false;
	boolean isMaxHighDate=false;
	boolean isMinLowDate=false;
	boolean isMarkDate=false;
	
	boolean isTransDate=false;
	
	StockYGProfitDayData saleSDD;
	public double profit=0;
	public String count;
	
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public boolean isTransDate() {
		return isTransDate;
	}
	public void setTransDate(boolean isTransDate) {
		this.isTransDate = isTransDate;
	}

	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public StockYGProfitDayData getSaleSDD() {
		return saleSDD;
	}
	public void setSaleSDD(StockYGProfitDayData saleSDD) {
		this.saleSDD = saleSDD;
	}
	public boolean isMarkDate() {
		return isMarkDate;
	}
	public void setMarkDate(boolean isMarkDate) {
		this.isMarkDate = isMarkDate;
	}
	public int posNum=0;
	
	public int getPosNum() {
		return posNum;
	}
	public void setPosNum(int posNum) {
		this.posNum = posNum;
	}
	public int getY_high() {
		return y_high;
	}
	public void setY_high(int y_high) {
		this.y_high = y_high;
	}
	public int getY_open() {
		return y_open;
	}
	public void setY_open(int y_open) {
		this.y_open = y_open;
	}
	public int getY_close() {
		return y_close;
	}
	public void setY_close(int y_close) {
		this.y_close = y_close;
	}
	public int getY_low() {
		return y_low;
	}
	public void setY_low(int y_low) {
		this.y_low = y_low;
	}
	public int getX_center() {
		return x_center;
	}
	public void setX_center(int x_center) {
		this.x_center = x_center;
	}
	public int getX_left() {
		return x_left;
	}
	public void setX_left(int x_left) {
		this.x_left = x_left;
	}
	public int getX_right() {
		return x_right;
	}
	public void setX_right(int x_right) {
		this.x_right = x_right;
	}
	public boolean isCenterDate() {
		return isCenterDate;
	}
	public void setCenterDate(boolean isCenterDate) {
		this.isCenterDate = isCenterDate;
	}
	public boolean isMaxHighDate() {
		return isMaxHighDate;
	}
	public void setMaxHighDate(boolean isMaxHighDate) {
		this.isMaxHighDate = isMaxHighDate;
	}
	public boolean isMinLowDate() {
		return isMinLowDate;
	}
	public void setMinLowDate(boolean isMinLowDate) {
		this.isMinLowDate = isMinLowDate;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getOpen_rise() {
		return open_rise;
	}
	public void setOpen_rise(double open_rise) {
		this.open_rise = open_rise;
	}
	public double getHigh_rise() {
		return high_rise;
	}
	public void setHigh_rise(double high_rise) {
		this.high_rise = high_rise;
	}
	public double getLow_rise() {
		return low_rise;
	}
	public void setLow_rise(double low_rise) {
		this.low_rise = low_rise;
	}
	public double getClose_rise() {
		return close_rise;
	}
	public void setClose_rise(double close_rise) {
		this.close_rise = close_rise;
	}
	public double getAf_close() {
		return af_close;
	}
	public void setAf_close(double af_close) {
		this.af_close = af_close;
	}
	public double getPf_close() {
		return pf_close;
	}
	public void setPf_close(double pf_close) {
		this.pf_close = pf_close;
	}
	
	public double getReal_rise() {
		return real_rise;
	}
	public void setReal_rise(double real_rise) {
		this.real_rise = real_rise;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getChange_ratio() {
		return change_ratio;
	}
	public void setChange_ratio(double change_ratio) {
		this.change_ratio = change_ratio;
	}
	public double getLiquid_value() {
		return liquid_value;
	}
	public void setLiquid_value(double liquid_value) {
		this.liquid_value = liquid_value;
	}
	public double getTotal_value() {
		return total_value;
	}
	public void setTotal_value(double total_value) {
		this.total_value = total_value;
	}
	public double getMa_5() {
		return ma_5;
	}
	public void setMa_5(double ma_5) {
		this.ma_5 = ma_5;
	}
	public double getMa_10() {
		return ma_10;
	}
	public void setMa_10(double ma_10) {
		this.ma_10 = ma_10;
	}
	public double getMa_20() {
		return ma_20;
	}
	public void setMa_20(double ma_20) {
		this.ma_20 = ma_20;
	}
	public double getMa_30() {
		return ma_30;
	}
	public void setMa_30(double ma_30) {
		this.ma_30 = ma_30;
	}
	public double getMa_60() {
		return ma_60;
	}
	public void setMa_60(double ma_60) {
		this.ma_60 = ma_60;
	}
	public double getSwing() {
		return swing;
	}
	public void setSwing(double swing) {
		this.swing = swing;
	}
	public double getEq_ratio() {
		return eq_ratio;
	}
	public void setEq_ratio(double eq_ratio) {
		this.eq_ratio = eq_ratio;
	}

	
}
