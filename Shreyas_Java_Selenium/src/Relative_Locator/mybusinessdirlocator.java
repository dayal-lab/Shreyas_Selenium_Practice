package Relative_Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mybusinessdirlocator
{
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://mybusinessdirectorylocal.com/members/index.php");
	}

	@Test
	public void test()
	{
		driver.findElement(By.id("user_login")).sendKeys("shreyas");		//username entered 
		
		//In this, when see on website..."password" field is below "username " field.
		//If we dont get path of "password" field...or we have to quicky want to take nearest path of selected "username" path, then can use "RelativeLocator.with()" method by using "By" annotation.
		
		//If we took path of "password" and want to take "username" field's path which is nearer to password field i.e it is above "password" field, then write in place of "below" , write "above"
		//can write "leftTo" , "rightTo"as per want path.
		By password = RelativeLocator.with (By.tagName("input")).below(By.id("user_login"));
		
		driver.findElement(password).sendKeys("abc");
	}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}


