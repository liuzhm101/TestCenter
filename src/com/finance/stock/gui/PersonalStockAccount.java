package com.finance.stock.gui;

import java.util.Map;
import java.util.TreeMap;

public class PersonalStockAccount {

	public String accountNo="A000101";  // 账户代码
	public String accountName="LiuZhiMing";  // 账户名称
	public int investMoney=1000000; // 账户默认股票投资金额: 100万
//	public int holdCount=10;  // 账户默认股票投资数: 10只股票
	public int holdCount=1;  // 账户默认股票投资数: 10只股票

	public Map accountDataMap=new TreeMap();  // (date, accountDayData) 每日账户变化情况

	public Map getAccountDataMap() {
		return accountDataMap;
	}

	public void setAccountDataMap(Map accountDataMap) {
		this.accountDataMap = accountDataMap;
	}
	
	
	
}
