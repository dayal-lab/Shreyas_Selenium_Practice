package Webpage_Loadtime;


	import java.io.IOException;
	import java.net.MalformedURLException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Mobile91_specificlink_time_check

	{
			WebDriver driver ;
		
			@BeforeTest
			public void setup()
			{
				System.setProperty("webdriver.chrome.driver","e:\\chromedriver93\\chromedriver.exe");
				driver = new ChromeDriver();
				

				
				long start = System.currentTimeMillis();
				driver.get("https://www.91mobiles.com/");
				driver.findElement(By.xpath("//a[contains(text(),'mobile dealers')]"));
				long finish = System.currentTimeMillis();
				long total_time = finish - start ;
				System.out.println("Total loadtime of webpage is :"+total_time);
			
			}
			
			
			
			@Test
			public void test() throws MalformedURLException, IOException
			{
			String source =driver.getPageSource();
			System.out.println("Page source is :" +source);
			
				
			}
			
		
		@AfterTest
		public void quit() throws InterruptedException
		{
			
			Thread.sleep(2000);
			driver.quit();
			
		}
		
	}

