package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng 
{

WebDriver driver;
	
	@BeforeTest 
	public void Setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("http://www.geecon.co.uk/dev/gap_v2/index.php/login/login");
			
	}
	
	
	@Test
	public void print() throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
		
		System.out.println("ENTERED USERNAME AND PASSWORD");
				
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
	}
	
	
	//when defined this "BeforeMethod, means it runs everytime before @Test method
	@BeforeMethod  
	public void shreyas()
	{
		System.out.println("SHREYAS");
	}
	
	
	
	//it runs everytime after @Test method
	@AfterMethod
	public void surname()
	{
		System.out.println("DAYAL");
	}
	
	@AfterTest
	public void quit()
	{
	driver.quit();
	}
	
	
	
	@BeforeSuite
	public void suit()
	{
		System.out.println("RUN SUIT FIRST");
	}
	
	
	 @AfterSuite
	public void quit_suit()
	{
		System.out.println("END SUIT");
	}
	
	
	
	
	
}
