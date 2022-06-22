package PageFrame_Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFrame.Dell_POM;

public class Dell_Test 
{
WebDriver driver;
	
	@BeforeTest
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver","e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-in/");	
	}
	
	@Test
	public void test() throws InterruptedException
	{
		Dell_POM delltest = PageFactory.initElements(driver, Dell_POM.class); //created class "delltest" of "Dell" which is imported class
		
		delltest.Deal();
		
		delltest.Desktop_Deal();
		
		//Moving page up-down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,700)");	//scrolled page down
		Thread.sleep(2000);
		
		
		
	}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
