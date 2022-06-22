package PageFrame_Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFrame.Puma_POM;

public class Puma_Test 
{
	WebDriver driver; 
	
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//checking Home webpage's load time
		long start = System.currentTimeMillis();
		driver.get("https://in.puma.com/in/en/home");
		long finish = System.currentTimeMillis();
		long total = finish - start ;
		System.out.println("Total loadtime of home webpage is (msec)	:	"+total);
	}
	
	
	
	@Test
	public void test() throws InterruptedException
	{
		Puma_POM call = PageFactory.initElements(driver, Puma_POM.class);
		
		call.Men_module();		
		call.Running_shoes();
		
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("scrollBy(0,60000)");	//full scrolled down
		Thread.sleep(2000);
		
		call.Facebook();
		
		
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
	
	

}
