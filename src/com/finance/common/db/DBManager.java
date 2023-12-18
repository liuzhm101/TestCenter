package com.finance.common.db;

import java.sql.*;

public class DBManager {

	public static DBManager dbm;
	public Connection connection = null;
	
	
	// 回传默认的connection	
	public Connection getDefaultConnection()
	{
		return connection;
	}
	
	// 一次性初始化为oracle connection，以后默认回传此connection
	public void initDefaultConnection(Param_Oracle dbpo)
	{
		connection=getOracleConnection(dbpo);
	}
	
	// 一次性初始化为mysql connection，以后默认回传此connection
	public void initDefaultConnection(Param_MySql dbpm)
	{
		connection=getMySqlConnection(dbpm);
	}
	
	// 初始化oracle连接
	public Connection getOracleConnection(Param_Oracle dbpo)
	{
		
		Connection con=null;
		
		String driver="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:" + "thin:@scnzli:1521:stock";
        String user = "system";
        String password = "Sas123";
        
		try
	    {
			
			//加载oracle驱动程序
	        Class.forName(driver);	       
	       
	        con = DriverManager.getConnection(url, user, password); // 获取连接
	        
	        System.out.println("Successfully connected!");
	        
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }

		return con;
		
	}
	
	// 初始化mysql连接
	public Connection getMySqlConnection(Param_MySql dbpm)
	{
		
		Connection con=null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stock";
        String user = "root";
        String password = "root";

        try {
        	
            //加载mysql驱动程序
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);  // 获取连接
            
            System.out.println("Successfully connected!");
            
        }
        catch (Exception e)
	    {
	        e.printStackTrace();	        
	    }

		
		return con;
		
	}
	
	
	public ResultSet executeSQL(String sqlStr)
	{
		       
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuffer sql = new StringBuffer(512);        
        sql.append(sqlStr);
        
        try {
           
            statement = connection.prepareStatement(sql.toString());
            resultSet = statement.executeQuery();	         	         
            	                  
            
        } catch(SQLException sqle) {	         
           
        	sqle.printStackTrace();
           
        } 
        		        	 	            
        return resultSet;   	        			
		
	}
	
	
	public static DBManager getInstance()
	{
		if (dbm==null)
		{
			dbm=new DBManager();
		}
		return dbm;
				
	}
	
}
