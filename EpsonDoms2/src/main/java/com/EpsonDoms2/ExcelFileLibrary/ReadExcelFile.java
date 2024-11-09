package com.EpsonDoms2.ExcelFileLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.EpsonDoms2.GenericLibrary.FrameworkConstant;


/**
* This Class Provides The Reusable Method To Read The Data To Excel File
* 
* 
* @author LENOVO
* */
public class ReadExcelFile implements FrameworkConstant{
 public FileInputStream fis=null;
 public Workbook wb=null;
 public FileOutputStream fos=null;
 public String readSingleData(String sheetname, int row, int cell)
 {
  //1.Convert the physical File into Java Readable File
  try {
    fis = new FileInputStream(excelpath);
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  //2.Create the Workbook using WbookFactory
  try {
    wb = WorkbookFactory.create(fis);
  } catch (EncryptedDocumentException | IOException e) {
   e.printStackTrace();
  }
  //3.Using Workbook Get the Sheet Control
  //4.Using Sheet Get the Row Control
  //5.Using Row Get the Column Control
  //6.Using Column Get the Cell Data
  String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
  return data;
 }
	
 public void readMultipleData(String sheetname)
 {
  //1.Convert the physical File into Java Readable File
    try {
      fis = new FileInputStream(excelpath);
    } catch (FileNotFoundException e) {
     e.printStackTrace();
    }
    //2.Create the Workbook using WbookFactory
    try {
      wb = WorkbookFactory.create(fis);
    } catch (EncryptedDocumentException | IOException e) {
     e.printStackTrace();
    }
    //3.Using Workbook Get the Sheet Control
    //4.Using Sheet Get the Row Control
    //5.Using Row Get the Column Control
    //6.Using Column Get the Cell Data
    
    int rowcount = wb.getSheet(sheetname).getLastRowNum();
    for(int i =1;i<rowcount;i++)
    {
     String data = wb.getSheet(sheetname).getRow(i).getCell(1).getStringCellValue();
    }
    
    
    
 }
	
 public void writeData(String sheetname,int row,int cell,String data)
 {
  //1.Convert the physical File into Java Readable File
    try {
      fis = new FileInputStream(excelpath);
    } catch (FileNotFoundException e) {
     e.printStackTrace();
    }
    //2.Create the Workbook using WbookFactory
    try {
      wb = WorkbookFactory.create(fis);
    } catch (EncryptedDocumentException | IOException e) {
     e.printStackTrace();
    }
    //3.Using Workbook Get the Sheet Control
    //4.Using Sheet Get the Row Control
    //5.Using Row create the Column
    //6.Using Column set the Cell Data
    wb.getSheet(sheetname).getRow(0).createCell(0).setCellValue("Data we will pass");
    
    //7.Convert Java Readable file into Physical file
     try {
     fos = new FileOutputStream(excelpath);
    } catch (FileNotFoundException e) {
     e.printStackTrace();
    }
     
    //8.Write the data
    try {
     wb.write(fos);
    } catch (IOException e) {
     e.printStackTrace();
    }
    
    //9.Close the WorkBook 
    try {
     wb.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
 }

}