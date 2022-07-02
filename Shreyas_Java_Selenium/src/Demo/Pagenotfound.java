package Demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/ref=nav_logo");
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println(e.getStackTrace());
	}
}


	@SuppressWarnings("null")
	@Test
	public void image_error() throws InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		try
		{
		System.out.println('\n'+"BROKEN IMAGE CHECKING STARTED......"+'\n');
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
	public void pagenotfound()
	{
		System.out.println('\n'+"WEBPAGE CHECKING STARTED......"+'\n');
		
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
	public void quit() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.quit();
	}	
}

	

