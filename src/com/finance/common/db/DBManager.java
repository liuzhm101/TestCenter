package com.finance.common.db;

import java.sql.*;

public class DBManager {

	public static DBManager dbm;
	public Connection connection = null;
	
	
	// �ش�Ĭ�ϵ�connection	
	public Connection getDefaultConnection()
	{
		return connection;
	}
	
	// һ���Գ�ʼ��Ϊoracle connection���Ժ�Ĭ�ϻش���connection
	public void initDefaultConnection(Param_Oracle dbpo)
	{
		connection=getOracleConnection(dbpo);
	}
	
	// һ���Գ�ʼ��Ϊmysql connection���Ժ�Ĭ�ϻش���connection
	public void initDefaultConnection(Param_MySql dbpm)
	{
		connection=getMySqlConnection(dbpm);
	}
	
	// ��ʼ��oracle����
	public Connection getOracleConnection(Param_Oracle dbpo)
	{
		
		Connection con=null;
		
		String driver="oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:" + "thin:@scnzli:1521:stock";
        String user = "system";
        String password = "Sas123";
        
		try
	    {
			
			//����oracle��������
	        Class.forName(driver);	       
	       
	        con = DriverManager.getConnection(url, user, password); // ��ȡ����
	        
	        System.out.println("Successfully connected!");
	        
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }

		return con;
		
	}
	
	// ��ʼ��mysql����
	public Connection getMySqlConnection(Param_MySql dbpm)
	{
		
		Connection con=null;

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/stock";
        String user = "root";
        String password = "root";

        try {
        	
            //����mysql��������
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);  // ��ȡ����
            
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
