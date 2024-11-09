package com.EpsonDoms2.PropertyFileLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import com.EpsonDoms2.GenericLibrary.FrameworkConstant;

/**
 *This Class Provides The Reusable Methods To Read And Write The Data To Property File
 *By Calling InBuild Methods
 *
 *
 *@author LENOVO
 **/

public class ReadPropertyFile implements FrameworkConstant{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static Properties pr;
	public String readData(String key) {
		 try {
		//1.Convert the physical file into java readable file
			fis=new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//2.Create object for properties
		pr=new Properties();
		//3.Load all keys/Data 
		try {
			pr.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//4.fetch data
		String data=pr.getProperty(key);
		return data;
		
	}
	
	public String writeData(String key,String value) {
		
		//1.Convert the physical file into java readable file
		try {
			fis=new FileInputStream("./src/test/resources/Data/commondata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//2.Create object for properties
		pr=new Properties();
		//3.Load all keys/Data 
		try {
			pr.load(fis);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		//4.Write the data
		pr.put(key, value);
		
		//5.Convert java readble file to physical file
		try {
			fos=new FileOutputStream("./src/test/resources/Data/commondata.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//6.Store the data
		try {
			pr.store(fos, "Latest key updated successfully");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		String data=pr.getProperty(key);
		return key;
		
		
		
	}
}
