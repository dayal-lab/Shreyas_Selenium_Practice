package Excel_Eclipse_Read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_From_Excel 
{
	public static void main (String args[]) throws IOException
	{
	//CHECK ALL DATA IN :E\\Test.xlsx	
	
	//Create an object of File class to open xlsx file
    File file =    new File("e:\\Test.xlsx");
    
    //Create an object of FileInputStream class to read excel file
    FileInputStream inputStream = new FileInputStream(file);
    
    //Creating workbook instance that refers to .xls file
    XSSFWorkbook wb=new XSSFWorkbook(inputStream);
    
    //Creating a Sheet object using the sheet Name
    XSSFSheet sheet=wb.getSheet("TestData");
    
    //Create a row object to retrieve from row vertically from Test excel
    XSSFRow row0=sheet.getRow(0);	//get data from 1st sheet "TestData" which is "username" which is at row "0" vertically in "Test" file
    XSSFRow row1=sheet.getRow(1);	//get data "abc"  which is at row "1" vertically just below "username" header
    
    //Create a cell object to retreive cells of horizontal
    XSSFCell cell0=row0.getCell(0);	//get data from file which is at 1st (i.e 1st cell starts from 1st location , so 1st horizontally is "Password" see in file horizontally 
    XSSFCell cell1=row1.getCell(1);	//get data from file which is at 1st (i.e 1st cell starts from 1st location , so 1st horizontally is "Password" see in file horizontally 
    
    //Get the address in a variable
    String address0= cell0.getStringCellValue();
   String address1= cell1.getStringCellValue();
    
    //Printing the address
    System.out.println (address0);
    System.out.println (address1);
    
    wb.close();
}

}