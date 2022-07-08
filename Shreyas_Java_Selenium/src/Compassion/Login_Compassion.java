package Compassion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Compassion 
{
	WebDriver driver ;
	
	@BeforeTest()
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://services.compassionuk.org/sef/");	
	}
		
	@Test()
	public void test() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("GC_2");					//username
		Thread.sleep(1000);
		
		driver.findElement(By.id("password")).sendKeys("G33con0404");			//password
		Thread.sleep(1000);
		
		driver.findElement(By.id("login")).click();								//click "LOGIN" button
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@onclick='logout()']")).click();	//click "Logout"
		Thread.sleep(5000);
		
		System.out.println("'\n'+*** LOGOUT SUCCESSFULLY ***"+'\n');
	}
	
	@AfterTest()
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}