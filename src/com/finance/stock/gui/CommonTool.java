package com.finance.stock.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import com.finance.stock.data.MarketRDDayData;
import com.finance.stock.data.StockDayData;
import com.finance.stock.data.StockFinanceIndicator;
import com.finance.stock.data.StockHoldData;
import com.finance.stock.data.StockMetaData;
import com.finance.stock.data.StockRecordDDR;
import com.finance.stock.data.StockRecordRUR;
import com.finance.stock.data.StockSecondData;
import java.util.regex.*;

public class CommonTool {

	static ArrayList shipEventList=null;
	static ArrayList localeList=null;
	
	static TreeMap datasetConnectionMap=new TreeMap();
	static Map indexMap=null;
	
	static List dateReferenceList=null;
	
	public static int getIntValue(String strValue)
	{
		int result=-1;
		try
		{
			if (!strValue.trim().equals(""))
			{
				result=Integer.parseInt(strValue);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static String getDateString(Timestamp ts)
	{
		String result;
		if (ts!=null)
		{
						
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒	
			
//			// ELC 时区
//			if (DSRSKey.userDomain.equals("ELC"))
//			{
//			 
////				Date date=new Date(ts.getTime());
////				Calendar calendar = new GregorianCalendar(); 
////				calendar.setTime(date); 
////				calendar.add(calendar.DATE, 1);  //把日期往后增加一天.整数往后推,负数往前移动 
////				date=calendar.getTime();   //这个时间就是日期往后推一天的结果 	
////				ts = new Timestamp(date.getTime());
//
//				df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
//			}
			
			
			df.setTimeZone(TimeZone.getTimeZone("GMT+8"));  // 统一以北京时间东八区为标准显示时间，否则欧洲会以GMT+2时区显示时间，造成显示数值错误。
															// DSRS系统不会有这个问题，是因为JSP是在服务器端编译的，取的都是服务器的时间，也就是北京时间。
															// 而SuperDSRS是在各个客户端处理时间，取的是客户端电脑所在的时区。
			String dateStr = df.format(ts);			
			
			
//			System.out.println("Common Tool Time Output: "+dateStr);
			int strLength=dateStr.length();
			if (strLength>=10)
			{
				result=dateStr.substring(0, 10);
			}
			else
			{
				result=dateStr.substring(0, strLength);
			}
		}
		else
		{
			result="";
		}
		
		return result;
		
	}
	
	
	public static Timestamp getDateTimeStamp(String dateStr)
	{
		
		Timestamp dateTS=null;
		try
		{
			if (!dateStr.trim().equals(""))
			{
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
				dateTS = new Timestamp(date.getTime());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return dateTS;
		
		
	}
	
	public static String getBuildType(String type)
	{
		
		if (type!=null && type.equals("Daily"))
		{
			return "Daily";
		}
		else
		{
			return "Weekly";
		}
		
		
	}
	
	public static String getStockTransDate_Today()
	{
		String result="";
		
		result=getCurrentDate().substring(0, 10).replace("-", "/");   // 格式: "2017/03/29"
		
		return result;
	}
	
	public static String getStockTransDate(String startDate, int distance_days)
	{
		
		
		// 读取全部指数代码
		List indexDataList;
		if (StockKey.indexDataList==null)
		{
			String indexFileName="index000001";
			String indexFilePath=StockKey.stockAllFolderPath;		
			indexDataList=CommonTool.getStockDataRecordList(indexFilePath, indexFileName);
			StockKey.indexDataList=indexDataList;
			
		}
		else
		{
			indexDataList=StockKey.indexDataList;
		}
				
		String result=((StockDayData)indexDataList.get(indexDataList.size()-1)).getDate();
			
		// 获得startDate在交易日中的序号
		int posNum=0;
		for (int i=0; i<indexDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)indexDataList.get(i);
			String curDate=sdd.getDate();
			
			if (curDate!=null)    // curDate应该是从小到大，当第一次curDate>=startDate，说明找到了startDate位置
			{
				if (curDate.compareTo(startDate)==0)
				{
					posNum=sdd.getPosNum();    // curDate==startDate，说明正好就是startDate
					break;
				}
				else if (curDate.compareTo(startDate)>0)	// curDate>startDate，说明startDate不是交易日，取前一个交易日
				{
					posNum=sdd.getPosNum()-1;
					break;
				}
			}	
			
			
		}
		
		// 计算出新的序号
		int newPosNum=posNum+distance_days;
		
		if (newPosNum<0)	// 超出历史交易日第一天，以第一天计算
			newPosNum=0;
		
		if (newPosNum>indexDataList.size()-1)  // 超出历史交易日最后一天，以最后一天计算
			newPosNum=indexDataList.size()-1;
		
		// 根据序号查出日期值
		for (int i=0; i<indexDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)indexDataList.get(i);
			if (sdd.getPosNum()==newPosNum)
			{
				result=sdd.getDate();
			}	
		}
		
		return result;
		
	}

	
	public static StockEvaluator getStockEvaluator(List stockDataList)
	{
		StockEvaluator selt=new StockEvaluator();
		
		for (int i=0; i<stockDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)stockDataList.get(i);
			selt.maxPrice=Math.max(sdd.getHigh(), selt.maxPrice);
			selt.minPrice=Math.min(sdd.getLow(), selt.minPrice);
			
//			selt.maxUpPinList.add()
		}
		
		return selt;
		
	}
	
	
	public static String getCurrentDate()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String time=null;
		try {
		   
			time= sdf.format(new Date());
		   

		} catch (Exception e) {

		   e.printStackTrace();
		}
		
		return time;

	}
	
	
	public static Timestamp getCurrentDateTS()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String time=null;
		Timestamp dateTS=null;
		try {
		   
			Date newDate=new Date();
			dateTS = new Timestamp(newDate.getTime());

		} catch (Exception e) {

		   e.printStackTrace();
		}
		
		return dateTS;

	}

	

	public static void setLocationInScreenCenter(Component comp)
	{
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int scrWidth = (int)screensize.getWidth();
		int scrHeight = (int)screensize.getHeight();

		int compWidth=comp.getWidth();
		int compHeight=comp.getHeight();
		
		comp.setLocation((scrWidth-compWidth)/2, (scrHeight-compHeight)/2-20);
	}
	
	
	public static void setLocationInScreenCenter(Component comp, int hori, int vert)
	{
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int scrWidth = (int)screensize.getWidth();
		int scrHeight = (int)screensize.getHeight();

		int compWidth=comp.getWidth();
		int compHeight=comp.getHeight();
		
		comp.setLocation((scrWidth-compWidth)/2+hori, (scrHeight-compHeight)/2+vert);
	}
	
	public static void setLocationInParentComponentCenter(Component comp, Component parentComp, int horiGap, int vetiGap)
	{
		
		int parentWidth = parentComp.getWidth();
		int parentHeight = parentComp.getHeight();

		if (parentWidth==0)
		{
			parentWidth=400;
		}
		
		if (parentHeight==0)
		{
			parentHeight=300;
		}
		
		int compWidth=parentWidth-horiGap*2;
		int compHeight=parentHeight-vetiGap*2;
		
		comp.setSize(compWidth, compHeight);
		comp.setLocation(horiGap, vetiGap);
	}
	
	public static void setProperSizeOfFrame(Component bigComp, Component smallComp, int hgap, int vgap)
	{
		int width=bigComp.getWidth()-hgap*2;
		int height=bigComp.getHeight()-vgap*2;
		smallComp.setSize(width, height);
		smallComp.setLocation(hgap, vgap);		
		
	}
	
	public static ImageIcon getButtonImage(String path)
	{
		ImageIcon ii=new ImageIcon(path);
		Image image = ii.getImage();                         
		Image smallImage=image.getScaledInstance(48, 48, Image.SCALE_DEFAULT);
		ii = new ImageIcon(smallImage);
		return ii; 
		
	}
	
	public static ImageIcon getButtonImage(String path, int width, int height)
	{
		ImageIcon ii=new ImageIcon(path);
		Image image = ii.getImage();                         
		Image smallImage=image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ii = new ImageIcon(smallImage);
		return ii; 
		
	}
	
	public static String getRequestID(String origRequestStr)
	{
		int start=origRequestStr.indexOf("(");
		int end=origRequestStr.indexOf(")");
		String requestStr=origRequestStr.substring(start+1, end);
		
		return requestStr;
	}
	

		
	
	public static String removeFirstNullString(String str)
	{
		
		if (str==null)
		{
			str="";
		}
		
		if (str.startsWith("null"))
		{
			str=str.substring(4, str.length());
		}
		
		return str;
		
		
	}
	
	
	
	
	public static void addToMapNoDup(String str, TreeMap objMap)
	{
		
		if (!objMap.keySet().contains(str))
		{
			objMap.put(str, str);
		}
						
	}
	

	
	public static void initComboBox(JComboBox jcb, ArrayList objList, String order)
	{
		jcb.removeAllItems();
		
		if (order.equals("ASC"))
    	{
			Collections.sort(objList, new Comparator<String>(){  
				  			
		            public int compare(String s1, String s2) {  
		          
		           		            
		            	int	result=s1.compareTo(s2);
		            	
		            	return result;
		            }
			});
    	}
		else if (order.equals("DESC"))
		{
			Collections.sort(objList, new Comparator<String>(){  
	  			
	            public int compare(String s1, String s2) {  
	          
	           		            
	            		int	result=s2.compareTo(s1);
	            	
	            		return result;
	            	}
			});
						
		}	
		else if (order.equals("ORIG"))
		{
			
			
			
		}
		
		jcb.addItem("All");
		for (int i=0; i<objList.size(); i++)
		{			
			if (objList.get(i)!=null && !objList.get(i).toString().equals("null") && objList.get(i).toString().trim().length()!=0)
			{
				if (!objList.get(i).toString().equals("All"))
				{
					jcb.addItem(objList.get(i).toString());
				}
			}
		}
				
	}

	
	
	public static ArrayList parseKeyWords(String keyStr)
	{
								
		 String[] keyWords=keyStr.split(" ");
		 ArrayList keyWordsList=new ArrayList();
		
		 for (int i=0; i<keyWords.length; i++)
		 {
			 keyWordsList.add(keyWords[i]);
			 			 
		 }
		 
		 return keyWordsList;
				
	}
	
	
	// ABC_MCHrdcesx10111_STSsuccessful
	public static String parseBigKeyValue(String bigKeyString, String key)
	{
		
		int startPos=bigKeyString.indexOf(key);  // key="_MCH"		
		
		int endPos=bigKeyString.substring(startPos+1, bigKeyString.length()).indexOf("_");
		
		String value=bigKeyString.substring(startPos+key.length(), startPos+endPos+1);
		
		return value;
		
	}
	
	
	public static Object getBigKeyMapValue(Map bigKeyMap, String key)
	{
		Object obj=null;
		Iterator it=bigKeyMap.keySet().iterator();
		while(it.hasNext())
		{
			String bigKey=it.next().toString();
			if (bigKey.contains(key))
			{
				obj=bigKeyMap.get(bigKey);
				
			}			
			
		}	
		
		return obj;
		
	}
	
	
	
