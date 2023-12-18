package com.finance.stock.gui;

import java.io.*;
import java.util.*;


public class PropertyManager implements Serializable { 

/** 定义一个静态的Properties变量 */ 

public Properties properties = new Properties(); 

/** 

 * 通过一个类似于类名的参数进行Property文件的初期化 

 * 比如现在有一个文件叫Message.properties， 它存放在 

 * ejb/util下面并且， 这个目录在运行的classpath下面 

 * 则in就为ejb.util.Message 

 * 

 */ 

public PropertyManager(String proFilePath) throws MissingResourceException { 

	
	ResourceBundle bundle=null;
	try
	{
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(proFilePath));  
		bundle = new PropertyResourceBundle(inputStream);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}


    Enumeration<String> keys = bundle.getKeys(); 

    Object key = null; 
    Object value = null;
    int count=0;

    while (keys.hasMoreElements()) { 

        key = keys.nextElement(); 
        value = bundle.getString(key.toString()); 
        properties.put(key, value); 

    }
    
	} 

	/** 
	
	 * 取得一个Property值 
	
	 */ 
	
	public String getProperty(String key) 
	{
		
		return properties.get(key).toString(); 
	} 
	
	/** 
	
	 * 设置一个Property值 
	
	 */ 
	
	public void setProperty(String key, String value) 
	{
		properties.put(key, value); 
	} 

	public Properties getAllProperties()
	{
		
		return properties;
	}
	
	public int getPropertiesSize()
	{
		
		return properties.size();
	}
	
	

} 
