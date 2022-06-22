package Broken_Links_findout;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageNotFound 
{
	WebDriver driver;
	
	
	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		driver = new ChromeDriver(options);
		driver.get("https://findusonweb.co.uk/view_companies");
	
	}
	
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
	
		//take tagname "a" , bcz main URL's href stores into tag "img"
		List <WebElement> list = driver.findElements(By.tagName("img"));
		
		//for loop to continuously check all URL till List's size is less than "0"
		for(int j=0; j<list.size(); j++) 
		{
	         WebElement e = list.get(j); //get data captured by"j"
		
	    //take attribute "href" by creating object "url"
		String url = e.getAttribute("src");
		
		
		//if URL is null or emoty or blank than following class or id or title or other take and print that
		if (url==null || url.isEmpty()  || url.isBlank())
		{
			
			String cls = e.getAttribute("class");
			System.out.println("Not found URL of image : "+cls+ '\n');
			
       	}
		else
			try{
				
				System.out.println("Found URL of image : "+url+ '\n');
				
			}
		catch(Exception ex)
		{
			
			//if errors captured, then print it messages
   		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
   		 System.out.println(ex.getLocalizedMessage());
   		 System.out.println(ex.getClass());
		}
		
		
	}
		System.out.println('\n'+'\n');
		System.out.println("URL CHECKING COMPLETED");
}
	
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();		
	}	
}