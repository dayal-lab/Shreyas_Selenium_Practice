package Compassion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Compassion 
{
	WebDriver driver ;
	
	@BeforeTest()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "e:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cukdev.co.uk/loggedinpop/");
	}
	
	
	@Test()
	public void test() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("Shreyas");
		Thread.sleep(1000);
		
		driver.findElement(By.id("password")).sendKeys("Compassion");
		Thread.sleep(1000);
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		
	}
	
	
	@AfterTest()
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
