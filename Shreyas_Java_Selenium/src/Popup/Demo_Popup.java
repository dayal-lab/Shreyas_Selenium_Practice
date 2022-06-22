package Popup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_Popup 

{
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void test() throws InterruptedException
	{
//click on "New Tab" button
		driver.findElement(By.id("tabButton")).click();
		
		// Handling child window by creating "Set" table's object
		Set <String> s = driver.getWindowHandles();
		
		Iterator <String> it = s.iterator();
		
		String parent = it.next();
		String child  = it.next();
		
		// switching iterator on child window
		driver.switchTo().window(child);
		System.out.println("Child window's URL :" +driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.close();
		
		// switching iterator on parent window again
		driver.switchTo().window(parent);
		System.out.println("Parent window's title name :" +driver.getTitle());
		Thread.sleep(3000);
}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
