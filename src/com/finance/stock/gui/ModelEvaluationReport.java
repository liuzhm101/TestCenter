package com.finance.stock.gui;

import java.util.List;

public class ModelEvaluationReport {


	String modelName;
	List transactionDataList;
	String reportLine;
	
	
	public List getTransactionDataList() {
		return transactionDataList;
	}

	public void setTransactionDataList(List transactionDataList) {
		this.transactionDataList = transactionDataList;
	}

	public String getReportLine() {
		return reportLine;
	}

	public void setReportLine(String reportLine) {
		this.reportLine = reportLine;
	}
	
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	


}
