package com.finance.stock.gui;

import java.util.*;
import com.finance.stock.data.*;

public class FundDataMaster {

	String fundAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\fundAllDataFull";
	
	public static void main(String args[])
	{
		
		FundDataMaster fdm=new FundDataMaster();
		
		try
		{
			
			long starttime=System.currentTimeMillis();
			
			List totalFundDayDataList=new ArrayList();
			
			List fileNames=FileTool.getFileNameList(fdm.fundAllDataFull+"\\Source");
			for (int f=0; f<fileNames.size(); f++)
			{
				String fileName=(String)fileNames.get(f);
				int dotPos=fileName.indexOf(".");
				String fileNameStr=fileName.substring(0, dotPos);
				
				List fundDayDataList=fdm.getFundDataFromFile(fileNameStr);
				
				for (int i=0; i<fundDayDataList.size(); i++)
				{
					FundDayData fdd=(FundDayData)fundDayDataList.get(i);
					System.out.println(fdd.getFundCode()+" "+fdd.getFundName()+" "+fdd.getFundType()+" "+fdd.getFundScale()+" "+fdd.getFundBirthDate()+" "+fdd.getFundManager()+" "+fdd.getFundCompany()+" "+
							fdd.getDate()+" "+fdd.getStockNo()+" "+fdd.getStockCode()+" "+fdd.getStockName()+" "+fdd.getStockHoldPercent()+" "+fdd.getStockHoldAmount()+" "+fdd.getStockHoldValue());
				}
				
				totalFundDayDataList.addAll(fundDayDataList);
				
			}

			List fundDataList=new ArrayList();
			for (int t=0; t<totalFundDayDataList.size(); t++)
			{
				FundDayData fdd=(FundDayData)totalFundDayDataList.get(t);
				String dataSqlStr=fdm.getFundSqlDataDef_all(fdd);
				fundDataList.add(dataSqlStr);
			}
			// 生成基金SAS数据集
			String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
			String sasFileName="FundQuarterData_"+timeStr;
			String columnDef=fdm.getFundSqlColumnDef_all();
			CommonTool.createSASDataSet(fdm.fundAllDataFull, sasFileName, columnDef);
			CommonTool.insertDataToSASDataSet(fdm.fundAllDataFull, sasFileName, fundDataList);
			
			
			long endtime=System.currentTimeMillis();
			int time=(int)(endtime-starttime)/1000;
			System.out.println("Total time: "+time+"秒");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}	
	
	public List getFundDataFromFile(String fileName)
	{
		
		String filePath=fundAllDataFull+"\\Source\\"+fileName+".txt";
		List lines=FileTool.readLinesFromFile(filePath);
		
		String date="";    // 季度日期
		String fundCode="";
		String fundName="";
		String fundCompany="";
		String fundManager="";
		String fundScale="";
		String fundBirthDate="";
		String fundType="";
		
		int firstPos=fileName.indexOf("_");
		fundCode=fileName.substring(0, firstPos);
		
		
		List fundDayDataList=new ArrayList();
		for (int i=0; i<lines.size(); i++)
		{
			String line=(String)lines.get(i);
			
			if (line.contains("成立日期："))   // 获取成立日期， 基金经理， 基金类型， 基金公司， 资产规模
			{
//				System.out.println(line);
				
				fundBirthDate=CommonTool.getContentAfterText(line, "成立日期：");						
				fundManager=CommonTool.getContentAfterText(line, "基金经理：");			
				fundType=CommonTool.getContentAfterText(line, "类型：");
				fundCompany=CommonTool.getContentAfterText(line, "管理人：");
				fundScale=CommonTool.getContentAfterText(line, "资产规模：");
				
			}
			
			if (line.contains("季度股票投资明细"))   // 获取基金名称，基金公布时间
			{
//				System.out.println(line);
				
				int firstSpacePos=line.indexOf(" ");
				fundName=line.substring(0, firstSpacePos);
//				System.out.println(fundName);
				
				int datePos=line.indexOf("截止至：")+4; 
				date=line.substring(datePos).trim();
//				System.out.println(date);
				
			}
			
			if (line.contains("变动详情股吧行情档案"))
			{
//				System.out.println(line);
				FundDayData fdd=new FundDayData();
				
				fdd.setDate(date);
				
				fdd.setFundBirthDate(fundBirthDate);
				fdd.setFundCode(fundCode);
				fdd.setFundName(fundName);
				fdd.setFundCompany(fundCompany);
				fdd.setFundType(fundType);
				fdd.setFundScale(CommonTool.converToDoubleNumber(fundScale.trim().replace("亿元", "")));
				fdd.setFundManager(fundManager);
				
				String[] stockData=line.split(" ");
				
				fdd.setStockNo(CommonTool.converToIntegerNumber(stockData[0]));
				fdd.setStockCode(stockData[1]);
				fdd.setStockName(stockData[2]);
				fdd.setStockHoldPercent(CommonTool.converToDoubleNumber(stockData[6].trim().replace("%", "")));
				fdd.setStockHoldAmount(CommonTool.converToDoubleNumber(stockData[7].trim().replace(",", "")));
				fdd.setStockHoldValue(CommonTool.converToDoubleNumber(stockData[8].trim().replace(",", "")));				 
				
				fundDayDataList.add(fdd);
			}
			else if (line.contains("股吧行情档案"))
			{
//				System.out.println(line);
				FundDayData fdd=new FundDayData();
				
				fdd.setDate(date);
				
				fdd.setFundBirthDate(fundBirthDate);
				fdd.setFundCode(fundCode);
				fdd.setFundName(fundName);
				fdd.setFundCompany(fundCompany);
				fdd.setFundType(fundType);
				fdd.setFundScale(CommonTool.converToDoubleNumber(fundScale.trim().replace("亿元", "")));
				fdd.setFundManager(fundManager);
				
				String[] stockData=line.split(" ");
				
				fdd.setStockNo(CommonTool.converToIntegerNumber(stockData[0]));
				fdd.setStockCode(stockData[1]);
				fdd.setStockName(stockData[2]);
				fdd.setStockHoldPercent(CommonTool.converToDoubleNumber(stockData[4].trim().replace("%", "")));
				fdd.setStockHoldAmount(CommonTool.converToDoubleNumber(stockData[5].trim().replace(",", "")));
				fdd.setStockHoldValue(CommonTool.converToDoubleNumber(stockData[6].trim().replace(",", "")));				
				
				fundDayDataList.add(fdd);
				
			}
			
		}
		
		return fundDayDataList;
		
	}
	
	
	public String getFundSqlColumnDef_all()
	{
		
		String columnDef="";
		
		columnDef=
				CommonTool.getSqlStrColumnDef("fund_code", 12)+    // 基金代码
				CommonTool.getSqlStrColumnDef("fund_name", 100)+	 // 基金名称
				CommonTool.getSqlStrColumnDef("fund_type", 12)+  // 基金类型
				CommonTool.getSqlStrColumnDef("fund_manager", 50)+	 // 基金经理
				CommonTool.getSqlStrColumnDef("fund_company", 50)+	// 基金公司
				CommonTool.getSqlNumberColumnDef("fund_scale")+	 // 基金规模
				CommonTool.getSqlStrColumnDef("fund_birthDate", 12)+	 // 基金创建日期
				
				CommonTool.getSqlStrColumnDef("date", 12)+	// 日期
				CommonTool.getSqlNumberColumnDef("stock_no", "int", "BEST12.")+	// 股票排名
				CommonTool.getSqlStrColumnDef("stock_code", 12)+	// 股票代码
				CommonTool.getSqlStrColumnDef("stock_name", 12)+	// 股票名称
				CommonTool.getSqlNumberColumnDef("stock_percent")+	// 股票占比
				CommonTool.getSqlNumberColumnDef("stock_amount")+	// 股票股数
				CommonTool.getSqlNumberColumnDef("stock_value").replace(",", "") // 股票金额
				
		;
		
		return columnDef;
		
	}
	
	
	public String getFundSqlDataDef_all(FundDayData fdd)
	{
		String dataDef="";
	
		dataDef=
				CommonTool.getSqlStrDataDef(fdd.getFundCode())+    // 基金代码
				CommonTool.getSqlStrDataDef(fdd.getFundName())+	   // 基金名称
				CommonTool.getSqlStrDataDef(fdd.getFundType())+
				CommonTool.getSqlStrDataDef(fdd.getFundManager())+
				CommonTool.getSqlStrDataDef(fdd.getFundCompany())+
				CommonTool.getSqlNumberDataDef(fdd.getFundScale()+"")+
				CommonTool.getSqlStrDataDef(fdd.getFundBirthDate())+
				CommonTool.getSqlStrDataDef(fdd.getDate())+
				CommonTool.getSqlNumberDataDef(fdd.getStockNo()+"")+
				CommonTool.getSqlStrDataDef(fdd.getStockCode())+
				CommonTool.getSqlStrDataDef(fdd.getStockName())+
				CommonTool.getSqlNumberDataDef(fdd.getStockHoldPercent()+"")+
				CommonTool.getSqlNumberDataDef(fdd.getStockHoldAmount()+"")+
				CommonTool.getSqlNumberDataDef(fdd.getStockHoldValue()+"").replace(",", "")
				
		;
		
		return dataDef;
		
	}
	
	
}
