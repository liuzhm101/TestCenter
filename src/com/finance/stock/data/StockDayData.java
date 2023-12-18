package com.finance.stock.data;

public class StockDayData {

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
	
	public double pastHigh;   // 过去交易最高价
	public double pastLow;
	public double pastHighAvg;  // 过去交易最高价平均值
	public double pastLowAvg;
	public double pastHighAvgEft;   // 过去交易最高价有效平均值
	public double pastLowAvgEft;
	

	public double pastHighPe;	// 过去交易最高市盈率
	public double pastLowPe;
	public double pastPeAvg;	// 过去交易市盈率平均值
	public double pastPeAvgEft;		// 过去交易最高市盈率有效平均值
	
	public double earnPerShare;  // 每股收益
	public double peAccFactor=1;  // pe累积系数 - 因收益增加导致的股价应上涨系数
	
	public double real_rise; // 实际上涨的阳柱或阴柱 real_rise=close_rise-open_rise
	
	public double af_close;
	public double pf_close;
	
	public double amount;
	public double money;
	public double change_ratio;
	public double liquid_value;
	public double total_value;
	

	public double pe_ratio;
	public double ps_ratio;
	public double px_ratio;
	public double pj_ratio;
	
	public double ma_5;
	public double ma_10;
	public double ma_20;
	public double ma_30;
	public double ma_60;
	
	public double ma_dif;
	public double ma_dea;
	public double ma_macd;
	public int ma_jcsc; // 1:金叉   -1:死叉   0:无值
	public double ma_ddz; // dea-dif 红蓝柱值
	
	public double kdj_k;
	public double kdj_d;
	public double kdj_j;
	public int kdj_jcsc; // 1:金叉   -1:死叉   0:无值

	public double wr6;	 // 1周
	public double wr10;	 // 半月
	public double wr20;	 // 1个月
	public double wr42;	 // 2个月
	public double wr100; // 5个月
	public double wr125; // 半年
	
	public double cci14;  // 14天的cci值
	
	public double swing;
	public double eq_ratio;
	
	public int y_high;
	public int y_open;
	public int y_close;
	public int y_low;
	
	public int x_center;
	public int x_left;
	public int x_right;
	
	public boolean isCenterDate=false;
	public boolean isMaxHighDate=false;
	public boolean isMinLowDate=false;
	public boolean isMarkDate=false;
	
	public boolean isTransDate=false;
	public boolean isBuyDate=false;
	public boolean isSaleDate=false;
	
	public StockDayData saleSDD;
	public double profit=0;
	public String count;
	
	public int rise_speed_rank=1;
	
