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
			// ���ɻ���SAS���ݼ�
			String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
			String sasFileName="FundQuarterData_"+timeStr;
			String columnDef=fdm.getFundSqlColumnDef_all();
			CommonTool.createSASDataSet(fdm.fundAllDataFull, sasFileName, columnDef);
			CommonTool.insertDataToSASDataSet(fdm.fundAllDataFull, sasFileName, fundDataList);
			
			
			long endtime=System.currentTimeMillis();
			int time=(int)(endtime-starttime)/1000;
			System.out.println("Total time: "+time+"��");
			
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
		
		String date="";    // ��������
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
			
			if (line.contains("�������ڣ�"))   // ��ȡ�������ڣ� ������ �������ͣ� ����˾�� �ʲ���ģ
			{
//				System.out.println(line);
				
				fundBirthDate=CommonTool.getContentAfterText(line, "�������ڣ�");						
				fundManager=CommonTool.getContentAfterText(line, "������");			
				fundType=CommonTool.getContentAfterText(line, "���ͣ�");
				fundCompany=CommonTool.getContentAfterText(line, "�����ˣ�");
				fundScale=CommonTool.getContentAfterText(line, "�ʲ���ģ��");
				
			}
			
			if (line.contains("���ȹ�ƱͶ����ϸ"))   // ��ȡ�������ƣ����𹫲�ʱ��
			{
//				System.out.println(line);
				
				int firstSpacePos=line.indexOf(" ");
				fundName=line.substring(0, firstSpacePos);
//				System.out.println(fundName);
				
				int datePos=line.indexOf("��ֹ����")+4; 
				date=line.substring(datePos).trim();
//				System.out.println(date);
				
			}
			
			if (line.contains("�䶯����ɰ����鵵��"))
			{
//				System.out.println(line);
				FundDayData fdd=new FundDayData();
				
				fdd.setDate(date);
				
				fdd.setFundBirthDate(fundBirthDate);
				fdd.setFundCode(fundCode);
				fdd.setFundName(fundName);
				fdd.setFundCompany(fundCompany);
				fdd.setFundType(fundType);
				fdd.setFundScale(CommonTool.converToDoubleNumber(fundScale.trim().replace("��Ԫ", "")));
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
			else if (line.contains("�ɰ����鵵��"))
			{
//				System.out.println(line);
				FundDayData fdd=new FundDayData();
				
				fdd.setDate(date);
				
				fdd.setFundBirthDate(fundBirthDate);
				fdd.setFundCode(fundCode);
				fdd.setFundName(fundName);
				fdd.setFundCompany(fundCompany);
				fdd.setFundType(fundType);
				fdd.setFundScale(CommonTool.converToDoubleNumber(fundScale.trim().replace("��Ԫ", "")));
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
				CommonTool.getSqlStrColumnDef("fund_code", 12)+    // �������
				CommonTool.getSqlStrColumnDef("fund_name", 100)+	 // ��������
				CommonTool.getSqlStrColumnDef("fund_type", 12)+  // ��������
				CommonTool.getSqlStrColumnDef("fund_manager", 50)+	 // ������
				CommonTool.getSqlStrColumnDef("fund_company", 50)+	// ����˾
				CommonTool.getSqlNumberColumnDef("fund_scale")+	 // �����ģ
				CommonTool.getSqlStrColumnDef("fund_birthDate", 12)+	 // ���𴴽�����
				
				CommonTool.getSqlStrColumnDef("date", 12)+	// ����
				CommonTool.getSqlNumberColumnDef("stock_no", "int", "BEST12.")+	// ��Ʊ����
				CommonTool.getSqlStrColumnDef("stock_code", 12)+	// ��Ʊ����
				CommonTool.getSqlStrColumnDef("stock_name", 12)+	// ��Ʊ����
				CommonTool.getSqlNumberColumnDef("stock_percent")+	// ��Ʊռ��
				CommonTool.getSqlNumberColumnDef("stock_amount")+	// ��Ʊ����
				CommonTool.getSqlNumberColumnDef("stock_value").replace(",", "") // ��Ʊ���
				
		;
		
		return columnDef;
		
	}
	
	
	public String getFundSqlDataDef_all(FundDayData fdd)
	{
		String dataDef="";
	
		dataDef=
				CommonTool.getSqlStrDataDef(fdd.getFundCode())+    // �������
				CommonTool.getSqlStrDataDef(fdd.getFundName())+	   // ��������
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
