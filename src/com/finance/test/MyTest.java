package com.finance.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.finance.common.db.DBManager;
import com.finance.common.db.Param_MySql;

public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyTest mt=new MyTest();		
		
//		mt.testConnectToDB();
		mt.javaConnectToSASDataSet();
		
	}
	
	public void testConnectToDB()
	{
		
		try
		{
//			Param_Oracle dbpo=new Param_Oracle();
//			DBManager.getInstance().initDefaultConnection(dbpo);
			
			for (int i=0; i<10; i++)
				System.out.println(i);
			
			Param_MySql dbpm=new Param_MySql();
			DBManager.getInstance().initDefaultConnection(dbpm);			
			
			ResultSet rs=DBManager.getInstance().executeSQL("select * from stock600001");
			while (rs.next())
			{			
				for (int i=1; i<20; i++)
				{
					System.out.print(rs.getString(i)+"   ");
				}
				System.out.println("");
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void javaConnectToSASDataSet()
	{
				
		Connection con = null;
		Statement stmt = null;
		try{
		 Class.forName("com.sas.rio.MVADriver");
		 String url = "jdbc:sasiom://localhost:8591";

		 java.util.Properties p = new java.util.Properties();
		 p.setProperty("librefs", "stocktal 'C:\\Users\\lzm\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull\\totalresult\\total(3连涨大于15无前置条件_7.14)';");
		 p.setProperty("username", "sasdemo");
		 p.setProperty("password", "Sas123");
		 
		 con = DriverManager.getConnection(url, p);
		 stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT * from stocktal.stocktotalselectalldata_300np");
		 
		 int columnCount = rs.getMetaData().getColumnCount();
		 		
		 for (int i = 1; i <= columnCount; i++) {
			 System.out.println(rs.getMetaData().getColumnName(i));
		 }
		 
		 while (rs.next()) {
		 
			  for (int i = 1; i <= columnCount; i++) {
				  System.out.print(rs.getString(i));
			  }		 
			  System.out.println("");
		 }
		 
		}catch( Exception e ){
		 e.printStackTrace();
		}
		finally{
			
			try
			{
			 if( null != stmt ){
			  stmt.close();
			 }
			 if( null != con ){
			  con.close();
			 }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}		
		
		
	}

}