	public int getRise_speed_rank() {
		return rise_speed_rank;
	}
	public void setRise_speed_rank(int rise_speed_rank) {
		this.rise_speed_rank = rise_speed_rank;
	}
	public double getPe_ratio() {
		return pe_ratio;
	}
	public void setPe_ratio(double pe_ratio) {
		this.pe_ratio = pe_ratio;
	}
	public double getPs_ratio() {
		return ps_ratio;
	}
	public void setPs_ratio(double ps_ratio) {
		this.ps_ratio = ps_ratio;
	}
	public double getPx_ratio() {
		return px_ratio;
	}
	public void setPx_ratio(double px_ratio) {
		this.px_ratio = px_ratio;
	}
	public double getPj_ratio() {
		return pj_ratio;
	}
	public void setPj_ratio(double pj_ratio) {
		this.pj_ratio = pj_ratio;
	}
	
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
	public boolean isBuyDate() {
		return isBuyDate;
	}
	public void setBuyDate(boolean isBuyDate) {
		this.isBuyDate = isBuyDate;
	}
	public boolean isSaleDate() {
		return isSaleDate;
	}
	public void setSaleDate(boolean isSaleDate) {
		this.isSaleDate = isSaleDate;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public StockDayData getSaleSDD() {
		return saleSDD;
	}
	public void setSaleSDD(StockDayData saleSDD) {
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
	public double getKdj_k() {
		return kdj_k;
	}
	public void setKdj_k(double kdj_k) {
		this.kdj_k = kdj_k;
	}
	public double getKdj_d() {
		return kdj_d;
	}
	public void setKdj_d(double kdj_d) {
		this.kdj_d = kdj_d;
	}
	public double getKdj_j() {
		return kdj_j;
	}
	public void setKdj_j(double kdj_j) {
		this.kdj_j = kdj_j;
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

	public double getMa_dif() {
		return ma_dif;
	}
	public void setMa_dif(double ma_dif) {
		this.ma_dif = ma_dif;
	}
	public double getMa_dea() {
		return ma_dea;
	}
	public void setMa_dea(double ma_dea) {
		this.ma_dea = ma_dea;
	}
	public double getMa_macd() {
		return ma_macd;
	}
	public void setMa_macd(double ma_macd) {
		this.ma_macd = ma_macd;
	}
	public int getMa_jcsc() {
		return ma_jcsc;
	}
	public void setMa_jcsc(int ma_jcsc) {
		this.ma_jcsc = ma_jcsc;
	}
	public int getKdj_jcsc() {
		return kdj_jcsc;
	}
	public void setKdj_jcsc(int kdj_jcsc) {
		this.kdj_jcsc = kdj_jcsc;
	}
	public double getMa_ddz() {
		return ma_ddz;
	}
	public void setMa_ddz(double ma_ddz) {
		this.ma_ddz = ma_ddz;
	}
	
	public double getPastHigh() {
		return pastHigh;
	}
	public void setPastHigh(double pastHigh) {
		this.pastHigh = pastHigh;
	}
	public double getPastLow() {
		return pastLow;
	}
	public void setPastLow(double pastLow) {
		this.pastLow = pastLow;
	}
	public double getPastHighAvg() {
		return pastHighAvg;
	}
	public void setPastHighAvg(double pastHighAvg) {
		this.pastHighAvg = pastHighAvg;
	}
	public double getPastLowAvg() {
		return pastLowAvg;
	}
	public void setPastLowAvg(double pastLowAvg) {
		this.pastLowAvg = pastLowAvg;
	}
	public double getPastHighAvgEft() {
		return pastHighAvgEft;
	}
	public void setPastHighAvgEft(double pastHighAvgEft) {
		this.pastHighAvgEft = pastHighAvgEft;
	}
	public double getPastLowAvgEft() {
		return pastLowAvgEft;
	}
	public void setPastLowAvgEft(double pastLowAvgEft) {
		this.pastLowAvgEft = pastLowAvgEft;
	}
	public double getPastHighPe() {
		return pastHighPe;
	}
	public void setPastHighPe(double pastHighPe) {
		this.pastHighPe = pastHighPe;
	}
	public double getPastLowPe() {
		return pastLowPe;
	}
	public void setPastLowPe(double pastLowPe) {
		this.pastLowPe = pastLowPe;
	}

	public double getPastPeAvg() {
		return pastPeAvg;
	}
	public void setPastPeAvg(double pastPeAvg) {
		this.pastPeAvg = pastPeAvg;
	}
	public double getPastPeAvgEft() {
		return pastPeAvgEft;
	}
	public void setPastPeAvgEft(double pastPeAvgEft) {
		this.pastPeAvgEft = pastPeAvgEft;
	}
	
	public double getEarnPerShare() {
		return earnPerShare;
	}
	public void setEarnPerShare(double earnPerShare) {
		this.earnPerShare = earnPerShare;
	}
	public double getPeAccFactor() {
		return peAccFactor;
	}
	public void setPeAccFactor(double peAccFactor) {
		this.peAccFactor = peAccFactor;
	}
	
	public double getWR6() {
		return wr6;
	}
	public void setWR6(double wr6) {
		this.wr6 = wr6;
	}
	
	public double getWR10() {
		return wr10;
	}
	public void setWR10(double wr10) {
		this.wr10 = wr10;
	}
	
	public double getWR20() {
		return wr20;
	}
	public void setWR20(double wr20) {
		this.wr20 = wr20;
	}
	
	public double getWR42() {
		return wr42;
	}
	public void setWR42(double wr42) {
		this.wr42 = wr42;
	}
	
	public double getWR100() {
		return wr100;
	}
	public void setWR100(double wr100) {
		this.wr100 = wr100;
	}
	
	public double getWR125() {
		return wr125;
	}
	public void setWR125(double wr) {
		this.wr125 = wr;
	}

	public double getCCI14() {
		return cci14;
	}
	public void setCCI14(double cci14) {
		this.cci14 = cci14;
	}
	
}
