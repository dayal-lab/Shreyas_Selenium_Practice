package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class multi_URL_pagenotfound 
{
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
	}	

	@SuppressWarnings("null")
	@Test
	public void image_error() throws InterruptedException, IOException
	{
	
	
		 File file=new File("e:\\URL.xlsx"); 
		
		 FileInputStream inputstream=new FileInputStream(file);
		  
		  @SuppressWarnings("resource")
		  XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		  
		  XSSFSheet sheet=wb.getSheet("Test");
			
		  XSSFRow row	=	null;
		  String url 	= 	null;					
		
		for (int i=1; i<=sheet.getLastRowNum();i++)
		{
		 row=sheet.getRow(i);
		 url = row.getCell(0).getStringCellValue();
		 String excel_url = url.toString();
		 driver.get(excel_url);

			 
			  
//Image Error-
		try
		{
		System.out.println('\n'+"*** BROKEN IMAGE CHECKING STARTED......"+'\n');
		
		List <WebElement> list = driver.findElements(By.tagName("img"));			
		
		for(int j=0; j<list.size(); j++) 											
		{
	       WebElement e = list.get(j); 												
	       String url1 = e.getAttribute("src");											 
		
		if (!(url1==null) || !(url1.isEmpty()  || !url1.isBlank()))						
		{
		}
		else
		{
			String tag	= e.getTagName();
			String id 	= e.getAttribute("id");
			String cls 	= e.getAttribute("class");
			String title= e.getAttribute("title");
			String href = e.getAttribute("href");
			System.out.println("******** BROKEN IMAGE URL *******"+url1+'\n'+ "ID name URL	: "+id+'\n'+"Class Name URL	: "+cls+'\n'+"Title name URL	: "+title+'\n'+"href name URL	: "+href+'\n'+"Tag name URL	: "+tag+'\n')	;
		}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("******** Total "+list.size()+ " IMAGE URL CHECKED. NO ANY BROKEN IMAGE ON THIS LINK--->'" +driver.getCurrentUrl()+"' ********");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------"+'\n'+'\n');
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
		
		
		
		
//404 Page Not Found-
		System.out.println('\n'+"*** WEBPAGE CHECKING STARTED......"+'\n');
		try
		{
		List <WebElement> list2 = driver.findElements(By.tagName("a"));					
		
		for(int j=0; j<list2.size(); j++) 												
		{
	         WebElement e2 = list2.get(j); 												
		
	    String url2 = e2.getAttribute("href");											
		
		if (url2==null || url2.isEmpty()  || url2.isBlank())								
		{	 	  
       	}
		else
		{
			URL link = new URL(url2);
			HttpURLConnection http = (HttpURLConnection)link.openConnection();
			http.connect();
				
		if (http.getResponseCode()==400 )
		{
			System.out.println("************ BAD REQUEST ************** : " +url2+'\n'+ "*Status code:"+http.getResponseCode()+'\n'+"*Response message:"  +http.getResponseMessage()+'\n');
			
		}
		if (http.getResponseCode()==404)
		{
			System.out.println("********** NOT FOUND LINK ************  :" +url2+'\n'+ "*Status code:"+http.getResponseCode()+'\n'+"*Response message:"  +http.getResponseMessage()+'\n');
		}
		}
		}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
		System.out.println("----------------------------------------");
		System.out.println("******** URL CHECKING COMPLETED ********");
		System.out.println("----------------------------------------"+'\n'+'\n');
		}
	}
			
	@AfterTest
	public void quit() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.quit();
	}	
}
