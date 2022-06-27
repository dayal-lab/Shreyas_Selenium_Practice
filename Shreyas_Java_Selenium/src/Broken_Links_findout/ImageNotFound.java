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
		driver.get("https://www.amazon.in/ref=nav_logo");
	}
	
	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException
	{
		List <WebElement> list = driver.findElements(By.tagName("img"));			//take tagname "a" , bcz main URL's href stores into tag "img"
		
		for(int j=0; j<list.size(); j++) 											//for loop to continuously check all URL till List's size is less than "0"
		{
	       WebElement e = list.get(j); 												//get data captured by"j"
	       String url = e.getAttribute("src");											 //take attribute "href" by creating object "url"
		
		if (url==null || url.isEmpty()  || url.isBlank())							//if URL is null or emoty or blank than following class or id or title or other take and print that
		{
			String cls = e.getAttribute("class");
			System.out.println("*********************************** Not found URL of image : *********************************"+cls+ '\n');
		}
		else
		try
		{
			System.out.println("Found URL of image : "+url+ '\n');
		}
		
		catch(Exception ex)
		{
		 System.out.println(ex.getMessage());
   		 ex.printStackTrace();
   		 System.out.println(ex.getLocalizedMessage());
		}
	}
		System.out.println("TOTAL"+list.size()+" IMAGE URL CHECKING COMPLETED.");
}

	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);	
		driver.quit();		
	}	
}