package resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public ExcelUtilities() {
		// TODO Auto-generated constructor stub
	}
	
	static XSSFWorkbook workbook;
	public static void readExcelFile(String path) throws Exception
	{
		
		try {
			FileInputStream file = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(file);
		}
		catch(Exception e)
		{
			System.out.println("Error in reading excel file.");
		}
	}
	
	public static String readData( String sheetName,String columnname,int  rowindex)
	{		
        int countofsheet = workbook.getNumberOfSheets();
        ArrayList<String> sheetname=new ArrayList<String>();
        for(int i=0;i<countofsheet;i++)
        {
    	   sheetname.add(workbook.getSheetName(i));
    	}
       
       if(sheetname.contains(sheetName))
       {
    	  XSSFSheet sheet= workbook.getSheet(sheetName);
    	  XSSFRow row= sheet.getRow(0);
    	  
    	  Map<String,Integer> headings=new HashMap<String,Integer>();
    	  ArrayList<String> headingarray=new ArrayList<String>();
    	  for(int i=0;i<row.getLastCellNum();i++)
    	  {
    		  headings.put(row.getCell(i).getStringCellValue().toString(), i);
    		  headingarray.add(row.getCell(i).getStringCellValue().toString());
    		  
    	  }
    	  if(headingarray.contains(columnname))
    	  {
    		  XSSFRow mainrow=sheet.getRow(rowindex);
    		  String actualdata= mainrow.getCell(headings.get(columnname)).getStringCellValue().toString();
    		  return actualdata;
    	  }
    	  else {
    		  System.out.println("Column Name not found");
    		  return "";
    	  }
    	  
       }
       else {
    	   System.out.println("Sheet Name not fount");
    	   return "";
       }
        
	}
	
	public static ArrayList<String> getColumn(String sheetName,String columnname)
	{
		ArrayList<String> columncontent=new ArrayList<String>();
		int countofsheet = workbook.getNumberOfSheets();
        ArrayList<String> sheetname=new ArrayList<String>();
        for(int i=0;i<countofsheet;i++)
        {
    	   sheetname.add(workbook.getSheetName(i));
    	}
       
       if(sheetname.contains(sheetName))
       {
    	  XSSFSheet sheet= workbook.getSheet(sheetName);
    	  XSSFRow row= sheet.getRow(0);
    	  
    	  Map<String,Integer> headings=new HashMap<String,Integer>();
    	  ArrayList<String> headingarray=new ArrayList<String>();
    	  for(int i=0;i<row.getLastCellNum();i++)
    	  {
    		  headings.put(row.getCell(i).getStringCellValue().toString(), i);
    		  headingarray.add(row.getCell(i).getStringCellValue().toString());
    		  
    	  }
    	  if(headingarray.contains(columnname))
    	  {
    		  for(int i=0;i<row.getLastCellNum();i++)
    		  {
	    		  XSSFRow mainrow=sheet.getRow(i);
	    		  String actualdata= mainrow.getCell(headings.get(columnname)).getStringCellValue().toString();
	    		  columncontent.add(actualdata);
    		  }
    	  }
    	  else {
    		  System.out.println("Column Name not found");
    		  
    	  }
       }
       else {
    	   System.out.println("Sheet Name is invalid.");
       }
		
		
		return columncontent;
	}
	
	
	public static ArrayList<String> getRow(String sheetName,int indexOfRow)
	{
		 ArrayList<String> rowcontent=new ArrayList<String>();  
		 int countofsheet = workbook.getNumberOfSheets();
	     ArrayList<String> sheetname=new ArrayList<String>();
	     for(int i=0;i<countofsheet;i++)
	     {
	    	   sheetname.add(workbook.getSheetName(i));
	     }
	     if(sheetname.contains(sheetName))
	     { 
	    	 try {
		    	  XSSFSheet sheet= workbook.getSheet(sheetName);
		    	  XSSFRow row= sheet.getRow(indexOfRow);
		    	  for(int i=0;i<row.getLastCellNum();i++)
		    	  {
		    		  rowcontent.add(row.getCell(i).getStringCellValue().toString());
		    	  }
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 System.out.println("Row Index is invalid.");
	    	 }
	      }
	     else {
	    	 System.out.println("Sheet name is not valid.");
	     }
	     return rowcontent;
		
	}
	
	
	
	
}
