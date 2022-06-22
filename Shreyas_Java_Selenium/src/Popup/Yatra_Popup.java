package Popup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Yatra_Popup
{
WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://secure.yatra.com/social/common/yatra/signin.htm");
		
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver.findElement(By.id("fb-login-btn")).click();
		
		Set <String> s = driver.getWindowHandles(); 
		
		Iterator <String> it = s.iterator();
		
		String parent = it.next();
		String child  = it.next();
		
		
		// going into "Facebook" child1 popup window
		driver.switchTo().window(child);
		driver.manage().window().maximize();
		System.out.println("Child1 window's Title name	: " +driver.getTitle());
		Thread.sleep(5000);
		driver.close();
		
		//again back on "Parent" window
		driver.switchTo().window(parent);
		System.out.println("Parent window's Title name	: " +driver.getTitle());
		
		
	}

	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		
	}
}






















