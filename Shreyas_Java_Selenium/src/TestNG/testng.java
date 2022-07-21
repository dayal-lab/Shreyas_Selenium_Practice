package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
		System.out.println("BeforeTest");
	}
	
	@Test
	public void print() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
		
		System.out.println('\n'+"Actual @Test2 runs"+'\n');
				
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
	}
	
	
	//if above "print()" passes then and only this method run, otherwise, if first failed then this aldo fails bcz it is dependent on above.
	@Test (dependsOnMethods = {"print"})	
	public void print2() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
		
		System.out.println('\n'+"Actual @Test2 runs"+'\n');
				
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("GSPLadmin");
		Thread.sleep(2000);
	}
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("AfterClass");
	}
	
	
	//when defined this "BeforeMethod, means it runs everytime before @Test method
	@BeforeMethod  
	public void shreyas()
	{
		System.out.println("BeforeMethod");
	}
	
	
	
	//it runs everytime after @Test method
	@AfterMethod
	public void surname()
	{
		System.out.println("AfterMethod");
	}
	
	@AfterTest
	public void quit()
	{
	System.out.println("AfterTest");
	driver.quit();
	}
	
	
	
	@BeforeSuite
	public void suit()
	{
		System.out.println("************************* Before Suit ******************************");
	}
	
	
	 @AfterSuite
	public void quit_suit()
	{
		System.out.println("************************* After Suit ***************************** ");
	}
	
	
	
	
	
}
