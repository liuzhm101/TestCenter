package com.finance.stock.gui;

import java.util.Map;
import java.util.TreeMap;

public class PersonalStockAccount {

	public String accountNo="A000101";  // �˻�����
	public String accountName="LiuZhiMing";  // �˻�����
	public int investMoney=1000000; // �˻�Ĭ�Ϲ�ƱͶ�ʽ��: 100��
//	public int holdCount=10;  // �˻�Ĭ�Ϲ�ƱͶ����: 10ֻ��Ʊ
	public int holdCount=1;  // �˻�Ĭ�Ϲ�ƱͶ����: 10ֻ��Ʊ

	public Map accountDataMap=new TreeMap();  // (date, accountDayData) ÿ���˻��仯���

	public Map getAccountDataMap() {
		return accountDataMap;
	}

	public void setAccountDataMap(Map accountDataMap) {
		this.accountDataMap = accountDataMap;
	}
	
	
	
}
