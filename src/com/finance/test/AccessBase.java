package com.finance.test;

import java.sql.*;


public class AccessBase
{
	
	
  public static void main(String argv[])
  {
    Connection connection;
    int i;
    Statement statement;
    String queryString = "SELECT * FROM mySASLib.class";
    ResultSet result;
    String name;

    try{
      //CONNECT TO THE SERVER BY USING A JDBC URL
      Class.forName("com.sas.rio.MVADriver");
      String user = "sasdemo";
      String password = "Password1";
      connection = DriverManager.getConnection(
         "jdbc:sasiom://localhost:8591?" +
         "librefs=mySasLib 'c:\\work'",
          user, password);

      //ACCESS DATA
      statement = connection.createStatement();
      result = statement.executeQuery(queryString);
      while (result.next()) {
        name = result.getString(1);
        System.out.println(" " + name);
      }
      statement.close();
      connection.close();
    }
    catch(Exception e){
      System.out.println("error " + e);
    }
  }
}
