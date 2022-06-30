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

public class ImageError_onlyMessageof_BrokenImageLoop 
{
	WebDriver driver;
	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/ref=nav_logo");		
	}
	
	@SuppressWarnings("null")
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
		try
		{
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
}
		catch(Exception ex)
		{
		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
   		 System.out.println(ex.getLocalizedMessage());
		}
	}

	@AfterTest
	public void quit() throws InterruptedException
	{
		System.out.println('\n'+"***** NO ANY BROKEN IMAGE ON THIS PAGE *****"+'\n');
		Thread.sleep(2000);	
		driver.quit();		
	}	
}
