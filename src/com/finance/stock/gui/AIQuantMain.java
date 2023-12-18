package com.finance.stock.gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.finance.stock.data.StockDayData;

public class AIQuantMain {

	String stockAllDataCode="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode";
	String stockAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull";
	String stockDayDataURL="http://yucezhe.com/api/v1/data/today?email=liuzhm101@163.com&name=overview-data-push&key=9HlfqPr1DDBqww9jl692lLPdJ9L9UJQV";

	
	public static void main(String args[])
	{
		try
		{
//			System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\AIQuantMainOut.log")));
			System.setErr(new PrintStream(new FileOutputStream("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\Log\\AIQuantMainErr.log")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		AIQuantMain aiqm=new AIQuantMain();
		
		// ��������
		String dateStr=CommonTool.getCurrentDate().substring(0, 10).replace("-", "");
		
		// �Զ����е������ݸ��¼��г��۲�
//		aiqm.autoRunDailyUpdateJob();	
		
		// �ֶ��������ݸ��¼��г��۲�
//		aiqm.manualRunDailyUpdateJob(dateStr, dateStr);  
		aiqm.manualRunDailyUpdateJob("20200301", "20200304");  // �ֶ�������ĳ��ʱ���Daily����
		
//		aiqm.manualRunDeleteDailyData("2018/05/25"); 
		
//		aiqm.manualRunHistoryCreateDataset();   // �ٶ�̫����������SAS����ת��CSVΪ���ݼ���	

//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index000001");
//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index399001");		
//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index399005");
//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index399006");
		
//		aiqm.manualRunSearchStockByModel_yg("2018/01/11", "2018/01/19");
		
		// �������µĹ�Ʊ�����б�
		aiqm.processRecreateStockList();
		aiqm.processRecreateStockListFull();
		
		// �����г���ؼ�¼
		MarketMonitor mm=new MarketMonitor();
		mm.monitorMarket("2020/03/01", "2020/03/04");
		
	}
	
		public void autoRunDailyUpdateJob()
		{
			
	//		while(true)
			{
				
				String dateStr=CommonTool.getCurrentDate().substring(0, 10).replace("-", "");   // ��ʽ��"20180108"
				String curDateStr=CommonTool.getCurrentDate().substring(0, 10).replace("-", "/");	// ��ʽ��"2018/01/08"
				System.out.println("Loop detecting data of date: "+dateStr+" ...... ");
				
				String zipFilePath=stockAllDataCode+"\\Zip\\"+dateStr+".zip";
				File f=new File(zipFilePath);
				
				if (!f.exists())  // ���zip�ļ������ڣ���ʼ�������ص����zip�ļ�����
				{			
					System.out.println("Try to download data zip file...");
					try
					{
						// ���ص����zip���ݰ�
						boolean result=FileTool.downloadZipFileFromURL(stockDayDataURL, zipFilePath);
						
						// ����zip������,��ѹ������ȡ���������
						if (result==true)
						{
							
							// ÿ�����ݸ��²���
							long starttime=System.currentTimeMillis();
							
							System.out.println("Successfully download data zip file.");
							processAddDailyData(dateStr); 
							
							processRecreateStockList();
							processRecreateStockListFull(); 
	
							long endtime=System.currentTimeMillis();
							int time=(int)(endtime-starttime)/1000;
							
						
							// ÿ���г��۲ⱨ�沿��
							long starttime1=System.currentTimeMillis();
							
							MarketMonitor mm=new MarketMonitor();
							mm.monitorMarket(curDateStr);
							
							long endtime1=System.currentTimeMillis();
							int time1=(int)(endtime1-starttime1)/1000;
							
							
							// ģ��ѡ�ɲ���
							long starttime2=System.currentTimeMillis();
							
							ModelCenter mc=new ModelCenter();
							mc.searchDataByModel_yg(curDateStr, curDateStr);
							
							long endtime2=System.currentTimeMillis();
							int time2=(int)(endtime2-starttime2)/1000;
							
							System.out.println("Total time (Update Daily Data): "+time+"��");
							System.out.println("Total time (Monitor Market): "+time1+"��");
							System.out.println("Total time (Model Search Stock): "+time2+"��");
	
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				else
				{
					System.out.println(dateStr+" Zip file has existed.");
					
				}
				
					
				try 
				{
				    Thread.sleep(600000);                 //10���Ӻ����
				} 
				catch(InterruptedException ex) 
				{
				    Thread.currentThread().interrupt();
				}
				
			}
			
		}
	
	public void manualRunDailyUpdateJob(String startDate, String endDate)
	{
		
		String zipFolderPath=stockAllDataCode+"\\Zip";
		List fileNames=FileTool.getFileNameList(zipFolderPath);
		
		for (int i=0; i<fileNames.size(); i++)
		{
			String newDate=fileNames.get(i).toString().substring(0, 8);  // "20180119.zip" ȡǰ8λ
			String curDateStr=newDate.substring(0,4)+"/"+newDate.substring(4,6)+"/"+newDate.substring(6,8); // ��ʽ��"2018/01/19"
			
			if (newDate.compareTo(startDate)>=0 && newDate.compareTo(endDate)<=0)
			{
				
				
				// ÿ�����ݸ��²���
				long starttime=System.currentTimeMillis();
				
				processAddDailyData(newDate); 
				
//				processRecreateStockList();
//				processRecreateStockListFull(); 

				long endtime=System.currentTimeMillis();
				int time=(int)(endtime-starttime)/1000;
				
			
				// ÿ���г��۲ⱨ�沿��
				long starttime1=System.currentTimeMillis();
				
//				MarketMonitor mm=new MarketMonitor();
//				mm.monitorMarket(curDateStr);
				
				long endtime1=System.currentTimeMillis();
				int time1=(int)(endtime1-starttime1)/1000;
				
				
				// ģ��ѡ�ɲ���
				long starttime2=System.currentTimeMillis();
				
//				ModelCenter mc=new ModelCenter();
//				mc.searchDataByModel_yg(curDateStr, curDateStr);
				
				long endtime2=System.currentTimeMillis();
				int time2=(int)(endtime2-starttime2)/1000;
				
				System.out.println("Total time (Update Daily Data): "+time+"��");
				System.out.println("Total time (Monitor Market): "+time1+"��");
				System.out.println("Total time (Model Search Stock): "+time2+"��");
				
			}
			
		}
		
	}
	
	public void manualRunDeleteDailyData(String dateStr)
	{
	
		String fileFolder=stockAllDataFull+"\\test";
//		FileTool.deleteDailyData(fileFolder, dateStr);

		fileFolder=stockAllDataFull+"\\index";
		FileTool.deleteDailyData(fileFolder, dateStr);		
		
//		fileFolder=stockAllDataFull+"\\000";
//		FileTool.deleteDailyData(fileFolder, dateStr);
		
//		fileFolder=stockAllDataFull+"\\002";
//		FileTool.deleteDailyData(fileFolder, dateStr);
//		
//		fileFolder=stockAllDataFull+"\\600";
//		FileTool.deleteDailyData(fileFolder, dateStr);
//		
//		fileFolder=stockAllDataFull+"\\300";
//		FileTool.deleteDailyData(fileFolder, dateStr);
		
		fileFolder=stockAllDataFull+"\\all";
		FileTool.deleteDailyData(fileFolder, dateStr);

		
	}
	
	public void manualRunAddDailyDataForCode(String startDate, String endDate, String code)
	{
		
		String newFolderPath=stockAllDataFull+"\\new";
		List fileNames=FileTool.getFileNameList(newFolderPath);
		
		for (int i=0; i<fileNames.size(); i++)
		{
			String newDate=fileNames.get(i).toString();
			
			if (newDate.compareTo(startDate)>=0 && newDate.compareTo(endDate)<=0)
			{
				// ���� new ����
				processAddDailyDataForCode(newDate, code);
				
			}
			
		}
		
			
	}
	
	public void manualRunSearchStockByModel_yg(String startDate, String endDate)
	{
		
		// ģ��ѡ�ɲ���
		long starttime2=System.currentTimeMillis();
		
		ModelCenter mc=new ModelCenter();
		mc.searchDataByModel_yg(startDate, endDate);
		
		long endtime2=System.currentTimeMillis();
		int time2=(int)(endtime2-starttime2)/1000;
		
		
		
	}
	
	public void manualRunHistoryCreateDataset()
	{
		
//		processCreateHistoryData("600");
//		processCreateHistoryData("000");
//		processCreateHistoryData("002");
//		processCreateHistoryData("300");
		
		
	}
	
	public void processCreateHistoryData(String type)
	{
		
		String dataFolderPath=stockAllDataFull+"\\"+type;
		List fileNames=FileTool.getFileNameList(dataFolderPath);
		
		int totalMaxlen=0;
		for (int i=0; i<fileNames.size(); i++)
//		for (int i=0; i<200; i++)
		{
			
			String csvFileName=(String)fileNames.get(i);
			String sasFileName=csvFileName.substring(0, csvFileName.indexOf("."));

			// ��ȡһֻ��Ʊ����ʷȫ��sdd��¼����
			List csvLines=FileTool.readLinesFromFile(dataFolderPath+"\\"+csvFileName);
			List transDataList=new ArrayList();
			int maxlen=0;
			for (int j=1; j<csvLines.size(); j++)
			{

				// ��ȡһ��csv����
				String dataLine=csvLines.get(j).toString();
				String[] stockColData=dataLine.split(",");
				
				if (stockColData.length<48)
					continue;
				
				// ���뵽���ݼ���
				String dataDef=getStockSqlDataDef_history(stockColData);
//				maxlen=Math.max(maxlen, stockColData[5].length());
				System.out.println(dataDef);
				
				transDataList.add(dataDef);
			}
//			System.out.println(maxlen);
//			totalMaxlen=Math.max(maxlen, totalMaxlen);
			
			// ����һֻ��Ʊ��SAS���ݼ�
			String columnDef=getStockSqlColumnDef_history();
			CommonTool.createSASDataSet(dataFolderPath, sasFileName, columnDef);
			CommonTool.insertDataToSASDataSet(dataFolderPath, sasFileName, transDataList);
			
		}
		
		System.out.println("totalMaxlen: "+totalMaxlen);
		
		
	}
	
	public void processRecreateStockList()
	{
		String allFolderPath=stockAllDataFull+"\\all";
		List<String> fileNames=FileTool.getFileNameList(allFolderPath);
		if (fileNames.size()==0)
		{
			System.out.println("No data files.");
			return;
		}
		
		String stockListFileName="stockcodelist";
		String columnDef=CommonTool.getSqlStrColumnDef("stockcode", 12, "$12.").replace(",", "");
		CommonTool.createSASDataSet(stockAllDataFull, stockListFileName, columnDef);
		List dataList=new ArrayList();
		for (int i=0; i<fileNames.size(); i++)
		{
			String fileName=fileNames.get(i);
			if (fileName.startsWith("stock") && fileName.endsWith(".sas7bdat"))
			{
				
//				List sddList=CommonTool.getStockDataRecordList(allFolderPath, fileName.substring(0, 11));
//				if (sddList.size()>0)
//				{
//					StockDayData sdd=(StockDayData)sddList.get(0);
//					System.out.println(sdd.getCode()+" "+sdd.getName());
//				}
				
				String code=fileName.substring(5, 11);
				String codeStr="";
				if (code.startsWith("6"))
				{
					codeStr="sh"+code;
				}
				else
				{
					codeStr="sz"+code;
				}
				
				System.out.println(codeStr);
				
				String dataDef=CommonTool.getSqlStrDataDef(codeStr);
				dataList.add(dataDef.replace(",", ""));
			}
			
			
		}
		
		Collections.sort(dataList);
		
		CommonTool.insertDataToSASDataSet(stockAllDataFull, stockListFileName, dataList);
		
	}
	
	public void processRecreateStockListFull()
	{
		
		String allFolderPath=stockAllDataFull+"\\all";
		List<String> fileNames=FileTool.getFileNameList(allFolderPath);
		if (fileNames.size()==0)
		{
			System.out.println("No data files.");
			return;
		}
		
		String stockListFileName="stockcodelist_full";
		String columnDef=CommonTool.getSqlStrColumnDef("stockcode", 12)+    // ��Ʊ����
				CommonTool.getSqlStrColumnDef("stockname", 12)+	 // ��Ʊ����
				CommonTool.getSqlStrColumnDef("industry", 30)+	 // ��ҵ
				CommonTool.getSqlStrColumnDef("concept", 200)+	 // ����
				CommonTool.getSqlStrColumnDef("location", 20).replace(",", "")	 // ����
				;
		
		CommonTool.createSASDataSet(stockAllDataFull, stockListFileName, columnDef);
		List dataList=new ArrayList();
		for (int i=0; i<fileNames.size(); i++)
		{
			String fileName=fileNames.get(i);
			if (fileName.startsWith("stock") && fileName.endsWith(".sas7bdat"))
			{
				
				List sddList=CommonTool.getStockDataRecordList_forStockCodeListFull(allFolderPath, fileName.substring(0, 11));
				if (sddList.size()>0)
				{
					StockDayData sdd=(StockDayData)sddList.get(0);
					System.out.println(sdd.getCode()+" "+sdd.getName());
				
				
					String dataDef=CommonTool.getSqlStrDataDef(sdd.getCode())+
						CommonTool.getSqlStrDataDef(sdd.getName())+
						CommonTool.getSqlStrDataDef(sdd.getIndustry())+
						CommonTool.getSqlStrDataDef(sdd.getConcept())+
						CommonTool.getSqlStrDataDef(sdd.getLocation()).replace(",", "")
						;
				
					dataList.add(dataDef);
				
				}
				
			}
				
		}
		
		CommonTool.insertDataToSASDataSet(stockAllDataFull, stockListFileName, dataList);
		
	}
	
	public void processAddDailyData(String date)
	{
		
		String zipFilePath=stockAllDataCode+"\\Zip\\"+date+".zip";
		String newFolderPath=stockAllDataFull+"\\new\\"+date;
		
		File f=new File(zipFilePath);

		// ��ѹ��ÿ��zip�ļ������޸��ļ�����ȥ�ո�
		try
		{
				
			// ��newĿ¼�´���dateĿ¼
			File newFolder=new File(newFolderPath);
			if (!newFolder.exists())
			{
				newFolder.mkdir();
			}
			
			// ��ѹ��zip����newĿ¼��
			String cmdStr="\"C:\\Program Files (x86)\\WinRAR\\WinRAR.exe\"  e  "+zipFilePath+" "+newFolderPath;
			CommonTool.executeCommand(cmdStr);
			
			try 
			{
				// ��10���ѹ��Ϻ��ټ���
			    Thread.sleep(5000);                 
			} 
			catch(InterruptedException e) 
			{
			    e.printStackTrace();
			}
			
			
			// ����ѹ��Ŀ¼�µ��ļ��Ƿ����
			List<String> fileNames=FileTool.getFileNameList(newFolderPath);
			if (fileNames.size()==0)
			{
				System.out.println("No data files.");
				return;
			}
			
			// �޸�dateĿ¼�µ�ÿ���ļ�����ȥ�ո�
			for (int i=0; i<fileNames.size(); i++)
			{
				String fileName=fileNames.get(i);
				FileTool.renameFile(newFolderPath, fileName, fileName.replace(" ", ""));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		// ****** ��ȡ index ָ�����ݲ�����ָ�����ݼ� ****** 
		try
		{

			List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\indexdata.csv");
			
			for (int i=1; i<csvLines.size(); i++)
//			for (int i=1; i<10; i++)
			{

				// ��ȡһ��csv���ݣ���Ӧ����һ��ָ������ȫ������
				String dataLine=csvLines.get(i).toString();
				String[] indexColData=dataLine.split(",");
				
				// ��ӵ�indexĿ¼�µ�ԭʼ���ݼ���
				String dataDef=getIndexSqlDataDef_history(indexColData);
//				System.out.println(dataDef);
				
				// �ҵ���Ӧ���ļ����µ�index�ļ�
				String fileName=indexColData[0];
				String indexDataFolder=stockAllDataFull+"\\index\\";
				
				File indexFile=new File(indexDataFolder+"\\"+fileName+".sas7bdat");
				if (indexFile.exists())
				{
					CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
				}
				else
				{
					
					// �����µ� index ���ݼ�
					String columnDef=getIndexSqlColumnDef_history();
					CommonTool.createSASDataSet(indexDataFolder, fileName, columnDef);
					CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
					
				}
				
				// ��ӵ�AllĿ¼��ת�����index���ݼ���
				String dataDef_all=getIndexSqlDataDef_all(indexColData);
//				System.out.println(dataDef_all);
	
				String fileNameAll="index"+indexColData[0].substring(2);
				String stockDataFolderAll=stockAllDataFull+"\\All\\";
				
				File indexFileAll=new File(indexDataFolder+"\\"+fileName+".sas7bdat");
				if (indexFileAll.exists())
				{
					CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef_all);
				}
				else
				{
					// �����µ� index ���ݼ�����������
					String columnDef=getIndexSqlColumnDef_all();
					CommonTool.createSASDataSet(stockDataFolderAll, fileNameAll, columnDef);
					CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef);
				}
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		// ****** ��ȡ stock ��Ʊ���ݲ����¹�Ʊ���ݼ� ****** 
		try
		{
			
			List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\stockoverview.csv");
			List newStockFileList=new ArrayList();
			
			for (int i=1; i<csvLines.size(); i++)
//			for (int i=1; i<10; i++)
			{

				// ��ȡһ��csv���ݣ���Ӧ����һֻ��Ʊ�ĵ���ȫ������
				String dataLine=csvLines.get(i).toString();
				String[] stockColData=dataLine.split(",");
				
				// ��ӵ�600,000,002,300Ŀ¼�µ�ԭʼ���ݼ���
				String dataDef=getStockSqlDataDef_history(stockColData);
//				System.out.println(dataDef);
				
				// �ҵ���Ӧ���ļ����µ�stock�ļ�
				String fileName=stockColData[0];
				String stockDataFolder="";
				if (stockColData[0].startsWith("sh6"))   // ��������
				{
					stockDataFolder=stockAllDataFull+"\\600\\";
				}

				if (stockColData[0].startsWith("sz002") || stockColData[0].startsWith("sz003"))  // ��С��
				{
					stockDataFolder=stockAllDataFull+"\\002\\";
				}
				
				if (stockColData[0].startsWith("sz000") || stockColData[0].startsWith("sz001"))   // ��������
				{
					stockDataFolder=stockAllDataFull+"\\000\\";				
				}
				
				if (stockColData[0].startsWith("sz3"))     // ��ҵ��
				{
					stockDataFolder=stockAllDataFull+"\\300\\";				
				}
				
				File stockFile=new File(stockDataFolder+"\\"+fileName+".sas7bdat");
				if (stockFile.exists())
				{
					CommonTool.insertDataToSASDataSet(stockDataFolder, fileName, dataDef);
				}
				else
				{
					
					// �����µ� Stock ԭʼ���ݼ�
					String columnDef=getStockSqlColumnDef_history(); 
					CommonTool.createSASDataSet(stockDataFolder, fileName, columnDef);
					CommonTool.insertDataToSASDataSet(stockDataFolder, fileName, dataDef);
					
					
				}
				
				// ��ӵ�AllĿ¼��ת��������ݼ���
				String dataDef_all=getStockSqlDataDef_all(stockColData);
//				System.out.println(dataDef_all);
	
				String fileNameAll="stock"+stockColData[0].substring(2);
				String stockDataFolderAll=stockAllDataFull+"\\All\\";
				
				
				File stockFileAll=new File(stockDataFolderAll+"\\"+fileNameAll+".sas7bdat");
				if (stockFileAll.exists())
				{
					CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef_all);
				}
				else
				{
					// �����µ� Stock All���ݼ�
					String columnDef_all=getStockSqlColumnDef_all();
					CommonTool.createSASDataSet(stockDataFolderAll, fileNameAll, columnDef_all);
					CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef_all);
					
					newStockFileList.add(fileNameAll);
				}
				
			}
			
			for(int s=0; s<newStockFileList.size(); s++)
			{
				String newStockFileName=newStockFileList.get(s).toString();
				System.out.println("Created New Stock File: "+newStockFileName);
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
	}
	
	
	
	public void processAddDailyDataForCode(String date, String code)
	{
		
		String newFolderPath=stockAllDataFull+"\\new\\"+date;

		// ****** ��ȡ index ָ�����ݲ�����ָ�����ݼ� ****** 
		if (code.startsWith("index"))
		{
		
			String indexCode=code.substring(5);   // ȡ index000001 �е����� 000001 
			
			try
			{
				
				List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\indexdata.csv");
				
				for (int i=1; i<csvLines.size(); i++)
	//			for (int i=1; i<10; i++)
				{
	
					// ��ȡһ��csv���ݣ���Ӧ����һ��ָ������ȫ������
					String dataLine=csvLines.get(i).toString();
					String[] indexColData=dataLine.split(",");
					
					if (indexColData[0].contains(indexCode))  // ��� sh000001, sz399001 �������� code=000001 ������������
					{
						
						System.out.println("process index code: "+indexCode);
						
						// ��ӵ�indexĿ¼�µ�ԭʼ���ݼ���
						String dataDef=getIndexSqlDataDef_history(indexColData);
		//				System.out.println(dataDef);
						
						// �ҵ���Ӧ���ļ����µ�index�ļ�
						String fileName=indexColData[0];
						String indexDataFolder=stockAllDataFull+"\\index\\";
						
						File indexFile=new File(indexDataFolder+"\\"+fileName+".sas7bdat");
						if (indexFile.exists())
						{
							CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
						}
						else
						{
							
							// �����µ� index ���ݼ�
							String columnDef=getIndexSqlColumnDef_history();
							CommonTool.createSASDataSet(indexDataFolder, fileName, columnDef);
							CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
							
						}
						
						// ��ӵ�AllĿ¼��ת�����index���ݼ���
						String dataDef_all=getIndexSqlDataDef_all(indexColData);
		//				System.out.println(dataDef_all);
			
						String fileNameAll="index"+indexColData[0].substring(2);
						String stockDataFolderAll=stockAllDataFull+"\\All\\";
						
						File indexFileAll=new File(indexDataFolder+"\\"+fileName+".sas7bdat");
						if (indexFileAll.exists())
						{
							CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef_all);
						}
						else
						{
							// �����µ� index ���ݼ�����������
							String columnDef=getIndexSqlColumnDef_all();
							CommonTool.createSASDataSet(stockDataFolderAll, fileNameAll, columnDef);
							CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef);
						}
						
						
						
					}
					

					
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		// ****** ��ȡ stock ��Ʊ���ݲ����¹�Ʊ���ݼ� ****** 
		if (code.startsWith("stock"))
		{
			
			String stockCode=code.substring(5);   // ȡ index000001 �е����� 000001 
			
			try
			{
				
				List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\stockoverview.csv");
				List newStockFileList=new ArrayList();
				
				for (int i=1; i<csvLines.size(); i++)
	//			for (int i=1; i<10; i++)
				{
	
					// ��ȡһ��csv���ݣ���Ӧ����һֻ��Ʊ�ĵ���ȫ������
					String dataLine=csvLines.get(i).toString();
					String[] stockColData=dataLine.split(",");
					
					
					if (stockColData[0].contains(stockCode))  // ��� sh000001, sz399001 �������� code=000001 ������������
					{
					
						System.out.println("process stock code: "+stockCode);
						
						// ��ӵ�600,000,002,300Ŀ¼�µ�ԭʼ���ݼ���
						String dataDef=getStockSqlDataDef_history(stockColData);
		//				System.out.println(dataDef);
						
						// �ҵ���Ӧ���ļ����µ�stock�ļ�
						String fileName=stockColData[0];
						String stockDataFolder="";
						if (stockColData[0].startsWith("sh6"))   // ��������
						{
							stockDataFolder=stockAllDataFull+"\\600\\";
						}
		
						if (stockColData[0].startsWith("sz002") || stockColData[0].startsWith("sz003"))  // ��С��
						{
							stockDataFolder=stockAllDataFull+"\\002\\";
						}
						
						if (stockColData[0].startsWith("sz000") || stockColData[0].startsWith("sz001"))   // ��������
						{
							stockDataFolder=stockAllDataFull+"\\000\\";				
						}
						
						if (stockColData[0].startsWith("sz3"))     // ��ҵ��
						{
							stockDataFolder=stockAllDataFull+"\\300\\";				
						}
						
						File stockFile=new File(stockDataFolder+"\\"+fileName+".sas7bdat");
						if (stockFile.exists())
						{
							CommonTool.insertDataToSASDataSet(stockDataFolder, fileName, dataDef);
						}
						else
						{
							
							// �����µ� Stock ԭʼ���ݼ�
							String columnDef=getStockSqlColumnDef_history(); 
							CommonTool.createSASDataSet(stockDataFolder, fileName, columnDef);
							CommonTool.insertDataToSASDataSet(stockDataFolder, fileName, dataDef);
							
							
						}
						
						// ��ӵ�AllĿ¼��ת��������ݼ���
						String dataDef_all=getStockSqlDataDef_all(stockColData);
		//				System.out.println(dataDef_all);
			
						String fileNameAll="stock"+stockColData[0].substring(2);
						String stockDataFolderAll=stockAllDataFull+"\\All\\";
						
						
						File stockFileAll=new File(stockDataFolderAll+"\\"+fileNameAll+".sas7bdat");
						if (stockFileAll.exists())
						{
							CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef_all);
						}
						else
						{
							// �����µ� Stock All���ݼ�
							String columnDef_all=getStockSqlColumnDef_all();
							CommonTool.createSASDataSet(stockDataFolderAll, fileNameAll, columnDef_all);
							CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef_all);
							
							newStockFileList.add(fileNameAll);
						}
					
						
					}
						
						
						
				}
				
				for(int s=0; s<newStockFileList.size(); s++)
				{
					String newStockFileName=newStockFileList.get(s).toString();
					System.out.println("Created New Stock File: "+newStockFileName);
				}
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		}	
		
		
	}
	
	
	public String getStockSqlColumnDef_history()
	{
		
		String columnDef="";
	
		columnDef=
				CommonTool.getSqlStrColumnDef("scode_org", 12)+    // ��Ʊ����
				CommonTool.getSqlStrColumnDef("sname_org", 12)+	 // ��Ʊ����
				CommonTool.getSqlDateColumnDef("date_org")+  // ��������
				CommonTool.getSqlStrColumnDef("industry", 30)+	 // ��ҵ
				CommonTool.getSqlStrColumnDef("concept", 200)+	 // ����
				CommonTool.getSqlStrColumnDef("location", 20)+	 // ����
				CommonTool.getSqlNumberColumnDef("open")+	// ���̼�
				CommonTool.getSqlNumberColumnDef("high")+	// ��߼�
				CommonTool.getSqlNumberColumnDef("low")+	// ��ͼ�
				CommonTool.getSqlNumberColumnDef("final")+	// ���̼�
				CommonTool.getSqlNumberColumnDef("af_final")+	// ��Ȩ��
				CommonTool.getSqlNumberColumnDef("pf_final")+	// ǰ��Ȩ��
				CommonTool.getSqlNumberColumnDef("rise")+	// �ǵ���
				CommonTool.getSqlNumberColumnDef("amount", "int", "BEST12.")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("money", "int", "BEST12.")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("change_ratio")+	// ������
				CommonTool.getSqlNumberColumnDef("liquid_value")+	// ��ͨ��ֵ
				CommonTool.getSqlNumberColumnDef("total_value")+	// ����ֵ
				CommonTool.getSqlNumberColumnDef("is_up_stop", "int", "BEST12.")+	// �Ƿ���ͣ
				CommonTool.getSqlNumberColumnDef("is_down_stop", "int", "BEST12.")+	// �Ƿ��ͣ				
				CommonTool.getSqlNumberColumnDef("pe_ratio")+	// ��ӯ��TTM
				CommonTool.getSqlNumberColumnDef("ps_ratio")+	// ������TTM
				CommonTool.getSqlNumberColumnDef("px_ratio")+ // ������TTM
				CommonTool.getSqlNumberColumnDef("pj_ratio")+	// �о���
				CommonTool.getSqlNumberColumnDef("MA_5")+	// MA_5
				CommonTool.getSqlNumberColumnDef("MA_10")+	// MA_10
				CommonTool.getSqlNumberColumnDef("MA_20")+	// MA_20
				CommonTool.getSqlNumberColumnDef("MA_30")+	// MA_30
				CommonTool.getSqlNumberColumnDef("MA_60")+	// MA_60
				CommonTool.getSqlStrColumnDef("ma_jcsc", 400)+		// MA_�������
				CommonTool.getSqlNumberColumnDef("MACD_DIF")+	// MACD_DIF
				CommonTool.getSqlNumberColumnDef("MACD_DEA")+	// MACD_DEA
				CommonTool.getSqlNumberColumnDef("MACD_MACD")+	// MACD_MACD
				CommonTool.getSqlStrColumnDef("macd_jcsc", 20)+		// MACD_�������
				CommonTool.getSqlNumberColumnDef("KDJ_K")+	// KDJ_K
				CommonTool.getSqlNumberColumnDef("KDJ_D")+	// KDJ_D
				CommonTool.getSqlNumberColumnDef("KDJ_J")+	// KDJ_J
				CommonTool.getSqlStrColumnDef("kdj_jcsc", 20)+		// KDJ_�������
				CommonTool.getSqlNumberColumnDef("blx_middle")+	// �������й�
				CommonTool.getSqlNumberColumnDef("blx_up")+	// �������Ϲ�
				CommonTool.getSqlNumberColumnDef("blx_down")+	// �������¹�
				CommonTool.getSqlNumberColumnDef("psy")+	// psy
				CommonTool.getSqlNumberColumnDef("psyma")+	// psyma
				CommonTool.getSqlNumberColumnDef("rsi1")+	// rsi1
				CommonTool.getSqlNumberColumnDef("rsi2")+	// rsi2
				CommonTool.getSqlNumberColumnDef("rsi3")+	// rsi3
				CommonTool.getSqlNumberColumnDef("swing")+	// ���
				CommonTool.getSqlNumberColumnDef("eq_ratio").replace(",", "")  //����  
				
		;
		
		
		return columnDef;
		
	}
	
	
	public String getStockSqlColumnDef_all()
	{
		
		String columnDef_all="";
	
		columnDef_all=
				CommonTool.getSqlStrColumnDef("scode_org", 12)+    // ��Ʊ����
				CommonTool.getSqlStrColumnDef("sname_org", 12)+	 // ��Ʊ����
				CommonTool.getSqlDateColumnDef("date_org")+  // ��������
				CommonTool.getSqlStrColumnDef("industry", 30)+	 // ��ҵ
				CommonTool.getSqlStrColumnDef("concept", 200)+	 // ����
				CommonTool.getSqlStrColumnDef("location", 20)+	 // ����
				CommonTool.getSqlNumberColumnDef("open")+	// ���̼�
				CommonTool.getSqlNumberColumnDef("high")+	// ��߼�
				CommonTool.getSqlNumberColumnDef("low")+	// ��ͼ�
				CommonTool.getSqlNumberColumnDef("final")+	// ���̼�
				CommonTool.getSqlNumberColumnDef("af_final")+	// ��Ȩ��
				CommonTool.getSqlNumberColumnDef("pf_final")+	// ǰ��Ȩ��
				CommonTool.getSqlNumberColumnDef("rise")+	// �ǵ���
				CommonTool.getSqlNumberColumnDef("amount", "int", "BEST12.")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("money", "int", "BEST12.")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("change_ratio")+	// ������
				CommonTool.getSqlNumberColumnDef("liquid_value")+	// ��ͨ��ֵ
				CommonTool.getSqlNumberColumnDef("total_value")+	// ����ֵ
				CommonTool.getSqlNumberColumnDef("is_up_stop", "int", "BEST12.")+	// �Ƿ���ͣ
				CommonTool.getSqlNumberColumnDef("is_down_stop", "int", "BEST12.")+	// �Ƿ��ͣ				
				CommonTool.getSqlNumberColumnDef("pe_ratio")+	// ��ӯ��TTM
				CommonTool.getSqlNumberColumnDef("ps_ratio")+	// ������TTM
				CommonTool.getSqlNumberColumnDef("px_ratio")+ // ������TTM
				CommonTool.getSqlNumberColumnDef("pj_ratio")+	// �о���
				CommonTool.getSqlNumberColumnDef("MA_5")+	// MA_5
				CommonTool.getSqlNumberColumnDef("MA_10")+	// MA_10
				CommonTool.getSqlNumberColumnDef("MA_20")+	// MA_20
				CommonTool.getSqlNumberColumnDef("MA_30")+	// MA_30
				CommonTool.getSqlNumberColumnDef("MA_60")+	// MA_60
				CommonTool.getSqlStrColumnDef("ma_jcsc", 400)+		// MA_�������
				CommonTool.getSqlNumberColumnDef("MACD_DIF")+	// MACD_DIF
				CommonTool.getSqlNumberColumnDef("MACD_DEA")+	// MACD_DEA
				CommonTool.getSqlNumberColumnDef("MACD_MACD")+	// MACD_MACD
				CommonTool.getSqlStrColumnDef("macd_jcsc", 20)+		// MACD_�������
				CommonTool.getSqlNumberColumnDef("KDJ_K")+	// KDJ_K
				CommonTool.getSqlNumberColumnDef("KDJ_D")+	// KDJ_D
				CommonTool.getSqlNumberColumnDef("KDJ_J")+	// KDJ_J
				CommonTool.getSqlStrColumnDef("kdj_jcsc", 20)+		// KDJ_�������
				CommonTool.getSqlNumberColumnDef("blx_middle")+	// �������й�
				CommonTool.getSqlNumberColumnDef("blx_up")+	// �������Ϲ�
				CommonTool.getSqlNumberColumnDef("blx_down")+	// �������¹�
				CommonTool.getSqlNumberColumnDef("psy")+	// psy
				CommonTool.getSqlNumberColumnDef("psyma")+	// psyma
				CommonTool.getSqlNumberColumnDef("rsi1")+	// rsi1
				CommonTool.getSqlNumberColumnDef("rsi2")+	// rsi2
				CommonTool.getSqlNumberColumnDef("rsi3")+	// rsi3
				CommonTool.getSqlNumberColumnDef("swing")+	// ���
				CommonTool.getSqlNumberColumnDef("eq_ratio")+  //����  
				
				CommonTool.getSqlStrColumnDef("scode", 12)+	// ��Ʊ����
				CommonTool.getSqlStrColumnDef("sname", 12)+	// ��Ʊ����
				CommonTool.getSqlStrColumnDef("date", 200)+	// ��������
				CommonTool.getSqlNumberColumnDef("open_rise", "double precision", "12.2")+	// �����Ƿ�
				CommonTool.getSqlNumberColumnDef("high_rise", "double precision", "12.2")+	// ����Ƿ�
				CommonTool.getSqlNumberColumnDef("low_rise",  "double precision", "12.2")+	// ����Ƿ�
				CommonTool.getSqlNumberColumnDef("final_rise", "double precision", "12.2").replace(",", "")	// �����Ƿ�
				
		;
		
		return columnDef_all;
		
	}
	
	
	
	public String getStockSqlDataDef_history(String[] stockColData)
	{
		String dataDef="";
	
		dataDef=
				CommonTool.getSqlStrDataDef(stockColData[0])+    // ��Ʊ����
				CommonTool.getSqlStrDataDef(stockColData[1])+	 // ��Ʊ����
				CommonTool.getSqlDateDataDef(stockColData[2])+    // ��������
				CommonTool.getSqlStrDataDef(stockColData[3])+	 // ��ҵ
				CommonTool.getSqlStrDataDef(stockColData[4])+	 // ����
				CommonTool.getSqlStrDataDef(stockColData[5])+	 // ����
				CommonTool.getSqlNumberDataDef(stockColData[6])+	// ���̼�
				CommonTool.getSqlNumberDataDef(stockColData[7])+	// ��߼�
				CommonTool.getSqlNumberDataDef(stockColData[8])+	// ��ͼ�
				CommonTool.getSqlNumberDataDef(stockColData[9])+	// ���̼�
				CommonTool.getSqlNumberDataDef(stockColData[10])+	// ��Ȩ��
				CommonTool.getSqlNumberDataDef(stockColData[11])+	// ǰ��Ȩ��
				CommonTool.getSqlNumberDataDef(stockColData[12])+	// �ǵ���
				CommonTool.getSqlNumberDataDef(stockColData[13])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(stockColData[14])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(stockColData[15])+	// ������
				CommonTool.getSqlNumberDataDef(stockColData[16])+	// ��ͨ��ֵ
				CommonTool.getSqlNumberDataDef(stockColData[17])+	// ����ֵ
				CommonTool.getSqlNumberDataDef(stockColData[18])+	// �Ƿ���ͣ
				CommonTool.getSqlNumberDataDef(stockColData[19])+	// �Ƿ��ͣ				
				CommonTool.getSqlNumberDataDef(stockColData[20])+	// ��ӯ��TTM
				CommonTool.getSqlNumberDataDef(stockColData[21])+	// ������TTM
				CommonTool.getSqlNumberDataDef(stockColData[22])+   // ������TTM
				CommonTool.getSqlNumberDataDef(stockColData[23])+	// �о���
				CommonTool.getSqlNumberDataDef(stockColData[24])+	// MA_5
				CommonTool.getSqlNumberDataDef(stockColData[25])+	// MA_10
				CommonTool.getSqlNumberDataDef(stockColData[26])+	// MA_20
				CommonTool.getSqlNumberDataDef(stockColData[27])+	// MA_30
				CommonTool.getSqlNumberDataDef(stockColData[28])+	// MA_60
				CommonTool.getSqlStrDataDef(stockColData[29])+		// MA_�������
				CommonTool.getSqlNumberDataDef(stockColData[30])+	// MACD_DIF
				CommonTool.getSqlNumberDataDef(stockColData[31])+	// MACD_DEA
				CommonTool.getSqlNumberDataDef(stockColData[32])+	// MACD_MACD
				CommonTool.getSqlStrDataDef(stockColData[33])+		// MACD_�������
				CommonTool.getSqlNumberDataDef(stockColData[34])+	// KDJ_K
				CommonTool.getSqlNumberDataDef(stockColData[35])+	// KDJ_D
				CommonTool.getSqlNumberDataDef(stockColData[36])+	// KDJ_J
				CommonTool.getSqlStrDataDef(stockColData[37])+		// KDJ_�������
				CommonTool.getSqlNumberDataDef(stockColData[38])+	// �������й�
				CommonTool.getSqlNumberDataDef(stockColData[39])+	// �������Ϲ�
				CommonTool.getSqlNumberDataDef(stockColData[40])+	// �������¹�
				CommonTool.getSqlNumberDataDef(stockColData[41])+	// psy
				CommonTool.getSqlNumberDataDef(stockColData[42])+	// psyma
				CommonTool.getSqlNumberDataDef(stockColData[43])+	// rsi1
				CommonTool.getSqlNumberDataDef(stockColData[44])+	// rsi2
				CommonTool.getSqlNumberDataDef(stockColData[45])+	// rsi3
				CommonTool.getSqlNumberDataDef(stockColData[46])+	// ���
				CommonTool.getSqlNumberDataDef(stockColData[47]).replace(",", "")    //����   
				
		;
		
		return dataDef;
		
	}
	
	public String getStockSqlDataDef_all(String[] stockColData)
	{
		String dataDef_all="";
	
		// ���� scode, sname, date
		String scode=stockColData[0].substring(2);
		String sname=stockColData[1];
		String date=stockColData[2].replace("-", "/");
		
		// ���� open_rise, high_rise, low_rise, final_rise
		double rise=CommonTool.converToDoubleNumber(stockColData[12]);
		double open=CommonTool.converToDoubleNumber(stockColData[6]);
		double high=CommonTool.converToDoubleNumber(stockColData[7]);
		double low=CommonTool.converToDoubleNumber(stockColData[8]);
		double close=CommonTool.converToDoubleNumber(stockColData[9]);
		
		double y_final=close/(1+rise);  // �������̼�
		double open_rise=(open/y_final-1)*100;
		double high_rise=(high/y_final-1)*100;
		double low_rise=(low/y_final-1)*100;
		double final_rise=rise*100;
		
		
		dataDef_all=
				CommonTool.getSqlStrDataDef(stockColData[0])+    // ��Ʊ����
				CommonTool.getSqlStrDataDef(stockColData[1])+	 // ��Ʊ����
				CommonTool.getSqlDateDataDef(stockColData[2])+    // ��������
				CommonTool.getSqlStrDataDef(stockColData[3])+	 // ��ҵ
				CommonTool.getSqlStrDataDef(stockColData[4])+	 // ����
				CommonTool.getSqlStrDataDef(stockColData[5])+	 // ����
				CommonTool.getSqlNumberDataDef(stockColData[6])+	// ���̼�
				CommonTool.getSqlNumberDataDef(stockColData[7])+	// ��߼�
				CommonTool.getSqlNumberDataDef(stockColData[8])+	// ��ͼ�
				CommonTool.getSqlNumberDataDef(stockColData[9])+	// ���̼�
				CommonTool.getSqlNumberDataDef(stockColData[10])+	// ��Ȩ��
				CommonTool.getSqlNumberDataDef(stockColData[11])+	// ǰ��Ȩ��
				CommonTool.getSqlNumberDataDef(stockColData[12])+	// �ǵ���
				CommonTool.getSqlNumberDataDef(stockColData[13])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(stockColData[14])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(stockColData[15])+	// ������
				CommonTool.getSqlNumberDataDef(stockColData[16])+	// ��ͨ��ֵ
				CommonTool.getSqlNumberDataDef(stockColData[17])+	// ����ֵ
				CommonTool.getSqlNumberDataDef(stockColData[18])+	// �Ƿ���ͣ
				CommonTool.getSqlNumberDataDef(stockColData[19])+	// �Ƿ��ͣ				
				CommonTool.getSqlNumberDataDef(stockColData[20])+	// ��ӯ��TTM
				CommonTool.getSqlNumberDataDef(stockColData[21])+	// ������TTM
				CommonTool.getSqlNumberDataDef(stockColData[22])+   // ������TTM
				CommonTool.getSqlNumberDataDef(stockColData[23])+	// �о���
				CommonTool.getSqlNumberDataDef(stockColData[24])+	// MA_5
				CommonTool.getSqlNumberDataDef(stockColData[25])+	// MA_10
				CommonTool.getSqlNumberDataDef(stockColData[26])+	// MA_20
				CommonTool.getSqlNumberDataDef(stockColData[27])+	// MA_30
				CommonTool.getSqlNumberDataDef(stockColData[28])+	// MA_60
				CommonTool.getSqlStrDataDef(stockColData[29])+		// MA_�������
				CommonTool.getSqlNumberDataDef(stockColData[30])+	// MACD_DIF
				CommonTool.getSqlNumberDataDef(stockColData[31])+	// MACD_DEA
				CommonTool.getSqlNumberDataDef(stockColData[32])+	// MACD_MACD
				CommonTool.getSqlStrDataDef(stockColData[33])+		// MACD_�������
				CommonTool.getSqlNumberDataDef(stockColData[34])+	// KDJ_K
				CommonTool.getSqlNumberDataDef(stockColData[35])+	// KDJ_D
				CommonTool.getSqlNumberDataDef(stockColData[36])+	// KDJ_J
				CommonTool.getSqlStrDataDef(stockColData[37])+		// KDJ_�������
				CommonTool.getSqlNumberDataDef(stockColData[38])+	// �������й�
				CommonTool.getSqlNumberDataDef(stockColData[39])+	// �������Ϲ�
				CommonTool.getSqlNumberDataDef(stockColData[40])+	// �������¹�
				CommonTool.getSqlNumberDataDef(stockColData[41])+	// psy
				CommonTool.getSqlNumberDataDef(stockColData[42])+	// psyma
				CommonTool.getSqlNumberDataDef(stockColData[43])+	// rsi1
				CommonTool.getSqlNumberDataDef(stockColData[44])+	// rsi2
				CommonTool.getSqlNumberDataDef(stockColData[45])+	// rsi3
				CommonTool.getSqlNumberDataDef(stockColData[46])+	// ���
				CommonTool.getSqlNumberDataDef(stockColData[47])+   // ����
				
				CommonTool.getSqlStrDataDef(scode)+				// ��Ʊ����
				CommonTool.getSqlStrDataDef(sname)+				// ��Ʊ����
				CommonTool.getSqlStrDataDef(date)+				// ��������
				CommonTool.getSqlNumberDataDef(open_rise+"")+   // �����Ƿ�
				CommonTool.getSqlNumberDataDef(high_rise+"")+	// ����Ƿ�
				CommonTool.getSqlNumberDataDef(low_rise+"")+	// ����Ƿ�
				CommonTool.getSqlNumberDataDef(final_rise+"").replace(",", "")   // �����Ƿ�
				
		;	
		
		return dataDef_all;
	}
	
	
	public String getIndexSqlColumnDef_history()
	{
		
		String columnDef="";
		
		columnDef=
				CommonTool.getSqlStrColumnDef("index_code", 12)+    // ָ������
				CommonTool.getSqlDateColumnDef("date")+	 // ��������
				CommonTool.getSqlNumberColumnDef("open")+  // ����ֵ
				CommonTool.getSqlNumberColumnDef("close")+	 // ����ֵ
				CommonTool.getSqlNumberColumnDef("low")+	 // ���ֵ
				CommonTool.getSqlNumberColumnDef("high")+	 // ���ֵ
				CommonTool.getSqlNumberColumnDef("volume")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("money")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("change").replace(",", "")	// �ǵ���
				
		;
		
		return columnDef;
		
	}
	
	
	public String getIndexSqlColumnDef_all()
	{
		
		String columnDef="";
		
		columnDef=
				CommonTool.getSqlStrColumnDef("code_org_i", 12)+    // ָ������
				CommonTool.getSqlDateColumnDef("date_org_i")+	 // ��������
				CommonTool.getSqlNumberColumnDef("open_i")+  // ����ֵ
				CommonTool.getSqlNumberColumnDef("final_i")+	 // ����ֵ
				CommonTool.getSqlNumberColumnDef("low_i")+	 // ���ֵ
				CommonTool.getSqlNumberColumnDef("high_i")+	 // ���ֵ
				CommonTool.getSqlNumberColumnDef("amount_i")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("money_i")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("change_i")+	// �ǵ���
				
				CommonTool.getSqlStrColumnDef("code_i", 12)+	// ָ������
				CommonTool.getSqlStrColumnDef("date", 12)+	// ��������
				CommonTool.getSqlNumberColumnDef("open_rise_i", "double precision", "12.2")+	// �����Ƿ�
				CommonTool.getSqlNumberColumnDef("high_rise_i", "double precision", "12.2")+	// ����Ƿ�
				CommonTool.getSqlNumberColumnDef("low_rise_i", "double precision", "12.2")+	// ����Ƿ�
				CommonTool.getSqlNumberColumnDef("final_rise_i", "double precision", "12.2").replace(",", "")	// �����Ƿ�
				
		;
		
		return columnDef;
		
	}
	
	
	public String getIndexSqlDataDef_history(String[] indexColData)
	{
		String dataDef="";
	
		dataDef=
				CommonTool.getSqlStrDataDef(indexColData[0])+    // ָ������
				CommonTool.getSqlDateDataDef(indexColData[1])+	 // ��������
				CommonTool.getSqlNumberDataDef(indexColData[2])+    // ����ֵ
				CommonTool.getSqlNumberDataDef(indexColData[3])+	 // ����ֵ
				CommonTool.getSqlNumberDataDef(indexColData[4])+	 // ���ֵ
				CommonTool.getSqlNumberDataDef(indexColData[5])+	 // ���ֵ
				CommonTool.getSqlNumberDataDef(indexColData[6])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(indexColData[7])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(indexColData[8]).replace(",", "")	// �ǵ���
				
		;
		
		return dataDef;
		
	}
	
	
	public String getIndexSqlDataDef_all(String[] indexColData)
	{
		String dataDef="";
	
		// ���� code, date
		String code=indexColData[0].substring(2);
		String date=indexColData[1].replace("-", "/");
		
		// ���� open_rise, high_rise, low_rise, final_rise
		double rise=CommonTool.converToDoubleNumber(indexColData[8]);
		double open=CommonTool.converToDoubleNumber(indexColData[2]);
		double high=CommonTool.converToDoubleNumber(indexColData[5]);
		double low=CommonTool.converToDoubleNumber(indexColData[4]);
		double close=CommonTool.converToDoubleNumber(indexColData[3]);
		
		double y_final=close/(1+rise);  // �������̼�
		double open_rise=(open/y_final-1)*100;
		double high_rise=(high/y_final-1)*100;
		double low_rise=(low/y_final-1)*100;
		double final_rise=rise*100;
		
		dataDef=
				CommonTool.getSqlStrDataDef(indexColData[0])+    // ָ������
				CommonTool.getSqlDateDataDef(indexColData[1])+	 // ��������
				CommonTool.getSqlNumberDataDef(indexColData[2])+    // ����ֵ
				CommonTool.getSqlNumberDataDef(indexColData[3])+	 // ����ֵ
				CommonTool.getSqlNumberDataDef(indexColData[4])+	 // ���ֵ
				CommonTool.getSqlNumberDataDef(indexColData[5])+	 // ���ֵ
				CommonTool.getSqlNumberDataDef(indexColData[6])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(indexColData[7])+	// �ɽ���
				CommonTool.getSqlNumberDataDef(indexColData[8])+	// �ǵ���
				
				CommonTool.getSqlStrDataDef(code)+				// ָ������
				CommonTool.getSqlStrDataDef(date)+				// ��������
				CommonTool.getSqlNumberDataDef(open_rise+"")+   // �����Ƿ�
				CommonTool.getSqlNumberDataDef(high_rise+"")+	// ����Ƿ�
				CommonTool.getSqlNumberDataDef(low_rise+"")+	// ����Ƿ�
				CommonTool.getSqlNumberDataDef(final_rise+"").replace(",", "")   // �����Ƿ�
				
		;
		
		return dataDef;
		
	}
	

	
	public void testCreate()
	{
		
		
		String fileName="sh000004";
		String indexDataFolder=stockAllDataFull+"\\test\\";
		
		String columnDef="";
		columnDef=
				CommonTool.getSqlStrColumnDef("index_code", 12)+    // ָ������
				CommonTool.getSqlDateColumnDef("date").replace(",", "")+	" PRIMARY KEY, "+ // ��������
				CommonTool.getSqlNumberColumnDef("open")+  // ����ֵ
				CommonTool.getSqlNumberColumnDef("close")+	 // ����ֵ
				CommonTool.getSqlNumberColumnDef("low")+	 // ���ֵ
				CommonTool.getSqlNumberColumnDef("high")+	 // ���ֵ
				CommonTool.getSqlNumberColumnDef("volume")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("money")+	// �ɽ���
				CommonTool.getSqlNumberColumnDef("change").replace(",", "")	// �ǵ��� 
		;

		
		// �����µ� Index ���ݼ�
		CommonTool.createSASDataSet(indexDataFolder, fileName, columnDef);
//		CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
		
		String fileNameAll="index"+fileName.substring(2);
		String stockDataFolderAll=stockAllDataFull+"\\test\\";
		
		// �����µ�sas���ݼ�����������
		String columnDef_all=getIndexSqlColumnDef_all();
		CommonTool.createSASDataSet(stockDataFolderAll, fileNameAll, columnDef_all);
//		CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef);
		
		
		
	}
}