	public static int getWeekNumber(String dateStr)
	{
		
		int weekNumber=1;

		try
		{
	   	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(dateStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setMinimalDaysInFirstWeek(3);   // 每年的第一周必须大于或等于3天，否则就算上一年的最后一周
			calendar.setTime(date);
			weekNumber=calendar.get(Calendar.WEEK_OF_YEAR);
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return weekNumber;
				
	}
	
	
	
	
	public static String getYearString(String dateStr)
	{
		
		String yearString="";

		try
		{	   	   
			if (dateStr!=null && dateStr.length()>4)
				yearString=dateStr.substring(0,4);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return yearString;
		
		
	}
	
	public static String getWeekStartDate(int year, int weekNumber)
	{
		
		String weekStartDate=null;
		
        Calendar cal = Calendar.getInstance(); 
        cal.clear(); 
        cal.set(Calendar.YEAR, year); 
        cal.set(Calendar.WEEK_OF_YEAR,weekNumber); 
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
       
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Timestamp ts=new Timestamp(cal.getTime().getTime());
		weekStartDate=ts.toString().substring(0,10);        
        
		return weekStartDate;
		
		
	}
	
	public static String getWeekEndDate(int year, int weekNumber)
	{
		
		String weekEndDate=null;
		
        Calendar cal = Calendar.getInstance(); 
        cal.clear(); 
        cal.set(Calendar.YEAR, year); 
        cal.set(Calendar.WEEK_OF_YEAR,weekNumber+1); 
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
       
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Timestamp ts=new Timestamp(cal.getTime().getTime());
		weekEndDate=ts.toString().substring(0,10);     
				
		return weekEndDate;
		
		
	}
	
	
	public static String getWeekBuildDate(int year, int weekNumber)
	{
		
		String weekStartDate=null;
		
        Calendar cal = Calendar.getInstance(); 
        cal.clear(); 
        cal.set(Calendar.YEAR, year); 
        cal.set(Calendar.WEEK_OF_YEAR,weekNumber); 
        cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
       
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Timestamp ts=new Timestamp(cal.getTime().getTime());
		weekStartDate=ts.toString().substring(0,10);        
        
		return weekStartDate;
		
		
	}
	
	
	
	
	public static String converToDouble(int weekNo)
	{
		String weekStr="";
		
		if (weekNo<=9)
		{
			weekStr="0"+weekNo;
		}
		else
		{
			weekStr=weekNo+"";
		}
		return weekStr;
		
	}
	
	public static double converToDoubleNumber(String numStr)
	{
		double num=0;
		if (numStr!=null && numStr.trim()!="")
		{
			try
			{
				num=Double.parseDouble(numStr);
//				num=CommonTool.getDoubleNumberWithTwoBit(num);   // 会对数据做截断导致失去信息，不能在这里做，必须在外面做
			}
			catch(Exception e)
			{
//				e.printStackTrace();     //不打印出来，否则日志太多
			}
		}
		return num;
		
	}
	
	public static int converToIntegerNumber(String numStr)
	{
		
		int num=0;
		
		if (numStr!=null && numStr.trim()!="")
		{
			numStr=numStr.trim();  // 去尾部空格
			
			int dotPos=numStr.indexOf(".");   // 例如："380.76"
			if (dotPos>0)
			{
				numStr=numStr.substring(0, dotPos);  // 去尾部小数部分
			}
			
			try
			{
				num=Integer.parseInt(numStr);
			}
			catch(Exception e)
			{
//				e.printStackTrace();    //不打印出来，否则日志太多
			}
		}
		
		return num;			
		
	}


	
	public static void setToFullScreenSize(Component comp)
	{
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int scrWidth = (int)screensize.getWidth();
		int scrHeight = (int)screensize.getHeight();
		
		comp.setSize(scrWidth, scrHeight-80);
		comp.setLocation(0, 0);
		
	}
	

	
	public static String getShortProductName(String origProductStr)
	{
		int a=origProductStr.indexOf("(");
		String finalProductStr=origProductStr.substring(0,a);
		return finalProductStr;
	}
	
	
	public static Object getBigKeyMap(Map bigKeyMap, String key, String pre)
	{
		Iterator it=bigKeyMap.keySet().iterator();
		Object result=null;
		
		while(it.hasNext())
		{
			String bigKey=it.next().toString();
			
			if (bigKey.contains(pre+key+"_"))
			{
				result=bigKeyMap.get(bigKey);
			}
			
		}
		
		return result;
		
		
	}
	
	public static void removeBigKeyMap(Map bigKeyMap, String key, String pre)
	{
		Iterator it=bigKeyMap.keySet().iterator();
		Object result=null;
		String deleteKey="";
		
		while(it.hasNext())
		{
			String bigKey=it.next().toString();
			
			if (bigKey.contains(pre+key+"_"))
			{
				deleteKey=bigKey;
			}
			
		}
		
		bigKeyMap.remove(deleteKey);
				
	}
	
	
	public static void setComboBoxByRID(JComboBox jcb, String rid)
	{
		for (int i=0; i<jcb.getItemCount(); i++)
		{
			String s=jcb.getItemAt(i).toString();
			if (s.contains(rid))
			{
				jcb.setSelectedIndex(i);
			}
		}
		
		
	}
	
	
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

                File file = new File(filepath);
                if (!file.isDirectory()) {
                        System.out.println(file.getName());

                } else if (file.isDirectory()) {
                        
                        String[] filelist = file.list();
                        for (int i = 0; i < filelist.length; i++) {
                                File readfile = new File(filepath + "\\" + filelist[i]);
                                if (!readfile.isDirectory()) {
                                     
                                        System.out.println(readfile.getName());

                                } 
                        }

                }

        } catch (Exception e) {
                System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;

    }
    
    public static Font loadFont(String fontFileName, float fontSize)  //第一个参数是外部字体名，第二个是字体大小
    {
        try
        {
            File file = new File(fontFileName);
            FileInputStream aixing = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);
            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);
            aixing.close();
            return dynamicFontPt;
        }
        catch(Exception e)//异常处理
        {
            e.printStackTrace();
            return new java.awt.Font("宋体", Font.PLAIN, 14);
        }
    }

    
	 public static String getFullProblemID(String request_id, String problem_id)
	 {
		 String fullProblemID="";
		 int length=problem_id.length();
		 
		 if (length==1)
		 {
			 fullProblemID=request_id+"00"+problem_id;
		 }		 
		 else if (length==2)
		 {
			 fullProblemID=request_id+"0"+problem_id;
		 }
		 
		 return fullProblemID;
		 
	 }
	 
	 
	 public static String removeFirstBR(String str)
	 {
		 
		 String result=str.replaceFirst("<br><br>", "");
		 
		 return result;
		 		 
		 
	 }

	 
	 public static String processNullString(String s)
	 {
		 if (s==null)
			 return "";
		 else
			 return s;
		 
		 
	 }
	 
	 public static String processBuildType(String bt)
	 {
		 
		 if (bt==null || bt.trim().equals(""))
		 {
			 bt="Weekly";
		 }
		 
		 return bt;
		 
	 }
    
