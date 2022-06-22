package Zoom_In_Out;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Jiomart_By_Javascript 
{
	WebDriver driver;
	
	@BeforeTest
	public void setuup()
	{
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public void test() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//zoomed in by 50%
		js.executeScript("document.body.style.zoom='50%'"); //shortcut "dbsz- document.body.style.zoom"
		Thread.sleep(2000);
		
		//zoomed by 200%
		js.executeScript("document.body.style.zoom='200%'");
		Thread.sleep(2000);
		
		//zommed to normal 100% 
		js.executeScript("document.body.style.zoom='100%'");
		Thread.sleep(2000);
	}
	
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
}
