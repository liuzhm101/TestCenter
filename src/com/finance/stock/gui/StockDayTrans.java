package com.finance.stock.gui;

import java.util.ArrayList;
import java.util.List;

public class StockDayTrans {
	

	List buyTransList=new ArrayList();
	List saleTransList=new ArrayList();
	
	public List getBuyTransList() {
		return buyTransList;
	}

	public void setBuyTransList(List buyTransList) {
		this.buyTransList = buyTransList;
	}

	public List getSaleTransList() {
		return saleTransList;
	}

	public void setSaleTransList(List saleTransList) {
		this.saleTransList = saleTransList;
	}


}
