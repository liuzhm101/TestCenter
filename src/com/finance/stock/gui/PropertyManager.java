package com.finance.stock.gui;

import java.io.*;
import java.util.*;


public class PropertyManager implements Serializable { 

/** ����һ����̬��Properties���� */ 

public Properties properties = new Properties(); 

/** 

 * ͨ��һ�������������Ĳ�������Property�ļ��ĳ��ڻ� 

 * ����������һ���ļ���Message.properties�� ������� 

 * ejb/util���沢�ң� ���Ŀ¼�����е�classpath���� 

 * ��in��Ϊejb.util.Message 

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
	
	 * ȡ��һ��Propertyֵ 
	
	 */ 
	
	public String getProperty(String key) 
	{
		
		return properties.get(key).toString(); 
	} 
	
	/** 
	
	 * ����һ��Propertyֵ 
	
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
