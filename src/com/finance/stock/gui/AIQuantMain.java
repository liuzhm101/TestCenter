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
		
		// 定义日期
		String dateStr=CommonTool.getCurrentDate().substring(0, 10).replace("-", "");
		
		// 自动运行当日数据更新及市场观测
//		aiqm.autoRunDailyUpdateJob();	
		
		// 手动运行数据更新及市场观测
//		aiqm.manualRunDailyUpdateJob(dateStr, dateStr);  
		aiqm.manualRunDailyUpdateJob("20200301", "20200304");  // 手动补插入某段时间的Daily数据
		
//		aiqm.manualRunDeleteDailyData("2018/05/25"); 
		
//		aiqm.manualRunHistoryCreateDataset();   // 速度太慢，还是用SAS程序转换CSV为数据集快	

//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index000001");
//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index399001");		
//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index399005");
//		aiqm.manualRunAddDailyDataForCode("20180222", "20180222", "index399006");
		
//		aiqm.manualRunSearchStockByModel_yg("2018/01/11", "2018/01/19");
		
		// 生成最新的股票代码列表
		aiqm.processRecreateStockList();
		aiqm.processRecreateStockListFull();
		
		// 生成市场监控记录
		MarketMonitor mm=new MarketMonitor();
		mm.monitorMarket("2020/03/01", "2020/03/04");
		
	}
	
		public void autoRunDailyUpdateJob()
		{
			
	//		while(true)
			{
				
				String dateStr=CommonTool.getCurrentDate().substring(0, 10).replace("-", "");   // 格式："20180108"
				String curDateStr=CommonTool.getCurrentDate().substring(0, 10).replace("-", "/");	// 格式："2018/01/08"
				System.out.println("Loop detecting data of date: "+dateStr+" ...... ");
				
				String zipFilePath=stockAllDataCode+"\\Zip\\"+dateStr+".zip";
				File f=new File(zipFilePath);
				
				if (!f.exists())  // 如果zip文件不存在，则开始尝试下载当天的zip文件数据
				{			
					System.out.println("Try to download data zip file...");
					try
					{
						// 下载当天的zip数据包
						boolean result=FileTool.downloadZipFileFromURL(stockDayDataURL, zipFilePath);
						
						// 处理zip包数据,解压缩并提取里面的数据
						if (result==true)
						{
							
							// 每日数据更新部分
							long starttime=System.currentTimeMillis();
							
							System.out.println("Successfully download data zip file.");
							processAddDailyData(dateStr); 
							
							processRecreateStockList();
							processRecreateStockListFull(); 
	
							long endtime=System.currentTimeMillis();
							int time=(int)(endtime-starttime)/1000;
							
						
							// 每日市场观测报告部分
							long starttime1=System.currentTimeMillis();
							
							MarketMonitor mm=new MarketMonitor();
							mm.monitorMarket(curDateStr);
							
							long endtime1=System.currentTimeMillis();
							int time1=(int)(endtime1-starttime1)/1000;
							
							
							// 模型选股部分
							long starttime2=System.currentTimeMillis();
							
							ModelCenter mc=new ModelCenter();
							mc.searchDataByModel_yg(curDateStr, curDateStr);
							
							long endtime2=System.currentTimeMillis();
							int time2=(int)(endtime2-starttime2)/1000;
							
							System.out.println("Total time (Update Daily Data): "+time+"秒");
							System.out.println("Total time (Monitor Market): "+time1+"秒");
							System.out.println("Total time (Model Search Stock): "+time2+"秒");
	
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
				    Thread.sleep(600000);                 //10分钟后继续
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
			String newDate=fileNames.get(i).toString().substring(0, 8);  // "20180119.zip" 取前8位
			String curDateStr=newDate.substring(0,4)+"/"+newDate.substring(4,6)+"/"+newDate.substring(6,8); // 格式："2018/01/19"
			
			if (newDate.compareTo(startDate)>=0 && newDate.compareTo(endDate)<=0)
			{
				
				
				// 每日数据更新部分
				long starttime=System.currentTimeMillis();
				
				processAddDailyData(newDate); 
				
//				processRecreateStockList();
//				processRecreateStockListFull(); 

				long endtime=System.currentTimeMillis();
				int time=(int)(endtime-starttime)/1000;
				
			
				// 每日市场观测报告部分
				long starttime1=System.currentTimeMillis();
				
//				MarketMonitor mm=new MarketMonitor();
//				mm.monitorMarket(curDateStr);
				
				long endtime1=System.currentTimeMillis();
				int time1=(int)(endtime1-starttime1)/1000;
				
				
				// 模型选股部分
				long starttime2=System.currentTimeMillis();
				
//				ModelCenter mc=new ModelCenter();
//				mc.searchDataByModel_yg(curDateStr, curDateStr);
				
				long endtime2=System.currentTimeMillis();
				int time2=(int)(endtime2-starttime2)/1000;
				
				System.out.println("Total time (Update Daily Data): "+time+"秒");
				System.out.println("Total time (Monitor Market): "+time1+"秒");
				System.out.println("Total time (Model Search Stock): "+time2+"秒");
				
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
				// 处理 new 数据
				processAddDailyDataForCode(newDate, code);
				
			}
			
		}
		
			
	}
	
	public void manualRunSearchStockByModel_yg(String startDate, String endDate)
	{
		
		// 模型选股部分
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

			// 读取一只股票的历史全部sdd记录集合
			List csvLines=FileTool.readLinesFromFile(dataFolderPath+"\\"+csvFileName);
			List transDataList=new ArrayList();
			int maxlen=0;
			for (int j=1; j<csvLines.size(); j++)
			{

				// 读取一行csv数据
				String dataLine=csvLines.get(j).toString();
				String[] stockColData=dataLine.split(",");
				
				if (stockColData.length<48)
					continue;
				
				// 插入到数据集中
				String dataDef=getStockSqlDataDef_history(stockColData);
//				maxlen=Math.max(maxlen, stockColData[5].length());
				System.out.println(dataDef);
				
				transDataList.add(dataDef);
			}
//			System.out.println(maxlen);
//			totalMaxlen=Math.max(maxlen, totalMaxlen);
			
			// 生成一只股票的SAS数据集
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
		String columnDef=CommonTool.getSqlStrColumnDef("stockcode", 12)+    // 股票代码
				CommonTool.getSqlStrColumnDef("stockname", 12)+	 // 股票名称
				CommonTool.getSqlStrColumnDef("industry", 30)+	 // 行业
				CommonTool.getSqlStrColumnDef("concept", 200)+	 // 概念
				CommonTool.getSqlStrColumnDef("location", 20).replace(",", "")	 // 地域
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

		// 解压缩每日zip文件，并修改文件名（去空格）
		try
		{
				
			// 在new目录下创建date目录
			File newFolder=new File(newFolderPath);
			if (!newFolder.exists())
			{
				newFolder.mkdir();
			}
			
			// 解压缩zip包到new目录下
			String cmdStr="\"C:\\Program Files (x86)\\WinRAR\\WinRAR.exe\"  e  "+zipFilePath+" "+newFolderPath;
			CommonTool.executeCommand(cmdStr);
			
			try 
			{
				// 等10秒解压完毕后再继续
			    Thread.sleep(5000);                 
			} 
			catch(InterruptedException e) 
			{
			    e.printStackTrace();
			}
			
			
			// 检查解压缩目录下的文件是否存在
			List<String> fileNames=FileTool.getFileNameList(newFolderPath);
			if (fileNames.size()==0)
			{
				System.out.println("No data files.");
				return;
			}
			
			// 修改date目录下的每个文件名，去空格
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
		
		
		// ****** 读取 index 指数数据并更新指数数据集 ****** 
		try
		{

			List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\indexdata.csv");
			
			for (int i=1; i<csvLines.size(); i++)
//			for (int i=1; i<10; i++)
			{

				// 读取一行csv数据，对应的是一个指数当日全景数据
				String dataLine=csvLines.get(i).toString();
				String[] indexColData=dataLine.split(",");
				
				// 添加到index目录下的原始数据集中
				String dataDef=getIndexSqlDataDef_history(indexColData);
//				System.out.println(dataDef);
				
				// 找到对应的文件夹下的index文件
				String fileName=indexColData[0];
				String indexDataFolder=stockAllDataFull+"\\index\\";
				
				File indexFile=new File(indexDataFolder+"\\"+fileName+".sas7bdat");
				if (indexFile.exists())
				{
					CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
				}
				else
				{
					
					// 创建新的 index 数据集
					String columnDef=getIndexSqlColumnDef_history();
					CommonTool.createSASDataSet(indexDataFolder, fileName, columnDef);
					CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
					
				}
				
				// 添加到All目录下转换后的index数据集中
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
					// 创建新的 index 数据集并插入数据
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
		
		
		// ****** 读取 stock 股票数据并更新股票数据集 ****** 
		try
		{
			
			List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\stockoverview.csv");
			List newStockFileList=new ArrayList();
			
			for (int i=1; i<csvLines.size(); i++)
//			for (int i=1; i<10; i++)
			{

				// 读取一行csv数据，对应的是一只股票的当日全景数据
				String dataLine=csvLines.get(i).toString();
				String[] stockColData=dataLine.split(",");
				
				// 添加到600,000,002,300目录下的原始数据集中
				String dataDef=getStockSqlDataDef_history(stockColData);
//				System.out.println(dataDef);
				
				// 找到对应的文件夹下的stock文件
				String fileName=stockColData[0];
				String stockDataFolder="";
				if (stockColData[0].startsWith("sh6"))   // 沪市主板
				{
					stockDataFolder=stockAllDataFull+"\\600\\";
				}

				if (stockColData[0].startsWith("sz002") || stockColData[0].startsWith("sz003"))  // 中小板
				{
					stockDataFolder=stockAllDataFull+"\\002\\";
				}
				
				if (stockColData[0].startsWith("sz000") || stockColData[0].startsWith("sz001"))   // 深市主板
				{
					stockDataFolder=stockAllDataFull+"\\000\\";				
				}
				
				if (stockColData[0].startsWith("sz3"))     // 创业板
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
					
					// 创建新的 Stock 原始数据集
					String columnDef=getStockSqlColumnDef_history(); 
					CommonTool.createSASDataSet(stockDataFolder, fileName, columnDef);
					CommonTool.insertDataToSASDataSet(stockDataFolder, fileName, dataDef);
					
					
				}
				
				// 添加到All目录下转换后的数据集中
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
					// 创建新的 Stock All数据集
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

		// ****** 读取 index 指数数据并更新指数数据集 ****** 
		if (code.startsWith("index"))
		{
		
			String indexCode=code.substring(5);   // 取 index000001 中的数字 000001 
			
			try
			{
				
				List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\indexdata.csv");
				
				for (int i=1; i<csvLines.size(); i++)
	//			for (int i=1; i<10; i++)
				{
	
					// 读取一行csv数据，对应的是一个指数当日全景数据
					String dataLine=csvLines.get(i).toString();
					String[] indexColData=dataLine.split(",");
					
					if (indexColData[0].contains(indexCode))  // 如果 sh000001, sz399001 包含上述 code=000001 则插入此条数据
					{
						
						System.out.println("process index code: "+indexCode);
						
						// 添加到index目录下的原始数据集中
						String dataDef=getIndexSqlDataDef_history(indexColData);
		//				System.out.println(dataDef);
						
						// 找到对应的文件夹下的index文件
						String fileName=indexColData[0];
						String indexDataFolder=stockAllDataFull+"\\index\\";
						
						File indexFile=new File(indexDataFolder+"\\"+fileName+".sas7bdat");
						if (indexFile.exists())
						{
							CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
						}
						else
						{
							
							// 创建新的 index 数据集
							String columnDef=getIndexSqlColumnDef_history();
							CommonTool.createSASDataSet(indexDataFolder, fileName, columnDef);
							CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
							
						}
						
						// 添加到All目录下转换后的index数据集中
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
							// 创建新的 index 数据集并插入数据
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
		
		
		// ****** 读取 stock 股票数据并更新股票数据集 ****** 
		if (code.startsWith("stock"))
		{
			
			String stockCode=code.substring(5);   // 取 index000001 中的数字 000001 
			
			try
			{
				
				List csvLines=FileTool.readLinesFromFile(newFolderPath+"\\stockoverview.csv");
				List newStockFileList=new ArrayList();
				
				for (int i=1; i<csvLines.size(); i++)
	//			for (int i=1; i<10; i++)
				{
	
					// 读取一行csv数据，对应的是一只股票的当日全景数据
					String dataLine=csvLines.get(i).toString();
					String[] stockColData=dataLine.split(",");
					
					
					if (stockColData[0].contains(stockCode))  // 如果 sh000001, sz399001 包含上述 code=000001 则插入此条数据
					{
					
						System.out.println("process stock code: "+stockCode);
						
						// 添加到600,000,002,300目录下的原始数据集中
						String dataDef=getStockSqlDataDef_history(stockColData);
		//				System.out.println(dataDef);
						
						// 找到对应的文件夹下的stock文件
						String fileName=stockColData[0];
						String stockDataFolder="";
						if (stockColData[0].startsWith("sh6"))   // 沪市主板
						{
							stockDataFolder=stockAllDataFull+"\\600\\";
						}
		
						if (stockColData[0].startsWith("sz002") || stockColData[0].startsWith("sz003"))  // 中小板
						{
							stockDataFolder=stockAllDataFull+"\\002\\";
						}
						
						if (stockColData[0].startsWith("sz000") || stockColData[0].startsWith("sz001"))   // 深市主板
						{
							stockDataFolder=stockAllDataFull+"\\000\\";				
						}
						
						if (stockColData[0].startsWith("sz3"))     // 创业板
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
							
							// 创建新的 Stock 原始数据集
							String columnDef=getStockSqlColumnDef_history(); 
							CommonTool.createSASDataSet(stockDataFolder, fileName, columnDef);
							CommonTool.insertDataToSASDataSet(stockDataFolder, fileName, dataDef);
							
							
						}
						
						// 添加到All目录下转换后的数据集中
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
							// 创建新的 Stock All数据集
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
				CommonTool.getSqlStrColumnDef("scode_org", 12)+    // 股票代码
				CommonTool.getSqlStrColumnDef("sname_org", 12)+	 // 股票名称
				CommonTool.getSqlDateColumnDef("date_org")+  // 交易日期
				CommonTool.getSqlStrColumnDef("industry", 30)+	 // 行业
				CommonTool.getSqlStrColumnDef("concept", 200)+	 // 概念
				CommonTool.getSqlStrColumnDef("location", 20)+	 // 地域
				CommonTool.getSqlNumberColumnDef("open")+	// 开盘价
				CommonTool.getSqlNumberColumnDef("high")+	// 最高价
				CommonTool.getSqlNumberColumnDef("low")+	// 最低价
				CommonTool.getSqlNumberColumnDef("final")+	// 收盘价
				CommonTool.getSqlNumberColumnDef("af_final")+	// 后复权价
				CommonTool.getSqlNumberColumnDef("pf_final")+	// 前复权价
				CommonTool.getSqlNumberColumnDef("rise")+	// 涨跌幅
				CommonTool.getSqlNumberColumnDef("amount", "int", "BEST12.")+	// 成交量
				CommonTool.getSqlNumberColumnDef("money", "int", "BEST12.")+	// 成交额
				CommonTool.getSqlNumberColumnDef("change_ratio")+	// 换手率
				CommonTool.getSqlNumberColumnDef("liquid_value")+	// 流通市值
				CommonTool.getSqlNumberColumnDef("total_value")+	// 总市值
				CommonTool.getSqlNumberColumnDef("is_up_stop", "int", "BEST12.")+	// 是否涨停
				CommonTool.getSqlNumberColumnDef("is_down_stop", "int", "BEST12.")+	// 是否跌停				
				CommonTool.getSqlNumberColumnDef("pe_ratio")+	// 市盈率TTM
				CommonTool.getSqlNumberColumnDef("ps_ratio")+	// 市销率TTM
				CommonTool.getSqlNumberColumnDef("px_ratio")+ // 市现率TTM
				CommonTool.getSqlNumberColumnDef("pj_ratio")+	// 市净率
				CommonTool.getSqlNumberColumnDef("MA_5")+	// MA_5
				CommonTool.getSqlNumberColumnDef("MA_10")+	// MA_10
				CommonTool.getSqlNumberColumnDef("MA_20")+	// MA_20
				CommonTool.getSqlNumberColumnDef("MA_30")+	// MA_30
				CommonTool.getSqlNumberColumnDef("MA_60")+	// MA_60
				CommonTool.getSqlStrColumnDef("ma_jcsc", 400)+		// MA_金叉死叉
				CommonTool.getSqlNumberColumnDef("MACD_DIF")+	// MACD_DIF
				CommonTool.getSqlNumberColumnDef("MACD_DEA")+	// MACD_DEA
				CommonTool.getSqlNumberColumnDef("MACD_MACD")+	// MACD_MACD
				CommonTool.getSqlStrColumnDef("macd_jcsc", 20)+		// MACD_金叉死叉
				CommonTool.getSqlNumberColumnDef("KDJ_K")+	// KDJ_K
				CommonTool.getSqlNumberColumnDef("KDJ_D")+	// KDJ_D
				CommonTool.getSqlNumberColumnDef("KDJ_J")+	// KDJ_J
				CommonTool.getSqlStrColumnDef("kdj_jcsc", 20)+		// KDJ_金叉死叉
				CommonTool.getSqlNumberColumnDef("blx_middle")+	// 布林线中轨
				CommonTool.getSqlNumberColumnDef("blx_up")+	// 布林线上轨
				CommonTool.getSqlNumberColumnDef("blx_down")+	// 布林线下轨
				CommonTool.getSqlNumberColumnDef("psy")+	// psy
				CommonTool.getSqlNumberColumnDef("psyma")+	// psyma
				CommonTool.getSqlNumberColumnDef("rsi1")+	// rsi1
				CommonTool.getSqlNumberColumnDef("rsi2")+	// rsi2
				CommonTool.getSqlNumberColumnDef("rsi3")+	// rsi3
				CommonTool.getSqlNumberColumnDef("swing")+	// 振幅
				CommonTool.getSqlNumberColumnDef("eq_ratio").replace(",", "")  //量比  
				
		;
		
		
		return columnDef;
		
	}
	
	
	public String getStockSqlColumnDef_all()
	{
		
		String columnDef_all="";
	
		columnDef_all=
				CommonTool.getSqlStrColumnDef("scode_org", 12)+    // 股票代码
				CommonTool.getSqlStrColumnDef("sname_org", 12)+	 // 股票名称
				CommonTool.getSqlDateColumnDef("date_org")+  // 交易日期
				CommonTool.getSqlStrColumnDef("industry", 30)+	 // 行业
				CommonTool.getSqlStrColumnDef("concept", 200)+	 // 概念
				CommonTool.getSqlStrColumnDef("location", 20)+	 // 地域
				CommonTool.getSqlNumberColumnDef("open")+	// 开盘价
				CommonTool.getSqlNumberColumnDef("high")+	// 最高价
				CommonTool.getSqlNumberColumnDef("low")+	// 最低价
				CommonTool.getSqlNumberColumnDef("final")+	// 收盘价
				CommonTool.getSqlNumberColumnDef("af_final")+	// 后复权价
				CommonTool.getSqlNumberColumnDef("pf_final")+	// 前复权价
				CommonTool.getSqlNumberColumnDef("rise")+	// 涨跌幅
				CommonTool.getSqlNumberColumnDef("amount", "int", "BEST12.")+	// 成交量
				CommonTool.getSqlNumberColumnDef("money", "int", "BEST12.")+	// 成交额
				CommonTool.getSqlNumberColumnDef("change_ratio")+	// 换手率
				CommonTool.getSqlNumberColumnDef("liquid_value")+	// 流通市值
				CommonTool.getSqlNumberColumnDef("total_value")+	// 总市值
				CommonTool.getSqlNumberColumnDef("is_up_stop", "int", "BEST12.")+	// 是否涨停
				CommonTool.getSqlNumberColumnDef("is_down_stop", "int", "BEST12.")+	// 是否跌停				
				CommonTool.getSqlNumberColumnDef("pe_ratio")+	// 市盈率TTM
				CommonTool.getSqlNumberColumnDef("ps_ratio")+	// 市销率TTM
				CommonTool.getSqlNumberColumnDef("px_ratio")+ // 市现率TTM
				CommonTool.getSqlNumberColumnDef("pj_ratio")+	// 市净率
				CommonTool.getSqlNumberColumnDef("MA_5")+	// MA_5
				CommonTool.getSqlNumberColumnDef("MA_10")+	// MA_10
				CommonTool.getSqlNumberColumnDef("MA_20")+	// MA_20
				CommonTool.getSqlNumberColumnDef("MA_30")+	// MA_30
				CommonTool.getSqlNumberColumnDef("MA_60")+	// MA_60
				CommonTool.getSqlStrColumnDef("ma_jcsc", 400)+		// MA_金叉死叉
				CommonTool.getSqlNumberColumnDef("MACD_DIF")+	// MACD_DIF
				CommonTool.getSqlNumberColumnDef("MACD_DEA")+	// MACD_DEA
				CommonTool.getSqlNumberColumnDef("MACD_MACD")+	// MACD_MACD
				CommonTool.getSqlStrColumnDef("macd_jcsc", 20)+		// MACD_金叉死叉
				CommonTool.getSqlNumberColumnDef("KDJ_K")+	// KDJ_K
				CommonTool.getSqlNumberColumnDef("KDJ_D")+	// KDJ_D
				CommonTool.getSqlNumberColumnDef("KDJ_J")+	// KDJ_J
				CommonTool.getSqlStrColumnDef("kdj_jcsc", 20)+		// KDJ_金叉死叉
				CommonTool.getSqlNumberColumnDef("blx_middle")+	// 布林线中轨
				CommonTool.getSqlNumberColumnDef("blx_up")+	// 布林线上轨
				CommonTool.getSqlNumberColumnDef("blx_down")+	// 布林线下轨
				CommonTool.getSqlNumberColumnDef("psy")+	// psy
				CommonTool.getSqlNumberColumnDef("psyma")+	// psyma
				CommonTool.getSqlNumberColumnDef("rsi1")+	// rsi1
				CommonTool.getSqlNumberColumnDef("rsi2")+	// rsi2
				CommonTool.getSqlNumberColumnDef("rsi3")+	// rsi3
				CommonTool.getSqlNumberColumnDef("swing")+	// 振幅
				CommonTool.getSqlNumberColumnDef("eq_ratio")+  //量比  
				
				CommonTool.getSqlStrColumnDef("scode", 12)+	// 股票代码
				CommonTool.getSqlStrColumnDef("sname", 12)+	// 股票名称
				CommonTool.getSqlStrColumnDef("date", 200)+	// 交易日期
				CommonTool.getSqlNumberColumnDef("open_rise", "double precision", "12.2")+	// 开盘涨幅
				CommonTool.getSqlNumberColumnDef("high_rise", "double precision", "12.2")+	// 最高涨幅
				CommonTool.getSqlNumberColumnDef("low_rise",  "double precision", "12.2")+	// 最低涨幅
				CommonTool.getSqlNumberColumnDef("final_rise", "double precision", "12.2").replace(",", "")	// 收盘涨幅
				
		;
		
		return columnDef_all;
		
	}
	
	
	
	public String getStockSqlDataDef_history(String[] stockColData)
	{
		String dataDef="";
	
		dataDef=
				CommonTool.getSqlStrDataDef(stockColData[0])+    // 股票代码
				CommonTool.getSqlStrDataDef(stockColData[1])+	 // 股票名称
				CommonTool.getSqlDateDataDef(stockColData[2])+    // 交易日期
				CommonTool.getSqlStrDataDef(stockColData[3])+	 // 行业
				CommonTool.getSqlStrDataDef(stockColData[4])+	 // 概念
				CommonTool.getSqlStrDataDef(stockColData[5])+	 // 地域
				CommonTool.getSqlNumberDataDef(stockColData[6])+	// 开盘价
				CommonTool.getSqlNumberDataDef(stockColData[7])+	// 最高价
				CommonTool.getSqlNumberDataDef(stockColData[8])+	// 最低价
				CommonTool.getSqlNumberDataDef(stockColData[9])+	// 收盘价
				CommonTool.getSqlNumberDataDef(stockColData[10])+	// 后复权价
				CommonTool.getSqlNumberDataDef(stockColData[11])+	// 前复权价
				CommonTool.getSqlNumberDataDef(stockColData[12])+	// 涨跌幅
				CommonTool.getSqlNumberDataDef(stockColData[13])+	// 成交量
				CommonTool.getSqlNumberDataDef(stockColData[14])+	// 成交额
				CommonTool.getSqlNumberDataDef(stockColData[15])+	// 换手率
				CommonTool.getSqlNumberDataDef(stockColData[16])+	// 流通市值
				CommonTool.getSqlNumberDataDef(stockColData[17])+	// 总市值
				CommonTool.getSqlNumberDataDef(stockColData[18])+	// 是否涨停
				CommonTool.getSqlNumberDataDef(stockColData[19])+	// 是否跌停				
				CommonTool.getSqlNumberDataDef(stockColData[20])+	// 市盈率TTM
				CommonTool.getSqlNumberDataDef(stockColData[21])+	// 市销率TTM
				CommonTool.getSqlNumberDataDef(stockColData[22])+   // 市现率TTM
				CommonTool.getSqlNumberDataDef(stockColData[23])+	// 市净率
				CommonTool.getSqlNumberDataDef(stockColData[24])+	// MA_5
				CommonTool.getSqlNumberDataDef(stockColData[25])+	// MA_10
				CommonTool.getSqlNumberDataDef(stockColData[26])+	// MA_20
				CommonTool.getSqlNumberDataDef(stockColData[27])+	// MA_30
				CommonTool.getSqlNumberDataDef(stockColData[28])+	// MA_60
				CommonTool.getSqlStrDataDef(stockColData[29])+		// MA_金叉死叉
				CommonTool.getSqlNumberDataDef(stockColData[30])+	// MACD_DIF
				CommonTool.getSqlNumberDataDef(stockColData[31])+	// MACD_DEA
				CommonTool.getSqlNumberDataDef(stockColData[32])+	// MACD_MACD
				CommonTool.getSqlStrDataDef(stockColData[33])+		// MACD_金叉死叉
				CommonTool.getSqlNumberDataDef(stockColData[34])+	// KDJ_K
				CommonTool.getSqlNumberDataDef(stockColData[35])+	// KDJ_D
				CommonTool.getSqlNumberDataDef(stockColData[36])+	// KDJ_J
				CommonTool.getSqlStrDataDef(stockColData[37])+		// KDJ_金叉死叉
				CommonTool.getSqlNumberDataDef(stockColData[38])+	// 布林线中轨
				CommonTool.getSqlNumberDataDef(stockColData[39])+	// 布林线上轨
				CommonTool.getSqlNumberDataDef(stockColData[40])+	// 布林线下轨
				CommonTool.getSqlNumberDataDef(stockColData[41])+	// psy
				CommonTool.getSqlNumberDataDef(stockColData[42])+	// psyma
				CommonTool.getSqlNumberDataDef(stockColData[43])+	// rsi1
				CommonTool.getSqlNumberDataDef(stockColData[44])+	// rsi2
				CommonTool.getSqlNumberDataDef(stockColData[45])+	// rsi3
				CommonTool.getSqlNumberDataDef(stockColData[46])+	// 振幅
				CommonTool.getSqlNumberDataDef(stockColData[47]).replace(",", "")    //量比   
				
		;
		
		return dataDef;
		
	}
	
	public String getStockSqlDataDef_all(String[] stockColData)
	{
		String dataDef_all="";
	
		// 生成 scode, sname, date
		String scode=stockColData[0].substring(2);
		String sname=stockColData[1];
		String date=stockColData[2].replace("-", "/");
		
		// 计算 open_rise, high_rise, low_rise, final_rise
		double rise=CommonTool.converToDoubleNumber(stockColData[12]);
		double open=CommonTool.converToDoubleNumber(stockColData[6]);
		double high=CommonTool.converToDoubleNumber(stockColData[7]);
		double low=CommonTool.converToDoubleNumber(stockColData[8]);
		double close=CommonTool.converToDoubleNumber(stockColData[9]);
		
		double y_final=close/(1+rise);  // 昨日收盘价
		double open_rise=(open/y_final-1)*100;
		double high_rise=(high/y_final-1)*100;
		double low_rise=(low/y_final-1)*100;
		double final_rise=rise*100;
		
		
		dataDef_all=
				CommonTool.getSqlStrDataDef(stockColData[0])+    // 股票代码
				CommonTool.getSqlStrDataDef(stockColData[1])+	 // 股票名称
				CommonTool.getSqlDateDataDef(stockColData[2])+    // 交易日期
				CommonTool.getSqlStrDataDef(stockColData[3])+	 // 行业
				CommonTool.getSqlStrDataDef(stockColData[4])+	 // 概念
				CommonTool.getSqlStrDataDef(stockColData[5])+	 // 地域
				CommonTool.getSqlNumberDataDef(stockColData[6])+	// 开盘价
				CommonTool.getSqlNumberDataDef(stockColData[7])+	// 最高价
				CommonTool.getSqlNumberDataDef(stockColData[8])+	// 最低价
				CommonTool.getSqlNumberDataDef(stockColData[9])+	// 收盘价
				CommonTool.getSqlNumberDataDef(stockColData[10])+	// 后复权价
				CommonTool.getSqlNumberDataDef(stockColData[11])+	// 前复权价
				CommonTool.getSqlNumberDataDef(stockColData[12])+	// 涨跌幅
				CommonTool.getSqlNumberDataDef(stockColData[13])+	// 成交量
				CommonTool.getSqlNumberDataDef(stockColData[14])+	// 成交额
				CommonTool.getSqlNumberDataDef(stockColData[15])+	// 换手率
				CommonTool.getSqlNumberDataDef(stockColData[16])+	// 流通市值
				CommonTool.getSqlNumberDataDef(stockColData[17])+	// 总市值
				CommonTool.getSqlNumberDataDef(stockColData[18])+	// 是否涨停
				CommonTool.getSqlNumberDataDef(stockColData[19])+	// 是否跌停				
				CommonTool.getSqlNumberDataDef(stockColData[20])+	// 市盈率TTM
				CommonTool.getSqlNumberDataDef(stockColData[21])+	// 市销率TTM
				CommonTool.getSqlNumberDataDef(stockColData[22])+   // 市现率TTM
				CommonTool.getSqlNumberDataDef(stockColData[23])+	// 市净率
				CommonTool.getSqlNumberDataDef(stockColData[24])+	// MA_5
				CommonTool.getSqlNumberDataDef(stockColData[25])+	// MA_10
				CommonTool.getSqlNumberDataDef(stockColData[26])+	// MA_20
				CommonTool.getSqlNumberDataDef(stockColData[27])+	// MA_30
				CommonTool.getSqlNumberDataDef(stockColData[28])+	// MA_60
				CommonTool.getSqlStrDataDef(stockColData[29])+		// MA_金叉死叉
				CommonTool.getSqlNumberDataDef(stockColData[30])+	// MACD_DIF
				CommonTool.getSqlNumberDataDef(stockColData[31])+	// MACD_DEA
				CommonTool.getSqlNumberDataDef(stockColData[32])+	// MACD_MACD
				CommonTool.getSqlStrDataDef(stockColData[33])+		// MACD_金叉死叉
				CommonTool.getSqlNumberDataDef(stockColData[34])+	// KDJ_K
				CommonTool.getSqlNumberDataDef(stockColData[35])+	// KDJ_D
				CommonTool.getSqlNumberDataDef(stockColData[36])+	// KDJ_J
				CommonTool.getSqlStrDataDef(stockColData[37])+		// KDJ_金叉死叉
				CommonTool.getSqlNumberDataDef(stockColData[38])+	// 布林线中轨
				CommonTool.getSqlNumberDataDef(stockColData[39])+	// 布林线上轨
				CommonTool.getSqlNumberDataDef(stockColData[40])+	// 布林线下轨
				CommonTool.getSqlNumberDataDef(stockColData[41])+	// psy
				CommonTool.getSqlNumberDataDef(stockColData[42])+	// psyma
				CommonTool.getSqlNumberDataDef(stockColData[43])+	// rsi1
				CommonTool.getSqlNumberDataDef(stockColData[44])+	// rsi2
				CommonTool.getSqlNumberDataDef(stockColData[45])+	// rsi3
				CommonTool.getSqlNumberDataDef(stockColData[46])+	// 振幅
				CommonTool.getSqlNumberDataDef(stockColData[47])+   // 量比
				
				CommonTool.getSqlStrDataDef(scode)+				// 股票代码
				CommonTool.getSqlStrDataDef(sname)+				// 股票名称
				CommonTool.getSqlStrDataDef(date)+				// 交易日期
				CommonTool.getSqlNumberDataDef(open_rise+"")+   // 开盘涨幅
				CommonTool.getSqlNumberDataDef(high_rise+"")+	// 最高涨幅
				CommonTool.getSqlNumberDataDef(low_rise+"")+	// 最低涨幅
				CommonTool.getSqlNumberDataDef(final_rise+"").replace(",", "")   // 收盘涨幅
				
		;	
		
		return dataDef_all;
	}
	
	
	public String getIndexSqlColumnDef_history()
	{
		
		String columnDef="";
		
		columnDef=
				CommonTool.getSqlStrColumnDef("index_code", 12)+    // 指数代码
				CommonTool.getSqlDateColumnDef("date")+	 // 交易日期
				CommonTool.getSqlNumberColumnDef("open")+  // 开盘值
				CommonTool.getSqlNumberColumnDef("close")+	 // 收盘值
				CommonTool.getSqlNumberColumnDef("low")+	 // 最低值
				CommonTool.getSqlNumberColumnDef("high")+	 // 最高值
				CommonTool.getSqlNumberColumnDef("volume")+	// 成交量
				CommonTool.getSqlNumberColumnDef("money")+	// 成交额
				CommonTool.getSqlNumberColumnDef("change").replace(",", "")	// 涨跌幅
				
		;
		
		return columnDef;
		
	}
	
	
	public String getIndexSqlColumnDef_all()
	{
		
		String columnDef="";
		
		columnDef=
				CommonTool.getSqlStrColumnDef("code_org_i", 12)+    // 指数代码
				CommonTool.getSqlDateColumnDef("date_org_i")+	 // 交易日期
				CommonTool.getSqlNumberColumnDef("open_i")+  // 开盘值
				CommonTool.getSqlNumberColumnDef("final_i")+	 // 收盘值
				CommonTool.getSqlNumberColumnDef("low_i")+	 // 最低值
				CommonTool.getSqlNumberColumnDef("high_i")+	 // 最高值
				CommonTool.getSqlNumberColumnDef("amount_i")+	// 成交量
				CommonTool.getSqlNumberColumnDef("money_i")+	// 成交额
				CommonTool.getSqlNumberColumnDef("change_i")+	// 涨跌幅
				
				CommonTool.getSqlStrColumnDef("code_i", 12)+	// 指数代码
				CommonTool.getSqlStrColumnDef("date", 12)+	// 交易日期
				CommonTool.getSqlNumberColumnDef("open_rise_i", "double precision", "12.2")+	// 开盘涨幅
				CommonTool.getSqlNumberColumnDef("high_rise_i", "double precision", "12.2")+	// 最高涨幅
				CommonTool.getSqlNumberColumnDef("low_rise_i", "double precision", "12.2")+	// 最低涨幅
				CommonTool.getSqlNumberColumnDef("final_rise_i", "double precision", "12.2").replace(",", "")	// 收盘涨幅
				
		;
		
		return columnDef;
		
	}
	
	
	public String getIndexSqlDataDef_history(String[] indexColData)
	{
		String dataDef="";
	
		dataDef=
				CommonTool.getSqlStrDataDef(indexColData[0])+    // 指数代码
				CommonTool.getSqlDateDataDef(indexColData[1])+	 // 交易日期
				CommonTool.getSqlNumberDataDef(indexColData[2])+    // 开盘值
				CommonTool.getSqlNumberDataDef(indexColData[3])+	 // 收盘值
				CommonTool.getSqlNumberDataDef(indexColData[4])+	 // 最低值
				CommonTool.getSqlNumberDataDef(indexColData[5])+	 // 最高值
				CommonTool.getSqlNumberDataDef(indexColData[6])+	// 成交量
				CommonTool.getSqlNumberDataDef(indexColData[7])+	// 成交额
				CommonTool.getSqlNumberDataDef(indexColData[8]).replace(",", "")	// 涨跌幅
				
		;
		
		return dataDef;
		
	}
	
	
	public String getIndexSqlDataDef_all(String[] indexColData)
	{
		String dataDef="";
	
		// 生成 code, date
		String code=indexColData[0].substring(2);
		String date=indexColData[1].replace("-", "/");
		
		// 计算 open_rise, high_rise, low_rise, final_rise
		double rise=CommonTool.converToDoubleNumber(indexColData[8]);
		double open=CommonTool.converToDoubleNumber(indexColData[2]);
		double high=CommonTool.converToDoubleNumber(indexColData[5]);
		double low=CommonTool.converToDoubleNumber(indexColData[4]);
		double close=CommonTool.converToDoubleNumber(indexColData[3]);
		
		double y_final=close/(1+rise);  // 昨日收盘价
		double open_rise=(open/y_final-1)*100;
		double high_rise=(high/y_final-1)*100;
		double low_rise=(low/y_final-1)*100;
		double final_rise=rise*100;
		
		dataDef=
				CommonTool.getSqlStrDataDef(indexColData[0])+    // 指数代码
				CommonTool.getSqlDateDataDef(indexColData[1])+	 // 交易日期
				CommonTool.getSqlNumberDataDef(indexColData[2])+    // 开盘值
				CommonTool.getSqlNumberDataDef(indexColData[3])+	 // 收盘值
				CommonTool.getSqlNumberDataDef(indexColData[4])+	 // 最低值
				CommonTool.getSqlNumberDataDef(indexColData[5])+	 // 最高值
				CommonTool.getSqlNumberDataDef(indexColData[6])+	// 成交量
				CommonTool.getSqlNumberDataDef(indexColData[7])+	// 成交额
				CommonTool.getSqlNumberDataDef(indexColData[8])+	// 涨跌幅
				
				CommonTool.getSqlStrDataDef(code)+				// 指数代码
				CommonTool.getSqlStrDataDef(date)+				// 交易日期
				CommonTool.getSqlNumberDataDef(open_rise+"")+   // 开盘涨幅
				CommonTool.getSqlNumberDataDef(high_rise+"")+	// 最高涨幅
				CommonTool.getSqlNumberDataDef(low_rise+"")+	// 最低涨幅
				CommonTool.getSqlNumberDataDef(final_rise+"").replace(",", "")   // 收盘涨幅
				
		;
		
		return dataDef;
		
	}
	

	
	public void testCreate()
	{
		
		
		String fileName="sh000004";
		String indexDataFolder=stockAllDataFull+"\\test\\";
		
		String columnDef="";
		columnDef=
				CommonTool.getSqlStrColumnDef("index_code", 12)+    // 指数代码
				CommonTool.getSqlDateColumnDef("date").replace(",", "")+	" PRIMARY KEY, "+ // 交易日期
				CommonTool.getSqlNumberColumnDef("open")+  // 开盘值
				CommonTool.getSqlNumberColumnDef("close")+	 // 收盘值
				CommonTool.getSqlNumberColumnDef("low")+	 // 最低值
				CommonTool.getSqlNumberColumnDef("high")+	 // 最高值
				CommonTool.getSqlNumberColumnDef("volume")+	// 成交量
				CommonTool.getSqlNumberColumnDef("money")+	// 成交额
				CommonTool.getSqlNumberColumnDef("change").replace(",", "")	// 涨跌幅 
		;

		
		// 创建新的 Index 数据集
		CommonTool.createSASDataSet(indexDataFolder, fileName, columnDef);
//		CommonTool.insertDataToSASDataSet(indexDataFolder, fileName, dataDef);
		
		String fileNameAll="index"+fileName.substring(2);
		String stockDataFolderAll=stockAllDataFull+"\\test\\";
		
		// 创建新的sas数据集并插入数据
		String columnDef_all=getIndexSqlColumnDef_all();
		CommonTool.createSASDataSet(stockDataFolderAll, fileNameAll, columnDef_all);
//		CommonTool.insertDataToSASDataSet(stockDataFolderAll, fileNameAll, dataDef);
		
		
		
	}
}