    public static void main(String[] args)
    {
    	try
    	{
    		CommonTool.readfile("C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockData\\test");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
    
    public static BufferedReader executeCommand(String cmdStr)
    {
    	
    		
		BufferedReader reader=null;
		
		  try {  
			  
			   System.out.println(cmdStr);
			  
			   // 执行 CMD 命令  
			   Process process = Runtime.getRuntime().exec(cmdStr);  
			   
			   		     
			   // 从输入流中读取文本  
			   reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			   
		  } catch (Exception e) {  
			   e.printStackTrace();  
			  
		  }
		  
		  return reader;	  	  
		
    	
    }
    
    
    public static String getCurrentTimeStr()
    {
    	String curTime_str="";
    	
    	SimpleDateFormat tformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");   
    	Timestamp curTime=new Timestamp(System.currentTimeMillis());			
        try {
        	curTime_str=tformat.format(curTime);        	
                    
        } catch (Exception e) {
            e.printStackTrace();			            
        }
        
        return curTime_str;        
    	
    }
    
    public static long getCurrentTimeLong()
    {
    	
    	long result=0;
    	
    	SimpleDateFormat tformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");   
    	Timestamp curTime=new Timestamp(System.currentTimeMillis());			
        try {
        	result = tformat.parse(tformat.format(curTime)).getTime();             
        } catch (ParseException e) {
            e.printStackTrace();			            
        }
        
        return result;
    	
    }
    
    
    public static boolean isComboboxContainsItem(JComboBox jcb, String item)
    {
    	
    	int count=jcb.getItemCount();
    	boolean isContain=false;
    	for (int i=0; i<count; i++)
    	{
    		String item_i=jcb.getItemAt(i).toString();
    		if (item_i.equals(item))
    		{
    			isContain=true;
    		}
    		
    	}
    	
    	return isContain;
    	
    }
    
    
    
    public static void insertItemWithOrder(JComboBox jcb, String item)
    {

    	int count=jcb.getItemCount();
   
    	for (int i=0; i<count; i++)
    	{
    		if (i<count-1)
    		{
    			String item_a=jcb.getItemAt(i).toString();
    			String item_b=jcb.getItemAt(i+1).toString();
    			if (item_a.compareTo(item)>0 && item_b.compareTo(item)<0)
    			{
    				jcb.insertItemAt(item, i+1);
    			}
    		}
    		else
    		{
    			jcb.insertItemAt(item, count);
    		}
    		
    	}
    	
    	jcb.setSelectedItem(item);
    	    	
    	
    }
    
    
    
    
    public static void scrollTableToBottom(JTable table)
    {
    	
        int rowCount=table.getRowCount();
        table.getSelectionModel().setSelectionInterval(rowCount-1,rowCount-1);
        Rectangle rect=table.getCellRect(rowCount-1,0,true);
        table.updateUI();
        table.scrollRectToVisible(rect);
    	
    }
    
    public static String getStatusColor(String status)
    {
    	
    	Map colorlist=new HashMap();
    	colorlist.put("Successful","green");	
    	colorlist.put("Successful(P)","green");
    	colorlist.put("Successful(W)","grey");
    	colorlist.put("Failed","red");
    	colorlist.put("Ongoing","orange");
    	colorlist.put("","black");
    	
    	String color="";
    	if (colorlist.get(status)!=null)
    	{
    		color=colorlist.get(status).toString();
    	}
    	
    	return color;
    }
	
    
    public static boolean testURLConnection(String address) 
    {
    	
    	  int status = 404;
    	  
    	  try {
    	  
    		 URL urlObj = new URL(address);
    		 HttpURLConnection oc = (HttpURLConnection)urlObj.openConnection();
    		 oc.setUseCaches(false);
    		 oc.setConnectTimeout(3000); // 设置超时时间
    		 status = oc.getResponseCode();// 请求状态
    		 if (200 == status) {
    		 
    			 // 200是请求地址顺利连通。。
    			 return true;    	     
    		 }
    		 else
    		 {
    			 return false;
    		 }
    		 
    	  } catch (Exception e) {
//    		  e.printStackTrace();    
    		  System.out.println("*** Connection is failed with exception! ***");
    		  return false;
    	  }
    	  
    	  
     }

     
    public static void closeHistoryDialog()
    {
    	
//    	for (int i=StockComponent.dialogPathList.size()-1; i>0; i--)
//    	{
//    		JDialog dialog=(JDialog)DSRSComponent.dialogPathList.get(i);
//    		dialog.dispose();    		
//    	}
    	
    	
    }
    
    
    public static String calculateLeftDays(Timestamp endDate)
    {
    	
    	String leftDays="";
    	if (endDate==null)
    	{
    		leftDays="";
    	}
    	else
    	{
			Timestamp etime=endDate;
			Timestamp ctime=new Timestamp(System.currentTimeMillis());		 		    				    
		    
		    SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", new Locale("zh", "cn"));				    
	        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	        long t1 = 0L;
	        long t2 = 0L;
	        try {
	            t1 = timeformat.parse(m_format.format(etime)).getTime();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        try {
	            t2 = timeformat.parse(m_format.format(ctime)).getTime();
	        } catch (ParseException e) {
	            e.printStackTrace();			            
	        }
	        //因为t1-t2得到的是毫秒级,所以要初3600000得出小时.算天数或秒同理
		    int ld=((int)(((t1 - t2)/3600000)/24))+1;
		    leftDays=ld+"";
    	}
    	
	    return leftDays;
	    
    }
    


	public static ResultSet readDataFromSASDataSet(String folderPath, String filename)
	{
				
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			con=getSASDatasetConnection(folderPath);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from stocklib."+filename);
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
		
		return rs;
		
	}
	
	public static ResultSet readDataFromSASDataSet(String folderPath, String filename, String condition)
	{
				
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try
		{
			con=getSASDatasetConnection(folderPath);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from stocklib."+filename+" where "+condition);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	public static ResultSet executeSQLforSASDataSet(String folderPath, String filename, String sqlStr)
	{
				
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try
		{
			con=getSASDatasetConnection(folderPath);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlStr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	
	public static boolean createSASDataSet(String folderPath, String filename, String columnDef)
	{
		
		Connection con = null;
		Statement stmt = null;
		boolean result = false;
		
		try
		{
			con=getSASDatasetConnection(folderPath);
			stmt = con.createStatement();
			String sql="CREATE TABLE stocklib."+filename+" ("+columnDef+")";
			System.out.println(sql);
			result = stmt.execute(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static boolean insertDataToSASDataSet(String folderPath, String filename, String valuesDef)
	{
		
		Connection con = null;
		Statement stmt = null;
		boolean result = false;
		
		try
		{
			con=getSASDatasetConnection(folderPath);
			stmt = con.createStatement();
						
			String sql="insert into stocklib."+filename+" values("+valuesDef+")";
			System.out.println(sql);
			result =stmt.execute(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static boolean insertDataToSASDataSet(String folderPath, String filename, List dataList)
	{
		
		Connection con = null;
		Statement stmt = null;
		boolean result = false;
		
		try
		{
			con=getSASDatasetConnection(folderPath);
			stmt = con.createStatement();
			
			for (int i=0; i<dataList.size(); i++)
			{
				String valuesDef=(String)dataList.get(i);
				String sql="insert into stocklib."+filename+" values("+valuesDef+")";
				System.out.println(sql);
				result =stmt.execute(sql);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public static Connection getSASDatasetConnection(String folderPath)
	{
	
		Connection con=null;
		if ( datasetConnectionMap.get(folderPath)!=null )
		{
			con=(Connection)datasetConnectionMap.get(folderPath);
			
		}
		else
		{
			
			try
			{
				
				 Class.forName("com.sas.rio.MVADriver");
				 String url = "jdbc:sasiom://localhost:8591";
//				 String url = "jdbc:sasiom://localhost:8591?characterEncoding=UTF-8";
//				 String url = "jdbc:sasiom://127.0.0.1:8591";
				 
				 java.util.Properties p = new java.util.Properties();
				 p.setProperty("librefs", "stocklib '"+folderPath+"';");
				 p.setProperty("username", "sasdemo");
				 p.setProperty("password", "Password1");
				 
				 con = DriverManager.getConnection(url, p);
				 datasetConnectionMap.put(folderPath, con);
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			
		}
		
		return con;
		
		
	}
	
	public static Connection getSASDatasetConnectionNew(String folderPath)
	{
	
		Connection con=null;
		if ( datasetConnectionMap.get(folderPath)!=null )
		{
			con=(Connection)datasetConnectionMap.get(folderPath);
			
		}
		else
		{
			
			try
			{
				
				 Class.forName("com.sas.rio.MVADriver");
				 String url = "jdbc:sasiom://rdcesx14004.race.sas.com:8591";

				 java.util.Properties p = new java.util.Properties();
				 p.setProperty("librefs", "stocklib '"+folderPath+"';");
				 p.setProperty("username", "sasdemo");
				 p.setProperty("password", "Sas123");
				 
				 con = DriverManager.getConnection(url, p);
				 datasetConnectionMap.put(folderPath, con);
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			
		}
		
		return con;
		
		
	}
	
	public static String getFileName(String fileFullName)
	{
		int dotpos=fileFullName.indexOf(".");
		String fileName;
		if (dotpos>0)
		{
			fileName=fileFullName.substring(0, dotpos);
		}
		else
		{
			fileName=fileFullName;
		}
		
		return fileName;
		
		
	}
    
	
	public static Map getStockMarketDataRecordMap(String datasetFolderPath, String marketfilename)
	{
		
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, marketfilename);
		Map marketDataRecordMap=new TreeMap();
		
		try
		{
			while (rs.next()) {
	
				MarketRDDayData mdd=new MarketRDDayData();
				
				mdd.setDate(rs.getString("date_sum").trim());
				mdd.setType(rs.getString("type").trim());
				mdd.setCount(rs.getInt("count"));
				
				mdd.setRise(rs.getInt("rise"));
				mdd.setDown(rs.getInt("down"));
				mdd.setRise10(rs.getInt("rise10"));
				mdd.setDown10(rs.getInt("down10"));
				mdd.setRise7(rs.getInt("rise7"));
				mdd.setDown7(rs.getInt("down7"));
				mdd.setRise5(rs.getInt("rise5"));
				mdd.setDown5(rs.getInt("down5"));
				mdd.setRise3(rs.getInt("rise3"));
				mdd.setDown3(rs.getInt("down3"));
				mdd.setRise0(rs.getInt("rise0"));
				mdd.setDown0(rs.getInt("down0"));
				
				mdd.setRise_open(rs.getInt("rise_open"));
				mdd.setDown_open(rs.getInt("down_open"));
				mdd.setRise10_open(rs.getInt("rise10_open"));
				mdd.setDown10_open(rs.getInt("down10_open"));
				mdd.setRise7_open(rs.getInt("rise7_open"));
				mdd.setDown7_open(rs.getInt("down7_open"));
				mdd.setRise5_open(rs.getInt("rise5_open"));
				mdd.setDown5_open(rs.getInt("down5_open"));
				mdd.setRise3_open(rs.getInt("rise3_open"));
				mdd.setDown3_open(rs.getInt("down3_open"));
				mdd.setRise0_open(rs.getInt("rise0_open"));
				mdd.setDown0_open(rs.getInt("down0_open"));
				
				mdd.setActual_rise_percent(CommonTool.converToDoubleNumber(rs.getString("actual_rise_percent").trim()));
				mdd.setActual_down_percent(CommonTool.converToDoubleNumber(rs.getString("actual_down_percent").trim()));
				mdd.setTotal_rise_percent(CommonTool.converToDoubleNumber(rs.getString("total_rise_percent").trim()));
				mdd.setTotal_down_percent(CommonTool.converToDoubleNumber(rs.getString("total_down_percent").trim()));
				
				marketDataRecordMap.put(mdd.getDate(), mdd);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return marketDataRecordMap;
		
	}
	
	public static Map getStockMarketDataRecordMap(String stockType)
	{
		
		Map marketDataRecordMap;   // Map(Date, MarketRDDayData) 
		
		String datasetFolderPath=StockKey.stockFullFolderPath+"\\market";
		String stockfilename="marketsumarydata_"+stockType;
		marketDataRecordMap=getStockMarketDataRecordMap(datasetFolderPath, stockfilename);
		
		return marketDataRecordMap;
		
	}
	
	public static Map getStockHoldRecordMap(String datasetFolderPath, String stockfilename, String condition)
	{
		
//		key: stockcode_date_number, value: stockHoldData 
		
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename, condition);
		Map stockHoldRecordMap=new TreeMap();
		
		try
		{
			while (rs.next()) {
	
				StockHoldData shd=new StockHoldData();
				
				shd.setStockcode(rs.getString("code").trim());
				shd.setDate(rs.getString("date").trim());
				shd.setNumber(CommonTool.getIntValue(rs.getString("no").trim()));
				shd.setHoldername(rs.getString("holdername").trim());
				shd.setAmount(CommonTool.getIntValue(rs.getString("amount").trim()));
				shd.setPercent(CommonTool.converToDoubleNumber(rs.getString("percent").trim()));
				shd.setType(rs.getString("type").trim());
				
				if (rs.getString("sname")!=null)
				{
					shd.setStockname(rs.getString("sname").trim());
				}
				
				if (rs.getString("industry")!=null)
				{
					shd.setIndustry(rs.getString("industry").trim());
				}
				
				if (rs.getString("concept")!=null)
				{
					shd.setIndustry(rs.getString("concept").trim());
				}
				
				
				String key=shd.getStockcode()+"_"+shd.getDate()+"_"+shd.getNumber();
				stockHoldRecordMap.put(key, shd);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stockHoldRecordMap;
		
	}
	
	
	// 获得一只股票历史上所有交易日记录
	public static List getStockDayDataList(String stockcode)
	{
		
		String stockfilename="stock"+stockcode;
		String datasetFolderPath=StockKey.stockAllFolderPath;
		
		List stockDayDataList=getStockDataRecordList(datasetFolderPath, stockfilename);
		return stockDayDataList;
		
	}
	
	// 获得一只股票历史上按条件查到的所有交易日记录
	public static List getStockDayDataList(String stockcode, String condition)
	{
		
		String stockfilename="stock"+stockcode;
		String datasetFolderPath=StockKey.stockAllFolderPath;
		
		List stockDayDataList=getStockDataRecordList(datasetFolderPath, stockfilename, condition);
		return stockDayDataList;
		
	}
	
	// 获得一只股票历史上某一天的交易日记录
	public static StockDayData getStockDayData(String stockcode, String date)
	{
		
		String stockfilename="stock"+stockcode;
		String datasetFolderPath=StockKey.stockAllFolderPath;
		
		String condition=getSqlDateSearchConditionStr(date, date);
		List stockDayDataList=getStockDataRecordList(datasetFolderPath, stockfilename, condition);
		
		StockDayData sdd=new StockDayData();
		if (stockDayDataList.size()>0)
		{
			sdd=(StockDayData)stockDayDataList.get(0);
		}
		
		return sdd;
		
	}
	
	public static StockDayData getStockDayData(List stockDayDataList, String date)
	{
		StockDayData result=null;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getDate()!=null && sdd.getDate().equals(date))
			{
				result=sdd;
			}
			
		}
		
		return result;
		
	}
	
	
	public static StockDayData getStockDayDataExisted(List stockDayDataList, String date)
	{
		StockDayData result=new StockDayData();
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			result=sdd;
			
			// 选择等于date的sdd，或者最接近date的sdd
			if (sdd.getDate()!=null && (sdd.getDate().equals(date) || sdd.getDate().compareTo(date)>0) )
			{
				result=sdd;  // 当找到了符合条件的sdd就退出循环，如果没有找到就用最后一个sdd
				break;
			}
				
		}
		
		return result;
		
	}
	
	
	public static StockDayData getStockDayData(List stockDayDataList, String date, int distance)
	{
		StockDayData result=null;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getDate()!=null && sdd.getDate().equals(date) && i+distance>=0)
			{
				StockDayData sdd_d=(StockDayData)stockDayDataList.get(i+distance);
				result=sdd_d;
			}
				
			
		}
		
		return result;
		
	}
	
	
	
	// 获得一只股票历史上一段日期内的所有交易日记录
	public static List getStockDayDataList(String stockcode, String startDate, String endDate)
	{
		
		String stockfilename="stock"+stockcode;
		String datasetFolderPath=StockKey.stockAllFolderPath;
		String condition=getSqlDateSearchConditionStr(startDate, endDate);
		
		List stockDayDataList=getStockDataRecordList(datasetFolderPath, stockfilename, condition);
		return stockDayDataList;
		
	}
	
	public static Map getStockMetaDataMap(String datasetFolderPath, String stockfilename)
	{
	
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename);
		Map stockMetaDataMap=new TreeMap();
		
		try
		{
			while (rs.next()) {
	
				StockMetaData smd=new StockMetaData();
				
				String code=rs.getString("stockcode").trim();
				String name=rs.getString("stockname").trim();
				
				smd.setCode(code);
				smd.setName(name);
				smd.setIndustry(rs.getString("industry").trim());
				smd.setConcept(rs.getString("concept").trim());
				smd.setLocation(rs.getString("location").trim());
				
				stockMetaDataMap.put(code, smd);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stockMetaDataMap;
		
	}
		
	public static List getStockDataRecordList(String datasetFolderPath, String stockfilename)
	{
	
		
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename);
		Map stockDataRecordMap=new TreeMap();
		List stockDataRecordList=new ArrayList();	
		
		if (rs==null)
		{
			List result=new ArrayList();
			return result;
		}
		
		if (stockfilename.startsWith("index"))
		{
			
			try
			{
				int i=1;
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("code_i").trim());
						sdd.setDate(rs.getString("date").trim());	
						sdd.setName(CommonTool.getStockNameByCode(rs.getString("code_i").trim()));
						
						sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open_i")));
						sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high_i")));
						sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low_i")));
						sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final_i")));
						
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount_i")));
						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money_i")));
						
						sdd.setOpen_rise(CommonTool.converToDoubleNumber(rs.getString("open_rise_i")));
						sdd.setHigh_rise(CommonTool.converToDoubleNumber(rs.getString("high_rise_i")));
						sdd.setLow_rise(CommonTool.converToDoubleNumber(rs.getString("low_rise_i")));
						sdd.setClose_rise(CommonTool.converToDoubleNumber(rs.getString("final_rise_i")));
						
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
						
						
						if ( CommonTool.isTableColumnExist(rs, "MACD_DIF") )  // 判断是否存在MACD信息，tdx的index里存在，要读出
						{
							sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF")));
							sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA")));
							sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD")));
							sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						}
						
						if ( CommonTool.isTableColumnExist(rs, "KDJ_K") )  // 判断是否存在KDJ信息，tdx的index里存在，要读出
						{
							sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
							sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
							sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
							sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						}
						
						stockDataRecordMap.put(sdd.getDate(), sdd);
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					calculateMAValue(stockDataRecordList, sdd);  // 计算指数的均线值
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
			
		}
		else if (stockfilename.startsWith("minute"))
		{
			
			try
			{
				int i=1;
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("code").trim());
						sdd.setDate(rs.getString("date").trim());	
						sdd.setName(CommonTool.getStockNameByCode(rs.getString("code").trim())+"分时");
						
						sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open")));
						sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high")));
						sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low")));
						sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final")));
						
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount")));
//						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money")));
						
						sdd.setOpen_rise(CommonTool.converToDoubleNumber(rs.getString("open_rise")));
						sdd.setHigh_rise(CommonTool.converToDoubleNumber(rs.getString("high_rise")));
						sdd.setLow_rise(CommonTool.converToDoubleNumber(rs.getString("low_rise")));
						sdd.setClose_rise(CommonTool.converToDoubleNumber(rs.getString("final_rise")));
						
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
						
						sdd.setWR42(CommonTool.converToDoubleNumber(rs.getString("wr42")));
						sdd.setWR100(CommonTool.converToDoubleNumber(rs.getString("wr100")));
						sdd.setCCI14(CommonTool.converToDoubleNumber(rs.getString("cci14")));
						
						if ( CommonTool.isTableColumnExist(rs, "MACD_DIF") )  // 判断是否存在MACD信息，tdx的index里存在，要读出
						{
							sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF")));
							sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA")));
							sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD")));
							sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						}
						
						if ( CommonTool.isTableColumnExist(rs, "KDJ_K") )  // 判断是否存在KDJ信息，tdx的index里存在，要读出
						{
							sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
							sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
							sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
							sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						}
						
						
						// 针对 stock/index/etf 数据特别处理
						if ( stockDataRecordMap.get(sdd.getDate())!=null )
						{
							i++;  // 计数器+1
							if (i<10)
							{
								sdd.setDate(sdd.getDate()+"-00"+i);
							}
							else if (i<100)
							{
								sdd.setDate(sdd.getDate()+"-0"+i);
							}
							else
							{
								sdd.setDate(sdd.getDate()+"-"+i);
							}
							stockDataRecordMap.put(sdd.getDate(), sdd);
							
						}
						else
						{
							i=1;  // 计数器归1
							stockDataRecordMap.put(sdd.getDate(), sdd);
							sdd.setDate(sdd.getDate()+"-00"+i);
						}
						
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					calculateMAValue(stockDataRecordList, sdd);  // 计算指数的均线值
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
			
		}
		else if (stockfilename.startsWith("day"))
		{
			
			try
			{
				int i=1;
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("code").trim());
						sdd.setDate(rs.getString("date").trim());	
						sdd.setName(CommonTool.getStockNameByCode(rs.getString("code").trim())+"日线");
						
						sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open")));
						sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high")));
						sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low")));
						sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final")));
						
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount")));
//						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money")));
						
						sdd.setOpen_rise(CommonTool.converToDoubleNumber(rs.getString("open_rise")));
						sdd.setHigh_rise(CommonTool.converToDoubleNumber(rs.getString("high_rise")));
						sdd.setLow_rise(CommonTool.converToDoubleNumber(rs.getString("low_rise")));
						sdd.setClose_rise(CommonTool.converToDoubleNumber(rs.getString("final_rise")));
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
						
						sdd.setWR42(CommonTool.converToDoubleNumber(rs.getString("wr42")));
						sdd.setWR100(CommonTool.converToDoubleNumber(rs.getString("wr100")));
//						sdd.setCCI14(CommonTool.converToDoubleNumber(rs.getString("cci14")));
						
						if ( CommonTool.isTableColumnExist(rs, "MACD_DIF") )  // 判断是否存在MACD信息，tdx的index里存在，要读出
						{
//							sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF")));
//							sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA")));
//							sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD")));
							sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF"))*100); // for ETF
							sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA"))*100); // for ETF
							sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD"))*100); // for ETF
							sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						}
						
						if ( CommonTool.isTableColumnExist(rs, "KDJ_K") )  // 判断是否存在KDJ信息，tdx的index里存在，要读出
						{
							sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
							sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
							sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
							sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						}
						
						stockDataRecordMap.put(sdd.getDate(), sdd);
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					calculateMAValue(stockDataRecordList, sdd);  // 计算指数的均线值
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
			
		}
		else if (stockfilename.startsWith("fund"))
		{
			
			try
			{
				int i=1;
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("code").trim());
						sdd.setDate(rs.getString("date").trim());	
						sdd.setName(CommonTool.getStockNameByCode(rs.getString("code").trim())+"日线");
						
						sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open")));
						sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high")));
						sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low")));
						sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final")));
						
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount")));
//						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money")));
						
						sdd.setOpen_rise(CommonTool.converToDoubleNumber(rs.getString("open_rise")));
						sdd.setHigh_rise(CommonTool.converToDoubleNumber(rs.getString("high_rise")));
						sdd.setLow_rise(CommonTool.converToDoubleNumber(rs.getString("low_rise")));
						sdd.setClose_rise(CommonTool.converToDoubleNumber(rs.getString("final_rise")));
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
						
						sdd.setWR42(CommonTool.converToDoubleNumber(rs.getString("wr42")));
						sdd.setWR100(CommonTool.converToDoubleNumber(rs.getString("wr100")));
//						sdd.setCCI14(CommonTool.converToDoubleNumber(rs.getString("cci14")));
						
						if ( CommonTool.isTableColumnExist(rs, "MACD_DIF") )  // 判断是否存在MACD信息，tdx的index里存在，要读出
						{
							sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF")));
							sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA")));
							sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD")));
							sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						}
						
						if ( CommonTool.isTableColumnExist(rs, "KDJ_K") )  // 判断是否存在KDJ信息，tdx的index里存在，要读出
						{
							sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
							sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
							sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
							sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						}
						
						stockDataRecordMap.put(sdd.getDate(), sdd);
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					calculateMAValue(stockDataRecordList, sdd);  // 计算指数的均线值
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
			
		}
		else if (stockfilename.startsWith("stock"))
		{
			
			try
			{
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("scode").trim());
						sdd.setName(rs.getString("sname").trim());
						sdd.setDate(rs.getString("date").trim());
						sdd.setIndustry(rs.getString("industry").trim());
						sdd.setLocation(rs.getString("location").trim());
//						sdd.setConcept(rs.getString("concept").trim());
						
						
						double final_rise=CommonTool.converToDoubleNumber(rs.getString("final_rise"));
						double open_rise=CommonTool.converToDoubleNumber(rs.getString("open_rise"));
						double high_rise=CommonTool.converToDoubleNumber(rs.getString("high_rise"));
						double low_rise=CommonTool.converToDoubleNumber(rs.getString("low_rise"));
						
						double pf_final=CommonTool.converToDoubleNumber(rs.getString("pf_final"));
						if (pf_final>0)
						{
							// 如果pf_final前复权值不为0，则对股价进行前复权转换
							double y_final=pf_final/(1+final_rise/100);
							double pf_open=y_final*(1+open_rise/100);
							double pf_high=y_final*(1+high_rise/100);
							double pf_low=y_final*(1+low_rise/100);
							sdd.setOpen(CommonTool.getDoubleNumberWithTwoBit(pf_open));
							sdd.setHigh(CommonTool.getDoubleNumberWithTwoBit(pf_high));
							sdd.setLow(CommonTool.getDoubleNumberWithTwoBit(pf_low));
							sdd.setClose(CommonTool.getDoubleNumberWithTwoBit(pf_final));
						}			
						else
						{
							// 如果pf_final为0，则不转换直接赋值
							sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open")));
							sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high")));
							sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low")));
							sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final")));
							
						}
						
						sdd.setAf_close(CommonTool.converToDoubleNumber(rs.getString("af_final")));
						sdd.setPf_close(CommonTool.converToDoubleNumber(rs.getString("pf_final")));
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount")));
						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money")));
						sdd.setChange_ratio(CommonTool.converToDoubleNumber(rs.getString("change_ratio")));
						
						sdd.setPe_ratio(CommonTool.converToDoubleNumber(rs.getString("pe_ratio")));
						sdd.setPs_ratio(CommonTool.converToDoubleNumber(rs.getString("ps_ratio")));
						sdd.setPx_ratio(CommonTool.converToDoubleNumber(rs.getString("px_ratio")));
						sdd.setPj_ratio(CommonTool.converToDoubleNumber(rs.getString("pj_ratio")));
						
						sdd.setLiquid_value(CommonTool.converToDoubleNumber(rs.getString("liquid_value")));
						sdd.setTotal_value(CommonTool.converToDoubleNumber(rs.getString("total_value")));
						sdd.setSwing(CommonTool.converToDoubleNumber(rs.getString("swing")));
						sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						
						sdd.setMa_5(CommonTool.converToDoubleNumber(rs.getString("MA_5")));
						sdd.setMa_10(CommonTool.converToDoubleNumber(rs.getString("MA_10")));
						sdd.setMa_20(CommonTool.converToDoubleNumber(rs.getString("MA_20")));
						sdd.setMa_30(CommonTool.converToDoubleNumber(rs.getString("MA_30")));
						sdd.setMa_60(CommonTool.converToDoubleNumber(rs.getString("MA_60")));
						
						sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF"))*1000);
						sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA"))*1000);
						sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD"))*1000);
						sdd.setMa_jcsc(CommonTool.converToJCSC(rs.getString("macd_jcsc")));
						sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						
						sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
						sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
						sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
						sdd.setKdj_jcsc(CommonTool.converToJCSC(rs.getString("kdj_jcsc")));
						
						sdd.setOpen_rise(open_rise);
						sdd.setHigh_rise(high_rise);
						sdd.setLow_rise(low_rise);
						sdd.setClose_rise(final_rise);
					
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
						
						stockDataRecordMap.put(sdd.getDate(), sdd);
						
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				StockDayData sddpre=null;
				int peNum_gain=0; // 盈利天数： PE为正
				int peNum_loss=0; // 亏损天数： PE为负
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					
					double earnPerShare=0;
					if (sdd.getPe_ratio()!=0)
					{
						earnPerShare=sdd.getClose()/sdd.getPe_ratio();
					}
					else
					{
						earnPerShare=sdd.getClose()/22.5;
					}
					sdd.setEarnPerShare(earnPerShare);
					
					if (sddpre!=null)
					{
//						double earnChangeFactor=sdd.getEarnPerShare()/sddpre.getEarnPerShare();
//						double earnChange=Math.abs(earnChangeFactor-1);
//						if (sdd.getEarnPerShare()>0 && sddpre.getEarnPerShare()>0
//								&& earnChange>0.1)
//						{
//							
//							sdd.setPeAccFactor(sddpre.getPeAccFactor()*earnChangeFactor);
//						}
//						else
//						{
//							sdd.setPeAccFactor(sddpre.getPeAccFactor());
//						}
						
						sdd.setPastHigh(Math.max(sddpre.getHigh(), sddpre.getPastHigh()));
						sdd.setPastLow(Math.min(sddpre.getLow(), sddpre.getPastLow()));
						sdd.setPastHighPe(Math.max(sddpre.getPe_ratio(), sddpre.getPastHighPe()));
						sdd.setPastLowPe(Math.min(sddpre.getPe_ratio(), sddpre.getPastLowPe()));	
						
						double pastHighAvg=(sddpre.getPastHighAvg()*(posNum-1)+sddpre.getHigh())/posNum;  //posNum是从0开始，所以本身就少1
						double pastLowAvg=(sddpre.getPastLowAvg()*(posNum-1)+sddpre.getLow())/posNum;
						double pastPeAvg_gain=0;
						double pastPeAvg_loss=0;
						if (sddpre.getPe_ratio()>0)
						{
							if (peNum_gain>0)
							{
								pastPeAvg_gain=(sddpre.getPastPeAvg()*(peNum_gain-1)+sddpre.getPe_ratio())/peNum_gain;
							}
							else
							{
								pastPeAvg_gain=sddpre.getPe_ratio();
							}
							peNum_gain++;
						}
						else
						{
//							if (peNum_loss>0)
//							{
//								pastPeAvg_loss=(sddpre.getPastPeAvg()*(peNum_loss-1)+sddpre.getPe_ratio())/peNum_loss;  // 对于当前PE为负值，即亏损的时候，就用过去平均值来代替
//							}
//							else
//							{
//								pastPeAvg_loss=sddpre.getPe_ratio();
//							}
//							peNum_loss++;
							
							pastPeAvg_gain=sddpre.getPastPeAvg();  //用之前的正PE值来代替当前因负值引起的问题
							
						}						
						sdd.setPastHighAvg(pastHighAvg);   // 要算上因收益上涨或下降而带来的变化
						sdd.setPastLowAvg(pastLowAvg);
						sdd.setPastPeAvg(pastPeAvg_gain);  // 记录正PE的平均值		
						
						
					}
					
					stockDataRecordList.add(sdd);
					sddpre=sdd;
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
		}
		

		generateWRVlueforSDD(stockDataRecordList);
		
		
		
		return stockDataRecordList;
		
		
	}
	
	
	public static void generateWRVlueforSDD(List sddList)
	{
		
		if (sddList.size()>6)
		{
			for (int i=6; i<sddList.size(); i++)
			{
				StockDayData sdd=(StockDayData)sddList.get(i);
				
				double wr6=calculateWRValue(sddList, i, 6);
				sdd.setWR6(wr6);
			}
		}
		
		if (sddList.size()>10)
		{
			
			for (int i=10; i<sddList.size(); i++)
			{
				StockDayData sdd=(StockDayData)sddList.get(i);
				
				double wr10=calculateWRValue(sddList, i, 10);
				sdd.setWR10(wr10);
			}
		}
		
		if (sddList.size()>20)
		{
			
			for (int i=20; i<sddList.size(); i++)
			{
				StockDayData sdd=(StockDayData)sddList.get(i);
				
				double wr20=calculateWRValue(sddList, i, 20);
				sdd.setWR20(wr20);
			}
		}
		
		
//		if (sddList.size()>42)
//		{
//			
//			for (int i=42; i<sddList.size(); i++)
//			{
//				StockDayData sdd=(StockDayData)sddList.get(i);
//				
//				double wr42=calculateWRValue(sddList, i, 42);
//				sdd.setWR42(wr42);
//			}
//		}
//		
//		
//		if (sddList.size()>100)
//		{
//			
//			for (int i=100; i<sddList.size(); i++)
//			{
//				StockDayData sdd=(StockDayData)sddList.get(i);
//				
//				double wr100=calculateWRValue(sddList, i, 100);
//				sdd.setWR100(wr100);
//			}
//		}
		
		if (sddList.size()>125)
		{
			
			for (int i=125; i<sddList.size(); i++)
			{
				StockDayData sdd=(StockDayData)sddList.get(i);
				
				double wr125=calculateWRValue(sddList, i, 125);
				sdd.setWR125(wr125);
			}
		}
	}
	
	// 计算第i日的前n天周期WR值
	public static double calculateWRValue(List sddList, int i, int n)
	{
		
		double totalClose=0;
		double highPrice=0;
		double lowPrice=10000;
		
		StockDayData sdd_c=(StockDayData)sddList.get(i);
		for (int s=0; s<n; s++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i-s);
			totalClose=totalClose+sdd.getClose();
			
			if (sdd.getHigh()>highPrice)
			{
				highPrice=sdd.getHigh();
			}
			
			if (sdd.getLow()<lowPrice)
			{
				lowPrice=sdd.getLow();
			}
		}
		
		// 处理极值
		double highlowPrice=highPrice-lowPrice;
		if(highlowPrice==0)
		{
			highlowPrice=10;
		}
		
		double avgPrice=totalClose/n;
		double wrValue=(double)(100-(sdd_c.getClose()-lowPrice)/highlowPrice*100);
		wrValue=getDoubleNumberWithTwoBit(wrValue);
		
		return wrValue;
		
		
	}
	
	public static List getStockDataRecordList(String datasetFolderPath, String stockfilename, String condition)
	{
	
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename, condition);
		Map stockDataRecordMap=new TreeMap();
		List stockDataRecordList=new ArrayList();	
				
		if (stockfilename.startsWith("index"))
		{
			
			try
			{
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("code_i").trim());
						sdd.setDate(rs.getString("date").trim());						
						
						sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open_i")));
						sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high_i")));
						sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low_i")));
						sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final_i")));
						
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount_i")));
						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money_i")));
						
						sdd.setOpen_rise(CommonTool.converToDoubleNumber(rs.getString("open_rise_i")));
						sdd.setHigh_rise(CommonTool.converToDoubleNumber(rs.getString("high_rise_i")));
						sdd.setLow_rise(CommonTool.converToDoubleNumber(rs.getString("low_rise_i")));
						sdd.setClose_rise(CommonTool.converToDoubleNumber(rs.getString("final_rise_i")));
						
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
					
						if ( CommonTool.isTableColumnExist(rs, "MACD_DIF") )	// 判断是否存在MACD信息，tdx的index里存在，要读出
						{
							sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF")));
							sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA")));
							sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD")));
							sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						}
						
						if ( CommonTool.isTableColumnExist(rs, "KDJ_K") )  // 判断是否存在KDJ信息，tdx的index里存在，要读出
						{
							sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
							sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
							sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
							sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						}
						
						stockDataRecordMap.put(sdd.getDate(), sdd);
						
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					calculateMAValue(stockDataRecordList, sdd);  // 计算指数的均线值
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
		}
		else if (stockfilename.startsWith("stock"))
		{
			
			try
			{
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
						sdd.setCode(rs.getString("scode").trim());
						sdd.setName(rs.getString("sname").trim());
						sdd.setDate(rs.getString("date").trim());
						sdd.setIndustry(rs.getString("industry").trim());
						sdd.setLocation(rs.getString("location").trim());
//						sdd.setConcept(rs.getString("concept").trim());
						
						double final_rise=CommonTool.converToDoubleNumber(rs.getString("final_rise"));
						double open_rise=CommonTool.converToDoubleNumber(rs.getString("open_rise"));
						double high_rise=CommonTool.converToDoubleNumber(rs.getString("high_rise"));
						double low_rise=CommonTool.converToDoubleNumber(rs.getString("low_rise"));
						
						double pf_final=CommonTool.converToDoubleNumber(rs.getString("pf_final"));
						if (pf_final>0)
						{
							// 如果pf_final前复权值不为0，则对股价进行前复权转换
							double y_final=pf_final/(1+final_rise/100);
							double pf_open=y_final*(1+open_rise/100);
							double pf_high=y_final*(1+high_rise/100);
							double pf_low=y_final*(1+low_rise/100);
							sdd.setOpen(CommonTool.getDoubleNumberWithTwoBit(pf_open));
							sdd.setHigh(CommonTool.getDoubleNumberWithTwoBit(pf_high));
							sdd.setLow(CommonTool.getDoubleNumberWithTwoBit(pf_low));
							sdd.setClose(CommonTool.getDoubleNumberWithTwoBit(pf_final));
						}			
						else
						{
							// 如果pf_final为0，则不转换直接赋值
							sdd.setOpen(CommonTool.converToDoubleNumber(rs.getString("open")));
							sdd.setHigh(CommonTool.converToDoubleNumber(rs.getString("high")));
							sdd.setLow(CommonTool.converToDoubleNumber(rs.getString("low")));
							sdd.setClose(CommonTool.converToDoubleNumber(rs.getString("final")));
							
						}
						
						sdd.setAf_close(CommonTool.converToDoubleNumber(rs.getString("af_final")));
						sdd.setPf_close(CommonTool.converToDoubleNumber(rs.getString("pf_final")));
						sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount")));
						sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money")));
						sdd.setChange_ratio(CommonTool.converToDoubleNumber(rs.getString("change_ratio")));
						
						sdd.setPe_ratio(CommonTool.converToDoubleNumber(rs.getString("pe_ratio")));
						sdd.setPs_ratio(CommonTool.converToDoubleNumber(rs.getString("ps_ratio")));
						sdd.setPx_ratio(CommonTool.converToDoubleNumber(rs.getString("px_ratio")));
						sdd.setPj_ratio(CommonTool.converToDoubleNumber(rs.getString("pj_ratio")));
						
						sdd.setLiquid_value(CommonTool.converToDoubleNumber(rs.getString("liquid_value")));
						sdd.setTotal_value(CommonTool.converToDoubleNumber(rs.getString("total_value")));
						sdd.setSwing(CommonTool.converToDoubleNumber(rs.getString("swing")));
						sdd.setEq_ratio(CommonTool.converToDoubleNumber(rs.getString("eq_ratio")));
						
						sdd.setMa_5(CommonTool.converToDoubleNumber(rs.getString("MA_5")));
						sdd.setMa_10(CommonTool.converToDoubleNumber(rs.getString("MA_10")));
						sdd.setMa_20(CommonTool.converToDoubleNumber(rs.getString("MA_20")));
						sdd.setMa_30(CommonTool.converToDoubleNumber(rs.getString("MA_30")));
						sdd.setMa_60(CommonTool.converToDoubleNumber(rs.getString("MA_60")));
						
						sdd.setMa_dif(CommonTool.converToDoubleNumber(rs.getString("MACD_DIF"))*1000);
						sdd.setMa_dea(CommonTool.converToDoubleNumber(rs.getString("MACD_DEA"))*1000);
						sdd.setMa_macd(CommonTool.converToDoubleNumber(rs.getString("MACD_MACD"))*1000);
						sdd.setMa_jcsc(CommonTool.converToJCSC(rs.getString("macd_jcsc")));
						sdd.setMa_ddz((sdd.getMa_dif()-sdd.getMa_dea()));
						
						sdd.setKdj_k(CommonTool.converToDoubleNumber(rs.getString("KDJ_K")));
						sdd.setKdj_d(CommonTool.converToDoubleNumber(rs.getString("KDJ_D")));
						sdd.setKdj_j(CommonTool.converToDoubleNumber(rs.getString("KDJ_J")));
						sdd.setKdj_jcsc(CommonTool.converToJCSC(rs.getString("kdj_jcsc")));
						
						sdd.setOpen_rise(open_rise);
						sdd.setHigh_rise(high_rise);
						sdd.setLow_rise(low_rise);
						sdd.setClose_rise(final_rise);
					
						sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
						
						stockDataRecordMap.put(sdd.getDate(), sdd);
						
						
				}
				Iterator it=stockDataRecordMap.keySet().iterator();
				int posNum=0;
				while(it.hasNext())
				{
					StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
					sdd.setPosNum(posNum);
					stockDataRecordList.add(sdd);
					posNum++;
					
				}
	
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
		}
		
		return stockDataRecordList;
		
		
	}
	
	
	
	public static List getStockDataRecordList_forStockCodeListFull(String datasetFolderPath, String stockfilename)
	{
	
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename);
		Map stockDataRecordMap=new TreeMap();
		List stockDataRecordList=new ArrayList();	
				
		try
		{
			
				while (rs.next()) {
		
					StockDayData sdd=new StockDayData();
					
					sdd.setCode(rs.getString("scode").trim());
					sdd.setName(rs.getString("sname").trim());
					sdd.setDate(rs.getString("date").trim());
					sdd.setIndustry(rs.getString("industry").trim());
					sdd.setLocation(rs.getString("location").trim());
					sdd.setConcept(rs.getString("concept").trim());
					
					stockDataRecordList.add(sdd);
						
					break;
				}
				
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
			
		
		return stockDataRecordList;
		
		
	}
	
	
	
	
	public static List getStockSecondDataRecordList(String datasetFolder, String date, String stockcode)
	{
		String prefix="";
		if (stockcode.startsWith("6"))
		{
			prefix="sh";
		}
		else
		{
			prefix="sz";
		}
		String stockfilename=prefix+stockcode+"_fenbi_"+date.replace("/", "");  // 例如：sh600000_fenbi_20170103
		String datasetFolderPath=datasetFolder+"\\fenbi-data-push-"+date.replace("/", "-"); // 例如：fenbi-data-push-2017-01-03
		
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename);
		List stockSecondDataRecordList=new ArrayList();	
							
		try
		{
			int posNum=0;
			while (rs.next()) {
	
				StockSecondData ssd=new StockSecondData();
				
				ssd.setPosNum(posNum);
				ssd.setTime(rs.getString("time"));
				ssd.setPrice(CommonTool.converToDoubleNumber(rs.getString("price")));
				ssd.setCount(CommonTool.converToIntegerNumber(rs.getString("count")));
				ssd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money")));
				ssd.setAmount(CommonTool.converToIntegerNumber(rs.getString("amount")));  // 转成整数
				ssd.setBsp(rs.getString("bsp"));
				
				ssd.setBuyPrice1(CommonTool.converToDoubleNumber(rs.getString("buyPrice1" )));
				ssd.setBuyPrice2(CommonTool.converToDoubleNumber(rs.getString("buyPrice2" )));
				ssd.setBuyPrice3(CommonTool.converToDoubleNumber(rs.getString("buyPrice3" )));
				ssd.setBuyPrice4(CommonTool.converToDoubleNumber(rs.getString("buyPrice4" )));
				ssd.setBuyPrice5(CommonTool.converToDoubleNumber(rs.getString("buyPrice5" )));
				ssd.setBuyAmount1(Integer.parseInt(rs.getString("buyAmount1").trim()));
				ssd.setBuyAmount2(Integer.parseInt(rs.getString("buyAmount2").trim()));
				ssd.setBuyAmount3(Integer.parseInt(rs.getString("buyAmount3").trim()));
				ssd.setBuyAmount4(Integer.parseInt(rs.getString("buyAmount4").trim()));
				ssd.setBuyAmount5(Integer.parseInt(rs.getString("buyAmount5").trim()));
				
				ssd.setSalePrice1(CommonTool.converToDoubleNumber(rs.getString("salePrice1" )));
				ssd.setSalePrice2(CommonTool.converToDoubleNumber(rs.getString("salePrice2" )));
				ssd.setSalePrice3(CommonTool.converToDoubleNumber(rs.getString("salePrice3" )));
				ssd.setSalePrice4(CommonTool.converToDoubleNumber(rs.getString("salePrice4" )));
				ssd.setSalePrice5(CommonTool.converToDoubleNumber(rs.getString("salePrice5" )));
				ssd.setSaleAmount1(Integer.parseInt(rs.getString("saleAmount1").trim()));
				ssd.setSaleAmount2(Integer.parseInt(rs.getString("saleAmount2").trim()));
				ssd.setSaleAmount3(Integer.parseInt(rs.getString("saleAmount3").trim()));
				ssd.setSaleAmount4(Integer.parseInt(rs.getString("saleAmount4").trim()));
				ssd.setSaleAmount5(Integer.parseInt(rs.getString("saleAmount5").trim()));
				
				stockSecondDataRecordList.add(ssd);
			
				posNum++;
				
			}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
			
		
		return stockSecondDataRecordList;
		
		
	}
	
	
	public static List getTransactionDataList(String datasetFolderPath, String stockfilename, String condition)
	{
		
			// get stock data from stockall library
			ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename, condition);
			List transactionDataList=new ArrayList();	
									
			try
			{
				while (rs.next()) {
		
					TransactionRecordData trd=new TransactionRecordData();
					
					StockDayData buySdd=new StockDayData();
					StockDayData saleSdd=new StockDayData();
					
					// 只需要知道哪只股票，在哪天买入，哪天卖出即可
					trd.setStockcode(rs.getString("stockcode").trim());
					buySdd.setDate(rs.getString("date_c").trim());
					saleSdd.setDate(rs.getString("saledate").trim());
					buySdd.setName(rs.getString("stockname").trim());
					saleSdd.setName(rs.getString("stockname").trim());
					double profit=CommonTool.converToDoubleNumber(rs.getString("profit").trim());
					saleSdd.setProfit(profit);					
					
					trd.setBuySDD(buySdd);
					trd.setSaleSDD(saleSdd);
					
					transactionDataList.add(trd);
						
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
			return transactionDataList;
		
	}
	
			
	
	public static List getAllStock_600(List stockCodeList)
	{
		
		List researchStockCodeList=new ArrayList();
		for (int i=0; i<stockCodeList.size(); i++)
		{
			
			// 按规则抽样选取
			if (i>=0 && i<stockCodeList.size())
			{
				String codeStr=stockCodeList.get(i).toString();
				
				if (codeStr.startsWith("sh6"))  // 选取沪市主板
				{
					researchStockCodeList.add(codeStr);
				}
			}
		}
		return researchStockCodeList;
		
	}
	
	public static List getAllStock_300(List stockCodeList)
	{
		
		List researchStockCodeList=new ArrayList();
		for (int i=0; i<stockCodeList.size(); i++)
		{
			
			// 按规则抽样选取
			if (i>=0 && i<stockCodeList.size())
			{
				String codeStr=stockCodeList.get(i).toString();
				
				if (codeStr.startsWith("sz3"))  // 选取沪市主板
				{
					researchStockCodeList.add(codeStr);
				}
			}
		}
		return researchStockCodeList;
		
	}
	
	public static List getAllStock_000(List stockCodeList)
	{
		
		List researchStockCodeList=new ArrayList();
		for (int i=0; i<stockCodeList.size(); i++)
		{
			
			// 按规则抽样选取
			if (i>=0 && i<stockCodeList.size())
			{
				String codeStr=stockCodeList.get(i).toString();
				
				if (codeStr.startsWith("sz000"))  // 选取沪市主板
				{
					researchStockCodeList.add(codeStr);
				}
			}
		}
		return researchStockCodeList;
		
	}
	
	public static List getAllStock_002(List stockCodeList)
	{
		
		List researchStockCodeList=new ArrayList();
		for (int i=0; i<stockCodeList.size(); i++)
		{
			
			// 按规则抽样选取
			if (i>=0 && i<stockCodeList.size())
			{
				String codeStr=stockCodeList.get(i).toString();
				
				if (codeStr.startsWith("sz002"))  // 选取沪市主板
				{
					researchStockCodeList.add(codeStr);
				}
			}
		}
		return researchStockCodeList;
		
	}
	
	public static List getAllStock_Random(List stockCodeList, int randomCount)
	{
		
		List researchStockCodeList=new ArrayList();
		int count=stockCodeList.size();
		
		List randomNumberList=new ArrayList();
		for (int n=0; n<randomCount; n++)
		{
			double m=Math.random();
			int rn=(int)(m*count);
			randomNumberList.add(rn);
		}
		
		
		for (int i=0; i<randomNumberList.size(); i++)
		{
			int r=CommonTool.getIntValue(randomNumberList.get(i).toString()); 
			String codeStr=stockCodeList.get(r).toString();
			researchStockCodeList.add(codeStr);
			
			System.out.println(codeStr);
			
		}
		return researchStockCodeList;
		
	}

	public static List getAllStock_ByOrderNo(List stockCodeList, int startPos, int numbers)
	{
		
		List researchStockCodeList=new ArrayList();
		int count=stockCodeList.size();
		
		List randomNumberList=new ArrayList();
		for (int n=0; n<numbers; n++)
		{
			int currentPos=startPos+n;
			if (stockCodeList.get(currentPos)!=null)
			{
				String codeStr=stockCodeList.get(currentPos).toString();
				researchStockCodeList.add(codeStr);
			
				System.out.println(codeStr);
			}
		}
		
		return researchStockCodeList;
		
	}
	
	public static void getAllStock_ByMarketValue(List stockCodeList, int numbers, String type)
	{
		
		
		
		
	}
	
	public static void calculateMAValue(List stockDataRecordList, StockDayData sdd)
	{
		
		sdd.setMa_5(getMAValue(stockDataRecordList, sdd, 5));
		sdd.setMa_10(getMAValue(stockDataRecordList, sdd, 10));
		sdd.setMa_20(getMAValue(stockDataRecordList, sdd, 20));
		sdd.setMa_30(getMAValue(stockDataRecordList, sdd, 30));
		sdd.setMa_60(getMAValue(stockDataRecordList, sdd, 60));
		
	}

	
	public static double getMAValue(List stockDataRecordList, StockDayData sdd, int days)
	{
		
		double ma_value=0;
		double sdd_total_ma=0;
		
		if (stockDataRecordList.size()>=days)
		{
			for (int i=1; i<=days; i++)
			{
				sdd_total_ma=sdd_total_ma+((StockDayData)stockDataRecordList.get(stockDataRecordList.size()-i)).getClose();	
			}
		}
		ma_value=CommonTool.getDoubleNumberWithTwoBit(sdd_total_ma/days);
		
		return ma_value;
		
	}
	
	public static List getStockDataRecordListWithProfit(String datasetFolderPath, String stockfilename, String profitColumnName)
	{
	
		// get stock data from stockall library
		ResultSet rs=CommonTool.readDataFromSASDataSet(datasetFolderPath, stockfilename);
		Map stockDataRecordMap=new TreeMap();
		List stockDataRecordList=new ArrayList();	
				
			
		try
		{
			while (rs.next()) {
	
				StockDayData sdd=new StockDayData();
				
					sdd.setCode(rs.getString("code_i").trim());
					sdd.setDate(rs.getString("date").trim());						
					
					sdd.setOpen(CommonTool.getDoubleNumberWithTwoBit(CommonTool.converToDoubleNumber(rs.getString("open_i"))));
					sdd.setHigh(CommonTool.getDoubleNumberWithTwoBit(CommonTool.converToDoubleNumber(rs.getString("high_i"))));
					sdd.setLow(CommonTool.getDoubleNumberWithTwoBit(CommonTool.converToDoubleNumber(rs.getString("low_i"))));
					sdd.setClose(CommonTool.getDoubleNumberWithTwoBit(CommonTool.converToDoubleNumber(rs.getString("final_i"))));
					
					sdd.setAmount(CommonTool.converToDoubleNumber(rs.getString("amount_i")));
					sdd.setMoney(CommonTool.converToDoubleNumber(rs.getString("money_i")));
					
					sdd.setOpen_rise(CommonTool.converToDoubleNumber(rs.getString("open_rise_i")));
					sdd.setHigh_rise(CommonTool.converToDoubleNumber(rs.getString("high_rise_i")));
					sdd.setLow_rise(CommonTool.converToDoubleNumber(rs.getString("low_rise_i")));
					sdd.setClose_rise(CommonTool.converToDoubleNumber(rs.getString("final_rise_i")));
				
					sdd.setReal_rise(sdd.getClose_rise()-sdd.getOpen_rise());
					
//					sdd.setProfit(CommonTool.converToDoubleNumber(rs.getString("average_fr_a1")));
					sdd.setProfit(CommonTool.converToDoubleNumber(rs.getString(profitColumnName)));
					sdd.setCount(rs.getString("count"));
					sdd.setTransDate(true);
					
					stockDataRecordMap.put(sdd.getDate(), sdd);
					
					
			}
			Iterator it=stockDataRecordMap.keySet().iterator();
			int posNum=0;
			while(it.hasNext())
			{
				StockDayData sdd=(StockDayData)stockDataRecordMap.get(it.next());
				sdd.setPosNum(posNum);
				calculateMAValue(stockDataRecordList, sdd);  // 计算指数的均线值
				stockDataRecordList.add(sdd);
				posNum++;
				
			}

		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
			
		
		return stockDataRecordList;
		
	}
	
	
	public static int getDatePosition(List stockDataRecordList, String dateStr)
	{
		int datePosition=0;
		for (int i=0; i<stockDataRecordList.size(); i++)
		{
			StockDayData sdd=(StockDayData)stockDataRecordList.get(i);
			if (sdd.getDate()!=null && sdd.getDate().trim().equals(dateStr))
			{
				datePosition=i;
			}
			
		}
		
		return datePosition;
		
		
	}
	
	// 获得历史时间标尺List，按顺序存储了历史上所有交易日日期
	public static List getDateReferenceList()
	{
		
		if (dateReferenceList==null)
		{
			
			dateReferenceList=new ArrayList();
				
			// 读取上证全部历史日期
			String indexFileName_600="index000001";
			String indexFilePath=StockKey.stockAllFolderPath;
			List indexDataRecordList=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_600);
			
			for (int i=0; i<indexDataRecordList.size(); i++)
			{
				StockDayData idd=(StockDayData)indexDataRecordList.get(i);
				dateReferenceList.add(idd.getDate());
				
			}
		}
		
		return dateReferenceList;
		
	}
	
	public static List getDateReferenceList(String startDate, String endDate)
	{
		
		// 读取上证部分历史日期
		String indexFileName_600="index000001";
		String indexFilePath=StockKey.stockHome+"\\StockAllDataFull\\all\\index";
		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
		List indexDataRecordList=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_600, condition );
		
		List dateReferenceList=new ArrayList();
	
		for (int i=0; i<indexDataRecordList.size(); i++)
		{
			StockDayData idd=(StockDayData)indexDataRecordList.get(i);
			dateReferenceList.add(idd.getDate());
			
		}
		
		return dateReferenceList;
		
	}
	
	public static List getDateReferenceList(String startDate, String endDate, int minute)
	{
		
		int no=240/minute;
		
		// 读取上证部分历史日期
		String indexFileName_600="index000001";
		String indexFilePath=StockKey.stockHome+"\\StockAllDataFull\\all\\index";
		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
		List indexDataRecordList=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_600, condition );
		
		List dateReferenceList=new ArrayList();
	
		for (int i=0; i<indexDataRecordList.size(); i++)
		{
			StockDayData idd=(StockDayData)indexDataRecordList.get(i);
			
			for (int j=1; j<=no; j++)
			{
				if (j<10)
				{
					dateReferenceList.add(idd.getDate()+"-00"+j);
				}
				else if (j<100)
				{
					dateReferenceList.add(idd.getDate()+"-0"+j);
				}
				else
				{
					dateReferenceList.add(idd.getDate()+"-"+j);
				}
				
			}
		}
		
		return dateReferenceList;
		
	}
	
	
	public static String getDateReferenceDate(String startDate, int days)
	{
		
		String dateStr=null;
		dateReferenceList=getDateReferenceList();
		
		for (int i=0; i<dateReferenceList.size(); i++)
		{
			String curDate=dateReferenceList.get(i).toString();
			if (curDate.equals(startDate) && i+days>=0)
			{
				dateStr=dateReferenceList.get(i+days).toString();
			}
			
		}
		
		return dateStr;
		
		
	}
	
	public static List generateTimeReferenceList(String startDate, String endDate, String timeType)
	{
		
		// 获得参考交易日期队列  - 切换日线数据/分时数据的时间标尺
		List dateList=new ArrayList();
		if (timeType.contains("day"))
		{
			dateList=CommonTool.getDateReferenceList(startDate, endDate);
		}
		else if (timeType.contains("minute"))
		{
			String minuteStr=timeType.substring(6);
			int minute=Integer.parseInt(minuteStr);
			dateList=CommonTool.getDateReferenceList(startDate, endDate, minute);		// 以上证指数的交易分时为参考值 - 待开发
		}
		
		return dateList;
				
	}

	
	public static double getDoubleNumberWithTwoBit(double d_number)
	{
		try
		{
			
//			d_number=((int)(d_number*100))/100.0; //注意：使用100.0 而不是 100
			
			BigDecimal b=new BigDecimal(d_number);  
			d_number=b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();  // 必须用3位高精度
			
//			d_number=b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();   // 取小数点后2位
//			d_number=b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();   // 取小数点后3位
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return d_number;
		
	}
	
	public static String formatNumberStrWithTwoBit(String d_number_str)
	{
		String result=d_number_str;
		if (CommonTool.isRealNumber(d_number_str) && d_number_str.contains(".") && !d_number_str.contains("E"))
		{
			int dotPos=d_number_str.indexOf(".");
			if (d_number_str.length()>dotPos+2)   // 12.345
			{
				result=d_number_str.substring(0, dotPos+3);
			}
			else
			{
				result=d_number_str;
			}
			
			
		}
		
		return result;
	}
	
	public static List getColumnDataList(ResultSet rs, String columnName)
	{
		
		List columnDataList=new ArrayList();
		try
		{
			while (rs.next()) {
				
				String value=rs.getString(columnName);
				columnDataList.add(value.trim());
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return columnDataList;
		
	}
	
	
	public static double getStockMax(List stockDataList, String priceType)
	{
		double max=0;
		if (priceType.equals("close"))
		{
			for (int i=0; i<stockDataList.size(); i++)
			{
				StockDayData sdd=(StockDayData)stockDataList.get(i);
				max=Math.max(max, sdd.getPf_close());
				
				if (i==0)
					System.out.print(sdd.getCode()+" "+sdd.getName()+" "+sdd.getDate().trim()+" ");
				
				if (i==stockDataList.size()-1)
					System.out.print(sdd.getDate().trim());
			}
		}
			
		if (priceType.equals("high"))
		{
			for (int i=0; i<stockDataList.size(); i++)
			{
				StockDayData sdd=(StockDayData)stockDataList.get(i);
				max=Math.max(max, sdd.getHigh());
			}
		}	
			
		return max;
		
	}
    
	
	public static double getStockMin(List stockDataList, String priceType)
	{
		double min=10000;
		if (priceType.equals("close"))
		{
			for (int i=0; i<stockDataList.size(); i++)
			{
				StockDayData sdd=(StockDayData)stockDataList.get(i);
				min=Math.min(min, sdd.getPf_close());
				
			}
		}
			
		if (priceType.equals("low"))
		{
			for (int i=0; i<stockDataList.size(); i++)
			{
				StockDayData sdd=(StockDayData)stockDataList.get(i);
				min=Math.min(min, sdd.getLow());
			}
		}	
			
		return min;
		
	}
	
	public static double getStockMean(List stockDataList, String priceType)
	{
		double mean=0;
		double total=0;
		int n=0;
		if (priceType.equals("close"))
		{
			for (int i=0; i<stockDataList.size(); i++)
			{
				StockDayData sdd=(StockDayData)stockDataList.get(i);
				total=total+sdd.getPf_close();
				n++;
			}
			
			mean=total/n;
		}
		
		return mean;
		
	}
	
	public static double getStockMeanRise(List stockDataList, String priceType)
	{
		double meanRise=0;
		double totalRise=0;
		int n=0;
		if (priceType.equals("close"))
		{
			for (int i=0; i<stockDataList.size(); i++)
			{
				StockDayData sdd=(StockDayData)stockDataList.get(i);
				totalRise=totalRise+Math.abs(sdd.getClose_rise());
				n++;
			}
			
			meanRise=CommonTool.getDoubleNumberWithTwoBit(totalRise/n);
		}
		
		return meanRise;
		
	}
	
	
	public static String getStockMarketType(String stockcode)
	{
		
		String marketType="all";
	
// 暂时以全市场all为参考，因为各个市场数据缺少2019年7月以后的，以后再择机放开
	
		if (stockcode.startsWith("6"))
			marketType="600";
		
		if (stockcode.startsWith("3"))
			marketType="300";
		
		if (stockcode.startsWith("000") || stockcode.startsWith("001"))
			marketType="000";
		
		if (stockcode.startsWith("002") || stockcode.startsWith("003"))
			marketType="002";


		return marketType;
		
	}
	
	public static int findPossibleDateColumn(DefaultTableModel dtm)
	{
		
		int datecol=dtm.findColumn("date");
		if (datecol==-1)
		{
			datecol=dtm.findColumn("date_c");
			if (datecol==-1)
			{
				datecol=dtm.findColumn("date_sum");
				if (datecol==-1)
				{
					datecol=dtm.findColumn("date_org");
				}
			}
		}
		
		return datecol;
		
	}
	
	public static int findPossibleCodeColumn(DefaultTableModel dtm)
	{
		
		int codecol=dtm.findColumn("code");
		if (codecol==-1)
		{
			codecol=dtm.findColumn("scode");
			if (codecol==-1)
			{
				codecol=dtm.findColumn("stockcode");
				if (codecol==-1)
				{
					codecol=dtm.findColumn("scode_org");
					if (codecol==-1)
					{
						codecol=dtm.findColumn("code_i");
					}
				}
			
			}
			
		}
		
		return codecol;
		
	}
	
	
	public static double getStockCurrentLiquidValue(List stockDayDataList)
	{
		double liquidValue=0;
		if (stockDayDataList.size()>0)
		{
			StockDayData lastSdd=(StockDayData)stockDayDataList.get(stockDayDataList.size()-1);
			liquidValue=CommonTool.getDoubleNumberWithTwoBit(lastSdd.getLiquid_value()/100000000);	
		}

		return liquidValue;
		
	}
	
	public static double getStockCurrentTotalValue(List stockDayDataList)
	{
		double totalValue=0;
		if (stockDayDataList.size()>0)
		{
			StockDayData lastSdd=(StockDayData)stockDayDataList.get(stockDayDataList.size()-1);
			totalValue=CommonTool.getDoubleNumberWithTwoBit(lastSdd.getTotal_value()/100000000);	
		}

		return totalValue;
		
	}
	
	public static String dealNullStr(String obj)
	{
		String result="";
		if (obj==null)
		{
			result="";
		}
		else
		{
			result=obj;
		}
		
		return result;
		
	}
	
	public static int calcStrLength(String str, float fontSize)
	{
		int strLen=(int)(str.length()*fontSize);
		return strLen;
		
	}
		
	public static double calculateMaxDrawDownByRate(List rateList)
	{
		
		double maxDDR=0;
		double startPrice=100;
		List priceList=new ArrayList();
		priceList.add(priceList);
		
		double currentPrice=startPrice;
		for (int i=0; i<rateList.size(); i++)
		{
			double rate=Double.parseDouble(rateList.get(i).toString());
			currentPrice=currentPrice*(1+rate);
			priceList.add(currentPrice);
		}
		
		maxDDR=calculateMaxDrawDownByPrice(priceList);
		
		return maxDDR;
		
	}
	
	public static double calculateMaxDrawDownByPrice(List priceList)
	{
		
		double maxDDR=0;
		List DDRList=new ArrayList();
		
		for (int i=0; i<priceList.size(); i++)
		{
			double curPrice=Double.parseDouble(priceList.get(i).toString()); // 获得每个值作为当前价格值
			double min=curPrice;
			for (int j=i; j<priceList.size(); j++)  // 从当前价格值往后查找最小价格值
			{
				double price=Double.parseDouble(priceList.get(j).toString());
				min=Math.min(min, price);
			}
			double DDR=getDoubleNumberWithTwoBit((curPrice-min)*100/curPrice); // 计算当前价格值为买入点的最大回撤
			DDRList.add(DDR);
		}
		
		for (int n=0; n<DDRList.size(); n++)
		{
			double DDR=Double.parseDouble(DDRList.get(n).toString());
			maxDDR=Math.max(maxDDR, DDR);
		}
		
		return maxDDR;   // 返回最大回撤幅值
	
	}
	
	// 盘中最大回撤，以盘中最高点作为买入点，盘中最低点作为卖出点，计算得出的DDR
	public static StockRecordDDR calculateMaxDrawDownBySDD(List sddList)
	{
		
		// StockRecordDDR 交易记录 list
		List SRDList=new ArrayList();
		
		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd_i=(StockDayData)sddList.get(i);
			double curPrice=(double)sdd_i.getHigh(); // 获得每个sdd的最高价作为当前可能买入的最高价格值
			double min=curPrice;
			StockDayData minSDD=new StockDayData();
			for (int j=i; j<sddList.size(); j++)  // 从当前价格值往后查找最小价格值
			{
				StockDayData sdd_j=(StockDayData)sddList.get(j);
				double price=sdd_j.getClose();  // 获得余下的sdd收盘价作为之后可能遇到的最低价格值
				
				if (price<min)
				{
					min=price;
					minSDD=sdd_j;
				}
				
			}
			if(curPrice==0)
				continue;
			
			double DDR=getDoubleNumberWithTwoBit((curPrice-min)*100/curPrice); // 计算以curPrice为当前价格值为买入点的最大回撤
			
			StockRecordDDR srd=new StockRecordDDR();
			srd.setCurSDD(sdd_i);
			srd.setMinSDD(minSDD);
			srd.setDDR(DDR);
			SRDList.add(srd);
		}
		
		StockRecordDDR maxSRD=new StockRecordDDR();
		double maxDDR=0;
		for (int n=0; n<SRDList.size(); n++)
		{
			StockRecordDDR srd=(StockRecordDDR)SRDList.get(n);
			double ddr=srd.getDDR();
			if (ddr>maxDDR)
			{
				maxDDR=ddr;
				maxSRD=srd;
			}
		}
		
		return maxSRD;   // 返回最大回撤记录
	
	}
	
	public static double calculateMaxRiseUpByPrice(List priceList)
	{
		
		double maxRUR=0;
		List RURList=new ArrayList();
		
		for (int i=0; i<priceList.size(); i++)
		{
			double curPrice=Double.parseDouble(priceList.get(i).toString()); // 获得每个值作为当前价格值
			double max=curPrice;
			for (int j=i; j<priceList.size(); j++)  // 从当前价格值往后查找最大价格值
			{
				double price=Double.parseDouble(priceList.get(j).toString());
				max=Math.max(max, price);
			}
			if(curPrice==0)
				continue;
			
			double RUR=getDoubleNumberWithTwoBit((max-curPrice)*100/curPrice); // 计算当前价格值为买入点的最大回撤
			RURList.add(RUR);
		}
		
		for (int n=0; n<RURList.size(); n++)
		{
			double RUR=Double.parseDouble(RURList.get(n).toString());
			maxRUR=Math.max(maxRUR, RUR);
		}
		
		return maxRUR;	// 返回最大上涨幅值
	
	}
	
	public static double calculateMaxRiseUpByRate(List rateList)
	{
		
		double maxRUR=0;
		double startPrice=100;
		List priceList=new ArrayList();
		priceList.add(priceList);
		
		double currentPrice=startPrice;
		for (int i=0; i<rateList.size(); i++)
		{
			double rate=Double.parseDouble(rateList.get(i).toString());
			currentPrice=currentPrice*(1+rate);
			priceList.add(currentPrice);
		}
		
		maxRUR=calculateMaxRiseUpByPrice(priceList);
		
		return maxRUR;
		
	}
	
	public static StockRecordRUR calculateMaxRiseUpBySDD(List sddList)
	{

		// StockRecordRUR 交易记录 list
		List SRRList=new ArrayList();
		
		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd_i=(StockDayData)sddList.get(i);
			double curPrice=(double)sdd_i.getLow(); // 获得每个sdd的最低价作为当前可能买入的最低价格值
			double max=curPrice;
			StockDayData maxSDD=new StockDayData();
			
			for (int j=i; j<sddList.size(); j++)  // 从当前价格值往后查找最大价格值
			{
				StockDayData sdd_j=(StockDayData)sddList.get(j);
				double price=sdd_j.getHigh();  // 获得余下的sdd最高价作为之后可能遇到的最高价格值
				
				if (price>max)
				{
					max=price;
					maxSDD=sdd_j;
				}
			}
			
			if(curPrice==0)
				continue;
			
			double RUR=getDoubleNumberWithTwoBit((max-curPrice)*100/curPrice); // 计算当前价格值为买入点的最大涨幅

			StockRecordRUR srr=new StockRecordRUR();
			srr.setCurSDD(sdd_i);
			srr.setMaxSDD(maxSDD);
			srr.setRUR(RUR);
			SRRList.add(srr);
		}
	
		StockRecordRUR maxSRR=new StockRecordRUR();
		double maxRUR=0;
		for (int n=0; n<SRRList.size(); n++)
		{
			StockRecordRUR srr=(StockRecordRUR)SRRList.get(n);
			double rur=srr.getRUR();
			if (rur>maxRUR)
			{
				maxRUR=rur;
				maxSRR=srr;
			}
		}
		
		return maxSRR;  // 返回最大上涨幅记录
		
	}
	
	
	public static void openStockKChart(String code)
	{
		
		try
		{
			String filePreStr="stock";
			String datasetFolderPath=StockKey.stockAllFolderPath;
			String stockfilename=filePreStr+code;
			List stockDataRecordList=CommonTool.getStockDataRecordList(datasetFolderPath, stockfilename);
			StockDayData sdd=(StockDayData)stockDataRecordList.get(stockDataRecordList.size()-1);
			String centerDate=sdd.getDate();
			
			int k_width=12;  // k线区域的宽度，一般要在10以上才行
			int y_distance=1;
			int d_height=0;
			
			StockKLineFrame sklc=new StockKLineFrame(stockDataRecordList, centerDate,  k_width, y_distance, d_height);
			int desktopWidth=StockComponent.desktopPane.getWidth();
			int desktopHeight=StockComponent.desktopPane.getHeight();
			sklc.setSize(desktopWidth-80, desktopHeight-80);
			
			StockComponent.desktopPane.add(sklc);
	//		CommonTool.setLocationInScreenCenter(sklc);
			sklc.setTitle(filePreStr+": "+code+" "+sdd.getName());
			sklc.setLocation(40, 40);
			sklc.setVisible(true);
			sklc.setSelected(true);
			sklc.moveToFront();		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void autoFitTableColumns(JTable myTable) {               //設置table的列寬隨內容調整

        JTableHeader header = myTable.getTableHeader();

        int rowCount = myTable.getRowCount();

        Enumeration columns = myTable.getColumnModel().getColumns();

        while (columns.hasMoreElements()) {

            TableColumn column = (TableColumn) columns.nextElement();

            int col = header.getColumnModel().getColumnIndex(

                    column.getIdentifier());

            int width = (int) myTable.getTableHeader().getDefaultRenderer()

                    .getTableCellRendererComponent(myTable,

                            column.getIdentifier(), false, false, -1, col)

                    .getPreferredSize().getWidth();

//            for (int row = 0; row < rowCount; row++){
            if (rowCount>20)
            {
            	rowCount=20;
            }
            for (int row = 0; row < rowCount; row++){    // 以前20条数据的最大值为参考标准
            	
                int preferedWidth = (int) myTable.getCellRenderer(row, col)

                        .getTableCellRendererComponent(myTable,

                                myTable.getValueAt(row, col), false, false,

                                row, col).getPreferredSize().getWidth();

                width = Math.max(width, preferedWidth); 

            }

            header.setResizingColumn(column);

            column.setWidth(width + myTable.getIntercellSpacing().width +20); // 稍微加宽一些 10

        }

    }
	
	
	public static String getSqlStrDataDef(String data)
	{
		
		String defStr="\""+data+"\",";
		
		return defStr;
		
	}
	
	public static String getSqlNumberDataDef(String data)
	{
		String defStr="";
		if (data.contains("."))
		{		
			double number=converToDoubleNumber(data);
			defStr=number+",";
		}
		else 
		{
			int number=converToIntegerNumber(data);
			defStr=number+",";
		}
		
		return defStr;
	}
	
	public static String getSqlDateDataDef(String date)
	{
		
		String defStr="";
		
		if (date.length()==10)
		{
			String year=date.substring(0,4);
			String month=date.substring(5,7);
			String day=date.substring(8,10);
			
			String monthStr=transSASMonth(month);
			defStr="\""+day+monthStr+year+"\"d,";
		}
		
		return defStr;
		
	}
	
	public static String getSqlDateSearchConditionStr(String startDate, String endDate)
	{
		
		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";
		return condition;
		
	}
	
	// 日期类型默认设置：YYMMDD10.
	public static String getSqlDateColumnDef(String columnName)
	{
		
		String defStr=columnName+" date format YYMMDD10. informat YYMMDD10. ,";
		
		return defStr;

	}
	
	// 文本类型通用模板
	public static String getSqlStrColumnDef(String columnName, int length, String columnFormat)
	{
		
		String defStr=columnName+" varchar("+length+") format "+columnFormat+",";
		
		return defStr;

	}
	
	// 默认设置为：类型varchar(length) 输入格式 $length. 输出格式 $length.
	public static String getSqlStrColumnDef(String columnName, int length)
	{
		
		String defStr=columnName+" varchar("+length+") format $"+length+". informat $"+length+".,";
		
		return defStr;

	}
	
	// 数字类型变量通用模板
	public static String getSqlNumberColumnDef(String columnName, String numberType, String columnFormat)
	{
		
		String defStr=columnName+" "+numberType+" format "+columnFormat+",";
		
		return defStr;

	}
	
	// 默认设置为：输入格式 BEST32. 输出格式 BEST12.
	public static String getSqlNumberColumnDef(String columnName)
	{
		
		String defStr=columnName+" double precision format BEST12. informat BEST32. ,";
		
		return defStr;

	}
	
	// 默认设置为：输入格式 BEST32. 输出格式 BEST12.
	public static String getSqlNumberColumnDefINT(String columnName)
	{
		
		String defStr=columnName+" int format BEST12. informat BEST32. ,";
		
		return defStr;

	}
	
	public static String getSqlSetColumnPrimaryKeyDef(String columnName)
	{
		
		String defStr="CONSTRAINT "+columnName+" PRIMARY KEY";
		
		return defStr;
		
	}
	
	
	public static String transSASMonth(String month)
	{
		String monthStr="";
		
		if (month.equals("01"))
		{
			monthStr="Jan";
		}
		
		if (month.equals("02"))
		{
			monthStr="Feb";
		}
		
		if (month.equals("03"))
		{
			monthStr="Mar";
		}
		
		if (month.equals("04"))
		{
			monthStr="Apr";
		}
		
		if (month.equals("05"))
		{
			monthStr="May";
		}
		
		if (month.equals("06"))
		{
			monthStr="Jun";
		}
		
		if (month.equals("07"))
		{
			monthStr="Jul";
		}
		
		if (month.equals("08"))
		{
			monthStr="Aug";
		}
		
		if (month.equals("09"))
		{
			monthStr="Sep";
		}

		if (month.equals("10"))
		{
			monthStr="Oct";
		}
		
		if (month.equals("11"))
		{
			monthStr="Nov";
		}
		
		if (month.equals("12"))
		{
			monthStr="Dec";
		}
		
		return monthStr;
		
	}
	
	public static DefaultMutableTreeNode getTreeNodeByFolderPath(JTree tree, String folderPath)
	{
		
		DefaultMutableTreeNode dmtn=null;
		
		
		
		
		return dmtn;
		
	}
	
	
	
	public static void findInTree(JTree tree, String str){
		
		Object root = tree.getModel().getRoot();
		TreePath treePath = new TreePath(root);
		treePath = findInPath(tree, treePath, str);
		if (treePath != null) {
			tree.setSelectionPath(treePath);
			tree.scrollPathToVisible(treePath);
		}
		
	}

	public static TreePath findInPath(JTree tree, TreePath treePath, String str){
		
		Object object = treePath.getLastPathComponent();
		if (object == null) {
			return null;
		}

		String value = object.toString();
		if (str.equals(value)) {
			return treePath;
		}else {
			TreeModel model = tree.getModel();
			int n = model.getChildCount(object);
			for (int i = 0; i < n; i++) {
				Object child = model.getChild(object, i);
				TreePath path = treePath.pathByAddingChild(child);

				path = findInPath(tree, path, str);
				if (path != null) {
					return path;
				}
			}
			return null;
		}
	}

	public static void markSDD(List stockDataList, String markDate)
	{
		for (int i=0; i<stockDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)stockDataList.get(i);
			if (sdd.getDate().equals(markDate))
			{
				sdd.setMarkDate(true);
			}
		}
		
	}
	
	public static void markSDD_Buy(List stockDataList, String markDate)
	{
		for (int i=0; i<stockDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)stockDataList.get(i);
			if (sdd.getDate().equals(markDate))
			{
				sdd.setBuyDate(true);
			}
		}
		
	}
	
	public static void markSDD_Sale(List stockDataList, String markDate)
	{
		for (int i=0; i<stockDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)stockDataList.get(i);
			if (sdd.getDate().equals(markDate))
			{
				sdd.setSaleDate(true);
			}
		}
		
	}
	
	public static String getContentAfterText(String line, String text)
	{
		int textPos=line.indexOf(text);   // 例如： 成立日期：2010-08-20 基金经理：  萧楠 类型：股票型 管理人：易方达基金  资产规模： 133.08亿元 （截止至：12-31） 
		int followPos=textPos+text.length();
		String followContent=line.substring(followPos).trim();
		int firstSpacePos=followContent.indexOf(" ");
		
		String content=followContent.substring(0, firstSpacePos);
		
		return content;
	}
	
	// 获取一段时间内的股票财务指标分析结果
	public static StockFinanceIndicator calculateStockFinanceIndicator(List stockDataList)
	{
		
		double pe_max=0;
		double pe_min=100000;
		double pe_avg=0;
		double pe_total=0;
		String pe_maxdate;
		String pe_mindate;
		
		StockDayData sdd_lastday=(StockDayData)stockDataList.get(0);
		pe_maxdate=sdd_lastday.getDate();
		pe_mindate=sdd_lastday.getDate();
		Map pe_changedateMap=new TreeMap();
		String earnChangeHistory="";
		for (int i=0; i<stockDataList.size(); i++)
		{
			StockDayData sdd=(StockDayData)stockDataList.get(i);
			double pe_current=sdd.getPe_ratio();
			if (pe_current>pe_max)
			{
				pe_max=pe_current;
				pe_maxdate=sdd.getDate();
			}
			if (pe_current<pe_min)
			{
				pe_min=pe_current;
				pe_mindate=sdd.getDate();
			}
			pe_total=pe_total+pe_current;
			
			if (sdd.getPe_ratio()!=0 && sdd_lastday.getPe_ratio()!=0 && sdd_lastday.getClose()!=0)
			{
				
				double earnChange=((sdd.getClose()/sdd.getPe_ratio())/(sdd_lastday.getClose()/sdd_lastday.getPe_ratio())-1)*100;
				earnChange=CommonTool.getDoubleNumberWithTwoBit(earnChange);
				if (Math.abs(earnChange)>1)
				{
					pe_changedateMap.put(sdd.getDate(), earnChange);
					earnChangeHistory=earnChangeHistory+sdd.getDate()+" "+earnChange+"%\n";
	//				System.out.println(earnChangeHistory);
				}
			
				sdd_lastday=sdd;
			
			}
			
		}
		
		if (stockDataList.size()!=0)
		{
			pe_avg=pe_total/stockDataList.size();
		}
		
		
		StockFinanceIndicator sfi=new StockFinanceIndicator();
		sfi.pe_avg=CommonTool.getDoubleNumberWithTwoBit(pe_avg);
		sfi.pe_max=CommonTool.getDoubleNumberWithTwoBit(pe_max);
		sfi.pe_min=CommonTool.getDoubleNumberWithTwoBit(pe_min);
		sfi.pe_maxdate=pe_maxdate;
		sfi.pe_mindate=pe_mindate;
		
		
		String peChangeHistory="pe_avg: "+sfi.pe_avg+"\n" 
				  +"pe_max: "+sfi.pe_max+" ("+sfi.pe_maxdate+")\n"
				  +"pe_min: "+sfi.pe_min+" ("+sfi.pe_mindate+")\n";
		
		sfi.pe_changedatemap=pe_changedateMap;
		sfi.earnChangeHistory=earnChangeHistory;
		sfi.peChangeHistory=peChangeHistory;
		
		return sfi;
		
	}
	
    private static boolean isMatch(String regex, String orginal){  
    	
    	if (orginal == null || orginal.trim().equals("")) {  
             return false;  
         }  
         Pattern pattern = Pattern.compile(regex);  
         Matcher isNum = pattern.matcher(orginal);  
         return isNum.matches();  
     }  
   
     public static boolean isPositiveInteger(String orginal) {  
         return isMatch("^\\+{0,1}[1-9]\\d*", orginal);  
     }  
   
     public static boolean isNegativeInteger(String orginal) {  
         return isMatch("^-[1-9]\\d*", orginal);  
     }  
   
     public static boolean isWholeNumber(String orginal) {  
         return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);  
     }  
       
     public static boolean isPositiveDecimal(String orginal){  
         return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);  
     }  
       
     public static boolean isNegativeDecimal(String orginal){  
         return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);  
     }  
       
     public static boolean isDecimal(String orginal){  
         return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);  
     }  
       
     public static boolean isRealNumber(String orginal){  
         return isWholeNumber(orginal) || isDecimal(orginal);  
     }  

	 public static int converToJCSC(String jcsc_str)
	 {
		 
		 if (jcsc_str==null || jcsc_str.trim().equals(""))
		 {
			 return 0;
		 }
		 
		 if (jcsc_str.trim().equals("金叉"))
		 {
			 return 1;
		 }
		 
		 if (jcsc_str.trim().equals("死叉"))
		 {
			 return -1;
		 }
		 
		 return 0;
		 
	 }
	 
	 public static boolean isTableColumnExist(ResultSet rs, String columnName)
	 {
		 boolean result=false;
		 try
		 {
			 rs.getString(columnName);
			 result=true;
		 }
		 catch(Exception e)
		 {
			 result=false;
		 }
		 
		 return result;
		 
	 }
	 
	 public static StockDayData getIndexDataForStock(StockDayData sdd)
	 {
		 
		 Map indexMap=getAllStockIndexDataMap();
		 
		 StockDayData idd=null;
		 String code=sdd.getCode();
		 String date=sdd.getDate();
		 
		 String type=CommonTool.getStockMarketType(code);
		 List indexDataList=(List)indexMap.get(type);
		 idd=CommonTool.getStockDayData(indexDataList, date);
		 
		 return idd;
		 
	 }
	 
	 public static Map getAllStockIndexDataMap()
	 {
				
		 if (indexMap==null)
		 {
			
			indexMap=new TreeMap();
			
			List indexDataList_600=new ArrayList();
			List indexDataList_000=new ArrayList();
			List indexDataList_002=new ArrayList();
			List indexDataList_300=new ArrayList();
//			List indexDataList_880=new ArrayList();  //次新股指
			
			// 读取全部指数代码
			String indexFileName_600="index000001";
			String indexFileName_000="index399001";
			String indexFileName_002="index399005";
			String indexFileName_300="index399006";
//			String indexFileName_880="index880529";
			
			String indexFilePath=StockKey.stockAllFolderPath;
//			String indexFilePath=StockKey.stockFullFolderPath+"\\tdx";
			
			indexDataList_600=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_600);
			indexDataList_000=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_000);		
			indexDataList_002=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_002);
			indexDataList_300=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_300);
//			indexDataList_880=CommonTool.getStockDataRecordList(indexFilePath, indexFileName_880);
			
			indexMap.put("600", indexDataList_600);
			indexMap.put("000", indexDataList_000);
			indexMap.put("002", indexDataList_002);
			indexMap.put("300", indexDataList_300);
//			indexMap.put("880", indexDataList_880);
			
		 }
			
		return indexMap;
			
	 }

	 public static List getIndexDataList(String marketType)
	 {
		 
		 Map indexMap=getAllStockIndexDataMap();
		 List indexDataList=(List)indexMap.get(marketType);
		 
		 return indexDataList;
		 
	 }
	 
	 public static Map loadMarketDataRecordMap(String type)
	 {
		
		 String datasetFolderPath=StockKey.stockFullFolderPath+"\\market";
		 String stockfilename="marketsumarydata_"+type;
		 Map marketDataRecordMap=CommonTool.getStockMarketDataRecordMap(datasetFolderPath, stockfilename);
		
		 return marketDataRecordMap;
		
	 }
		
	 public static List cloneStockHoldList(List stockHoldList)
	 {
		 List newStockHoldList=new ArrayList();
		 
		 for (int i=0; i<stockHoldList.size(); i++)
		 {
			 StockHoldShare shs=(StockHoldShare)stockHoldList.get(i);
			 StockHoldShare newshs=new StockHoldShare();
			 
			 newshs.code=shs.code;
			 newshs.name=shs.name;
			 newshs.amount=shs.amount;
			 newshs.buyDate=shs.buyDate;
			 newshs.buyPrice=shs.buyPrice;
			 newshs.curDate=shs.curDate;
			 newshs.curPrice=shs.curPrice;
			 newshs.buySDD=shs.buySDD;
			 
			 newStockHoldList.add(newshs);
		 }
		 
		 return newStockHoldList;
		 
	 }
	 
	 
	 public static double calculateTransactionProfit(StockDayData buySDD, StockDayData saleSDD)
	 {
		 
		 double profit;
	 
		 if (buySDD.getOpen()!=0)
		 {
				profit=((saleSDD.getClose()-buySDD.getOpen())/buySDD.getOpen())*100-0.2;
		 }
		 else
		 {
				profit=0;
		 }
	 
		 return profit;
	 }
	 
	 
	 public static String getStockNameByCode(String code)
	 {
		 
		 Map stockCodeNameMap=new TreeMap();

		 // 板块
		 stockCodeNameMap.put("880471", "银行板块");
		 stockCodeNameMap.put("880472", "证券板块");
		 stockCodeNameMap.put("880473", "保险板块");
		 stockCodeNameMap.put("880380", "酿酒板块");
		 stockCodeNameMap.put("880398", "医疗板块");
		 stockCodeNameMap.put("880400", "医药板块");
		 stockCodeNameMap.put("880324", "有色板块");
		 stockCodeNameMap.put("880301", "煤炭板块");
		 stockCodeNameMap.put("880318", "钢铁板块");
		 stockCodeNameMap.put("880310", "石油板块");
		 stockCodeNameMap.put("880494", "互联网板块");
		 stockCodeNameMap.put("880464", "仓储物流板块");
		 
		 // ETF
		 stockCodeNameMap.put("510050", "50ETF");
		 stockCodeNameMap.put("510500", "500ETF");
		 stockCodeNameMap.put("510300", "300ETF");
		 stockCodeNameMap.put("159915", "创业板ETF");
		 stockCodeNameMap.put("159949", "创业板50ETF");
		 stockCodeNameMap.put("159902", "中小板ETF");
		 
		 stockCodeNameMap.put("588000", "科创50ETF");  
		 stockCodeNameMap.put("510900", "H股ETF");  
		 stockCodeNameMap.put("513520", "日经ETF");   
		 stockCodeNameMap.put("513100", "纳指ETF");  
		 stockCodeNameMap.put("513500", "标普500ETF");  
		 
		 stockCodeNameMap.put("515050", "5GETF");
		 stockCodeNameMap.put("512690", "酒ETF");
		 stockCodeNameMap.put("512010", "医药ETF");
		 stockCodeNameMap.put("512880", "证券ETF");
		 stockCodeNameMap.put("512800", "银行ETF");
		 stockCodeNameMap.put("515050", "5GETF");
		 stockCodeNameMap.put("512660", "军工ETF");
		 stockCodeNameMap.put("515210", "钢铁ETF");
		 stockCodeNameMap.put("515220", "煤炭ETF");
		 stockCodeNameMap.put("515000", "科技ETF");
		 stockCodeNameMap.put("512200", "房地产ETF");
		 stockCodeNameMap.put("512480", "半导体ETF");
		 
		 stockCodeNameMap.put("512760", "芯片ETF");  
		 stockCodeNameMap.put("515030", "新能源车ETF"); 
		 stockCodeNameMap.put("516110", "汽车ETF");  
		 stockCodeNameMap.put("515790", "光伏ETF");  
		 stockCodeNameMap.put("512170", "医疗ETF");  
		 stockCodeNameMap.put("516970", "基建50ETF"); 
		 stockCodeNameMap.put("512400", "有色ETF");  
		 stockCodeNameMap.put("518880", "黄金ETF"); 
		 stockCodeNameMap.put("516020", "化工ETF"); 
		 stockCodeNameMap.put("515880", "通信ETF");   
		 stockCodeNameMap.put("159996", "家电ETF"); 
		 stockCodeNameMap.put("512720", "计算机ETF"); 
		 stockCodeNameMap.put("159852", "软件ETF");  
		 stockCodeNameMap.put("159869", "游戏ETF");  
		 stockCodeNameMap.put("159939", "信息技术ETF"); 
		 
		 
		 // 基金
		 stockCodeNameMap.put("110022", "易基消费");
		 stockCodeNameMap.put("008903", "广科先锋");
		 
         
		 // 初始化stock name code列表
         if (StockKey.stockMetaDataMap==null)
         {
        	 String datasetFolderPath=StockKey.stockFullFolderPath;
        	 String stockFileName="stockcodelist_full";
        	 StockKey.stockMetaDataMap=CommonTool.getStockMetaDataMap(datasetFolderPath, stockFileName);
         }
		 
		 String name="";
		 if (stockCodeNameMap.get(code)!=null)
		 {
			 name=stockCodeNameMap.get(code).toString();
		 }
		 else
		 {
			 StockMetaData smd=(StockMetaData)StockKey.stockMetaDataMap.get(code);
			 if (smd!=null)
				name=smd.getName();
		 }
		 
		 return name;
		 
	 }
	 
	 
	 public static List getPastStockDayDataList(List totalStockList, StockDayData curSdd, int days)
	 {
		 
		 	List pastStockList=new ArrayList();
			int curDateNo=curSdd.getPosNum();
				
			if (curDateNo>days)    // curDateNo: 当日序号    days: 之前的天数
			{
				for (int i=1; i<=days; i++)
				{
					StockDayData sdd=(StockDayData)totalStockList.get(curDateNo-i);
					pastStockList.add(sdd);
				}
			}
			
			return pastStockList;
			
	 }
	 
	 public static String formatStringLength(String inputStr, int finalLength)
	 {
		 
		 
		 if (inputStr!=null)
		 {
//			 inputStr=inputStr.trim().replace(" ", "");
			 
			 int spaceLength=finalLength-inputStr.trim().length();
			 
			 for (int i=0; i<spaceLength; i++)
			 {
				 inputStr=inputStr+" ";
			 }
		 }
		 
		 return inputStr;
		 
	 }

	 
	 public static String formatStockNameLength(String stockname, int finalLength)
	 {
		 
		 
		 if (stockname!=null)
		 {
			 stockname=stockname.replace(" ", "");
			 if (stockname.length()==5)
			 {
				 stockname=stockname.substring(0,3)+"的"+stockname.substring(3);
			 }
//			 inputStr=inputStr.trim().replace(" ", "");
			 
			 int spaceLength=finalLength-stockname.trim().length();
			 
			 for (int i=0; i<spaceLength; i++)
			 {
				 stockname=stockname+" ";
			 }
		 }
		 
		 return stockname;
		 
	 }
	 
	 
	 public static double getReferenceProfit(String stockCode, String codeType, String startDate, String endDate)
	 {
		 double profit=0;
		 
		 String stockAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull";
		 String stockFileFolder=stockAllDataFull+"\\all\\"+codeType;  // 根据research code类型选择不同的数据目录, day/minute1/minute30/minute60
			
		 String stockfilename="";
		 if (codeType.startsWith("minute"))
		 {
		    	stockfilename="minute"+stockCode;
		 }
		 else if (codeType.startsWith("day"))
		 {
			    stockfilename="day"+stockCode;
		 }
		 else if (codeType.startsWith("index"))
		 {
			    stockfilename="index"+stockCode;
		 }
		 else if (codeType.startsWith("fund"))
		 {
			    stockfilename="fund"+stockCode;
		 }
				
		 List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
		 
		 StockDayData buySDD=CommonTool.getStockDayDataExisted(stockDataList, startDate);
		 StockDayData saleSDD=CommonTool.getStockDayDataExisted(stockDataList, endDate);
		 
		 profit=CommonTool.calculateTransactionProfit(buySDD, saleSDD);
		 
		 return profit;
		 
	 }
	 
	 
	 public static String getFundCompany(String line)
	 {
		 String fundCompany=line.substring(0,2); // 默认取前两个字为基金公司名称
		 
		 List fundCompanyList=new ArrayList();  // 基金公司名称列表
		 fundCompanyList.add("易方达");
		 fundCompanyList.add("汇添富");
		 fundCompanyList.add("海富通");
		 fundCompanyList.add("前海开源");
		 fundCompanyList.add("上投摩根");
		 
		 for (int i=0; i<fundCompanyList.size(); i++)
		 {
			 
			 // 如果列表中查到有此基金公司名称，则优先用列表中的
			 String companyName=fundCompanyList.get(i).toString();  
			 if (line.startsWith(companyName))
			 {
				 fundCompany=companyName;
				 break;
			 }
		 }
		 
		 return fundCompany;
		 
	 }
	 
	 
}
