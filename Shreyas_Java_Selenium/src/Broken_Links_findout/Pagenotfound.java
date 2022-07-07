package Broken_Links_findout;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagenotfound 
{	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
	try
	{	
//		System.setOut(new PrintStream(new FileOutputStream("e:\\Demo_Output.txt")));
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://mybusinessdirectorylocal.com/");
		
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println(e.getStackTrace());
	}
}

	@Test
	public void JS_Console_Error() throws FileNotFoundException
	{
		
	System.out.println('\n'+"> CONSOLE ERRORS CHECKING STARTED......"+'\n');	
		
	LogEntries  logEntries = driver.manage().logs().get(LogType.BROWSER);
	for (LogEntry entry : logEntries)
		System.out.println(entry);
	
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	System.out.println("******** CHECKED CONSOLE ERRORS ON THIS LINK--->'" +driver.getCurrentUrl()+"' ********");
	System.out.println("-------------------------------------------------------------------------------------------------------------------------------"+'\n'+'\n');
	}
	
	
	@SuppressWarnings("null")
	@Test
	public void image_error() throws InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		try
		{
		System.out.println('\n'+"> BROKEN IMAGE CHECKING STARTED......");
		List <WebElement> list = driver.findElements(By.tagName("img"));			
		
		for(int j=0; j<list.size(); j++) 											
		{
	       WebElement e = list.get(j); 												
	       String url = e.getAttribute("src");											 
		
		if (!(url==null) || !url.isEmpty()  || !url.isBlank())							
		{
		}
		else
		{
			String tag	= e.getTagName();
			String id 	= e.getAttribute("id");
			String cls 	= e.getAttribute("class");
			String title= e.getAttribute("title");
			String href = e.getAttribute("href");
			System.out.println("******** BROKEN IMAGE URL *******"+url+'\n'+ "ID name URL	: "+id+'\n'+"Class Name URL	: "+cls+'\n'+"Title name URL	: "+title+'\n'+"href name URL	: "+href+'\n'+"Tag name URL	: "+tag+'\n')	;
		}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("******** Total "+list.size()+ " IMAGE URL CHECKED. NO ANY BROKEN IMAGE ON THIS LINK--->'" +driver.getCurrentUrl()+"' ********");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------"+'\n'+'\n');
		}
		catch(Exception ex)
		{
		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
		}
	}
	
	@Test
	public void pagenotfound() throws FileNotFoundException
	{   
		System.out.println('\n'+"> WEBPAGE CHECKING STARTED......");
		
		List <WebElement> list = driver.findElements(By.tagName("a"));					
		
		for(int j=0; j<list.size(); j++) 												
		{
	         WebElement e = list.get(j); 												
		
	    String url = e.getAttribute("href");											
		
		if (url==null || url.isEmpty()  || url.isBlank())								
		{
		}
		else
			
		try
		{
			URL link = new URL(url);
			HttpURLConnection http = (HttpURLConnection)link.openConnection();
			http.connect();
				
		if (http.getResponseCode()==400 )
		{
			System.out.println("************ BAD REQUEST ************** : " +url+'\n'+ "*Status code:"+http.getResponseCode()+'\n'+"*Response message:"  +http.getResponseMessage()+'\n');
		}
		if (http.getResponseCode()==404)
		{
			System.out.println("********** NOT FOUND LINK ************  :" +url+'\n'+ "*Status code:"+http.getResponseCode()+'\n'+"*Response message:"  +http.getResponseMessage()+'\n');
		}
		}

		catch(Exception ex)
		{
   		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
		}
	}
		System.out.println("----------> Total "+list.size()+ " WEBPAGE VISITED. CHECKING COMPLETED <-----------");
		
}
	
	@AfterTest
	public void quit() throws InterruptedException, FileNotFoundException 
	{
	  	Thread.sleep(2000);
		driver.quit();
	}	
}

	

