package com.finance.stock.gui;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FileTool {

	static String eachFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\each\\11";
	
	public static void main(String args[])
	{
		
		FileTool ft=new FileTool();
		
		// 处理历史多日分笔数据（改名字）
//		List folderNameList=getFileNameList(eachFolder);
//		for(int i=0; i<folderNameList.size(); i++)
//		{
//			String fileFolder=eachFolder+"\\"+folderNameList.get(i);
//			System.out.println(fileFolder);
//			ft.processFileForFenbiFile(fileFolder);
//		}
		
		// 处理每日分笔数据（改名字）		
//		ft.processFileForFenbiFile(fileFolder);
		
		// 处理每日市场全景数据（改名字）
//		ft.processFileForDayFile(fileFolder);
		
		// 删除历史多日数据的csv文件（删除CSV文件）
//		ft.deleteCSVFileByCMD("2017-07");
		
//		String dataType="index";  	// 指数
//		String dataType="day";	  	// 股票、ETF 日线 
//		String dataType="minute1";	// 股票、ETF 1分钟线
//		String dataType="minute5";	// 股票、ETF 5分钟线
		String dataType="minute15";	// 股票、ETF 15分钟线
//		String dataType="minute30"; // 股票、ETF 30分钟线
//		String dataType="minute60"; // 股票、ETF 60分钟线
//		String dataType="fund";		// 基金净值 日线
		
		String inFileFolder="C:\\new_tdx\\T0002\\export\\"+dataType;
		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\"+dataType;
		
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\fundhold";
//		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\fundhold";
		
		// 处理通达信导出的股指数据（去空格，格式化）
//		String inFileFolder="C:\\new_tdx\\T0002\\export";
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\week";
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\year";
		
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\index";
//		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\index";
		
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\minute1";
//		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\minute1";
	
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\minute30";
//		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\minute30";
	
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\minute60";
//		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\minute60";
		
//		String inFileFolder="C:\\new_tdx\\T0002\\export\\day";
//		String outFileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\tdx\\day";
		
		ft.processFileForTdxFile(inFileFolder, outFileFolder);
		
//		ft.processFileForFundHoldFile(inFileFolder, outFileFolder);
		
		
//		String fileFolder="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\test";
//		String dateStr="2018/05/25";
//		ft.deleteDailyData(fileFolder, dateStr);
		
		
	}
	
	public static void renameFile(String fileFolder, String oldName, String newName)
	{
		
		File file=new File(fileFolder+"\\"+oldName);
		file.renameTo(new File(fileFolder+"\\"+newName)); 
		
		System.out.println("Rename file: "+oldName+" to "+newName);
		
	}
	
	public static List getFileNameList(String fileFolder)
	{
		List fileNameList=new ArrayList();
		
		File fileFolderObj=new File(fileFolder);
		File files[] = fileFolderObj.listFiles();
		if (files==null)
			return fileNameList;
		
		for (int i = 0; i < files.length; i++) {
		
			fileNameList.add(files[i].getName());
		}

		return fileNameList;
		
	}
	
	public static void copyFolderFile(String oldSuperFolder, String newSuperFolder, String folderName)
	{
		
		
	}
	
	public static void deleteCSVFileByCMD(String year_month)
	{
		List folderNameList=getFileNameList(eachFolder);
		
		for(int i=0; i<folderNameList.size(); i++)
		{
			String folderName=folderNameList.get(i).toString();
			String fileFolder=eachFolder+"\\"+folderName+"\\*.csv";
			
			if (folderName.contains(year_month))
			{
				try
				{
					String cmd="cmd.exe /c del "+fileFolder;
					System.out.println(cmd);
					Runtime.getRuntime().exec(cmd);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	public void processFileForFenbiFile(String fileFolder)
	{
		
		List fileNameList=getFileNameList(fileFolder);
		for (int i=0; i<fileNameList.size(); i++)
		{
			
			String oldName=(String)fileNameList.get(i);   // oldname: "2017-01-03 sh600008 fenbi.csv"
			if (oldName.length()<29)
				continue;
			
			String tmpName=oldName.replace(" ", "").replace("-", "");  // change to: "20170103sh600008fenbi.csv"
			String newName=tmpName.substring(8,16)+"_"+tmpName.substring(16,21)+"_"+tmpName.substring(0,8)+".csv";
			
			renameFile(fileFolder, oldName, newName);
		}
		
	}
	
	public static void deleteDailyData(String fileFolder, String dateStr)
	{
	
		dateStr=CommonTool.getSqlDateDataDef(dateStr); // 转化成SAS Date格式： 2018/05/25 -> "25May2018"d
		dateStr=dateStr.substring(0, dateStr.length()-1);
		
		List fileNameList=getFileNameList(fileFolder);
		for (int i=0; i<fileNameList.size(); i++)
		{
			
			String filename=(String)fileNameList.get(i);   // oldname: "2017-01-03 sh600008 fenbi.csv"
			int pos=filename.indexOf(".");
			filename=filename.substring(0, pos);
			
			Connection con = null;
			Statement stmt = null;
			boolean result = false;
			
			try
			{
				con=CommonTool.getSASDatasetConnection(fileFolder);
				stmt = con.createStatement();
							
				if (filename.startsWith("index") || fileFolder.endsWith("index"))  // 处理index指数数据集
				{
					String sql="delete from stocklib."+filename+" where date_org_i="+dateStr;
					System.out.println(sql);
					result =stmt.execute(sql);
				}
//				else		// 处理stock股票数据集
//				{
//					String sql="delete from stocklib."+filename+" where date_org="+dateStr;
//					System.out.println(sql);
//					result =stmt.execute(sql);
//				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			
		}
	
	}
	
	public void processFileForTdxFile(String inFileFolder, String outFileFolder)
	{
		
		List fileNameList=getFileNameList(inFileFolder);
		for (int i=0; i<fileNameList.size(); i++)
		{
			
			String inFileName=(String)fileNameList.get(i);  
			String inFileFullPath=inFileFolder+"\\"+inFileName;
			String outFileFullPath=outFileFolder+"\\"+inFileName;
			List allLines=readLinesFromFile(inFileFullPath);
			writeLinesToFile(allLines, outFileFullPath);
			
			
		}
		
	}
	
	public void processFileForFundHoldFile(String inFileFolder, String outFileFolder)
	{
		
		List fileNameList=getFileNameList(inFileFolder);
		for (int i=0; i<fileNameList.size(); i++)
		{
			
			String inFileName=(String)fileNameList.get(i);  
			String inFileFullPath=inFileFolder+"\\"+inFileName;
			String outFileFullPath=outFileFolder+"\\"+inFileName;
			List allLines=readLinesFromFile(inFileFullPath);
			writeLinesToFileForFundHold(allLines, outFileFullPath);
			
			
		}
		
	}
	
	
	public static void createFolder(String folderPath)
	{
		File f=new File(folderPath);
		if (!f.exists())
		{
			if (f.mkdirs()==false)
			{
				System.out.println("Failed to create folder.");
			}
			else
			{
				System.out.println("Create folder: "+folderPath);
			}
		}
		
	}
	
    public static boolean downloadZipFileFromURL(String urlStr, String filePath) 
    {
    	
        boolean result=false;
        
        int bytesum = 0;
        int byteread = 0;

        try 
        {
        	URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();  

        	// 先获得downloadURL字符串
            byte[] buffer = new byte[1024];
            byteread = inStream.read(buffer);  
            
        	String downloadURL=new String(buffer);
        	downloadURL=downloadURL.trim();
        	System.out.println(downloadURL.trim());
        	
        	if (downloadURL!=null && downloadURL.contains("zip"))
        	{
        		
                // 下载zip文件
                url = new URL(downloadURL);
                conn = url.openConnection();
                inStream = conn.getInputStream();  
                FileOutputStream fs = new FileOutputStream(filePath);
                
                byte[] buffer_zip = new byte[1024];
                while ((byteread = inStream.read(buffer_zip)) != -1) 
                {
                    bytesum += byteread;
                    System.out.println("Read byte: "+bytesum);

                	fs.write(buffer_zip, 0, byteread);
                	System.out.println("Get file successfully.");
                	result=true;
                    
                }    
                
                fs.close();                
            
            }   
        	    
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        
        return result;
        
    }
    
    public static List readLinesFromFile(String filePath)
    {
    
    	List allLines = new ArrayList();
    	
    	File f=new File(filePath);
    	if (!f.exists())
    	{
    		System.out.println("File not exist: "+filePath);
    		return allLines;    // 文件不存在，返回空List
    	}
    	
	    BufferedReader br = null;
	    try
	    {
	        br = new BufferedReader(new FileReader(f));
	    } 
	    catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    
	    String line = "";
	    String everyLine = "";
	    try {
	          
	            while ((line = br.readLine()) != null)  //读取到的内容给line变量
	            {
	                everyLine = line;
	                allLines.add(everyLine);
	            }
	            
	            System.out.println("文件中的所有行数："+allLines.size());
	            
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    
	    return allLines;
	    
    }    
	
    
    public static void writeLinesToFile(List allLines, String filePath)
    {
    
    	try
    	{
    		
	    	File f=new File(filePath);
	    	if (!f.exists())
	    	{
	    		System.out.println("File not exist, create file: "+filePath);
	    		f.createNewFile();
	    	}
    	
	    	FileOutputStream fos = new FileOutputStream(new File(filePath));
	    	BufferedOutputStream bos = new BufferedOutputStream(fos);
	    	
	    	bos.write(allLines.get(0).toString().getBytes());
	    	bos.write((allLines.get(1).toString()+"\r\n").getBytes());
	    	bos.write(allLines.get(2).toString().getBytes());
            for (int i=3; i<allLines.size()-1; i++) {
            	String line=allLines.get(i).toString().replace("	", " ")+"\r\n";
            	
//            	if (i==allLines.size()-2)
//            	{
//            		line=line.substring(0, 112)+"                   "+line.substring(132);
//            	}
            	
                bos.write(line.getBytes());
            }
            fos.flush();
            bos.close();              
		    
    	} 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    
	    
    }    
    
    
    public static void writeLinesToFileForFundHold(List allLines, String filePath)
    {
    
    	try
    	{
    		
	    	File f=new File(filePath);
	    	if (!f.exists())
	    	{
	    		System.out.println("File not exist, create file: "+filePath);
	    		f.createNewFile();
	    	}
    	
	    	FileOutputStream fos = new FileOutputStream(new File(filePath));
	    	BufferedOutputStream bos = new BufferedOutputStream(fos);
	    	
	    
	    	String fundMetaInfo="";
            for (int i=0; i<allLines.size()-1; i++) {
            	
            	String line=allLines.get(i).toString().replace("	", " ").replace(",", "").replace("  ", " ").replace(" 等", "等");
                   	
            	if (line.contains("档案"))
            	{
            		
            		String fundcompany=CommonTool.getFundCompany(line);
            		
            		String[] infoStr=line.split(" ");
            		
            		fundMetaInfo=
            				fundcompany+" " // company
            				+infoStr[0]+" "  // name
            				+infoStr[1]+" "  // code
            				+infoStr[4]+" "	 // type
            				+infoStr[9]+" "  // 6 month rise
            				+infoStr[10]+" " // 12 month rise
            				+infoStr[11]+" " // scale
            				+infoStr[12]+" " // manager
            				+infoStr[13]+" " // apply
            				+infoStr[14]+" " // ratio
            		;
            	}
            	else if (line.trim().getBytes().length>0)
            	{
            		bos.write((fundMetaInfo+line+"\r\n").getBytes());
            	}
            }
            fos.flush();
            bos.close();              
		    
    	} 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    
	    
    }    
    
}
